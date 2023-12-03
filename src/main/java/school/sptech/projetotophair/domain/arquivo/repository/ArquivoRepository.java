package school.sptech.projetotophair.domain.arquivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.projetotophair.domain.arquivo.Arquivo;

import java.util.List;

public interface ArquivoRepository extends JpaRepository<Arquivo, Integer> {
    List<Arquivo> findAllByEmpresaIdEmpresa(Long idEmpresa);

    Arquivo findByUsuarioIdUsuario(Long idUsuario);
}
