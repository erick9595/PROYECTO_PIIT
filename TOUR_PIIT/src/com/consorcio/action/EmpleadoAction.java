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
import com.consorcio.entidad.Empleado;
import com.consorcio.entidad.Empleados;

import com.consorcio.entidad.Rol;

import com.consorcio.entidad.Usuario;
import com.consorcio.entidad.Usuarios;
import com.consorcio.modelo.modeloCliente;
import com.consorcio.modelo.modeloDistrito;
import com.consorcio.modelo.modeloEmpleado;

import com.consorcio.modelo.modeloLogin;

import com.consorcio.modelo.modeloRol;

import com.consorcio.modelo.modeloUsuario;

import utils.Constantes;
@ManagedBean(name="CRUDEmpleados")
@ViewScoped
public class EmpleadoAction {
	//atributo para almacenar todos los medicamentos
	private List<Empleados> listaEmpleado;
	private List<Empleados> listaEmpleado2;
	//Atributo para registrar
	private Empleados empleado;
	//Atributo para almacenar los laboratorios
	private List<Distrito> listaDistrito;
	private List<Usuarios> listaUsuarios;
	//Atributo para referenciar la fila seleccionada del DataTable
	private UIData dtFila;


	private String codEmpleado;
	

	
	//Metodo para registrar medicamentos
	public void registrarEmpleado(){
		new modeloEmpleado().addEmpleado(empleado);
		Constantes.mensaje("Sistema","EMPLEADO REGISTRADO",
					FacesMessage.SEVERITY_INFO);
		//return "/ui/listaMedicamento.jsf";
	}
	//Método para actualizar medicamento
	public void actualizarEmpleado(){
		new modeloEmpleado().
			updateEmpleado(empleado);
		Constantes.mensaje("Sistema","EMPLEADO ACTUALIZADO",
				FacesMessage.SEVERITY_INFO);
	}
	//Método para eliminar medicamento
	public void eliminarEmpleado(){
		new modeloEmpleado().
		deleteEmpleado(empleado.getCodiEmpleado());
		Constantes.mensaje("Sistema","EMPLEADO ELIMINADO",
				FacesMessage.SEVERITY_INFO);
	}

	
	//Método para vicular el valor del objeto "dtFila" con el objeto "medicamento"
	public void seleccionar(){
		empleado=(Empleados)dtFila.getRowData();

		
	}

	public void nuevoEmpleado(){
		empleado = new Empleados();
	}
	
	//Constructor
	public EmpleadoAction(){
		empleado = new Empleados();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<Empleados> getListaEmpleado() {
		listaEmpleado = new modeloEmpleado().lista();
		return listaEmpleado;
	}
	public void setListaEmpleado(List<Empleados> listaEmpleado) {
		this.listaEmpleado = listaEmpleado;
	}
	
	
	public List<Empleados> getListaEmpleado2() {
		return listaEmpleado2;
	}
	public void setListaEmpleado2(List<Empleados> listaEmpleado2) {
		this.listaEmpleado2 = listaEmpleado2;
	}
	public Empleados getEmpleado() {
		return empleado;
	}
	public void setEmpleado(Empleados empleado) {
		this.empleado = empleado;
	}
	public List<Distrito> getListaDistrito() {
		listaDistrito = new modeloDistrito().lista();
		return listaDistrito;
	}
	public void setListaDistrito(List<Distrito> listaDistrito) {
		this.listaDistrito = listaDistrito;
	}
	public List<Usuarios> getListaUsuarios() {
		listaUsuarios = new modeloUsuario().lista();
		return listaUsuarios;
	}
	public void setListaUsuarios(List<Usuarios> listaUsuarios) {
		this.listaUsuarios = listaUsuarios;
	}
	public UIData getDtFila() {
		return dtFila;
	}
	public void setDtFila(UIData dtFila) {
		this.dtFila = dtFila;
	}
	public String getCodEmpleado() {
		return codEmpleado;
	}
	public void setCodEmpleado(String codEmpleado) {
		this.codEmpleado = codEmpleado;
	}
	
	
	

	
	
	
	
	//listaUsuarios = new modeloUsuario().lista();
	//listaDistrito=new modeloDistrito().lista();
	//listaEmpleado=new modeloEmpleado().lista();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
