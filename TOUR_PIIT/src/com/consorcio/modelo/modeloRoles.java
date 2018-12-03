package com.consorcio.modelo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


import com.consorcio.entidad.Roles;



public class modeloRoles {
	//objeto para obtener la unidad de persistencia que se encuentra
	//en el archivo persistence.xml
	EntityManagerFactory fabrica=Persistence.
			createEntityManagerFactory("PE");
	
	
	
	
	
	
	
	
	public List<Roles> lista(){
		EntityManager manager=fabrica.createEntityManager();
		List<Roles> data=null;
		TypedQuery<Roles> resul=null;
		try {
			String hql="SELECT ro FROM Roles ro";
			resul=manager.createQuery(hql,Roles.class);
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
