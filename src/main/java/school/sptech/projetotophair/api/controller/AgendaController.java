package school.sptech.projetotophair.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetotophair.api.pilha.PilhaObj;
import school.sptech.projetotophair.domain.agenda.Agenda;
import school.sptech.projetotophair.domain.usuario.Usuario;
import school.sptech.projetotophair.domain.usuario.repository.UsuarioRepository;
import school.sptech.projetotophair.service.AgendaService;
import school.sptech.projetotophair.service.dto.agenda.AgendaDto;
import school.sptech.projetotophair.service.dto.agenda.AgendaEmpresaVinculadaDto;
import school.sptech.projetotophair.service.dto.agenda.UltimosAgendamentosDto;
import school.sptech.projetotophair.service.dto.agenda.mapper.AgendaMapper;
import school.sptech.projetotophair.service.dto.usuario.UsuarioAgendaResponseDto;
import school.sptech.projetotophair.service.dto.usuario.mapper.UsuarioMapper;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agendas")
public class AgendaController {

    @Autowired
    private UsuarioRepository u;

    @Autowired
    private AgendaService agendaService;

    @PostMapping
    public ResponseEntity<AgendaDto> cadastrar(@RequestBody Agenda agenda) {
        agenda.setData(LocalDate.now());
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm");
        agenda.setHora(LocalTime.now().format(formato));
        Agenda agendaCadastrada = agendaService.cadastrarAgenda(agenda);
        AgendaDto agendaDto = AgendaMapper.toAgendaDto(agendaCadastrada);
        return ResponseEntity.ok(agendaDto);
    }

    @PutMapping("/vincular-empresa/{idAgenda}/{idEmpresa}")
    public ResponseEntity<AgendaEmpresaVinculadaDto> vincularEmpresa(@PathVariable Long idAgenda, @PathVariable Long idEmpresa){
        Agenda agenda = agendaService.vincularEmpresa(idAgenda, idEmpresa);
        AgendaEmpresaVinculadaDto agendaEmpresaVinculadaDto = AgendaMapper.toAgendaEmpresaVinculadaDto(agenda);
        return ResponseEntity.ok(agendaEmpresaVinculadaDto);
    }

    @PutMapping("/vincular-usuario/{idAgenda}/{idUsuario}")
    public ResponseEntity<UsuarioAgendaResponseDto> vincularUsuario(@PathVariable Long idAgenda, @PathVariable Long idUsuario){
        Usuario usuario = agendaService.vincularUsuario(idAgenda, idUsuario);
        UsuarioAgendaResponseDto usuarioAgendaResponseDto = UsuarioMapper.toUsuarioAgendaResponseDto(usuario);
        return ResponseEntity.ok(usuarioAgendaResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Agenda>> listar(@PathVariable Long id) {
        Optional<Agenda> agenda = agendaService.buscarAgendaPorId(id);
        return ResponseEntity.ok(agenda);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<AgendaDto>> listarPorUsuario(@PathVariable Long idUsuario){
        List<Agenda> agendas = agendaService.listarAgendasPorUsuario(idUsuario);
        List<AgendaDto> dtos = new ArrayList<>();
        for (Agenda agendaDaVez: agendas) {
            dtos.add(AgendaMapper.toAgendaDto(agendaDaVez));
        }
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/empresa/{idEmpresa}")
    public ResponseEntity<List<AgendaDto>> listarPorEmpresa(@PathVariable Long idEmpresa){
        List<Agenda> agendas = agendaService.listarAgendasPorEmpresa(idEmpresa);
        List<AgendaDto> dtos = new ArrayList<>();
        for (Agenda agendaDaVez: agendas) {
            dtos.add(AgendaMapper.toAgendaDto(agendaDaVez));
        }
        return ResponseEntity.ok(dtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agenda> atualizar(
            @PathVariable Long id,
            @RequestBody Agenda agenda
    ) {
        Optional<Agenda> agendaAtualizada = agendaService.atualizarAgenda(id, agenda);
            return ResponseEntity.status(200).body(agendaAtualizada.get());
    }

//    @GetMapping("/ultimos-agendamentos/{id}")
//    public ResponseEntity<UltimosAgendamentosDto> ultimosAgendamentos(@PathVariable Long id){
//        Optional<Usuario> all = u.findById(id);
//
//        if (all.isEmpty()) {
//            return ResponseEntity.notFound().build();
//        }
//
//        UltimosAgendamentosDto dto = UltimosAgendamentosMapper.toDto(all.get());
//
//        return ResponseEntity.ok(dto);
//    }

    @GetMapping("/ultimos-agendamentos")
    public ResponseEntity<List<UltimosAgendamentosDto>> ultimosAgendamentos() {
        // Assuming you have a service instance called agendaService
        PilhaObj<Agenda> ultimosAgendamentos = agendaService.getUltimosAgendamentos();

        // Convert Agenda objects to UltimosAgendamentosDto objects using the mapper
        List<UltimosAgendamentosDto> dtos = new ArrayList<>();
        while (!ultimosAgendamentos.isEmpty()) {
            Agenda agenda = ultimosAgendamentos.pop();
            UltimosAgendamentosDto dto = AgendaMapper.toDto(agenda);
            dtos.add(dto);
        }

        return ResponseEntity.ok(dtos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAgenda(@PathVariable Long id) {
        agendaService.deletarAgenda(id);
        return ResponseEntity.noContent().build();
    }
}
