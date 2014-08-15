<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<html>
		<head>
			<title>Izmeni Pera</title>
			
			
			
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
			<form action="./PeraUpdateController" method="post" name="forma" onsubmit="return provera()">
				<table >
				
			
			
			<tr>
				 <td>adresa </td>
					<td><select name="adresa">
							<c:forEach var="tempBoja" items="<%= model.Boja.values() %>">
								<option value="${tempBoja}">${tempBoja}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
						
			
			
			<tr>
				 <td>zika </td>
			 	
					<td><select name="zika">
							<c:forEach var="tempZika" items="${listZika}">
								<option value="${tempZika.id}">${tempZika.toString()}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
						
			
			
			
			
			<tr>
					<td>ime *</td>
					<td><input type="text" name="ime" value="${pera.ime}" maxlength="5" size="5" /> </td>				
			</tr>			
			
			
			<tr>
					<td>prezime </td>
					<td><input type="text" name="prezime" value="${pera.prezime}"  /> </td>				
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
						<td><input type="hidden" name="id" value="${pera.id}"></td>
						<td><input type="submit" name="submit" value="Izmeni Pera"></td>
					</tr>
				</table>
			</form>
			<p> <a href="./home.jsp">Pocetna</a>  </p>
		</body>
	</html>