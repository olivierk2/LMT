package fr.dawan.projetLMT.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.projetLMT.dao.LocalizeDao;
import fr.dawan.projetLMT.entities.Member;

@Service
public class LocalizeService {
	@Autowired
	private LocalizeDao localizeDao;
	
	@Transactional
	public List<Member> findByCity(String city){
		return localizeDao.readByCity(city);
	}
	
	@Transactional
	public List<Member> findByZipCode(int zipcode){
		return localizeDao.readByZipCode(zipcode);
	}
}
