<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
	<!-- begin::Head -->
	<head>
		<meta charset="utf-8" />
		<title>
			Friendly | Manage Cusromer
		</title>
		
		<jsp:include page="../topscript.jsp"></jsp:include>
	
	</head>
	<body class="m-page--fluid m--skin- m-content--skin-light2 m-header--fixed m-header--fixed-mobile m-aside-left--enabled m-aside-left--skin-dark m-aside-left--offcanvas m-footer--push m-aside--offcanvas-default">
		<!-- begin:: Page -->
		
			<jsp:include page="../header.jsp" /> 
		<!-- begin::Body -->
			<jsp:include page="../sidebar.jsp" /> 
				<div class="m-grid__item m-grid__item--fluid m-wrapper">
					<!-- BEGIN: Subheader -->
					<div class="m-subheader ">
						<div class="d-flex align-items-center">
							<div class="mr-auto">
								<h3 class="m-subheader__title m-subheader__title--separator">
									Customer
								</h3>
								<ul class="m-subheader__breadcrumbs m-nav m-nav--inline">
									<li class="m-nav__item m-nav__item--home">
										<a href="/index" class="m-nav__link m-nav__link--icon">
											<i class="m-nav__link-icon la la-home"></i>
										</a>
									</li>
									<li class="m-nav__separator">
										- Customer/
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
											Manage Customer
										</h3>
									</div>
								</div>
							<a target="_blank" class="m-btn btn btn-success" href="/report/pdf" style="margin-top: 15px">PDF</a>
							<a class="m-btn btn btn-warning" href="/report/xls" style="margin-top: 15px">XLS</a>
								
								<div class="m-portlet__head-tools">
									<ul class="m-portlet__nav">
										<li class="m-portlet__nav-item">
											<a href="/addcustomer" class="btn btn-primary m-btn m-btn--custom m-btn--icon m-btn--air">
												<span>
													<i class="m-menu__link-icon flaticon-users"></i>
													<span>
														Add Customer
													</span>
												</span>
											</a>
										</li>
									</ul>
								</div>
							</div>
							<div class="m-portlet__body">
							
								<!--begin: Datatable -->
								<table class="table table-striped- table-bordered table-hover table-checkable my_table_1" id="customer_table_1">
									<thead style="text-align: center;">
										<tr>
											
											<th>
												User-Type
											</th>
											<th>
												Firstname
											</th>
											
											<th>
												Email
											</th>
											<th>
												PhoneNumber
											</th>
											<th>
												Country
											</th>
											
											<th>
												State
											</th>
											<th>
												City
											</th>
											<th>
												Company
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
			
			
			<!-- end:: Body -->
            <!-- begin::Footer -->
			<jsp:include page="../footer.jsp"></jsp:include>
		
			<!-- end::Footer -->
			
	
		<jsp:include page="../basescript.jsp" />
	<!-- end::Body -->
  
	
	<script>
  
  $(document).ready(function()
			{
				console.log("document is ready...");
	   
	    
	    		/* DataTable */
				
	    		
	    		
				    var table = $('#customer_table_1').DataTable({
				    	//'scrollX': true,
				    	'stateSave': true,
				    	 'ajax' : {
				    		         
								    'contentType': 'application/json',
								        'url': '/customer/data',
								        'type': 'POST',
								   		'crossDomain':'true',
								   		'crossOrigin':'true',
								        'data': function(d) {
										 console.log(d);
											
								            return JSON.stringify(d);
								          }
								    },

								
				        'serverSide' : true,
				        
				        columns : 
						    [
						    	
						    {
							      data : 'cuser',
							}, 
							{
						          data : 'cfname'
						    },
							{
							      data : 'email'
							}, 
							{
							      data : 'contact'
							},
							{
							      data : 'country.country'
							}, 
							{
							      data : 'state.state'
							}, 
							{
							      data : 'city.city'
							}, 
							{
							      data : 'company'
							}, 
							
						     {
							      data : 'cid',
							      render: function (data, type, row) 
							      {
							        return '<div class="row" style="padding-left:10px;"><a href="/editcustomer/'+data+'" class="btn btn-warning edit" data-id="'+data+'"><i class="fa fa-pencil"></i></a>  <a class="btn btn-danger delete-pro" data-id="'+data+'"><i class="fa fa-trash-o"></i></a></div>';
							      } 
							} 
						    ]
						});
				
				//delete code
				
				$('body').on('click','.delete-pro',function(e){
					 toastr.remove();
					
					var id1 = null;
					
					 id1 = $(this).data("id");
					
					var r = confirm("are u sure want to delete");
					if(r==true)
						{
					$.ajax(
					   {
						type:"GET",
						url:"/customer/delete/"+id1,
						success: function(data){
							console.log(data);
							
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

									 toastr.success('press for undo <button type="button" class="btn btn-outline-light btn-sm m-btn m-btn--air m-btn--wide" style="margin-left:20%" data-id="'+id1+'" id="btn">undo</button>', "Undo");
									
									  $("#btn").on('click',function(){
										 
										 var id2 = $(this).data("id");
												   console.log(id2);
												    $.ajax(
												   {


												 type:"GET",
												 url:"/customer/undo/"+id2,
												 success: function(data){

													 
												 table.draw();
												
												console.log(id2);
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
</body>

</html>