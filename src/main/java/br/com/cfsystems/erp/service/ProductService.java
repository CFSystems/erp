package br.com.cfsystems.erp.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cfsystems.erp.dao.ProductDAO;
import br.com.cfsystems.erp.models.Product;

@Service
public class ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	public Collection<Product> list(){
		return productDAO.findAll();
	}

}
