package fr.dawan.projetLMT.controllers;

import java.sql.Array;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
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
import fr.dawan.projetLMT.service.InstrumentService;

@Controller
@RequestMapping("/member")

public class MemberController {
	@Autowired
	MemberService memberService;
	@Autowired
	private GenreService genreService;
	@Autowired
	private InstrumentService instrumentService;

	@GetMapping("/display")
	public String display(Model model) {

		List<Genre> listG = genreService.readAll();
		List<Member> listU = memberService.readAll();
		List<Instrument> listInstru = instrumentService.readAll();

		model.addAttribute("listMembres", listU);
		model.addAttribute("listGenres", listG);
		model.addAttribute("newMember", new Member());
		model.addAttribute("listInstru", listInstru);

		return "member";
	}

	@GetMapping("/displayMusicians")
	public String findAmember(Model model) {

		List<Member> listMembers = memberService.readAll();
		
		for (Member member : listMembers) {
			LocalDate birth = member.getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

			Period age = Period.between(birth, LocalDate.now());
			member.setAge(age.getYears());
		}
		
		model.addAttribute("listMembres", listMembers);

		return "findMusicians";

	}

	@PostMapping("/newMember")
	public String createMember(@Valid @ModelAttribute("newMember") Member member, BindingResult br, Model model,
			Locale locale, HttpSession session, HttpServletRequest req) {

		// creation d'une liste pour récuperer les instruments par id(foreach)
		List<Instrument> instrus = new ArrayList<Instrument>();

		for (String idInstru : req.getParameterValues("instruments")) {
			Instrument instr = instrumentService.readById((Long.parseLong(idInstru))); // récupérer le genre par son
																						// nom
			instrus.add(instr);
		}

		member.setInstruments(instrus);

		// Recuperation des genres

		List<Genre> genres = new ArrayList<Genre>();

		for (String nom : req.getParameterValues("genres")) {
			Genre genrer = genreService.readByName(nom); // récupérer le genre par son nom
			genres.add(genrer);
		}

		member.setGenres(genres);
		memberService.create(member);
		Member user = memberService.readByEmail(member.getEmail());
		model.addAttribute("lastName", user.getLastname());
		return "welcome";
	}

	@ModelAttribute("newMember")
	public Member getUserForm() {
		return new Member();
	}
}
