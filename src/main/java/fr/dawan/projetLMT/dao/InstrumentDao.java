package fr.dawan.projetLMT.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.dawan.projetLMT.entities.Instrument;
import fr.dawan.projetLMT.entities.Member;;

public class InstrumentDao {
	
	@PersistenceContext 
	private EntityManager em;
	
	public void create(Instrument instru) {
		try {
			em.persist(instru);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//@Transactional à rajouter si pas de couche service
		@SuppressWarnings("unchecked")
		public List<Instrument> readAll() {
			try  {
				return em.createQuery("From Instrument").getResultList();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
		public Instrument readById(long id) {
			try {
				
				return (Instrument) em.createQuery("From Instrument WHERE id= :id").setParameter("id", id).getSingleResult();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}

}
