<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<html>
	  
		<head>
			<title> Prikaz Student </title>
		
		</head>
		<body>
		<h2> Tabela Student </h2>
			<c:if test="${not empty error}">
			    ${error}
			</c:if>
				<table border="1">
					<tr> 
					
					
					 <th>	indexnumber </th>					 
					
					
					 <th>	countexampassed </th>					 
					
										 
					
					
					
					 <th>	firstname </th>					 
					
					
					 <th>	lastname </th>					 
					
					
					 <th>	birthday </th>					 
					
					
					 <th>	gender </th>					 
					
					 <th colspan="2"> </th>
						
					</tr>
					
					<c:forEach var="show" items="${list}">
					<tr> 
					
					
					<td>${show.indexnumber} </td>	
					
					
					<td>${show.countexampassed} </td>	
					
						
					

					
					
					<td>${show.firstname} </td>	
					
					
					<td>${show.lastname} </td>	
					
					
					<td>${show.birthday} </td>	
					
					
					<td>${show.gender} </td>	
					
				   
				   
				   
				    <form action="./StudentPrepareUpdateController" method="post">
								<td><input type="hidden" name="id" value="${show.id}" /><input
									type="submit" value="Izmena" /></td>
					</form>
				   
				     <form action="./StudentDeleteController">
								<td><input type="hidden" name="id" value="${show.id}" /><input
									type="submit" value="Brisanje" /></td>
					</form>
				   

					
				    </tr>
				</c:forEach>
				</table>
	<p> <a href="./StudentControllerPrepareAdd">Dodavanje Student</a>  </p>
	<p> <a href="./StudentSearch.jsp">Pretraga Student</a>  </p>
	<p> <a href="./home.jsp">Pocetna</a>  </p>
		</body>
	</html>