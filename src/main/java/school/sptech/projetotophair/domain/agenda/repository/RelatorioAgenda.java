package school.sptech.projetotophair.domain.agenda.repository;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class RelatorioAgenda {
    private int ano;
    private int mes;
    private String dataInicio;
    private String dataFinal;
    private BigDecimal precoTotal;

    public RelatorioAgenda(int ano, int mes, String dataInicio, String dataFinal, BigDecimal precoTotal) {
    }
}
