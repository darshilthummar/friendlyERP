package com.essyerp.erp.controller.Tax;


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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.essyerp.erp.model.Tax.TaxModel;

import com.essyerp.erp.repo.TaxRepo;


@Controller
@RequestMapping(value= {"/",""})
public class TaxController {

	@Autowired
	TaxRepo taxRepo;
	
	@RequestMapping("/manageTax")
	public String manageTax()
	{
		return "/tax/manageTax";
	}
	
	@RequestMapping("/addtax/save")
	@ResponseBody
	public TaxModel saveTax(@ModelAttribute TaxModel c,HttpServletRequest request)
	{
		System.out.println(c.getTax());
		Long userId = (Long) request.getSession().getAttribute("UserId");
		
		c.setUserid(userId);
		
		
		return taxRepo.save(c);
	//	return taxRepo.save(c);
	}

	@RequestMapping("/tax/data")
	@ResponseBody
    public DataTablesOutput<TaxModel> getUsers1(@RequestBody DataTablesInput input,HttpServletRequest request) {
//		System.out.println(request.getParameter("from_date"));
//		String fdate = request.getParameter("from_date");
//		String tdate = request.getParameter("from_date");
		//request.getParameter("from_date");
		Long userId = (Long) request.getSession().getAttribute("UserId");
		@SuppressWarnings("serial")
		Specification<TaxModel> stu = new Specification<TaxModel>() {
			
			@Override
			public Predicate toPredicate(Root<TaxModel> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				
				predicates.add(criteriaBuilder.equal(root.get("flag"), false));
				predicates.add(criteriaBuilder.equal(root.get("userid"), userId));
				// TODO Auto-generated method stub
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}

			
		};
		
		
//		System.out.println(studentRepo.findAll(input));
        return taxRepo.findAll(input,null,stu);
	}
	
	@RequestMapping("/findbytax/{id}")
	@ResponseBody
	public TaxModel findTax(@PathVariable long id)
	{
		return taxRepo.findById(id).orElse(null);
	}
	
	@RequestMapping("/tax/delete/{id}")
	@ResponseBody
	public Optional<TaxModel> deletetax(@PathVariable Long id)
	{
		

		
		Optional<TaxModel> cus = taxRepo.findById(id);
		TaxModel tax = cus.get();
		System.out.println("------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------");
		System.out.println(tax);
		System.out.println("tax");
		tax.setFlag(true);
		System.out.println(tax);
		System.out.println(tax.isFlag());
//		student.setIsDelete("true");
		taxRepo.save(tax);
		
		
		return taxRepo.findById(id);
		
		
		//taxrepo.deleteById(id);
		//return "done";
	}
	
	@GetMapping("/tax/undo/{id}")
	@ResponseBody
	public Optional<TaxModel> undoData(@PathVariable long id)
	{
		System.out.print("-------------------------------------------------");
		System.out.print("-------------------------------------------------");
		System.out.print(id);

		Optional<TaxModel> cus = taxRepo.findById(id);
		
		TaxModel tax = cus.get();
		tax.setFlag(false);
		System.out.print(tax);
		System.out.print(tax.isFlag());
//		student.setIsDelete("true");
		taxRepo.save(tax);
		System.out.print(taxRepo.findById(id));
		return taxRepo.findById(id);
	}
	
	
	@GetMapping("/alltax")
	@ResponseBody
	public List<TaxModel> getAlltax(HttpServletRequest request)
	{
		Long userId = (Long) request.getSession().getAttribute("UserId");

		return taxRepo.findTaxData(userId);
	}
}
