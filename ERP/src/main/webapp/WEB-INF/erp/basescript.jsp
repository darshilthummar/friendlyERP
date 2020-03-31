<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   
<!--begin::Base Scripts -->
		<script src="/assets/vendors/base/vendors.bundle.js" type="text/javascript"></script>
		<script src="/assets/demo/default/base/scripts.bundle.js" type="text/javascript"></script>
		<!--end::Base Scripts -->   
        <!--begin::Page Vendors -->
		<script src="/assets/vendors/custom/fullcalendar/fullcalendar.bundle.js" type="text/javascript"></script>
		<!--end::Page Vendors -->  
        <!--begin::Page Snippets -->
		<script src="/assets/app/js/dashboard.js" type="text/javascript"></script>
		<!--end::Page Snippets -->
			<script src="/assets/vendors/custom/datatables/datatables.bundle.js" type="text/javascript"></script>
	

	<script src="/assets/demo/default/custom/crud/forms/validation/form-widgets.js" type="text/javascript"></script>
		<script src="/assets/demo/default/custom/crud/forms/validation/form-controls.js" type="text/javascript"></script>
			<script src="/assets/demo/demo12/custom/crud/forms/widgets/select2.js" type="text/javascript"></script>

<script src="/assets/app/js/dashboard.js" type="text/javascript"></script>

<script type="text/javascript">

 var current = location.pathname;
//console.log(current);
$('#m_ver_menu ul li ul li a').each(function(){
var $this = $(this);
// if the current path is like this link, make it active
if($this.attr('href').indexOf(current) !== -1){
$this.parent().addClass('m-menu__item--active');
$this.parent().parent().parent().parent().addClass('m-menu__item--open');
}
});
 
$( document ).ready(function() {
    console.log( "ready!" );
  
 
$.get("/userdata",  // url
	      function (data, status) {  
console.log(data);
 $("#user").html(data.username);
 $("#user_email").html(data.email);
});

});
</script>

</body>
</html>