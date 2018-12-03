package com.consorcio.modelo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.consorcio.entidad.Cliente;
import com.consorcio.entidad.Empleado;
import com.consorcio.entidad.Enlace;

public class modeloCliente {
	//objeto para obtener la unidad de persistencia que se encuentra
	//en el archivo persistence.xml
	EntityManagerFactory fabrica=Persistence.
			createEntityManagerFactory("PE");
	
	public List<Cliente> listaCliente(String ape){
		EntityManager manager=fabrica.createEntityManager();
		List<Cliente> data=null;
		TypedQuery<Cliente> resul=null;
		try {
			String hql="select c from Cliente c where c.apeCliente like ?1";
			resul=manager.createQuery(hql,Cliente.class);
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
	
	
	
	
	public void addCliente(Cliente cli){
		//crear una sesión del objeto fabrica
		EntityManager manager=fabrica.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.persist(cli);//insert into
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
	public void updateCliente(Cliente cli){
		//crear una sesión del objeto fabrica
		EntityManager manager=fabrica.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(cli);//update
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
	public void deleteCliente(int cod){
		//crear una sesión del objeto fabrica
		EntityManager manager=fabrica.createEntityManager();
		try {
			Cliente cli=manager.find(Cliente.class, cod);
			manager.getTransaction().begin();
			manager.remove(cli);//delete 
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
	
	
	
	
	
	public List<Cliente> lista(){
		EntityManager manager=fabrica.createEntityManager();
		List<Cliente> data=null;
		TypedQuery<Cliente> resul=null;
		try {
			String hql="select cl from Cliente cl";
			resul=manager.createQuery(hql,Cliente.class);
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
