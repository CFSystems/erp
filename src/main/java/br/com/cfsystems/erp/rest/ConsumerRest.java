package br.com.cfsystems.erp.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cfsystems.erp.model.Consumer;
import br.com.cfsystems.erp.service.ConsumerService;

@RestController
@RequestMapping("/rest/consumer")
public class ConsumerRest {
	
	@Autowired
	private ConsumerService service; 
	
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Consumer>> listAll() {
        List<Consumer> consumers = (List<Consumer>) service.findAll();
        if(consumers.isEmpty()){
            return new ResponseEntity<List<Consumer>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Consumer>>(consumers, HttpStatus.OK);
    }
	
	@RequestMapping(value={"/save"}, method = RequestMethod.POST)
    public ResponseEntity<Consumer> save(@Valid @RequestBody Consumer consumer, BindingResult bindingResult) {
		
		/**
		 * VALIDA AS ANOTACOES SOBRE OS ATRIBUTOS DA ENTITY
		 * *** DAR PREFERENCIA PARA CLASSES DE VALIDACAO DO PACOTE javax.validation.*
		 */
		if (bindingResult.hasErrors()) {
			//REDIRECIONAR MENSAGEM DE ERRO AO USUARIO.
		}
		
		service.save(consumer);
        return new ResponseEntity<Consumer>(consumer, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Consumer> delete(@PathVariable("id") int id){
		Consumer consumer = service.find(id);
		System.out.println("Deletando cliente " + consumer.getName());
		service.delete(id);
		return new ResponseEntity<Consumer>(consumer, HttpStatus.OK);
	}

}
