package fr.dawan.projetLMT.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.dawan.projetLMT.dao.GenreDao;
import fr.dawan.projetLMT.entities.Genre;
import fr.dawan.projetLMT.entities.Member;

@Service
public class GenreService {
		
	
	
		@Autowired
		private GenreDao genreDao ;
		
		@Transactional
		public  List<Genre> readAll() {
		return genreDao.readAll();
		}
}
