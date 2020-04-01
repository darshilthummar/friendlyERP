<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" >
	<!-- begin::Head -->
	<head>
		<meta charset="utf-8" />
		<title>
			Friendly ERP
		</title>
		<jsp:include page="topscript.jsp"></jsp:include>
		<style type="text/css">
		
		
		#demo2:hover {
		
    transform: scale(1.4);
   
}
		</style>
		</head>
	<!-- end::Head -->
  
	<body  class="m-page--fluid m--skin- m-content--skin-light2 m-header--fixed m-header--fixed-mobile m-aside-left--enabled m-aside-left--skin-dark m-aside-left--offcanvas m-footer--push m-aside--offcanvas-default"  >
		<!-- begin:: Page -->
		
		<!--header-->
		
		<jsp:include page="header.jsp" /> 
		
		
		
		 <jsp:include page="sidebar.jsp" /> 
		
					
		<!-- begin::Body -->
			
				
				<div class="m-grid__item m-grid__item--fluid m-wrapper">
					<!-- BEGIN: Subheader -->
					<div class="m-subheader ">
						<div class="d-flex align-items-center">
							<div class="mr-auto">
								<h3 class="m-subheader__title ">
									Dashboard
								</h3>
							</div>
							<div>
								<span class="m-subheader__daterange" id="m_dashboard_daterangepicker">
									<span class="m-subheader__daterange-label">
										<span class="m-subheader__daterange-title"></span>
										<span class="m-subheader__daterange-date m--font-brand"></span>
									</span>
									<a href="#" class="btn btn-sm btn-brand m-btn m-btn--icon m-btn--icon-only m-btn--custom m-btn--pill">
										<i class="la la-angle-down"></i>
									</a>
								</span>
							</div>
						</div>
					</div>
					<!-- END: Subheader -->
					<div class="m-content">
						<!--Begin::Section-->
						<!--End::Section-->
<!--Begin::Section-->
						<div class="m-portlet">
							<div class="m-portlet__body  m-portlet__body--no-padding">
								<div class="row m-row--no-padding m-row--col-separator-xl">
									<div class="col-md-12 col-lg-6 col-xl-4">
										<!--begin::Total Profit-->
										<div class="m-widget24">
											<div class="m-widget24__item">
												<br><br>
												
												
												<span style="padding-top: -10px;padding-left: 33%;"><img alt="" height="100px" width="100px" src="/assets/app/media/img/client-logos/51fed8e3-b4fa-4298-91c8-2796bfc39632_200x200.png" id="demo2">
												<span class="m-widget24__stats m--font-info" id="countCustomer">
													${totalCustomer}
												</span>
												<div class="progress m-progress--sm" style="margin: 10px 0px 5px 0px;" >
													<div class="progress-bar m--bg-info" role="progressbar" style="width: 100%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
												</div>
													<p style="text-align: center;">Total Customers</p>
												 
												
												</span>
																							</div>
										</div>
										<!--end::Total Profit-->
									</div>
									<div class="col-md-12 col-lg-6 col-xl-4">
										<!--begin::New Orders-->
										<div class="m-widget24">
											<div class="m-widget24__item">
												<br><br>
												
												
												<span style="padding-top: -10px;padding-left: 33%;"><a href="/managecustomer" ><img alt="" height="100px" width="100px" src="/assets/app/media/img/client-logos/5b1d6251-43b2-4201-9503-e3150debbdac_200x200.png" id="demo2"></a>
												<span class="m-widget24__stats m--font-brand"id="countSupplier">
													${totalSupplier}
												</span>
												<div class="progress m-progress--sm" style="margin: 10px 0px 5px 0px;">
													<div class="progress-bar m--bg-brand" role="progressbar" style="width: 100%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
												</div>
													<p style="text-align: center;">Total Supplier</p>
												 
												
												</span>
																							</div>
										</div>
										<!--end::New Orders-->
									</div>
									<div class="col-md-12 col-lg-6 col-xl-4">
										<!--begin::New Users-->
										<div class="m-widget24">
											<div class="m-widget24__item">
												<br><br>
												
												
												<span style="padding-top: -10px;padding-left: 33%;"><img alt="" height="100px" width="100px" src="/assets/app/media/img/client-logos/productLogo.png" id="demo2">
												<span class="m-widget24__stats" style="color: #e61717;">
													${totalProduct}
												</span>
												<div class="progress m-progress--sm" style="margin: 10px 0px 5px 0px;">
													<div class="" role="progressbar" style="width: 100%;background-color:#e61717;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
												</div>
													<p style="text-align: center;">Total Product</p>
												 
												
												</span>
																							</div>
										</div>
										<!--end::New Users-->
									</div>
									
									
									</div>
									<div class="row m-row--no-padding m-row--col-separator-xl">
									<div class="col-md-12 col-lg-6 col-xl-4">
										<!--begin::New Users-->
										<div class="m-widget24">
											<div class="m-widget24__item">
												<br><br>
												
												
												<span style="padding-top: -10px;padding-left: 33%;"><img alt="" height="100px" width="100px" src="/assets/app/media/img/client-logos/StockLogo.png" id="demo2">
												<span class="m-widget24__stats" style="color: #0e29b0">
													${totalStock}
												</span>
												<div class="progress m-progress--sm" style="margin: 10px 0px 5px 0px;">
													<div class="progress-bar" role="progressbar" style="width: 100%; background-color: #0e29b0;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
												</div>
													<p style="text-align: center;">Total Stock</p>
												 
												
												</span>
																							</div>
										</div>
										<!--end::New Users-->
									</div>
									<div class="col-md-12 col-lg-6 col-xl-4">
										<!--begin::New Feedbacks-->
										<div class="m-widget24">
											<div class="m-widget24__item">
												<br><br>
												
												
												<span style="padding-top: -10px;padding-left: 33%;"><img alt="" height="100px" width="100px" src="/assets/app/media/img/client-logos/purchaseLogo.png" id="demo2">
												<span class="m-widget24__stats" style="color: #91411f;">
													${totalPurchase}
												</span>
												
												<div class="progress m-progress--sm" style="margin: 10px 0px 5px 0px;">
													<div class="progress-bar " role="progressbar" style="width: 100%;background-color: #91411f" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
												</div>
													<p style="text-align: center;">Total Purchase</p>
												 
												
												</span>
																							</div>
										</div>
										<!--end::New Feedbacks-->
									</div>
									<div class="col-md-12 col-lg-6 col-xl-4">
										<!--begin::New Feedbacks-->
										<div class="m-widget24">
											<div class="m-widget24__item">
												<br><br>
												
												
												<span style="padding-top: -10px;padding-left: 33%;"><img alt="" height="100px" width="100px" src="/assets/app/media/img/client-logos/aaf3f9d6-967c-4b6e-8fea-a7eeaa6d9343_200x200.png" id="demo2">
												<span class="m-widget24__stats m--font-success">
													${totalSales}
												</span>
												
												<div class="progress m-progress--sm" style="margin: 10px 0px 5px 0px;">
													<div class="progress-bar m--bg-success" role="progressbar" style="width: 100%;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
												</div>
													<p style="text-align: center;">Total Sales</p>
												 
												
												</span>
																							</div>
										</div>
										<!--end::New Feedbacks-->
									</div>
									
								</div>
								<div class="row m-row--no-padding m-row--col-separator-xl">
								<div class="col-md-12 col-lg-6 col-xl-4">
										<!--begin::New Users-->
										<div class="m-widget24">
											<div class="m-widget24__item">
												<br><br>
												
												
												<span style="padding-top: -10px;padding-left: 33%;"><img alt="" height="100px" width="100px" src="/assets/app/media/img/client-logos/CaseInHandLogo.png" id="demo2">
												<span class="m-widget24__stats " style="color: #51a629">
													${CaseInHand}
												</span>
												<div class="progress m-progress--sm" style="margin: 10px 0px 5px 0px;">
													<div class="progress-bar " role="progressbar" style="width: 100%;background-color: #51a629;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
												</div>
													<p style="text-align: center;">Case In Hand </p>
												 
												
												</span>
																							</div>
										</div>
										<!--end::New Users-->
									</div>
									<div class="col-md-12 col-lg-6 col-xl-4">
										<!--begin::New Users-->
										<div class="m-widget24">
											<div class="m-widget24__item">
												<br><br>
												
												
												<span style="padding-top: -10px;padding-left: 33%;"><img alt="" height="100px" width="100px" src="/assets/app/media/img/client-logos/BankLogo.png" id="demo2">
												<span class="m-widget24__stats " style="color: #044275;">
													${CaseInBank}
												</span>
												<div class="progress m-progress--sm" style="margin: 10px 0px 5px 0px;">
													<div class="progress-bar " role="progressbar" style="width: 100%; background-color: #044275;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
												</div>
													<p style="text-align: center;">Case In Bank </p>
												 
												
												</span>
																							</div>
										</div>
										<!--end::New Users-->
									</div>
									<div class="col-md-12 col-lg-6 col-xl-4">
										<!--begin::New Users-->
										<div class="m-widget24">
											<div class="m-widget24__item">
												<br><br>
												
												
												<span style="padding-top: -10px;padding-left: 33%;"><img alt="" height="100px" width="100px" src="/assets/app/media/img/client-logos/ProfitLogo.png" id="demo2">
												<span class="m-widget24__stats " style="color: #b03f3f;">
													$$
												</span>
												<div class="progress m-progress--sm" style="margin: 10px 0px 5px 0px;">
													<div class="progress-bar " role="progressbar" style="width: 100%; background-color: #b03f3f;" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100"></div>
												</div>
													<p style="text-align: center;">Profit</p>
												 
												
												</span>
																							</div>
										</div>
										<!--end::New Users-->
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- end:: Body -->
<!-- begin::Footer -->
			<footer class="m-grid__item		m-footer ">
				<div class="m-container m-container--fluid m-container--full-height m-page__container">
					<div class="m-stack m-stack--flex-tablet-and-mobile m-stack--ver m-stack--desktop">
						<div class="m-stack__item m-stack__item--left m-stack__item--middle m-stack__item--last">
							<span class="m-footer__copyright">
								2020 &copy; FriendlyERP
							</span>
						</div>
						<div class="m-stack__item m-stack__item--right m-stack__item--middle m-stack__item--first">
							<ul class="m-footer__nav m-nav m-nav--inline m--pull-right">
								<li class="m-nav__item">
									<a href="#" class="m-nav__link">
										<span class="m-nav__link-text">
											About
										</span>
									</a>
								</li>
								<li class="m-nav__item">
									<a href="#"  class="m-nav__link">
										<span class="m-nav__link-text">
											Privacy
										</span>
									</a>
								</li>
								<li class="m-nav__item">
									<a href="#" class="m-nav__link">
										<span class="m-nav__link-text">
											T&C
										</span>
									</a>
								</li>
								<li class="m-nav__item">
									<a href="#" class="m-nav__link">
										<span class="m-nav__link-text">
											Purchase
										</span>
									</a>
								</li>
								<li class="m-nav__item m-nav__item">
									<a href="#" class="m-nav__link" data-toggle="m-tooltip" title="Support Center" data-placement="left">
										<i class="m-nav__link-icon flaticon-info m--icon-font-size-lg3"></i>
									</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</footer>
			<!-- end::Footer -->
		
		<!-- end:: Page -->
	    <!-- begin::Scroll Top -->
		<div id="m_scroll_top" class="m-scroll-top">
			<i class="la la-arrow-up"></i>
		</div>
		<!-- end::Scroll Top -->		    
    	<!--begin::Base Scripts -->
		<script src="assets/vendors/base/vendors.bundle.js" type="text/javascript"></script>
		<script src="assets/demo/default/base/scripts.bundle.js" type="text/javascript"></script>
		<!--end::Base Scripts -->   
        <!--begin::Page Vendors -->
		<script src="assets/vendors/custom/fullcalendar/fullcalendar.bundle.js" type="text/javascript"></script>
		<!--end::Page Vendors -->  
        <!--begin::Page Snippets -->
		<script src="assets/app/js/dashboard.js" type="text/javascript"></script>
		<!--end::Page Snippets -->
	
	<script>
	$("#dashboard").addClass("m-menu__item--active");
	
	$( document ).ready(function() {
	    console.log( "ready!" );
	    
	    $.ajax(
				   {
					type:"GET",
					url:"/count/customer",
					success: function(data){
						console.log(data);
						$("#countCustomer").html(data);
					}
						   
					});
	    $.ajax(
				   {
					type:"GET",
					url:"/count/supplier",
					success: function(data){
						console.log(data);
						$("#countSupplier").html(data);
					}
						   
					});
	    
	      
		    $.get("/userdata",  // url
				      function (data, status) {  
		  	console.log(data);
		  	 $("#user").html(data.username);
		  	 $("#user_email").html(data.email);
			});
		
	
	    
	});
	</script>
	
	</body>
	<!-- end::Body -->
	
</html>
