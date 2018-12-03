package com.consorcio.entidad;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="tb_usuario")
public class Usuarios implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_usu")
	private int codiUsuario;
	@Column(name="login")
	private String logUsuario;
	@Column(name="password")
	private String passUsuario;

	
	
	
	@OneToMany(mappedBy="usuarios")
	private List<Empleados> listaEmpleadoUsuario;
	
	

	
	//relación muchos a uno "Usuario - Roles"
	@ManyToOne
	@JoinColumn(name="idrol")
	private Roles rolUsuario;


	
	
	
	
	
	
	
	//Constructor
			public Usuarios(){
				rolUsuario = new Roles();
				
			}

			
			
			
			
			
	









			public List<Empleados> getListaEmpleadoUsuario() {
				return listaEmpleadoUsuario;
			}
















			public void setListaEmpleadoUsuario(List<Empleados> listaEmpleadoUsuario) {
				this.listaEmpleadoUsuario = listaEmpleadoUsuario;
			}
















	
			
			
			
			



			public String getLogUsuario() {
				return logUsuario;
			}




			public void setLogUsuario(String logUsuario) {
				this.logUsuario = logUsuario;
			}




			public String getPassUsuario() {
				return passUsuario;
			}




			public void setPassUsuario(String passUsuario) {
				this.passUsuario = passUsuario;
			}














			public Roles getRolUsuario() {
				return rolUsuario;
			}














			public void setRolUsuario(Roles rolUsuario) {
				this.rolUsuario = rolUsuario;
			}
















			public int getCodiUsuario() {
				return codiUsuario;
			}
















			public void setCodiUsuario(int codiUsuario) {
				this.codiUsuario = codiUsuario;
			}
































	
	
	
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	
}
