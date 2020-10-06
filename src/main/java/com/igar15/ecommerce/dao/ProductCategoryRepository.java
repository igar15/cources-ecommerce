package com.igar15.ecommerce.dao;

import com.igar15.ecommerce.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category") //override default name of JSON entry and default rest path
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
