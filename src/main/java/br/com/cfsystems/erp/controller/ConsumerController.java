package br.com.cfsystems.erp.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cfsystems.erp.dao.ConsumerDAO;
import br.com.cfsystems.erp.models.Consumer;

@Controller
@Transactional
@RequestMapping("/consumer")
public class ConsumerController {

	@Autowired
	private ConsumerDAO dao;
	
	@RequestMapping(value={"", "/"}, method={RequestMethod.GET})
	public String home(Model model){
		model.addAttribute("consumers", dao.findAll());
		return "sys/consumer/index";
	}
	
	@RequestMapping(value={"/form"}, method={RequestMethod.GET})
	public String form(Consumer consumer) {
		return "sys/consumer/form";
	}

	@RequestMapping(value={"/save"}, method = RequestMethod.POST)
	public String save(Consumer consumer, RedirectAttributes redirectAttributes) {
		dao.save(consumer);
		redirectAttributes.addFlashAttribute("sucesso", "Cliente cadastrado com sucesso.");
		return "redirect:/consumer";
	}

}
