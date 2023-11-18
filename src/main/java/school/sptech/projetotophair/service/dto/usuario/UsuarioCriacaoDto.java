package school.sptech.projetotophair.service.dto.usuario;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import school.sptech.projetotophair.domain.empresa.Empresa;
import school.sptech.projetotophair.domain.endereco.Endereco;
import school.sptech.projetotophair.service.dto.empresa.EmpresaDto;

public class UsuarioCriacaoDto {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    @Nullable
    private String cpf;
    @Getter
    @NotBlank
    private String nomeCompleto;
    @Getter
    @Email
    @NotBlank
    private String email;
    @Getter
    @NotBlank
    private String senha;
    @Getter
    private String telefone;

    @NotNull
    private Boolean isProfissional;


    @Getter
    @ManyToOne
    @JoinColumn(name = "fkEmpresa", referencedColumnName = "idEmpresa")
    private Empresa empresa;

    @Nullable
    @OneToOne
    @JoinColumn(name = "fkEndereco", referencedColumnName = "idEndereco")
    private Endereco endereco;

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Nullable
    public String getCpf() {
        return cpf;
    }

    public void setCpf(@Nullable String cpf) {
        this.cpf = cpf;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Boolean getProfissional() {
        return isProfissional;
    }

    public void setProfissional(Boolean profissional) {
        isProfissional = profissional;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Nullable
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(@Nullable Endereco endereco) {
        this.endereco = endereco;
    }
}
