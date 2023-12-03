package school.sptech.projetotophair.service.dto.servico;

import lombok.Data;

@Data
public class ServicoEnderecoDto {
    private Long idEmpresa;
    private String razaoSocial;
    private String cnpj;
    private String tipoServico;
    private String estado;
}
