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

import br.com.cfsystems.erp.model.Purchase;
import br.com.cfsystems.erp.service.PurchaseService;

@RestController
@RequestMapping("/rest/puchase/")
public class PurchaseRest {
	
	@Autowired
	private PurchaseService service; 
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<List<Purchase>> listAll() {
        List<Purchase> purchases = (List<Purchase>) service.findAll();
        if(purchases.isEmpty()){
            return new ResponseEntity<List<Purchase>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Purchase>>(purchases, HttpStatus.OK);
    }
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        System.out.println("Criando pedido " + purchase.getId());
        service.save(purchase);
        return new ResponseEntity<Purchase>(purchase, HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Purchase> delete(@PathVariable("id") int id){
		Purchase purchase = service.find(id);
		System.out.println("Deletando pedido " + purchase.getId());
		service.delete(id);
		return new ResponseEntity<Purchase>(purchase, HttpStatus.OK);
	}

}
