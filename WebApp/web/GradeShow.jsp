<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<html>
	  
		<head>
			<title> Prikaz Grade </title>
		
		</head>
		<body>
		<h2> Tabela Grade </h2>
			<c:if test="${not empty error}">
			    ${error}
			</c:if>
				<table border="1">
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
									type="submit" value="Izmena" /></td>
					</form>
				   
				     <form action="./GradeDeleteController">
								<td><input type="hidden" name="id" value="${show.id}" /><input
									type="submit" value="Brisanje" /></td>
					</form>
				   

					
				    </tr>
				</c:forEach>
				</table>
	<p> <a href="./GradeControllerPrepareAdd">Dodavanje Grade</a>  </p>
	<p> <a href="./GradeSearch.jsp">Pretraga Grade</a>  </p>
	<p> <a href="./home.jsp">Pocetna</a>  </p>
		</body>
	</html>