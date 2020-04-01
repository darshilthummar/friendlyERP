<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html lang="en">
<!-- begin::Head -->
<head>
<meta charset="utf-8" />
<title>Friendly | Add Sales</title>


<jsp:include page="../topscript.jsp"></jsp:include>
<link rel="stylesheet"
	href="/assets/vendors/formvalidation/css/formValidation.min.css">
<style type="text/css">
.hide {
	display: none;
}
</style>
</head>
<body
	class="m-page--fluid m--skin- m-content--skin-light2 m-header--fixed m-header--fixed-mobile m-aside-left--enabled m-aside-left--skin-dark m-aside-left--offcanvas m-footer--push m-aside--offcanvas-default">
	<!-- begin:: Page -->
	<jsp:include page="../header.jsp"></jsp:include>


	<jsp:include page="../sidebar.jsp"></jsp:include>
	<!-- begin::Body -->


	<div class="m-grid__item m-grid__item--fluid m-wrapper">




		<!-- BEGIN: Subheader -->
		<div class="m-subheader ">
			<div class="d-flex align-items-center">
				<div class="mr-auto">
					<h3 class="m-subheader__title m-subheader__title--separator">
						Sales</h3>
					<ul class="m-subheader__breadcrumbs m-nav m-nav--inline">
						<li class="m-nav__item m-nav__item--home"><a href="#"
							class="m-nav__link m-nav__link--icon"> <i
								class="m-nav__link-icon la la-home"></i>
						</a></li>
						<li class="m-nav__separator">- Sales/</li>
						<li class="m-nav__item"><a href="" class="m-nav__link"> <span
								class="m-nav__link-text"> Add Sales </span>
						</a></li>
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
									<span class="m-portlet__head-icon m--hide"> <i
										class="la la-gear"></i>
									</span>
									<h3 class="m-portlet__head-text">Sales details</h3>
								</div>
							</div>
						</div>
						<!--begin::Form-->
						<form class="m-form m-form--label-align-right" method="post" action="addSales/save" id="purchase_form">
							<div class="m-portlet__body">
								<div class="m-form__section m-form__section--first">

									<div class="form-group m-form__group row">
									<label class="col-lg-2 col-form-label"> Invice No: </label>
									<div class="col-lg-4">
									<input type="hidden" value="${inviceNo}" name="invoiceno">
									<input type="hidden" value="${prefix}" name="prefix"> 
									<input type="hidden" value="1" name="new">
									<input type="text" name="invoice_no" id="inviceNo" class="form-control m-input quantity_id" value="${prefix}-${inviceNo}" readonly="readonly">
									</div>
									</div>

									<div class="form-group m-form__group row">
										<input type="hidden" name="invoiceno" id="invoiceno_id">
										<label class="col-lg-2 col-form-label"> Customer: </label>
										<div class="col-lg-4">
											<select class="form-control m-select2" name="customerModel.cid" id="customer_id">
												<option value="0">select Customer</option>
												<c:forEach items="${customerList}" var="customerLists">
												<option value="${customerLists.cid}">${customerLists.cfname}</option>
												</c:forEach>


											</select>
										</div>
										<label class="col-lg-2 col-form-label"> Date: </label>
										<div class="col-lg-4">
										<input type="text" class="form-control daterange-single" name="date" id="date_id"  >
										<div class="form-control-feedback">
											<i class="icon-calendar22" ></i>
										</div>
										</div>
										<!-- 
											<input type="date" class="form-control daterange-single" name="date" id="date_id">


										</div> -->
									</div>
									<div class="form-group m-form__group row">
										<label class="col-lg-2 col-form-label"> Payment Type:</label>
										<div class="col-lg-4">
											<select class="form-control m-select2" name="paymenttype" id="paymenttype_id">
												<option value="0">select paymentType</option>
												<option value="Cash Payment">Cash Payment</option>
												<option value="Bank Payment">Bank Payment</option>
											</select>
										</div>


										<label class="col-lg-2 col-form-label"> Details: </label>
										<div class="col-lg-4">


											<div class="m-input-icon m-input-icon--right">
												<textarea name="details" id="details_id" class="form-control m-input"
													placeholder="Enter product detail" rows="2" cols="3"></textarea>
											</div>
										</div>
									</div>






									<!-- main -->
									<div>
										<div data-item="0">


											<div class="" data-index=""></div>
											<div class="form-group m-form__group row">
												<div class="col-lg-2">
													<label> Product: </label>
													<div class="m-input-icon m-input-icon--right">
														<select class="form-control m-input product_id" onchange="calculation(0)" name="salesItemModel[0].product.id" id="product_id0">
															<option value="0">select Product</option>
														</select>
													</div>
												</div>
												<div class="col-lg-2">
													<label> Ava.Stock: </label>
													<div class="m-input-icon m-input-icon--right">
														<input type="text" name="" id="avl_stock0" class="form-control m-input">


													</div>


												</div>
												<div class="col-lg-2">
													<label> Qnty: </label>
													<div class="m-input-icon m-input-icon--right">
														<input type="text" name="salesItemModel[0].quantity" id="quantity_id0" class="form-control m-input quantity_id" value="0">
												</div>


												</div>
												<div class="col-lg-2">
													<label> Rate: </label>
													<div class="m-input-icon m-input-icon--right">
														<input type="text" name="salesItemModel[0].rate" id="rate_id0" class="form-control m-input rate_id" value="0">


													</div>


												</div>
												<div class="col-lg-2">
													<label> Total: </label>
													<div class="m-input-icon m-input-icon--right">
														<input type="text" name="salesItemModel[0].total" id="total_id0" class="form-control m-input total_id" value="0">


													</div>


												</div>
												<div class="col-lg-2">
													<label> Action </label>
													<div class="m-input-icon m-input-icon--right">
														<a class="btn btn-danger delete-pro" data-remove=""><i class="fa fa-trash-o"></i></a>
													</div>


												</div>
											</div>
										</div>
									</div>


									<!-- model -->


									<div data-list="">
										<div data-item="template" class="m--hide">


											<div class="" data-index=""></div>
											<div class="form-group m-form__group row">
												<div class="col-lg-2">


													<div class="m-input-icon m-input-icon--right">
														<select class="form-control m-input product_id" name="salesItemModel[{index}].product.id" onchange="calculation({index})" id="product_id{index}">
															<option value="0">select Product</option>


														</select>
													</div>


												</div>
												<div class="col-lg-2">


													<div class="m-input-icon m-input-icon--right">
														<input type="text" name="" id="avl_stock{index}" class="form-control m-input avlstock_id">


													</div>


												</div>
												<div class="col-lg-2">


													<div class="m-input-icon m-input-icon--right">
														<input type="text" name="salesItemModel[{index}].quantity" id="quantity_id{index}" class="form-control m-input quantity_id" value="0">


													</div>


												</div>
												<div class="col-lg-2">


													<div class="m-input-icon m-input-icon--right">
														<input type="text" name="salesItemModel[{index}].rate" id="rate_id{index}" class="form-control m-input rate_id" value="0">


													</div>


												</div>
												<div class="col-lg-2">


													<div class="m-input-icon m-input-icon--right">
														<input type="text" name="salesItemModel[{index}].total" id="total_id{index}" class="form-control m-input total_id" value="0">


													</div>


												</div>
												<div class="col-lg-2">


													<div class="m-input-icon m-input-icon--right">
														<a class="btn btn-danger delete-pro" data-remove=""><i  class="fa fa-trash-o"></i></a>
													</div>


												</div>
											</div>


										</div>
									</div>










									<div class="form-group m-form__group row">
										<div class="col-lg-2"></div>
										<div class="col-lg-2"></div>
										<div class="col-lg-2"></div>
										<div class="col-lg-2 col-form-label">
											<label style="padding-left: 60px;"> Grand Total: </label>


										</div>


										<div class="col-lg-2">


											<div class="m-input-icon m-input-icon--right">
												<input type="text" name="grandtotal" id="grandtotal_id"
													class="form-control m-input m-input--solid"
													style="background-color: #E8F0FE;" readonly="readonly">


											</div>


										</div>
										<div class="col-lg-2">
											<a class="btn btn-warning" id="btnrow"><i
												class="fa fa-plus"></i></a>


										</div>
									</div>
								</div>
							</div>
							<div
								class="m-portlet__foot m-portlet__no-border m-portlet__foot--fit">
								<div class="m-form__actions m-form__actions--solid">
									<div class="row">
										<div class="col-lg-4"></div>
										<div class="col-lg-8">
											<input type="submit" value="Submit" id="save_purchase"
												class="btn btn-primary">
											<button type="reset" class="btn btn-secondary">
												Cancel</button>
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


	<!-- start footer -->
	<jsp:include page="../footer.jsp"></jsp:include>
	<!-- end footer -->


	<!-- end:: Page -->






	<jsp:include page="../basescript.jsp" />
	<script src="/assets/vendors/formvalidation/js/FormValidation.min.js"></script>
	<script src="/assets/app/js/select2.js"></script>
	<script src="/assets/app/js/daterangepicker.js"></script>
	<script
		src="/assets/vendors/formvalidation/js/framework/Bootstrap.min.js"></script>
	<!-- end::Body -->
	<script type="text/javascript">
	
	$('.daterange-single').daterangepicker({
		singleDatePicker : true,
		locale:{
		format: 'YYYY-MM-DD' 
		}
   
	});
	
	var index = 0, productId=1;
	

	$( document ).ready(function() {
	    console.log( "ready!" );
	

	     /* $.get("/findAllCustomer", function(data, status){
	    	console.log(data);
	    	$.each(data,function(i,o){
	    	

	    	$("#supplier_id").append('<option value='+o.cid+'>'+o.cfname+'</option>');
	    	

	    	  });
	    	

	      }); */
	   

	    

	    $.get("/products",  // url
	      function (data, status) {  
      	var list1=data;
      	console.log("----------------------->>>>>-------------->>>>>>>");
	      console.log(list1);
  	$.each(list1, function( i, o ) {
  	

  	console.log(o.id);
  	$(".product_id").append('<option value="'+o.id+'">'+o.pname+'</option>');
  	                        

  	});
  	

	});
	    
	    

	    console.log("----------------------->>>>>");
	  /*   $("#product_id").change(function () { */
	    	/* $("#rate_id").val(null);
 	$("#total_id").val(null);
 	$("#grandtotal_id").val(null);
 	$("#quantity_id").val(null);
	    	

	    	var id1 = $(this).val();
	    	$.get("/findByIdproduct/"+id1,  // url
	      function (data, status) {  
	    	console.log(data);
	    	 $("#rate_id").val(data.salesPrice);
	    	

	    	 

	    	 

	    }); */
	    /* }); */
	    /* $("#quantity_id").keyup(function(){ 
	$("#total_id").empty();
	$("#grandtotal_id").empty();
	  var q=$("#quantity_id").val();
	  var p=$("#rate_id").val();
	  $("#total_id").val(q*p);
	  $("#grandtotal_id").val(q*p);
	});
	    

	    $("#rate_id").keyup(function(){ 
	$("#total_id").empty();
	$("#grandtotal_id").empty();
	  var q=$("#quantity_id").val();
	  var p=$("#rate_id").val();
	  $("#total_id").val(q*p);
	  $("#grandtotal_id").val(q*p);
	}); */
	    $("#invoiceno_id").val(1);
	   /*  $.get("/findAllpurchase", function(data, status){
	    	 

	    	console.log("----------------------->>>>>");
	    	var k=0;
	    	

	    	$.each(data,function(i,o){
	    	

	    	k++;
	    	

	    	  });
	    	

	    	console.log(k);
	    	$.get("/findAllpurchase", function(data, status){
	    	

	    	console.log("----------------------->>>>>");
	    	var j=0;
	    	

	    	$.each(data,function(i,o){
	    	j++;
	    	if(j==k)
	    	{
	    	console.log(o.invoiceno);
	    	var no3 = o.invoiceno+1; 
	    	console.log(no3);
	    	$("#invoiceno_id").val(null);
	    	$("#invoiceno_id").val(no3);
	    	}
	    	

	    	  });
	    	

	    	console.log(k);
	    	

	      });
	      }); 
 */	    

	    /* index */
	    

	    $(document).on('click','#btnrow',function(e) {
	    	

	    	 

	    	e.preventDefault();
	    	addProduct();
	    	

	    	});

	    $("#purchase_form").on("click",'a[data-remove]',function(e) {
	//var i=$(this).closest("[data-jobwork-item]").attr("data-jobwork-item");
	//e.preventDefault();
	//var i=$(this).closest("[data-item]").attr("data-item");
	//$('#jobwork_form').formValidation('removeField',"jobworkItemVos["+i+"].productVariantsVo.productVariantId");
	//$('#jobwork_form').formValidation('removeField',"jobworkItemVos["+i+"].qty");
	console.log("hello");
	var r = confirm("are u sure want to delete");
	if(r==true){
	$(this).closest("[data-item]").remove();
	  grandTotal();
	setProductSrNo();
	//setTotalQty();
	}
	});

	    $("#save_purchase").click(function() 
	    	{

	    	if($("#purchase_form").find("[data-item]").not(".m--hide").length == 0) 
	    	{
	    	toastr.error("","add minimum one product");
	    	return false;
	    	}else
	    	{
	    	$("#purchase_form").find("[data-item='template']").remove();
	    	}

	    	 //alert( $("#receivedBy").val());
	    	//return false;	
	    	});
	    	

	    

});
	function addProduct() {
	

    	 $productItemTemplate=$("#purchase_form").find("[data-item='template']").clone();
    	 

    	$productItemTemplate.removeClass("m--hide").attr("data-item",productId);
    	$productItemTemplate.find("input[type='text'],input[type='hidden'],select,textarea,span").each(function ()
    	{
    	n=$(this).attr("id");
    	n ? $(this).attr("id",n.replace(/{index}/g,productId)) : "";
    	n=$(this).attr("onchange");
    	n ? $(this).attr("onchange",n.replace(/{index}/g,productId)) : "";
    	n=$(this).attr("name");
    	n ? $(this).attr("name",n.replace(/{index}/g,productId)) : "";

    	//$(this).attr("onchange") ? $(this).attr("onchange",$(this).attr("onchange").replace(/{index}/g,productId)) : "";
    	});
    	

    	console.log($productItemTemplate);

    	$("#purchase_form").find("[data-list]").append($productItemTemplate);
    	productId++;
    	

    	setProductSrNo();
    	}
	function setProductSrNo() 
	{
	var $productItem=$("#purchase_form").find("[data-item]").not(".m--hide");
	var i = 1;
	$productItem.each(function (){
	//$(this).find("[data-index]").html(++i));
	});
	}
	

	

	function calculation(j) {
	console.log(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>--------------------------");
	    

	    

	  

	    $("#rate_id"+j).val(0);
	$("#total_id"+j).val(0);
	

	$("#quantity_id"+j).val(0);
    	

    	var id1 = $("#product_id"+j).val();
    	console.log(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
    	
    	$.get("findByIdproduct/"+id1,  // url
	      function (data, status) {  
    	console.log(data);
    	 $("#rate_id"+j).val(data.salesPrice);
    	

    });
	   

    	$("#quantity_id"+j).keyup(function(){ 
	$("#total_id"+j).empty();
	

	  var q=$("#quantity_id"+j).val();
	  var p=$("#rate_id"+j).val();
	  $("#total_id"+j).val(q*p);
	  

	  grandTotal();
	  

	  });
	    

	    $("#rate_id"+j).keyup(function(){ 
	$("#total_id"+j).empty();
	

	  var q=$("#quantity_id"+j).val();
	  var p=$("#rate_id"+j).val();
	  $("#total_id"+j).val(q*p);
	  grandTotal();
	});
	     }
	function grandTotal(){
	console.log("[[[[[[[[[[[[[[[[[[[[[[[[[[[[[]]]]]]]]]]]]]]]]]]]]]]]]]]]]");
	var no5 = parseFloat($("#purchase_form").find("[data-item]").not(".m--hide").length);
	console.log(no5);
	var total = 0;
	var arlene1 = new Array();
	var x=0;
	$("[data-item]").each(function(){
	if(($(this).attr("data-item"))!="template"){
	console.log("{{{{{{{{{{{{{{{{{{{{{{{{{{{}}}}}}}}}}}}}}}}}}}}}}}}}}}");
	   console.log($(this).attr("data-item"));
	   arlene1[x]=$(this).attr("data-item");
	   

	   

	   x++;
	}
	});
	

	

	for(var k=0;k<no5;k++)
	{
	

	console.log($("#total_id"+arlene1[k]).val());
	var no3 = $("#total_id"+arlene1[k]).val();
	total = parseFloat(total) + parseFloat(no3);
	}
	console.log(total);
	 $("#grandtotal_id").val(total);
	}
	

	

    </script>

</body>


</html>