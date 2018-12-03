package com.consorcio.modelo;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.consorcio.entidad.Tour;
public class modeloTour {
	EntityManagerFactory fabrica=Persistence.
			createEntityManagerFactory("PE");
	
	
	public void addTour(Tour med){
		EntityManager manager=fabrica.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.persist(med);
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
	public void updateTour(Tour med){
		EntityManager manager=fabrica.createEntityManager();
		try {
			manager.getTransaction().begin();
			manager.merge(med);
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
	public void deleteTour(int cod){
		EntityManager manager=fabrica.createEntityManager();
		try {
			Tour med=manager.find(Tour.class, cod);
			manager.getTransaction().begin();
			manager.remove(med);
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
	
	
	
	public Tour findTour(int cod){
		EntityManager manager=fabrica.createEntityManager();
		Tour med=null;
		try {
			med=manager.find(Tour.class, cod);
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			manager.close();
			fabrica.close();
		}
		return med;
	}
	
	
	
	
	//listar todos los medicamentos "hql"
	public List<Tour> lista(){
		EntityManager manager=fabrica.createEntityManager();
		List<Tour> data=null;
		TypedQuery<Tour> resul=null;
		try {
			String hql="select t from Tour t";
			resul=manager.createQuery(hql,Tour.class);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//listar todos los medicamentos que inicien con la letra a
	public List<Tour> listaXnombre(String nom){
		EntityManager manager=fabrica.createEntityManager();
		List<Tour> data=null;
		TypedQuery<Tour> resul=null;
		try {
			String hql="select t from Tour t where "+
						"t.nomTour like concat(:param,'%')";
			resul=manager.createQuery(hql,Tour.class);
			resul.setParameter("param", nom);
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
	
	
	
	//listar todos los medicamentos según código de laboratorio
		public List<Tour> listaXDestino(int cod){
			EntityManager manager=fabrica.createEntityManager();
			List<Tour> data=null;
			TypedQuery<Tour> resul=null;
			try {
				
				
			
				
				
				
				
				
				
				String hql="SELECT  m.nomTour, de.departamentos, m.stockTour,d.nomBus,	d.nomHotel,m.precioTour, m.fechaViaje "+
							"FROM Tour m"+
						"INNER JOIN Destino d ON m.codDestino = d.codDestino"+
							"INNER JOIN Departamento de ON d.codDepartamento = de.codDepartamento"+
						"where de.codDepartamento = ?1";
				resul=manager.createQuery(hql,Tour.class);
				resul.setParameter(1, cod);
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
		
		
		
		
	
		
				
				
				
		//actualizar precio de todos los medicamentos
		public int updatePrecio(double porcentaje){
			EntityManager manager=fabrica.createEntityManager();
			int resu=-1;
			Query q=null;
			try {
				
				
				
				
				
				String hql="update Medicamento m set m.precioMedicamento="+
							"precioMedicamento+precioMedicamento*?1";
				manager.getTransaction().begin();
				q=manager.createQuery(hql);
				q.setParameter(1, porcentaje);
				resu=q.executeUpdate();
				manager.getTransaction().commit();
			} catch (Exception e) {
				manager.getTransaction().rollback();
				e.printStackTrace();
			}
			finally {
				manager.close();
				fabrica.close();
			}
			return resu;
		}
				
				
				
				
				
				
}

