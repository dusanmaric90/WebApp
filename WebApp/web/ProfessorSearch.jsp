<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
		
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	
	<%@page import="java.util.List"%>
	<%@page import="model.Professor"%>
	<%
		List<Professor> professors = (List<Professor>) request.getAttribute("professors");
	%>
	<%
		Boolean badFormat = (Boolean) request.getAttribute("badFormat");
	%>
	<link href="style.css" type="text/css" rel="stylesheet">
	
	<html>
		<head>
			<title>Pretraga Professor</title>
		</head>
		<body>
			<%@include  file="menu.jsp"  %>
			<div class ="content">
			<div class = "listCentar"> <h2>Search Professor</h2> </div>
			<div class = "listCentar">
			<form action="./ProfessorSearchController" method="post">
				<table>
				
				
				

				
				<tr>
				
				<td>count_subjests</td>
				
				
				<td><input type="text" name="count_subjests" /></td>
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
					<option value="null"></option>
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
			</div>
			
			<c:if test="${!empty professors }">
				<div class = "listCentar"><p>Results:</p> </div>
				<div class = "listCentar">
				<table id="professorsTable">
					<tr>
					
					
					<th>count_subjests</th>
					
					
					
					
					
					<th>firstname</th>
					
					
					<th>lastname</th>
					
					
					<th>birthday</th>
					
					
					<th>gender</th>
					
					</tr>
					<c:forEach var="professor" items="${professors }">
						<tr>
						
						
						
						<td>${professor.count_subjests } </td>
						
						
						
						
						
						
						<td>${professor.firstname } </td>
						
						
						
						<td>${professor.lastname } </td>
						
						
						
						<td> <fmt:formatDate pattern="dd-MM-yyyy" value="${professor.birthday}" /></td>
						
						
						
						
						<td>${professor.gender } </td>
						
						</tr>
					</c:forEach>
				</table>
				</div>
			</c:if>
		<p> <a href="./home.jsp">Pocetna</a>  </p>
		</div>
		</body>
	</html>