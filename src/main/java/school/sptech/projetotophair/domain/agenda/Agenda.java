package school.sptech.projetotophair.domain.agenda;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import school.sptech.projetotophair.domain.empresa.Empresa;
import school.sptech.projetotophair.domain.usuario.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Agenda {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgenda;
    @Nullable
    private LocalDateTime start;
    @Nullable
    private LocalDateTime end;

    @Nullable
    private String background;
    @Getter
    @NotBlank
    private String title;
    @Getter
    @OneToMany(mappedBy = "agenda")
    List<Usuario> usuarios;
    @Getter
    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "fkEmpresa", referencedColumnName = "idEmpresa")
    private Empresa empresa;

    public Agenda(Long idAgenda, @Nullable LocalDateTime start, @Nullable LocalDateTime end, @Nullable String background, String title, List<Usuario> usuarios, Empresa empresa) {
        this.idAgenda = idAgenda;
        this.start = start;
        this.end = end;
        this.background = background;
        this.title = title;
        this.usuarios = usuarios;
        this.empresa = empresa;
    }

    public Agenda() {

    }

    public void setIdAgenda(Long idAgenda) {
        this.idAgenda = idAgenda;
    }

    @Nullable
    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(@Nullable LocalDateTime start) {
        this.start = start;
    }

    @Nullable
    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(@Nullable LocalDateTime end) {
        this.end = end;
    }

    @Nullable
    public String getBackground() {
        return background;
    }

    public void setBackground(@Nullable String background) {
        this.background = background;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
