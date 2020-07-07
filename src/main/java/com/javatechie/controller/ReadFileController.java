package com.javatechie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javatechie.model.User;
import com.javatechie.service.ReadFileService;

@Controller
public class ReadFileController {
	
	@Autowired
	private ReadFileService service;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("user", new User());
		List<User> users = service.findAll();
		model.addAttribute("users", users);
		return "view/users";
	}
	
	@PostMapping("/fileupload")
	public String uploadFile(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
		boolean isFlag = service.saveDataFromUploadFile(user.getFile());
		if (isFlag) {
			redirectAttributes.addFlashAttribute("successmessage", "File Upload Successfully!");
		} else {
			redirectAttributes.addFlashAttribute("errormessage", "File upload not done, Please try again!");
		}
		return "redirect:/";
	}

}
