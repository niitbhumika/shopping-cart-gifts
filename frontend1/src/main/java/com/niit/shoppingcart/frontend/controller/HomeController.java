package com.niit.shoppingcart.frontend.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.shoppingcart.giftsgallery.dao.CategoryDAO;
import com.niit.shoppingcart.giftsgallery.dao.ProductDAO;
import com.niit.shoppingcart.giftsgallery.dao.SupplierDAO;
import com.niit.shoppingcart.giftsgallery.dao.UserDAO;
import com.niit.shoppingcart.giftsgallery.model.Category;
import com.niit.shoppingcart.giftsgallery.model.Product;
import com.niit.shoppingcart.giftsgallery.model.Supplier;
import com.niit.shoppingcart.giftsgallery.model.UserInfo;


@Controller
public class HomeController {

	@RequestMapping("/register")
	public ModelAndView register() {
		
		return new ModelAndView("register","userinfo",new UserInfo()); // 21.11.2016 -->changes made here then error removed //
		}

	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	Product product;
	
	@Autowired
	Category category;
	
	@Autowired
	Supplier supplier;	
	
	@Autowired
	UserInfo userInfo;


	@ModelAttribute
	public Product returnObject()

	{
		return new Product();
	}

	@RequestMapping("/home")
	public String showhome() {
		return "home";
	}

	@RequestMapping("/AboutUs")
	public String showAboutUs() {
		return "AboutUs";
	}

	
	@RequestMapping("/")
	public String showIndex() {
		return "home";
	}

	@RequestMapping("/login")
	public String showlogin() {
		return "login";
	}
	
	@RequestMapping("/Products")
	public String showProducts() {
		System.out.println("products page seen");
		return "Products";
	}
		@RequestMapping("/adminProducts")
		public String showadminProducts() {
			System.out.println("products page seen");
			return "adminProducts";
	}
		@RequestMapping("/deleteProducts")
		public String showdeleteProducts() {
			System.out.println("products page seen");
			return "deleteProducts";
			
			
		}
		
//add products//
	
	@RequestMapping("/addProducts")
	public ModelAndView showaddProducts(Model model) {
		
		System.out.println("in product");
		ModelAndView mv=new ModelAndView("addProducts");
		model.addAttribute("productList", productDAO.list());
		model.addAttribute("categoryList", categoryDAO.list());
		model.addAttribute("supplierList", supplierDAO.list());
		return mv;

	}

	@RequestMapping("/Productdetails")//added on 23.11.2016
	public ModelAndView showProductdetails(@RequestParam("id")String id,Model model) {
		System.out.println("details");
		int i=Integer.parseInt(id);
		model.addAttribute("productList",this. productDAO.list());
		Product product=productDAO.get(i);
		return new ModelAndView("Productdetails","product",product);
	}
	
	@RequestMapping(value= "/deleteProducts&{id}")
	 /*@RequestMapping(value= "/delete")*/
	public ModelAndView showdeleteProducts(@PathVariable("id")String id,Model model )throws Exception{
		System.out.println(id);
		int i=Integer.parseInt(id);
		 product=productDAO.get(i);
		ModelAndView mv = new ModelAndView("adminProducts");
		productDAO.delete1(product);
		/*mv.addObject("adminProducts",0);*/
		
		System.out.println("deleting product");
		
		return mv;
		
	}
	
	

	/*
	 * @RequestMapping("/addCategories") public String show() { return
	 * "addCategories"; }
	 */

	/*
	 * @RequestMapping ("/validate") public void checkUser(HttpServletRequest
	 * req,HttpServletResponse res) { String s1=req.getParameter("name1");
	 * String s2=req.getParameter("password1");
	 * if(s1.equals("sa@gmail.com")&&s2.equals("sa"))
	 * 
	 * { System.out.println("valid"); } else {System.out.println("Not Valid");
	 * 
	 * } }
	 */
	
	/*@RequestMapping("/validate")
	public ModelAndView checkUser(@RequestParam("name1") String s1, @RequestParam("password1") String s2) {
		String message;
		ModelAndView mv;
		if (s1.equals("sa@gmail.com") && s2.equals("sa")) {
			message = "valid";
			mv = new ModelAndView("AdminHome");
			mv.addObject("info", message);

		} else {
			message = "Invalid";
			mv = new ModelAndView("login");
			mv.addObject("info", message);
		}
		return mv;
	}*/
	@RequestMapping(value="/login_session_attributes")
	public String login_session_attributes(HttpSession session,Model model, @RequestParam(value="username")String id){
		String name=SecurityContextHolder.getContext().getAuthentication().getName();
		
		System.out.println("inside security check");
		
		session.setAttribute("name", name);
		System.out.println(name);
		
		//user=userDAO.get(name);
		
		userInfo = userDAO.get(id);
		int x = userInfo.getId();
		session.setAttribute("loggedInUser", userInfo.getName());
    	session.setAttribute("loggedInUserID", x);
    	
		session.setAttribute("LoggedIn", "true");
		
		@SuppressWarnings("unchecked")
		Collection<GrantedAuthority> authorities =(Collection<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		
		String role="ROLE_USER";
		for(GrantedAuthority authority : authorities)
		{
			if(authority.getAuthority().equals(role))
			{
				System.out.println(role);
				return "home";
			}
			else
			{
				session.setAttribute("isAdmin", "true");
			}
			}
		return "AdminHome" ;
		
		
	}
	
	@RequestMapping("/perform_logout")
	public ModelAndView logout(HttpServletRequest request,HttpSession session){
		ModelAndView mv=new ModelAndView("home");
		session.invalidate();
		session=request.getSession(true);
		/*session.setAttribute("category", category);
		session.setAttribute("categoryList", categoryDAO.list());*/
		
		mv.addObject("logOutMessage", "You have successfully logged out!");
		mv.addObject("loggedout","true");
		
		return mv;
}



	/* Logout */
	@RequestMapping("/Logout")
	public String showLogout() {
		return "Logout";

	}

	// when user clicks submit these details are posted//
	@Autowired
	UserDAO userDAO;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	/*
	 * public ModelAndView addUser (@ModelAttribute("userinfo")UserInfo
	 * user,ModelMap model,BindingResult result,HttpServletRequest request)
	 */

	/*public ModelAndView showUserInfo(@ModelAttribute("userinfo") UserInfo user, BindingResult result,
			HttpServletRequest request) {
		user.setEnabled("true");
		user.setRole("ROLE_USER");// decided by admin//
		userDAO.saveOrUpdate(user);// decided by admin//
		ModelAndView mv = new ModelAndView("login");	
		return mv;
	}*/
	
	

	public String addUser(@ModelAttribute("userinfo") UserInfo user, ModelMap model, BindingResult result,HttpServletRequest request) {
		System.out.println("In add user");
		
		model.addAttribute("id", user.getId());//no changes occur as of in strings//
		model.addAttribute("name", user.getName());
		model.addAttribute("phno", user.getPhno());
		model.addAttribute("emailid", user.getEmailid());
		model.addAttribute("address", user.getAddress());
		model.addAttribute("password", user.getPassword());
		user.setEnabled("true");
		user.setRole("ROLE_USER");
		userDAO.saveOrUpdate(user);
		return "login";
	}

	/* Add Product */
	
	
	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public String ShowAddProduct(@ModelAttribute("product") com.niit.shoppingcart.giftsgallery.model.Product product,
			Model model, BindingResult result, HttpServletRequest request) throws IOException {
		System.out.println(product.getProd_name());
		System.out.println("image upload");
		System.out.println("myproduct controller called");
		MultipartFile image = product.getImage();
		Path path;/* belong to nio package */
		path = Paths.get(
				"F:/project1.1 2016/frontend1/src/main/webapp/resources/images/" + product.getProd_name() + ".jpg");
		System.out.println("Path=" + path);
		System.out.println("File name" + product.getImage().getOriginalFilename());
		if (image != null && !image.isEmpty()) {
			try {
				image.transferTo(new File(path.toString()));
				System.out.println("Image Saved in:" + path.toString());
			} catch (Exception e)

			{
				e.printStackTrace();
				System.out.println("Image not saved");

			}
		//category = categoryDAO.get(product.getCategory().getCat_name());
		//	categoryDAO.saveOrUpdate(category);

			
       // supplier = supplierDAO.get(product.getSupplier().getSup_name());
		//	supplierDAO.saveOrUpdate(supplier);

			//product.setSupplier(supplier);
			//product.setCategory(category);
			productDAO.saveOrUpdate(product);
			model.addAttribute("message","product added successfully");
			model.addAttribute("productList", productDAO.list());
			model.addAttribute("categoryList", categoryDAO.list());
			model.addAttribute("supplierList", supplierDAO.list());
		}
		productDAO.saveOrUpdate(product);
		model.addAttribute("message","product added successfully");
		model.addAttribute("productList", productDAO.list());

		return "Products";
	}
	
	String setName;//this added today and dependencies added//
	List<Product>plist;
	
	@RequestMapping("GsonCon")
	public @ResponseBody String getValues() throws Exception {
		String result ="";
		System.out.println("hellllloooo");
		plist= productDAO.list();
		Gson gson=new Gson();
		result= gson.toJson(plist);
		return result;
		
	}
	
    /* Add categories */
	@Autowired
	CategoryDAO categoryDAO;

	@RequestMapping("/addCategories") // JSP page
	public ModelAndView showCategory(@ModelAttribute("category") Category category, BindingResult result,
			HttpServletRequest request)// commandname
	{
		ModelAndView mv = new ModelAndView("addCategories");
		return mv;
	}

	@RequestMapping(value = "/addcategory", method = RequestMethod.POST) // Jsp page
																			
	public String addCategory(@ModelAttribute("category") Category category, ModelMap model, BindingResult result,
			HttpServletRequest request) {
		System.out.println("In add category");
		model.addAttribute("cat_id", category.getCat_id());
		model.addAttribute("cat_name", category.getCat_name());
		model.addAttribute("cat_description", category.getCat_description());

		categoryDAO.saveOrUpdate(category);
		return "login";
	}
	
	/*Add suppliers*/
	@Autowired
	SupplierDAO supplierDAO;

	@RequestMapping("/addSuppliers") // JSP page
	public ModelAndView showSupplier(@ModelAttribute("supplier") Supplier supplier, BindingResult result,
			HttpServletRequest request)// commandname
	{
		ModelAndView mv = new ModelAndView("addSuppliers");
		return mv;
	}

	@RequestMapping(value = "/addsuppliers", method = RequestMethod.POST) // Jsp page
																			
	public String addSupplier(@ModelAttribute("supplier") Supplier supplier, ModelMap model, BindingResult result,
			HttpServletRequest request) {
		System.out.println("In add supplier");
		model.addAttribute("sup_id", supplier.getSup_id());
		model.addAttribute("sup_name", supplier.getSup_name());
		model.addAttribute("sup_description", supplier.getSup_description());

		supplierDAO.saveOrUpdate(supplier);
		return "login";
	}
	
}
