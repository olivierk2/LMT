package fr.dawan.projetLMT.controllers;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.dawan.projetLMT.storage.StorageService;
import fr.dawan.projetLMT.entities.FileUploader;
import fr.dawan.projetLMT.entities.Genre;
import fr.dawan.projetLMT.entities.Instrument;
import fr.dawan.projetLMT.entities.Member;
import fr.dawan.projetLMT.service.MemberService;
import fr.dawan.projetLMT.storage.StorageFileNotFoundException;

@Controller
@RequestMapping("/upload")
public class FileUploadController {
	@Autowired
    private FileUploader fileUploader;
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/display")
	public String display(Model model) {

		

		return "upload";
	}

    @PostMapping("/import")
    public String importPhoto(Model model, /*BindingResult result,*/
            @RequestParam("photo") MultipartFile file, @RequestParam("id") String id, HttpServletRequest request) {
    	String picture="";
        if (!file.isEmpty()) {
            try {
             picture=   fileUploader.uploadFile(file,id, request);
            } catch (IOException e) {
//                result.addError(new ObjectError("Erreur de traitement de fichier", e.getMessage()));
            }
        } else {
//           result.addError(new ObjectError("training_files", "Fichier vide"));
        }
        Member m=memberService.readById(Long.parseLong(id));
        m.setPicture(picture);
        memberService.update(m);
        return "redirect:/member/display";
    }
   
    
}
