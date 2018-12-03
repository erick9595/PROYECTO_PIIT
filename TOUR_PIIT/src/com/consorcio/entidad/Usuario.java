package com.consorcio.entidad;
import java.io.Serializable;
import javax.persistence.*;
@Entity
@Table(name="tb_usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_usu")
	private int codUsuario;
	private String login;
	private String password;

	@ManyToOne
	@JoinColumn(name="idRol")
	private Rol rol;
	@OneToOne(mappedBy="usuario")
	private Empleado empleado;
	
	
	
	
	
	
	//constructor
	
	public Usuario() {
		rol = new Rol();
	
	}
	
	
	
	
	public int getCodUsuario() {
		return codUsuario;
	}
	public void setCodUsuario(int codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getLogin() {
		return this.login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public Empleado getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	
}