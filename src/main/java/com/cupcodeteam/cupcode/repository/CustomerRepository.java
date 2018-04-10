package com.cupcodeteam.cupcode.repository;

import com.cupcodeteam.cupcode.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by YusReE_MS on 4/2/2018.
 */
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {

    @RestResource
    List<Customer> findAll();

    @RestResource
    Customer findOneById(@Param("id") Integer id);
}
