<!-- Page directives -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions"  %>

<!-- Spring tags -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!-- JSTL tags -->
<!--%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%-->

<section id="card-data">
  <div class="container-fluid">
    <div class="row">
      <div class="col-4">
        <div class="heroCardFather" id="card${card.card_id }">
			<div class="heroCard">
				<div class="cardImg" style="background-image: url('${pageContext.request.contextPath}/static/img/card/heroes/${card.name}.png')"></div>
				<a 	href="${pageContext.request.contextPath}/card/${card.card_id}/data">
				<img class="templateImg"
					src="${pageContext.request.contextPath}/static/img/card/templates/${fn:toLowerCase(card.type)}-template.png"
					alt="edit icon">
				</a>
				<div class="titleArea">
					<div class="heroName" id="${card.name}">${card.name}</div>
				</div>
				<div class="stats">
					<div class="ATK statName">ATK</div>
					<div class="DEF statName">DEF</div>
					<div class="SPD statName">SPD</div>
					<div class="HP statName">HP</div>
					<div class="MATK statName">MATK</div>
					<div class="MDEF statName">MDEF</div>
					<div class="ATK_VAL statValue">${card.atk}</div>
					<div class="DEF_VAL statValue">${card.def}</div>
					<div class="SPD_VAL statValue">${card.spd}</div>
					<div class="HP_VAL statValue">${card.hp}</div>
					<div class="MATK_VAL statValue">${card.mag_atk}</div>
					<div class="MDEF_VAL statValue">${card.mag_def}</div>
				</div>
				<div class="sagaArea">
					<div class="saga">${card.saga}</div>
				</div>
				<div class="levelArea">
					<c:forEach var="i" begin="0" end="${card.stars}">
						<div class="levelStar"></div>
					</c:forEach>
				</div>
				<div class="abilityArea">
					<div class="abilityTitle">SPECIAL ABILITY:</div>
					<div class="abilityName">${card.ability.name}</div>
				</div>
			</div>
		</div>
      </div>
      <div class="col-3">
        <div><h2>Card</h2></div>
        <div><spring:message code="card.data.saga"/>: ${card.saga}</div>
        <div><spring:message code="card.data.type"/>: ${card.type}</div>
        <div><spring:message code="card.data.ability"/>: ${card.ability.name}</div>
        <div><p>${card.ability.description}</p></div>
      </div>
      <div class="col-1"><a class="btn btn-primary" href="#" role="button"><spring:message code="action.edit"/></a></div>
    </div>
  </div>
  
  <div class="container-fluid">
    <h3><spring:message code="deck.data.stats.title"/></h3>
    <div class="row">
      <div class="col-2"><spring:message code="card.data.stats.table.stats.heading"/></div>
      <div class="col-4"><spring:message code="card.data.stats.table.value.heading"/></div>
      <div class="col-4"><spring:message code="card.data.stats.table.ranking.heading"/></div>
      <div class="col-2 radar-col"><spring:message code="card.data.stats.table.balance.heading"/></div>
    </div>
    <div class="row">
      <div class="col-2">
        <div><spring:message code="card.data.stats.table.stats.hp"/></div>
        <div><spring:message code="card.data.stats.table.stats.attack"/></div>
        <div><spring:message code="card.data.stats.table.stats.defense"/></div>
        <div><spring:message code="card.data.stats.table.stats.magicAttack"/></div>
        <div><spring:message code="card.data.stats.table.stats.magicDefense"/></div>
        <div><spring:message code="card.data.stats.table.stats.speed"/></div>
      </div>
      <div class="col-4">
        <div>${card.hp}</div>
        <div>${card.atk}</div>
        <div>${card.def}<div>
        <div>${card.mag_atk}</div>
        <div>${card.mag_def}</div>
        <div>${card.spd}</div>
      </div>
      <div class="col-4">
        <div>Span 6</div>
        <div>Span 6</div>
        <div>Span 6</div>
        <div>Span 6</div>
        <div>Span 6</div>
        <div>Span 6</div>
      </div>
      <div class="col-2 radar-col">
         <div id="chart" class="radar-chart">
 
        <script>
          var config = {
              w: 150,
              h: 150,
              maxValue: 100,
              levels: 5,
              fontFamily: "orbitron",
              ExtraWidthX: 150
          }
          
          //Call function to draw the Radar chart
          d3.json("${pageContext.request.contextPath}/static/js/data.json", function(error, data) {
              if (error) throw error;
              radar_chart.draw("#chart", data, config);
          });
        </script>
       </div>
      </div>
    </div>
  </div>
  
</section>