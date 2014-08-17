<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<html>
	  
		<head>
			<title> Prikaz Subject </title>
		
		</head>
		<body>
		<h2> Tabela Subject </h2>
			<c:if test="${not empty error}">
			    ${error}
			</c:if>
				<table border="1">
					<tr> 
					
					
					 <th>	subjectname </th>					 
					
					
					 <th>	espb </th>					 
					
										 
					
					
					 <th colspan="2"> </th>
						
					</tr>
					
					<c:forEach var="show" items="${list}">
					<tr> 
					
					
					<td>${show.subjectname} </td>	
					
					
					<td>${show.espb} </td>	
					
						
					

					
				   
				   
				   
				    <form action="./SubjectPrepareUpdateController" method="post">
								<td><input type="hidden" name="id" value="${show.id}" /><input
									type="submit" value="Izmena" /></td>
					</form>
				   
				     <form action="./SubjectDeleteController">
								<td><input type="hidden" name="id" value="${show.id}" /><input
									type="submit" value="Brisanje" /></td>
					</form>
				   

					
				    </tr>
				</c:forEach>
				</table>
	<p> <a href="./SubjectControllerPrepareAdd">Dodavanje Subject</a>  </p>
	<p> <a href="./SubjectSearch.jsp">Pretraga Subject</a>  </p>
	<p> <a href="./home.jsp">Pocetna</a>  </p>
		</body>
	</html>