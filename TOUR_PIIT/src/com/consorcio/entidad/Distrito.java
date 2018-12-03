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
@Table(name="tb_distrito")
public class Distrito implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_dis")
	private int codDistrito;
	@Column(name="nom_dis")
	private String nomDistrito;
	
	
	//relación uno a muchos "Distrito - Cliente"
	@OneToMany(mappedBy="distritoCliente")
	private List<Cliente> listaClienteDistrito;
	//relación uno a muchos "Distrito - Empleado"
	@OneToMany(mappedBy="distritoEmpleado")
	private List<Empleado> listaEmpleadoDistrito;
	
	
	
	
	
	
	
	
	public int getCodDistrito() {
		return codDistrito;
	}
	public void setCodDistrito(int codDistrito) {
		this.codDistrito = codDistrito;
	}
	public String getNomDistrito() {
		return nomDistrito;
	}
	public void setNomDistrito(String nomDistrito) {
		this.nomDistrito = nomDistrito;
	}
	public List<Cliente> getListaClienteDistrito() {
		return listaClienteDistrito;
	}
	public void setListaClienteDistrito(List<Cliente> listaClienteDistrito) {
		this.listaClienteDistrito = listaClienteDistrito;
	}
	public List<Empleado> getListaEmpleadoDistrito() {
		return listaEmpleadoDistrito;
	}
	public void setListaEmpleadoDistrito(List<Empleado> listaEmpleadoDistrito) {
		this.listaEmpleadoDistrito = listaEmpleadoDistrito;
	}
}









