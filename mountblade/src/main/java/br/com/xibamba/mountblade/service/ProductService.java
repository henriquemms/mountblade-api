package br.com.xibamba.mountblade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.xibamba.mountblade.model.entity.Product;
import br.com.xibamba.mountblade.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getProduct(){
		
		Product product = new Product();
		
		product.getDataControl().setDeleted(false);
		
		Example<Product> example = Example.of(product);
		
		return this.productRepository.findAll(example);
		
	}

}
