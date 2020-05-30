<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>

<html>

	


<head>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    
    <script src="<c:url value="/resources/js/work.js" />"></script>
  
</head>
<div id="content" >
		
	 <input type="button"  class="boton2" value="Добавить сотрудника"
				   onclick="window.location.href='showFormForAdd'; return false;"
				  
			/>
		
			<table class="Departments">
				<tr>
					<th>Departments</th>
					
				</tr>
				
			
				
				<c:forEach var="tempDepartments" items="${departments}">
					<form action="/table/list"   method="post">
					<tr>
					<td class="dep">
						<p>
							<input type="hidden" name="name" value="${tempDepartments.id_Department}">
							<input type="submit" class="boton1" value="${tempDepartments.name}" >
						</p> 
					</td> 
				
					</tr>	 
					</form> 
				</c:forEach>
					
			</table>
			
</div>
	
<div class="tab">
  <button class="tablinks"  onclick="openCity(event, 'январь')">Январь</button>
  <button class="tablinks" onclick="openCity(event, 'февраль')">Февраль</button>
  <button class="tablinks" onclick="openCity(event, 'март')">Март</button>
  <button class="tablinks" onclick="openCity(event, 'апрель')">Апрель</button>
  <button class="tablinks" onclick="openCity(event, 'май')">Май</button>
  <button class="tablinks" onclick="openCity(event, 'июнь')">Июнь</button>
  <button class="tablinks" onclick="openCity(event, 'июль')">Июль</button>
  <button class="tablinks" onclick="openCity(event, 'август')">Август</button>
  <button class="tablinks" onclick="openCity(event, 'сентябрь')">Сентябрь</button>
  <button class="tablinks" onclick="openCity(event, 'октябрь')">Октябрь</button>
  <button class="tablinks" onclick="openCity(event, 'ноябрь')">Ноябрь</button>
  <button class="tablinks" onclick="openCity(event, 'декабрь')">Декабрь</button>
</div>
		<table class ="emp">
		<tr>
		<th>Имя</th>
		<th>Фамилия</th>
		<th>Возраст</th>
		<th>Должность</th>
	
		</tr> 		
		
		<tr>
		<c:forEach var="tempEmp" items="${employes}">
			<c:forEach var="ins" items="${tempEmp}">
			<td>${ins}</td>
			
			</c:forEach>
			
		</tr>
		</c:forEach>
		
		</table>
			
	





<table style="display:block;" id="DaysTable">
	<c:if test="${not empty daysMod}">
		<c:forEach var="day" items="${daysMod}">
			<th>${day}</th> 
		</c:forEach>
	
		
	</c:if>	
		
	<c:if test="${not empty markMod}">
		<tr>
		<c:forEach var="mark" items="${markMod}" varStatus="status">
			   <c:set var="days" value="${daysMod.size()}"/>
			   <c:if test ="${status.getIndex()%days==0}" >
			   		
			   		<tr> </tr>
			   		
			   		
			   </c:if>	
			   <td>${mark}</td>
			    
       </c:forEach>
       
      
       
       
       
		</tr>
	</c:if>	
		
		
</table>


</html>








