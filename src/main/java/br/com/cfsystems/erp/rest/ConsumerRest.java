package br.com.cfsystems.erp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.cfsystems.erp.dao.ConsumerDAO;
import br.com.cfsystems.erp.models.Consumer;

@RestController
public class ConsumerRest {
	
	@Autowired
	private ConsumerDAO dao; 
	
	@RequestMapping(value = "/listConsumer/", method = RequestMethod.GET)
    public ResponseEntity<List<Consumer>> listAllUsers() {
        List<Consumer> consumers = (List<Consumer>) dao.findAll();
        if(consumers.isEmpty()){
            return new ResponseEntity<List<Consumer>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Consumer>>(consumers, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/createConsumer/", method = RequestMethod.POST)
    public ResponseEntity<Void> createConsumer(@RequestBody Consumer consumer, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Consumer " + consumer.getName());
 
        dao.save(consumer);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/consumer/{id}").buildAndExpand(consumer.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

}
