package school.sptech.projetotophair.api.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetotophair.domain.empresa.Empresa;
import school.sptech.projetotophair.domain.endereco.Endereco;
import school.sptech.projetotophair.domain.usuario.Usuario;
import school.sptech.projetotophair.service.UsuarioService;
import school.sptech.projetotophair.service.autenticacao.dto.UsuarioLoginDto;
import school.sptech.projetotophair.service.autenticacao.dto.UsuarioTokenDto;
import school.sptech.projetotophair.service.dto.endereco.EnderecoDto;
import school.sptech.projetotophair.service.dto.endereco.mapper.EnderecoMapper;
import school.sptech.projetotophair.service.dto.usuario.UsuarioAvaliacaoResponseDto;
import school.sptech.projetotophair.service.dto.usuario.UsuarioCriacaoDto;
import school.sptech.projetotophair.service.dto.usuario.UsuarioEnderecoVinculadoDto;
import school.sptech.projetotophair.service.dto.usuario.UsuarioResponseDto;
import school.sptech.projetotophair.service.dto.usuario.UsuarioEmpresaVinculadaDto;
import school.sptech.projetotophair.service.dto.usuario.mapper.UsuarioMapper;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

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
    public ResponseEntity<UsuarioResponseDto> buscarPorid(@PathVariable Long id){
        Usuario usuario = this.usuarioService.buscarPorId(id);
        UsuarioResponseDto usuarioResponseDto = UsuarioMapper.toUsuarioResponseDto(usuario);
        return ResponseEntity.ok(usuarioResponseDto);
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
}