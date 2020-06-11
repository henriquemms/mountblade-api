package br.com.xibamba.mountblade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.xibamba.mountblade.model.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
