package br.com.xibamba.mountblade.model.dto;

import br.com.xibamba.mountblade.model.entity.Product;
import lombok.Data;

@Data
public class ProductUpdateDto {

	private Long id;
	private String name_en;
	private String name_br;
	
	public Product productUpdateDTO() {
		
		Product product = new Product();
		product.setId(this.id);
		product.setName_en(this.name_en);
		product.setName_br(this.name_br);
		
		return product;
	}
	
}
