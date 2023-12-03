package school.sptech.projetotophair.service.dto.arquivo.mapper;

import school.sptech.projetotophair.domain.arquivo.Arquivo;
import school.sptech.projetotophair.service.dto.arquivo.ArquivoDto;
import school.sptech.projetotophair.service.dto.arquivo.ArquivoEmpresaVinculadaDto;
import school.sptech.projetotophair.service.dto.empresa.mapper.EmpresaMapper;

public class ArquivoMapper {
    public static ArquivoDto toArquivoDto(Arquivo entity){
        ArquivoDto dto = new ArquivoDto();
        dto.setId(entity.getId());
        dto.setNomeArquivoOriginal(entity.getNomeArquivoOriginal());
        dto.setNomeArquivoOriginal(entity.getNomeArquivoOriginal());
        dto.setDataUpload(entity.getDataUpload());

        return dto;
    }

    public static ArquivoEmpresaVinculadaDto toArquivoEmpresaVinculadaDto(Arquivo entity){
        ArquivoEmpresaVinculadaDto dto = new ArquivoEmpresaVinculadaDto();
        dto.setId(entity.getId());
        dto.setNomeArquivoOriginal(entity.getNomeArquivoOriginal());
        dto.setNomeArquivoOriginal(entity.getNomeArquivoOriginal());
        dto.setDataUpload(entity.getDataUpload());
        dto.setEmpresaDto(EmpresaMapper.toEmpresaDto(entity.getEmpresa()));

        return dto;
    }
}
