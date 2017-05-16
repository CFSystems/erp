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

import br.com.cfsystems.erp.model.User;
import br.com.cfsystems.erp.service.UserService;

@RestController
@RequestMapping("/rest/user/")
public class UserRest {
	
	@Autowired
	private UserService service; 
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAll() {
        List<User> users = (List<User>) service.findAll();
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity<User> save(@RequestBody User user) {
        System.out.println("Criando usuário " + user.getName());
        service.save(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<User> delete(@PathVariable("id") int id){
		User user = service.find(id);
		System.out.println("Deletando usuário " + user.getName());
		service.delete(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

}
