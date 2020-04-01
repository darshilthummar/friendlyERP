package com.essyerp.erp.controller.stock;

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
import com.essyerp.erp.model.stock.StockModel;
import com.essyerp.erp.model.stock.StockTransaction;
import com.essyerp.erp.repo.CityRepo;
import com.essyerp.erp.repo.CountryRepo;
import com.essyerp.erp.repo.CustomerRepo;
import com.essyerp.erp.repo.ProductRepo;
import com.essyerp.erp.repo.SalesItemRepo;
import com.essyerp.erp.repo.SalesRepo;
import com.essyerp.erp.repo.StateRepo;
import com.essyerp.erp.repo.StockRepo;
import com.essyerp.erp.repo.StockTransactionRepo;

@Controller
@RequestMapping(value= {"/stock"})
public class StockController 
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
	
	@Autowired
	StockRepo stockRepo;
	
	@Autowired
	StockTransactionRepo stockTransactionRepo;
	
	@GetMapping("/")
	public String stockMaster()
	{
		return "/stock/stockMaster";
	}
	
	@GetMapping("/stocktransaction")
	public String stockTransaction()
	{
		return "/stock/stockTransaction";
	}
	
	
	
	@RequestMapping("/stockMaster/data")
	@ResponseBody
    public DataTablesOutput<StockModel> getStock(@RequestBody DataTablesInput input,HttpServletRequest request) {
//		System.out.println(request.getParameter("from_date"));
//		String fdate = request.getParameter("from_date");
//		String tdate = request.getParameter("from_date");
		//request.getParameter("from_date");
		@SuppressWarnings("serial")
		Specification<StockModel> stock = new Specification<StockModel>() {
			

			@Override
			public Predicate toPredicate(Root<StockModel> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				

				predicates.add(criteriaBuilder.equal(root.get("isdelete"), 0));
				// TODO Auto-generated method stub
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}

			

		};
		  return stockRepo.findAll(input,null,stock);
	}
	
	
	@RequestMapping("/stockTransaction/data")
	@ResponseBody
    public DataTablesOutput<StockTransaction> getStockTransaction(@RequestBody DataTablesInput input,HttpServletRequest request) {
//		System.out.println(request.getParameter("from_date"));
//		String fdate = request.getParameter("from_date");
//		String tdate = request.getParameter("from_date");
		//request.getParameter("from_date");
		@SuppressWarnings("serial")
		Specification<StockTransaction> stock = new Specification<StockTransaction>() {
			

			@Override
			public Predicate toPredicate(Root<StockTransaction> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				

				predicates.add(criteriaBuilder.equal(root.get("isdelete"), 0));
				// TODO Auto-generated method stub
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}

			

		};
		  return stockTransactionRepo.findAll(input,null,stock);
	}
	
	
	
}
