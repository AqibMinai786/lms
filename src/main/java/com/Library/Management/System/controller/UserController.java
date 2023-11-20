package com.Library.Management.System.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Library.Management.System.entity.User;
import com.Library.Management.System.repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired(required=true)
	private UserRepository repo;
	
	//this method return login page
	@GetMapping("/")
	public String login(Model model) {
		User user=new User();
		model.addAttribute("user",user);
		return "login";   //this login is html page as we are using thymeleaf
	}
	
	
//	@PostMapping("/userLogin")
//	public String loginUser(@ModelAttribute("user") User user, Model model) {
//		String userId=user.getUserId();
//		Optional<User> userdata=repo.findById(userId);
//		if(userdata.isPresent() && user.getPassword().equals(userdata.get().getPassword())) {
//			System.out.println("User ID: " + userId);
//	        model.addAttribute("userId", userId);
//			return "redirect:/books";
//		}
//		else {
//			return "error";
//		}
//	}
//	
	
	@PostMapping("/userLogin")
	public String loginUser(@ModelAttribute("user") User user, RedirectAttributes redirectAttributes) {
	    String userId = user.getUserId();
	    Optional<User> userdata = repo.findById(userId);

	    if (userdata.isPresent() && user.getPassword().equals(userdata.get().getPassword())) {
//	        System.out.println("User ID: " + userId);
	        redirectAttributes.addAttribute("userId", userId);
	        return "redirect:/books";
	    } else {
	        return "error";
	    }
	}


}
