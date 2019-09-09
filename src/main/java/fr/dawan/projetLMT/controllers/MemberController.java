package fr.dawan.projetLMT.controllers;
import java.sql.Array;
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
import fr.dawan.projetLMT.dao.GenreDao;
import fr.dawan.projetLMT.entities.Genre;

import fr.dawan.projetLMT.entities.Instrument;
import fr.dawan.projetLMT.entities.Member;
import fr.dawan.projetLMT.entities.Member.sex;
import fr.dawan.projetLMT.entities.SharedLink;
import fr.dawan.projetLMT.service.GenreService;
import fr.dawan.projetLMT.service.MemberService;


@Controller 
@RequestMapping("/member")

public class MemberController {
	@Autowired
	MemberService memberService;
	@Autowired
	private GenreService genreService;

	@GetMapping("/display")
	public String display(Model model)
	{
		
	List<Genre> listG = genreService.readAll();
	List<Member> listU = memberService.readAll();
	
//		for (Genre genre : listG) {
//			
//			System.out.println("GenreName: " + g.getGenreName());
//		
//		}
		
		model.addAttribute("listGenres",listG);
		model.addAttribute("newMember",new Member());
		model.addAttribute("listVierge",new Genre());
	
		return "member";
	}
		
		
	@PostMapping("/newMember")
	public String createMember(@Valid @ModelAttribute("newMember") Member member,@ModelAttribute("listGenres") List<String> genre,BindingResult br, Model model, Locale locale, HttpSession session) {
		//DateTimeFormatter df = DateTimeFormatter.ofPattern("d-MM-yyyy");
		
		
		member.setGenres(genre);
//		
//		Member uM = new Member(0, 0, 
//				memberForm.getFirstname(),
//				memberForm.getLastname(), 
//				memberForm.getBirthday(), 
//				memberForm.getSexMember(),
//				memberForm.getEmail(), 
//				memberForm.getPassword(),
//				memberForm.getLevelMember(), 
//				memberForm.getAdress(), 
//				Integer.parseInt(memberForm.getZipCode()), 
//				memberForm.getCity(), 
//				memberForm.getPicture(),
//				memberForm.getResume(), 
//				memberForm.getInstruments(),
//				
//				memberForm.getGenre(),				
//				
//				memberForm.getSharedLinks());
		
		memberService.create(member);		
		model.addAttribute("newMember",member.getFirstname());
		return "welcome";	

	}


	@ModelAttribute("newMember")
	public Member getUserForm() {
		return new Member();
	}
}
