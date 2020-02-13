package springboothibernatejpasecurity.models;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_usuario;
	
	@Column(name="fecha_creacion")
	private LocalTime fecha_creacion;
	
	@NotBlank(message="Tiene que especificar al menos el nombre del usuario.")
	@Column(name="nombres")
	private String nombres;
	
	@Column(name="apellidos")
	private String apellidos;
	
	@NotBlank(message="Tiene que especificar el email del usuario.")
	@Column(name="email")
	private String email;
	
	@Column(name="tel")
	private int tel;
	
	@NotBlank(message="Tiene que especificar una constraseña para el usuario.")
	@Column(name="password")
	private String password;
	
	@ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
       name="user_role",
       joinColumns = {@JoinColumn(name="id_usuario", referencedColumnName="id_usuario")},
       inverseJoinColumns = {@JoinColumn(name="id_role", referencedColumnName="id_role")})
    private List<Role> Role;

	public Usuario(int id_usuario, LocalTime fecha_creacion, String nombres, String apellidos, String email, int tel, String password, List<Role> Role) {
		super();
		this.id_usuario = id_usuario;
		this.fecha_creacion = LocalTime.now();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.tel = tel;
		this.password = password;
		this.Role = Role;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public LocalTime getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(LocalTime fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return Role;
	}

	public void setRoles(List<Role> Role) {
		this.Role = Role;
	}
}
