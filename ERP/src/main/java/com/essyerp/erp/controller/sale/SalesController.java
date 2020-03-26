package com.essyerp.erp.controller.sale;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.essyerp.erp.model.product.ProductModel;
import com.essyerp.erp.model.sale.SalesModel;
import com.essyerp.erp.repo.CityRepo;
import com.essyerp.erp.repo.CountryRepo;
import com.essyerp.erp.repo.CustomerRepo;
import com.essyerp.erp.repo.ProductRepo;
import com.essyerp.erp.repo.SalesItemRepo;
import com.essyerp.erp.repo.SalesRepo;
import com.essyerp.erp.repo.StateRepo;

@Controller
@RequestMapping(value= {"/sales"})
public class SalesController 
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
	ProductRepo ProductRepo;
	
	@Autowired
	SalesRepo salesRepo;
	
	@Autowired
	SalesItemRepo salesItemRepo;
	
	
	@GetMapping("/addSales")
	public ModelAndView addCustomer()
	{
		ModelAndView view =new ModelAndView("/sales/addSales");
		view.addObject("customerList", customerRepo.findByCuser("customer"));
		view.addObject("productList", ProductRepo.findAll());
		return view;
	}
	
	
	
	@GetMapping("/findByIdproduct/{id}")
	@ResponseBody
	public Optional<ProductModel> getprice(@PathVariable long id, Model m)
	{
		
	return ProductRepo.findById(id);
	}
	
	
	 
	@GetMapping("/manageSales")
	public String manageSales()
	{
		return "/sales/manageSales";
	}
	
//
//	@RequestMapping("/findAllpurchase")
//	@ResponseBody
//	public List<PurchaseModel> getAllpurchase()
//	{
//		return purchaseRepo.findAll();
//	}
	

//	@RequestMapping("/editpurchase/{id}")
//	public String editPurchase(@PathVariable long id ,Model m)
//	{
//		
//
//		m.addAttribute("purchase", purchaseitemRepo.findById(id).orElse(null));
//		return "/purchase/editpurchase";
//	}
	

	@RequestMapping("/addSales/save")
	public String saveSales(@ModelAttribute SalesModel sm)
	{
		
			
			sm.getSalesItemModel().forEach((si->{
			si.setSalesModel(sm);
		}));
			
		//sm.setInvoiceno(salesRepo.findMaxInvoiceNo());
		
		salesRepo.save(sm);
		return "redirect:/sales/manageSales";
	}
	
	
	

	@RequestMapping("/sales/data")
	@ResponseBody
    public DataTablesOutput<SalesModel> getSales(@RequestBody DataTablesInput input,HttpServletRequest request) {
//		System.out.println(request.getParameter("from_date"));
//		String fdate = request.getParameter("from_date");
//		String tdate = request.getParameter("from_date");
		//request.getParameter("from_date");
		@SuppressWarnings("serial")
		Specification<SalesModel> stu = new Specification<SalesModel>() {
			

			@Override
			public Predicate toPredicate(Root<SalesModel> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				

				predicates.add(criteriaBuilder.equal(root.get("isdelete"), 0));
				// TODO Auto-generated method stub
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}

			

		};
		

		

//		System.out.println(studentRepo.findAll(input));
        return salesRepo.findAll(input,null,stu);
	}
	

	
	@RequestMapping("/editSales/{id}")
	public String getDataById(@PathVariable long id, Model m)
	{
	System.out.println("==>"+id);
	System.out.println("=c"+customerRepo.findAll());
	System.out.println("=p-"+ProductRepo.findAll());
	System.out.println("=-s-"+salesRepo.findById(id));
	Optional<SalesModel> SalesModel=salesRepo.findById(id); 
	System.out.println("-=-ss"+SalesModel.get().getSalesItemModel().get(0).getTotal());
	m.addAttribute("customerList", customerRepo.findAll());
	m.addAttribute("productList", ProductRepo.findAll());
	m.addAttribute("sales", SalesModel.get());
//	ModelAndView mv=new ModelAndView("sales/editSales");
//	mv.addObject("customerList", customerRepo.findAll());
//	mv.addObject("productList", ProductRepo.findAll());
//	mv.addObject("sales", salesRepo.findById(id));
//	System.out.println("=>"+mv);
	return "sales/editSales";

	}


			@RequestMapping("/delete/{id}")
			@ResponseBody
			public Optional<SalesModel> deleteproduct(@PathVariable Long id)
			{
				

				Optional<SalesModel> sales= salesRepo.findById(id);
				SalesModel sale= sales.get();
				
				sale.setIsdelete(1);				
				 salesRepo.save(sale);

				return salesRepo.findById(id);
			}
			

			@RequestMapping("/undo/{id}")
			@ResponseBody
			public Optional<SalesModel> undoData(@PathVariable long id)
			{
				System.out.print("-------------------------------------------------");
				System.out.print("-------------------------------------------------");
				System.out.print(id);
			

				Optional<SalesModel> sales = salesRepo.findById(id);
				

				SalesModel sale= sales.get();
				sale.setIsdelete(0);
//				System.out.print(customer);
//				System.out.print(customer.isFlag());
			//	student.setIsDelete("true");
				salesRepo.save(sale);
//				System.out.print(purchaseitemRepo.findById(id));
				return salesRepo.findById(id);
			}

	
	
	
}