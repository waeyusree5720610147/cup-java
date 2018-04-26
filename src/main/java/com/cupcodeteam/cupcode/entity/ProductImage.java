package com.cupcodeteam.cupcode.entity;

import javax.persistence.*;

/**
 * Created by YusReE_MS on 4/23/2018.
 */
@Entity
@Table(name = "product_image")
public class ProductImage {

    private Integer id;
    private Integer products_id;
    private String url;

    private Product product_id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_imagepro")
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    @Basic
    @Column(name="fk_id_product")
    public Integer getProducts_id() {
        return products_id;
    }

    public void setProducts_id(Integer products_id) {
        this.products_id = products_id;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_id_product", referencedColumnName = "id_pro", insertable = false, updatable = false)
    public Product getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Product product_id) {
        this.product_id = product_id;
    }


}
