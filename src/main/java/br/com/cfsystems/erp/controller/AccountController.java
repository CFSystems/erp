package br.com.cfsystems.erp.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cfsystems.erp.dao.AccountDAO;
import br.com.cfsystems.erp.models.Account;

@Controller
@Transactional
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountDAO dao;
	
	@RequestMapping(value={"", "/"}, method={RequestMethod.GET})
	public String home(Model model){
		model.addAttribute("accounts", dao.findAll());
		return "sys/account/index";
	}
	
	@RequestMapping(value={"/form"}, method={RequestMethod.GET})
	public String form(Account account) {
		return "sys/account/form";
	}

	@RequestMapping(value={"/save"}, method = RequestMethod.POST)
	public String save(Account account, RedirectAttributes redirectAttributes) {
		dao.save(account);
		redirectAttributes.addAttribute("sucesso", "Conta cadastrada com sucesso.");
		return "redirect:/account";
	}

}
