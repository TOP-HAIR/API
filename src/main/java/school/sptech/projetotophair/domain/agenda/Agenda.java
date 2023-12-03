package school.sptech.projetotophair.domain.agenda;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import school.sptech.projetotophair.domain.avaliacao.Avaliacao;
import school.sptech.projetotophair.domain.empresa.Empresa;
import school.sptech.projetotophair.domain.historicoservico.HistoricoServico;
import school.sptech.projetotophair.domain.servico.Servico;
import school.sptech.projetotophair.domain.usuario.Usuario;

import java.time.LocalDate;
import java.util.List;

@Entity
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgenda;
    @FutureOrPresent
    @Nullable
    private LocalDate data;
    @Nullable
    private String hora;
    @NotBlank
    private String status;
    @OneToMany(mappedBy = "agenda")
    List<Usuario> usuarios;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "fkEmpresa", referencedColumnName = "idEmpresa")
    private Empresa empresa;

    public Agenda(Long idAgenda, LocalDate data, String hora, String status, List<Usuario> usuarios, Empresa empresa) {
        this.idAgenda = idAgenda;
        this.data = data;
        this.hora = hora;
        this.status = status;
        this.usuarios = usuarios;
        this.empresa = empresa;
    }

    public Agenda(){

    }

    public Long getIdAgenda() {
        return idAgenda;
    }

    public void setIdAgenda(Long idAgenda) {
        this.idAgenda = idAgenda;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
