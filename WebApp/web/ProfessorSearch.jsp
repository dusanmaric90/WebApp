<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<%@page import="java.util.List"%>
	<%@page import="model.Professor"%>
	<%
		List<Professor> professors = (List<Professor>) request.getAttribute("professors");
	%>
	<%
		Boolean badFormat = (Boolean) request.getAttribute("badFormat");
	%>
	
	
	<html>
		<head>
			<title>Pretraga Professor</title>
		</head>
		<body>
		
			<form action="./ProfessorSearchController" method="post">
				<table>
				
				
				
				
				<tr>
				
				<td>countsubjests</td>
				
				
				<td><input type="text" name="countsubjests" /></td>
				</tr>				
				
								
				
				
				
				
				<tr>
				
				<td>firstname</td>
				
				
				<td><input type="text" name="firstname" /></td>
				</tr>				
				
				
				<tr>
				
				<td>lastname</td>
				
				
				<td><input type="text" name="lastname" /></td>
				</tr>				
				
				
				<tr>
				
				<td> birthday (dd-MM-yyyy)</td>
				
				
				
				<td><input type="text" name="birthday" /></td>
				</tr>				
				
				
				<tr>
				
				<td>gender</td>
				
				
				<td>
					<select name="gender">
						<c:forEach var="tempGender" items="<%= model.Gender.values() %>">
							<option value="${tempGender}">${tempGender}</option>
						</c:forEach>
					</select>
				</td>
				
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
			
			
			<c:if test="${!empty professors }">
				<p>Results:</p>
				<table id="professorsTable">
					<tr>
					
					
					<th>countsubjests</th>
					
					
					
					</tr>
					<c:forEach var="professor" items="${professors }">
						<tr>
						
						
						<td>${professor.countsubjests } </td>
						
						
						

							<td>
								<form action="./ProfessorControllerShow" method="post">
									<input type="hidden" name="id" value="${professor.id }"> <input
										type="submit" name="View Professor" value="View Professor">
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		<p> <a href="./home.jsp">Pocetna</a>  </p>
		</body>
	</html>