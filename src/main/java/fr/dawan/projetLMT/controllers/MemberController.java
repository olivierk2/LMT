package fr.dawan.projetLMT.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.dawan.projetLMT.service.MemberService;

@Controller 
public class MemberController {
	@Autowired
	MemberService memberService;

}
