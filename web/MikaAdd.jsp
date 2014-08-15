	
	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<html>
	<head>
		<title>Dodaj Mika</title>
		
	<script type="text/javascript">
	
	function provera(){
		
		
		

			
		
		
		
		
		
		
		
	}	
	</script>
	</head>
	
	<body>
	<h2>Dodaj Mika</h2>
		<c:if test="${not empty error}">
		    ${error}
		</c:if>
		<form action="./MikaControllerAdd" method="post" name="forma" onsubmit="return provera()" >
			<table >
			
			
			
			<tr>
					<td>ime </td>
					<td><input type="text" name="ime"  /> </td>				
			</tr>			
			
			
			
			
			
			<tr>
					<td>&nbsp;</td>
					<td><input type="submit" name="submit" value="Dodaj Mika"></td>				
				</tr>
			</table>						
		</form>
		
		<p> <a href="./home.jsp">Pocetna</a>  </p>
	<body>
</html>