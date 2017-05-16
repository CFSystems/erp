package br.com.cfsystems.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cfsystems.erp.model.Consumer;
import br.com.cfsystems.erp.service.ConsumerService;

@Controller
@Transactional
@RequestMapping("/consumer")
public class ConsumerController {

	@Autowired
	private ConsumerService service;

	@RequestMapping(value = { "", "/" }, method = { RequestMethod.GET })
	public String home(Model model) {
		model.addAttribute("consumers", service.findAll());
		return "sys/consumer/index";
	}

	@RequestMapping(value = { "/form" }, method = { RequestMethod.GET })
	public String form(Consumer consumer) {
		return "sys/consumer/form";
	}

	@RequestMapping(value = { "/save" }, method = RequestMethod.POST)
	public String save(Consumer consumer, RedirectAttributes redirectAttributes) {
		service.save(consumer);
		redirectAttributes.addFlashAttribute("sucesso", "Cliente cadastrado com sucesso.");
		return "redirect:/consumer";
	}

	@RequestMapping(value = { "/edit-{id}" }, method = RequestMethod.GET)
	public String edit(@PathVariable int id, Model model) {
		Consumer consumer = service.find(id);
		model.addAttribute("consumer", consumer);
		model.addAttribute("edit", true);
		return "sys/consumer/form";
	}
	
	@RequestMapping(value = { "/delete-{id}" }, method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        service.delete(id);
        return "redirect:/consumer";
    }

}
