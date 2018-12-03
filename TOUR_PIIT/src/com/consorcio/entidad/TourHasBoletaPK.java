package com.consorcio.entidad;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class TourHasBoletaPK implements Serializable{
	@Column(name="num_bol")
	private int numBoleta;
	@Column(name="cod_tour")
	private int codTour;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codTour;
		result = prime * result + numBoleta;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TourHasBoletaPK other = (TourHasBoletaPK) obj;
		if (codTour != other.codTour)
			return false;
		if (numBoleta != other.numBoleta)
			return false;
		return true;
	}
	
	
	
	
	
	
	
	public int getNumBoleta() {
		return numBoleta;
	}
	public void setNumBoleta(int numBoleta) {
		this.numBoleta = numBoleta;
	}
	public int getCodTour() {
		return codTour;
	}
	public void setCodTour(int codTour) {
		this.codTour = codTour;
	}

	
	
	
	
	
}









