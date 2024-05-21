package school.sptech.projetotophair.domain.empresa;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@NamedStoredProcedureQuery(name = "MetricaEmpresa.calcInfo", procedureName = "calcularInformacoes", parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "empresaId", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "data_inicio", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "data_fim", type = Integer.class),
        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "res", type = Integer.class) })
@Getter
@Setter
public class MetricaEmpresa {

    @Id
    private Long idMetricaEmpresa;
    private BigDecimal totalSemanal;
    private int qtdAgendas; // Aqui está diferente
    private String servicoMaisPedidos;
    private String servicoMenosPedidos;
    private String faturamentoMinimo;
    private String faturamentoMaximo;
    @Nullable
    private Integer qtdAgendaDomingo;
    @Nullable
    private Integer qtdAgendaSegunda;
    @Nullable
    private Integer qtdAgendaTerca;
    @Nullable
    private Integer qtdAgendaQuarta;
    @Nullable
    private Integer qtdAgendaQuinta;
    @Nullable
    private Integer qtdAgendaSexta;
    @Nullable
    private Integer qtdAgendaSabado;
}
