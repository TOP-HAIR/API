package school.sptech.projetotophair.service.dto.empresa.mapper;

import school.sptech.projetotophair.domain.arquivo.Arquivo;
import school.sptech.projetotophair.domain.avaliacao.Avaliacao;
import school.sptech.projetotophair.domain.empresa.Empresa;
import school.sptech.projetotophair.service.dto.arquivo.ArquivoDto;
import school.sptech.projetotophair.service.dto.arquivo.mapper.ArquivoMapper;
import school.sptech.projetotophair.service.dto.avaliacao.AvaliacaoResponseDto;
import school.sptech.projetotophair.service.dto.avaliacao.mapper.AvaliacaoMapper;
import school.sptech.projetotophair.service.dto.empresa.*;
import school.sptech.projetotophair.service.dto.endereco.EnderecoDto;
import school.sptech.projetotophair.service.dto.endereco.mapper.EnderecoMapper;

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

    public static EmpresaAvaliacaoDto toEmpresaAvaliacaoDto(Empresa entity) {
        EmpresaAvaliacaoDto dto = new EmpresaAvaliacaoDto();

        List<Avaliacao> avaliacoes = entity.getAvaliacoes();
        List<AvaliacaoResponseDto> dtosAvaliacao = new ArrayList<>();

        assert avaliacoes != null;
        for (Avaliacao avaliacaoAtual : avaliacoes) {
            dtosAvaliacao.add(AvaliacaoMapper.toAvaliacaoResponseDto(avaliacaoAtual));
        }

        dto.setIdEmpresa(entity.getIdEmpresa());
        dto.setRazaoSocial(entity.getRazaoSocial());
        dto.setAvaliacoes(dtosAvaliacao);
        assert entity.getEndereco() != null;
        dto.setEndereco(EnderecoMapper.toEnderecoDto(entity.getEndereco()));

        if (!dtosAvaliacao.isEmpty()) {
            double media = dtosAvaliacao.stream()
                    .mapToDouble(AvaliacaoResponseDto::getNivel)
                    .average()
                    .orElse(0.0);
            dto.setMediaNivelAvaliacoes(media);
        } else {
            dto.setMediaNivelAvaliacoes(0.0);
        }

        return dto;
    }


    public static EmpresaEnderecoVinculadoDto toEmpresaEnderecoVinculadoDto(Empresa empresaEntity){
        EmpresaEnderecoVinculadoDto dto = new EmpresaEnderecoVinculadoDto();

        dto.setEndereco(EnderecoMapper.toEnderecoDto(empresaEntity.getEndereco()));
        dto.setCnpj(empresaEntity.getCnpj());
        dto.setIdEmpresa(empresaEntity.getIdEmpresa());
        dto.setRazaoSocial(empresaEntity.getRazaoSocial());

        return dto;
    }

    public static EmpresaPorEstadoDto toEmpresaPorEstadoDto(Empresa entity){
        EmpresaPorEstadoDto dto = new EmpresaPorEstadoDto();

        dto.setIdEmpresa(entity.getIdEmpresa());
        dto.setCnpj(entity.getCnpj());
        dto.setRazaoSocial(entity.getRazaoSocial());
        dto.setEndereco(EnderecoMapper.toEnderecoDto(entity.getEndereco()));

        return dto;
    }

    public static EmpresaComImagensDto toEmpresaComImagensDto(Empresa entity){
        EmpresaComImagensDto dtos = new EmpresaComImagensDto();
        List<Arquivo> arquivos = entity.getArquivos();
        List<ArquivoDto> arquivoDtos = new ArrayList<>();

        for (Arquivo arquivoDaVez: arquivos) {
            arquivoDtos.add(ArquivoMapper.toArquivoDto(arquivoDaVez));
        }

        dtos.setIdEmpresa(entity.getIdEmpresa());
        dtos.setRazaoSocial(entity.getRazaoSocial());
        dtos.setCnpj(entity.getCnpj());;
        dtos.setArquivos(arquivoDtos);

        return dtos;
    }
}
