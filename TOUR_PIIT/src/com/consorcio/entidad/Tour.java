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
@Table(name="tb_tour")
public class Tour implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cod_tour")
	private int codTour;
	@Column(name="nom_tour")
	private String nomTour;
	@Column(name="stock_med")
	private int stockTour;
	@Column(name="pre_rutas")
	private double precioTour;
	@Temporal(TemporalType.DATE)
	@Column(name="fec_rutas")
	private Date fechaViaje;//Date paquete java.util
	@Column
	private byte[]foto;
	//atributo no sera mapeado
	@Transient
	private String imagen;
	
	
	
	
	
	
	//relación muchos a uno
	@ManyToOne
	@JoinColumn(name="cod_destino")//nombre de la columna "llave fk"
	private Destino destino;
	
	
	//relación uno a muchos 
	@OneToMany(mappedBy="tour")
	private List<TourHasBoleta>
					listaTourHasBoleta;
	
	
	//Constructor
		public Tour(){
			destino = new Destino();
			
		}

		
		

		public int getCodTour() {
			return codTour;
		}


		public void setCodTour(int codTour) {
			this.codTour = codTour;
		}


		public String getNomTour() {
			return nomTour;
		}


		public void setNomTour(String nomTour) {
			this.nomTour = nomTour;
		}


		public int getStockTour() {
			return stockTour;
		}


		public void setStockTour(int stockTour) {
			this.stockTour = stockTour;
		}


		public double getPrecioTour() {
			return precioTour;
		}


		public void setPrecioTour(double precioTour) {
			this.precioTour = precioTour;
		}


		public Date getFechaViaje() {
			return fechaViaje;
		}


		public void setFechaViaje(Date fechaViaje) {
			this.fechaViaje = fechaViaje;
		}


		public byte[] getFoto() {
			return foto;
		}


		public void setFoto(byte[] foto) {
			this.foto = foto;
		}


		public String getImagen() {
			return imagen;
		}


		public void setImagen(String imagen) {
			this.imagen = imagen;
		}

		
	

		public List<TourHasBoleta> getListaTourHasBoleta() {
			return listaTourHasBoleta;
		}


		public void setListaTourHasBoleta(List<TourHasBoleta> listaTourHasBoleta) {
			this.listaTourHasBoleta = listaTourHasBoleta;
		}




		public Destino getDestino() {
			return destino;
		}




		public void setDestino(Destino destino) {
			this.destino = destino;
		}
	
		
		
		
		



	
	
}






