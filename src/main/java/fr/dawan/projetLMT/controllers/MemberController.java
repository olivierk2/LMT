package fr.dawan.projetLMT.controllers;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import fr.dawan.projetLMT.service.MemberService;

@Controller 
@RequestMapping("/member")

public class MemberController {
	@Autowired
	MemberService memberService;

	@GetMapping("/display")
	public String display(Model model)
	{

		return "member";
	}
	@PostMapping("/newMember")
	public String createMember(@Valid @ModelAttribute("newMember") MemberForm memberForm,  BindingResult br, Model model, Locale locale, HttpSession session) {
		//DateTimeFormatter df = DateTimeFormatter.ofPattern("d-MM-yyyy");

		Member uM = new Member(0, 0, 
				memberForm.getFirstname(), memberForm.getLastname(), 
				memberForm.getBirthday(), 
				sex.valueOf(memberForm.getSexMember()),
				memberForm.getEmail(), 
				memberForm.getPassword(),
				Member.level.valueOf(memberForm.getLevelMember()), 
				memberForm.getAdress(), 
				Integer.parseInt(memberForm.getZipCode()), 
				memberForm.getCity(), 
				memberForm.getPicture(),
				memberForm.getResume(), 
				memberForm.getInstruments(),
				memberForm.getGenres(), 
				memberForm.getSharedLinks());
		
		memberService.create(uM);

		model.addAttribute("member",uM);

		return "welcome";	

	}


	@ModelAttribute("newMember")
	public MemberForm getUserForm() {
		return new MemberForm();
	}
}
