package com.consorcio.entidad;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="tb_rol")
public class Roles implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idrol")
	private int codRol;
	@Column(name="descripcion")
	private String nomRol;
	
	
	
	
	//relación uno a muchos "Distrito - Cliente"
	@OneToMany(mappedBy="rolUsuario")
	private List<Usuarios> listaUsuarioRol;



	

	
	
	

	public int getCodRol() {
		return codRol;
	}




	public void setCodRol(int codRol) {
		this.codRol = codRol;
	}




	public String getNomRol() {
		return nomRol;
	}




	public void setNomRol(String nomRol) {
		this.nomRol = nomRol;
	}




	public List<Usuarios> getListaUsuarioRol() {
		return listaUsuarioRol;
	}




	public void setListaUsuarioRol(List<Usuarios> listaUsuarioRol) {
		this.listaUsuarioRol = listaUsuarioRol;
	}




	

	
	
	
	
	
	
	
	
}









