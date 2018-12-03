package com.consorcio.modelo;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.consorcio.entidad.Departamento;
import com.consorcio.entidad.Distrito;

public class modeloDepartamento {
	EntityManagerFactory fabrica=Persistence.
				createEntityManagerFactory("PE");
	
	
	
	public List<Departamento> lista(){
		EntityManager manager=fabrica.createEntityManager();
		List<Departamento> data=null;
		TypedQuery<Departamento> resul=null;
		try {
			String hql="select dep from Departamento dep";
			resul=manager.createQuery(hql,Departamento.class);
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
