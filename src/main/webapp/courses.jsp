<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	<jsp:include page="header.jsp" />  
</head>
<body>
<br>
	<div id="searchDiv" style="right: 50px;">
		<form id="courses" action="courses" method="post">
			<input type="text" name="searchQuery" placeholder="Nombre del curso" required> 
			<input type="hidden" name="accessToken" value="${accessToken}"/> 
			<input type="submit" name="searchBtn" class="button" title="search" value="Buscar">
		</form>
	</div>
<fieldset id="Courses">
<br><br>
<div class="row" align="center">
	<c:forEach items="${courses}" var="course">
  <div class="col-sm-6" align="center">
	<div class="card mb-3" style="max-width: 540px;height: 350px">
  <div class="row no-gutters" align="center">
      <div class="card-body">
      <br>
        <h5 class="card-title"> ${course.title}</h5>
       <p><small>Precio: ${course.price}€</small></p>
      </div>
    <div align="center" style="margin: 20px;text-align: center">
     <p class="card-text">${course.summary}</p>
     <a href="http://studentalks.appspot.com/${course.type}Course?code=${course.code}&accessToken=${accessToken}" class="button">Ver curso</a>
     </div>
  </div>
</div>
</div>
	</c:forEach>
	</div>
	<c:if test="${notResult}">
	<div class="alert alert-danger" role="alert">
 	 La búsqueda no obtuvo ningún resultado.
	<br><br>
	Sugerencias:
	<br>
	- Comprueba que todas las palabras están escritas correctamente.<br>
	- Intenta usar otras palabras.<br>
	- Intenta usar palabras más generales.
	
	</div>
	</c:if>
</fieldset>


</body>
</html>