package school.sptech.projetotophair.service.dto.empresa;

import lombok.Data;
import school.sptech.projetotophair.domain.avaliacao.Avaliacao;
import school.sptech.projetotophair.service.dto.avaliacao.AvaliacaoResponseDto;

import java.util.List;

@Data
public class EmpresaAvaliacaoDto {
    private Long idEmpresa;
    private String razaoSocial;
    List<AvaliacaoResponseDto> avaliacoes;
}
