package com.consorcio.modelo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.consorcio.entidad.Empleado;
import com.consorcio.entidad.Empleados;
import com.consorcio.entidad.Enlace;

public class modeloLogin{
	//objeto para obtener la unidad de persistencia que se encuentra
		//en el archivo persistence.xml
		EntityManagerFactory fabrica=Persistence.
				createEntityManagerFactory("PE");
		
		
		

		
		
		
		
		
		public Empleado iniciarSesion(String login,String clave){
			EntityManager manager=fabrica.createEntityManager();
			Empleado data=null;
			TypedQuery<Empleado> resul=null;
			try {
				String hql="select e from Empleado e join e.usuario"
						+ " u where u.login=?1 and u.password=?2";
				resul=manager.createQuery(hql,Empleado.class);
				resul.setParameter(1, login);
				resul.setParameter(2, clave);
				List<Empleado> lista=resul.getResultList();
				if(!lista.isEmpty())
					data=lista.get(0);
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				manager.close();
				fabrica.close();
			}
			return data;
		}
		public List<Enlace> listaEnlace(int idRol){
			EntityManager manager=fabrica.createEntityManager();
			List<Enlace> data=null;
			TypedQuery<Enlace> resul=null;
			try {
				String hql="select e from RolEnlace re join re.enlace e where "+
						"re.rol.idrol=?1";
				resul=manager.createQuery(hql,Enlace.class);
				resul.setParameter(1, idRol);
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
