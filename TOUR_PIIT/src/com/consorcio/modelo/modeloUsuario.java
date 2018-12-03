package com.consorcio.modelo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.consorcio.entidad.Usuarios;


public class modeloUsuario {
	
	//objeto para obtener la unidad de persistencia que se encuentra
		//en el archivo persistence.xml
		EntityManagerFactory fabrica=Persistence.
				createEntityManagerFactory("PE");
		
		
		
		
		public List<Usuarios> listaUsuario(String ape){
			EntityManager manager=fabrica.createEntityManager();
			List<Usuarios> data=null;
			TypedQuery<Usuarios> resul=null;
			try {
				String hql="select us from Usuarios us where us.login like ?1";
				resul=manager.createQuery(hql,Usuarios.class);
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
		
		
		
		
		
		
		
		public void addUsuario(Usuarios cli){
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
		public void updateUsuario(Usuarios cli){
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
		public void deleteUsuario(int cod){
			//crear una sesión del objeto fabrica
			EntityManager manager=fabrica.createEntityManager();
			try {
				Usuarios cli=manager.find(Usuarios.class, cod);
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
		
		
		
		
		
		public List<Usuarios> lista(){
			EntityManager manager=fabrica.createEntityManager();
			List<Usuarios> data=null;
			TypedQuery<Usuarios> resul=null;
			try {
				String hql="select us from Usuarios us";
				resul=manager.createQuery(hql,Usuarios.class);
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
