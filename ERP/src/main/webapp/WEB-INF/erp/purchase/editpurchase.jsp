<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
	<!-- begin::Head -->
	<head>
		<meta charset="utf-8" />
		<title>
			Friendly | Add Purchase
		</title>
		
		<jsp:include page="../topscript.jsp"></jsp:include>
<link rel="stylesheet" href="/assets/vendors/formvalidation/css/formValidation.min.css">		
	
	</head>
	<body class="m-page--fluid m--skin- m-content--skin-light2 m-header--fixed m-header--fixed-mobile m-aside-left--enabled m-aside-left--skin-dark m-aside-left--offcanvas m-footer--push m-aside--offcanvas-default">
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
									Purchase
								</h3>
								<ul class="m-subheader__breadcrumbs m-nav m-nav--inline">
									<li class="m-nav__item m-nav__item--home">
										<a href="/index" class="m-nav__link m-nav__link--icon">
											<i class="m-nav__link-icon la la-home"></i>
										</a>
									</li>
									<li class="m-nav__separator">
										- Purchase/
									</li>
									<li class="m-nav__item">
										<a href="" class="m-nav__link">
											<span class="m-nav__link-text">
												Add Purchase
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
													Purchase details
												</h3>
											</div>
										</div>
									</div>
									<!--begin::Form-->
									<form class="m-form m-form--label-align-right" method="post" action="/addpurchase/save">
										<div class="m-portlet__body">
											<div class="m-form__section m-form__section--first">
												<div class="form-group m-form__group row">
												<input type="hidden" name="purchaseitemModel[0].id" id="purchaseitem_id"> 
										     	<input type="hidden" name="id" id="purchase_id"> 
												
												 <div class="col-lg-6">
												
											    
											     </div>
													<label class="col-lg-2 col-form-label">
														Invoice No:
													</label>
													<div class="col-lg-4">
														<input type="text" class="form-control m-input--solid" name="invoiceno" id="invoiceno_id" readonly="readonly"> 	
													</div>
													
												</div>
												<div class="form-group m-form__group row">
											
													<label class="col-lg-2 col-form-label">
														Supplier:
													</label>
													<div class="col-lg-4">
														<select class="form-control m-select2" name="supplier.cid" id="supplier_id" >
															   <option value="0">select Supplier</option>
															   
															 </select>		
													</div>
													<label class="col-lg-2 col-form-label">
														Date:
													</label>
													<div class="col-lg-4">
														<input type="date" class="form-control m-input" name="date" id="date_id">
														
													</div>
												</div>
												<div class="form-group m-form__group row">
													<label class="col-lg-2 col-form-label">
														Payment Type:
													</label>
													<div class="col-lg-4">
														<select class="form-control m-input" name="paymenttype" id="paymenttype_id" >
															   <option value="0">select paymentType</option>
															   <option value="Cash_Payment">Cash Payment</option>
															   <option value="Bank_Payment">Bank Payment</option>
															 </select>	
														
													</div>
													
													<label class="col-lg-2 col-form-label">
														Details:
													</label>
													<div class="col-lg-4">
														
                                                     <div class="m-input-icon m-input-icon--right">
                                                     <textarea name="details" id="details_id" class="form-control m-input" placeholder="Enter product detail" rows="2" cols="3"></textarea>
                                                    </div>
													</div>
												</div>
												<div class="form-group m-form__group row">
													<div class="col-lg-2">
													<label>
														Product:
													</label>
													<div class="m-input-icon m-input-icon--right">
														<select class="form-control m-select2" name="purchaseitemModel[0].product.id" id="product_id" >
															   <option value="0">select Product</option>
															   
															 </select>		
													</div>
													
												</div>
												<div class="col-lg-2">
													<label>
														Ava.Stock:
													</label>
													<div class="m-input-icon m-input-icon--right">
														<input type="text" name="" id="" class="form-control m-input--solid" readonly="readonly">
														
													</div>
													
												</div>
												<div class="col-lg-2">
													<label>
														Qnty:
													</label>
													<div class="m-input-icon m-input-icon--right">
														<input type="text" name="purchaseitemModel[0].quantity" id="quantity_id" class="form-control m-input" placeholder="0">
														
													</div>
													
												</div>
												<div class="col-lg-2">
													<label>
														Rate:
													</label>
													<div class="m-input-icon m-input-icon--right">
														<input type="text" name="purchaseitemModel[0].rate" id="rate_id" class="form-control m-input">
														
													</div>
													
												</div>
												<div class="col-lg-2">
													<label>
														Total:
													</label>
													<div class="m-input-icon m-input-icon--right">
														<input type="text" name="purchaseitemModel[0].total" id="total_id" class="form-control m-input">
														
													</div>
													
												</div>
												<!-- <div class="col-lg-2">
													<label>
														Action:
													</label>
													<div class="m-input-icon m-input-icon--right">
														<a class="btn btn-warning edit" id="edit_subcategory" data-toggle="modal" data-target="#m_modal_6" data-id="'+data+'"><i class="fa fa-plus"></i></a>
														<a class="btn btn-danger delete-pro" data-id="'+data+'"><i class="fa fa-trash-o"></i></a>
													</div>
													
												</div> -->
												</div>
												<div class="form-group m-form__group row">
												<div class="col-lg-2">
													
													
												</div>
												<div class="col-lg-2">
													
													
												</div>
												<div class="col-lg-2">
													
													
												</div>
												<div class="col-lg-2 col-form-label">
													<label style="padding-left: 60px;" >
														Grand Total:
													</label>
													
												</div>
												
													<div class="col-lg-2">
													
													<div class="m-input-icon m-input-icon--right">
														<input type="text" name="grandtotal" id="grandtotal_id" class="form-control m-input--solid" readonly="readonly">
														
													</div>
													
												</div>
												<div class="col-lg-2">
													
													
												</div>
												</div>
												</div>
												</div>
												<div class="m-portlet__foot m-portlet__no-border m-portlet__foot--fit">
											<div class="m-form__actions m-form__actions--solid">
												<div class="row">
													<div class="col-lg-4"></div>
													<div class="col-lg-8">
														<input type="submit" value="Submit" id="save_purchase" class="btn btn-primary">
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
			
			<!-- start footer -->
		<jsp:include page="../footer.jsp"></jsp:include>
		    <!-- end footer -->
		
		<!-- end:: Page -->	    
	   	    
	   	    
		
	<jsp:include page="../basescript.jsp" />
<script src="/assets/vendors/formvalidation/js/FormValidation.min.js"></script>
		<script src="/assets/vendors/formvalidation/js/framework/Bootstrap.min.js"></script>
	<!-- end::Body -->
	<script type="text/javascript">
	$( document ).ready(function() {
		
	    console.log( "ready!" );
	
	    var a = "${purchase.purchaseModel.grandtotal}";
	    var b = "${purchase.total}";
	    var c = a-b;
	    
	    
	    
	    
	    
	    $.get("/findAllSupplier", function(data, status){
	    	console.log(data);
	    	$.each(data,function(i,o){
	    		
	    		$("#supplier_id").append('<option value='+o.cid+'>'+o.cfname+'</option>');
	    		
	    	  });
	    	$("#supplier_id").val("${purchase.purchaseModel.supplier.cid}");
	      });
	    
	    $.get("/products",  // url
			      function (data, status) {  
      	
      
      	
      	var list1=data;
      	console.log("----------------------->>>>>-------------->>>>>>>");
		      console.log(list1);
  		$.each(list1, function( i, o ) {
  			
  		console.log(o.id);
  		$("#product_id").append('<option value="'+o.id+'">'+o.pname+'</option>');
  		                        
  		});
  		$("#product_id").val("${purchase.product.id}");
				});
	    
	    console.log("----------------------->>>>>");
	    $("#product_id").change(function () {
	    	$("#rate_id").val(0);
 			$("#total_id").val(0);
 			
 			$("#quantity_id").val(0);
 			grandTotal();
	    	var id1 = $(this).val();
	    	$.get("/findByIdproduct/"+id1,  // url
				      function (data, status) {  
	    	console.log(data);
	    		 $("#rate_id").val(data.salesPrice);
	    		
	    		 
	    		 
	    });
	    });
	    $("#quantity_id").keyup(function(){ 
			$("#total_id").empty();
			
		  var q=$("#quantity_id").val();
		  var p=$("#rate_id").val();
		  $("#total_id").val(q*p);
		  grandTotal()
		});
	    
	    $("#rate_id").keyup(function(){ 
			$("#total_id").empty();
			
		  var q=$("#quantity_id").val();
		  var p=$("#rate_id").val();
		  $("#total_id").val(q*p);
		  grandTotal();
		});
	    console.log("====================================");
	    console.log("${purchase.product.stockModel.avlstock}");
	    $("#purchaseitem_id").val("${purchase.id}");
	    $("#purchase_id").val("${purchase.purchaseModel.id}");
	    $("#invoiceno_id").val("${purchase.purchaseModel.invoiceno}");
	    
	    console.log("${purchase.purchaseModel.date}")
	    $("#date_id").val("${purchase.purchaseModel.date}");
	    $("#paymenttype_id").val("${purchase.purchaseModel.paymenttype}");
	    $("#details_id").val("${purchase.purchaseModel.details}");
	    
	    $("#quantity_id").val("${purchase.quantity}");
	    $("#rate_id").val(parseFloat("${purchase.rate}"));
	    $("#total_id").val(parseFloat("${purchase.total}"));
	   // $("#grandtotal_id").val("${purchase.purchaseModel.grandtotal}");
	    grandTotal();
	    function grandTotal()
	    {
	    $("#grandtotal_id").val(parseFloat(c)+ parseFloat($("#total_id").val()));
	    }
});

    </script>

</body>


</html>