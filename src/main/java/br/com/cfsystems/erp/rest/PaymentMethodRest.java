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

import br.com.cfsystems.erp.model.PaymentMethod;
import br.com.cfsystems.erp.service.PaymentMethodService;

@RestController
@RequestMapping("/rest/paymentmethod/")
public class PaymentMethodRest {
	
	@Autowired
	private PaymentMethodService service; 
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<List<PaymentMethod>> listAll() {
        List<PaymentMethod> paymentsMethod = (List<PaymentMethod>) service.findAll();
        if(paymentsMethod.isEmpty()){
            return new ResponseEntity<List<PaymentMethod>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<PaymentMethod>>(paymentsMethod, HttpStatus.OK);
    }
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity<PaymentMethod> save(@RequestBody PaymentMethod paymentMethod) {
        System.out.println("Criando forma de pagamento " + paymentMethod.getName());
        service.save(paymentMethod);
        return new ResponseEntity<PaymentMethod>(paymentMethod, HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<PaymentMethod> delete(@PathVariable("id") int id){
		PaymentMethod paymentMethod = service.find(id);
		System.out.println("Deletando forma de pagamento " + paymentMethod.getId());
		service.delete(id);
		return new ResponseEntity<PaymentMethod>(paymentMethod, HttpStatus.OK);
	}
}
