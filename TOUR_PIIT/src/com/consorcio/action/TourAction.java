package com.consorcio.action;
import java.io.FileOutputStream;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.component.api.UIData;
import org.primefaces.event.FileUploadEvent;
import com.consorcio.entidad.Departamento;
import com.consorcio.entidad.Destino;
import com.consorcio.entidad.Tour;
import com.consorcio.modelo.modeloDepartamento;
import com.consorcio.modelo.modeloDestino;

import com.consorcio.modelo.modeloTour;

import utils.Constantes;
@ManagedBean(name="CRUDTour")
@ViewScoped
public class TourAction {
	//atributo para almacenar todos los tour
	private List<Tour> listaTour;
	private List<Tour> listaTour2;
	//Atributo para registrar
	private Tour tour;
	//Atributo para almacenar las rutas
	private List<Destino> listaDestino;
	
	private List<Departamento> listaDepartamento;
	

	//Atributo para referenciar la fila seleccionada del DataTable
	private UIData dtFila;
	
	
	private String codDepartamento;
	
	
	
	public void consultaXDestino(){
		System.out.println("----"+codDepartamento);
		listaTour2=new modeloTour().listaXDestino
				(Integer.parseInt(codDepartamento));
	}
	
	
	
	
	
	
	
	//Metodo para registrar tour
		public void registrarTour(){
			new modeloTour().addTour(tour);
			Constantes.mensaje("Sistema","TOUR REGISTRADO",
						FacesMessage.SEVERITY_INFO);	
		}
		
		
		
		//Método para actualizar tour
		public void actualizarTour(){
			new modeloTour().
				updateTour(tour);
			Constantes.mensaje("Sistema","TOUR ACTUALIZADO",
					FacesMessage.SEVERITY_INFO);
		}
				
		
		//Método para eliminar tour
		public void eliminarTour(){
			new modeloTour().
			deleteTour(tour.getCodTour());
			Constantes.mensaje("Sistema","TOUR ELIMINADO",
					FacesMessage.SEVERITY_INFO);
		}
		
		
		
		//método para setear la foto del medicamento
		public void subirFoto(FileUploadEvent event){
			tour.setFoto(event.getFile().getContents());
		}
		
		
		
		
		//Método para vicular el valor del objeto "dtFila" con el objeto "medicamento"
		public void seleccionar(){
			tour=(Tour)dtFila.getRowData();
			mostrarImagen();
		}
		
		
		
		
		
		
		public void mostrarImagen() {
			//1 Obtiene la ruta del servidor
			ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
			String realPath=(String) servletContext.getRealPath("/"); 
			//2 Construye el archivo con los bytes que esta en la BD 
			try {
				String rutaFile = realPath+"\\"+ 
						tour.getCodTour() +".jpg";
				
				tour.setImagen(
						tour.getCodTour() +".jpg");
				
				System.out.println("Imagen -> " + rutaFile);
				
				
				if(tour.getFoto()!=null){
					FileOutputStream fileOuputStream = 
						new FileOutputStream(rutaFile);
					fileOuputStream.write(tour.getFoto());
					fileOuputStream.close();
				}	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	

	
	
	
	
	
	
	
	
	
	
	
	public void nuevoTour(){
		tour = new Tour();
	}
	
	//Constructor
	public TourAction(){
		tour = new Tour();
	}
	
	
	
	
	
	
	
	
	
	
	
	

	
	public List<Tour> getListaTour() {
		listaTour=new modeloTour().lista();
		return listaTour;
	}




	public void setListaTour(List<Tour> listaTour) {
		this.listaTour = listaTour;
	}




	public List<Tour> getListaTour2() {
		return listaTour2;
	}




	public void setListaTour2(List<Tour> listaTour2) {
		this.listaTour2 = listaTour2;
	}




	public Tour getTour() {
		return tour;
	}




	public void setTour(Tour tour) {
		this.tour = tour;
	}



	
	
	
	
	
	
	
	




	public List<Departamento> getListaDepartamento() {
		listaDepartamento 
		= new modeloDepartamento().lista();
		return listaDepartamento;
	}







	public void setListaDepartamento(List<Departamento> listaDepartamento) {
		this.listaDepartamento = listaDepartamento;
	}







	public String getCodDepartamento() {
		return codDepartamento;
	}







	public void setCodDepartamento(String codDepartamento) {
		this.codDepartamento = codDepartamento;
	}







	public UIData getDtFila() {
		return dtFila;
	}




	public void setDtFila(UIData dtFila) {
		this.dtFila = dtFila;
	}







	public List<Destino> getListaDestino() {
		listaDestino = new modeloDestino().lista();
		return listaDestino;
	}







	public void setListaDestino(List<Destino> listaDestino) {
		this.listaDestino = listaDestino;
	}






	
	
	
	
	
	
	
	
	
	
	








	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
