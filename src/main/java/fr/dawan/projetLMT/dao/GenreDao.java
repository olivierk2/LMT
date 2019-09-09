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

	public List<Genre> readAll() {
		try  {
			return em.createQuery(" From Genre",Genre.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Genre readById(long id) {
		try {			
			return (Genre) em.createQuery("From Genre WHERE id= :id").setParameter("id", id).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public long count()
	{
		try {
			return (long) em.createQuery("FROM Genre x select count(x)").getSingleResult();
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	

}
