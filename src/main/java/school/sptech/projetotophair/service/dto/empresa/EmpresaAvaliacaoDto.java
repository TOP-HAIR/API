package school.sptech.projetotophair.service.dto.empresa;

import lombok.Data;
import school.sptech.projetotophair.service.dto.avaliacao.AvaliacaoResponseDto;
import school.sptech.projetotophair.service.dto.endereco.EnderecoDto;

import java.util.List;

@Data
public class EmpresaAvaliacaoDto {
    private Long idEmpresa;
    private String razaoSocial;
    private EnderecoDto endereco;
    List<AvaliacaoResponseDto> avaliacoes;
    private Double mediaNivelAvaliacoes;
}
