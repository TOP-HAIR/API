package school.sptech.projetotophair.api.configuration.security.BCryptHashGenerator;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // Dados dos usuários
        String[][] usuarios = {
                {"11122233344", "Maria Silva", "maria@example.com", "senha123", "(55) 5555-1111", "true", "1", "1", "1", "1"},
                {"22233344455", "João Oliveira", "joao@example.com", "senha123", "(55) 5555-2222", "false", "null", "2", "null", "2"},
                {"33344455566", "Ana Souza", "ana@example.com", "senha123", "(55) 5555-3333", "true", "3", "3", "3", "3"},
                {"44455566677", "Carlos Santos", "carlos@example.com", "senha123", "(55) 5555-4444", "false", "null", "4", "null", "4"},
                {"55566677788", "Mariana Lima", "mariana@example.com", "senha123", "(55) 5555-5555", "true", "5", "5", "5", "5"}
        };

        // Gerar e imprimir os hashes
        for (String[] usuario : usuarios) {
            String cpf = usuario[0];
            String nomeCompleto = usuario[1];
            String email = usuario[2];
            String senha = usuario[3];
            String telefone = usuario[4];
            boolean isProfissional = Boolean.parseBoolean(usuario[5]);
            Long fkServico = parseLongOrNull(usuario[6]);
            Long fkAgenda = parseLongOrNull(usuario[7]);
            Long fkEmpresa = parseLongOrNull(usuario[8]);
            Long fkEndereco = parseLongOrNull(usuario[9]);

            String hashSenha = encoder.encode(senha);

            System.out.println("INSERT INTO Usuario (cpf, nome_Completo, email, senha, telefone, is_Profissional, fk_Servico, fk_Agenda, fk_Empresa, fk_Endereco)");
            System.out.println("VALUES");
            System.out.println("    ('" + cpf + "', '" + nomeCompleto + "', '" + email + "', '" + hashSenha + "', '" + telefone + "', " + isProfissional + ", " + fkServico + ", " + fkAgenda + ", " + fkEmpresa + ", " + fkEndereco + ");");
            System.out.println();
        }
    }

    private static Long parseLongOrNull(String value) {
        if ("null".equalsIgnoreCase(value)) {
            return null;
        }
        return Long.parseLong(value);
    }
}
