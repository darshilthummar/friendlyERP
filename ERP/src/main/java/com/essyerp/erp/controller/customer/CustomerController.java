package com.essyerp.erp.controller.customer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.essyerp.erp.model.country.City;
import com.essyerp.erp.model.country.Country;
import com.essyerp.erp.model.country.State;
import com.essyerp.erp.model.customer.CustomerModel;
import com.essyerp.erp.repo.CityRepo;
import com.essyerp.erp.repo.CountryRepo;
import com.essyerp.erp.repo.CustomerRepo;
import com.essyerp.erp.repo.StateRepo;
import com.essyerp.erp.service.UserServiceReport;


import net.sf.jasperreports.engine.JRException;






@Controller
@RequestMapping(value= {"/",""})
public class CustomerController 
{
 
	@Autowired
	CustomerRepo customerRepo;
	
	
	@Autowired
	CountryRepo countryRepo;
	
	@Autowired
	StateRepo stateRepo;
	
	@Autowired
	CityRepo cityRepo;
	
	@Autowired
	private UserServiceReport userServiceReport;
	
	@GetMapping("/addcustomer")
	public String addCustomer()
	{
		return "/customer/addcustomer";
	}
	
	@RequestMapping("/editcustomer/{id}")
	public String editCustomer(@PathVariable long id ,Model m)
	{
		
		m.addAttribute("customer", customerRepo.findById(id).orElse(null));
		return "/customer/editCustomer";
	}
	
	@GetMapping("/managecustomer")
	public String manageCustomer()
	{
		return "/customer/managecustomer";
	}
	
	
	@RequestMapping("/emailCheck/{email}")
	@ResponseBody
	public String checkEmail(@PathVariable String email)
	{
		int n = customerRepo.findemailData(email);
		
		if(n==0)
		{
			return "true";
		}
		else
		{
			return "false";
		}
		
	}
	
	 
	
	@PostMapping("/addcustomer/save")
	public String saveCustomer(@ModelAttribute CustomerModel cm,HttpServletRequest request)
	{
       Long userId = (Long) request.getSession().getAttribute("UserId");
		
		cm.setUserid(userId);
		
		customerRepo.save(cm);
		return "redirect:/managecustomer";
	}
	
	@GetMapping("/customers")
	@ResponseBody
	public List<CustomerModel> getAllcustomer(HttpServletRequest request)
	{
		Long userId = (Long) request.getSession().getAttribute("UserId");
		return customerRepo.findCustomerData(userId);
	}
	
	@RequestMapping("/customer/delete/{id}")
	@ResponseBody
	public Optional<CustomerModel> deleteproduct(@PathVariable Long id)
	{
		

		
		Optional<CustomerModel> cus = customerRepo.findById(id);
		CustomerModel customer = cus.get();
		System.out.println("------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------");
		System.out.println(customer);
		System.out.println("customer");
		customer.setFlag(true);
		System.out.println(customer);
		System.out.println(customer.isFlag());
//		student.setIsDelete("true");
		 customerRepo.save(customer);
		
		
		return customerRepo.findById(id);
		
		
		//customerrepo.deleteById(id);
		//return "done";
	}
	
	@GetMapping("/customer/undo/{id}")
	@ResponseBody
	public Optional<CustomerModel> undoData(@PathVariable long id)
	{
		System.out.print("-------------------------------------------------");
		System.out.print("-------------------------------------------------");
		System.out.print(id);

		Optional<CustomerModel> cus = customerRepo.findById(id);
		
		CustomerModel customer = cus.get();
		customer.setFlag(false);
		System.out.print(customer);
		System.out.print(customer.isFlag());
//		student.setIsDelete("true");
		customerRepo.save(customer);
		System.out.print(customerRepo.findById(id));
		return customerRepo.findById(id);
	}
	@GetMapping("/country")
	@ResponseBody
	public List<Country> countryData()
	{
		
		return countryRepo.findAll();
	}
	@GetMapping("/state/{country_id}")
	@ResponseBody
	public List<State> getAllState(@PathVariable Long country_id) 
	{		
		return stateRepo.findData(country_id);
	}
	@GetMapping("/city/{state_id}")
	@ResponseBody
	public List<City> getAllcity(@PathVariable Long state_id) 
	{		
		System.out.print("--------------------------------------------");
		System.out.print("--------------------------------------------");
		System.out.print("--------------------------------------------");
		System.out.print(state_id);
		System.out.print("--------------------------------------------");
		System.out.print("--------------------------------------------");
		return cityRepo.findData(state_id);
	}
	
	@RequestMapping("/customer/data")
	
	@ResponseBody
    public DataTablesOutput<CustomerModel> getUsers(@RequestBody DataTablesInput input,HttpServletRequest request) {
//		System.out.println(request.getParameter("from_date"));
//		String fdate = request.getParameter("from_date");
//		String tdate = request.getParameter("from_date");
		//request.getParameter("from_date");
		Long userId = (Long) request.getSession().getAttribute("UserId");

		@SuppressWarnings("serial")
		Specification<CustomerModel> stu = new Specification<CustomerModel>() {
			
			@Override
			public Predicate toPredicate(Root<CustomerModel> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				
				predicates.add(criteriaBuilder.equal(root.get("flag"), false));
				predicates.add(criteriaBuilder.equal(root.get("userid"), userId));

				// TODO Auto-generated method stub
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}

			
		};
		
		
//		System.out.println(studentRepo.findAll(input));
        return customerRepo.findAll(input,null,stu);
	}
	
	@RequestMapping("/count/customer")
	@ResponseBody
	public Long countCustomer(HttpServletRequest request)
	{
		Long userId = (Long) request.getSession().getAttribute("UserId");
		return customerRepo.countContect("customer",userId);
		
	}
	@RequestMapping("/count/supplier")
	@ResponseBody
	public Long countSupplier(HttpServletRequest request)
	{
		Long userId = (Long) request.getSession().getAttribute("UserId");
		return customerRepo.countContect("supplier",userId);
		
	}
	
	@GetMapping("/report/{formate}")
	@ResponseBody
	public String generateReport(@PathVariable String formate , HttpServletResponse response,HttpServletRequest request) throws JRException, IOException
	{
		return userServiceReport.exportReport(formate,response,request);
		
	}
}
