package br.com.cfsystems.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cfsystems.erp.model.Purchase;
import br.com.cfsystems.erp.service.ProductService;
import br.com.cfsystems.erp.service.PurchaseService;

@Controller
@Transactional
@RequestMapping("/purchase")
public class PurchaseController {
	
	@Autowired
	private PurchaseService purchaseService;
	@Autowired
	private ProductService productService;

	@RequestMapping(value={"", "/"}, method={RequestMethod.GET,RequestMethod.POST})
	public String home(Model model) {
		model.addAttribute("purchases", purchaseService.findAll());
		return "sys/purchase/index";
	}

	@RequestMapping(value={"/form"}, method={RequestMethod.GET,RequestMethod.POST})
	public String form(Model model, Purchase Purchase) {
		model.addAttribute("products", productService.findAll());
		return "sys/purchase/form";
	}

	@RequestMapping(value={"/save"}, method = RequestMethod.POST )
	public String save(@ModelAttribute Purchase purchase, RedirectAttributes redirectAttributes) {
		purchaseService.save(purchase);
		redirectAttributes.addFlashAttribute("sucesso", "Pedido cadastrado com sucesso.");
		return "redirect:/purchase";
	}

}
