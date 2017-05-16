package br.com.cfsystems.erp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.cfsystems.erp.model.Payment;
import br.com.cfsystems.erp.service.PaymentService;

@Controller
@Transactional
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@RequestMapping(value={"", "/"}, method={RequestMethod.GET})
	public String home(Model model){
		model.addAttribute("payments", paymentService.findAll());
		return "sys/payment/index";
	}
	
	@RequestMapping(value={"/form"}, method={RequestMethod.GET})
	public String form(Payment payments) {
		return "sys/payment/form";
	}

	@RequestMapping(value={"/save"}, method = RequestMethod.POST)
	public String save(Payment payment, RedirectAttributes redirectAttributes) {
		paymentService.save(payment);
		redirectAttributes.addAttribute("sucesso", "Pagamento cadastrado com sucesso.");
		return "redirect:/payment";
	}

}
