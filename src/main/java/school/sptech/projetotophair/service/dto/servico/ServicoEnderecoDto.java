package school.sptech.projetotophair.service.dto.servico;

import lombok.Data;

@Data
public class ServicoEnderecoDto {
    private Long idServico;
    private String nomeServico;
    private String categoria;
    private String descricao;
    private String tipoServico;
    private Double preco;
    private String qtdTempoServico;
    private String estado;
}
