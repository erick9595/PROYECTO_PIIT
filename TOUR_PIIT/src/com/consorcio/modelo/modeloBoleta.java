package com.consorcio.modelo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.consorcio.entidad.Boleta;
import com.consorcio.entidad.TourHasBoleta;
import com.consorcio.entidad.TourHasBoletaPK;
public class modeloBoleta {
	EntityManagerFactory fabrica=Persistence.
				createEntityManagerFactory("PE");
	
	
	
	public void registraBoleta(Boleta bol){
		EntityManager manager=fabrica.
					createEntityManager();
		try {
			manager.getTransaction().begin();
			//grabar cabacera
			manager.persist(bol);
			manager.flush(); 
			//grabar detalle
			for(TourHasBoleta mhb: bol.getListaHasBoleta()){
				manager.persist(bol);
				manager.flush(); 
				TourHasBoletaPK mhbPK=new TourHasBoletaPK();
				mhbPK.setNumBoleta(bol.getNumBoleta());
				mhbPK.setCodTour(mhb.getTour().getCodTour());	
				
				mhb.setPk(mhbPK);
				manager.persist(mhb);
				manager.flush();
			}
			manager.getTransaction().commit();
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}
		finally {
			manager.close();
			fabrica.close();
		}
	}
	
	
}
