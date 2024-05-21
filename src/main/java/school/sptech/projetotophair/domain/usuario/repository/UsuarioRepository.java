package school.sptech.projetotophair.domain.usuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import school.sptech.projetotophair.domain.endereco.Endereco;
import school.sptech.projetotophair.domain.usuario.Usuario;

import java.util.List;
import java.util.Optional;
@EnableJpaRepositories
@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Long> {

    Usuario findByIdUsuario(Long idUsuario);
    Optional<Usuario> findByEmail(String email);
    boolean existsByEmail(String email);
    @Query("SELECT u FROM Usuario u JOIN u.avaliacoes a WHERE a.idAvaliacao = :avaliacaoId")
    Usuario findByAvaliacaoId(@Param("avaliacaoId") Long avaliacaoId);

    @Query("SELECT u.endereco FROM Usuario u WHERE u.idUsuario = :usuarioId")
    Optional<Endereco> findEnderecoByUsuarioId(Long usuarioId);

    @Query("SELECT u FROM Usuario u WHERE u.empresa.idEmpresa = :idEmpresa")
    List<Usuario> findAllByEmpresaId(@Param("idEmpresa") Long idEmpresa);
}
