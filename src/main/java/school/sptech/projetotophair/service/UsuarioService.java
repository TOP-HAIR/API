package school.sptech.projetotophair.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.projetotophair.api.configuration.security.jwt.GerenciadorTokenJwt;
import school.sptech.projetotophair.domain.empresa.Empresa;
import school.sptech.projetotophair.domain.empresa.repository.EmpresaRepository;
import school.sptech.projetotophair.domain.endereco.Endereco;
import school.sptech.projetotophair.domain.endereco.repository.EnderecoRepository;
import school.sptech.projetotophair.domain.usuario.Usuario;
import school.sptech.projetotophair.domain.usuario.repository.UsuarioRepository;
import school.sptech.projetotophair.service.autenticacao.dto.UsuarioLoginDto;
import school.sptech.projetotophair.service.autenticacao.dto.UsuarioTokenDto;
import school.sptech.projetotophair.service.dto.usuario.UsuarioCriacaoDto;
import school.sptech.projetotophair.service.dto.usuario.mapper.UsuarioMapper;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private GerenciadorTokenJwt gerenciadorTokenJwt;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    public void criar(UsuarioCriacaoDto usuarioCriacaoDto) {
        if (usuarioRepository.existsByEmail(usuarioCriacaoDto.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }

        final Usuario novoUsuario = UsuarioMapper.of(usuarioCriacaoDto);

        String senhaCriptografada = passwordEncoder.encode(novoUsuario.getSenha());
        novoUsuario.setSenha(senhaCriptografada);

        this.usuarioRepository.save(novoUsuario);
    }

    public UsuarioTokenDto autenticar(UsuarioLoginDto usuarioLoginDto) {

        final UsernamePasswordAuthenticationToken credentials = new UsernamePasswordAuthenticationToken(
                usuarioLoginDto.getEmail(), usuarioLoginDto.getSenha());

        final Authentication authentication = this.authenticationManager.authenticate(credentials);

        Usuario usuarioAutenticado =
                usuarioRepository.findByEmail(usuarioLoginDto.getEmail())
                        .orElseThrow(
                                () -> new ResponseStatusException(404, "Email do usuário não cadastrado", null)
                        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        final String token = gerenciadorTokenJwt.generateToken(authentication);

        return UsuarioMapper.of(usuarioAutenticado, token);
    }

    public Usuario buscarPorId(Long id) {
        Usuario usuario = this.usuarioRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Usuário não encontrado com ID: " + id)
        );
        return usuario;
    }

    public Usuario buscarPorIdAvaliacao(Long id){
        Usuario byAvaliacaoId = usuarioRepository.findByAvaliacaoId(id);
        return byAvaliacaoId;
    }

    public Usuario atualizarUsuario(Long id, Usuario novoUsuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Usuário não encontrado com ID: " + id));

        usuarioExistente.setNomeCompleto(novoUsuario.getNomeCompleto());
        usuarioExistente.setEmail(novoUsuario.getEmail());
        usuarioExistente.setTelefone(novoUsuario.getTelefone());

        return usuarioRepository.save(usuarioExistente);
    }

    public Usuario vincularFkEmpresa(Long idEmpresa, Long idUsuario){
        if (empresaRepository.existsById(idEmpresa) && usuarioRepository.existsById(idUsuario)) {
            Optional<Empresa> empresaById = empresaRepository.findById(idEmpresa);
            Optional<Usuario> usuarioById = usuarioRepository.findById(idUsuario);
            usuarioById.get().setEmpresa(empresaById.get());
            return usuarioRepository.save(usuarioById.get());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa ou usuário não encontrados");
    }

    public Usuario vincularEndereco(Long idEndereco, Long idUsuario){
        if (enderecoRepository.existsById(idEndereco) && usuarioRepository.existsById(idUsuario)) {
            Optional<Usuario> usuarioById = usuarioRepository.findById(idUsuario);
            Optional<Endereco> enderecoById = enderecoRepository.findById(idEndereco);
            usuarioById.get().setEndereco(enderecoById.get());
            return usuarioRepository.save(usuarioById.get());
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço ou usuário não encontrados");
    }

    public List<Usuario> buscarUsuariosPorIdEmpresa(Long idEmpresa){
        List<Usuario> allByEmpresaId = usuarioRepository.findAllByEmpresaId(idEmpresa);
        if (empresaRepository.existsById(idEmpresa)) {
            return allByEmpresaId;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada");
    }

    public List<Usuario> buscarUsuariosIdEmpresa(Long idEmpresa){
        List<Usuario> usuarios = usuarioRepository.findByEmpresaIdEmpresa(idEmpresa);
        if (empresaRepository.existsById(idEmpresa)) {
            return usuarios;
        }
        if(usuarios.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Empresa não possui usuarios");

        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada");
    }

    public Endereco findEnderecoByUsuarioId(Long idUsuario){
        Optional<Endereco> enderecoByUsuarioId = usuarioRepository.findEnderecoByUsuarioId(idUsuario);

        if (enderecoByUsuarioId.isPresent()) {
            return enderecoByUsuarioId.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Endereço não cadastrado ou usuário não encontrado");
    }

    public void deletarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Usuário não encontrado com ID: " + id));

        usuarioRepository.delete(usuario);
    }
}
