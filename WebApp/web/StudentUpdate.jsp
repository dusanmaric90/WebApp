<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<html>
		<head>
			<title>Izmeni Student</title>
			
			
			
<script type="text/javascript">
	
	function provera(){
		
		
		
		
		parametar = document.forms['forma'].indexnumber.value;
		if(parametar==""){
			alert("Niste uneli indexnumber");
			return false;
		}

		
		parametar = document.forms['forma'].indexnumber.value.length;
		if(parametar<0){
			alert("Za polje indexnumber minimalna duzina mora biti 0 ");
			return false;
		}	
		
		
		
		
		
		

			
		
		
		parametar=document.forms['forma'].countexampassed.value;
		var num = parametar.replace(/\,/g,'');
		if(isNaN(parametar)|| num.indexOf('.') > -1 ) {
				alert("countexampassed mora biti ceo broj");
				return false;
		}
		
		
		
		
		
		
		
		
		parametar = document.forms['forma'].firstname.value;
		if(parametar==""){
			alert("Niste uneli firstname");
			return false;
		}

		
		parametar = document.forms['forma'].firstname.value.length;
		if(parametar<0){
			alert("Za polje firstname minimalna duzina mora biti 0 ");
			return false;
		}	
		
		
		
		
		
		
		parametar = document.forms['forma'].lastname.value;
		if(parametar==""){
			alert("Niste uneli lastname");
			return false;
		}

		
		parametar = document.forms['forma'].lastname.value.length;
		if(parametar<0){
			alert("Za polje lastname minimalna duzina mora biti 0 ");
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
		 alert("Format birthday mora biti yyyy-MM-dd");
		  return false; 
		}else{
		 if(isNaN(niz[0]) || isNaN(niz[1]) || isNaN(niz[2]) || niz[0].length!=4|| niz[1].length!=2|| niz[2].length!=2){
		  alert("Format birthday mora biti yyyy-MM-dd");
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
			<c:if test="${not empty error}">
			    ${error}
			</c:if>
			<form action="./StudentUpdateController" method="post" name="forma" onsubmit="return provera()">
				<table >
				
			
			
			<tr>
					<td>indexnumber *</td>
					<td><input type="text" name="indexnumber" value="${student.indexnumber}" maxlength="30" size="30" /> </td>				
			</tr>			
			
			
			<tr>
					<td>countexampassed </td>
					<td><input type="text" name="countexampassed" value="${student.countexampassed}"  /> </td>				
			</tr>			
			
						
			
			
			
			
			<tr>
					<td>firstname *</td>
					<td><input type="text" name="firstname" value="${student.firstname}" maxlength="30" size="30" /> </td>				
			</tr>			
			
			
			<tr>
					<td>lastname *</td>
					<td><input type="text" name="lastname" value="${student.lastname}" maxlength="30" size="30" /> </td>				
			</tr>			
			
			
			<tr>
					<td>birthday *</td>
					<td><input type="text" name="birthday" value="${student.birthday}"  /> </td>				
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
						<td><input type="hidden" name="id" value="${student.id}"></td>
						<td><input type="submit" name="submit" value="Izmeni Student"></td>
					</tr>
				</table>
			</form>
			<p> <a href="./home.jsp">Pocetna</a>  </p>
		</body>
	</html>