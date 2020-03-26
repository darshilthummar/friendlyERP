package com.essyerp.erp.controller.Unit;

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

import com.essyerp.erp.model.Unit.UnitModel;



import com.essyerp.erp.repo.UnitRepo;


@Controller
@RequestMapping(value= {"/",""})
public class UnitController {

	@Autowired
	UnitRepo unitRepo;
	
	@RequestMapping("/manageUnit")
	public String manageUnit()
	{
		return "/unit/manageUnit";
	}
	
	@RequestMapping("/addunit/save")
	@ResponseBody
	public UnitModel saveUnit(@ModelAttribute UnitModel c)
	{
		
		
		
		return unitRepo.save(c);
	}

	@RequestMapping("/unit/data")
	@ResponseBody
    public DataTablesOutput<UnitModel> getUsers1(@RequestBody DataTablesInput input,HttpServletRequest request) {
//		System.out.println(request.getParameter("from_date"));
//		String fdate = request.getParameter("from_date");
//		String tdate = request.getParameter("from_date");
		//request.getParameter("from_date");
		@SuppressWarnings("serial")
		Specification<UnitModel> stu = new Specification<UnitModel>() {
			
			@Override
			public Predicate toPredicate(Root<UnitModel> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> predicates = new ArrayList<>();
				
				predicates.add(criteriaBuilder.equal(root.get("flag"), false));
				// TODO Auto-generated method stub
				return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
			}

			
		};
		
		
//		System.out.println(studentRepo.findAll(input));
        return unitRepo.findAll(input,null,stu);
	}
	
	@RequestMapping("/findbyunit/{id}")
	@ResponseBody
	public UnitModel findUnit(@PathVariable long id)
	{
		return unitRepo.findById(id).orElse(null);
	}
	
	@RequestMapping("/unit/delete/{id}")
	@ResponseBody
	public Optional<UnitModel> deleteunit(@PathVariable Long id)
	{
		

		
		Optional<UnitModel> cus = unitRepo.findById(id);
		UnitModel unit = cus.get();
		System.out.println("------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------");
		System.out.println(unit);
		System.out.println("unit");
		unit.setFlag(true);
		System.out.println(unit);
		System.out.println(unit.isFlag());
//		student.setIsDelete("true");
		unitRepo.save(unit);
		
		
		return unitRepo.findById(id);
		
		
		//unitrepo.deleteById(id);
		//return "done";
	}
	
	@GetMapping("/unit/undo/{id}")
	@ResponseBody
	public Optional<UnitModel> undoData(@PathVariable long id)
	{
		System.out.print("-------------------------------------------------");
		System.out.print("-------------------------------------------------");
		System.out.print(id);

		Optional<UnitModel> cus = unitRepo.findById(id);
		
		UnitModel unit = cus.get();
		unit.setFlag(false);
		System.out.print(unit);
		System.out.print(unit.isFlag());
//		student.setIsDelete("true");
		unitRepo.save(unit);
		System.out.print(unitRepo.findById(id));
		return unitRepo.findById(id);
	}
	
	
	@GetMapping("/allunit")
	@ResponseBody
	public List<UnitModel> getAllunit()
	{
		return unitRepo.findAll();
	}
}
