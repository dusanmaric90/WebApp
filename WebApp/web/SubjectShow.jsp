<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<link href="style.css" type="text/css" rel="stylesheet">
	<html>
	  
		<head>
			<title> Prikaz Subject </title>
		
		</head>
		<body>
		<%@include  file="menu.jsp"  %>
		<div class ="content">
		<div class = "listCentar"><h2 >Tabela Subject</h2> 
			<c:if test="${not empty error}">
			    ${error}
			</c:if>
			
				<table border="1">
					<tr> 
					
					
					 <th>	subject_name </th>					 
					
					
					 <th>	espb </th>					 
					
										 
					
					
					 <th colspan="2"> </th>
						
					</tr>
					
					<c:forEach var="show" items="${list}">
					<tr> 
					
					
					
					<td>${show.subject_name} </td>	
					
					
					
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
				</div>
	<p> <a href="./SubjectControllerPrepareAdd">Dodavanje Subject</a>  </p>
	<p> <a href="./SubjectSearch.jsp">Pretraga Subject</a>  </p>
	<p> <a href="./home.jsp">Pocetna</a>  </p>
	</div>
		</body>
	</html>