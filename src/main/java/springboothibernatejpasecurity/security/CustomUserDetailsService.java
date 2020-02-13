package springboothibernatejpasecurity.security;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import springboothibernatejpasecurity.models.Usuario;
import springboothibernatejpasecurity.repository.UsuarioRepository;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	private static Collection<? extends GrantedAuthority> getAuthorities(Usuario usuario) {
        String[] userRoles = usuario.getRoles().stream().map((role) -> role.getName()).toArray(String[]::new);
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRoles);
        return authorities;
    }
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		Usuario usuario = usuarioRepository.findByEmail(userName)
				.orElseThrow(() -> new UsernameNotFoundException("EMAIL " + userName + " NOT FOUND."));
				return new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getPassword(), getAuthorities(usuario));
	}
}
