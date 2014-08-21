	
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<link href="style.css" type="text/css" rel="stylesheet">
	<html>
	<head>
		<title>Dodaj Subject</title>
		
	<script type="text/javascript">
	
	function provera(){
		
		
		
		
		parametar = document.forms['forma'].subject_name.value;
		if(parametar==""){
			alert("Niste uneli subject_name");
			return false;
		}

		
		parametar = document.forms['forma'].subject_name.value.length;
		if(parametar<0){
			alert("Za polje subject_name min_lengthimalna duzina mora biti 0 ");
			return false;
		}	
		
		
		
		
		
		

			
		
		
		parametar=document.forms['forma'].espb.value;
		var num = parametar.replace(/\,/g,'');
		if(isNaN(parametar)|| num.indexOf('.') > -1 ) {
				alert("espb mora biti ceo broj");
				return false;
		}
		
		
		
		
		
		
		
	}	
	</script>
	</head>
	
	<body>
	<%@include  file="menu.jsp"  %>
	<div class ="content">
	<div class = "listCentar"> <h2>Dodaj Subject</h2> </div>
		<c:if test="${not empty error}">
		    ${error}
		</c:if>
		<div class = "listCentarGrey">
		<form action="./SubjectControllerAdd" method="post" name="forma" onsubmit="return provera()" >
			<table >
			
			
			
			<tr>
					<td>subject_name *</td>
					<td><input type="text" name="subject_name"  /> </td>				
			</tr>			
			
			
			<tr>
					<td>espb </td>
					<td><input type="text" name="espb"  /> </td>				
			</tr>			
			
						
			
			
			
			
			
			<tr>
					<td>&nbsp;</td>
					<td><input type="submit" name="submit" value="Dodaj Subject" class = "button"></td>				
				</tr>
			</table>						
		</form>
		</div>
		<p> <a href="./home.jsp">Pocetna</a>  </p>
		</div>
	<body>
</html>