<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<html>
	  
		<head>
			<title> Prikaz Mika </title>
		
		</head>
		<body>
		<h2> Tabela Mika </h2>
			<c:if test="${not empty error}">
			    ${error}
			</c:if>
				<table border="1">
					<tr> 
					
					 <th>	ime </th>	
					
					
					 <th colspan="2"> </th>
						
					</tr>
					
					<c:forEach var="show" items="${list}">
					<tr> 
					
					
					<td>${show.ime} </td>	
					

					
				   
				   
				   
				    <form action="./MikaPrepareUpdateController" method="post">
								<td><input type="hidden" name="id" value="${show.id}" /><input
									type="submit" value="Izmena" /></td>
					</form>
				   
				     <form action="./MikaDeleteController">
								<td><input type="hidden" name="id" value="${show.id}" /><input
									type="submit" value="Brisanje" /></td>
					</form>
				   

					
				    </tr>
				</c:forEach>
				</table>
	<p> <a href="./MikaControllerPrepareAdd">Dodavanje Mika</a>  </p>
	<p> <a href="./MikaSearch.jsp">Pretraga Mika</a>  </p>
	<p> <a href="./home.jsp">Pocetna</a>  </p>
		</body>
	</html>