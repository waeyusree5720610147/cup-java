package com.cupcodeteam.cupcode.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by YusReE_MS on 3/26/2018.
 */
@Controller
@RequestMapping("/admin")
public class PersonnelController {
    @RequestMapping("/personnel")
    public String personnel(){
        return "personnel/personnel";
    }
}
