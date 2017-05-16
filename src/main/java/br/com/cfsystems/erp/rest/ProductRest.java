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

import br.com.cfsystems.erp.model.Product;
import br.com.cfsystems.erp.service.ProductService;

@RestController
@RequestMapping("/rest/product/")
public class ProductRest {
	
	@Autowired
	private ProductService service; 
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> listAll() {
        List<Product> products = (List<Product>) service.findAll();
        if(products.isEmpty()){
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
    public ResponseEntity<Product> save(@RequestBody Product product) {
        System.out.println("Criando produto " + product.getName());
        service.save(product);
        return new ResponseEntity<Product>(product, HttpStatus.CREATED);
    }
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Product> delete(@PathVariable("id") int id){
		Product product = service.find(id);
		System.out.println("Deletando produto " + product.getId());
		service.delete(id);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

}
