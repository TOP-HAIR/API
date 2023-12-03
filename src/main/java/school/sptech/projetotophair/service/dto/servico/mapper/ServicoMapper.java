package school.sptech.projetotophair.service.dto.servico.mapper;

import school.sptech.projetotophair.domain.servico.Servico;
import school.sptech.projetotophair.service.dto.empresa.mapper.EmpresaMapper;
import school.sptech.projetotophair.service.dto.endereco.mapper.EnderecoMapper;
import school.sptech.projetotophair.service.dto.servico.ServicoDto;
import school.sptech.projetotophair.service.dto.servico.ServicoEmpresaVinculadaDto;
import school.sptech.projetotophair.service.dto.servico.ServicoEnderecoDto;

public class ServicoMapper {
    public static ServicoDto toServicoDto(Servico entity){
        ServicoDto dto = new ServicoDto();

        dto.setIdServico(entity.getIdServico());
        dto.setNomeServico(entity.getNomeServico());
        dto.setCategoria(entity.getCategoria());
        dto.setPreco(entity.getPreco());
        dto.setQtdTempoServico(entity.getQtdTempoServico());
        dto.setDescricao(entity.getDescricao());

        return dto;
    }

    public static ServicoEmpresaVinculadaDto toServicoEmpresaVinculadaDto(Servico entity){
        ServicoEmpresaVinculadaDto dto = new ServicoEmpresaVinculadaDto();

        dto.setIdServico(entity.getIdServico());
        dto.setNomeServico(entity.getNomeServico());
        dto.setCategoria(entity.getCategoria());
        dto.setDescricao(entity.getDescricao());
        dto.setPreco(entity.getPreco());
        dto.setQtdTempoServico(entity.getQtdTempoServico());
        dto.setEmpresa(EmpresaMapper.toEmpresaDto(entity.getEmpresa()));

        return dto;
    }

    public static ServicoEnderecoDto toServicoEndereco(Servico entity){
        ServicoEnderecoDto dto = new ServicoEnderecoDto();

        dto.setIdEmpresa(entity.getEmpresa().getIdEmpresa());
        dto.setCnpj(entity.getEmpresa().getCnpj());
        dto.setRazaoSocial(entity.getEmpresa().getRazaoSocial());
        dto.setTipoServico(entity.getTipoServico());
        dto.setEstado(entity.getEndereco().getEstado());

        return dto;
    }
}
