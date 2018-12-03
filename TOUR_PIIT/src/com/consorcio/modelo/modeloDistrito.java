package com.consorcio.modelo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.consorcio.entidad.Cliente;
import com.consorcio.entidad.Distrito;
public class modeloDistrito {
	//objeto para obtener la unidad de persistencia que se encuentra
	//en el archivo persistence.xml
	EntityManagerFactory fabrica=Persistence.
			createEntityManagerFactory("PE");
	
	
	
	public List<Distrito> lista(){
		EntityManager manager=fabrica.createEntityManager();
		List<Distrito> data=null;
		TypedQuery<Distrito> resul=null;
		try {
			String hql="select di from Distrito di";
			resul=manager.createQuery(hql,Distrito.class);
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
