<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<link href="style.css" type="text/css" rel="stylesheet">
	<html>
	  
		<head>
			<title> Prikaz Grade </title>
		
		</head>
		<body>
		<%@include  file="menu.jsp"  %>
		<div class ="content">
		<div class = "listCentar"><h2 >Tabela Grade</h2> 
			<c:if test="${not empty error}">
			    ${error}
			</c:if>
			
				<table border="1" class = "listCentarGrey">
					<tr> 
					
					
					 <th>	points </th>					 
					
					
					 <th>	grade </th>					 
					
					
					 <th>	subject </th>					 
					
					
					 <th>	professor </th>					 
					
					
					 <th>	student </th>					 
					
					
					 <th colspan="2"> </th>
						
					</tr>
					
					<c:forEach var="show" items="${list}">
					<tr> 
					
					
					
					<td>${show.points} </td>	
					
					
					
					<td>${show.grade} </td>	
					
					
					<td>${show.subject.toString()}  </td>
						
					
					
					<td>${show.professor.toString()}  </td>
						
					
					
					<td>${show.student.toString()}  </td>
						
					

					
				   
				   
				   
				    <form action="./GradePrepareUpdateController" method="post">
								<td><input type="hidden" name="id" value="${show.id}" /><input
									type="submit" value="Izmena" class = "button"/></td>
					</form>
				   
				     <form action="./GradeDeleteController">
								<td><input type="hidden" name="id" value="${show.id}" /><input
									type="submit" value="Brisanje" class = "button" /></td>
					</form>
				   

					
				    </tr>
				</c:forEach>
				</table>
				</div>

	</div>
		</body>
	</html>