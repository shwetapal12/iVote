<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Admin Login Page</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" >
        
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="Css/Login.css" rel="stylesheet" type="text/css"/>

</head>
<body>
 <%  session = request.getSession(false);
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");

if (session.getAttribute("name") != null)
	{
	response.sendRedirect("Logout");
	}
else{
%> 

	<div class="container h-100">
		<div class="d-flex justify-content-center h-100">
			<div class="user_card">
				<div class="d-flex justify-content-center">
					<div class="brand_logo_container">
                                          
						<img src=  "images/logo.jpg"  class="brand_logo" alt="Logo">
					</div>
				</div>
				<div class="d-flex justify-content-center form_container">
                    <!-- <form action="Home.jsp" method="post">  --> 
                  <form action="adminLogin" method="post"> 
						<div class="input-group mb-3">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
							<input type="text" name="UserName" id="UserName" class="form-control input_user"  placeholder="username">
						</div>
						<div class="input-group mb-2">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
							<input type="password" name="Password"  id="Password" class="form-control input_pass"  placeholder="password">
						</div>
						<span class="text-danger"><% if(null!=request.getAttribute("errorMessage"))
			   				 {
			        			out.println(request.getAttribute("errorMessage"));
			   				 }
						%></span>
              <div class="d-flex justify-content-center mt-3 login_container">
              	 <input type="submit" name="button" class="btn login_btn" value="Login">
              	  
			</div>
					</form>
				</div>								
			</div>
		</div>
	</div>
</body>

</html>
 <% 	}	%> 



