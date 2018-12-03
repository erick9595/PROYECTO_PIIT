package com.consorcio.modelo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.consorcio.entidad.Cliente;
import com.consorcio.entidad.Distrito;
import com.consorcio.entidad.Rol;

public class modeloRol {
	//objeto para obtener la unidad de persistencia que se encuentra
	//en el archivo persistence.xml
	EntityManagerFactory fabrica=Persistence.
			createEntityManagerFactory("PE");
	
	
	
	public List<Rol> lista(){
		EntityManager manager=fabrica.createEntityManager();
		List<Rol> data=null;
		TypedQuery<Rol> resul=null;
		try {
			String hql="select r from Rol r";
			resul=manager.createQuery(hql,Rol.class);
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
