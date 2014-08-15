<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<%@page import="java.util.List"%>
	<%@page import="model.Pera"%>
	<%
		List<Pera> peras = (List<Pera>) request.getAttribute("peras");
	%>
	<%
		Boolean badFormat = (Boolean) request.getAttribute("badFormat");
	%>
	
	
	<html>
		<head>
			<title>Pretraga Pera</title>
		</head>
		<body>
		
			<form action="./PeraSearchController" method="post">
				<table>
				
				
				
				<tr>
				
				<td>adresa</td>
				
				
				<td>
					<select name="adresa">
						<c:forEach var="tempBoja" items="<%= model.Boja.values() %>">
							<option value="${tempBoja}">${tempBoja}</option>
						</c:forEach>
					</select>
				</td>
				
				</tr>				
				
				<tr>
				
				<td>zika</td>
				
				
				<td><input type="text" name="zika" /></td>
				</tr>				
				
				
				
				<tr>
				
				<td>ime</td>
				
				
				<td><input type="text" name="ime" /></td>
				</tr>				
				
				<tr>
				
				<td>prezime</td>
				
				
				<td><input type="text" name="prezime" /></td>
				</tr>				
				
				<tr>
				
				<td>mika</td>
				
				
				<td><input type="text" name="mika" /></td>
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
			
			
			<c:if test="${!empty peras }">
				<p>Results:</p>
				<table id="perasTable">
					<tr>
					
					<th>adresa</th>
					
					<th>zika</th>
					
					</tr>
					<c:forEach var="pera" items="${peras }">
						<tr>
						
						<td>${pera.adresa } </td>
						
						<td>${pera.zika } </td>
						

							<td>
								<form action="./PeraControllerShow" method="post">
									<input type="hidden" name="id" value="${pera.id }"> <input
										type="submit" name="View Pera" value="View Pera">
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		<p> <a href="./home.jsp">Pocetna</a>  </p>
		</body>
	</html>