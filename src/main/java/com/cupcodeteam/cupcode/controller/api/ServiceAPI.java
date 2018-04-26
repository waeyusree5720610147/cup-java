package com.cupcodeteam.cupcode.controller.api;

import com.cupcodeteam.cupcode.entity.Service;
import com.cupcodeteam.cupcode.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by YusReE_MS on 4/23/2018.
 */
@RestController
@RequestMapping("/api")
public class ServiceAPI {

    @Autowired
    private ServiceRepository serviceRepository;

    @RequestMapping("/get_service")
    public List<Service> getServiceList(){
        List<Service> services = this.serviceRepository.findAll();

        return services;
    }
}
