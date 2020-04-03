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
									My Profile
								</h3>
							</div>
						</div>
					</div>
					<!-- END: Subheader -->
					<div class="m-content">
						<div class="row">
							<div class="col-xl-3 col-lg-4">
								<div class="m-portlet m-portlet--full-height  ">
									<div class="m-portlet__body">
										<div class="m-card-profile">
											<div class="m-card-profile__title m--hide">
												Your Profile
											</div>
											<div class="m-card-profile__pic">
												<div class="m-card-profile__pic-wrapper">
													<img src="/assets/app/media/img/users/${user.img}" />
												</div>
											</div>
											<div class="m-card-profile__details">
												<span class="m-card-profile__name">
												${user.username}
												</span>
												<a class="m-card-profile__email m-link">
												${user.email}
												</a>
											</div>
										</div>
										<ul class="m-nav m-nav--hover-bg m-portlet-fit--sides">
											<li class="m-nav__separator m-nav__separator--fit"></li>
											<li class="m-nav__section m--hide">
												<span class="m-nav__section-text">
													Section
												</span>
											</li>
											<li class="m-nav__item">
												<a href="/profile" class="m-nav__link">
													<i class="m-nav__link-icon flaticon-profile-1"></i>
													<span class="m-nav__link-title">
														<span class="m-nav__link-wrap">
															<span class="m-nav__link-text">
																My Profile
															</span>
															
														</span>
													</span>
												</a>
											</li>
											<li class="m-nav__item">
												<a href="../header/profile&amp;demo=default.html" class="m-nav__link">
													<i class="m-nav__link-icon flaticon-share"></i>
													<span class="m-nav__link-text">
														Activity
													</span>
												</a>
											</li>
											<li class="m-nav__item">
												<a class="m-nav__link" data-toggle="modal" data-target="#m_modal_5">
													<i class="m-nav__link-icon flaticon-lock-1"></i>
													<span class="m-nav__link-text">
														Change Password
													</span>
												</a>
											</li>
											<li class="m-nav__item">
												<a href="../header/profile&amp;demo=default.html" class="m-nav__link">
													<i class="m-nav__link-icon flaticon-lifebuoy"></i>
													<span class="m-nav__link-text">
														Support
													</span>
												</a>
											</li>
										</ul>
										<div class="m-portlet__body-separator"></div>
									</div>
								</div>
							</div>
							<div class="col-xl-9 col-lg-8">
								<div class="m-portlet m-portlet--full-height m-portlet--tabs  ">
									<div class="m-portlet__head">
										<div class="m-portlet__head-tools">
											<ul class="nav nav-tabs m-tabs m-tabs-line   m-tabs-line--left m-tabs-line--primary" role="tablist">
												<li class="nav-item m-tabs__item">
													<a class="nav-link m-tabs__link active" data-toggle="tab"  role="tab">
														<i class="flaticon-share m--hide"></i>
														Update Profile
													</a>
												</li>
											</ul>
										</div>
									</div>
									<div class="tab-content">
										<div class="tab-pane active" id="m_user_profile_tab_1">
											<form class="m-form m-form--fit m-form--label-align-right" action="/profile/update" method="post">
											<input type="hidden" name="id" id="id" class="form-control m-input" value="${user.id}">	
												<div class="m-portlet__body">
													<div class="form-group m-form__group m--margin-top-10 m--hide">
														<div class="alert m-alert m-alert--default" role="alert">
															The example form below demonstrates common HTML form elements that receive updated styles from Bootstrap with additional classes.
														</div>
													</div>
													<div class="form-group m-form__group row">
														<div class="col-10 ml-auto">
															<h3 class="m-form__section">
																1. Personal Details
															</h3>
														</div>
													</div>
													<div class="form-group m-form__group row">
														<label for="example-text-input" class="col-2 col-form-label">
															First Name
														</label>
														<div class="col-sm-3">
															<input class="form-control m-input" type="text" name="fname" value="${user.fname}">
														</div>
														<label for="example-text-input" class="col-2 col-form-label">
															Last Name
														</label>
														<div class="col-sm-3">
															<input class="form-control m-input" type="text" name="lname" value="${user.lname}">
														</div>
													</div>
													<div class="form-group m-form__group row">
														<label for="example-text-input" class="col-2 col-form-label">
															Position
														</label>
														<div class="col-8">
															<input class="form-control m-input" type="text" name="position" value="${user.position}">
														</div>
													</div>
													<div class="form-group m-form__group row">
														<label for="example-text-input" class="col-2 col-form-label">
															Company Name
														</label>
														<div class="col-8">
															<input class="form-control m-input" type="text" name="company" value="${user.company}">
														</div>
													</div>
													<div class="form-group m-form__group row">
														<label for="example-text-input" class="col-2 col-form-label">
															Phone No.
														</label>
														<div class="col-8">
															<input class="form-control m-input" type="text" name="number" value="${user.number}">
														</div>
													</div>
													<div class="form-group m-form__group row">
														<label for="example-text-input" class="col-2 col-form-label">
															GST.No
														</label>
														<div class="col-8">
															<input class="form-control m-input" type="text" name="gst_no" value="${user.gst_no}">
														</div>
													</div>
													
													<div class="m-form__seperator m-form__seperator--dashed m-form__seperator--space-2x"></div>
													<div class="form-group m-form__group row">
														<div class="col-10 ml-auto">
															<h3 class="m-form__section">
																2. Address
															</h3>
														</div>
													</div>
													<div class="form-group m-form__group row">
														<label for="example-text-input" class="col-2 col-form-label">
															Address
														</label>
														<div class="col-8">
															<input class="form-control m-input" type="text" name="address" value="${user.address}">
														</div>
													</div>
													<div class="form-group m-form__group row">
														<label for="example-text-input" class="col-2 col-form-label">
															State
														</label>
														<div class="col-8">
															<input class="form-control m-input" type="text" name="state" value="${user.state}">
														</div>
													</div>
													<div class="form-group m-form__group row">
														<label for="example-text-input" class="col-2 col-form-label">
															City
														</label>
														<div class="col-8">
															<input class="form-control m-input" type="text" name="city" value="${user.city}">
														</div>
													</div>
													<div class="form-group m-form__group row">
														<label for="example-text-input" class="col-2 col-form-label">
															Postcode
														</label>
														<div class="col-8">
															<input class="form-control m-input" type="text" name="postcode" value="${user.postcode}">
														</div>
													</div>
												</div>
												<div class="m-form__seperator m-form__seperator--dashed m-form__seperator--space-2x"></div>
												<%--  <div class="form-group m-form__group row">
														<label for="example-text-input" class="col-2 col-form-label">
															Profile Upload
														</label>
														<div class="col-8">
															<input class="form-control m-input" type="file" name="img" value="${user.img}" >
														</div>
													</div> --%>
												<div class="m-portlet__foot m-portlet__foot--fit">
													<div class="m-form__actions">
														<div class="row">
															<div class="col-2">
															</div>
															<div class="col-7">
																<button type="submit" class="btn btn-accent m-btn m-btn--air m-btn--custom">
																	Save Profile
																</button>
																&nbsp;&nbsp;
																<!--  <button type="file" class="btn btn-secondary m-btn m-btn--air m-btn--custom">
																	Reset
																</button>  -->
															</div>
														</div>
													</div>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
			<!-- Edit model -->
					<div class="modal fade" id="m_modal_5" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true" style="display: none;">
							<div class="modal-dialog modal-sm" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">
											Change Password
										</h5>
										<button type="button" class="close" data-dismiss="modal" aria-label="Close">
											<span aria-hidden="true">
												×
											</span>
										</button>
									</div>
									<div class="modal-body">
										<form id="change_pass">
										<input type="hidden" class="form-control" id="id" name="id" value="${user.id}">
											<div class="form-group">
												<label for="recipient-name" class="form-control-label">
													Password:
												</label>
												<div class="input-group">
												<input type="password" class="form-control"  name="password">
												</div>
											</div>
											<div class="form-group">
												<label for="recipient-name" class="form-control-label">
													Confirm Password:
												</label>
												<div class="input-group">
												<input type="password" class="form-control" name="rpassword">
												</div>
											</div>
										</form>
										
									</div>
									<div class="modal-footer">
								    	<button type="button" class="btn btn-primary submit_button" id="submit_button" data-dismiss="modal">Submit</button>

									</div>
								</div>
							</div>
						</div>
						
			<!-- end:: Body -->
<!-- begin::Footer -->
				<jsp:include page="footer.jsp"></jsp:include>
<!-- end::Footer -->
		
		<!-- end:: Page -->
	    <!-- begin::Scroll Top -->
		<jsp:include page="basescript.jsp" />
		
	
<script type="text/javascript">
		$(document).ready(function(){
			console.log("READY");
			
			$('#submit_button').on('click',function()
					{
						var value = $("#change_pass").serialize();
						
						$.ajax(
						{
							type:"POST",
							url:"/save",
							data:value,
							success: function(data1)
							{
								console.log(data1);
							
							}
						});
						
					});	
			});
		
		</script>
	
	</body>
	<!-- end::Body -->
	
</html>
