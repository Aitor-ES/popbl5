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
          <h3>${deck.name}</h3>
          <div class="d-flex justify-content-end">
            <a class="btn btn-lg btn-warning" href="${pageContext.request.contextPath}/deck/${deck.deckId}/form" role="button">
              <i class="fas fa-cog"></i> <spring:message code="action.edit"/></a>
            <a class="btn btn-lg btn-danger" href="${pageContext.request.contextPath}/deck/${deck.deckId}/delete" role="button">
              <i class="fas fa-trash-alt"></i> <spring:message code="action.delete"/></a>
          </div>
        </div>
        <div class="deck-cards row">
          <c:forEach items="${deck.deckCardMaps}" var="deckCardMap">
            <div class="col px-3 mb-5 d-flex justify-content-center">
              <div class="heroCardDeckFather" id="${deckCardMap.card.cardId}" draggable="true" ondragstart="drag(event)">
                <div class="heroCardDeck" draggable="false">
                  <div class="cardImg"
                    style="background-image: url('${pageContext.request.contextPath}/static/img/card/heroes/${deckCardMap.card.name}.png')"></div>
                  <img class="templateImg"
                    src="${pageContext.request.contextPath}/static/img/card/templates/${fn:toLowerCase(deckCardMap.card.type)}-template.png"
                    alt="edit icon">
                  <div class="titleArea">
                    <div class="heroName">${deckCardMap.card.name}</div>
                  </div>
                  <div class="stats">
                    <div class="ATK statName"><spring:message code="card.atk.physical" /></div>
                    <div class="DEF statName"><spring:message code="card.def.physical" /></div>
                    <div class="SPD statName"><spring:message code="card.spd" /></div>
                    <div class="HP statName"><spring:message code="card.hp" /></div>
                    <div class="MATK statName"><spring:message code="card.atk.magic" /></div>
                    <div class="MDEF statName"><spring:message code="card.def.magic" /></div>
                    <div class="ATK_VAL statValue"
                      style="color:var(--${fn:toLowerCase(deckCardMap.card.type)}-color);">${deckCardMap.card.atk}</div>
                    <div class="DEF_VAL statValue"
                      style="color:var(--${fn:toLowerCase(deckCardMap.card.type)}-color);">${deckCardMap.card.def}</div>
                    <div class="SPD_VAL statValue"
                      style="color:var(--${fn:toLowerCase(deckCardMap.card.type)}-color);">${deckCardMap.card.spd}</div>
                    <div class="HP_VAL statValue"
                      style="color:var(--${fn:toLowerCase(deckCardMap.card.type)}-color);">${deckCardMap.card.hp}</div>
                    <div class="MATK_VAL statValue"
                      style="color:var(--${fn:toLowerCase(deckCardMap.card.type)}-color);">${deckCardMap.card.magAtk}</div>
                    <div class="MDEF_VAL statValue"
                      style="color:var(--${fn:toLowerCase(deckCardMap.card.type)}-color);">${deckCardMap.card.magDef}</div>
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
                    <div class="abilityTitle"><spring:message code="card.ability" /></div>
                    <div class="abilityName" style="color:var(--${fn:toLowerCase(deckCardMap.card.type)}-color);">${deckCardMap.card.ability.name}</div>
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