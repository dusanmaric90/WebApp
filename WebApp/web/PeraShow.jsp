<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<html>
	  
		<head>
			<title> Prikaz Pera </title>
		
		</head>
		<body>
		<h2> Tabela Pera </h2>
			<c:if test="${not empty error}">
			    ${error}
			</c:if>
				<table border="1">
					<tr> 
					
					 <th>	adresa </th>	
					
					 <th>	zika </th>	
					
					
					 <th>	ime </th>	
					
					 <th>	prezime </th>	
					
					 <th>	mika </th>	
					
					 <th colspan="2"> </th>
						
					</tr>
					
					<c:forEach var="show" items="${list}">
					<tr> 
					
					
					<td>${show.adresa} </td>	
					
					
					<td>${show.zika.toString()}  </td>
						
					

					
					
					<td>${show.ime} </td>	
					
					
					<td>${show.prezime} </td>	
					
					
					<td>${show.mika.toString()}  </td>
						
					
				   
				   
				   
				    <form action="./PeraPrepareUpdateController" method="post">
								<td><input type="hidden" name="id" value="${show.id}" /><input
									type="submit" value="Izmena" /></td>
					</form>
				   
				     <form action="./PeraDeleteController">
								<td><input type="hidden" name="id" value="${show.id}" /><input
									type="submit" value="Brisanje" /></td>
					</form>
				   

					
				    </tr>
				</c:forEach>
				</table>
	<p> <a href="./PeraControllerPrepareAdd">Dodavanje Pera</a>  </p>
	<p> <a href="./PeraSearch.jsp">Pretraga Pera</a>  </p>
	<p> <a href="./home.jsp">Pocetna</a>  </p>
		</body>
	</html>