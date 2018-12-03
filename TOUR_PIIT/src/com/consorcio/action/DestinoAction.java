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
import com.consorcio.entidad.Destino;
import com.consorcio.entidad.Cliente;
import com.consorcio.entidad.Departamento;
import com.consorcio.modelo.modeloDepartamento;
import com.consorcio.modelo.modeloDestino;

import utils.Constantes;
@ManagedBean(name="CRUDDestino")
@ViewScoped
public class DestinoAction {
	//atributo para almacenar todos los tour
	private List<Destino> listaDestino;
	private List<Destino> listaDestino2;
	//Atributo para registrar
	private Destino destino;
	private Departamento departamento;
	//Atributo para almacenar los destinos
	private List<Departamento> listaDepartamento;
	
	//Atributo para referenciar la fila seleccionada del DataTable
	private UIData dtFila;
	
	
	
	
		//Metodo para registrar Bus
		public void registrarDestino(){
			new modeloDestino().addDestino(destino);
			Constantes.mensaje("Sistema","BUS REGISTRADO",
					FacesMessage.SEVERITY_INFO);	
		}
			
		//Método para actualizar tour
		public void actualizarDestino(){
			new modeloDestino().
				updateDestino(destino);
			Constantes.mensaje("Sistema","TOUR ACTUALIZADO",
					FacesMessage.SEVERITY_INFO);
		}
				
		
		//Método para eliminar tour
		public void eliminarDestino(){
			new modeloDestino().
			deleteDestino(destino.getCodDestino());
			Constantes.mensaje("Sistema","TOUR ELIMINADO",
					FacesMessage.SEVERITY_INFO);
		}
		
		
		
		
		
		//Método para vicular el valor del objeto "dtFila" con el objeto "destino"
		public void seleccionar(){
			destino=(Destino)dtFila.getRowData();
			
		}
		
		
	//Constructor
	public void nuevoDestino(){
		destino = new Destino();
	}
	
	
	//Constructor
	 public DestinoAction() {
		destino = new Destino();
	}
	
	
	
	
	
	public List<Destino> getListaDestino() {
		listaDestino = new modeloDestino().lista();
		return listaDestino;
	}

	public void setListaDestino(List<Destino> listaDestino) {
		this.listaDestino = listaDestino;
	}

	public List<Destino> getListaDestino2() {
		return listaDestino2;
	}

	public void setListaDestino2(List<Destino> listaDestino2) {
		this.listaDestino2 = listaDestino2;
	}

	public Destino getDestino() {
		return destino;
	}

	public void setDestino(Destino destino) {
		this.destino = destino;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Departamento> getListaDepartamento() {
		listaDepartamento = new modeloDepartamento().lista();
		return listaDepartamento;
	}

	public void setListaDepartamento(List<Departamento> listaDepartamento) {
		this.listaDepartamento = listaDepartamento;
	}


	public UIData getDtFila() {
		return dtFila;
	}


	public void setDtFila(UIData dtFila) {
		this.dtFila = dtFila;
	}




	
	
	
	
	
}
