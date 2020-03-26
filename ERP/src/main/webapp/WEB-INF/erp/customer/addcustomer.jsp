<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
	<!-- begin::Head -->
	<head>
		<meta charset="utf-8" />
		<title>
			Friendly | Add Customer
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
												Add Customer
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
													Customer details
												</h3>
											</div>
										</div>
									</div>
									<!--begin::Form-->
									<form class="m-form m-form--fit m-form--label-align-right m-form--group-seperator-dashed" id="addcustomer" name="addcustomer" method="post" action="/addcustomer/save">
										<div class="m-portlet__body">
											<div class="form-group m-form__group row">
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
														
													</div>
													
												</div>
											</div>
											<div class="form-group m-form__group row">
												<div class="col-lg-4">
													<label>
														First Name:
													</label>
													<input type="text" name="cfname" id="cfname" class="form-control m-input" placeholder="Enter frist name">
													
												</div>
												<div class="col-lg-4">
													<label>
														Last Name:
													</label>
													
														<input type="text" name="clname" id="lname" class="form-control m-input" placeholder="Enter Last name" >
						
													
												</div>
												<div class="col-lg-4">
													<label class="">
														Email:
													</label>
													
													<input type="text" name="email" class="form-control m-input" placeholder="Enter your email">
													
												</div>
											</div>
											<div class="form-group m-form__group row">
												<div class="col-lg-4">
													<label class="">
														Contact:
													</label>
													<input type="text" name="contact" id="contact" class="form-control m-input" placeholder="Enter contact number">
													
												</div>
												<div class="col-lg-4" data-select2-id="80">
												<label class="" >
														County:
													</label>
												
															<select class="form-control m-select2"   name="country.id" id="country_id" >
															<option value="0">select Country</option>
															</select>													
												</div>
												<div class="col-lg-4">
													<label class="">
														State:
													</label>
															<select class="form-control m-select2" name="state.id" id="state_id" >
															   <option value="0">select State</option>
															   
															 </select>													
												</div>
												
											</div>
											<div class="form-group m-form__group row">
											    <div class="col-lg-4">
													<label class="">
														City:
													</label>
															<select class="form-control m-select2" name="city.id" id="city_id" >
															   <option value="0">select City</option>
															   
															 </select>													
												</div>
												<div class="col-lg-4">
													<label>
														Address:
													</label>
													<div class="m-input-icon m-input-icon--right">
														<input type="text" name="address" id="address" class="form-control m-input" placeholder="Enter your address">
														<span class="m-input-icon__icon m-input-icon__icon--right">
															<span>
																<i class="la la-map-marker"></i>
															</span>
														</span>
													</div>
													
												</div>
												
												<div class="col-lg-4">
													<label>
														Postcode:
													</label>
													<div class="m-input-icon m-input-icon--right">
														<input type="text" name="postcode" id="postcode" class="form-control m-input" placeholder="Enter your postcode">
														<span class="m-input-icon__icon m-input-icon__icon--right">
															<span>
																<i class="la la-map-marker"></i>
															</span>
														</span>
													</div>
													
												</div>
											</div>
											<div class="form-group m-form__group row">
												<div class="col-lg-4">
													<label class="">
														company:
													</label>
													<div class="m-input-icon m-input-icon--right">
														<input type="text" name="company" id="company" class="form-control m-input" placeholder="Enter your company name">
														<span class="m-input-icon__icon m-input-icon__icon--right">
															<span>
																<i class="la la-bookmark-o"></i>
															</span>
														</span>
													</div>
													
												</div>
												<div class="col-lg-4">
													<label class="">
														GST.No:
													</label>
													<div class="m-input-icon m-input-icon--right">
														<input type="text" name="gst_no" id="gst_no" class="form-control m-input" placeholder="Enter your GST number">
														<span class="m-input-icon__icon m-input-icon__icon--right">
															<span>
																<i class="la la-bookmark-o"></i>
															</span>
														</span>
													</div>
													
												</div>
					
											</div>
										</div>
										<div class="m-portlet__foot m-portlet__no-border m-portlet__foot--fit">
											<div class="m-form__actions m-form__actions--solid">
												<div class="row">
													<div class="col-lg-4"></div>
													<div class="col-lg-8">
														<input type="submit" value="Submit" id="saveaccount" class="btn btn-primary">
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
	
	$('#addcustomer').formValidation({

		 framework : 'bootstrap',
			live:'disabled',
			excluded : ":disabled",
			button:{

				selector : "#saveaccount",
				disabled : "disabled",
			},
				icon : null,
				fields: {
					cfname: {
						validators: {
                    notEmpty: {
                           message: 'The first name is required'
                       },
                       regexp: {
                           regexp: /^[a-zA-Z]+$/,
                           message: 'The name can only consist of alphabetical'
                      			}
                      		}
                      },
                      clname:{
                   	   validators:{
                     	 notEmpty: {
                       	    message: 'The last name is required'
                      				},
                       		regexp: {
                           		regexp: /^[a-zA-Z]+$/,
                          			 message: 'The name can only consist of alphabetical'
                       				}
                      			}
                      },
               email: {
               	validators: {
                   	 notEmpty: {
                       	    message: 'The email is required'
                      				},
                       emailAddress: {
                           message: 'The value is not a valid email address'
                       			}	
          						}
          				},
          	contact: {
               validators: {
                    notEmpty: {
                           message: 'The contact number is required'
                       },
              		  integer: {
                           message: 'The number is not valid.',
                        		},
                 stringLength: {
                       min: 10,
                       message: 'The number must be less than 10 characters long'
                   			},
                      		}
                      },

                      address: {
                   	   validators: {
                   	 notEmpty: {
                       	    message: 'The address is required'
                      				}	
          						}
          				},
          				
          				postcode:{
          					validators: {
                   	 notEmpty: {
                       	    message: 'The postcode is required'
                      				}	
          						}
          				}

          		},
	 });
	$.get("/country", function(data, status){
    	console.log(data);
    	$.each(data,function(i,o){
    		
    		$("#country_id").append('<option value='+o.id+'>'+o.country+'</option>');
    		
    	  });
    	
      });
	$("#country_id").change(function () {
		$("#state_id").empty();
		$("#city_id").empty();
        var id1 = $(this).val();
        
        $.get("/state/"+id1,  // url
			      function (data, status) {  
        	
        
        	$("#state_id").append('<option value="0">select State</option>');
        	var list1=data;
		      console.log(list1);
    		$.each(list1, function( i, o ) {
    			
    		console.log(o.id);
    		$("#state_id").append('<option value="'+o.id+'">'+o.state+'</option>');
    		                        
    		});
    		
				});
	});
	$("#state_id").change(function () {
		$("#city_id").empty();
        var id2 = $(this).val()
        console.log(id2);
        $.get("/city/"+id2,  // url
			      function (data, status) {  
        	console.log(data);
        
        	$("#city_id").append('<option value="0">select City</option>');
        	var list2=data;
		      
    		$.each(list2, function( i, o ) {
    		$("#city_id").append('<option value="'+o.id+'">'+o.city+'</option>');
    		                        
    		});
			      
				});
	});   
	
});

    </script>

</body>


</html>