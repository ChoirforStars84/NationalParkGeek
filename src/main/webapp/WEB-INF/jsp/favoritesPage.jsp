<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />
<c:forEach var="favorite" items="${requestScope.favorites}">


	<div id="Favparkinfo">
		
			
			<div id="parkName"><strong> ${favorite.parkName}</strong> </div>
			<br/>
			<div id="surveyCount">Number of surveys submitted for this Park: ${favorite.surveyCount} </div>
			<br />
			<br/>
			
		
			<img id="thisFavorite" src="img/parks/${favorite.parkCode}.jpg">
				
			
			
			<br />
			<br />
		
	</div>
	<br style="clear: left;" />
</c:forEach>

	

	

	
	


	
