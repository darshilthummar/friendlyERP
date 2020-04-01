<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html lang="en">
<!-- begin::Head -->
<head>
<meta charset="utf-8" />
<title>Friendly | Edit Sales</title>


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
								class="m-nav__link-text"> Edit Sales </span>
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
									<h3 class="m-portlet__head-text">Sales details </h3>
								</div>
							</div>
						</div>
						<!--begin::Form-->
						<form class="m-form m-form--label-align-right" method="post" action="/sales/addSales/save" id="purchase_form">
							<div class="m-portlet__body">
								<div class="m-form__section m-form__section--first">
								<input type="hidden" value="${sales.id}" name="id">

									<div class="form-group m-form__group row">
									<label class="col-lg-2 col-form-label"> Invice No: </label>
									<div class="col-lg-4">
									<input type="hidden" value="${sales.invoiceno}" name="invoiceno">
									<input type="hidden" value="${sales.prefix}" name="prefix"> 
									<input type="hidden" value="" name="delete_product" id="delete_product"> 
									<input type="text" name="invoice_no" id="inviceNo" class="form-control m-input quantity_id" value="${sales.prefix}-${sales.invoiceno}" readonly="readonly">
									</div>
									</div>
									<div class="form-group m-form__group row">
										<!-- <input type="hidden" name="invoiceno" id="invoiceno_id"> -->
										<label class="col-lg-2 col-form-label"> Customer: </label>
										<div class="col-lg-4">
											<select class="form-control m-select2" name="customerModel.cid" id="customer_id" value="sales.customerModel">
												<option value="0">select Customer</option>
			                    			<c:forEach items="${customerList}" var="customerList">
			                    		 <c:choose>
			                    				<c:when test="${customerList.cid==sales.customerModel.cid}">
			                    					<option value="${customerList.cid}" selected="selected" >${customerList.cfname}</option>
			                    				</c:when>
			                    				<c:otherwise>
			                         				<option value="${customerList.cid}">${customerList.cfname}</option>
			                         				
			                    				</c:otherwise>
	                    					</c:choose> 
	                    						
			                    			</c:forEach>

											</select>
										</div>
										<label class="col-lg-2 col-form-label"> Date: </label>
										<div class="col-lg-4">
										<input type="text" class="form-control daterange-single" name="date" id="date_id" value="${sales.date}" >
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
												
												<option value="Cash Payment" <c:if test="${sales.paymenttype == 'Cash Payment'}">selected="selected"</c:if>>Cash Payment</option>
												
												<option value="Bank Payment" <c:if test="${sales.paymenttype == 'Bank Payment'}"> selected="selected"</c:if>>Bank Payment</option>
											<%-- 
											<option value="Input Service Distributor" 
											<c:if test="${supplierDetail.gstRegistrationType == 'Input Service Distributor'}">selected="selected"</c:if>>Input Service Distributor</option>
											 --%></select>
										</div>


										<label class="col-lg-2 col-form-label"> Details: </label>
										<div class="col-lg-4">


											<div class="m-input-icon m-input-icon--right">
												<textarea name="details" id="details_id" class="form-control m-input"
													placeholder="Enter product detail" rows="2" cols="3">${sales.details}</textarea>
											</div>
										</div>
									</div>






									<!-- main -->
						<div class="row">
							<br>
							<div class="table-responsive">
							<p id="errormessageadditem" style="color:red;"></p>
								<table class="table table-bordered table-framed" id="sales_Table">
									<thead>
										<tr>
											
											<th class="">Sr No.</th>
											<th class="">Product</th>
											<!-- <th class="">Ava.Stock</th> -->
											<th class="">Qty</th>
											<th class="">Rate</th>
											<th class="">Total</th>
											<th class="">Action</th>
											
										</tr>
									</thead>
									<tbody  id="item_table">
									<c:set var="srNo" scope="page" value="-1"></c:set>
										
									<c:forEach items="${sales.salesItemModel}" var="salesItemModel">
									<c:set var="srNo" value="${srNo+1}" scope="page"></c:set>
									 	<tr id="${srNo}" name="${salesItemModel.id}" style="cursor: pointer;"> 
							                <td class="sno text-center"></td>
						            		<td>
						            		<input type="hidden" name="salesItemModel[${srNo}].id" value="${salesItemModel.id}">
												<div class="form-group" style="margin-bottom: 0px;">
													<div class="m-input-icon m-input-icon--right">										
													<select class="form-control m-input product_id" onchange="calculation(${srNo})" name="salesItemModel[${srNo}].product.id" id="product_id${srNo}">
														<option value="0">select Product</option>
															<c:forEach items="${productList}" var="productList">
			                    					 		<c:choose>
			                    								<c:when test="${productList.id==salesItemModel.product.id}">
			                    									<option value="${productList.id}" selected="selected" >${productList.pname}</option>
			                    								</c:when>
			                    							<c:otherwise>
			                         							<option value="${productList.id}">${productList.pname}</option>
			                         						</c:otherwise>
	                    									</c:choose> 
	                    									</c:forEach>
														</select>
													</div>
												</div>
											</td>
											<%-- <td>
												<div class="form-group" style="margin-bottom: 0px;">
													<div class="m-input-icon m-input-icon--right">
														<input type="text" name="" id="avl_stock${srNo}" class="form-control m-input">
													</div>
												</div>
											</td> --%>
											<td>
												<div class="form-group" style="margin-bottom: 0px;">
													<div class="m-input-icon m-input-icon--right">
														<input type="text" class="form-control m-input" name="salesItemModel[${srNo}].quantity" id="quantity_id${srNo}" onkeyup="getTotal(${srNo})" class="form-control m-input quantity_id" value="${salesItemModel.quantity}">
													</div>
												</div>
											</td>
											<td>
												<div class="form-group" style="margin-bottom: 0px;">
													<div class="m-input-icon m-input-icon--right">
														<input type="text" name="salesItemModel[${srNo}].rate" id="rate_id${srNo}" onkeyup="getTotal(${srNo})" class="form-control m-input rate_id" value="${salesItemModel.rate}">
													</div>
												</div>
											</td>
											<td>
												<div class="form-group" style="margin-bottom: 0px;">
													<div class="m-input-icon m-input-icon--right">
														<input type="text" name="salesItemModel[${srNo}].total" id="total_id${srNo}" class="form-control m-input total_id" value="${salesItemModel.total}">
													</div>
												</div>
											</td>
											<td>
												<div class="form-group" style="margin-bottom: 0px;">
													<div class="m-input-icon m-input-icon--right">
														<a class="btn btn-danger delete-pro" data-remove="" ><i class="fa fa-trash-o"></i></a>
													</div>
												</div>
											</td>											
									</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
								
									<!-- model -->


									
									<div class="form-group m-form__group row">
										<div class="col-lg-2"></div>
										<div class="col-lg-2"></div>
										<div class="col-lg-2"></div>
										<div class="col-lg-2 col-form-label">
											<label style="padding-left: 60px;"> Grand Total: </label>
										</div>
										<div class="col-lg-2">
											<div class="m-input-icon m-input-icon--right">
												<input type="text" name="grandtotal" id="grandtotal_id" class="form-control m-input m-input--solid"	style="background-color: #E8F0FE;" readonly="readonly" value=${sales.grandtotal}>
											</div>
										</div>
										<div class="col-lg-2">
											<a class="btn btn-warning" id="btnrow"><i class="fa fa-plus"></i></a>
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
	

	    setSrNo();	
		setId('${srNo}');
		
	    

	    console.log("----------------------->>>>>");
	     
	    /* index */
	    

	    $(document).on('click','#btnrow',function(e) {
	    	

	    	 

	    	e.preventDefault();
	    	addProduct();
	    	

	    	});
///-------for delete product-----------
	    $("#purchase_form").on("click",'a[data-remove]',function(e) {
	
	console.log("hello");
	var r = confirm("are u sure want to delete");
	if(r==true){
		var id=$(this).closest("tr").attr("name");
		$("#delete_product").val($("#delete_product").val()+id+",");
	$(this).closest("tr").remove();
	  grandTotal();
	setProductSrNo();
	//setTotalQty();
	}
	});
	
	///----------

	    $("#save_purchase").click(function() 
	    	{
		    	var rowCount = $('#sales_Table >tbody >tr').length;
		    	if(rowCount == 0) 
		    	{
		    	toastr.error("","add minimum one product");
		    	return false;
		    	}else
		    	{

		    		return true;
		    	}
	    	});
	    	

	    

});
	/* function addProduct() {
	

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
	 */
	
	function setProductSrNo() 
	{
	var $productItem=$("#purchase_form").find("[data-item]").not(".m--hide");
	var i = 1;
	$productItem.each(function (){
	//$(this).find("[data-index]").html(++i));
	});
	}
	

	

	
	
	function grandTotal(){
				console.log("in grand total");
				var rowCount = $('#sales_Table >tbody >tr').length;
				
				console.log("raw "+rowCount);
				var Gtotal = 0;
				var arlene1 = new Array();
				var x=0;
			
				
			 for(var k=0;k<rowCount;k++)
				{
					console.log($("#total_id"+k).val());
					var total = $("#total_id"+k).val();
					Gtotal = parseFloat(Gtotal) + parseFloat(total);
				}
				console.log(Gtotal);
				 $("#grandtotal_id").val(Gtotal); 
	}
	
	
	
	function setId(i)
	{
		srno=i;
	}
	function setSrNo()
	{
		
		 $("td.sno").each(function(index,element){                 
	            $(element).text(index + 1);
	            
	         });
	}
	
	
	function calculation(j) {
		console.log(">>>>>- call calculation");
		$("#total_id"+j).val(0);
		$("#rate_id"+j).val(0);
		$("#quantity_id"+j).val(0);
			var id1 = $("#product_id"+j).val();
		console.log(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			
		$.get("/sales/findByIdproduct/"+id1,function (data, status) {  
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
	
	
	function getTotal(j){
		$("#total_id"+j).empty();
		$("#grandtotal_id").empty();
		  var q=$("#quantity_id"+j).val();
		  var p=$("#rate_id"+j).val();
		  $("#total_id"+j).val(q*p);
		  grandTotal();  
		
	}
		
	

    </script>

</body>


</html>