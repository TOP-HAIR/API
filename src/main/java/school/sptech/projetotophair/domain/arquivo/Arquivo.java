package school.sptech.projetotophair.domain.arquivo;

import jakarta.persistence.*;
import school.sptech.projetotophair.domain.agenda.Agenda;
import school.sptech.projetotophair.domain.empresa.Empresa;

import java.time.LocalDate;

@Entity
public class Arquivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomeArquivoOriginal;
    private String nomeArquivoSalvo;
    private LocalDate dataUpload;

    @ManyToOne
    @JoinColumn(name = "fkEmpresa", referencedColumnName = "idEmpresa")
    private Empresa empresa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeArquivoOriginal() {
        return nomeArquivoOriginal;
    }

    public void setNomeArquivoOriginal(String nomeArquivoOriginal) {
        this.nomeArquivoOriginal = nomeArquivoOriginal;
    }

    public String getNomeArquivoSalvo() {
        return nomeArquivoSalvo;
    }

    public void setNomeArquivoSalvo(String nomeArquivoSalvo) {
        this.nomeArquivoSalvo = nomeArquivoSalvo;
    }

    public LocalDate getDataUpload() {
        return dataUpload;
    }

    public void setDataUpload(LocalDate dataUpload) {
        this.dataUpload = dataUpload;
    }
}
