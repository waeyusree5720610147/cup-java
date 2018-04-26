package com.cupcodeteam.cupcode.entity;

import javax.persistence.*;

/**
 * Created by YusReE_MS on 4/3/2018.
 */
@Entity
@Table(name = "pathimage")
public class Pathimage {

    private Integer id;
    private String path_image;
    private String url_image;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() { return id;}

    public void setId(Integer id) {this.id = id; }

    @Basic
    @Column(name = "path")
    public String getPath_image() { return path_image; }

    public void setPath_image(String path_image) {
        this.path_image = path_image;
    }

    @Basic
    @Column(name = "url")
    public String getUrl_image() { return  url_image;}

    public void setUrl_image(String url_image) { this.url_image = url_image;}
}
