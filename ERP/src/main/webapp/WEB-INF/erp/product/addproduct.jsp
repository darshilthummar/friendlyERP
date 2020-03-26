<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
<!-- begin::Head -->
<head>
<meta charset="utf-8" />
<title>

Friendly | Add Product
</title>
<jsp:include page="../topscript.jsp"></jsp:include>
</head>
<body class="m-page--fluid m--skin- m-content--skin-light2 m-header--fixed m-header--fixed-mobile m-aside-left--enabled m-aside-left--skin-dark m-aside-left--offcanvas m-footer--push m-aside--offcanvas-default">
<!-- begin:: Page -->

<!-- BEGIN: Header -->
<jsp:include page="../header.jsp"></jsp:include>
	
		<jsp:include page="../sidebar.jsp"></jsp:include> 
<!-- END: Header -->	
<!-- begin::Body -->

<div class="m-grid__item m-grid__item--fluid m-wrapper">
<!-- BEGIN: Subheader -->
					<div class="m-subheader ">
						<div class="d-flex align-items-center">
							<div class="mr-auto">
								<h3 class="m-subheader__title m-subheader__title--separator">
									Product
								</h3>
								<ul class="m-subheader__breadcrumbs m-nav m-nav--inline">
									<li class="m-nav__item m-nav__item--home">
										<a href="/index" class="m-nav__link m-nav__link--icon">
											<i class="m-nav__link-icon la la-home"></i>
										</a>
									</li>
									<li class="m-nav__separator">
										- Product/
									</li>
									<li class="m-nav__item">
										<a href="" class="m-nav__link">
											<span class="m-nav__link-text">
												Add Product
											</span>
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<!-- END: Subheader -->
<div class="m-content">
<div class="row">
<div class="col-lg-12">

<!--begin::Portlet-->
<div class="m-portlet">
<div class="m-portlet__head">
<div class="m-portlet__head-caption">
<div class="m-portlet__head-title">
<span class="m-portlet__head-icon m--hide">
<i class="la la-gear"></i>
</span>
<h3 class="m-portlet__head-text">
Product details
</h3>
</div>
</div>
</div>
<!--begin::Form-->
<form class="m-form m-form--fit m-form--label-align-right m-form--group-seperator-dashed" name="addproduct" method="post" action="addproduct/save">
<div class="m-portlet__body">
<!-- <div class="form-group m-form__group row">
<div class="col-lg-4">
</div>
<div class="col-lg-4">
<label class="">
User Group:
</label>
<div class="m-radio-inline" id="cuser">
<label class="m-radio m-radio--solid">
<input type="radio" name="cuser" checked="" value="supplier">
Supplier
<span></span>
</label>
<label class="m-radio m-radio--solid">
<input type="radio" name="cuser" value="customer">
Customer
<span></span>
</label>
<label class="m-radio m-radio--solid">
<input type="radio" name="cuser" value="transpoter">
Transpoter
<span></span>
</label>
</div>
<span class="m-form__help">
Please select user group
</span>
</div>
</div> -->
<div class="form-group m-form__group row">
<div class="col-lg-4">


<label>
Product Name:
</label>
<input type="text" name="pname" id="pname" class="form-control m-input" placeholder="Enter Product name">
<!-- <span class="m-form__help">
Please enter your frist name
</span> -->
</div>
<div class="col-lg-4">
<label>
category 
</label>
 <select class="form-control m-select2" name="categorymodel.id" id="categoryid" >
						   <option value="0">select Category</option>
															   
						 </select>	
</div>
<div class="col-lg-4">
<label class="">
Sub-Category :
</label>
<select class="form-control m-select2" name="subcategorymodel.id" id="subcategoryid" >
						   <option value="0">select SubCategory</option>
															   
						 </select>	
</div>
</div>

<div class="form-group m-form__group row">
<div class="col-lg-4">
<label class="">
Measurement:
</label>
<select class="form-control m-select2" name="measurement" id="unitid" >
   <option value="0">select unit of Measurement</option>
   
 </select>

</div>
<div class="col-lg-4">
<label class="">
Product image:
</label>
<div class="m-input-icon m-input-icon--right">
<!-- <input type="text" name="city" id="city" class="form-control m-input" placeholder="city"> -->
                              <input type="file" name="image" class="form-control m-input" id="image" tabindex="" placeholder="upload product image">

<!-- <span class="m-input-icon__icon m-input-icon__icon--right">
<span>
<i class="la la-info-circle"></i>
</span>
</span> -->
</div>
<!-- <span class="m-form__help">
Please enter city
</span> -->
</div>
<div class="col-lg-4">
<label>
Product description:
</label>
<div class="m-input-icon m-input-icon--right">
<textarea name="description" id="description" class="form-control m-input" placeholder="Enter product detail" rows="2" cols="3">
</textarea>
</div>
<!-- <span class="m-form__help">
Please enter your postcode
</span> -->
</div>
</div>
<div class="form-group m-form__group row">

<div class="col-lg-4">
<label class="">
Purchase price:
</label>
<input type="text" name="purchasePrice" id="purchasePrice" class="form-control m-input" placeholder="Enter Purchase Price">

</div>
<div class="col-lg-4">
<label class="">
MRP:
</label>
<div class="m-input-icon m-input-icon--right">
<input type="text" name="salesPrice" id="salesPrice" class="form-control m-input" placeholder="Enter Sales Price">
<!-- <span class="m-input-icon__icon m-input-icon__icon--right">
<span>
<i class="la la-info-circle"></i>
</span>
</span> -->
</div>
<!-- <span class="m-form__help">
Please enter fax
</span> -->
</div>
<div class="col-lg-4">
<label>
Tax:
</label>
<div class="m-input-icon m-input-icon--right">
<select class="form-control m-select2" name="tax" id="taxid" >
   <option value="0">select Tax</option>
   </select>
</div>
<!-- <span class="m-form__help">
Please enter your address
</span> -->
</div>
</div>

</div>
<div class="m-portlet__foot m-portlet__no-border m-portlet__foot--fit">
<div class="m-form__actions m-form__actions--solid">
<div class="row">
<div class="col-lg-4"></div>
<div class="col-lg-8">
<input type="submit" value="Submit" class="btn btn-primary">
<button type="reset" class="btn btn-secondary">
Cancel
</button>
</div>
</div>
</div>
</div>
</form>
<!--end::Form-->
</div>
<!--end::Portlet-->
</div>
</div>
</div>
</div>

<!-- end:: Body -->
<!-- begin::Footer -->
<jsp:include page="../footer.jsp"></jsp:include>
<!-- end::Footer -->

<!-- end:: Page -->	   
    <jsp:include page="../basescript.jsp" />

<!-- end::Body -->


</body>
<script type="text/javascript">
$(document).ready(function()
		{
	
	
	
$.get("/allcategory", function(data, status){
	console.log(data);
	$.each(data,function(i,o){
		console.log(o.id);
		$("#categoryid").append('<option value='+o.id+'>'+o.categoryname+'</option>');
		
	  });
	
  });
  
$.get("/alltax", function(data, status){
	console.log(data);
	$.each(data,function(i,o){
		console.log(o.id);
		$("#taxid").append('<option value='+o.tax+'>'+o.tax+'</option>');
		
	  });
	
  });
  
$.get("/allunit", function(data, status){
	console.log(data);
	$.each(data,function(i,o){
		console.log(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		console.log(o.unitcode);
		$("#unitid").append('<option value='+o.unitcode+'>'+o.unitcode+'</option>');
		
	  });
	
  });
  
$("#categoryid").change(function () {
	$("#subcategoryid").empty();
	

    var id1 = $('option:selected',this).val();
    console.log(id1);
    $.get("/findbySubcategory1/"+id1, function(data, status){
    	console.log(data);
    	$("#subcategoryid").append('<option value="0">select SubCategory</option>');
    	$.each(data,function(i,o){
    		console.log(o.id);
    		$("#subcategoryid").append('<option value='+o.id+'>'+o.subcategoryname+'</option>');
    		
    	  });
    	
      });

});
  
  
		});
</script>
</html>