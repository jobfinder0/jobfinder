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
     <h5 class="title" style="font-weight: bold"><a href="${course.url}"> ${course.name}</a> </h5>
     <p class="card-text"><small class="text-muted">Autor: ${course.teacher.name}    -    Dificultad: ${course.difficultyLevel}    -    Precio: ${course.price.EUR}€</small></p>
	</div>
	<br>
	<div align="justify">
     
     <p class="card-text">${course.description}</p>
</div>
  		  
   
</fieldset>
<div align="center">
<video controls autoplay>
<source src="${course.videoUrl}" type="video/mp4">
</video>
</div>
<br>
<div id="searchDiv" style="right: 50px;">
		<form id="ugcPost" action="ugcPost" method="post" >
		
			<input type="text" class="form-control" name="shareCommentary" placeholder="Comparte tu opinión sobre este curso."/> 
			<input type="hidden" name="title" value="${course.name}"/> 
			<input type="hidden" name="accessToken" value="${accessToken}"/> 
			<input type="hidden" name="url" value="${course.url}"/>  
			<input type="hidden" name="web" value="https://www.tutellus.com"/> 
			<br>
			<input type="submit" name="postBtn" class="button" title="Publicar" value="Publicar en linkedIn">
		</form>
	</div>
   
   <br><br>
</body>
</html>