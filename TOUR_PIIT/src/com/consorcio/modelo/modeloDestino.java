package com.consorcio.modelo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.consorcio.entidad.Cliente;
import com.consorcio.entidad.Destino;
import com.consorcio.entidad.Distrito;
public class modeloDestino {
	//objeto para obtener la unidad de persistencia que se encuentra
	//en el archivo persistence.xml
	EntityManagerFactory fabrica=Persistence.
			createEntityManagerFactory("PE");
	
	
	
	
	public void addDestino(Destino cli){
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
	public void updateDestino(Destino cli){
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
	public void deleteDestino(int cod){
		//crear una sesión del objeto fabrica
		EntityManager manager=fabrica.createEntityManager();
		try {
			Destino cli=manager.find(Destino.class, cod);
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
	
	
	
	
	

	
	
	
	
	
	public List<Destino> lista(){
		EntityManager manager=fabrica.createEntityManager();
		List<Destino> data=null;
		TypedQuery<Destino> resul=null;
		try {
			String hql="select des from Destino des";
			resul=manager.createQuery(hql,Destino.class);
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
