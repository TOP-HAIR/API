package school.sptech.projetotophair.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetotophair.domain.agendaservico.AgendaServico;
import school.sptech.projetotophair.service.AgendaServicoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agendas-servicos")
public class AgendaServicoController {

    @Autowired
    private AgendaServicoService agendaServicoService;

    @PostMapping
    public ResponseEntity<AgendaServico> cadastrar(@RequestBody AgendaServico agendaServico){
        AgendaServico agendaServicoCadastrado = agendaServicoService.cadastrarServico(agendaServico);
        return ResponseEntity.status(201).body(agendaServicoCadastrado);
    }

    @GetMapping
    public ResponseEntity<List<AgendaServico>> listarTodos() {
        List<AgendaServico> servicos = agendaServicoService.listarTodosServicos();
        return ResponseEntity.ok(servicos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendaServico> atualizar(
            @PathVariable Long id,
            @RequestBody AgendaServico agendaServico
    ) {
        Optional<AgendaServico> servicoAtualizado = agendaServicoService.atualizarServico(id, agendaServico);
        return ResponseEntity.status(200).body(servicoAtualizado.get());
    }

    @DeleteMapping("/{idServico}")
    public ResponseEntity<Void> deletarServico(@PathVariable Long idServico) {
        agendaServicoService.deletarServico(idServico);
        return ResponseEntity.ok().build();
    }
}
