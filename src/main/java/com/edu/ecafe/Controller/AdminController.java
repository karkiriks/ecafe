package com.edu.ecafe.Controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edu.ecafe.Domain.Admin;
import com.edu.ecafe.Domain.Order;
import com.edu.ecafe.Domain.Product;
import com.edu.ecafe.Service.ProductService;


@Controller
public class AdminController {
	@Resource
	ProductService ps;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String showAdminHome() {
		return "admin/adminhome";

	}

	
	
	@RequestMapping(value = "/adminhome", method = RequestMethod.GET)
	public String adminHome(Model model){
		model.addAttribute("page", "product/listproduct.jsp");
		return "admin/adminhome";
	}
	
	@RequestMapping(value = "/admin/product", method = RequestMethod.GET)
	public String product(Model model) {
		model.addAttribute("proList",ps.getAllProduct());
		model.addAttribute("page","product/listproduct.jsp");
		return "admin/adminhome";
	}
	
	@RequestMapping(value = "/admin/product/edit/{productId}", method = RequestMethod.GET)
	public String editProduct(@PathVariable int productId, Model model) {
		Product pro = ps.getProduct((int) productId);
		model.addAttribute("productModel",pro);
		model.addAttribute("transType", "/ecafe/admin/product/edit");
		model.addAttribute("page","product/editproduct.jsp");
		return "admin/adminhome";
	}
	
	@RequestMapping(value = "/admin/product/edit", method = RequestMethod.POST)
	public String editProduct(@ModelAttribute("productModel") Product pro,Model model,RedirectAttributes redirectAttribute) {
		ps.update(pro.getProductName(), pro.getDescription(), pro.getPrice(), pro.getProductType(), pro.getId());
		redirectAttribute.addFlashAttribute("message","Product has been edited!");
		model.addAttribute("page","product/listproduct.jsp");
		return "redirect:/admin/product";
	}
	
	@RequestMapping(value = "/admin/product/add")
	public String addProduct(Model model) {
		model.addAttribute("productModel",new Product());
		model.addAttribute("page","product/addproduct.jsp");
		return "admin/adminhome";
	}
	
	@RequestMapping(value = "/admin/product/add", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("productModel") Product pro,Model model,RedirectAttributes redirectAttribute) {
		System.out.println(pro.getProductName());
		ps.save(pro);
		redirectAttribute.addFlashAttribute("message","Product has been added!");
		model.addAttribute("page","product/listproduct.jsp");
		return "redirect:/admin/product";
	}

	@RequestMapping(value = "/admin/product/delete/{productId}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable int productId, Model model) {
		Product pro = ps.getProduct(productId);
		ps.delete(pro);
		return "redirect:/admin/product";
	}
	
}
