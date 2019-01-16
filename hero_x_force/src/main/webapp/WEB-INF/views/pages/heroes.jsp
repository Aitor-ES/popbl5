<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<section id="tournament_list">
  <div class="container-fluid">
    <div class="row px-4 pt-4">
      <div class="col">
        <h2 class="title-style">
          <spring:message code="heroes.title" />
        </h2>
      </div>
    </div>
    <div class="row mt-4 ml-5">
      <c:forEach items="${heroesList}" var="card">
        <div class="col-sm-4 py-5 px-3">
          <div class="heroCardFather" id="card${card.card_id }">
            <div class="heroCard">
              <div class="cardImg"
                style="background-image: url('${pageContext.request.contextPath}/static/img/card/heroes/${card.name}.png')"></div>
              <a href="${pageContext.request.contextPath}/card/${card.card_id}/data">
                <img class="templateImg"
                src="${pageContext.request.contextPath}/static/img/card/templates/${fn:toLowerCase(card.type)}-template.png"
                alt="edit icon">
              </a>
              <div class="titleArea">
              <script>changeTitleFontSize();</script>
                <div class="heroName" id="${card.name}">${card.name}</div>
              </div>
              <div class="stats">
                <div class="ATK statName">ATK</div>
                <div class="DEF statName">DEF</div>
                <div class="SPD statName">SPD</div>
                <div class="HP statName">HP</div>
                <div class="MATK statName">MATK</div>
                <div class="MDEF statName">MDEF</div>
                <div class="ATK_VAL statValue" style="color:var(--${fn:toLowerCase(card.type)}-color);">${card.atk}</div>
                <div class="DEF_VAL statValue" style="color:var(--${fn:toLowerCase(card.type)}-color);">${card.def}</div>
                <div class="SPD_VAL statValue" style="color:var(--${fn:toLowerCase(card.type)}-color);">${card.spd}</div>
                <div class="HP_VAL statValue" style="color:var(--${fn:toLowerCase(card.type)}-color);">${card.hp}</div>
                <div class="MATK_VAL statValue" style="color:var(--${fn:toLowerCase(card.type)}-color);">${card.mag_atk}</div>
                <div class="MDEF_VAL statValue" style="color:var(--${fn:toLowerCase(card.type)}-color);">${card.mag_def}</div>
              </div>
              <div class="sagaArea">
                <div class="saga">${card.saga}</div>
              </div>
              <div class="levelArea">
                <c:forEach var="i" begin="1" end="${card.stars}">
                  <div class="levelStar"></div>
                </c:forEach>
              </div>
              <div class="abilityArea">
                <div class="abilityTitle">SPECIAL ABILITY:</div>
                <div class="abilityName" style="color:var(--${fn:toLowerCase(card.type)}-color);">${card.ability.name}</div>
              </div>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
</section>