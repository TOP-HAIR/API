package school.sptech.projetotophair.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import school.sptech.projetotophair.domain.empresa.Empresa;
import school.sptech.projetotophair.domain.endereco.Endereco;
import school.sptech.projetotophair.domain.usuario.Usuario;
import school.sptech.projetotophair.service.EmpresaService;
import school.sptech.projetotophair.service.UsuarioService;
import school.sptech.projetotophair.service.autenticacao.dto.UsuarioLoginDto;
import school.sptech.projetotophair.service.autenticacao.dto.UsuarioTokenDto;
import school.sptech.projetotophair.service.dto.endereco.EnderecoDto;
import school.sptech.projetotophair.service.dto.endereco.mapper.EnderecoMapper;
import school.sptech.projetotophair.service.dto.usuario.*;
import school.sptech.projetotophair.service.dto.usuario.mapper.UsuarioMapper;
import school.sptech.projetotophair.service.integraveis.exportacao.Exportacao;
import school.sptech.projetotophair.service.integraveis.importacao.Importacao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private EmpresaService empresaService;
    @PostMapping("/cadastrar")
    @SecurityRequirement(name = "Bearer")
    public ResponseEntity<Long> criar(@RequestBody UsuarioCriacaoDto usuarioCriacaoDto) {
        Usuario usuario = this.usuarioService.criar(usuarioCriacaoDto);
        return ResponseEntity.status(201).body(usuario.getIdUsuario());
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioTokenDto> login(@Valid @RequestBody UsuarioLoginDto usuarioLoginDto) {
        UsuarioTokenDto usuarioTokenDto = this.usuarioService.autenticar(usuarioLoginDto);
        return ResponseEntity.ok().body(usuarioTokenDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioComArquivoDto> buscarPorid(@PathVariable Long id){
        Usuario usuario = this.usuarioService.buscarPorId(id);
        UsuarioComArquivoDto usuarioDto = UsuarioMapper.toUsuarioComArquivoDto(usuario);
        return ResponseEntity.ok(usuarioDto);
    }

    @GetMapping("/empresa/{idEmpresa}")
    public ResponseEntity<List<UsuarioResponseDto>> buscarUsuariosPorIdEmpresa(@PathVariable Long idEmpresa){
        List<Usuario> usuarios = usuarioService.buscarUsuariosPorIdEmpresa(idEmpresa);
        if (!usuarios.isEmpty()) {
            List<UsuarioResponseDto> dtos = new ArrayList<>();
            for (Usuario usuarioDaVez: usuarios) {
                dtos.add(UsuarioMapper.toUsuarioResponseDto(usuarioDaVez));
            }
            return ResponseEntity.ok(dtos);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/avaliacao/{id}")
    public ResponseEntity<UsuarioAvaliacaoResponseDto> buscarPorIdAvaliacao(@PathVariable Long id){
        Usuario usuario = usuarioService.buscarPorIdAvaliacao(id);
        UsuarioAvaliacaoResponseDto usuarioAvaliacaoResponseDto = UsuarioMapper.toUsuarioAvaliacaoResponseDto(usuario);
        return ResponseEntity.ok(usuarioAvaliacaoResponseDto);
    }

    @GetMapping("/endereco/{idUsuario}")
    public ResponseEntity<EnderecoDto> buscarEnderecoPorIdusuario(@PathVariable Long idUsuario){
        Endereco enderecoByUsuarioId = usuarioService.findEnderecoByUsuarioId(idUsuario);
        EnderecoDto enderecoDto = EnderecoMapper.toEnderecoDto(enderecoByUsuarioId);
        return ResponseEntity.ok(enderecoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, @RequestBody Usuario novoUsuario) {
        Usuario usuarioAtualizado = usuarioService.atualizarUsuario(id, novoUsuario);
        return ResponseEntity.ok(usuarioAtualizado);
    }

    @PutMapping("/vincular-empresa/{idUsuario}/{idEmpresa}")
    public ResponseEntity<UsuarioEmpresaVinculadaDto> vincularEmpresa(@PathVariable Long idUsuario, @PathVariable Long idEmpresa){
        Usuario usuario = usuarioService.vincularFkEmpresa(idEmpresa, idUsuario);
        Empresa empresa = usuario.getEmpresa();
        UsuarioEmpresaVinculadaDto usuarioEmpresaVinculadaDto = UsuarioMapper.toUsuarioEmpresaVinculadaDto(usuario, empresa);
        return ResponseEntity.ok(usuarioEmpresaVinculadaDto);
    }

    @PutMapping("/vincular-endereco/{idEndereco}/{idUsuario}")
    public ResponseEntity<UsuarioEnderecoVinculadoDto> vincularEndereco(@PathVariable Long idUsuario, @PathVariable Long idEndereco){
        Usuario usuario = usuarioService.vincularEndereco(idEndereco, idUsuario);
        Endereco endereco = usuario.getEndereco();
        UsuarioEnderecoVinculadoDto usuarioEnderecoVinculadoDto = UsuarioMapper.toUsuarioEnderecoVinculadoDto(usuario, endereco);
        return ResponseEntity.ok(usuarioEnderecoVinculadoDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/exportar-txt/{idEmpresa}")
    public ResponseEntity<Resource> exportarFuncionariosParaTXT(@PathVariable Long idEmpresa) {
        List<Usuario> usuarios = usuarioService.buscarUsuariosPorIdEmpresa(idEmpresa);
        Optional<Empresa> empresa = empresaService.buscarEmpresaPorId(idEmpresa);
        Exportacao exportar = new Exportacao();
        if (usuarios == null || empresa == null) {
            return ResponseEntity.notFound().build();
        }
        if (usuarios == null || usuarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        else {

            String txtFilename = "usuarios.txt";
            exportar.gravaArquivoFuncionarios(usuarios,empresa, txtFilename);

            // Crie um recurso FileSystemResource para o arquivo TXT gerado
            Resource resource = (Resource) new FileSystemResource(txtFilename);

            // Configure os cabeçalhos da resposta para indicar o tipo de mídia e o nome do arquivo
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=funcionarios.txt");
            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);

            // Retorne a resposta com o arquivo TXT como anexo
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(resource);
        }
    }

    @PostMapping("/importacao")
    public ResponseEntity<List<UsuarioCriacaoDto>> cadastrarFuncionariosTxt(
            @RequestParam MultipartFile file
    ) throws IOException {
        // Verifique se o arquivo é nulo ou vazio antes de prosseguir
        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        List<UsuarioCriacaoDto> result = new Importacao(empresaService, usuarioService).importarDados(file);

        if (result.isEmpty()) {
            return ResponseEntity.status(404).build();
        } else {
            return ResponseEntity.status(201).body(result);
        }
    }

}