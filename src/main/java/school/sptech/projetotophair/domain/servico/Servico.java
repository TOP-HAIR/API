package school.sptech.projetotophair.domain.servico;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import school.sptech.projetotophair.domain.agenda.Agenda;
import school.sptech.projetotophair.domain.empresa.Empresa;
import school.sptech.projetotophair.domain.usuario.Usuario;

import java.util.List;


@Entity
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idServico;
    @Size(min = 4, max = 40)
    private String nomeServico;

    private String categoria;

    @Size(min = 5, max = 250)
    @NotNull
    private String descricao;
    @NotNull
    private Double preco;
    @Pattern(regexp = "^([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d$")
    private String qtdTempoServico;
    @OneToOne
    @JoinColumn(name = "fkAgenda", referencedColumnName = "idAgenda")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Agenda agenda;
    @ManyToOne
    @JoinColumn(name = "fkEmpresa", referencedColumnName = "idEmpresa")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private Empresa empresa;

    @OneToMany(mappedBy = "servico")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private List<Usuario> usuarios;

    public Servico(Long idServico, String nomeServico, String categoria, String descricao, Double preco, String qtdTempoServico, Agenda agenda, Empresa empresa) {
        this.idServico = idServico;
        this.nomeServico = nomeServico;
        this.categoria = categoria;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdTempoServico = qtdTempoServico;
        this.agenda = agenda;
        this.empresa = empresa;
    }

    public Servico(Long idServico, String nomeServico, String descricao, Double preco, String qtdTempoServico, Agenda agenda, Empresa empresa) {
        this.idServico = idServico;
        this.nomeServico = nomeServico;
        this.descricao = descricao;
        this.preco = preco;
        this.qtdTempoServico = qtdTempoServico;
        this.agenda = agenda;
        this.empresa = empresa;
    }

    public Servico() {

    }

    public Long getIdServico() {
        return idServico;
    }

    public void setIdServico(Long idServico) {
        this.idServico = idServico;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getQtdTempoServico() {
        return qtdTempoServico;
    }

    public void setQtdTempoServico(String qtdTempoServico) {
        this.qtdTempoServico = qtdTempoServico;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
