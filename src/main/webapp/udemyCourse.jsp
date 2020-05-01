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
<fieldset id="Course" style="align-content: center;padding: 50px;">
	<div align="center">
     <h5 class="title" style="font-weight: bold"><a href="https://www.udemy.com${course.url}"> ${course.title}</a> </h5>
     <p class="card-text"><small class="text-muted">Precio: ${course.price}</small></p>
	
	</div>
	<div align="center">
	<img src="${course.image240x135}">
	</div>
	<br>
	<div align="justify">
     <p class="card-text">${course.headline}</p>
</div>
<br>

<div id="searchDiv" style="right: 50px;">
		<form id="ugcPost" action="ugcPost" method="post" >
			<input type="text" class="form-control" name="shareCommentary" placeholder="Comparte tu opinión sobre este curso."/> 
			<input type="hidden" name="accessToken" value="${accessToken}"/> 
			<input type="hidden" name="title" value="${course.title}"/> 
			<input type="hidden" name="url" value="https://www.udemy.com${course.url}"/>  
			<input type="hidden" name="web" value="https://www.udemy.com"/> 
			<br>
			<input type="submit" name="postBtn" class="button" title="Publicar" value="Publicar en linkedIn">
		</form>
	</div>
   <br><br>
</fieldset>
</body>
</html>