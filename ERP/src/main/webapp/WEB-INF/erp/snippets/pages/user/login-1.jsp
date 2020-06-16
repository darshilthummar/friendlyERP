<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!-- 
Template Name: Metronic - Responsive Admin Dashboard Template build with Twitter Bootstrap 4
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Dribbble: www.dribbble.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
Renew Support: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
License: You must have a valid license purchased only from themeforest(the above link) in order to legally use the theme for your project.
-->
<html lang="en" >
	<!-- begin::Head -->
	<head>
		<meta charset="utf-8" />
		<title>
			FriendlyERP | Login Page
		</title>
		<jsp:include page="../../../topscript.jsp"></jsp:include>
	</head>
	<!-- end::Head -->
    <!-- end::Body -->
	<body  class="m--skin- m-header--fixed m-header--fixed-mobile m-aside-left--enabled m-aside-left--skin-dark m-aside-left--offcanvas m-footer--push m-aside--offcanvas-default"  >
		<!-- begin:: Page -->
		<div class="m-grid m-grid--hor m-grid--root m-page">
			<div class="m-grid__item m-grid__item--fluid m-grid m-grid--ver-desktop m-grid--desktop m-grid--tablet-and-mobile m-grid--hor-tablet-and-mobile m-login m-login--1 m-login--signin" id="m_login">
				<div class="m-grid__item m-grid__item--order-tablet-and-mobile-2 m-login__aside">
					<div class="m-stack m-stack--hor m-stack--desktop">
						<div class="m-stack__item m-stack__item--fluid">
							<div class="m-login__wrapper" style="padding: 18% 2rem 2rem 2rem">
								<div class="m-login__logo">
									
								</div>
								<!-- SIGN IN -->
								
								<div class="m-login__signin">
									<div class="m-login__head">
										<h3 class="m-login__title">
											Sign In
										</h3>
									</div>
									<form class="m-login__form m-form"  action="/login" method="post" id="signin">
										<div class="form-group m-form__group">
											<input class="form-control m-input" type="text" placeholder="Username" name="username"  id="login_email" autocomplete="off">
										</div>
										<div class="form-group m-form__group">
											<input class="form-control m-input m-login__form-input--last" type="password" id="login_password" placeholder="Password" name="password">
										</div>
										<div class="form-group m-form__group">
										<c:if test="${param.error ne null}">
											<div class="m--font-danger">Invalid username and password.</div>
										</c:if>
										<c:if test="${param.logout ne null}">
											<div class="m--font-success">You have been logged out.</div>
										</c:if>
										</div>
										<div class="row m-login__form-sub">
											<div class="col m--align-left">
												<label class="m-checkbox m-checkbox--focus">
													<input type="checkbox" name="remember">
													Remember me
													<span></span>
												</label>
											</div>
											<div class="col m--align-right">
												<a href="javascript:;" id="m_login_forget_password" class="m-link">
													Forget Password ?
												</a>
											</div>
										</div>
										<div class="m-login__form-action">
											<button type="submit" id="m_login_signin_submit" class="btn btn-focus m-btn m-btn--pill m-btn--custom m-btn--air">
												Sign In
											</button>
										</div>
									</form>
								</div>
							
								<!-- END SINGN IN -->	
							
							
								<!-- CREATE NEW ACCOUNT -->
								<div class="m-login__signup">
									<div class="m-login__head">
										<h3 class="m-login__title">
											Sign Up
										</h3>
										<div class="m-login__desc">
											Enter your details to create your account:
										</div>
									</div>
									<form class="m-login__form m-form" id="creat_acc">
										<div class="form-group m-form__group">
											<input class="form-control m-input" type="text" placeholder="Username" name="username">
										</div>
										<div class="form-group m-form__group">
											<input class="form-control m-input" type="text" placeholder="Email" id="email1" name="email" autocomplete="off">
										</div>
										<div class="form-group m-form__group">
											<input class="form-control m-input" type="password" placeholder="Password" id="password" name="password">
										</div>
										
										<div class="form-group m-form__group">
											<input class="form-control m-input m-login__form-input--last" type="password" id="rpassword" placeholder="Confirm Password" name="rpassword">
										</div>
										<div class="row form-group m-form__group m-login__form-sub">
											<div class="col m--align-left">
												<label class="m-checkbox m-checkbox--focus">
													<input type="checkbox" name="agree">
													I Agree the
													<a href="#" class="m-link m-link--focus">
														terms and conditions
													</a>
													.
													<span></span>
												</label>
												<span class="m-form__help"></span>
											</div>
										</div>
										<div class="m-login__form-action">
											<button type="submit" id="m_login_signup_submit" class="btn btn-focus m-btn m-btn--pill m-btn--custom m-btn--air">
												Sign Up
											</button>
											<button id="m_login_signup_cancel" class="btn btn-outline-focus  m-btn m-btn--pill m-btn--custom">
												Cancel
											</button>
										</div>
									</form>
								</div>
								<!-- END CREAT NEW ACCOUNT  -->
								
								<!-- FORGET PASSWORD -->
								<div class="m-login__forget-password">
									<div class="m-login__head">
										<h3 class="m-login__title">
											Forgotten Password ?
										</h3>
										<div class="m-login__desc">
											Enter your email to reset your password:
										</div>
									</div>
									<form class="m-login__form m-form" action="">
										<div class="form-group m-form__group">
											<input class="form-control m-input" type="text" placeholder="Email" name="email" id="m_email" autocomplete="off">
										</div>
										<div class="m-login__form-action">
											<button id="m_login_forget_password_submit" class="btn btn-focus m-btn m-btn--pill m-btn--custom m-btn--air">
												Request
											</button>
											<button id="m_login_forget_password_cancel" class="btn btn-outline-focus m-btn m-btn--pill m-btn--custom">
												Cancel
											</button>
										</div>
									</form>
								</div>
							</div>
						</div>
						<div class="m-stack__item m-stack__item--center">
							<div class="m-login__account">
								<span class="m-login__account-msg">
									Don't have an account yet ?
								</span>
								&nbsp;&nbsp;
								<a href="javascript:;" id="m_login_signup" class="m-link m-link--focus m-login__account-link">
									Sign Up
								</a>
							</div>
						</div>
					</div>
				</div>
				
				<div class="m-grid__item m-grid__item--fluid m-grid m-grid--center m-grid--hor m-grid__item--order-tablet-and-mobile-1	m-login__content" style="background-image: url(../../../assets/app/media/img/bg/bg-4.jpg)">
					
					<div class="m-grid__item m-grid__item--middle">
						<h4 class="m-login__welcome" style="color: white;font-family: inherit;">
							Friendly ERP
							
						</h4>
						<p class="m-login__msg">
							
						</p>
					</div>
					<h1 style="color: white;padding-left: 60px;font-size: 35px">
							Join Our Community
						</h1>
				</div>
			</div>
		</div>
		<!-- end:: Page -->
    	<!--begin::Base Scripts -->
		<script src="<%=request.getContextPath()%>/../../../assets/vendors/base/vendors.bundle.js" type="text/javascript"></script>
		<script src="<%=request.getContextPath()%>/../../../assets/demo/default/base/scripts.bundle.js" type="text/javascript"></script>
		
		<!--end::Base Scripts -->   
        <!--begin::Page Snippets -->
		<script src="<%=request.getContextPath()%>/../../../assets/snippets/custom/pages/user/login.js" type="text/javascript"></script>
		<!--end::Page Snippets -->
		<script type="text/javascript">
		$(document).ready(function(){
			console.log("READY");
			$("#email1").change(function(){
				var email = $("#email1").val();
				$.get("/emailCheck/"+email, function(data, status){
			    	console.log(data);
			    	if(data=='false')
			    		{
			    		alert("email is already exists");
			    		$("#email1").val(null);
			    		}
			    	
			      });
				  /* alert("email is already exists"); */
				});
			
			});
		
		</script>
	</body>
	<!-- end::Body -->
	
</html>
