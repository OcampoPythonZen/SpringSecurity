package springboothibernatejpasecurity.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id_message;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="valor")
	private int valor;
	
	@NotBlank(message="Tiene que especificar al menos el nombre del privilegio.")
	@Column(nullable = false)
    private String content;

	public Message(int id_message, String nombre, int valor, String content) {
		super();
		this.id_message = id_message;
		this.nombre = nombre;
		this.valor = valor;
		this.content = content;
	}

	public int getId_message() {
		return id_message;
	}

	public void setId_message(int id_message) {
		this.id_message = id_message;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
