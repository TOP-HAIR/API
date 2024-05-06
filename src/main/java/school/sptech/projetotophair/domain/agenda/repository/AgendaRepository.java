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
            + "YEAR(a.dataInicio) ano, "
            + "MONTH(a.dataInicio) mes, "
            + "MIN(a.dataInicio) dataInicio, "
            + "MAX(a.dataFim) dataFinal, "
            + "SUM(s.preco) precoTotal "
            + "FROM Agenda a "
            + "JOIN Servico s ON a.id = s.fk_agenda "
            + "WHERE a.fk_empresa = :idEmpresa "
            + "GROUP BY YEAR(a.dataInicio), MONTH(a.dataInicio) "
            + "ORDER BY YEAR(a.dataInicio), MONTH(a.dataInicio)",
            nativeQuery = true)
    List<Object[]> buscarPeriodosPorEmpresa(@Param("idEmpresa") Long idEmpresa);

}
