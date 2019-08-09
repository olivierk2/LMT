package fr.dawan.projetLMT.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.projetLMT.dao.MemberDao;
import fr.dawan.projetLMT.entities.Member;

/*
 * Nouvelle couche Service qui permet :
 * 		- de protéger la couche DAO et donc la BDD des attaques externes
 * 		- faire le lien entre la couche métier et la couche DAO
 * 				=> augmente la modularité du projet
 * 		- facilite aussi la maintenance et l'évolution du projet
 * 		Si dans une servlet on appelle 50 fois une méthode dao, si on modifie la méthode dao
 * 	il faudra changer les appels 50 fois dans la servlet. Pour faciliter la maintenance on utilise maintenant
 * une couche service qui s'occupe des appels dao, et donc si les dao sont modifiés il y aura juste à changer 
 * un appel dans la couche service
 * 
 * 
 * C'est dans cette couche qu'on va appliquer des traitements spécifiques à l'objet member propre à notre projet
 * et qu'on va gérer les transactions vers la BDD.
 * 
 */
@Service
public class MemberService {

	@Autowired // avec cette annotation plus besoin d'initialiser l'objet (plus besoin de memberDao= new MemberDao();)
	private MemberDao memberDao;
	
	// Annotation TRES IMPORTANTE
	@Transactional //  Annotation qui permet de gérer les flux de connexions (ouverture, fermeture et rollback en cas d'erreur sur la requête)
	public void create(Member member) {
		// Si modification à faire sur le member les faire ici SURTOUT avant l'appel du dao
		memberDao.create(member);
	}
	
	@Transactional
	public List<Member> readAll() {
		return memberDao.readAll();
	}

	@Transactional
	public Member readById(long id) {
		return memberDao.readById(id);
	}
	
	@Transactional
	public Member readByEmail(String email) {
		return memberDao.readByEmail(email);
	}
	
	@Transactional
	public void delete(long id) {
		Member u = readById(id);
		memberDao.delete(u);
	}
	
	@Transactional
	public void update(Member utilisateur) {
		memberDao.update(utilisateur);
	}
	
	@Transactional
	public List<Member> readPartial(int start, int nbElts){
		return memberDao.readPartial(start, nbElts);
	}
	
	@Transactional
	public long count() {
		return memberDao.count();
	}
	
	
}
