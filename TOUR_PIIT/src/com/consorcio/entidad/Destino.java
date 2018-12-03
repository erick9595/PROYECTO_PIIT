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
@Table(name="tb_destino")
public class Destino implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_destino")
	private int codDestino;
	@Column(name="des_bus")
	private String nomBus;
	@Column(name="des_hotel")
	private String nomHotel;
	
	//relación muchos a uno "Cliente - Distrito"
	@ManyToOne
	@JoinColumn(name="cod_departamento")
	private Departamento departamentoDestino;
	
	
	@OneToMany(mappedBy="destino")
	private List<Tour> listaDestinoDepartamento;
	
	
	
	
	
	
	//Constructor
			public Destino(){
				departamentoDestino = new Departamento();
				
			}




			public int getCodDestino() {
				return codDestino;
			}




			public void setCodDestino(int codDestino) {
				this.codDestino = codDestino;
			}




			public String getNomBus() {
				return nomBus;
			}




			public void setNomBus(String nomBus) {
				this.nomBus = nomBus;
			}




			public String getNomHotel() {
				return nomHotel;
			}




			public void setNomHotel(String nomHotel) {
				this.nomHotel = nomHotel;
			}




			public Departamento getDepartamentoDestino() {
				return departamentoDestino;
			}




			public void setDepartamentoDestino(Departamento departamentoDestino) {
				this.departamentoDestino = departamentoDestino;
			}
	
	
	
			
			
			
	
	
	
	
}
