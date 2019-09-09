package fr.dawan.projetLMT.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.dawan.projetLMT.entities.Instrument;
import fr.dawan.projetLMT.entities.Member;
import fr.dawan.projetLMT.entities.Genre;;;
@Repository
public class GenreDao {
	
	@PersistenceContext 
	private EntityManager em;
	
	public void create(Genre style) {
		try {
			em.persist(style);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Genre style) {
		try {
			em.remove(style);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Genre style) {
		try {
			em.merge(style);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Genre> readAll() {
		try  {
			return em.createQuery("From Genre").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
