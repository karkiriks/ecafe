package com.edu.ecafe.Controller;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.type.CalendarTimeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edu.ecafe.Domain.Order;
import com.edu.ecafe.Domain.Orderline;
import com.edu.ecafe.Domain.Person;
import com.edu.ecafe.Domain.Product;
import com.edu.ecafe.Domain.ProductType;
import com.edu.ecafe.Service.MailService;
import com.edu.ecafe.Service.OraderlineService;
import com.edu.ecafe.Service.OrderService;
import com.edu.ecafe.Service.PersonService;
import com.edu.ecafe.Service.ProductService;

@Controller
@SessionAttributes("cart")

public class CustomerController {

	@Autowired
	PersonService personService;
	
	@Autowired
	ProductService ps ;
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	OraderlineService oraderlineService;
	
	@Autowired
	MailService mailserv;
	
	public double getOrderTotal(HttpServletRequest request){
		double orderTotal=0;
		ArrayList<Orderline> cart;
		
		try{
			cart=(ArrayList<Orderline>) request.getSession().getAttribute("cart");
		}
		catch (Exception ex) {
			 cart=new ArrayList<Orderline>();
		}
		
		if (cart==null || cart.size()==0){
			return 0;
		}
		
		for (Orderline ordline : cart ){
			orderTotal += ordline.getSubtotal();
		}
		
		NumberFormat formatter = new DecimalFormat("#0.00");
		return Double.valueOf(formatter.format(orderTotal));
		
	}
	@RequestMapping(value = "/dinner", method = RequestMethod.GET)
	public String showDinner(Model model,  HttpServletRequest request) {
		List<Product> products = ps.findByProductType(ProductType.DINNER);
		model.addAttribute("products",products);
		model.addAttribute("page", "dinner.jsp");
		
		model.addAttribute("orderTotal",getOrderTotal(request)) ;
		
		return "customerportal";
	}
	
	@RequestMapping(value = "/lunch", method = RequestMethod.GET)
	public String showLunch(Model model,HttpServletRequest request) {
		List<Product> products = ps.findByProductType(ProductType.LUNCH);
		model.addAttribute("products",products);
		model.addAttribute("page", "lunch.jsp");
		model.addAttribute("orderTotal",getOrderTotal(request)) ;
		return "customerportal";
	}
	
	@RequestMapping(value = "/breakfast", method = RequestMethod.GET)
	public String showBreakfast(Model model,HttpServletRequest request) {
//		ps.save(new Product("HashBrown", "Potato Smashes", 1.50, ProductType.BREAKFAST));
//		ps.save(new Product("Mc Chicken", "Kind of burger", 1.19, ProductType.DINNER));
//		ps.save(new Product("Egg Muffin", "A tasty Muffin", 1.73, ProductType.BREAKFAST));
//		ps.save(new Product("HashBrown", "Potato Smashes", 1.50, ProductType.DINNER));
//		ps.save(new Product("Mc Chicken", "Kind of burger", 1.19, ProductType.BREAKFAST));
//		ps.save(new Product("Egg Muffin", "A tasty Muffin", 1.73, ProductType.LUNCH));
//		ps.save(new Product("Daal Bhaat", "A Rice", 1.73, ProductType.LUNCH));
		List<Product> products = ps.findByProductType(ProductType.BREAKFAST);
		model.addAttribute("products",products);
		model.addAttribute("page", "breakfast.jsp");
		model.addAttribute("orderTotal",getOrderTotal(request)) ;
		return "customerportal";
	}	
	
	@RequestMapping(value = "/saveorder", method = RequestMethod.GET)
	public String saveOrder(Model model , HttpServletRequest request, SessionStatus status){
		double orderTotal =0;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    username="ahmed";   
	    
		ArrayList<Orderline> cart;
		
		try{
			cart=(ArrayList<Orderline>) request.getSession().getAttribute("cart");
		}
		catch (Exception ex) {
			cart=new ArrayList<Orderline>();
			model.addAttribute("saveError", "no item to save...");
		}
		
		if (cart==null || cart.size()==0){
			model.addAttribute("saveError", "no item to save...");
			model.addAttribute("page", "orderline.jsp");
			return "customerportal";
		}

		Person cust = personService.findByUserName(username);
		
		Order newOrder=new Order();
		newOrder.setPerson(cust);
		newOrder.setOrderDate(new Date());
		
		Orderline newOrderline=null;
		newOrder = orderService.save(newOrder);
		for (int i=0;i<cart.size();i++){
			newOrderline=cart.get(i);
			newOrderline.setOrder(newOrder);
			oraderlineService.save(newOrderline);
		}
		
		model.addAttribute("saveError", "Order Saved... ");
		cart=new ArrayList<Orderline>();

		for (int i=0; i<cart.size();i++){
				cart.remove(i);
		}
		
		request.getSession().setAttribute("cart", new ArrayList<Orderline>() );
		
		model.addAttribute("orderTotal",0) ;
		status.setComplete();
		model.addAttribute("page", "success.jsp");
		mailserv.sendMail("ecafeweb@gmail.com", "ahmed_amin007@hotmail.com", 
				"new order-" + newOrder.getId(), "You have new order " + newOrder.getId()  );
		return "customerportal";
	}
	
	@RequestMapping(value = "/customerportal", method = RequestMethod.GET)
	public String customer(@ModelAttribute("loginForm") Person person,Model model) {
		model.addAttribute("page","breakfast.jsp");
		return "customerportal";
	}
	
	@RequestMapping(value = "/orderline", method = RequestMethod.GET)
	public String orderline(@ModelAttribute("loginForm") Person person,Model model, HttpServletRequest request) {
		
		double orderTotal=0;
		ArrayList<Orderline> cart;
		
		try{
			cart=(ArrayList<Orderline>) request.getSession().getAttribute("cart");

		}
		catch (Exception ex) {
			 cart=new ArrayList<Orderline>();
			 return "customerportal";
		}
		if (cart==null){
			model.addAttribute("page", "breakfast.jsp");
			return "customerportal";
		}
		
		model.addAttribute("cart",cart);
		model.addAttribute("page", "orderline.jsp");
		
		for (Orderline ordline : cart ){
			orderTotal += ordline.getSubtotal();
		}
		
		NumberFormat formatter = new DecimalFormat("#0.00");
		model.addAttribute("orderTotal",formatter.format(orderTotal)) ;
		
		return "customerportal";
	}

	@RequestMapping(value = "/orderline/remove/{id}", method = RequestMethod.GET)
	public String removeCartItem(Model model, @PathVariable int id , HttpServletRequest request){
		ArrayList<Orderline> cart;
		double orderTotal=0;
		
		try{
			cart=(ArrayList<Orderline>) request.getSession().getAttribute("cart");
			
			for (int i=0; i<cart.size();i++){
				if (cart.get(i).getProduct().getId()==id){
					cart.remove(i);
				}
			}
			
			for (Orderline ordline : cart ){
				orderTotal += ordline.getSubtotal();
			}

		}
		catch (Exception ex) {
			 System.out.println("delete error");
		}
		
		model.addAttribute("page", "orderline.jsp");
		NumberFormat formatter = new DecimalFormat("#0.00");
		model.addAttribute("orderTotal",formatter.format(orderTotal)) ;
		return "customerportal";
		
	}
								
	@RequestMapping(value = "/addToCart/{id}", method = RequestMethod.GET)
	public String addToCart(Model model , @PathVariable int id , HttpServletRequest request ){
		
		boolean found=false;
		double orderTotal=0;
		Product prod=new Product();
		ArrayList<Orderline> cart;
		
		
		prod = ps.findById(id);
		ProductType prodType=prod.getProductType();
		
		Orderline newOrder=new Orderline();
		newOrder.setProduct(prod);
		newOrder.setPrice(prod.getPrice());
		newOrder.setQuantity(1);
		
		
		try{
			cart=(ArrayList<Orderline>) request.getSession().getAttribute("cart");
		}
		catch (Exception ex) {
			 cart=new ArrayList<Orderline>();
		}
		
	
		if (request.getSession().getAttribute("cart") ==null){
			 cart=new ArrayList<Orderline>();
			 cart.add(newOrder);
		}
		else {
			cart=(ArrayList<Orderline>) request.getSession().getAttribute("cart");
			for (Orderline ordline : cart ){
				
				if (ordline.getProduct().getId()==id) {
					found=true;
					ordline.setQuantity(ordline.getQuantity() + 1);
				}
			}
			if (!found)
				cart.add(newOrder);
		}
		//get order total
		for (Orderline ordline : cart ){
			orderTotal += ordline.getSubtotal();
		}
		
		model.addAttribute("pageCart",cart);
		NumberFormat formatter = new DecimalFormat("#0.00");
		model.addAttribute("orderTotal",formatter.format(orderTotal)) ;
		request.getSession().setAttribute("cart", cart);
		
		if (prodType==ProductType.BREAKFAST){
			model.addAttribute("page", "lunch.jsp");
			return "forward:/breakfast";
		}
		else if (prodType==ProductType.LUNCH){
			model.addAttribute("page", "lunch.jsp");
			return "forward:/lunch";
		}
		else if (prodType==ProductType.DINNER) { 
			model.addAttribute("page", "lunch.jsp");
			return "forward:/dinner";
		}
		
		return "customerportal";
	}
	

	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("registrationForm") Person person, Model model,
			RedirectAttributes redirectAttributes) {
		personService.savePerson(person);
		redirectAttributes.addFlashAttribute("message",
				"Congratulations User: " + person.getUsername() + " has been created successfully");
		return "redirect:/home";
	}

}
