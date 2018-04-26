package com.cupcodeteam.cupcode.controller.admin;

import com.cupcodeteam.cupcode.entity.Pathimage;
import com.cupcodeteam.cupcode.entity.Service;
import com.cupcodeteam.cupcode.repository.ServiceRepository;
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
 * Created by YusReE_MS on 3/23/2018.
 */
@Controller
@RequestMapping("/admin")
public class ServiceController {

    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private FileUploadService fileUploadService;

    @RequestMapping("/service")
    public String service( Model model){
        List<Service> Service;
        Service = this.serviceRepository.findAll();
        model.addAttribute("service", Service);
        model.addAttribute("page_active","service");

        return "service/service";
    }

    @RequestMapping("/service/add")
    public String addService(Model model){
        model.addAttribute("service", new Service());
        model.addAttribute("keywords", true);
        model.addAttribute("page_active","service");

        return "service/serviceForm";
    }

    @RequestMapping(value = "/service/save", method = RequestMethod.POST)
    public String saveService(
            Service service,
            RedirectAttributes redirectAttributes,
            @RequestParam(value = "file", required = false)MultipartFile file
    ){
        Pathimage imageFileMetadata = null;

        if(this.fileUploadService.canUpload(file)){
            imageFileMetadata = this.fileUploadService.uploadFile(file);
            System.out.print(imageFileMetadata);
        }

        try {
            if(imageFileMetadata != null){
                service.setIconService(imageFileMetadata.getUrl_image());
                serviceRepository.save(service);
            }

            if(service.getId() == null) {
                serviceRepository.save(service);
            }else {
                Service oldservice = this.serviceRepository.findOneById(service.getId());
                oldservice.setNameService(service.getNameService());
                oldservice.setDetailShort(service.getDetailShort());
                oldservice.setDetailLong(service.getDetailLong());

                serviceRepository.save(oldservice);

            }
            redirectAttributes.addFlashAttribute("successMassage", "Save Success!");
            return "redirect:/admin/service";

        }catch (Exception ex){
            redirectAttributes.addFlashAttribute("errorMessage", "Cannot Save Banner!");
            return "redirect:/admin/service";
        }
    }

    @RequestMapping("/service/edit/{id}")
    public String editService(
            @PathVariable int id,
            Model model
    ){
        Service service;
        service = this.serviceRepository.findOneById(id);
        model.addAttribute("service", service);
        model.addAttribute("keywords", false);
        model.addAttribute("page_active","service");

        return "service/serviceForm";
    }

    @RequestMapping("/service/delete/{id}")
    public String deleteService(
            @PathVariable int id,
            Model model
    ){
        serviceRepository.deleteById(id);
        return "redirect:/admin/service";
    }
}
