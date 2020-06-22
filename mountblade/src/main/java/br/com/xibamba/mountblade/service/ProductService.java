package br.com.xibamba.mountblade.service;

import java.util.Date;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.xibamba.mountblade.model.entity.Product;
import br.com.xibamba.mountblade.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getProduct(/*String status*/){

		Product product = new Product();
		/*
		switch(status) {
		case "false":
			product.getDataControl().setDeleted(false);
			break;
		case "true":
			product.getDataControl().setDeleted(true);
			break;
		default:
			product.getDataControl().setDeleted(false);
		}
*/		
		product.getDataControl().setDeleted(false);
		Example<Product> example = Example.of(product);

		return this.productRepository.findAll(example);

	}

	public Product createProduct(Product product) {
		if(product.getId() != null) {
			throw new ServiceException("Não é possível salvar, pois o id está preenchido.");
		}
		
		product.getDataControl().markCreated(new Date());
		this.productRepository.save(product);
		
		return product;
	};
}
