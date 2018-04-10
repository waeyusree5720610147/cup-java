package com.cupcodeteam.cupcode.repository;

import com.cupcodeteam.cupcode.entity.Partner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by YusReE_MS on 3/27/2018.
 */
public interface PartnerRepository extends PagingAndSortingRepository<Partner, Integer> {

    @RestResource
    List<Partner> findAll();

//    @RestResource
//    Page<Partner> findAllByOrderByIdAsc(Pageable pageable);

    @RestResource
    Partner findOneById(@Param("id") Integer id);



}
