package school.sptech.projetotophair.domain.empresa;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.br.CNPJ;
import school.sptech.projetotophair.domain.agenda.Agenda;
import school.sptech.projetotophair.domain.arquivo.Arquivo;
import school.sptech.projetotophair.domain.avaliacao.Avaliacao;
import school.sptech.projetotophair.domain.endereco.Endereco;
import school.sptech.projetotophair.domain.usuario.Usuario;

import java.util.List;

@Entity
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpresa;

    private String razaoSocial;

    private String cnpj;

    @Nullable
    @OneToOne
    @JoinColumn(name = "fkEndereco", referencedColumnName = "idEndereco")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Endereco endereco;

    @Nullable
    @OneToMany(mappedBy = "empresa")
    @OnDelete(action = OnDeleteAction.CASCADE)
    List<Usuario> usuarios;

    @Nullable
    @OneToMany(mappedBy = "empresa")
    List<Avaliacao> avaliacoes;

    @Nullable
    @OneToMany(mappedBy = "empresa")
    @OnDelete(action = OnDeleteAction.CASCADE)
    List<Arquivo> arquivos;


    public Empresa(Long idEmpresa, String razaoSocial, String cnpj, Endereco endereco) {
        this.idEmpresa = idEmpresa;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }

    public Empresa() {

    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "idEmpresa=" + idEmpresa +
                ", razaoSocial='" + razaoSocial + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", endereco=" + endereco +
                ", usuarios=" + usuarios +
                ", avaliacoes=" + avaliacoes +
                ", arquivos=" + arquivos +
                '}';
    }
}
