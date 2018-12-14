<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Natural Park Geek</title>
<c:url value="/css/park.css" var="cssHref" />
<link rel="stylesheet" href="${cssHref}">
</head>

	<header>
		<c:url value="/" var="homePageHref" />
		<c:url value="/img/logo.png" var="logoSrc" />
		<a href="${homePageHref}"> <img src="${logoSrc}"
			alt="Natural Parks Geek logo" />
		</a>

	</header>
	<nav>
		<h2>Explore The National Parks</h2>
		
		<ul>
			<li><a href="homePage">Home</a></li>
			<li><a href="surveyPage">Survey</a></li>
			<li><a href="favoritesPage">Favorites</a></li>
			<br/>
			<br/>
			<br/>

		</ul>
	</nav>