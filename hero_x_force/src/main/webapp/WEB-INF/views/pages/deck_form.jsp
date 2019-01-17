<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Start: Deck list -->
<section id="deck-form">
  <div class="container-fluid">
  
    <!-- Start: Title & Info-->
    <div class="row px-sm-4 mt-4">
    
      <!-- Start: Title -->
      <div class="col-sm-6">
        <h2 class="title-style"><spring:message code="deck.form.title.create"/></h2>
      </div>
      
      <!-- Start: Info -->
      <div class="col-sm-6 mt-2 mt-sm-0 d-flex justify-content-end align-items-center">
        <p class="text-center m-0 p-1 modal-content"><span><i class="fas fa-info-circle"></i> <spring:message code="deck.form.instructions"/></span></p>
      </div>
    </div>
    <!-- End: Title & Buttons -->

    <!-- Start: Form -->
    <form name="userForm" action="${pageContext.request.contextPath}/deck/form/save" method='POST'>
      
      <!-- Start: ID and name inputs and buttons -->
      <div class="row px-5">
        <div class="col-4 d-flex justify-content-end align-items-center">
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text"><i class="fas fa-pen"></i></span>
            </div>
            <c:if test="${not empty deck}">
              <input type="text" class="form-control" name='deck_id'
                value="${deck.deckId}" required readonly>
            </c:if>
            <input type="text" class="form-control" name='deckName'
              placeholder="<spring:message code="deck.form.name.placeholder"/>" value="${deck.name}" required>
          </div>
        </div>
        <div class="col-8 d-flex justify-content-end align-items-center">
          <a class="btn btn-lg btn-warning mr-3" href="${pageContext.request.contextPath}/deck/list" role="button">
            <i class="fas fa-times-circle"></i><spring:message code="action.cancel"/></a>
          <button class="btn btn-lg btn-warning ml-3 mt-3 mb-3" type="submit" name="submit">
            <i class="fas fa-check-circle"></i><spring:message code="action.save" /></button>
        </div>  
      </div>
      <!-- End: ID and name inputs and buttons -->
      
      <!-- Start: card inputs and drop boxes -->
      <!-- Editing/Creating -->
      <c:choose>
        <c:when test="${not empty deck}">
          <div class="row mx-5 mt-2" id="selected-card-names">
            <c:forEach items="${deck.deckCardMaps}" var="deckCardMap">
              <input type="text" class="selected-card-name form-control col mx-3" id="selected-card-name-${deckCardMap.position}"
                name='selected-card-id-${deckCardMap.position}'
                placeholder="<spring:message code="deck.form.slot-${deckCardMap.position}.placeholder"/>"
                value="Hero #${deckCardMap.card.cardId}" required readonly>
            </c:forEach>
          </div>
          <div class="row mx-5 mt-2" id="selected-card-slots">
            <c:forEach items="${deck.deckCardMaps}" var="deckCardMap">
              <div class="selected-card-slot col bg-dark text-light rounded d-flex justify-content-center align-items-center"
                id="selected-card-slot-${deckCardMap.position}" ondragover="allowDrop(event)" ondrop="drop(event)"></div>
            </c:forEach>
          </div>
        </c:when>
        
        <c:otherwise>
          <div class="row mx-5 mt-2" id="selected-card-names">
            <c:forEach var="i" begin="1" end="5">
              <input type="text" class="selected-card-name form-control col mx-3" id="selected-card-name-${i}"
                name='selected-card-id-${i}'
                placeholder="<spring:message code="deck.form.slot-${i}.placeholder"/>" required readonly>
            </c:forEach>
          </div>
          <div class="row mx-5 mt-2" id="selected-card-slots">
            <c:forEach var="i" begin="1" end="5">
              <div class="selected-card-slot col bg-dark text-light rounded d-flex justify-content-center align-items-center"
                id="selected-card-slot-${i}" ondragover="allowDrop(event)" ondrop="drop(event)"></div>
            </c:forEach>
          </div>
        </c:otherwise>
      </c:choose>
      <!-- End: card inputs and drop boxes -->

    </form>
    <!-- End: Form -->

    <!-- Start: Card HTML -->
    <div class="row mx-3 mt-3" id="available-cards">
      <c:forEach items="${cardList}" var="card">
        <div class="col-sm-3 px-3 mb-5 d-flex justify-content-center" ondragover="allowDrop(event)" ondrop="drop(event)">
          <div class="heroCardFather" id="${card.cardId}" draggable="true" ondragstart="drag(event)">
            <div class="heroCard" draggable="false">
              <div class="cardImg"
                style="background-image: url('${pageContext.request.contextPath}/static/img/card/heroes/${card.name}.png')"></div>
              <img class="templateImg"
                src="${pageContext.request.contextPath}/static/img/card/templates/${fn:toLowerCase(card.type)}-template.png"
                alt="edit icon" draggable="false">
              <div class="titleArea">
                <div class="heroName">${card.name}</div>
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
                <div class="abilityName">${card.ability.name}</div>
              </div>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>
   <!-- End: Deck list -->
  
    <!-- Start: Top button -->
    <button class="button-style btn btn-lg btn-warning" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
    <!-- End: Top button -->
  
  </div>
</section>
<!-- End: Deck list -->

<!-- Reduce long card titles -->
<script>changeTitleFontSize();</script>