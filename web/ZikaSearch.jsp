<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<%@page import="java.util.List"%>
	<%@page import="model.Zika"%>
	<%
		List<Zika> zikas = (List<Zika>) request.getAttribute("zikas");
	%>
	<%
		Boolean badFormat = (Boolean) request.getAttribute("badFormat");
	%>
	
	
	<html>
		<head>
			<title>Pretraga Zika</title>
		</head>
		<body>
		
			<form action="./ZikaSearchController" method="post">
				<table>
				
				
				
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
			
			
			<c:if test="${!empty zikas }">
				<p>Results:</p>
				<table id="zikasTable">
					<tr>
					
					<th>ime</th>
					
					<th>prezime</th>
					
					<th>mika</th>
					
					</tr>
					<c:forEach var="zika" items="${zikas }">
						<tr>
						
						<td>${zika.ime } </td>
						
						<td>${zika.prezime } </td>
						
						<td>${zika.mika } </td>
						

							<td>
								<form action="./ZikaControllerShow" method="post">
									<input type="hidden" name="id" value="${zika.id }"> <input
										type="submit" name="View Zika" value="View Zika">
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		<p> <a href="./home.jsp">Pocetna</a>  </p>
		</body>
	</html>