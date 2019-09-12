package fr.dawan.projetLMT.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.dawan.projetLMT.entities.Member;
import fr.dawan.projetLMT.service.LocalizeService;
import fr.dawan.projetLMT.service.MemberService;

@Controller
@RequestMapping("/localize")
public class LocalizationController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	LocalizeService localizeService;
	
	@GetMapping("/display")
	public String display(Model model) {
		Member exampleMember = memberService.readByEmail("test");
		System.out.println(exampleMember);
		model.addAttribute("member",exampleMember);
		return "localizedisplay";
		
	}
	@GetMapping("/byCity/{city}")
	public String findByCity(@PathVariable("city")String city,Model model) {
		List<Member> listByCity = localizeService.findByCity(city);
		model.addAttribute("listByCity", listByCity);
		return "listmember";
	}
}
