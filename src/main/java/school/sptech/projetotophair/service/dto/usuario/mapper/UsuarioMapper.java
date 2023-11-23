package school.sptech.projetotophair.service.dto.usuario.mapper;

import school.sptech.projetotophair.domain.empresa.Empresa;
import school.sptech.projetotophair.domain.endereco.Endereco;
import school.sptech.projetotophair.domain.usuario.Usuario;
import school.sptech.projetotophair.service.autenticacao.dto.UsuarioTokenDto;
import school.sptech.projetotophair.service.dto.empresa.EmpresaDto;
import school.sptech.projetotophair.service.dto.empresa.mapper.EmpresaMapper;
import school.sptech.projetotophair.service.dto.usuario.UsuarioAvaliacaoResponseDto;
import school.sptech.projetotophair.service.dto.usuario.UsuarioCriacaoDto;
import school.sptech.projetotophair.service.dto.usuario.UsuarioEnderecoVinculadoDto;
import school.sptech.projetotophair.service.dto.usuario.UsuarioResponseDto;

public class UsuarioMapper {

    public static UsuarioAvaliacaoResponseDto toUsuarioAvaliacaoResponseDto(Usuario entity){
        UsuarioAvaliacaoResponseDto dto = new UsuarioAvaliacaoResponseDto();

        dto.setIdUsuario(entity.getIdUsuario());
        dto.setNomeCompleto(entity.getNomeCompleto());
        dto.setEmail(entity.getEmail());
        dto.setCpf(entity.getCpf());
        dto.setTelefone(entity.getTelefone());
        dto.setIsProfissional(entity.getProfissional());

        return dto;
    }

    public static Usuario of(UsuarioCriacaoDto usuarioCriacaoDto) {
        Usuario usuario = new Usuario();

        usuario.setEmail(usuarioCriacaoDto.getEmail());
        usuario.setCpf(usuarioCriacaoDto.getCpf());
        usuario.setNomeCompleto(usuarioCriacaoDto.getNomeCompleto());
        usuario.setSenha(usuarioCriacaoDto.getSenha());
        usuario.setProfissional(usuarioCriacaoDto.getProfissional());
        usuario.setEmpresa(usuarioCriacaoDto.getEmpresa());

        return usuario;
    }

    public static UsuarioTokenDto of(Usuario usuario, String token) {
        UsuarioTokenDto usuarioTokenDto = new UsuarioTokenDto();

        usuarioTokenDto.setUserId(usuario.getIdUsuario());
        usuarioTokenDto.setEmail(usuario.getEmail());
        usuarioTokenDto.setNomeCompleto(usuario.getNomeCompleto());
        usuarioTokenDto.setToken(token);

        return usuarioTokenDto;
    }

    public static UsuarioResponseDto toUsuarioResponseDto(Usuario entity){
        UsuarioResponseDto dto = new UsuarioResponseDto();

        dto.setIdUsuario(entity.getIdUsuario());
        dto.setNomeCompleto(entity.getNomeCompleto());
        dto.setEmail(entity.getEmail());
        dto.setCpf(entity.getCpf());
        dto.setTelefone(entity.getTelefone());

        return dto;
    }

    public static UsuarioEmpresaVinculadaDto toUsuarioEmpresaVinculadaDto(Usuario usuarioEntity, Empresa empresaEntity){
        UsuarioEmpresaVinculadaDto dto = new UsuarioEmpresaVinculadaDto();

        dto.setIdUsuario(usuarioEntity.getIdUsuario());
        dto.setEmail(usuarioEntity.getEmail());
        dto.setNomeCompleto(usuarioEntity.getNomeCompleto());
        dto.setCpf(usuarioEntity.getCpf());
        dto.setIsProfissional(usuarioEntity.getProfissional());
        dto.setTelefone(usuarioEntity.getTelefone());
        dto.setEmpresa(EmpresaMapper.toEmpresaDto(empresaEntity));
        dto.setEndereco(usuarioEntity.getEndereco());

        return dto;
    }

    public static UsuarioEnderecoVinculadoDto toUsuarioEnderecoVinculadoDto(Usuario usuarioEntity, Endereco enderecoEntity){
        UsuarioEnderecoVinculadoDto dto = new UsuarioEnderecoVinculadoDto();

        dto.setIdUsuario(usuarioEntity.getIdUsuario());
        dto.setEmail(usuarioEntity.getEmail());
        dto.setNomeCompleto(usuarioEntity.getNomeCompleto());
        dto.setCpf(usuarioEntity.getCpf());
        dto.setTelefone(usuarioEntity.getTelefone());
        dto.setIsProfissional(usuarioEntity.getProfissional());
        dto.setEndereco(enderecoEntity);

        return dto;
    }
}
