package br.com.cfsystems.erp.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cfsystems.erp.dao.ProductDAO;
import br.com.cfsystems.erp.models.Product;

@Controller
@Transactional
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductDAO dao;
	
	@RequestMapping(value={"", "/"}, method={RequestMethod.GET})
	public String home(Model model){
		model.addAttribute("products", dao.findAll());
		return "sys/product/index";
	}
	
	@RequestMapping(value={"/form"}, method={RequestMethod.GET })
	public String form(Model model, Product product) {
		return "sys/product/form";
	}

	@RequestMapping(value={"/save"}, method={ RequestMethod.POST})
	public String save(Product product, RedirectAttributes redirectAttributes) {
		dao.save(product);
		redirectAttributes.addFlashAttribute("sucesso", "Produto cadastrado com sucesso.");
		return "redirect:/product";
	}
}
