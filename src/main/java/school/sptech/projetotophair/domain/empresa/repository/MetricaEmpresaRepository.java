package school.sptech.projetotophair.domain.empresa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import school.sptech.projetotophair.domain.empresa.MetricaEmpresa;

import java.time.LocalDate;

@Repository
public interface MetricaEmpresaRepository extends JpaRepository<MetricaEmpresa, Long> {

    @Procedure(procedureName = "calcularInformacoes")
    MetricaEmpresa callMetricas(LocalDate dataInicio, LocalDate dataFim, Long empresaId);
}
