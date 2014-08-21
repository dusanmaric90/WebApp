<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<link href="style.css" type="text/css" rel="stylesheet">
	<html>
		<head>
			<title>Izmeni Grade</title>
			
			
			
<script type="text/javascript">
	
	function provera(){
		
		
		
		
		parametar = document.forms['forma'].points.value;
		if(parametar==""){
			alert("Niste uneli points");
			return false;
		}

			
		
		
		parametar=document.forms['forma'].points.value;
		var num = parametar.replace(/\,/g,'');
		if(isNaN(parametar)|| num.indexOf('.') > -1 ) {
				alert("points mora biti ceo broj");
				return false;
		}
		
		
		
		
		parametar = document.forms['forma'].grade.value;
		if(parametar==""){
			alert("Niste uneli grade");
			return false;
		}

			
		
		
		parametar=document.forms['forma'].grade.value;
		var num = parametar.replace(/\,/g,'');
		if(isNaN(parametar)|| num.indexOf('.') > -1 ) {
				alert("grade mora biti ceo broj");
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
			<div class = "listCentar"> <h2>Update Grade</h2> </div>
			<div class = "listCentar">
			<form action="./GradeUpdateController" method="post" name="forma" onsubmit="return provera()">
				<table >
				
			
			
			<tr>
					<td>points *</td>
					
					<td><input type="text" name="points" value="${grade.points}"  /> </td>				
					
			</tr>			
			
			
			<tr>
					<td>grade *</td>
					
					<td><input type="text" name="grade" value="${grade.grade}"  /> </td>				
					
			</tr>			
			
			
			<tr>
				 <td>subject </td>
			 	
					<td><select name="subject">
							<c:forEach var="tempSubject" items="${listSubject}">
								<option value="${tempSubject.id}">${tempSubject.toString()}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
						
			
			
			<tr>
				 <td>professor </td>
			 	
					<td><select name="professor">
							<c:forEach var="tempProfessor" items="${listProfessor}">
								<option value="${tempProfessor.id}">${tempProfessor.toString()}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
						
			
			
			<tr>
				 <td>student </td>
			 	
					<td><select name="student">
							<c:forEach var="tempStudent" items="${listStudent}">
								<option value="${tempStudent.id}">${tempStudent.toString()}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
						
			
			
			
	
					<tr>
					
						<td><input type="hidden" name="id" value="${grade.id}"></td>
						<td><input type="submit" name="submit" value="Izmeni Grade"></td>
					</tr>
				</table>
			</form>
			</div>
			<p> <a href="./home.jsp">Pocetna</a>  </p>
			</div>
		</body>
	</html>