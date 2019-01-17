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
    <div class="row mx-3 mt-3">
      <c:forEach items="${heroesList}" var="card">
        <div class="col-sm-3 px-3 mb-5 d-flex justify-content-center">
          <div class="heroCardFather" id="${card.cardId}">
            <div class="heroCard">
              <div class="cardImg"
                style="background-image: url('${pageContext.request.contextPath}/static/img/card/heroes/${card.name}.png')"></div>
              <a href="${pageContext.request.contextPath}/card/${card.cardId}/data">
                <img class="templateImg"
                src="${pageContext.request.contextPath}/static/img/card/templates/${fn:toLowerCase(card.type)}-template.png"
                alt="edit icon">
              </a>
              <div class="titleArea">
                <div class="heroName" id="${card.name}">${card.name}</div>
              </div>
              <div class="stats">
                <div class="ATK statName"><spring:message code="card.atk.physical" /></div>
                <div class="DEF statName"><spring:message code="card.def.physical" /></div>
                <div class="SPD statName"><spring:message code="card.spd" /></div>
                <div class="HP statName"><spring:message code="card.hp" /></div>
                <div class="MATK statName"><spring:message code="card.atk.magic" /></div>
                <div class="MDEF statName"><spring:message code="card.def.magic" /></div>
                <div class="ATK_VAL statValue" style="color:var(--${fn:toLowerCase(card.type)}-color);">${card.atk}</div>
                <div class="DEF_VAL statValue" style="color:var(--${fn:toLowerCase(card.type)}-color);">${card.def}</div>
                <div class="SPD_VAL statValue" style="color:var(--${fn:toLowerCase(card.type)}-color);">${card.spd}</div>
                <div class="HP_VAL statValue" style="color:var(--${fn:toLowerCase(card.type)}-color);">${card.hp}</div>
                <div class="MATK_VAL statValue" style="color:var(--${fn:toLowerCase(card.type)}-color);">${card.magAtk}</div>
                <div class="MDEF_VAL statValue" style="color:var(--${fn:toLowerCase(card.type)}-color);">${card.magDef}</div>
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
                <div class="abilityTitle"><spring:message code="card.ability" /></div>
                <div class="abilityName" style="color:var(--${fn:toLowerCase(card.type)}-color);">${card.ability.name}</div>
              </div>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
  
  <!-- Start: Back to top button -->
  <button class="btn btn-lg btn-primary" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
  <!-- End: Back to top button -->
</section>

<!-- Reduce long card titles -->
<script>changeTitleFontSize();</script>