package springboothibernatejpasecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import springboothibernatejpasecurity.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	Optional<Usuario> findByEmail(String email);
}
