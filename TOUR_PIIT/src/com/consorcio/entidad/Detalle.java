package com.consorcio.entidad;
public class Detalle {
	private int codMed;
	private String nomMed;
	private int cantidad;
	private double precio;
	
	public double getImporte(){
		return cantidad*precio;
	}
	public int getCodMed() {
		return codMed;
	}
	public void setCodMed(int codMed) {
		this.codMed = codMed;
	}
	public String getNomMed() {
		return nomMed;
	}
	public void setNomMed(String nomMed) {
		this.nomMed = nomMed;
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

	
	

}
