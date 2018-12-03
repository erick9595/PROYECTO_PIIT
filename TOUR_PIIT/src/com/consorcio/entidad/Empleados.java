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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tb_empleado")
public class Empleados implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_emp")
	private int codiEmpleado;
	@Column(name="nom_emp")
	private String nomEmpleado;
	@Column(name="ape_emp")
	private String apeEmpleado;
	@Column(name="sex_emp")
	private String sexoEmpleado;
	
	//relación muchos a uno "Empleado - Distrito"
	@ManyToOne
	@JoinColumn(name="cod_dis_emp")
	private Distrito distritoEmpleado;
	
	
	
	@ManyToOne
	@JoinColumn(name="cod_usu")
	private Usuarios usuarios;
	

	//Constructor
	 public Empleados() {
		distritoEmpleado = new Distrito();
		usuarios = new Usuarios();
	}
	
	

	
	
	
	
	
	
	public Usuarios getUsuarios() {
		return usuarios;
	}








	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}








		
		
	
	
	
	

	public int getCodiEmpleado() {
		return codiEmpleado;
	}








	public void setCodiEmpleado(int codiEmpleado) {
		this.codiEmpleado = codiEmpleado;
	}








	public String getNomEmpleado() {
		return nomEmpleado;
	}
	public void setNomEmpleado(String nomEmpleado) {
		this.nomEmpleado = nomEmpleado;
	}
	public String getApeEmpleado() {
		return apeEmpleado;
	}
	public void setApeEmpleado(String apeEmpleado) {
		this.apeEmpleado = apeEmpleado;
	}
	public String getSexoEmpleado() {
		return sexoEmpleado;
	}
	public void setSexoEmpleado(String sexoEmpleado) {
		this.sexoEmpleado = sexoEmpleado;
	}
	
	public Distrito getDistritoEmpleado() {
		return distritoEmpleado;
	}
	public void setDistritoEmpleado(Distrito distritoEmpleado) {
		this.distritoEmpleado = distritoEmpleado;
	}
	
	public Usuarios getUsuario() {
		return usuarios;
	}
	public void setUsuario(Usuarios usuario) {
		this.usuarios = usuario;
	}
	
	
}
