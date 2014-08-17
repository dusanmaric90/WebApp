<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
	<%@page import="java.util.List"%>
	<%@page import="model.Subject"%>
	<%
		List<Subject> subjects = (List<Subject>) request.getAttribute("subjects");
	%>
	<%
		Boolean badFormat = (Boolean) request.getAttribute("badFormat");
	%>
	
	
	<html>
		<head>
			<title>Pretraga Subject</title>
		</head>
		<body>
		
			<form action="./SubjectSearchController" method="post">
				<table>
				
				
				
				
				<tr>
				
				<td>subjectname</td>
				
				
				<td><input type="text" name="subjectname" /></td>
				</tr>				
				
				
				<tr>
				
				<td>espb</td>
				
				
				<td><input type="text" name="espb" /></td>
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
			
			
			<c:if test="${!empty subjects }">
				<p>Results:</p>
				<table id="subjectsTable">
					<tr>
					
					
					<th>subjectname</th>
					
					
					<th>espb</th>
					
					
					
					</tr>
					<c:forEach var="subject" items="${subjects }">
						<tr>
						
						
						<td>${subject.subjectname } </td>
						
						
						<td>${subject.espb } </td>
						
						
						

							<td>
								<form action="./SubjectControllerShow" method="post">
									<input type="hidden" name="id" value="${subject.id }"> <input
										type="submit" name="View Subject" value="View Subject">
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		<p> <a href="./home.jsp">Pocetna</a>  </p>
		</body>
	</html>