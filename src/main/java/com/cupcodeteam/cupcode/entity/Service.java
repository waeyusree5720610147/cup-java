package com.cupcodeteam.cupcode.entity;

import javax.persistence.*;

/**
 * Created by YusReE_MS on 4/10/2018.
 */
@Entity
public class Service {
    private Integer id;
    private String nameService;
    private String iconService;
    private String detailShort;
    private String detailLong;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ser")
    public Integer getId(){ return id;}

    public void setId(Integer id) { this.id = id;}

    @Basic
    @Column(name = "n_service")
    public String getNameService() { return nameService; }

    public void setNameService(String nameService) { this.nameService = nameService; }

    @Basic
    @Column(name = "icon")
    public String getIconService() { return iconService; }

    public void setIconService(String iconService) { this.iconService = iconService; }

    @Basic
    @Column(name = "detail_short")
    public String getDetailShort() { return detailShort; }

    public void setDetailShort(String detailShort) { this.detailShort = detailShort; }

    @Basic
    @Column(name = "detail_long")
    public String getDetailLong() { return detailLong; }

    public void setDetailLong(String detailLong) { this.detailLong = detailLong; }

}
