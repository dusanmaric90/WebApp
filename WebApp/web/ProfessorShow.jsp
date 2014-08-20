<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<html>
	  
		<head>
			<title> Prikaz Professor </title>
		
		</head>
		<body>
		<h2> Tabela Professor </h2>
			<c:if test="${not empty error}">
			    ${error}
			</c:if>
				<table border="1">
					<tr> 
					
					
					 <th>	count_subjests </th>					 
					
										 
					
					
					
					 <th>	firstname </th>					 
					
					
					 <th>	lastname </th>					 
					
					
					 <th>	birthday </th>					 
					
					
					 <th>	gender </th>					 
					
					 <th colspan="2"> </th>
						
					</tr>
					
					<c:forEach var="show" items="${list}">
					<tr> 
					
					
					
					<td>${show.count_subjests} </td>	
					
						
					

					
					
					
					<td>${show.firstname} </td>	
					
					
					
					<td>${show.lastname} </td>	
					
					
					
					<td> <fmt:formatDate pattern="dd-MM-yyyy" value="${show.birthday}" /></td>
						
					
					
					
					<td>${show.gender} </td>	
					
				   
				   
				   
				    <form action="./ProfessorPrepareUpdateController" method="post">
								<td><input type="hidden" name="id" value="${show.id}" /><input
									type="submit" value="Izmena" /></td>
					</form>
				   
				     <form action="./ProfessorDeleteController">
								<td><input type="hidden" name="id" value="${show.id}" /><input
									type="submit" value="Brisanje" /></td>
					</form>
				   

					
				    </tr>
				</c:forEach>
				</table>
	<p> <a href="./ProfessorControllerPrepareAdd">Dodavanje Professor</a>  </p>
	<p> <a href="./ProfessorSearch.jsp">Pretraga Professor</a>  </p>
	<p> <a href="./home.jsp">Pocetna</a>  </p>
		</body>
	</html>