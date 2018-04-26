package com.cupcodeteam.cupcode.repository;

import com.cupcodeteam.cupcode.entity.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by YusReE_MS on 4/23/2018.
 */
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer>{

    @RestResource
    Product findOneById(@Param("id") Integer id);

    List<Product> findAll();
}
