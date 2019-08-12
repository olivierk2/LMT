package fr.dawan.projetLMT.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.dawan.projetLMT.entities.Message;



public class MessageDao {
	@PersistenceContext 
	private EntityManager em;

	public void create(Message message) {
		try {
			em.persist(message);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
