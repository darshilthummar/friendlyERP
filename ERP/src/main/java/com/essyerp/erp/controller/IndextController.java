package com.essyerp.erp.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.essyerp.erp.model.login.User;
import com.essyerp.erp.repo.CustomerRepo;
import com.essyerp.erp.repo.ProductRepo;
import com.essyerp.erp.repo.PurchaseRepo;
import com.essyerp.erp.repo.SalesItemRepo;
import com.essyerp.erp.repo.SalesRepo;
import com.essyerp.erp.repo.StockRepo;
import com.essyerp.erp.repo.logrepo.UserRepository;


@Controller
@RequestMapping("/")
public class IndextController 
{

	@Autowired
	UserRepository userRepo;
	
	@Autowired
	SalesRepo salesRepo;
	
	@Autowired
	PurchaseRepo purchaseRepo; 
	
	@Autowired
	CustomerRepo customerRepo; 
	
	@Autowired
	ProductRepo productRepo;
	
	@Autowired
	StockRepo stockRepo;
	
	@Autowired
	SalesItemRepo salesItemRepo;

	
	@GetMapping("/login")
	public String getLogin()
	{
		return "snippets/pages/user/login-1";
	}
	
	@RequestMapping(value={" ","/", "/index"})
	public ModelAndView getIndext(HttpServletRequest request)
	{
		
		Long userId = (Long) request.getSession().getAttribute("UserId");
		ModelAndView view =new ModelAndView("index");
		view.addObject("totalPurchase", purchaseRepo.TotalPurchase(userId));
		view.addObject("totalSales" ,salesRepo.TotalSales(userId));
		view.addObject("totalCustomer", customerRepo.countContect("customer",userId));
		view.addObject("totalSupplier", customerRepo.countContect("supplier",userId));
		view.addObject("totalProduct", productRepo.countProduct(userId));
		view.addObject("totalStock", stockRepo.countStock(userId));
		view.addObject("CaseInHand", salesRepo.caseCount("Cash Payment",userId));
		view.addObject("CaseInBank", salesRepo.caseCount("Bank Payment",userId));
		view.addObject("totalProfit" ,salesItemRepo.countProfit(userId));
		System.err.println("totalProfit "+salesItemRepo.countProfit(userId));
		return view;
	}
	
	
	@RequestMapping("/userdata")
	@ResponseBody
	public User getddata(HttpServletRequest request, Model m)
	{
		Long user = (Long) request.getSession().getAttribute("UserId");

		
		System.out.println(userRepo.findById(user).orElse(null));
		return userRepo.findById(user).orElse(null);
	}
	
	@RequestMapping("/contact")
	public String contactUs()
	{
		
		return "contactUs";
	}
	@RequestMapping("/aboutUs")
	public String aboutUsMethod()
	{
		
		return "aboutUs";
	}
	
}
