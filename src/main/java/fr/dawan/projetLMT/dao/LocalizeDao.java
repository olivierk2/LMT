package fr.dawan.projetLMT.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.dawan.projetLMT.entities.Member;

@Repository
public class LocalizeDao{
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Member> readByCity(String city){
		try {
			return em.createQuery("From Member WHERE city= :city").setParameter("city", city).getResultList();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
		
	}
	
	
	
}



































































