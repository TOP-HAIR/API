package school.sptech.projetotophair.api.controller;


import io.jsonwebtoken.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetotophair.service.Integraveis.csv.ArquivoCsv;
import school.sptech.projetotophair.service.Integraveis.lista.ListaObj;
import school.sptech.projetotophair.domain.servico.Servico;
import school.sptech.projetotophair.service.ServicoService;
import school.sptech.projetotophair.service.dto.servico.ServicoDto;
import school.sptech.projetotophair.service.dto.servico.ServicoEmpresaVinculadaDto;
import school.sptech.projetotophair.service.dto.servico.mapper.ServicoMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public ResponseEntity<Servico> cadastrar(@RequestBody Servico servico) {
        if(servico == null){
            return ResponseEntity.badRequest().build();
        }
        Servico servicoCadastrado = servicoService.cadastrarServico(servico);
        return ResponseEntity.status(201).body(servicoCadastrado);
    }

    @PutMapping("/vincular-empresa/{idServico}/{idEmpresa}")
    public ResponseEntity<ServicoEmpresaVinculadaDto> vincularEmpresa(@PathVariable Long idServico, @PathVariable Long idEmpresa){
        Servico servico = servicoService.vincularEmpresa(idServico, idEmpresa);
        ServicoEmpresaVinculadaDto servicoEmpresaVinculadaDto = ServicoMapper.toServicoEmpresaVinculadaDto(servico);
        return ResponseEntity.ok(servicoEmpresaVinculadaDto);
    }

    @GetMapping("/empresa/{id}")
    public ResponseEntity<List<ServicoDto>> buscarServicosPorEmpresaId(@PathVariable Long id){
        List<Servico> servicos = servicoService.buscarServicosPorEmpresaId(id);
        List<ServicoDto> dtos = new ArrayList<>();
        for (Servico servicoDaVez: servicos) {
            dtos.add(ServicoMapper.toServicoDto(servicoDaVez));
        }
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/agenda/{idAgenda}")
    public ResponseEntity<List<ServicoDto>> buscarServicosPorAgenda(@PathVariable Long idAgenda){
        List<Servico> servicos = servicoService.buscarServicosPorIdAgenda(idAgenda);
        List<ServicoDto> dtos = new ArrayList<>();

        for (Servico servicoDaVez: servicos) {
            dtos.add(ServicoMapper.toServicoDto(servicoDaVez));
        }
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoDto> listar(@PathVariable Long id) {
        Optional<Servico> servico = servicoService.buscarServicoPorId(id);
        ServicoDto servicoDto = ServicoMapper.toServicoDto(servico.get());
        return ResponseEntity.ok(servicoDto);
    }

    @GetMapping
    public ResponseEntity<List<Servico>> listarTodos() {
        List<Servico> servicos = servicoService.listarTodosServicos();
        return ResponseEntity.ok(servicos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> atualizar(
            @PathVariable Long id,
            @RequestBody Servico servico
    ) {
        Optional<Servico> servicoAtualizado = servicoService.atualizarServico(id, servico);
            return ResponseEntity.status(200).body(servicoAtualizado.get());
    }

    @DeleteMapping("/{idServico}")
    public ResponseEntity<Void> deletarServico(@PathVariable Long idServico) {
        servicoService.deletarServico(idServico);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/exportar-csv")
    public ResponseEntity<Resource> downloadCSVFuncionarios() {
        List<Servico> servico = servicoService.listarTodosServicos();
        System.out.println("ENTROUUUUUUUUUUUU AQUIIII");
        if (servico.isEmpty()) {
            // Se não houver funcionários, retorne uma resposta vazia com status 204
            return ResponseEntity.noContent().build();
        } else {
            try {
                ListaObj<Servico> servicoList = new ListaObj<>(servico.size());

                int tamanho = servico.size();
                for (int i = 0; i < tamanho; i++) {
                    Servico servicoDaVez = servico.get(i);
                    servicoList.adiciona(servicoDaVez);
                }
                // Gere um arquivo CSV com os funcionários
                String csvFilename = "servico";
                ArquivoCsv<Servico> csvExporter = new ArquivoCsv<>();
                csvExporter.gravaArquivoCsv(servicoList, csvFilename);

                // Crie um recurso FileSystemResource para o arquivo CSV gerado
                Resource resource = new FileSystemResource(csvFilename);

                // Configure os cabeçalhos da resposta para indicar o tipo de mídia e o nome do arquivo
                HttpHeaders headers = new HttpHeaders();
                headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=funcionarios.csv");
                headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);

                // Armazena o resultado do ResponseEntity em uma variavel
                ResponseEntity<Resource> responseEntity = ResponseEntity.ok()
                        .headers(headers)
                        .contentType(MediaType.APPLICATION_OCTET_STREAM)
                        .body(resource);

            } catch (IOException e) {
                // Em caso de erro ao criar o arquivo CSV, retorne uma resposta de erro 500
                return ResponseEntity.internalServerError().build();
            }
        }
        return ResponseEntity.ok().build();
    }

}
