<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<html>
	  
		<head>
			<title> Prikaz Zika </title>
		
		</head>
		<body>
		<h2> Tabela Zika </h2>
			<c:if test="${not empty error}">
			    ${error}
			</c:if>
				<table border="1">
					<tr> 
					
					 <th>	ime </th>	
					
					 <th>	prezime </th>	
					
					 <th>	mika </th>	
					
					
					 <th colspan="2"> </th>
						
					</tr>
					
					<c:forEach var="show" items="${list}">
					<tr> 
					
					
					<td>${show.ime} </td>	
					
					
					<td>${show.prezime} </td>	
					
					
					<td>${show.mika.toString()}  </td>
						
					

					
				   
				   
				   
				    <form action="./ZikaPrepareUpdateController" method="post">
								<td><input type="hidden" name="id" value="${show.id}" /><input
									type="submit" value="Izmena" /></td>
					</form>
				   
				     <form action="./ZikaDeleteController">
								<td><input type="hidden" name="id" value="${show.id}" /><input
									type="submit" value="Brisanje" /></td>
					</form>
				   

					
				    </tr>
				</c:forEach>
				</table>
	<p> <a href="./ZikaControllerPrepareAdd">Dodavanje Zika</a>  </p>
	<p> <a href="./ZikaSearch.jsp">Pretraga Zika</a>  </p>
	<p> <a href="./home.jsp">Pocetna</a>  </p>
		</body>
	</html>