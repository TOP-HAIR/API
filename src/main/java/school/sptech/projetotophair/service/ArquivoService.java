package school.sptech.projetotophair.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.projetotophair.domain.arquivo.Arquivo;
import school.sptech.projetotophair.domain.arquivo.repository.ArquivoRepository;
import school.sptech.projetotophair.domain.empresa.Empresa;
import school.sptech.projetotophair.domain.empresa.repository.EmpresaRepository;
import school.sptech.projetotophair.domain.usuario.Usuario;
import school.sptech.projetotophair.domain.usuario.repository.UsuarioRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ArquivoService {

    @Autowired
    private ArquivoRepository arquivoRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private Path diretorioBase = Path.of(System.getProperty("java.io.tmpdir") + "/arquivos");

    public List<Arquivo> bucarPorEmpresa(Long idEmpresa) {
        Optional<Empresa> empresaById = empresaRepository.findById(idEmpresa);
        if (empresaById.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa não encontrada");
        }
        List<Arquivo> allByEmpresaIdEmpresa = arquivoRepository.findAllByEmpresaIdEmpresa(idEmpresa);
        if (allByEmpresaIdEmpresa.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Essa empresa não tem arquivos");
        }
        return allByEmpresaIdEmpresa;
    }

    public Arquivo buscarArquivoPorUsuario(Long idUsuario) {
        Optional<Usuario> usuarioById = usuarioRepository.findById(idUsuario);
        if (usuarioById.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não econtrado");
        }
        Arquivo byUsuarioIdUsuario = arquivoRepository.findByUsuarioIdUsuario(idUsuario);
        return byUsuarioIdUsuario;
    }

    public Arquivo vincularEmpresa(Integer idArquivo, Long idEmpresa) {
        Optional<Arquivo> arquivoById = arquivoRepository.findById(idArquivo);
        Optional<Empresa> empresaById = empresaRepository.findById(idEmpresa);
        if (empresaById.isPresent() && arquivoById.isPresent()) {
            arquivoById.get().setEmpresa(empresaById.get());
            return arquivoById.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Empresa ou arquivo não encontrados");
    }

    public Arquivo uploadArquivo(MultipartFile file) {
        if (file.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Arquivo vazio");
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

        return arquivoRepository.save(arquivo);
    }

    public byte[] downloadArquivo(Integer id) {
        Optional<Arquivo> arquivoOptional = arquivoRepository.findById(id);

        if (arquivoOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Arquivo não encontrado");
        }

        Arquivo arquivoBanco = arquivoOptional.get();

        File file = this.diretorioBase.resolve(arquivoBanco.getNomeArquivoSalvo()).toFile();
        try {
            return java.nio.file.Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            throw new ResponseStatusException(422, "Não foi possível ler o arquivo", null);
        }
    }

    private String formatarNomeArquivo(String nomeOriginal) {
        return String.format("%s_%s", UUID.randomUUID(), nomeOriginal);
    }

    public void deletar(Integer idArquivo) {
        Optional<Arquivo> byId = arquivoRepository.findById(idArquivo);
        if (byId.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Arquivo não encontrado");
        }
        arquivoRepository.deleteById(idArquivo);
    }
}
