package fr.dawan.projetLMT.controllers;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.dawan.projetLMT.beans.MemberForm;
import fr.dawan.projetLMT.beans.UserForm;
import fr.dawan.projetLMT.entities.Member;
import fr.dawan.projetLMT.entities.Member.sex;
import fr.dawan.projetLMT.entities.SharedLink;
import fr.dawan.projetLMT.entities.Genre;
import fr.dawan.projetLMT.service.MemberService;
import fr.dawan.projetLMT.service.GenreService;

@Controller 
@RequestMapping("/member")

public class MemberController {
	@Autowired
	MemberService memberService;
	@Autowired
	GenreService genreService;
	@GetMapping("/display")
	public String display(Model model){
		model.addAttribute("newMember",new Member());
		return "member";
	}
	@PostMapping("/newMember")
	public String createMember(@Valid @ModelAttribute("newMember") Member member,  BindingResult br, Model model, Locale locale, HttpSession session) {
		//DateTimeFormatter df = DateTimeFormatter.ofPattern("d-MM-yyyy");
		memberService.create(member);
		List<Genre> genresInBase = genreService.readAll();
		List<String> listGenres = new ArrayList<String>();
		for(Genre genre : genresInBase)
			listGenres.add(genre.getGenreName());
		
		model.addAttribute("listVierge", new ArrayList<String>());
		model.addAttribute("listGenres",listGenres);
		return "choixgenre";	

	}



}
