package fr.dawan.projetLMT.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.dawan.projetLMT.service.MemberService;

@Controller 
@RequestMapping("/member")
@SessionAttributes("userBean")
public class MemberController {
	@Autowired
	MemberService memberService;
	
	

}
