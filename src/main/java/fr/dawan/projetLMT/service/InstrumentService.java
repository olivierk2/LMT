package fr.dawan.projetLMT.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.projetLMT.dao.InstrumentDao;
import fr.dawan.projetLMT.dao.MemberDao;
import fr.dawan.projetLMT.entities.Instrument;
import fr.dawan.projetLMT.entities.Member;

@Service
public class InstrumentService {
	
	@Autowired // avec cette annotation plus besoin d'initialiser l'objet (plus besoin de memberDao= new MemberDao();)
	private InstrumentDao instrumentDao;
	
	// Annotation TRES IMPORTANTE
	@Transactional //  Annotation qui permet de gérer les flux de connexions (ouverture, fermeture et rollback en cas d'erreur sur la requête)
	public void create(Instrument instru) {
		// Si modification à faire sur le member les faire ici SURTOUT avant l'appel du dao
		instrumentDao.create(instru);
	}
	
	@Transactional
	public List<Instrument> readAll() {
		return instrumentDao.readAll();
	}

	@Transactional
	public Instrument readById(long id) {
		return instrumentDao.readById(id);
	}	
	
//	@Transactional
//	public void delete(long id) {
//		Instrument u = readById(id);
//		instrumentDao.delete(u);
//	}
	
//	@Transactional
//	public void update(Instrument instru) {
//		instrumentDao.update(instru);
//	}
	
	
	
}
