package com.cupcodeteam.cupcode.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by YusReE_MS on 4/23/2018.
 */
@Entity
@Table(name = "product")
public class Product {
    private Integer id;
    private String nameproduct;
    private String detailshort;
    private String detaillong;
    private Integer numberofcustomer;
    private Integer numberofmembers;
    private Integer amountofcontent;
    private String linkappstore;
    private String linkgoogleplay;
    private String linkpage;
    private String contact;

    private List<ProductImage> productImageset;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pro")
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    @Basic
    @Column(name = "n_product")
    public String getNameproduct() { return nameproduct; }

    public void setNameproduct(String nameproduct ) { this.nameproduct = nameproduct; }

    @Basic
    @Column(name = "detail_short")
    public String getDetailshort() { return detailshort; }

    public void setDetailshort(String detailshort) { this.detailshort = detailshort; }

    @Basic
    @Column(name = "detail_long")
    public String getDetaillong() { return detaillong; }

    public void setDetaillong(String detaillong) { this.detaillong = detaillong; }

    @Basic
    @Column(name = "number_of_customer")
    public Integer getNumberofcustomer() { return numberofcustomer; }

    public void setNumberofcustomer(Integer numberofcustomer) { this.numberofcustomer = numberofcustomer; }

    @Basic
    @Column(name = "number_of_members")
    public Integer getNumberofmembers() { return numberofmembers; }

    public void setNumberofmembers(Integer numberofmembers) { this.numberofmembers = numberofmembers; }

    @Basic
    @Column(name = "amount_of_content")
    public Integer getAmountofcontent() { return amountofcontent; }

    public void setAmountofcontent(Integer amountofcontent) { this.amountofcontent = amountofcontent; }

    @Basic
    @Column(name = "link_appstore")
    public String getLinkappstore() { return linkappstore; }

    public void setLinkappstore(String linkappstore) { this.linkappstore = linkappstore; }

    @Basic
    @Column(name = "link_googleplay")
    public String getLinkgoogleplay() { return linkgoogleplay; }

    public void setLinkgoogleplay(String linkgoogleplay) { this.linkgoogleplay = linkgoogleplay; }

    @Basic
    @Column(name = "link_page")
    public String getLinkpage() { return linkpage; }

    public void setLinkpage(String linkpage) { this.linkpage = linkpage; }

    @Basic
    @Column(name = "contact")
    public String getContact() { return contact; }

    public void setContact(String contact) { this.contact = contact; }

    @OneToMany(fetch =FetchType.LAZY, mappedBy = "product_id", cascade = CascadeType.ALL)
    public List<ProductImage> getProductImageset(){ return productImageset; }

    public void setProductImageset(List<ProductImage> productImageset) { this.productImageset = productImageset; }

}
