<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
	<!-- begin::Head -->
	<head>
		<meta charset="utf-8" />
		<title>
			Friendly | ManageTax
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
									Tax
								</h3>
								<ul class="m-subheader__breadcrumbs m-nav m-nav--inline">
									<li class="m-nav__item m-nav__item--home">
										<a href="/index" class="m-nav__link m-nav__link--icon">
											<i class="m-nav__link-icon la la-home"></i>
										</a>
									</li>
									<li class="m-nav__separator">
										- Tax/
									</li>
									<li class="m-nav__item">
										<a href="" class="m-nav__link">
											<span class="m-nav__link-text">
												Manage Tax
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
										<div class="m-content">
						<div class="m-portlet m-portlet--mobile">
							<div class="m-portlet__head">
								<div class="m-portlet__head-caption">
									<div class="m-portlet__head-title">
										<h3 class="m-portlet__head-text">
											Manage Tax
										</h3>
									</div>
								</div>
								<div class="m-portlet__head-tools">
									<ul class="m-portlet__nav">
										<li class="m-portlet__nav-item">
											<button class="btn btn-primary m-btn m-btn--custom m-btn--icon m-btn--air" id="add_tax" data-toggle="modal" data-target="#m_modal_5">
												<span>
													<i class="m-menu__link-icon fa fa-tag"></i>
													<span>
														Add Tax
													</span>
												</span>
											</button>
										</li>
									</ul>
								</div>
							</div>
							<div class="m-portlet__body">
								<!--begin: Datatable -->
								<table class="table table-striped- table-bordered table-hover table-checkable my_table_1" id="tax_table">
									<thead style="text-align: center;">
										<tr>
											
											<th>
												Tax
											</th>
											<th>
												Tax Rate
											</th>
											
											<th>
												Action
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
					
					
					<!-- add model -->
					<div class="modal fade" id="m_modal_5" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" style="display: none;">
							<div class="modal-dialog modal-sm" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">
											Add Tax
										</h5>
										<button type="button" class="close" data-dismiss="modal" aria-label="Close">
											<span aria-hidden="true">
												×
											</span>
										</button>
									</div>
									<div class="modal-body">
										<form id="tax_data">
											<div class="form-group">
												<label for="recipient-name" class="form-control-label">
													Tax Name:
												</label>
												<div class="input-group">
												<input type="text" class="form-control" id="taxname" name="tax">
												</div>
												</div>
											<div class="form-group">
												<label for="recipient-name" class="form-control-label">
													Tax Rate:
												</label>
												<div class="input-group">
												<input type="text" class="form-control" id="taxRate" name="taxRate">
												<div class="input-group-append">
														<span class="input-group-text" id="basic-addon2">
															%
														</span>
													</div>
													</div>
											</div>
										</form>
										
									</div>
									<div class="modal-footer">
								    	<button type="button" class="btn btn-primary submit_button" id="submit_button" >Submit</button>

									</div>
								</div>
							</div>
						</div>
						
						<!-- edit model -->
						<div class="modal fade" id="m_modal_6" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" style="display: none;">
							<div class="modal-dialog modal-sm" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">
											Edit Tax
										</h5>
										<button type="button" class="close" data-dismiss="modal" aria-label="Close">
											<span aria-hidden="true">
												×
											</span>
										</button>
									</div>
									<div class="modal-body">
										<form id="tax_edit">
											<div class="form-group">
											<input type="hidden" class="form-control" id="taxid" name="id">
												<label for="recipient-name" class="form-control-label">
													Tax Name:
												</label>
											   
												<div class="input-group">
												<input type="text" class="form-control" id="tax_name" name="tax">
												</div>
												</div>
											<div class="form-group">
											
												<label for="recipient-name" class="form-control-label">
													Tax Rate:
												</label>
											   
												<div class="input-group">
												<input type="text" class="form-control" id="tax_Rate" name="taxRate">
												<div class="input-group-append">
														<span class="input-group-text" id="basic-addon2">
															%
														</span>
													</div>
													</div>
											</div>
										</form>
										
									</div>
									<div class="modal-footer">
								    	<button type="button" class="btn btn-primary edit_button" id="edit_button" data-dismiss="modal">Submit</button>

									</div>
								</div>
							</div>
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


</body>
<script type="text/javascript">
$(document).ready(function()
		{
	
	
	 $('#tax_data').formValidation({

		 framework : 'bootstrap',
			live:'disabled',
			excluded : ":disabled",
			button:{

				selector : ".submit_button",
				disabled : "disabled",
			},
				icon : null,
				fields: {
					tax: {
		                validators: {
		                    notEmpty: {
		                        message: 'Enter tax'
		                    }
		                }
		            }
                 }
	 });
	
	
	
	 var table = $('#tax_table').DataTable({
	    	//'scrollX': true,
	    	'stateSave': true,
	    	 'ajax' : {
	    		         
					    'contentType': 'application/json',
					        'url': '/tax/data',
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
				      data : 'tax',
				}, 
				{
				      data : 'taxRate',
				}, 
				
			     {
				      data : 'id',
				      render: function (data, type, row) 
				      {
				        return '<div class="row" style="margin-left:40%"><a class="btn btn-warning edit" id="edit_tax" data-toggle="modal" data-target="#m_modal_6" data-id="'+data+'"><i class="fa fa-pencil"></i></a>  <a class="btn btn-danger delete-pro" data-id="'+data+'"><i class="fa fa-trash-o"></i></a></div>';
				      } 
				} 
			    ]
			});
	
	 
$('#submit_button').on('click',function()
		{
	 if ($('#tax_data').data('formValidation').isValid() == null) {
			$('#tax_data').data('formValidation').validate();
		
	 }
	 if($('#tax_data').data('formValidation').isValid() == true) {
		var value = $("#tax_data").serialize();
			
			$.ajax(
			{
				type:"POST",
				url:"/addtax/save",
				data:value,
				success: function(data1)
				{
					
					 document.getElementById("tax_data").reset();
					 $('#m_modal_5').modal('toggle');
					 table.draw();
				}
			});
	 }
		});
		
		
		
		/* edit tax */
		
		$('body').on('click','.edit',function()
				{
					var sid = $(this).data("id");
					console.log(sid);
					$.ajax(
					{
						type:"GET",
						url :"/findbytax/"+sid,
						success:function(data3){
							console.log(data3);
							
							$("#taxid").val(data3.id);
							$('#tax_name').val(data3.tax);
							$("#tax_Rate").val(data3.taxRate);
							
						}
					});
				
				$('.edit_button').on('click',function()
						{
							var value = $("#tax_edit").serialize();
							$.ajax(
							{
								type:"POST",
								url:"/addtax/save",
								data:value,
								success: function(data1)
								{
									console.log(data1);
									 //$('#myModal1').modal('toggle');
									 document.getElementById("tax_edit").reset();
									 
									 
									  table.draw();
									 
								}
							});
							
						});	
				});
		
		/* delete tax */
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
						url:"/tax/delete/"+id1,
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
												 url:"/tax/undo/"+id2,
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

</html>