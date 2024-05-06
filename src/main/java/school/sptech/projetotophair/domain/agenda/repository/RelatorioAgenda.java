package school.sptech.projetotophair.domain.agenda.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelatorioAgenda {
    private String dataInicio;
    private String dataFinal;
    private Double precoTotal;
}
