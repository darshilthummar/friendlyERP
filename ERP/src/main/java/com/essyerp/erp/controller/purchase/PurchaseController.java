package com.essyerp.erp.controller.purchase;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;

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

import com.essyerp.erp.model.customer.CustomerModel;
import com.essyerp.erp.model.purchase.PurchaseModel;
import com.essyerp.erp.model.purchase.PurchaseitemModel;
import com.essyerp.erp.repo.CustomerRepo;
import com.essyerp.erp.repo.PurchaseRepo;
import com.essyerp.erp.repo.PurchaseitemRepo;

@Controller
@RequestMapping(value= {"/",""})
public class PurchaseController {
	
	@Autowired
	PurchaseRepo purchaseRepo;

	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	PurchaseitemRepo purchaseitemRepo;
	
	@GetMapping("/addpurchase")
	public String addPurchase()
	{
		return "/purchase/addpurchase";
	}
	
	@GetMapping("/managepurchase")
	public String managePurchase()
	{
		return "/purchase/managepurchase";
	}
	
	@RequestMapping("/findAllpurchase")
	@ResponseBody
	public List<PurchaseModel> getAllpurchase()
	{
		return purchaseRepo.findAll();
	}
	
	@RequestMapping("/editpurchase/{id}")
	public String editPurchase(@PathVariable long id ,Model m)
	{
		
		m.addAttribute("purchase", purchaseitemRepo.findById(id).orElse(null));
		return "/purchase/editpurchase";
	}
	
	@RequestMapping("/addpurchase/save")
	public String saveCustomer(@ModelAttribute PurchaseModel pm)
	{
		
		
		pm.getPurchaseitemModel().forEach((pi->
		{
			pi.setPurchaseModel(pm);
		}));
		
		
		purchaseRepo.save(pm);
		return "redirect:/managepurchase";
	}
	
@RequestMapping("/purchase/data")
	
	@ResponseBody
    public DataTablesOutput<PurchaseitemModel> getUsers(@RequestBody DataTablesInput input,HttpServletRequest request) {
//		System.out.println(request.getParameter("from_date"));
//		String fdate = request.getParameter("from_date");
//		String tdate = request.getParameter("from_date");
		//request.getParameter("from_date");
		@SuppressWarnings("serial")
		Specification<PurchaseitemModel> stu = new Specification<PurchaseitemModel>() {
			
			@Override
			public Predicate toPredicate(Root<PurchaseitemModel> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				
				predicates.add(criteriaBuilder.equal(root.get("flag"), false));
				// TODO Auto-generated method stub
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}

			
		};
		
		
//		System.out.println(studentRepo.findAll(input));
        return purchaseitemRepo.findAll(input,null,stu);
	}
	

			@RequestMapping("/purchase/delete/{id}")
			@ResponseBody
			public Optional<PurchaseitemModel> deleteproduct(@PathVariable Long id)
			{
				
			
				
				Optional<PurchaseitemModel> cus = purchaseitemRepo.findById(id);
				PurchaseitemModel customer = cus.get();
				System.out.println("------------------------------------------------------------------------");
				System.out.println("------------------------------------------------------------------------");
				System.out.println(customer);
				System.out.println("customer");
				customer.setFlag(true);
				System.out.println(customer);
				System.out.println(customer.isFlag());
			//	student.setIsDelete("true");
				 purchaseitemRepo.save(customer);
				
				
				return purchaseitemRepo.findById(id);
				
				
				//customerrepo.deleteById(id);
				//return "done";
			}
			
			@RequestMapping("/purchase/undo/{id}")
			@ResponseBody
			public Optional<PurchaseitemModel> undoData(@PathVariable long id)
			{
				System.out.print("-------------------------------------------------");
				System.out.print("-------------------------------------------------");
				System.out.print(id);
			
				Optional<PurchaseitemModel> cus = purchaseitemRepo.findById(id);
				
				PurchaseitemModel customer = cus.get();
				customer.setFlag(false);
				System.out.print(customer);
				System.out.print(customer.isFlag());
			//	student.setIsDelete("true");
				purchaseitemRepo.save(customer);
				System.out.print(purchaseitemRepo.findById(id));
				return purchaseitemRepo.findById(id);
			}
			@GetMapping("/findAllSupplier")
			@ResponseBody
			public List<CustomerModel> supplierData()
			{
				
				return customerRepo.findData("supplier");
			}

}
