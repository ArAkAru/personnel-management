<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html>

<head>
	<title>Новый сотрудник</title>

	

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>

	<div id="container">
		<h3>Новый сотрудник</h3>
 
		<form:form class="contact_form" action="saveEmployee" modelAttribute="employee" method="POST">
		
			<table>
				<tbody>
					<tr>
						<td><label>Имя:</label></td>
						<td><form:input path="name" /></td>
					</tr>
				
					<tr>
						<td><label>Фамилия:</label></td>
						<td><form:input path="lastName" /></td>
					</tr>
<tr>
						<td><label>Возраст:</label></td>
						<td><form:input path="years" value="18" /></td>
					</tr>
					
					<tr>
						<td><label>Должность:</label></td>
						<td><form:input path="position" /></td>
					</tr>

					<tr>
					<td><label>Отделы:</label></td>
							
							<td>	
							<select name="nameDEP">
							<c:forEach var="tempDep" items="${depList}">
  								<option>${tempDep.name} </option>
  							</c:forEach>
							</select>
							</td> 
							
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Сохранить" class="submitB" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/table/list">Обратно к списку</a>
		</p>
	
	</div>

</body>

</html>










