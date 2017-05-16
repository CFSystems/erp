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

import br.com.cfsystems.erp.model.Account;
import br.com.cfsystems.erp.service.AccountService;

@RestController
@RequestMapping("/rest/account/")
public class AccountRest {

	@Autowired
	private AccountService service; 
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<List<Account>> listAll() {
        List<Account> accounts = (List<Account>) service.findAll();
        if(accounts.isEmpty()){
            return new ResponseEntity<List<Account>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Account>>(accounts, HttpStatus.OK);
    }
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity<Account> save(@RequestBody Account account) {
        System.out.println("Criando conta " + account.getId());
        service.save(account);
        return new ResponseEntity<Account>(account, HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Account> delete(@PathVariable("id") int id){
		Account account = service.find(id);
		System.out.println("Deletando conta " + account.getId());
		service.delete(id);
		return new ResponseEntity<Account>(account, HttpStatus.OK);
	}
	
}
