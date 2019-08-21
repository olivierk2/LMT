package fr.dawan.projetLMT.controllers;
import java.util.Locale;

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
	public String createMember(@Valid @ModelAttribute("newBean") MemberForm memberForm,  BindingResult br, Model model, Locale locale, HttpSession session) {
		
		
			Member u = new Member(0, 0,memberForm.getFirstname(), memberForm.getEmail(), null, null,memberForm.getPassword(), null, null, null,1, null, null, null, null, null, null);
			memberService.create(u);
				
		model.addAttribute("member",u);
		
		return "welcome";	
		
	}
	
	
	@ModelAttribute("newBean")
	public MemberForm getUserForm() {
		return new MemberForm();
	}
}
