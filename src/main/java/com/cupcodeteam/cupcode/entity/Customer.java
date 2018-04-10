package com.cupcodeteam.cupcode.entity;

import javax.persistence.*;

/**
 * Created by YusReE_MS on 4/2/2018.
 */
@Entity
public class Customer {

    private Integer id;
    private String nameCompanyCustomer;
    private String logoCustomer;
    private String linkCustomer;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "n_company")
    public String getNameCompanyCustomer() {
        return nameCompanyCustomer;
    }

    public void setNameCompanyCustomer(String nameCompanyCustomer) {
        this.nameCompanyCustomer = nameCompanyCustomer;
    }

    @Basic
    @Column(name = "logo")
    public String getLogoCustomer() {
        return logoCustomer;
    }

    public void setLogoCustomer(String logoCustomer) {
        this.logoCustomer = logoCustomer;
    }

    @Basic
    @Column(name = "link")
    public String getLinkCustomer() {
        return linkCustomer;
    }

    public void setLinkCustomer(String linkCustomer) {
        this.linkCustomer = linkCustomer;
    }
}