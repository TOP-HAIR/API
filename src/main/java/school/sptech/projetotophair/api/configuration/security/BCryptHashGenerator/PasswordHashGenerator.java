package school.sptech.projetotophair.api.configuration.security.BCryptHashGenerator;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // Dados dos usuários
        String[][] usuarios = {
                {"11122233301", "Alice Oliveira", "alice@gmail.com", "senha123", "(55) 5555-1111", "true", "null", "null", "7", "7"},
                {"22233344402", "Bruno Silva", "bruno@gmail.com", "senha123", "(55) 5555-2222", "true", "null", "null", "8", "8"},
                {"33344455503", "Clara Souza", "clara@gmail.com", "senha123", "(55) 5555-3333", "true", "null", "null", "9", "9"},
                {"44455566604", "Daniel Santos", "daniel@gmail.com", "senha123", "(55) 5555-4444", "true", "null", "null", "10", "10"},
                {"55566677705", "Eva Lima", "eva@gmail.com", "senha123", "(55) 5555-5555", "true", "null", "null", "11", "11"},
                {"66677788806", "Felipe Oliveira", "felipe@gmail.com", "senha123", "(55) 5555-6666", "true", "null", "null", "12", "12"},
                {"77788899907", "Gabriela Silva", "gabriela@gmail.com", "senha123", "(55) 5555-7777", "true", "null", "null", "13", "13"},
                {"88899900008", "Henrique Souza", "henrique@gmail.com", "senha123", "(55) 5555-8888", "true", "null", "null", "14", "14"},
                {"99900011109", "Isabela Santos", "isabela@gmail.com", "senha123", "(55) 5555-9999", "true", "null", "null", "15", "15"},
                {"11122233310", "João Lima", "joao@gmail.com", "senha123", "(55) 5555-1010", "true", "null", "null", "16", "16"},
                {"22233344411", "Karen Oliveira", "karen@gmail.com", "senha123", "(55) 5555-1111", "true", "null", "null", "17", "17"},
                {"33344455512", "Lucas Silva", "lucas@gmail.com", "senha123", "(55) 5555-1212", "true", "null", "null", "18", "18"},
                {"44455566613", "Mariana Souza", "mariana@gmail.com", "senha123", "(55) 5555-1313", "true", "null", "null", "19", "19"},
                {"55566677714", "Nathan Santos", "nathan@gmail.com", "senha123", "(55) 5555-1414", "true", "null", "null", "20", "20"},
                {"66677788815", "Olivia Lima", "olivia@gmail.com", "senha123", "(55) 5555-1515", "true", "null", "null", "21", "21"},
                {"77788899916", "Paulo Oliveira", "paulo@gmail.com", "senha123", "(55) 5555-1616", "true", "null", "null", "22", "22"},
                {"88899900017", "Quezia Souza", "quezia@gmail.com", "senha123", "(55) 5555-1717", "true", "null", "null", "23", "23"},
                {"99900011118", "Rafael Santos", "rafael@gmail.com", "senha123", "(55) 5555-1818", "true", "null", "null", "24", "24"},
                {"11122233319", "Sabrina Lima", "sabrina@gmail.com", "senha123", "(55) 5555-1919", "true", "null", "null", "25", "25"},
                {"22233344420", "Thiago Oliveira", "thiago@gmail.com", "senha123", "(55) 5555-2020", "true", "null", "null", "26", "26"}
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
