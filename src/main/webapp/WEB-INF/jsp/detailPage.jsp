<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:import url="/WEB-INF/jsp/common/header.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body>
<div class="detail_park_info_container">
<div class="detail_park_header">
<span class="detail_park_info" id="detailparkname"><strong>${park.parkName}</strong></span>
<br/>
<br/>
<span class="detail_park_info" id="parkquote">${park.inspirationalQuote}</span>
<br/>
<span class="detail_park_info" id="quotesource">--  ${park.quoteSource}</span>
<br/>
<br/>
<br/>
<br/>
<span class="detail_park_info" id="detailparkimage"><img id="thisPark" src="img/parks/${park.parkCode}.jpg"></span>
<br/>

<br/>
<br/>

<br/>
<br/>
<span class="detail_park_info" id="detaildescription">Park Description: <br/>${park.parkDescription}</span>
<br/>
</div>
<br/>
<br/>
<div class="detail_park_stats_container">
<span class="detail_park_stats" id="statsheader">Park Statistics:</span>
<br/>
<span class="detail_park_stats" id="acreage">Acreage: ${park.acreage} acres</span>
<br/>
<span class="detail_park_stats" id="detailclimate">Climate: ${park.climate}</span>
<br/>
<span class="detail_park_stats" id="elevation">Elevation: ${park.elevationInFeet} ft.</span>
<br/>
<span class="detail_park_stats" id="milesoftrail">Miles of Trail: ${park.milesOfTrail}</span>
<br/>
<span class="detail_park_stats" id="numofspecies">Number of Animal Species: ${park.numberOfAnimalSpecies}</span>
<br/>
<span class="detail_park_stats" id="yearfounded">Year Founded: ${park.yearFounded}</span>
<br/>
<span class="detail_park_stats" id="detailstate">State: ${park.state}</span>
<br/>
<span class="detail_park_stats" id="numofcampsites">Number of Camp Sites: ${park.numberOfCampSites}</span>
<br/>
<span class="detail_park_stats" id="annualvisitors">Number of Annual Visitors: ${park.annualVisitorCount}</span>
<br/>
</div>
<span class="detail_park_info" id="entryfee">Park Entry Fee: ${park.entryFee}</span>
</div>
<div>

<div class="weatherSectionContainer">
<p id="weatherTitle">Five Day Weather Forecast for ${park.parkName}</p>
</div>

<table>

<form id="setTempScaleForm" name="setTempScaleForm" action="/detailPage" method="POST">
<label name="tempScaleLabel">
<input type="radio" name="setTempScale" value="Celsius">Celcius</input>
<input type="radio" name="setTempScale" value="Fahrenheit">Fahrenheit</input>
</label>
</form>

        <c:forEach var="weather" items="${requestScope.weather}">
<c:set var="weatherPicRef" value="${weather.forecast}"/>
<tr>
<div class="weatherItem" id="dayTitle">${weather.displayForecastValue}</div>
</tr>
<tr>
<div class="weatherImageContainer"></div><img id="weatherPic" src="img/weather/${weather.picAccessForecast}.png"/></div>
</tr>
<tr>
<div class="weatherItem" id="lowFahrenheit">Low ${weather.lowFahrenheit}&#176F</div>
</tr>
<tr>
<div class="weatherItem" id="highFahrenheit">High ${weather.highFahrenheit}&#176F</div>
</tr>
<tr>
<div class="weatherItem" id="forecast">${weather.displayForecast}</div>
</tr>
<br/>

</c:forEach>
        
</table>






</body>
</html>