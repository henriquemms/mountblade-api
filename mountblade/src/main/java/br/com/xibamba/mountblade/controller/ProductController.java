package br.com.xibamba.mountblade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.xibamba.mountblade.model.dto.ProductCreateDto;
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
	public List<Product> listProduct(/*@RequestBody String status*/){
		return productService.getProduct(/*status*/);
	}
	
	@PostMapping("create")
	@ApiOperation("Cria um produto")
	public Product create(@RequestBody ProductCreateDto productCreateDto) {
		Product product = productCreateDto.productCreateDto();
		
		this.productService.createProduct(product);
		
		return product;
	}

}
