package com.consorcio.modelo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.consorcio.entidad.Cliente;
import com.consorcio.entidad.Empleado;
import com.consorcio.entidad.Empleados;
import com.consorcio.entidad.Enlace;
public class modeloEmpleado {
	//objeto para obtener la unidad de persistencia que se encuentra
	//en el archivo persistence.xml
	EntityManagerFactory fabrica=Persistence.
			createEntityManagerFactory("PE");
	
	
	
	public List<Empleados> listaEmpleado(String ape){
		EntityManager manager=fabrica.createEntityManager();
		List<Empleados> data=null;
		TypedQuery<Empleados> resul=null;
		try {
			String hql="select em from Empleados e where e.apeEmpleado like ?1";
			resul=manager.createQuery(hql,Empleados.class);
			resul.setParameter(1, ape+"%");
			data=resul.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			manager.close();
			fabrica.close();
		}
		return data;
	}
	
	
	
	
	public void addEmpleado(Empleados emp){
		//crear una sesión del objeto fabrica
		EntityManager manager=fabrica.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.persist(emp);//insert into
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		finally{
			manager.close();
			fabrica.close();
		}
	}
	
	
	
	public void updateEmpleado(Empleados emp){
		//crear una sesión del objeto fabrica
		EntityManager manager=fabrica.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(emp);//update
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		finally{
			manager.close();
			fabrica.close();
		}
	}
	
	
	
	
	
	public void deleteEmpleado(int cod){
		//crear una sesión del objeto fabrica
		EntityManager manager=fabrica.createEntityManager();
		try {
			Empleados emp=manager.find(Empleados.class, cod);
			manager.getTransaction().begin();
			manager.remove(emp);//delete 
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		finally{
			manager.close();
			fabrica.close();
		}
	}
	
	
	
	
	
	public List<Empleados> lista(){
		EntityManager manager=fabrica.createEntityManager();
		List<Empleados> data=null;
		TypedQuery<Empleados> resul=null;
		try {
			String hql="select em from Empleados em";
			resul=manager.createQuery(hql,Empleados.class);
			data=resul.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			manager.close();
			fabrica.close();
		}
		return data;
	}
	
	
	
	
	
	
}
