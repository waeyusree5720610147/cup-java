package com.cupcodeteam.cupcode.controller.admin;

import com.cupcodeteam.cupcode.entity.Pathimage;
import com.cupcodeteam.cupcode.entity.Product;
import com.cupcodeteam.cupcode.entity.ProductImage;
import com.cupcodeteam.cupcode.repository.ProductImageRepository;
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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by YusReE_MS on 4/25/2018.
 */
@Controller
@RequestMapping("/admin")
public class productImageController {

    @Autowired
    private ProductImageRepository productImageRepository;

    @Autowired
    private FileUploadService fileUploadService;

    @RequestMapping("/addImage/{id}")
    public String addImage(
            Model model,
            @PathVariable int id
    ){
        model.addAttribute("productImage", new ProductImage());
        model.addAttribute("product_id", id);
        model.addAttribute("page_active","product");

        return "productImage/productImageForm";
    }

    @RequestMapping(value = "/productImage/save", method = RequestMethod.POST)
    public String saveProductImage(
            ProductImage productImage,
            RedirectAttributes redirectAttributes,
            @RequestParam(value = "file", required = false) MultipartFile []files
    ){
        Pathimage imageFileMetadata = null;
        Integer id = 0;

        for (MultipartFile file: files){
            if (this.fileUploadService.canUpload(file)) {
                imageFileMetadata = this.fileUploadService.uploadFile(file);
            }
            if(imageFileMetadata != null){
                productImage.setId(id);
                productImage.setUrl(imageFileMetadata.getUrl_image());
                productImageRepository.save(productImage);
            }
            id++;
        }
        redirectAttributes.addFlashAttribute("successMassage", "Save Success!");
        return "redirect:/admin/product";
    }

    @RequestMapping("/product/delete/{id}")
    public String deleteProduct(
            @PathVariable int id
    ){
        productImageRepository.deleteByProductsId(id);
//        productRepository.deleteById(id);

        return null;
    }
}
