package br.com.cfsystems.erp.service;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cfsystems.erp.dao.AccountDAO;
import br.com.cfsystems.erp.dao.PaymentDAO;
import br.com.cfsystems.erp.models.Payment;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentDAO paymentDAO;
	@Autowired
	private AccountDAO accountDAO;
	
	@Transactional
	public void save(Payment payment) {
		paymentDAO.save(payment);
		accountDAO.updateAumontPaid(payment.getAccount());
	}
	
	public Collection<Payment> list(){
		return paymentDAO.findAll();
	}

}
