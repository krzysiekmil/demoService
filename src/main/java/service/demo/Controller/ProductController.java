package service.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.demo.Model.Type;
import service.demo.Service.ParametrService;
import service.demo.Service.ProductService;
import service.demo.Model.Product;
import service.demo.Model.Parametr;
import service.demo.Model.State;

import javax.validation.Valid;
import java.lang.reflect.Parameter;

@Controller
public class ProductController {
    private ProductService productService;
    private ParametrService parametrService;



    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/product/list";
    }

    @RequestMapping({"/product/list", "/product"})
    public String listProducts(Model model){
        model.addAttribute("ProductList", productService.listAll());
        return "product/list";
    }

    @RequestMapping("/product/show/{id}")
    public String getProduct(@PathVariable String id, Model model){
        model.addAttribute("product", productService.getById(Long.valueOf(id)));
        return "product/show";
    }

    @RequestMapping("product/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Product product = productService.getById(Long.valueOf(id));
        model.addAttribute("product", product);
        model.addAttribute("ProductStates", State.values());
        model.addAttribute("ProductTypes", Type.values());
        return "product/product";
    }

    @RequestMapping("/product/show/newParametr/{id}")
    public String newParametr(@PathVariable String id, Model model) {
        Parametr parametr = new Parametr();
        model.addAttribute("parametr", new Parametr());
        return "product/parametr";
    }
    @RequestMapping("/product/new")
    public String newProduct(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("ProductStates", State.values());
        model.addAttribute("ProductTypes", Type.values());
        return "product/product";
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String saveOrUpdateProduct(@Valid Product product,@Valid Parametr parametr, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "product/productform";
        }
       // Parametr savedParametr = parametrService.saveOrUpdate(parametr);
        Product savedProduct = productService.saveOrUpdate(product);

        return "redirect:/product/list";
    }

    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable String id){
        productService.delete(Long.valueOf(id));
        return "redirect:/product/list";
    }
}

