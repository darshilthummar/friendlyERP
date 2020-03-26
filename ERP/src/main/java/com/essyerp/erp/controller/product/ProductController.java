package com.essyerp.erp.controller.product;

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
import org.springframework.web.servlet.ModelAndView;

import com.essyerp.erp.model.country.State;
import com.essyerp.erp.model.product.ProductModel;
import com.essyerp.erp.repo.ProductRepo;

@Controller
@RequestMapping(value= {"/",""})
public class ProductController 
{
 
@Autowired
ProductRepo productRepo;

@GetMapping("/addproduct")
public String addCustomer()
{
return "/product/addproduct";
}

@GetMapping("/manageproduct")
public String manageCustomer()
{
return "/product/manageproduct";
}


@PostMapping("/addproduct/save")
public String saveProduct(@ModelAttribute ProductModel p)
{
productRepo.save(p);
return "redirect:/manageproduct";
}


@RequestMapping("/products")
@ResponseBody
public  List<ProductModel> getAllproducts()
{
      return productRepo.findAll();
}

@RequestMapping("/findByIdproduct/{id}")
@ResponseBody
public ProductModel getAllproduct(@PathVariable long id)
{
     
	return productRepo.findById(id).orElse(null);
}

@GetMapping("/delete/{id}")
    @ResponseBody
    public Optional<ProductModel> deleteproduct(@PathVariable Long id)
    {

Optional<ProductModel> pro = productRepo.findById(id);

ProductModel product = pro.get();
System.out.println(product);
           product.setIsdelete(1);
//            System.out.println(product);
//            System.out.println(product.isFlag());
//          student.setIsDelete("true");
           productRepo.save(product);


           return productRepo.findById(id);


           //customerrepo.deleteById(id);
           //return "done";
   }

//	@RequestMapping("/data")
//	@ResponseBody
//	public DataTablesOutput<ProductModel> getProduct(@RequestBody DataTablesInput input) 
//	{ 
//	 return  productRepo.findAll(input);
//	}
//	
@RequestMapping("/product/data")
     @ResponseBody
public DataTablesOutput<ProductModel> getProduct(@RequestBody DataTablesInput input,HttpServletRequest request) {
//           System.out.println(request.getParameter("from_date"));
//           String fdate = request.getParameter("from_date");
//           String tdate = request.getParameter("from_date");
            //request.getParameter("from_date");
            @SuppressWarnings("serial")
            Specification<ProductModel> stu = new Specification<ProductModel>() {

@Override
public Predicate toPredicate(Root<ProductModel> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
List<Predicate> predicates = new ArrayList<>();

                            predicates.add(criteriaBuilder.equal(root.get("isdelete"), 0));
                            // TODO Auto-generated method stub
                            return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
                    }


            };


//           System.out.println(studentRepo.findAll(input));
    return productRepo.findAll(input,null,stu);
    }


@RequestMapping("/editproduct/{id}")
@ResponseBody
public ModelAndView getDataById(@PathVariable Long id)
{
System.out.println("==>"+id);
ModelAndView mv=new ModelAndView("product/editproduct");

mv.addObject("product",productRepo.findById(id).orElse(null));
System.out.println("=>"+mv);
return mv;

}


@GetMapping("/product/undo/{id}")
     @ResponseBody
     public Optional<ProductModel> undoData(@PathVariable long id)
     {
             Optional<ProductModel> pro = productRepo.findById(id);

             ProductModel product = pro.get();
             product.setIsdelete(0);
             //System.out.print(customer);
             //System.out.print(customer.isFlag());
//           student.setIsDelete("true");
             productRepo.save(product);
             return productRepo.findById(id);
     }

@GetMapping("/findBySupplierIdProduct/{id}")
@ResponseBody
public List<ProductModel> getAllState(@PathVariable Long id) 
{		
	return productRepo.findData(id);
}


@RequestMapping("/productName")
@ResponseBody
public  List<String> getAllproductsName()
{
      return productRepo.findProductname();
}
}