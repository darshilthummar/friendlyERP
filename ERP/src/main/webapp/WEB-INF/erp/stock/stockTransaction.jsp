<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
	<!-- begin::Head -->
	<head>
		<meta charset="utf-8" />
		<title>
			Easy | Stock Transaction
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
									Stock Transaction
								</h3>
								<ul class="m-subheader__breadcrumbs m-nav m-nav--inline">
									<li class="m-nav__item m-nav__item--home">
										<a href="#" class="m-nav__link m-nav__link--icon">
											<i class="m-nav__link-icon la la-home"></i>
										</a>
									</li>
									<li class="m-nav__separator">
										- Transaction/
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
											Stock Transaction
										</h3>
									</div>
								</div>
								
							</div>
							<div class="m-portlet__body">
								<!--begin: Datatable -->
								<table class="table table-striped- table-bordered table-hover table-checkable my_table_1" id="sales_table_1" style="text-align: center;">
									<thead>
										<tr>
											
											<th>
												#
											</th>
											 <th>
												Product
											</th>
											
											<th>
												In Qty
											</th>
											<th>
												Out Qty
											</th>
											<th>
												Transaction Type
											</th>
											
											<th>
												Date
											</th>
										</tr>
									</thead>
									<tbody>
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
				
	    		
	    		
				    var table = $('#sales_table_1').DataTable({
				    	'scrollX': true,
				    	'stateSave': true,
				    	 'ajax' : {
				    		         
								    'contentType': 'application/json',
								        'url': 'stockTransaction/data',
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
								      data : 'id'
								      
							}, 
							{
									
									data:'product.pname',
									
									
							},
						    {
							      data : 'inqty',
							}, 
							{
						          data : 'outqty'
						    },
							{
							      data : 'type'
							}, 
							
							
						     {
							      data : 'transactionDate',
							     
							} 
						    ],
						    
						    columnDefs:[{
						    	targets: 0,
						    	orderable: !1,
						    	render: function(a, e, t, n){
						    		return (n.row+1);
						    	}
						    }],
								
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
						url:"delete/"+id1,
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

									 toastr.success('press for undo <button type="button" data-id="'+id1+'" id="btn">undo</button>', "Undo");
									
									  $("#btn").on('click',function(){
										 
										 var id2 = $(this).data("id");
												   console.log(id2);
												    $.ajax(
												   {


												 type:"GET",
												 url:"undo/"+id2,
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