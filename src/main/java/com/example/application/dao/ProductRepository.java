package com.example.application.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.application.entities.Product;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
	@RestResource( path="/selectedProducts")
	public List<Product> findBySelectedIsFalse();
	@RestResource( path="/productsByKeyWord")
	@Query("Select p from Product p where p.name like %:x%")
	public List<Product> chercher(@Param("x") String mc);
	
}
