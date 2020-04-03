package com.essyerp.erp.controller.purchase;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TimeZone;
import java.util.stream.Collectors;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.essyerp.erp.model.product.ProductModel;
import com.essyerp.erp.model.purchase.PurchaseModel;
import com.essyerp.erp.model.stock.StockModel;
import com.essyerp.erp.model.stock.StockTransaction;
import com.essyerp.erp.repo.CityRepo;
import com.essyerp.erp.repo.CountryRepo;
import com.essyerp.erp.repo.CustomerRepo;
import com.essyerp.erp.repo.ProductRepo;
import com.essyerp.erp.repo.PurchaseRepo;
import com.essyerp.erp.repo.PurchaseitemRepo;
import com.essyerp.erp.repo.StateRepo;
import com.essyerp.erp.repo.StockRepo;
import com.essyerp.erp.repo.StockTransactionRepo;
import com.essyerp.erp.service.purchase.PurchaseService;
import com.essyerp.erp.service.stock.StockService;

@Controller
@RequestMapping(value= {"/purchase"})
public class PurchaseController 
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
	StockRepo stockRepo; 
	
  	@Autowired
	PurchaseRepo purchaseRepo;
	
  	@Autowired
  	PurchaseitemRepo purchaseitemRepo; 
	
  	@Autowired
  	PurchaseService purchaseService; 
  	
  	@Autowired
  	StockService stockService;
  	
  	@Autowired
  	StockTransactionRepo stockTransactionRepo;
	
	@GetMapping("/addPurchase")
	public ModelAndView addPurchase(HttpServletRequest request)
	{
		Long userId = (Long) request.getSession().getAttribute("UserId");

		ModelAndView view =new ModelAndView("/purchase/addpurchase");
		view.addObject("supplierList", customerRepo.findByCuser("supplier",userId));
		view.addObject("productList", ProductRepo.findProductData(userId));
		if((purchaseRepo.MaxInvoiceNo(userId))==0)
		{
		view.addObject("inviceNo", 1);
		}
		else {
		view.addObject("inviceNo", purchaseRepo.MaxInvoiceNo(userId)+1);
		}
		view.addObject("prefix", "BILL");
		return view;
	}
	
	
	
	@GetMapping("/findByIdproduct/{id}")
	@ResponseBody
	public Optional<ProductModel> getprice(@PathVariable long id, Model m)
	{
		
	return ProductRepo.findById(id);
	}
	
	
	 
	@GetMapping("/managePurchase")
	public String managePurchase()
	{
		return "/purchase/managepurchase";
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
	

	@RequestMapping("/addPurchase/save")
	public String savePurchase(@ModelAttribute PurchaseModel pm ,@RequestParam Map<String,String> allRequestParams,HttpServletRequest request)
	{
		System.err.println("all "+ pm.getPrefix() +"///"+ pm.getPurchaseitemModel().size());
		System.err.println("111 "+ pm.getPurchaseitemModel().get(0).getProduct().getId());
		Long userId = (Long) request.getSession().getAttribute("UserId");
		
		if(allRequestParams.get("delete_product") != null && !allRequestParams.get("delete_product").equals("")) {
			String address=allRequestParams.get("delete_product").substring(0, allRequestParams.get("delete_product").length()-1);
			List<Long> l= Arrays.asList(address.split(",")).stream().map(Long::parseLong).collect(Collectors.toList());
			
			purchaseService.deletePurchaseItem(l);
			
		}
		
		pm.getPurchaseitemModel().forEach((pi->{
			pi.setPurchaseModel(pm);
			
			if(allRequestParams.get("new").equals("1"))
			{	
				//stock----------------
				long productId=pi.getProduct().getId();
				long qty=pi.getQuantity();
				StockModel stockModel =new StockModel();
				stockModel.setProduct(pi.getProduct());
				stockModel.setQty(pi.getQuantity());
				stockModel.setDescription("product add");
				stockModel.setUserid(userId);
				int count = stockRepo.findProduct(productId,userId);
				
				if(count==0) {
					stockRepo.save(stockModel);
				}else {
					
					stockService.updateAddStock(qty,productId);
				}
				
				
				//stock transaction-----
				
				StockTransaction StockTransaction=new StockTransaction();
				StockTransaction.setProduct(pi.getProduct());
				StockTransaction.setInqty(pi.getQuantity());
				StockTransaction.setOutqty(0);
				StockTransaction.setPrice(pi.getRate());
				StockTransaction.setType("inProduct");
				StockTransaction.setDescription("purchase product");
				StockTransaction.setUserid(userId);
				Date todayDate=new Date();
//				DateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
//				dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
//				dateFormat.format(todayDate);
				StockTransaction.setTransactionDate(todayDate);
				
				stockTransactionRepo.save(StockTransaction);
				
			}
		}));
			
		
       
		
		pm.setUserid(userId);
		
		purchaseRepo.save(pm);
		
		return "redirect:/purchase/managePurchase";
	}
	
	
	

	@RequestMapping("/purchase/data")
	@ResponseBody
    public DataTablesOutput<PurchaseModel> getPurchase(@RequestBody DataTablesInput input,HttpServletRequest request) {
//		System.out.println(request.getParameter("from_date"));
//		String fdate = request.getParameter("from_date");
//		String tdate = request.getParameter("from_date");
		//request.getParameter("from_date");
		Long userId = (Long) request.getSession().getAttribute("UserId");
		@SuppressWarnings("serial")
		Specification<PurchaseModel> stu = new Specification<PurchaseModel>() {
			

			@Override
			public Predicate toPredicate(Root<PurchaseModel> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				

				predicates.add(criteriaBuilder.equal(root.get("isdelete"), 0));
				predicates.add(criteriaBuilder.equal(root.get("userid"), userId));
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}

			

		};
		

		

//		System.out.println(studentRepo.findAll(input));
        return purchaseRepo.findAll(input,null,stu);
	}
	

	
	@RequestMapping("/editPurchase/{id}")
	public String getDataById(@PathVariable long id, Model m,HttpServletRequest request)
	{
		Long userId = (Long) request.getSession().getAttribute("UserId");
//	System.out.println("==>"+id);
//	System.out.println("=c"+customerRepo.findCustomerData(userId));
//	System.out.println("=p-"+ProductRepo.findAll());
//	System.out.println("=-s-"+purchaseRepo.findById(id));
	Optional<PurchaseModel> purchaseModel=purchaseRepo.findById(id); 
//	System.out.println("-=-ss"+purchaseModel.get().getPurchaseitemModel().get(0).getTotal());
	m.addAttribute("supplierList", customerRepo.findByCuser("supplier",userId));
	m.addAttribute("productList", ProductRepo.findProductData(userId));
	m.addAttribute("purchase", purchaseModel.get());
//	ModelAndView mv=new ModelAndView("sales/editSales");
//	mv.addObject("customerList", customerRepo.findAll());
//	mv.addObject("productList", ProductRepo.findAll());
//	mv.addObject("sales", salesRepo.findById(id));
//	System.out.println("=>"+mv);
	return "purchase/editpurchase";

	}


			@RequestMapping("/delete/{id}")
			@ResponseBody
			public Optional<PurchaseModel> deleteproduct(@PathVariable Long id)
			{
				

				Optional<PurchaseModel> purchase= purchaseRepo.findById(id);
				PurchaseModel purchaseModel= purchase.get();
				
				purchaseModel.setIsdelete(1);				
				 purchaseRepo.save(purchaseModel);

				return purchaseRepo.findById(id);
			}
			

			@RequestMapping("/undo/{id}")
			@ResponseBody
			public Optional<PurchaseModel> undoData(@PathVariable long id)
			{
				System.out.print("-------------------------------------------------");
				System.out.print("-------------------------------------------------");
				System.out.print(id);
			

				Optional<PurchaseModel> purchase = purchaseRepo.findById(id);
				

				PurchaseModel purchaseModel= purchase.get();
				purchaseModel.setIsdelete(0);
//				System.out.print(customer);
//				System.out.print(customer.isFlag());
			//	student.setIsDelete("true");
				purchaseRepo.save(purchaseModel);
//				System.out.print(purchaseitemRepo.findById(id));
				return purchaseRepo.findById(id);
			}

	
	
			@RequestMapping("/graphdata/{year}")
			@ResponseBody
			public List<Map<String,String>> generateReport1(@PathVariable String year,HttpServletRequest request)
			{
				Long userId = (Long) request.getSession().getAttribute("UserId");
				return purchaseRepo.getPurchaseAll(userId, year);
				
			}
}
