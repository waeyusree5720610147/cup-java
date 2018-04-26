package com.cupcodeteam.cupcode.entity;

import javax.persistence.*;

/**
 * Created by YusReE_MS on 3/26/2018.
 */
@Entity
@Table(name = "partner")
public class Partner {

    private Integer id;
    private String nameCompanyPartner;
    private String logoPartner;
    private String linkPartner;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId(){ return id;}

    public void setId(Integer id) { this.id = id; }

    @Basic
    @Column(name = "n_company")
    public String getNameCompanyPartner(){ return nameCompanyPartner;}

    public void setNameCompanyPartner(String nameCompanyPartner) { this.nameCompanyPartner = nameCompanyPartner; }

    @Basic
    @Column(name = "logo")
    public String getLogoPartner() { return logoPartner;}

    public void setLogoPartner( String logoPartner) { this.logoPartner = logoPartner; }

    @Basic
    @Column(name = "link")
    public String getLinkPartner() { return linkPartner;}

    public void setLinkPartner(String linkPartner) {this.linkPartner = linkPartner;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Partner partner = (Partner) o;

        if (id != null ? !id.equals(partner.id) : partner.id != null) return false;
        if (nameCompanyPartner != null ? !nameCompanyPartner.equals(partner.nameCompanyPartner) : partner.nameCompanyPartner != null)
            return false;
        if (logoPartner != null ? !logoPartner.equals(partner.logoPartner) : partner.logoPartner != null) return false;
        return linkPartner != null ? linkPartner.equals(partner.linkPartner) : partner.linkPartner == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nameCompanyPartner != null ? nameCompanyPartner.hashCode() : 0);
        result = 31 * result + (logoPartner != null ? logoPartner.hashCode() : 0);
        result = 31 * result + (linkPartner != null ? linkPartner.hashCode() : 0);
        return result;
    }
}
