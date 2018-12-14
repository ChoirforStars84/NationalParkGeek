<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="/WEB-INF/jsp/common/header.jsp" />


<c:forEach var="park" items="${requestScope.parkList}">

	<div id="homePageimg">
		<ul style="list-style: none;">

			<li id="hpparkimage"><a
				href="http://localhost:8080/m3-java-capstone/detailPage?parkCode=${park.parkCode}"><img
					id="thisPark" src="img/parks/${park.parkCode}.jpg"></a></li>

		</ul>
	</div>

	<div id="hpparkinfo">
		<ul>
			<li id="homePageparkname"><a
				href="http://localhost:8080/m3-java-capstone/detailPage?parkCode=${park.parkCode}">${park.parkName}</a><br />

				<br />
			<li id="HomePageparkstate">State: ${park.state}<br /> <br /></li>
			<li id="HomePageparkdesc">${park.parkDescription}</li>

		</ul>
	</div>
	<br style="clear: left;" />
</c:forEach>

