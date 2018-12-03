package com.consorcio.entidad;
import java.io.Serializable;
import java.util.ArrayList;
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
@Table(name="tb_boleta")
public class Boleta implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="num_bol")
	private int numBoleta;
	@Temporal(TemporalType.DATE)
	@Column(name="fec_emi_bol")
	private Date fechaEmision;
	@Column(name="monto_bol")
	private double monto;
	//relación muchos a uno "Boleta - Empleado"
	@ManyToOne
	@JoinColumn(name="cod_emp")
	private Empleado empleadoBoleta;
	//relación uno a muchos "Boleta - 
	//							MedicamentoHasBoleta"
	@OneToMany(mappedBy="boleta")
	private List<TourHasBoleta>listaHasBoleta=new ArrayList<TourHasBoleta>();
	public int getNumBoleta() {
		return numBoleta;
	}
	
	
	
	public void setNumBoleta(int numBoleta) {
		this.numBoleta = numBoleta;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	public Empleado getEmpleadoBoleta() {
		return empleadoBoleta;
	}
	public void setEmpleadoBoleta(Empleado empleadoBoleta) {
		this.empleadoBoleta = empleadoBoleta;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<TourHasBoleta> getListaHasBoleta() {
		return listaHasBoleta;
	}



	public void setListaHasBoleta(List<TourHasBoleta> listaHasBoleta) {
		this.listaHasBoleta = listaHasBoleta;
	}



	public TourHasBoleta addTourHasBoleta(TourHasBoleta tourHasBoleta) {
		getListaHasBoleta().add(tourHasBoleta);
		tourHasBoleta.setBoleta(this);

		return tourHasBoleta;
	}
	
}





