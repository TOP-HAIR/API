package school.sptech.projetotophair.domain.agendaservico.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import school.sptech.projetotophair.domain.agendaservico.AgendaServico;

@Repository
public interface AgendaServicoRepository extends JpaRepository<AgendaServico, Long> {
}
