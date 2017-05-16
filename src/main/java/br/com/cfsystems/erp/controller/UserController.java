package br.com.cfsystems.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cfsystems.erp.model.User;
import br.com.cfsystems.erp.service.UserService;

@Controller
@Transactional
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(value={"", "/"}, method={RequestMethod.GET})
	public String home(Model model){
		model.addAttribute("users", service.findAll());
		return "sys/user/index";
	}
	
	@RequestMapping(value={"/form"}, method={RequestMethod.GET})
	public String form(User user) {
		return "sys/user/form";
	}

	@RequestMapping(value={"/save"}, method = RequestMethod.POST)
	public String save(User user, RedirectAttributes redirectAttributes) {
		service.save(user);
		redirectAttributes.addFlashAttribute("sucesso", "Usuário cadastrado com sucesso.");
		return "redirect:/user";
	}

}
