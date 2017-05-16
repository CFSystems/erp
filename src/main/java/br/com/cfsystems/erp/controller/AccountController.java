package br.com.cfsystems.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cfsystems.erp.model.Account;
import br.com.cfsystems.erp.service.AccountService;

@Controller
@Transactional
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountService service;
	
	@RequestMapping(value={"", "/"}, method={RequestMethod.GET})
	public String home(Model model){
		model.addAttribute("accounts", service.findAll());
		return "sys/account/index";
	}
	
	@RequestMapping(value={"/form"}, method={RequestMethod.GET})
	public String form(Account account) {
		return "sys/account/form";
	}

	@RequestMapping(value={"/save"}, method = RequestMethod.POST)
	public String save(Account account, RedirectAttributes redirectAttributes) {
		service.save(account);
		redirectAttributes.addAttribute("sucesso", "Conta cadastrada com sucesso.");
		return "redirect:/account";
	}

}
