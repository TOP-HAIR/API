package school.sptech.projetotophair.domain.empresa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class MetricaEmpresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMetricaEmpresa;
    private BigDecimal totalSemanal;
    private int quantidadeAgendamentos;
    private String servicoMaisPedido;
    private String servicoMenosPedido;
    private String faturamentoMinimo;
    private String faturamentoMaximo;
    private int qtdAgendamentoDomingo;
    private int qtdAgendamentoSegunda;
    private int qtdAgendamentoTerca;
    private int qtdAgendamentoQuarta;
    private int qtdAgendamentoQuinta;
    private int qtdAgendamentoSexta;
    private int qtdAgendamentoSabado;

    public Long getIdMetricaEmpresa() {
        return idMetricaEmpresa;
    }

    public void setIdMetricaEmpresa(Long idMetricaEmpresa) {
        this.idMetricaEmpresa = idMetricaEmpresa;
    }

    public BigDecimal getTotalSemanal() {
        return totalSemanal;
    }

    public void setTotalSemanal(BigDecimal totalSemanal) {
        this.totalSemanal = totalSemanal;
    }

    public int getQuantidadeAgendamentos() {
        return quantidadeAgendamentos;
    }

    public void setQuantidadeAgendamentos(int quantidadeAgendamentos) {
        this.quantidadeAgendamentos = quantidadeAgendamentos;
    }

    public String getServicoMaisPedido() {
        return servicoMaisPedido;
    }

    public void setServicoMaisPedido(String servicoMaisPedido) {
        this.servicoMaisPedido = servicoMaisPedido;
    }

    public String getServicoMenosPedido() {
        return servicoMenosPedido;
    }

    public void setServicoMenosPedido(String servicoMenosPedido) {
        this.servicoMenosPedido = servicoMenosPedido;
    }

    public String getFaturamentoMinimo() {
        return faturamentoMinimo;
    }

    public void setFaturamentoMinimo(String faturamentoMinimo) {
        this.faturamentoMinimo = faturamentoMinimo;
    }

    public String getFaturamentoMaximo() {
        return faturamentoMaximo;
    }

    public void setFaturamentoMaximo(String faturamentoMaximo) {
        this.faturamentoMaximo = faturamentoMaximo;
    }

    public int getQtdAgendamentoDomingo() {
        return qtdAgendamentoDomingo;
    }

    public void setQtdAgendamentoDomingo(int qtdAgendamentoDomingo) {
        this.qtdAgendamentoDomingo = qtdAgendamentoDomingo;
    }

    public int getQtdAgendamentoSegunda() {
        return qtdAgendamentoSegunda;
    }

    public void setQtdAgendamentoSegunda(int qtdAgendamentoSegunda) {
        this.qtdAgendamentoSegunda = qtdAgendamentoSegunda;
    }

    public int getQtdAgendamentoTerca() {
        return qtdAgendamentoTerca;
    }

    public void setQtdAgendamentoTerca(int qtdAgendamentoTerca) {
        this.qtdAgendamentoTerca = qtdAgendamentoTerca;
    }

    public int getQtdAgendamentoQuarta() {
        return qtdAgendamentoQuarta;
    }

    public void setQtdAgendamentoQuarta(int qtdAgendamentoQuarta) {
        this.qtdAgendamentoQuarta = qtdAgendamentoQuarta;
    }

    public int getQtdAgendamentoQuinta() {
        return qtdAgendamentoQuinta;
    }

    public void setQtdAgendamentoQuinta(int qtdAgendamentoQuinta) {
        this.qtdAgendamentoQuinta = qtdAgendamentoQuinta;
    }

    public int getQtdAgendamentoSexta() {
        return qtdAgendamentoSexta;
    }

    public void setQtdAgendamentoSexta(int qtdAgendamentoSexta) {
        this.qtdAgendamentoSexta = qtdAgendamentoSexta;
    }

    public int getQtdAgendamentoSabado() {
        return qtdAgendamentoSabado;
    }

    public void setQtdAgendamentoSabado(int qtdAgendamentoSabado) {
        this.qtdAgendamentoSabado = qtdAgendamentoSabado;
    }
}
