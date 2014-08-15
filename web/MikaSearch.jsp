<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<%@page import="java.util.List"%>
	<%@page import="model.Mika"%>
	<%
		List<Mika> mikas = (List<Mika>) request.getAttribute("mikas");
	%>
	<%
		Boolean badFormat = (Boolean) request.getAttribute("badFormat");
	%>
	
	
	<html>
		<head>
			<title>Pretraga Mika</title>
		</head>
		<body>
		
			<form action="./MikaSearchController" method="post">
				<table>
				
				
				
				<tr>
				
				<td>ime</td>
				
				
				<td><input type="text" name="ime" /></td>
				</tr>				
				
				
				

					<c:if test="${badFormat }">
						<tr>
							<td>&nbsp;</td>
							<td><font color="red">ERROR: Bad date format!</font></td>
						</tr>
					</c:if>
					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" name="Search" value="Search" />
					</tr>
				</table>
			</form>
			
			
			<c:if test="${!empty mikas }">
				<p>Results:</p>
				<table id="mikasTable">
					<tr>
					
					<th>ime</th>
					
					</tr>
					<c:forEach var="mika" items="${mikas }">
						<tr>
						
						<td>${mika.ime } </td>
						

							<td>
								<form action="./MikaControllerShow" method="post">
									<input type="hidden" name="id" value="${mika.id }"> <input
										type="submit" name="View Mika" value="View Mika">
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		<p> <a href="./home.jsp">Pocetna</a>  </p>
		</body>
	</html>