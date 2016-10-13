package br.com.cfsystems.erp.service;

import java.math.BigDecimal;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cfsystems.erp.dao.AccountDAO;
import br.com.cfsystems.erp.dao.ProductDAO;
import br.com.cfsystems.erp.dao.PurchaseDAO;
import br.com.cfsystems.erp.dao.PurchaseProductDAO;
import br.com.cfsystems.erp.models.Product;
import br.com.cfsystems.erp.models.Purchase;
import br.com.cfsystems.erp.models.PurchaseProduct;

@Service
public class PurchaseService {

	@Autowired
	private PurchaseDAO purchaseDAO;
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private AccountDAO accountDAO;
	@Autowired
	private PurchaseProductDAO purchaseProductDAO;

	@Transactional(rollbackFor = Exception.class)
	public void save(Purchase purchase) {
		try {
			purchaseDAO.save(purchase);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Product product = null;
		for (PurchaseProduct pp : purchase.getPurchaseProducts()) {
			if (pp.getProduct() != null && pp.getProduct().getId() != null) {
				product = productDAO.find(pp.getProduct().getId());
				pp.setProduct(product);
				pp.setAmount(pp.getUnitaryValue().multiply(new BigDecimal(pp.getQuantity())));
				pp.setPurchase(purchase);
				try {
					purchaseProductDAO.save(pp);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		try {
			purchaseDAO.updateValue(purchase);
			accountDAO.updateAumontSpent(purchase.getAccount());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Collection<Purchase> list() {
		return purchaseDAO.findAll();
	}

}
