<%@include file="Header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 		<script src="jquery/jquery-3.3.1.min.js" type="text/javascript"></script>
      
<script>
$(document).ready(function(){
	//alert("Loaded inside");
	
	$.ajax({
		
		type:'GET',
		url:'ShowCandidates',		
		success: function(result){
			//alert("On inside"+$("#CandidateName").val());
	        $('#demo').html(result);
	    }
	});	

	$("#sub").click(function(){
		//alert("Loaded Button"+$("#CandidateName").val());
$.ajax({
			
			type:'POST',
			url:'InsertCandidates',
			data:{"CandidateName":$("#CandidateName").val(),"City":$("#City").val(),"Pincode":$("#Pincode").val()},
			success: function(result){
				//alert("On inside"+$("#CandidateName").val());
		        $('#demo').html(result);
		    }
		});
	
	});
		
});
</script>
</head>
<body>
 <%  session = request.getSession(false);
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
if (session.getAttribute("name") != null)
	{
%> 
 <h4 class="text-success">Welcome <% out.print(session.getAttribute("name")); %></h4>  

<br><br>
<div class="container">

  <form class="form" >
                <div class="form-group ">
                    <label class="col-3"><b>Candidate Name</b></label>
                    <input type="text" id ="CandidateName"  name="CandidateName" placeholder="Candidate Name" class="form-control col-12" required="required">
                </div>
                
<div class="form-group">
                    <label class="col-3"><b>City</b></label>
                    <input type="text" placeholder="City" name="City" class="form-control col-12" id="City" required="required">
                </div> 
               <div class="form-group ">
                    <label class="col-3"><b>Pincode</b></label>
                    <input type="text" placeholder="Pincode" name="Pincode" class="form-control col-12" id="Pincode" required="required">
                </div>               
				  <div class="d-flex justify-content-center mt-3 login_container">
            
				</div>                      
        </form>
        <div >
       	 	<button id="sub" class="btn btn-success btn-block">Add Candidate</button>
       	 	
        	<!-- <input type="reset" class=" col-6 btn btn-dark " value="Reset" style="float: right;"> -->
        </div>
        </div><br><br>
        <h3 style="color: blue ;font-family: Sans-serif ; text-align: center;">Available Candidates</h3><br>
        <div id="demo" class="container"></div>
</body>
 <%@include file="Footer.jsp" %> 
</html>
  <%  }
else
{
		response.sendRedirect("Logout");
	} 
	%>  