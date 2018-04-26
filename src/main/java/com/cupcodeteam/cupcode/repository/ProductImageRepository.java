package com.cupcodeteam.cupcode.repository;

import com.cupcodeteam.cupcode.entity.ProductImage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by YusReE_MS on 4/23/2018.
 */
public interface ProductImageRepository extends PagingAndSortingRepository<ProductImage, Long> {

    @RestResource
    ProductImage findOneById(@Param("id") Integer id);


    @Query("delete from ProductImage p where p.products_id = ?1")
    void deleteByProductsId(Integer id);
}
