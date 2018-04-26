package com.cupcodeteam.cupcode.controller.api;

import com.cupcodeteam.cupcode.entity.Personnel;
import com.cupcodeteam.cupcode.repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by YusReE_MS on 4/23/2018.
 */
@RestController
@RequestMapping("api")
public class PersonnelAPI {

    @Autowired
    private PersonnelRepository personnelRepository;

    @RequestMapping("/get_personnel")
    public List<Personnel> getPersonnelList(){
        List<Personnel> personnels = this.personnelRepository.findAll();

        return personnels;
    }
}
