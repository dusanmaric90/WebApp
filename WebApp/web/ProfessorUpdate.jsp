<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<link href="style.css" type="text/css" rel="stylesheet">
	<html>
		<head>
			<title>Izmeni Professor</title>
			
			
			
<script type="text/javascript">
	
	function provera(){
		
		
		
		

			
		
		
		parametar=document.forms['forma'].count_subjests.value;
		var num = parametar.replace(/\,/g,'');
		if(isNaN(parametar)|| num.indexOf('.') > -1 ) {
				alert("count_subjests mora biti ceo broj");
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
			<c:if test="${not empty error}">
			    ${error}
			</c:if>
			<div class = "listCentar"> <h2>Update Professor</h2> </div>
			<div class = "listCentar">
			<form action="./ProfessorUpdateController" method="post" name="forma" onsubmit="return provera()">
				<table >
				
			
			
			<tr>
					<td>count_subjests </td>
					
					<td><input type="text" name="count_subjests" value="${professor.count_subjests}"  /> </td>				
					
			</tr>			
			
						
			
			
			
			
			<tr>
					<td>firstname *</td>
					
					<td><input type="text" name="firstname" value="${professor.firstname}" max_lengthlength="30" size="30" /> </td>				
					
			</tr>			
			
			
			<tr>
					<td>lastname *</td>
					
					<td><input type="text" name="lastname" value="${professor.lastname}" max_lengthlength="30" size="30" /> </td>				
					
			</tr>			
			
			
			<tr>
					<td>birthday *</td>
					
					<td>
					<fmt:formatDate value="${professor.birthday}"  type="date" pattern="dd-MM-yyyy" var="theFormattedDate" />
					<input type="text" name="birthday" value="${theFormattedDate}"  /> </td>				
					
			</tr>			
			
			
			<tr>
				 <td>gender *</td>
					<td><select name="gender">
							<c:forEach var="tempGender" items="<%= model.Gender.values() %>">
								<option value="${tempGender}" <c:if test="${professor.gender==tempGender}">selected="selected"</c:if>>${tempGender}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
						
			
	
					<tr>
					
						<td><input type="hidden" name="id" value="${professor.id}"></td>
						<td><input type="submit" name="submit" value="Izmeni Professor"></td>
					</tr>
				</table>
			</form>
			</div>
			<p> <a href="./home.jsp">Pocetna</a>  </p>
			</div>
		</body>
	</html>