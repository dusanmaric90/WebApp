<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<link href="style.css" type="text/css" rel="stylesheet">
	<html>
		<head>
			<title>Izmeni Subject</title>
			
			
			
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
			<c:if test="${not empty error}">
			    ${error}
			</c:if>
			<div class = "listCentar"> <h2>Update Subject</h2> </div>
			<div class = "listCentarGrey">
			<form action="./SubjectUpdateController" method="post" name="forma" onsubmit="return provera()">
				<table >
				
			
			
			<tr>
					<td>subject_name *</td>
					
					<td><input type="text" name="subject_name" value="${subject.subject_name}" max_lengthlength="30" size="30" /> </td>				
					
			</tr>			
			
			
			<tr>
					<td>espb </td>
					
					<td><input type="text" name="espb" value="${subject.espb}"  /> </td>				
					
			</tr>			
			
						
			
			
			
	
					<tr>
					
						<td><input type="hidden" name="id" value="${subject.id}"></td>
						<td><input type="submit" name="submit" value="Izmeni Subject" class = "button"></td>
					</tr>
				</table>
			</form>
			</div>
			<p> <a href="./home.jsp">Pocetna</a>  </p>
			</div>
		</body>
	</html>