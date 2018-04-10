package com.cupcodeteam.cupcode.controller.api;

import com.cupcodeteam.cupcode.entity.Partner;
import com.cupcodeteam.cupcode.helper.JsonViews;
import com.cupcodeteam.cupcode.repository.PartnerRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by YusReE_MS on 4/2/2018.
 */
@RestController
@RequestMapping("/api")
public class PartnerAPI {

    @Autowired
    private PartnerRepository partnerRepository;

//    @JsonView(JsonViews.All.class)
    @RequestMapping("/get_partner")
    public List<Partner> getPartnerList(){
        List<Partner> partner = this.partnerRepository.findAll();
        System.out.println(partner.get(0).getNameCompanyPartner());
        System.out.print(partner.size());
        return partner;
    }
}
