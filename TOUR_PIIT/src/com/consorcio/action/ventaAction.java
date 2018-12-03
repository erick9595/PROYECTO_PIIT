package com.consorcio.action;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.component.api.UIData;

import com.consorcio.entidad.Boleta;
import com.consorcio.entidad.Cliente;
import com.consorcio.entidad.Detalle;
import com.consorcio.entidad.Empleado;
import com.consorcio.entidad.Tour;
import com.consorcio.entidad.TourHasBoleta;
import com.consorcio.modelo.modeloBoleta;
import com.consorcio.modelo.modeloCliente;

import com.consorcio.modelo.modeloTour;

import utils.Constantes;
@ManagedBean(name="ventas")
@ViewScoped
public class ventaAction {
	
	
	
	//Tour
	private String nombre;
	private List<Tour> listaTour;
	private Tour tour;
	private UIData dtFilaTour;
	
	
	
	
	
	//ventas
	//sesión de tipo Map
	private Map<String, Object> sesion=FacesContext.getCurrentInstance().
				getExternalContext().getSessionMap();
	
	
	private String cantidad;
	
	
	
	@ManagedProperty(value="#{sesion.empleado}")
	private Empleado emp;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void consultaTourXNombre(){
		listaTour=new modeloTour().listaXnombre(nombre);
	}
	public void seleccionarTour(){
		tour=(Tour) dtFilaTour.getRowData();
	}
	
	
	
	
	
	public void adicionar(){
		//recuperar la clave "detalle"
		List<Detalle>lista=(ArrayList<Detalle>)sesion.get("detalle");
		//validar
		if(lista==null)
			lista=new ArrayList<Detalle>();
		
		//objeto de la clase Detalle
		Detalle d=new Detalle();
		d.setCodMed(tour.getCodTour());
		d.setNomMed(tour.getNomTour());
		d.setCantidad(Integer.parseInt(cantidad));
		d.setPrecio(tour.getPrecioTour());
		//enviar "d" a lista 
		lista.add(d);
		//crear o actualizar la clave "detalle"
		sesion.put("detalle", lista);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	public double getMonto(){
		List<Detalle>lista=(ArrayList<Detalle>)sesion.get("detalle");
		double s=0;
		if(lista!=null){
			for(int i=0;i<lista.size();i++)
				s+=lista.get(i).getImporte();
		}
		return s;
	}
	
	

	
	
	
	public void registraVenta() {
		try {
			Boleta b = new Boleta();
			b.setFechaEmision(new Date());
			b.setMonto(getMonto());
			//recuperar sesion
			Empleado uu=emp;//(Empleado) sesion.get("objUsuario");
			Empleado ee=new Empleado();
			ee.setCodEmpleado(uu.getUsuario().getCodUsuario());
			b.setEmpleadoBoleta(ee);
			//recuperar detalle de la venta
			List<Detalle> boleta = (ArrayList<Detalle>) sesion.get("detalle");
			if (boleta != null) {
				for (Detalle s : boleta) {
					TourHasBoleta mhb = new TourHasBoleta();
					Tour p = new Tour();
					p.setCodTour(s.getCodMed());
					mhb.setCantidad(s.getCantidad());
					mhb.setPrecio(s.getPrecio());
					mhb.setTour(p);
					b.addTourHasBoleta(mhb);
				}
				modeloBoleta m = new modeloBoleta();
				m.registraBoleta(b);
				boleta.clear();
				sesion.put("detalle",boleta);
			
				Constantes.mensaje("Sistema", "TOUR RESERVADO CON EXITO", FacesMessage.SEVERITY_INFO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	
	
	
	
	
	
	
	public List<Tour> getListaTour() {
		return listaTour;
	}
	public void setListaTour(List<Tour> listaTour) {
		this.listaTour = listaTour;
	}
	public Tour getTour() {
		return tour;
	}
	public void setTour(Tour tour) {
		this.tour = tour;
	}
	public UIData getDtFilaTour() {
		return dtFilaTour;
	}
	public void setDtFilaTour(UIData dtFilaTour) {
		this.dtFilaTour = dtFilaTour;
	}
	public Empleado getEmp() {
		return emp;
	}
	public void setEmp(Empleado emp) {
		this.emp = emp;
	}
	
	
	
	
	
	
	
	
	
}



