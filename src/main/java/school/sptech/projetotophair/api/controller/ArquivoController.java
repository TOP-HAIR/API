package school.sptech.projetotophair.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.projetotophair.domain.arquivo.Arquivo;
import school.sptech.projetotophair.domain.arquivo.repository.ArquivoRepository;
import school.sptech.projetotophair.service.ArquivoService;
import school.sptech.projetotophair.service.dto.arquivo.ArquivoDto;
import school.sptech.projetotophair.service.dto.arquivo.ArquivoEmpresaVinculadaDto;
import school.sptech.projetotophair.service.dto.arquivo.ArquivoUsuarioVinculadoDto;
import school.sptech.projetotophair.service.dto.arquivo.mapper.ArquivoMapper;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/arquivos")
public class ArquivoController {

    @Autowired
    private ArquivoRepository arquivoRepository;

    @Autowired
    private ArquivoService arquivoService;

    private Path diretorioBase = Path.of(System.getProperty("java.io.tmpdir") + "/arquivos");

    @PostMapping("/upload")
    public ResponseEntity<Arquivo> upload(@RequestParam("arquivo") MultipartFile file) {

        if (file.isEmpty()){
            return ResponseEntity.status(400).build();
        }

        if (!this.diretorioBase.toFile().exists()) {
            this.diretorioBase.toFile().mkdir();
        }

        String nomeArquivoFormatado = formatarNomeArquivo(file.getOriginalFilename());

        String filePath = this.diretorioBase + "/" + nomeArquivoFormatado;
        File dest = new File(filePath);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ResponseStatusException(422, "Não foi possível salvar o arquivo", null);
        }

        Arquivo arquivo = new Arquivo();
        arquivo.setDataUpload(LocalDate.now());
        arquivo.setNomeArquivoOriginal(file.getOriginalFilename());
        arquivo.setNomeArquivoSalvo(nomeArquivoFormatado);
        Arquivo arquivoBanco = arquivoRepository.save(arquivo);

        return ResponseEntity.status(200).body(arquivoBanco);
    }

    @PutMapping("/vincular-empresa/{idArquivo}/{idEmpresa}")
    public ResponseEntity<ArquivoEmpresaVinculadaDto> vincularEmpresa(@PathVariable Integer idArquivo, @PathVariable Long idEmpresa){
        Arquivo arquivo = arquivoService.vincularEmpresa(idArquivo, idEmpresa);
        ArquivoEmpresaVinculadaDto arquivoEmpresaVinculadaDto = ArquivoMapper.toArquivoEmpresaVinculadaDto(arquivo);
        return ResponseEntity.ok(arquivoEmpresaVinculadaDto);
    }

    @PutMapping("/vincular-usuario/{idArquivo}/{idUsuario}")
    public ResponseEntity<ArquivoUsuarioVinculadoDto> vincularUsuario(@PathVariable Integer idArquivo, @PathVariable Long idUsuario){
        Arquivo arquivo = arquivoService.vincularUsuario(idArquivo, idUsuario);
        ArquivoUsuarioVinculadoDto arquivoUsuarioVinculadoDto = ArquivoMapper.toArquivoUsuarioVinculadoDto(arquivo);
        return ResponseEntity.ok(arquivoUsuarioVinculadoDto);
    }

    @GetMapping("/empresa/{idEmpresa}")
    public ResponseEntity<List<ArquivoDto>> buscarArquivosEmpresa(@PathVariable Long idEmpresa){
        List<Arquivo> arquivos = arquivoService.bucarPorEmpresa(idEmpresa);
        List<ArquivoDto> dtos = new ArrayList<>();
        for (Arquivo arquivoDaVez: arquivos) {
            dtos.add(ArquivoMapper.toArquivoDto(arquivoDaVez));
        }
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<ArquivoDto> buscarArquivoPorUsuario(@PathVariable Long idUsuario){
        Arquivo arquivo = arquivoService.buscarArquivoPorUsuario(idUsuario);
        ArquivoDto arquivoDto = ArquivoMapper.toArquivoDto(arquivo);
        return ResponseEntity.ok(arquivoDto);
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable Integer id){
        Optional<Arquivo> arquivoOptional = arquivoRepository.findById(id);

        if (arquivoOptional.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        Arquivo arquivoBanco = arquivoOptional.get();

        File file = this.diretorioBase.resolve(arquivoBanco.getNomeArquivoSalvo()).toFile();
        try {
            InputStream fileInputStream = new FileInputStream(file);

            return ResponseEntity.status(200)
                    .header("Content-Disposition",
                            "attachment; filename=" + arquivoBanco.getNomeArquivoOriginal())
                    .body(fileInputStream.readAllBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new ResponseStatusException(422, "Diretório não encontrado", null);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ResponseStatusException(422, "Não foi possível converter para byte[]", null);
        }
    }

    @GetMapping("/exibir/{id}")
    public ResponseEntity<Resource> exibirArquivo(@PathVariable Integer id) {
        Optional<Arquivo> arquivoOptional = arquivoRepository.findById(id);

        if (arquivoOptional.isEmpty()) {
            return ResponseEntity.status(404).build();
        }

        Arquivo arquivoBanco = arquivoOptional.get();

        File file = this.diretorioBase.resolve(arquivoBanco.getNomeArquivoSalvo()).toFile();

        try {
            // Carrega o arquivo como um recurso
            Resource resource = new FileSystemResource(file);

            // Define o cabeçalho para o nome do arquivo
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + arquivoBanco.getNomeArquivoOriginal());

            // Retorna o recurso com os cabeçalhos apropriados
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
                    .body(resource);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao ler o arquivo", e);
        }
    }

    private String formatarNomeArquivo(String nomeOriginal) {
        return String.format("%s_%s", UUID.randomUUID(), nomeOriginal);
    }

    @DeleteMapping("{idArquivo}")
    public ResponseEntity<Void> deletar(@PathVariable Integer idArquivo){
    arquivoService.deletar(idArquivo);
    return ResponseEntity.noContent().build();
    }
}