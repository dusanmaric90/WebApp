<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<link href="style.css" type="text/css" rel="stylesheet">
		<html>
			<head>
				<title>Pocetna strana</title>
			</head>
			<body>
			<%@include  file="menu.jsp"  %>
			<div class ="content">
					<table>
					
						<tr>
							<p><a href="./StudentControllerShow">Prikaz entiteta 'Student'</a></p>
						</tr>
					
						<tr>
							<p><a href="./ProfessorControllerShow">Prikaz entiteta 'Professor'</a></p>
						</tr>
					
						<tr>
							<p><a href="./SubjectControllerShow">Prikaz entiteta 'Subject'</a></p>
						</tr>
					
						<tr>
							<p><a href="./GradeControllerShow">Prikaz entiteta 'Grade'</a></p>
						</tr>
					
					</table>
			</div>
			</body>
		</html>