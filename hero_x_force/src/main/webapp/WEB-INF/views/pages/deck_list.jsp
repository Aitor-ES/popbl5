<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<section id="deck-list">
  <div class="container-fluid">
    <div class="row px-4 pt-4">
      <div class="col-10">
        <h2 class="title-style"><spring:message code="deck.list.title"/></h2>
      </div>
      <div class="col-2 d-flex justify-content-end align-items-center">
        <a class="btn btn-lg btn-warning" href="${pageContext.request.contextPath}/deck/form" role="button">
          <i class="fas fa-plus"></i> <spring:message code="action.new"/>
        </a>
      </div>
    </div>

    <c:forEach items="${deckList}" var="deck">
      <div class="deck-list-data-box">
        <div class="row deck-list-title-row mr-3">
          <h3><a class="deck-title" href="${pageContext.request.contextPath}/deck/data">${deck.name}</a></h3>
          <div class="d-flex justify-content-end">
            <a class="btn btn-lg btn-warning" href="${pageContext.request.contextPath}/deck/${deck.deck_id}/form" role="button">
              <i class="fas fa-cog"></i> <spring:message code="action.edit"/>
            </a>
          </div>
        </div>
        <div class="deck-cards row">
          <c:forEach items="${deck.deckCardMaps}" var="deckCardMap">
            <div class="col px-3 mb-5 d-flex justify-content-center">
              <div class="heroCardDeckFather" id="${deckCardMap.card.card_id}" draggable="true" ondragstart="drag(event)">
                <div class="heroCardDeck" draggable="false">
                  <div class="cardImg"
                    style="background-image: url('${pageContext.request.contextPath}/static/img/card/heroes/${deckCardMap.card.name}.png')"></div>
                  <img class="templateImg"
                    src="${pageContext.request.contextPath}/static/img/card/templates/${fn:toLowerCase(deckCardMap.card.type)}-template.png"
                    alt="edit icon">
                  <div class="titleArea">
                    <div class="heroName" id="${deckCardMap.card.name}">${deckCardMap.card.name}</div>
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
                    <div class="saga">${deckCardMap.card.saga}</div>
                  </div>
                  <div class="levelArea">
                    <c:forEach var="i" begin="1" end="${deckCardMap.card.stars}">
                      <div class="levelStar"></div>
                    </c:forEach>
                  </div>
                  <div class="abilityArea">
                    <div class="abilityTitle">SPECIAL ABILITY:</div>
                    <div class="abilityName">${deckCardMap.card.ability.name}</div>
                  </div>
                </div>
              </div>
            </div>
          </c:forEach>
        </div>
      </div>
    </c:forEach>
  </div>
  
  <!-- Start: Back to top button -->
  <button class="btn btn-lg btn-primary" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
  <!-- End: Back to top button -->
</section>

<!-- Reduce long card titles -->
<script>changeTitleFontSize();</script>