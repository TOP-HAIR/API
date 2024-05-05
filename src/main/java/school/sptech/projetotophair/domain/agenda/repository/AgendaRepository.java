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

    @Query(value = "SELECT "
            + "YEAR(a.data_inicio) AS ano, "
            + "MONTH(a.data_inicio) AS mes, "
            + "FORMAT(MIN(a.data_inicio), 'dd/MM/yyyy') AS dataInicio, "
            + "FORMAT(MAX(a.data_final), 'dd/MM/yyyy') AS dataFinal, "
            + "SUM(s.preco) AS precoTotal "
            + "FROM Agenda AS a "
            + "JOIN Servico AS s ON a.id = s.fk_agenda "
            + "WHERE a.fk_empresa = :idEmpresa "
            + "GROUP BY YEAR(a.data_inicio), MONTH(a.data_inicio) "
            + "ORDER BY YEAR(a.data_inicio), MONTH(a.data_inicio)",
            nativeQuery = true)
    List<Object[]> buscarPeriodosPorEmpresa(@Param("idEmpresa") Long idEmpresa);
}
