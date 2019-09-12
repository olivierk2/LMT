package fr.dawan.projetLMT.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.projetLMT.dao.GenreDao;
import fr.dawan.projetLMT.dao.MemberDao;
import fr.dawan.projetLMT.entities.Genre;
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
public class GenreService {

	@Autowired // avec cette annotation plus besoin d'initialiser l'objet (plus besoin de memberDao= new MemberDao();)
	private GenreDao genreDao;
	
	// Annotation TRES IMPORTANTE
	@Transactional //  Annotation qui permet de gérer les flux de connexions (ouverture, fermeture et rollback en cas d'erreur sur la requête)
	public void create(Genre genre) {
		// Si modification à faire sur le member les faire ici SURTOUT avant l'appel du dao
		genreDao.create(genre);
	}
	
	@Transactional
	public List<Genre> readAll() {
		return genreDao.readAll();
		
	}

	@Transactional
	public Genre readById(long id) {
		return genreDao.readById(id);
	}
	
	
	@Transactional
	public Genre readByName(String name) {
		return genreDao.readByName(name);
	}

	
	
	@Transactional
	public void delete(long id) {
		Genre u = readById(id);
		genreDao.delete(u);
	}
	
	@Transactional
	public void update(Genre utilisateur) {
		genreDao.update(utilisateur);
	}
	
	
	
	@Transactional
	public long count() {
		return genreDao.count();
	}
	
}
