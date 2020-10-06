package com.igar15.ecommerce.dao;

import com.igar15.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category") //override default name of JSON entry and default rest path
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
