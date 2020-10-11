package com.igar15.ecommerce.dao;

import com.igar15.ecommerce.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "countries", path = "countries") //override default name of JSON entry and default rest path
public interface CountryRepository extends JpaRepository<Country, Long> {
}
