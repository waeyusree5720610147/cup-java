package com.cupcodeteam.cupcode.controller.admin;

import com.cupcodeteam.cupcode.entity.Partner;
import com.cupcodeteam.cupcode.entity.Pathimage;
import com.cupcodeteam.cupcode.repository.PartnerRepository;
import com.cupcodeteam.cupcode.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by YusReE_MS on 3/26/2018.
 */
@Controller
@RequestMapping("/admin")
public class PartnerController {

    @Autowired
    private PartnerRepository partnerRepository;
    @Autowired
    private FileUploadService fileUploadService;

    @RequestMapping("/partner")
    public String partner( Model model){
        List<Partner> Partner;
        Partner = this.partnerRepository.findAll();
        model.addAttribute("partner", Partner);
        model.addAttribute("page_active","partner");

        return "partner/partner";
    }

    @RequestMapping("/partner/add")
    public String addPartner(Model model){
        model.addAttribute("partner", new Partner());
        model.addAttribute("keywords", true);
        model.addAttribute("page_active","partner");

        return "partner/partnerForm";
    }

    @RequestMapping(value = "/partner/save", method = RequestMethod.POST)
    public String savePartner(
            Partner partner,
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
                partner.setLogoPartner(imageFileMetadata.getUrl_image());
                partnerRepository.save(partner);
            }

            if(partner.getId() == null) {
//            System.out.print("555555");
//            fileUploadService.uploadFile(logoPartner);
                partnerRepository.save(partner);
            }else {
                Partner oldpartner = this.partnerRepository.findOneById(partner.getId());
                oldpartner.setNameCompanyPartner(partner.getNameCompanyPartner());
                oldpartner.setLinkPartner(partner.getLinkPartner());

                partnerRepository.save(oldpartner);

            }
            redirectAttributes.addFlashAttribute("successMassage", "Save Success!");
            return "redirect:/admin/partner";

        }catch (Exception ex){
            redirectAttributes.addFlashAttribute("errorMessage", "Cannot Save Banner!");
            return "redirect:/admin/partner";
        }

    }

    @RequestMapping("/partner/edit/{id}")
    public String editPartner(
            @PathVariable int id,
            Model model
    ){
        Partner Partner;
        Partner = this.partnerRepository.findOneById(id);
        model.addAttribute("partner", Partner);
        model.addAttribute("keywords", false);
        model.addAttribute("page_active","partner");

        return "partner/partnerForm";
    }

    @RequestMapping("/partner/delete/{id}")
    public String deletePartner(
            @PathVariable int id
    ){
        partnerRepository.deleteById(id);
        return "redirect:/admin/partner";
    }
}
