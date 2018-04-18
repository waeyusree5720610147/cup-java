package com.cupcodeteam.cupcode.repository;

import com.cupcodeteam.cupcode.entity.Personnel;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by YusReE_MS on 4/11/2018.
 */
public interface PersonnelRepository  extends PagingAndSortingRepository<Personnel, Integer> {
    @RestResource
    List<Personnel> findAll();

    @RestResource
    Personnel findOneById(@Param("id") Integer id);
}
