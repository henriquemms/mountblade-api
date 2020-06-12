package br.com.xibamba.mountblade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.xibamba.mountblade.model.entity.Product;
import br.com.xibamba.mountblade.service.ProductService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/list-product")
	@ApiOperation("Lista os produtos")
	public List<Product> listProduct(){
		return productService.getProduct();
	}

}
