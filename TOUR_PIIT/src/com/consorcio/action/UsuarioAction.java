package com.consorcio.action;
import java.io.FileOutputStream;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.component.api.UIData;

import com.consorcio.entidad.Roles;
import com.consorcio.entidad.Usuarios;
import com.consorcio.modelo.modeloRoles;
import com.consorcio.modelo.modeloUsuario;

import utils.Constantes;
@ManagedBean(name="CRUDUsuario")
@ViewScoped
public class UsuarioAction {
	//atributo para almacenar todos los medicamentos
	private List<Usuarios> listaUsuario;
	private List<Usuarios> listaUsuario2;
	//Atributo para registrar
	private Usuarios usuario;
	//Atributo para almacenar los laboratorios
	private List<Roles> listaRoles;
	//Atributo para referenciar la fila seleccionada del DataTable
	private UIData dtFila;


	private String codiUsuario;
	

	
	//Metodo para registrar medicamentos
	public void registrarUsuario(){
		new modeloUsuario().addUsuario(usuario);
		Constantes.mensaje("Sistema","USUARIO REGISTRADO",
					FacesMessage.SEVERITY_INFO);

	}
	//Método para actualizar medicamento
	public void actualizarUsuario(){
		new modeloUsuario().
			updateUsuario(usuario);
		Constantes.mensaje("Sistema","USUARIO ACTUALIZADO",
				FacesMessage.SEVERITY_INFO);
	}
	//Método para eliminar medicamento
	public void eliminarUsuario(){
		new modeloUsuario().
		deleteUsuario(usuario.getCodiUsuario());
		Constantes.mensaje("Sistema","USUARIO ELIMINADO",
				FacesMessage.SEVERITY_INFO);
	}

	
	//Método para vicular el valor del objeto "dtFila" con el objeto "medicamento"
	public void seleccionar(){
		usuario=(Usuarios)dtFila.getRowData();

		
	}

	public void nuevoUsuario(){
		usuario = new Usuarios();
	}
	
	//Constructor
	public UsuarioAction(){
		usuario = new Usuarios();
	}
	
	
	
	
	
	
	
	
	
	public List<Usuarios> getListaUsuario() {
		listaUsuario = new modeloUsuario().lista();
		return listaUsuario;
	}
	public void setListaUsuario(List<Usuarios> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	public List<Usuarios> getListaUsuario2() {
		return listaUsuario2;
	}
	public void setListaUsuario2(List<Usuarios> listaUsuario2) {
		this.listaUsuario2 = listaUsuario2;
	}
	public Usuarios getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
	
	
	public List<Roles> getListaRoles() {
		listaRoles=new modeloRoles().lista();
		return listaRoles;
	}
	public void setListaRoles(List<Roles> listaRoles) {
		this.listaRoles = listaRoles;
	}
	
	
	
	public UIData getDtFila() {
		return dtFila;
	}
	public void setDtFila(UIData dtFila) {
		this.dtFila = dtFila;
	}
	public String getCodiUsuario() {
		return codiUsuario;
	}
	public void setCodiUsuario(String codiUsuario) {
		this.codiUsuario = codiUsuario;
	}
	
	
	




		


	
	
	
	
	

		
		
		
		
		
		
		
		

	
	
	
	
	
	
	

	
	
	
	

	
	
	
	
	
}
