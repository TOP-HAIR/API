package school.sptech.projetotophair.service.dto.servico.mapper;

import school.sptech.projetotophair.domain.servico.Servico;
import school.sptech.projetotophair.service.dto.empresa.mapper.EmpresaMapper;
import school.sptech.projetotophair.service.dto.servico.ServicoDto;
import school.sptech.projetotophair.service.dto.servico.ServicoEmpresaVinculadaDto;

public class ServicoMapper {
    public static ServicoDto toServicoDto(Servico entity){
        ServicoDto dto = new ServicoDto();

        dto.setIdServico(entity.getIdServico());
        dto.setNomeServico(entity.getNomeServico());
        dto.setPreco(entity.getPreco());
        dto.setQtdTempoServico(entity.getQtdTempoServico());
        dto.setDescricao(entity.getDescricao());

        return dto;
    }

    public static ServicoEmpresaVinculadaDto toServicoEmpresaVinculadaDto(Servico entity){
        ServicoEmpresaVinculadaDto dto = new ServicoEmpresaVinculadaDto();

        dto.setIdServico(entity.getIdServico());
        dto.setNomeServico(entity.getNomeServico());
        dto.setDescricao(entity.getDescricao());
        dto.setPreco(entity.getPreco());
        dto.setQtdTempoServico(entity.getQtdTempoServico());
        dto.setEmpresa(EmpresaMapper.toEmpresaDto(entity.getEmpresa()));

        return dto;
    }
}
