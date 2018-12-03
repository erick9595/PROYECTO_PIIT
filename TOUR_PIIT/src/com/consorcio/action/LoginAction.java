package com.consorcio.action;
import java.io.IOException;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.consorcio.entidad.Empleado;
import com.consorcio.entidad.Empleados;
import com.consorcio.entidad.Enlace;
import com.consorcio.modelo.modeloLogin;

import utils.Constantes;
@ManagedBean(name="sesion")
@SessionScoped
public class LoginAction {
	private String login;
	private String clave;
	private Empleado empleado;
	private List<Enlace> lista;
	public void iniciaSesion() throws IOException{
		
	
		
		
		
		empleado=new modeloLogin().iniciarSesion(login, clave);
		if(empleado!=null){
			int rol=empleado.getUsuario().getRol().getIdrol();
			lista=new modeloLogin().listaEnlace(rol);
			
			Constantes.url("Inicio.jsf");
		}
		else
			Constantes.mensaje("Sistema", "usuario y/o clave incorrecto", FacesMessage.SEVERITY_ERROR);
		
	}
	public void cerrarSesion() throws IOException{
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		Constantes.url("login.jsf");
	}
	

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

    public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public List<Enlace> getLista() {
		return lista;
	}
	public void setLista(List<Enlace> lista) {
		this.lista = lista;
	}

	
	
	
	
}
