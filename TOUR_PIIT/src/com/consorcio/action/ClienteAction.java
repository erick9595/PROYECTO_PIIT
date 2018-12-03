package com.consorcio.action;
import java.io.FileOutputStream;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.component.api.UIData;
import org.primefaces.event.FileUploadEvent;

import com.consorcio.entidad.Cliente;
import com.consorcio.entidad.Distrito;

import com.consorcio.modelo.modeloCliente;
import com.consorcio.modelo.modeloDistrito;


import utils.Constantes;
@ManagedBean(name="CRUDCliente")
@ViewScoped
public class ClienteAction {
	//atributo para almacenar todos los medicamentos
	private List<Cliente> listaCliente;
	private List<Cliente> listaCliente2;
	//Atributo para registrar
	private Cliente cliente;
	//Atributo para almacenar los laboratorios
	private List<Distrito> listaDistrito;
	//Atributo para referenciar la fila seleccionada del DataTable
	private UIData dtFila;


	private String codCliente;
	

	
	//Metodo para registrar medicamentos
	public void registrarCliente(){
		new modeloCliente().addCliente(cliente);
		Constantes.mensaje("Sistema","CLIENTE REGISTRADO",
					FacesMessage.SEVERITY_INFO);
		//return "/ui/listaMedicamento.jsf";
	}
	//Método para actualizar medicamento
	public void actualizarCliente(){
		new modeloCliente().
			updateCliente(cliente);
		Constantes.mensaje("Sistema","CLIENTE ACTUALIZADO",
				FacesMessage.SEVERITY_INFO);
	}
	//Método para eliminar medicamento
	public void eliminarCliente(){
		new modeloCliente().
		deleteCliente(cliente.getCodCliente());
		Constantes.mensaje("Sistema","CLIENTE ELIMINADO",
				FacesMessage.SEVERITY_INFO);
	}

	
	//Método para vicular el valor del objeto "dtFila" con el objeto "medicamento"
	public void seleccionar(){
		cliente=(Cliente)dtFila.getRowData();

		
	}

	public void nuevoCliente(){
		cliente = new Cliente();
	}
	
	//Constructor
	public ClienteAction(){
		cliente = new Cliente();
	}
	
	
	

	
	
	public List<Cliente> getListaCliente() {
		listaCliente=new modeloCliente().lista();
		return listaCliente;
	}
	
	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}
	
	
	
	public List<Cliente> getListaCliente2() {
		return listaCliente2;
	}
	public void setListaCliente2(List<Cliente> listaCliente2) {
		this.listaCliente2 = listaCliente2;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Distrito> getListaDistrito() {
		listaDistrito=new modeloDistrito().lista();
		return listaDistrito;
	}
	public void setListaDistrito(List<Distrito> listaDistrito) {
		this.listaDistrito = listaDistrito;
	}
	public String getCodCliente() {
		return codCliente;
	}
	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}
	
	
	public UIData getDtFila() {
		return dtFila;
	}
	public void setDtFila(UIData dtFila) {
		this.dtFila = dtFila;
	}

	

	
	
	
	
	
}
