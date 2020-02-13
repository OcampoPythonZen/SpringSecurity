package springboothibernatejpasecurity.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_role;
    
    @NotBlank(message="Tiene que especificar el nombre del Role.")
    @Column(nullable = false, unique = true)
    private String name;

    @ManyToMany(mappedBy="Role")
    private List <Usuario> usuario;

	public Role(int id_role, String name, List<Usuario> usuario) {
		super();
		this.id_role = id_role;
		this.name = name;
		this.usuario = usuario;
	}

	public int getId_role() {
		return id_role;
	}

	public void setId_role(int id_role) {
		this.id_role = id_role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}
}