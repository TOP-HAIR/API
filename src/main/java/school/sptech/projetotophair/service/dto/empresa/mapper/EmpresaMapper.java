package school.sptech.projetotophair.service.dto.empresa.mapper;

import school.sptech.projetotophair.domain.avaliacao.Avaliacao;
import school.sptech.projetotophair.domain.empresa.Empresa;
import school.sptech.projetotophair.service.dto.avaliacao.AvaliacaoResponseDto;
import school.sptech.projetotophair.service.dto.avaliacao.mapper.AvaliacaoMapper;
import school.sptech.projetotophair.service.dto.empresa.EmpresaAvaliacaoDto;
import school.sptech.projetotophair.service.dto.empresa.EmpresaDto;

import java.util.ArrayList;
import java.util.List;

public class EmpresaMapper {
    public static EmpresaDto toEmpresaDto(Empresa entity){
        EmpresaDto dto = new EmpresaDto();

        dto.setIdEmpresa(entity.getIdEmpresa());
        dto.setCnpj(entity.getCnpj());
        dto.setRazaoSocial(entity.getRazaoSocial());

        return dto;
    }

    public static EmpresaAvaliacaoDto toEmpresaAvaliacaoDto(Empresa entity){
        EmpresaAvaliacaoDto dto = new EmpresaAvaliacaoDto();

        List<Avaliacao> avaliacoes = entity.getAvaliacoes();
        List<AvaliacaoResponseDto> dtosAvaliacao = new ArrayList<>();

        for (Avaliacao avaliacaoAtual: avaliacoes) {
            dtosAvaliacao.add(AvaliacaoMapper.toAvaliacaoResponseDto(avaliacaoAtual));
        }

        dto.setIdEmpresa(entity.getIdEmpresa());
        dto.setRazaoSocial(entity.getRazaoSocial());
        dto.setAvaliacoes(dtosAvaliacao);

        return dto;
    }
}
