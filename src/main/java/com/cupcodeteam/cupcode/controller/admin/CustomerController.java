package com.cupcodeteam.cupcode.controller.admin;

import com.cupcodeteam.cupcode.entity.Customer;
import com.cupcodeteam.cupcode.entity.Pathimage;
import com.cupcodeteam.cupcode.repository.CustomerRepository;
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
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private FileUploadService fileUploadService;

    @RequestMapping("/customer")
    public String customer( Model model ){
        List<Customer> Customer;
        Customer = this.customerRepository.findAll();
        model.addAttribute("customer", Customer);
        model.addAttribute("page_active","customer");

        return "customer/customer";
    }

    @RequestMapping("/customer/add")
    public String addCustomer(Model model){
        model.addAttribute("customer", new Customer());
        model.addAttribute("keywords", true);
        model.addAttribute("page_active","customer");

        return "customer/customerForm";
    }

    @RequestMapping(value = "/customer/save", method = RequestMethod.POST)
    public String saveCustomer(
            Customer customer,
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
                customer.setLogoCustomer(imageFileMetadata.getUrl_image());
                customerRepository.save(customer);
            }

            if(customer.getId() == null) {
                customerRepository.save(customer);
            }else {
                Customer oldcustomer = this.customerRepository.findOneById(customer.getId());
                oldcustomer.setNameCompanyCustomer(customer.getNameCompanyCustomer());
                oldcustomer.setLinkCustomer(customer.getLinkCustomer());

                customerRepository.save(oldcustomer);

            }
            redirectAttributes.addFlashAttribute("successMassage", "Save Success!");
            return "redirect:/admin/customer";

        }catch (Exception ex){
            redirectAttributes.addFlashAttribute("errorMessage", "Cannot Save Banner!");
            return "redirect:/admin/customer";
        }
    }

    @RequestMapping("/customer/edit/{id}")
    public String editCustomer(
            @PathVariable int id,
            Model model
    ){
        Customer customer;
        customer = this.customerRepository.findOneById(id);
        model.addAttribute("customer", customer);
        model.addAttribute("keywords", false);
        model.addAttribute("page_active","customer");
//        model.addAttribute("customer", customerRepository.findById(id));

        return "customer/customerForm";
    }

    @RequestMapping("/customer/delete/{id}")
    public String deleteCustomer(
            @PathVariable int id
    ){
        customerRepository.deleteById(id);
        return "redirect:/admin/customer";
    }
}
