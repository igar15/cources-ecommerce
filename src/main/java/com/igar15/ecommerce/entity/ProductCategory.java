package com.igar15.ecommerce.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "product_category")
//@Data - known bug with @OneToMany and @ManyToOne -> use @Getter & @Setter instead of it
@Getter
@Setter
public class ProductCategory extends AbstractBaseEntity {

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Product> products;
}
