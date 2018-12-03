package com.consorcio.entidad;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="tb_tour_has_boleta")	
public class TourHasBoleta implements Serializable{
	
	@EmbeddedId
	private TourHasBoletaPK pk;
	@Column(name="can")
	private int cantidad;
	@Column(name="pre")
	private double precio;
	
	//relación muchos a uno "MedicamentoHasBoleta - 
	//							Boleta
	@ManyToOne
	@JoinColumn(name="num_bol", 
			referencedColumnName="num_bol",
			insertable=false, updatable=false)
	private Boleta boleta;
	
	
	
	
	//relación muchos a uno
	@ManyToOne
	@JoinColumn(name="cod_tour", 
			referencedColumnName="cod_tour",
			insertable=false, updatable=false)
	private Tour tour;


	
	
	
	
	
	
	
	
	


	public TourHasBoletaPK getPk() {
		return pk;
	}




	public void setPk(TourHasBoletaPK pk) {
		this.pk = pk;
	}




	public int getCantidad() {
		return cantidad;
	}




	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}




	public double getPrecio() {
		return precio;
	}




	public void setPrecio(double precio) {
		this.precio = precio;
	}








	public Boleta getBoleta() {
		return boleta;
	}




	public void setBoleta(Boleta boleta) {
		this.boleta = boleta;
	}




	public Tour getTour() {
		return tour;
	}




	public void setTour(Tour tour) {
		this.tour = tour;
	}

	

	
	
	
	
	
	
	
}


