package fr.dawan.projetLMT.dao;






import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import fr.dawan.projetLMT.entities.Member;

@Repository // Permet à Spring de savoir que cette classe est un composant de type DAO
public class MemberDao {

	@PersistenceContext // Permet à Spring d'injecter l'entity manager avec les infos de connexion de la base de données
	private EntityManager em;
	
	public void create(Member member) {
		try {
			em.persist(member);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//@Transactional à rajouter si pas de couche service
	@SuppressWarnings("unchecked")
	public List<Member> readAll() {
		try  {
			return em.createQuery("From Member").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Member readById(long id) {
		try {
			//Member u = (Member) em.createQuery("From Member WHERE id= :id").setParameter("id", id).getSingleResult();
			return (Member) em.createQuery("From Member WHERE id= :id").setParameter("id", id).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Member readByEmail(String email) {
		try {
			return (Member) em.createQuery("From Member WHERE email= :email").setParameter("email", email).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void delete(Member member) {
		try {
			em.remove(member);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Member member) {
		try {
			em.merge(member);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public long count() {
		try {
			return (long) em.createQuery("Select count(x) FROM Member x").getSingleResult();
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Member> readPartial(int start, int nbElements) {
		try  {
			return em.createQuery("From Member").setFirstResult(start).setMaxResults(nbElements).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
