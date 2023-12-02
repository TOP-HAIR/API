package school.sptech.projetotophair.service.integraveis.exportacao;

import school.sptech.projetotophair.domain.empresa.Empresa;
import school.sptech.projetotophair.domain.usuario.Usuario;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class Exportacao {
    public void gravaArquivoFuncionarios(List<Usuario> lista, Optional<Empresa> empresas, String nomeArq) {
        int contaRegDadosUsuarios = 0;
        int contaRegDadosEmpresas = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        // Monta o registro de header para os usuários
        String headerUsuarios = "00Usuarios";
        headerUsuarios += LocalDateTime.now().format(formatter);
        headerUsuarios += "01";

        // Grava o registro de header para os usuários no arquivo único
        gravaRegistro(headerUsuarios, nomeArq);

        // Grava os registros de dados (registros de corpo) para usuários no arquivo único
        for (Usuario usuario : lista) {
            String corpoUsuario = "02";
            corpoUsuario += String.format("%06d", usuario.getIdUsuario());
            corpoUsuario += String.format("%-50.50s", usuario.getNomeCompleto());
            corpoUsuario += String.format("%-50.50s", usuario.getEmail());
            corpoUsuario += String.format("%-14.14s", usuario.getTelefone());
            corpoUsuario += String.format("%-14.14s", usuario.getCpf());
            corpoUsuario += String.format("%-1.1s", usuario.getProfissional());
            corpoUsuario += String.format("%06d", usuario.getEmpresa().getIdEmpresa());

            // Verifica se o usuário possui uma empresa associada
            if (usuario.getEmpresa() != null) {
                Empresa empresa = usuario.getEmpresa();
                String corpoEmpresa = "03";
                corpoEmpresa += String.format("%05d", empresa.getIdEmpresa());
                corpoEmpresa += String.format("%-50.50s", empresa.getRazaoSocial());
                corpoEmpresa += String.format("%-18.18s", empresa.getCnpj());

                // Grava o registro de corpo da empresa no mesmo arquivo
                gravaRegistro(corpoEmpresa, nomeArq);
                contaRegDadosEmpresas++;
            }

            // Grava o registro de corpo do usuário no mesmo arquivo
            gravaRegistro(corpoUsuario, nomeArq);
            contaRegDadosUsuarios++;
        }

        // Monta e grava o registro de trailer para usuários e empresas no mesmo arquivo
        String trailer = "01";
        trailer += String.format("%010d", contaRegDadosUsuarios + contaRegDadosEmpresas);
        gravaRegistro(trailer, nomeArq);
    }

    public void gravaRegistro(String registro, String nomeArq) {
        BufferedWriter saida = null;

        // Abre o arquivo
        try {
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException erro) {
            System.out.println("Erro na abertura do arquivo");
        }

        // Grava o registro e fecha o arquivo
        try {
            if (saida != null) {
                saida.append(registro).append("\n");
                saida.close();
            }
        } catch (IOException erro) {
            System.out.println("Erro ao gravar o arquivo");
            erro.printStackTrace();
        }
    }

}