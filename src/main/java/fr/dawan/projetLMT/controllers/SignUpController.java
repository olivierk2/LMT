package fr.dawan.projetLMT.controllers;

import java.util.Locale;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.dawan.projetLMT.beans.MemberForm;
import fr.dawan.projetLMT.entities.Member;
import fr.dawan.projetLMT.service.MemberService;



@Controller
@RequestMapping("/signIn")
@SessionAttributes("userBean")
public class SignUpController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/display")
	public String display(Model model)
	{
		
		return "authenticate";
	}
	
	@PostMapping("/authentication")
	public String authentication(@ModelAttribute("userBean") MemberForm memberForm, Model model, HttpSession session) {
		String email =memberForm.getEmail();
		String msg = "";
		Member u = null;
		
		if(email!= null && !email.isEmpty()) {
			u= memberService.readByEmail(memberForm.getEmail());
		} else {
			msg = "Veuillez remplir le champ email";
			model.addAttribute("msg", msg);
			return "authenticate";	
		}
		
		if(u != null && u.getPassword() != null && u.getPassword().equals(memberForm.getPassword())) {
			
			
			return "dashboard";
		} else {
			msg = "Couple login password incorrect";
			model.addAttribute("msg", msg);
			return "authenticate";	
		}
	}
	
		// Pour la validation avec les annotations sur les beans, il faut rajouter un objet de type
		// BindingResult br JUSTE APRES le bean donc ici userForm car c'est lui qui contient
		// le resultat de la validation
		// Rajouter aussi l'annotation @Valid sur le bean
		@PostMapping("/authentication/avec/validation")
		public String authentication(@Valid @ModelAttribute("memberBean") MemberForm memberForm,  BindingResult br, Model model, Locale locale, HttpSession session) {
			String email =memberForm.getEmail();
			String msg = "";
			Member u = null;
			
			if(br.hasErrors()) {
				return "authenticate";
			}
			
			
			u = memberService.readByEmail(memberForm.getEmail());

			if(u != null && u.getPassword() != null && u.getPassword().equals(memberForm.getPassword())) {
				//session.setAttribute("role", u.getRole());
				return "dashboard";
			} else {
				
				msg = messageSource.getMessage("authentication.errors", null, locale);
				//msg = "Couple login password incorrect";
				model.addAttribute("msg", msg);
				return "authenticate";	
			}
		}
	
	@GetMapping("/load")
	public String load(Model model) {
		
		for(int i = 0 ; i<50 ; i++) {
			Member u = new Member(0, 0, "nom"+i, "email"+i, null, null, "password"+i, null, null, null, i, null, null, null, null, null, null);
			memberService.create(u);
		}
	
		
		String msg = "Utilisateur nom/password enregistré en BDD!";
		model.addAttribute("msg", msg);
		
		return "authenticate";	
		
	}
	
	@ModelAttribute("userBean")
	public MemberForm getUserForm() {
		return new MemberForm();
	}
 }
