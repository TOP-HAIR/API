package school.sptech.projetotophair.domain.agenda;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import school.sptech.projetotophair.domain.empresa.Empresa;
import school.sptech.projetotophair.domain.usuario.Usuario;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgenda;

    @Nullable
    private LocalDateTime start;

    @Nullable
    private LocalDateTime end;

    @Nullable
    private String background;

    @NotBlank
    private String title;

    @OneToMany(mappedBy = "agenda")
    private List<Usuario> usuarios;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "fkEmpresa", referencedColumnName = "idEmpresa")
    private Empresa empresa;

    public Agenda() {
    }

    public Agenda(Long idAgenda, @Nullable LocalDateTime start, @Nullable LocalDateTime end, @Nullable String background, String title, List<Usuario> usuarios, Empresa empresa) {
        this.idAgenda = idAgenda;
        this.start = start;
        this.end = end;
        this.background = background;
        this.title = title;
        this.usuarios = usuarios;
        this.empresa = empresa;
    }
}