package com.cupcodeteam.cupcode.repository;

import com.cupcodeteam.cupcode.entity.Service;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;



import java.util.List;

/**
 * Created by YusReE_MS on 4/10/2018.
 */
public interface ServiceRepository extends PagingAndSortingRepository<Service,Integer> {

    @RestResource
    List<Service> findAll();

    @RestResource
    Service findOneById(@Param("id") Integer id);
}
