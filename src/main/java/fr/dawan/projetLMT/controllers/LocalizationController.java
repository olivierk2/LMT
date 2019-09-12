package fr.dawan.projetLMT.controllers;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
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
		List<Member> listMembers = localizeService.findByCity(city);
		

		
		for (Member member : listMembers) {
			LocalDate birth = member.getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

			Period age = Period.between(birth, LocalDate.now());
			member.setAge(age.getYears());
		}
		
		model.addAttribute("listMembres", listMembers);

		return "findMusicians";
		
	}
	@GetMapping("/byZipCode/{zipcode}")
	public String findByZipCode(@PathVariable("zipcode")int zipcode,Model model) {
		List<Member> listMembers = localizeService.findByZipCode(zipcode);
		

		
		for (Member member : listMembers) {
			LocalDate birth = member.getBirthday().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

			Period age = Period.between(birth, LocalDate.now());
			member.setAge(age.getYears());
		}
		
		model.addAttribute("listMembres", listMembers);

		return "findMusicians";
		
	}
}
