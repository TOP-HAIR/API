package school.sptech.projetotophair.domain.agenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import school.sptech.projetotophair.domain.agenda.Agenda;

import java.util.List;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    List<Agenda> findAllByUsuariosIdUsuario(Long idUsuario);

    List<Agenda> findAllByEmpresaIdEmpresa(Long idEmpresa);
}
