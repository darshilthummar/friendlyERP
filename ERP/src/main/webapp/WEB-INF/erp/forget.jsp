<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			FriendlyERP | Password Reset
		</title>
		<meta name="description" content="Latest updates and statistic charts">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!--begin::Web font -->
		<script src="https://ajax.googleapis.com/ajax/libs/webfont/1.6.16/webfont.js"></script>
		
		<script>
          WebFont.load({
            google: {"families":["Poppins:300,400,500,600,700","Roboto:300,400,500,600,700"]},
            active: function() {
                sessionStorage.fonts = true;
            }
          });
		</script>
		<!--end::Web font -->
        <!--begin::Base Styles -->
		<link href="/../../../assets/vendors/base/vendors.bundle.css" rel="stylesheet" type="text/css" />
		<link href="/../../../assets/demo/default/base/style.bundle.css" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" href="/assets/vendors/formvalidation/css/formValidation.min.css">		
		<!--end::Base Styles -->
		<link rel="shortcut icon" href="/assets/demo/default/media/img/logo/5a729504-9b87-43d3-8385-9d86b297f6a1_200x200.png" />
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
											Forget Your Password
										</h3>
									</div>
									<form class="m-login__form m-form" action="/forgetpass" method="post" id="change_pass1">
										<div class="form-group m-form__group">
											<input class="form-control m-input" type="password"  name="password" placeholder="Password" id="password" autocomplete="off">
										</div>
										<div class="form-group m-form__group">
											<input class="form-control m-input" type="password" placeholder="Confirm Password" name="rpassword" id="rpassword" onKeyUp="checkPassword()">
										</div>
										<div class="m--font-danger" id="divCheckPasswordMatch">
										</div>
										<div class="m-login__form-action">
											
											<input type="submit" value="Reset Password"  class="btn btn-focus m-btn m-btn--pill m-btn--custom m-btn--air" id="submit_button1">
											
										</div>
									</form>
								</div>
							
								<!-- END SINGN IN -->	
							
							
								
							</div>
						</div>
						
					</div>
				</div>
				<div class="m-grid__item m-grid__item--fluid m-grid m-grid--center m-grid--hor m-grid__item--order-tablet-and-mobile-1	m-login__content" style="background-image: url(../../../assets/app/media/img/bg/bg-4.jpg)">
					<div class="m-grid__item m-grid__item--middle">
						<h3 class="m-login__welcome">
							Join Our Community
						</h3>
						<p class="m-login__msg">
							
						</p>
					</div>
				</div>
			</div>
		</div>
		<!-- end:: Page -->
    	<!--begin::Base Scripts -->
		<script src="/../../../assets/vendors/base/vendors.bundle.js" type="text/javascript"></script>
		<script src="/../../../assets/demo/default/base/scripts.bundle.js" type="text/javascript"></script>
		
		<!--end::Base Scripts -->   
        <!--begin::Page Snippets -->
		<script src="/../../../assets/snippets/custom/pages/user/login.js" type="text/javascript"></script>
		<!--end::Page Snippets -->
		<script src="/assets/vendors/formvalidation/js/FormValidation.min.js"></script>
		<script src="/assets/vendors/formvalidation/js/framework/Bootstrap.min.js"></script>
		<script type="text/javascript">
		
		 function checkPassword() {
		        var password = $('#password').val();
		        var newPassword = $('#rpassword').val();

		        if (password != newPassword) {
		        	 $("#divCheckPasswordMatch").html("Passwords do not match!");

		        } else {
		        	 $("#divCheckPasswordMatch").html("");
		        }
		    }
		
		
		$(document).ready(function(){
			console.log("READY");
			
			

			 $('#change_pass1').formValidation({

				 framework : 'bootstrap',
					live:'disabled',
					excluded : ":disabled",
					button:{

						selector : "#submit_button1",
						disabled : "disabled",
					},
						icon : null,
						fields: {
							password: {
				                validators: {
				                    notEmpty: {
				                        message: 'The password is required'
				                    },
				                    stringLength: {
				                        min: 6,
				                        message: 'The password must have at least 8 characters'
				                    }
				                }
				            },
		                      rpassword:{
					                validators: {
					                    notEmpty: {
					                        message: 'The password is required'
					                    },
					                    stringLength: {
					                        min: 6,
					                        message: 'The password must have at least 8 characters'
					                    }
					                }
					            },
		                      },
			 });
			 checkPassword();
			
			});
		 
		</script>
	</body>
	<!-- end::Body -->
	
</html>
