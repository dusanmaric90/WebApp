	
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<link href="style.css" type="text/css" rel="stylesheet">
	<html>
	<head>
		<title>Dodaj Student</title>
		
	<script type="text/javascript">
	
	function provera(){
		
		
		
		
		parametar = document.forms['forma'].index_number.value;
		if(parametar==""){
			alert("Niste uneli index_number");
			return false;
		}

		
		parametar = document.forms['forma'].index_number.value.length;
		if(parametar<0){
			alert("Za polje index_number min_lengthimalna duzina mora biti 0 ");
			return false;
		}	
		
		
		
		
		
		

			
		
		
		parametar=document.forms['forma'].count_exam_passed.value;
		var num = parametar.replace(/\,/g,'');
		if(isNaN(parametar)|| num.indexOf('.') > -1 ) {
				alert("count_exam_passed mora biti ceo broj");
				return false;
		}
		
		
		
		
		
		
		
		
		parametar = document.forms['forma'].firstname.value;
		if(parametar==""){
			alert("Niste uneli firstname");
			return false;
		}

		
		parametar = document.forms['forma'].firstname.value.length;
		if(parametar<0){
			alert("Za polje firstname min_lengthimalna duzina mora biti 0 ");
			return false;
		}	
		
		
		
		
		
		
		parametar = document.forms['forma'].lastname.value;
		if(parametar==""){
			alert("Niste uneli lastname");
			return false;
		}

		
		parametar = document.forms['forma'].lastname.value.length;
		if(parametar<0){
			alert("Za polje lastname min_lengthimalna duzina mora biti 0 ");
			return false;
		}	
		
		
		
		
		
		
		parametar = document.forms['forma'].birthday.value;
		if(parametar==""){
			alert("Niste uneli birthday");
			return false;
		}

			
		
		
		
	    vrednost=document.forms['forma'].birthday.value;
	   var date=vrednost.trim();
	   if(vrednost.length!=0){ 
		var niz=new Array();
		niz=date.split('-');
		if(niz.length!=3){
		 alert("Format birthday mora biti dd-MM-yyyy");
		  return false; 
		}else{
		 if(isNaN(niz[0]) || isNaN(niz[1]) || isNaN(niz[2]) || niz[0].length!=2|| niz[1].length!=2|| niz[2].length!=4){
		  alert("Format birthday mora biti dd-MM-yyyy");
		  return false; 
		 }
		}
	   }
		
		
		
		parametar = document.forms['forma'].gender.value;
		if(parametar==""){
			alert("Niste uneli gender");
			return false;
		}

			
		
		
		
		
		
	}	
	</script>
	</head>
	
	<body>
	<%@include  file="menu.jsp"  %>
	<div class ="content">
	<div class = "listCentar"> <h2>Dodaj Student</h2> </div>
		<c:if test="${not empty error}">
		    ${error}
		</c:if>
		<div class = "listCentarGrey">
		<form action="./StudentControllerAdd" method="post" name="forma" onsubmit="return provera()" >
			<table >
			
			
			
			<tr>
					<td>index_number *</td>
					<td><input type="text" name="index_number"  /> </td>				
			</tr>			
			
			
			<tr>
					<td>count_exam_passed </td>
					<td><input type="text" name="count_exam_passed"  /> </td>				
			</tr>			
			
						
			
			
			
			
			<tr>
					<td>firstname *</td>
					<td><input type="text" name="firstname"  /> </td>				
			</tr>	
			
			
			<tr>
					<td>lastname *</td>
					<td><input type="text" name="lastname"  /> </td>				
			</tr>	
			
			
			<tr>
					<td>birthday *</td>
					<td><input type="text" name="birthday"  /> </td>				
			</tr>	
			
			
			<tr>
				 <td>gender *</td>
					<td><select name="gender">
							<c:forEach var="tempGender" items="<%= model.Gender.values() %>">
								<option value="${tempGender}">${tempGender}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				
			
			
			
			<tr>
					<td>&nbsp;</td>
					<td><input type="submit" name="submit" value="Dodaj Student" class = "button"></td>				
				</tr>
			</table>						
		</form>
		</div>
		<p> <a href="./home.jsp">Pocetna</a>  </p>
		</div>
	<body>
</html>