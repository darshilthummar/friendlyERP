<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
<!-- begin::Head -->
<head>
<meta charset="utf-8" />
<title>
Friendly | Manage Purchase
</title>
<jsp:include page="../topscript.jsp"></jsp:include>
</head>
<body class="m-page--fluid m--skin- m-content--skin-light2 m-header--fixed m-header--fixed-mobile m-aside-left--enabled m-aside-left--skin-dark m-aside-left--offcanvas m-footer--push m-aside--offcanvas-default">
<!-- begin:: Page -->
<div class="m-grid m-grid--hor m-grid--root m-page">
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
												DataTable
											</span>
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
					<!-- END: Subheader -->
<div class="m-content">
<div class="m-portlet m-portlet--mobile">
<div class="m-portlet__head">
<div class="m-portlet__head-caption">
<div class="m-portlet__head-title">
<h3 class="m-portlet__head-text">
Manage purchase
</h3>
</div>
</div>
<div class="m-portlet__head-tools">
<ul class="m-portlet__nav">
<li class="m-portlet__nav-item">
<a href="/addpurchase" class="btn btn-primary m-btn m-btn--custom m-btn--icon m-btn--air">
<span>
<i class="m-menu__link-icon fa fa-shopping-cart"></i>
<span>
Add Purchase
</span>
</span>
</a>
</li>
</ul>
</div>
</div>
<div class="m-portlet__body">
<!--begin: Datatable -->
<table class="table table-striped- table-bordered table-hover table-checkable my_table_1" id="purchase_table">
<thead style="text-align: center;">
<tr>
<th>
Invoice No.
</th>
<th>
Supplier
</th>

<th>
Date
</th>
<th>
Product
</th>
<th>
Quantity
</th>
<th>
Total price
</th>
<th>
Actions
</th>
</tr>
</thead>
<tbody style="text-align: center;">
</tbody>
</table>
</div>
</div>
<!-- END EXAMPLE TABLE PORTLET-->
</div>
</div>
</div>
<!-- end:: Body -->
<!-- begin::Footer -->
<jsp:include page="../footer.jsp"></jsp:include>

<!-- end::Footer -->

<!-- end:: Page -->	   
     <jsp:include page="../basescript.jsp" />
<script type="text/javascript"> 
$(document).ready(function()
{
console.log("Doc is Ready........");

var table = $('#purchase_table').DataTable(
{
   'ajax' : {
   	'contentType': 'application/json',
       'url': '/purchase/data',
       'type': 'POST',
       
       'data': function(d) {
           return JSON.stringify(d);
         }
   },
   'serverSide' : true,
   columns :  
   [
	   {
		     data : 'purchaseModel.invoiceno'
		     
		   }, 
   {
     data : 'purchaseModel.supplier.cfname'
     
   }, 
   {
     data : 'purchaseModel.date'
   },
   {
	     data : 'product.pname'
	   },
   {
   	data : 'quantity'
   },
   {
   	data : 'total'
   },
   {
     data : 'id',
     render: function (data, type, row) 
     {
	        return '<div class="row" style="padding-left:30%;"><a href="/editpurchase/'+data+'" class="btn btn-warning edit" id="demo" data-id="'+data+'"><i class="fa fa-pencil"></i></a>  <button class="btn btn-danger delete-pro" data-id="'+data+'"><i class="fa fa-trash-o"></i></button></div>';
     }
}
  
]
 });

// for delete----------------------------------------------

/* $('body').on('click', '.delete-user', function () 
{
       var id = $(this).data("id");
       confirm("Are You sure want to delete !");

       $.ajax(
       {
           type: "GET",
           url: "/product/delete/"+id,
           success: function (data) 
           {
               //$("#user_id_" + user_id).remove();
var table = $('#product_table').DataTable();
table.row('.selected').remove().draw( false );
               
           },
           error: function (data) {
               console.log('Error:', data);
           }
       });
   }); */
   
$('body').on('click','.delete-pro',function(e){
	toastr.remove();
var id1 = $(this).data("id");

var r = confirm("are u sure want to delete");
if(r==true)
{
$.ajax(
  {
type:"GET",
url:"/purchase/delete/"+id1,
success: function(data){
/* $("#user_id_"+id).remove();	*/
console.log(data);
//console.log(table.row($("this").parent('tr')).remove().draw());
// myFunction();

  table.draw();
  toastr.options = {
			 
		   "tapToDismiss": true,
		   "closeButton": false,
		   "debug": false,
		   "newestOnTop": true,
		   "progressBar": false,
		   "positionClass": "toast-bottom-center",
		   "preventDuplicates": true,
		   "showDuration": "300",
		   "hideDuration": "1000",
		   "timeOut": "5000",
		   "extendedTimeOut": "1000",
		   "showEasing": "swing",
		   "hideEasing": "linear",
		   "showMethod": "fadeIn",
		   "hideMethod": "fadeOut"
		 };

		 toastr.success('press for undo <button type="button" class="btn btn-outline-light btn-sm m-btn m-btn--air m-btn--wide" style="margin-left:20%" data-id="'+id1+'" id="btn">Yes</button>', "Undo");
		
		  $("#btn").on('click',function(){
			 
			 var id2 = $(this).data("id");
					 
					    $.ajax(
					   {


					 type:"GET",
					 url:"/purchase/undo/"+id2,
					 success: function(data){

						 
					 table.draw();
					
					
					 },


					   error: function (data) {
					                  console.log('Error:', data);
					              }


					 });
					    

					
		 });  


},
  error: function (data) {
                 console.log('Error:', data);
             }
  });
}
e.preventDefault();
});

  

});


</script>

<!-- end::Body -->

</body>

</html>