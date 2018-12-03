package com.consorcio.entidad;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
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
import javax.persistence.Transient;
@Entity
@Table(name="tb_departamento")
public class Departamento implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_departamento")
	private int codDepartamento;
	@Column(name="departamentos")
	private String nomDepartamento;
		
	
	
	//relación uno a muchos "Distrito - Cliente"
	@OneToMany(mappedBy="departamentoDestino")
	private List<Destino> listaDestinoDepartamento;



	
	
	
	
	
	
	
	
	
	
	public int getCodDepartamento() {
		return codDepartamento;
	}



	public void setCodDepartamento(int codDepartamento) {
		this.codDepartamento = codDepartamento;
	}



	public String getNomDepartamento() {
		return nomDepartamento;
	}



	public void setNomDepartamento(String nomDepartamento) {
		this.nomDepartamento = nomDepartamento;
	}



	public List<Destino> getListaDestinoDepartamento() {
		return listaDestinoDepartamento;
	}



	public void setListaDestinoDepartamento(List<Destino> listaDestinoDepartamento) {
		this.listaDestinoDepartamento = listaDestinoDepartamento;
	}
	
	


	



	



	
		
		



	
	
}






