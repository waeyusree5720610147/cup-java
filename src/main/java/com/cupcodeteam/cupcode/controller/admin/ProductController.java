package com.cupcodeteam.cupcode.controller.admin;

import com.cupcodeteam.cupcode.entity.Product;
import com.cupcodeteam.cupcode.repository.ProductImageRepository;
import com.cupcodeteam.cupcode.repository.ProductRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Created by YusReE_MS on 3/26/2018.
 */
@Controller
@RequestMapping("/admin")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductImageRepository productImageRepository;

    @RequestMapping("/product")
    public String product(Model model){
        List<Product> products;
        products = productRepository.findAll();
//        System.out.print(products.get(0).getProductImageset().get(1));
        model.addAttribute("products", products);
        model.addAttribute("page_active","product");

        return "product/product";
    }

    @RequestMapping("/product/add")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("keywords", true);
        model.addAttribute("page_active","product");

        return "product/productForm";
    }

    @RequestMapping(value = "/product/save", method = RequestMethod.POST)
    public String saveProduct(
            Product product,
            RedirectAttributes redirectAttributes
    ){
        try {

            if(product.getId() == null ){
                productRepository.save(product);
            }else {
                Product oldproduct = this.productRepository.findOneById(product.getId());
                oldproduct.setNameproduct(product.getNameproduct());
                oldproduct.setDetailshort(product.getDetailshort());
                oldproduct.setDetaillong(product.getDetaillong());
                oldproduct.setNumberofcustomer(product.getNumberofcustomer());
                oldproduct.setNumberofmembers(product.getNumberofmembers());
                oldproduct.setAmountofcontent(product.getAmountofcontent());
                oldproduct.setLinkappstore(product.getLinkappstore());
                oldproduct.setLinkgoogleplay(product.getLinkgoogleplay());
                oldproduct.setContact(product.getContact());

                productRepository.save(oldproduct);
            }
            redirectAttributes.addFlashAttribute("successMassage", "Save Success!");
            return "redirect:/admin/product";
        }catch (Exception ex){
            redirectAttributes.addFlashAttribute("errorMessage", "Cannot Save Banner!");
            return "redirect:/admin/product";
        }
    }

    @RequestMapping("/product/edit/{id}")
    public String editProduct(
            @PathVariable int id,
            Model model
    ){
            model.addAttribute("product", productRepository.findOneById(id));
            model.addAttribute("keywords", false);
            model.addAttribute("page_active","product");

            return "product/productForm";
    }

    @RequestMapping("/product/delete/{id}")
    public String deleteProduct(
            @PathVariable int id
    ){
        productImageRepository.deleteByProductsId(id);
        productRepository.deleteById(id);

        return "redirect:/admin/product";
    }
}
