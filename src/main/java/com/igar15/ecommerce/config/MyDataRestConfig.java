package com.igar15.ecommerce.config;

import com.igar15.ecommerce.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Autowired
    private EntityManager entityManager;

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        // disable HTTP methods for Product: POST, PUT, DELETE
        disableHttpMethods(config, theUnsupportedActions, Product.class);

        // disable HTTP methods for ProductCategory: POST, PUT, DELETE
        disableHttpMethods(config, theUnsupportedActions, ProductCategory.class);

        // disable HTTP methods for Country: POST, PUT, DELETE
        disableHttpMethods(config, theUnsupportedActions, Country.class);

        // disable HTTP methods for State: POST, PUT, DELETE
        disableHttpMethods(config, theUnsupportedActions, State.class);

        // call an internal helper method
        exposeIds(config);
    }

    private void disableHttpMethods(RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions, Class<? extends AbstractBaseEntity> entityClass) {
        config.getExposureConfiguration()
                .forDomainType(entityClass)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions)));
    }

    private void exposeIds(RepositoryRestConfiguration config) {
        // get a list of all entity classes from the entity manager
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        // create an array list of the entity types
        List<Class<?>> entityClasses = new ArrayList<>();

        // get the entity types for the entities
        for (EntityType entityType : entities) {
            entityClasses.add(entityType.getJavaType());
        }

        //expose the entity ids for the array of entity/domain types
        Class[] classes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(classes);
    }

}
