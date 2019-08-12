package fr.dawan.projetLMT.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.dawan.projetLMT.entities.Instrument;
import fr.dawan.projetLMT.entities.Genre;;;

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

}
