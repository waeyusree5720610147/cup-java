package com.cupcodeteam.cupcode.controller.admin;

import com.cupcodeteam.cupcode.entity.Pathimage;
import com.cupcodeteam.cupcode.entity.Personnel;
import com.cupcodeteam.cupcode.helper.JsonViews;
import com.cupcodeteam.cupcode.repository.PersonnelRepository;
import com.cupcodeteam.cupcode.service.FileUploadService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

/**
 * Created by YusReE_MS on 3/26/2018.
 */
@Controller
@RequestMapping("/admin")
public class PersonnelController {

    @Autowired
    private PersonnelRepository personnelRepository;
    @Autowired
    private FileUploadService fileUploadService;

    @RequestMapping("/personnel")
    public String personnel(Model model){
        List<Personnel> personnel;
        personnel = this.personnelRepository.findAll();
        model.addAttribute("personnel", personnel);
        model.addAttribute("page_active","personnel");

        return "personnel/personnel";
    }

    @RequestMapping("/personnel/add")
    public String addPersonnel(Model model){
        model.addAttribute("personnel", new Personnel());
        model.addAttribute("keywords", true);
        model.addAttribute("page_active","personnel");

        return "personnel/personnelForm";
    }

    @RequestMapping(value = "/personnel/save", method = RequestMethod.POST)
    public String savePersonnel(
            Personnel personnel,
            RedirectAttributes redirectAttributes,
            @RequestParam(value = "file", required = false) MultipartFile file
    ){
        Pathimage imageFileMetadata = null;

        if(this.fileUploadService.canUpload(file)){
            imageFileMetadata = this.fileUploadService.uploadFile(file);
            System.out.print(imageFileMetadata);
        }

        try {
            if(imageFileMetadata != null){
                personnel.setImage(imageFileMetadata.getUrl_image());
                personnelRepository.save(personnel);
            }

            if(personnel.getId() == null) {
                personnelRepository.save(personnel);
            }
            else {
                Personnel oldpersonnel = this.personnelRepository.findOneById(personnel.getId());
                oldpersonnel.setName_sername(personnel.getName_sername());
                oldpersonnel.setNickname(personnel.getNickname());
                oldpersonnel.setPosition(personnel.getPosition());
                oldpersonnel.setBirthday(personnel.getBirthday());
                oldpersonnel.setTell(personnel.getTell());
                oldpersonnel.setEmail_per(personnel.getEmail_per());
                oldpersonnel.setFacebook(personnel.getFacebook());
                oldpersonnel.setLine(personnel.getLine());
                oldpersonnel.setTwitter(personnel.getTwitter());
                oldpersonnel.setInstagram(personnel.getInstagram());

                personnelRepository.save(oldpersonnel);

            }
            redirectAttributes.addFlashAttribute("successMassage", "Save Success!");
            return "redirect:/admin/personnel";

        }catch (Exception ex){
            redirectAttributes.addFlashAttribute("errorMessage", "Cannot Save Banner!");
            return "redirect:/admin/personnel";
        }
    }

    @RequestMapping("/personnel/edit/{id}")
    public String editPersonnel(
            Model model,
            @PathVariable int id
    ){
        Personnel personnel;
        personnel = this.personnelRepository.findOneById(id);
        model.addAttribute("personnel", personnel);
        model.addAttribute("keywords", false);
        model.addAttribute("page_active","personnel");

        return "personnel/personnelForm";
    }

    @RequestMapping("/personnel/delete/{id}")
    public String deletePersonnel(
            @PathVariable int id
    ){
        personnelRepository.deleteById(id);
        return "redirect:/admin/personnel";
    }

    @RequestMapping("/personnel/description")
    public @ResponseBody Personnel descriptionPersonnel(
//            Model model,
            @RequestParam(value = "id", required = true) int id
    ){
//        ObjectMapper mapper = new ObjectMapper();
        Personnel personnel;
        personnel = this.personnelRepository.findOneById(id);
        return personnel;
//        try{
//            String normalView = mapper.writerWithView(JsonViews.Normal.class).writeValueAsString(personnel);
//            System.out.println("DDDDDDD = " + normalView);

//        }catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }

//        model.addAttribute("personnel", personnel);
//        model.addAttribute("keywords", false);
//        return "personnel/personnel_profile";

    }

}
