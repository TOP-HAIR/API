package school.sptech.projetotophair.service.dto.servico;

import lombok.Data;
import school.sptech.projetotophair.service.dto.empresa.EmpresaDto;

@Data
public class ServicoEmpresaVinculadaDto {
    private Long idServico;
    private String nomeServico;
    private String descricao;
    private Double preco;
    private String qtdTempoServico;
    private EmpresaDto empresa;
}
