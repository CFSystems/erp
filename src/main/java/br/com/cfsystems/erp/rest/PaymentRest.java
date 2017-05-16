package br.com.cfsystems.erp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cfsystems.erp.model.Payment;
import br.com.cfsystems.erp.service.PaymentService;

@RestController
@RequestMapping("/rest/payment/")
public class PaymentRest {
	
	@Autowired
	private PaymentService service; 
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<List<Payment>> listAll() {
        List<Payment> payments = (List<Payment>) service.findAll();
        if(payments.isEmpty()){
            return new ResponseEntity<List<Payment>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Payment>>(payments, HttpStatus.OK);
    }
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity<Payment> save(@RequestBody Payment payment) {
        System.out.println("Criando pagamento " + payment.getId());
        service.save(payment);
        return new ResponseEntity<Payment>(payment, HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Payment> delete(@PathVariable("id") int id){
		Payment payment = service.find(id);
		System.out.println("Deletando pagamento " + payment.getId());
		service.delete(id);
		return new ResponseEntity<Payment>(payment, HttpStatus.OK);
	}

}
