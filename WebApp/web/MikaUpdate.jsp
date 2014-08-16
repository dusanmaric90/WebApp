<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<html>
		<head>
			<title>Izmeni Mika</title>
			
			
			
<script type="text/javascript">
	
	function provera(){
		
		
		

			
		
		
		
		
		
		
		
	}	
	</script>
	
	
	
		</head>
		<body>
			<c:if test="${not empty error}">
			    ${error}
			</c:if>
			<form action="./MikaUpdateController" method="post" name="forma" onsubmit="return provera()">
				<table >
				
			
			
			<tr>
					<td>ime </td>
					<td><input type="text" name="ime" value="${mika.ime}"  /> </td>				
			</tr>			
			
			
			
	
					<tr>
						<td>&nbsp;</td>
						<td><input type="hidden" name="id" value="${mika.id}"></td>
						<td><input type="submit" name="submit" value="Izmeni Mika"></td>
					</tr>
				</table>
			</form>
			<p> <a href="./home.jsp">Pocetna</a>  </p>
		</body>
	</html>