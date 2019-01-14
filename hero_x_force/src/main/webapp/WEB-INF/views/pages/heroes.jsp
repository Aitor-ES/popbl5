<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:set var="count" value="0" scope="page" />
<h2>
	<spring:message code="heroes.title" />
</h2>
<div id="charts">
	<c:forEach items="${heroesList}" var="card">
		<div class="heroCardFather" id="card${card.card_id }">
			<div class="heroCard">
				<div class="cardImg" style="background-image: url('${pageContext.request.contextPath}/static/img/card/heroes/${card.name}.png')"></div>
				<img class="templateImg"
					src="${pageContext.request.contextPath}/static/img/card/templates/darkness-template.png"
					alt="edit icon">
				<div class="titleArea">
					<div class="heroName" id="${card.name }">${card.name}</div>
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
					<div class="abilityName">${card.ability}</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

