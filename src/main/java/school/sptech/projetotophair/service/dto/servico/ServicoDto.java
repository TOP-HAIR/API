package school.sptech.projetotophair.service.dto.servico;

import lombok.Data;

@Data
public class ServicoDto {
    private Long idServico;
    private String nomeServico;
    private String categoria;
    private String descricao;
    private Double preco;
    private String qtdTempoServico;
}

