package com.essyerp.erp.controller.category;

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


import com.essyerp.erp.model.category.SubcategoryModel;
import com.essyerp.erp.model.country.State;
import com.essyerp.erp.repo.SubcategoryRepo;


@Controller
@RequestMapping(value= {"/",""})
public class SubcategoryController {

	@Autowired
	SubcategoryRepo subcategoryRepo; 
	
	@RequestMapping("/manageSubcategory")
	public String addSubCategory()
	{
		return "/category/manageSubcategory";
	}
	
	@RequestMapping("/addSubcategory/save")
	@ResponseBody
	public SubcategoryModel saveSubCategory(@ModelAttribute SubcategoryModel c)
	{
		return subcategoryRepo.save(c);
	}

	@RequestMapping("/Subcategory/data")
	@ResponseBody
    public DataTablesOutput<SubcategoryModel> getUserSubCategory(@RequestBody DataTablesInput input,HttpServletRequest request) {
//		System.out.println(request.getParameter("from_date"));
//		String fdate = request.getParameter("from_date");
//		String tdate = request.getParameter("from_date");
		//request.getParameter("from_date");
		@SuppressWarnings("serial")
		Specification<SubcategoryModel> stu = new Specification<SubcategoryModel>() {
			
			@Override
			public Predicate toPredicate(Root<SubcategoryModel> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				
				predicates.add(criteriaBuilder.equal(root.get("flag"), false));
				// TODO Auto-generated method stub
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}

			
		};
		
		
//		System.out.println(studentRepo.findAll(input));
        return subcategoryRepo.findAll(input,null,stu);
	}
	
	@RequestMapping("/findbySubcategory/{id}")
	@ResponseBody
	public SubcategoryModel findSubcategory1(@PathVariable long id)
	{
		return subcategoryRepo.findById(id).orElse(null);
	}
	
	
	@RequestMapping("/findbySubcategory1/{id}")
	@ResponseBody
	public List<SubcategoryModel> findSubcategory(@PathVariable long id)
	{
		return subcategoryRepo.findData(id);
	}
	
	@RequestMapping("/Subcategory/delete/{id}")
	@ResponseBody
	public String deletesubcategory(@PathVariable Long id)
	{
		

		
		Optional<SubcategoryModel> cus = subcategoryRepo.findById(id);
		SubcategoryModel customer = cus.get();
		System.out.println("------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------");
		System.out.println(customer);
		System.out.println("customer");
		customer.setFlag(true);
		System.out.println(customer);
		System.out.println(customer.isFlag());
//		student.setIsDelete("true");
		subcategoryRepo.save(customer);
		
		
		return "done";
		
		
		//customerrepo.deleteById(id);
		//return "done";
	}
	
	@GetMapping("/Subcategory/undo/{id}")
	@ResponseBody
	public Optional<SubcategoryModel> undosubcategory(@PathVariable long id)
	{
		System.out.print("-------------------------------------------------");
		System.out.print("-------------------------------------------------");
		System.out.print(id);

		Optional<SubcategoryModel> cus = subcategoryRepo.findById(id);
		
		SubcategoryModel customer = cus.get();
		customer.setFlag(false);
		System.out.print(customer);
		System.out.print(customer.isFlag());
//		student.setIsDelete("true");
		subcategoryRepo.save(customer);
		System.out.print(subcategoryRepo.findById(id));
		return subcategoryRepo.findById(id);
	}
	@RequestMapping("/allsubcategory")
	@ResponseBody
	public List<SubcategoryModel> getAllsubcategory()
	{
		return subcategoryRepo.findAll();
	}
}
