<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<html>
		<head>
			<title>Izmeni Zika</title>
			
			
			
<script type="text/javascript">
	
	function provera(){
		
		
		
		parametar = document.forms['forma'].ime.value;
		if(parametar==""){
			alert("Niste uneli ime");
			return false;
		}

		
		parametar = document.forms['forma'].ime.value.length;
		if(parametar<2){
			alert("Za polje ime minimalna duzina mora biti 2 ");
			return false;
		}	
		
		
		
		
		

			
		
		
		
		
		

			
		
		
		
		
		
		
		
	}	
	</script>
	
	
	
		</head>
		<body>
			<c:if test="${not empty error}">
			    ${error}
			</c:if>
			<form action="./ZikaUpdateController" method="post" name="forma" onsubmit="return provera()">
				<table >
				
			
			
			<tr>
					<td>ime *</td>
					<td><input type="text" name="ime" value="${zika.ime}" maxlength="5" size="5" /> </td>				
			</tr>			
			
			
			<tr>
					<td>prezime </td>
					<td><input type="text" name="prezime" value="${zika.prezime}"  /> </td>				
			</tr>			
			
			
			<tr>
				 <td>mika </td>
			 	
					<td><select name="mika">
							<c:forEach var="tempMika" items="${listMika}">
								<option value="${tempMika.id}">${tempMika.toString()}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
						
			
			
			
	
					<tr>
						<td>&nbsp;</td>
						<td><input type="hidden" name="id" value="${zika.id}"></td>
						<td><input type="submit" name="submit" value="Izmeni Zika"></td>
					</tr>
				</table>
			</form>
			<p> <a href="./home.jsp">Pocetna</a>  </p>
		</body>
	</html>