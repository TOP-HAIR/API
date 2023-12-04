package school.sptech.projetotophair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import school.sptech.projetotophair.domain.empresa.Empresa;
import school.sptech.projetotophair.domain.empresa.repository.EmpresaRepository;
import school.sptech.projetotophair.domain.endereco.Endereco;
import school.sptech.projetotophair.domain.endereco.repository.EnderecoRepository;
import school.sptech.projetotophair.domain.usuario.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Empresa cadastrarEmpresa(Empresa empresa) {
        if (empresa == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A empresa não pode ser nula.");
        }
        return empresaRepository.save(empresa);
    }

    @Transactional
    public Empresa vincularEndereco(Long idEmpresa, Long idEndereco){
        Optional<Empresa> empresaById = empresaRepository.findById(idEmpresa);
        Optional<Endereco> enderecoById = enderecoRepository.findById(idEndereco);

        if (enderecoById.isPresent() && empresaById.isPresent()) {
            empresaById.get().setEndereco(enderecoById.get());
            return empresaRepository.save(empresaById.get());
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "empresa ou endereço não encontrados");
    }

    public Optional<Empresa> buscarEmpresaPorId(Long id) {
        Optional<Empresa> empresaOptional = empresaRepository.findById(id);
        if (empresaOptional.isPresent()) {
            return empresaOptional;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada com o ID: " + id);
        }
    }
    public List<Empresa> listarEmpresasPorEstado(String estado) {
        List<Empresa> empresas = empresaRepository.findByEnderecoEstado(estado);
        if (empresas.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nenhuma empresa encontrada no estado: " + estado);
        }
        return empresas;
    }

//    public List<Empresa> listarEmpresasTop5AvaliacoesPorEstado(String estado) {
//        List<Empresa> empresas = empresaRepository.findTop5EmpresasMelhorAvaliadasPorEstado(estado);
//        if (empresas.isEmpty()) {
//            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Nenhuma avaliação de empresa encontrada no estado: " + estado);
//        }
//        return empresas;
//    }

    public List<Empresa> listarEmpresasTop5AvaliacoesPorEstado(String estado) {
        List<Empresa> empresas = empresaRepository.findTopEmpresasMelhorAvaliadasPorEstado(estado);
        if (empresas.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Nenhuma avaliação de empresa encontrada no estado: " + estado);
        }

        // Retorne apenas os primeiros 5 resultados
        return empresas.stream().limit(5).collect(Collectors.toList());
    }





    public Optional<Empresa> findEmpresaByUsuarioId(Long idUsuario) {
        if (usuarioRepository.existsById(idUsuario)) {
            Optional<Empresa> empresaByUsuarioId = empresaRepository.findEmpresaByUsuarioId(idUsuario);
            if (empresaByUsuarioId.isPresent()) {
                return empresaByUsuarioId;
            }
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Este usuário não tem uma empresa");
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado");
    }

    public Optional<Empresa> atualizarEmpresa(Long id, Empresa empresa) {
        if (!empresaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada");
        }
        empresa.setIdEmpresa(id);
        Empresa empresaAtualizada = empresaRepository.save(empresa);
        return Optional.of(empresaAtualizada);
    }

    public void deletarEmpresa(Long id) {
        if (!empresaRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada com o ID: " + id);
        }
        empresaRepository.deleteById(id);
    }
}
