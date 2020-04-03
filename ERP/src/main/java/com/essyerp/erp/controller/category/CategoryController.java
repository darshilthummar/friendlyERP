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

import com.essyerp.erp.model.Tax.TaxModel;
import com.essyerp.erp.model.category.CategoryModel;
import com.essyerp.erp.model.customer.CustomerModel;
import com.essyerp.erp.repo.CategoryRepo;


@Controller
@RequestMapping(value= {"/",""})
public class CategoryController {

	@Autowired
	CategoryRepo categoryRepo; 
	
	@RequestMapping("/manageCategory")
	public String addCustomer()
	{
		return "/category/manageCategory";
	}
	
	@RequestMapping("/addcategory/save")
	@ResponseBody
	public CategoryModel saveCustomer(@ModelAttribute CategoryModel c,HttpServletRequest request)
	{
		System.out.println(c);
		Long userId = (Long) request.getSession().getAttribute("UserId");
		
		c.setUserid(userId);
		
		
		return categoryRepo.save(c);
	}

	@RequestMapping("/category/data")
	@ResponseBody
    public DataTablesOutput<CategoryModel> getUsers1(@RequestBody DataTablesInput input,HttpServletRequest request) {
//		System.out.println(request.getParameter("from_date"));
//		String fdate = request.getParameter("from_date");
//		String tdate = request.getParameter("from_date");
		//request.getParameter("from_date");
		Long userId = (Long) request.getSession().getAttribute("UserId");
		@SuppressWarnings("serial")
		Specification<CategoryModel> stu = new Specification<CategoryModel>() {
			
			@Override
			public Predicate toPredicate(Root<CategoryModel> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				
				predicates.add(criteriaBuilder.equal(root.get("flag"), false));
				predicates.add(criteriaBuilder.equal(root.get("userid"), userId));
				// TODO Auto-generated method stub
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}

			
		};
		
		
//		System.out.println(studentRepo.findAll(input));
        return categoryRepo.findAll(input,null,stu);
	}
	
	@RequestMapping("/findbycategory/{id}")
	@ResponseBody
	public CategoryModel findStu(@PathVariable long id)
	{
		return categoryRepo.findById(id).orElse(null);
	}
	
	@RequestMapping("/category/delete/{id}")
	@ResponseBody
	public Optional<CategoryModel> deleteproduct(@PathVariable Long id)
	{
		

		
		Optional<CategoryModel> cus = categoryRepo.findById(id);
		CategoryModel customer = cus.get();
		System.out.println("------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------");
		System.out.println(customer);
		System.out.println("customer");
		customer.setFlag(true);
		System.out.println(customer);
		System.out.println(customer.isFlag());
//		student.setIsDelete("true");
		categoryRepo.save(customer);
		
		
		return categoryRepo.findById(id);
		
		
		//customerrepo.deleteById(id);
		//return "done";
	}
	
	@GetMapping("/category/undo/{id}")
	@ResponseBody
	public Optional<CategoryModel> undoData(@PathVariable long id)
	{
		System.out.print("-------------------------------------------------");
		System.out.print("-------------------------------------------------");
		System.out.print(id);

		Optional<CategoryModel> cus = categoryRepo.findById(id);
		
		CategoryModel customer = cus.get();
		customer.setFlag(false);
		System.out.print(customer);
		System.out.print(customer.isFlag());
//		student.setIsDelete("true");
		categoryRepo.save(customer);
		System.out.print(categoryRepo.findById(id));
		return categoryRepo.findById(id);
	}
	
	
	@GetMapping("/allcategory")
	@ResponseBody
	public List<CategoryModel> getAllcustomer(HttpServletRequest request)
	{
		Long userId = (Long) request.getSession().getAttribute("UserId");
		return categoryRepo.findCategoryData(userId);
	}
}
