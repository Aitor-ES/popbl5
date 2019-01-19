<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Start: Deck List -->
<section id="deck-form">
  <div class="container-fluid">
  
    <!-- Start: Title & Info -->
    <div class="row px-sm-4 mt-4">
    
      <!-- Title -->
      <div class="col-10 col-sm-4 order-first">
        <c:choose>
          <c:when test="${action == 'create'}">
            <h2 class="title-style"><spring:message code="deck.form.title.create"/></h2>
          </c:when>
          <c:otherwise>
            <h2 class="title-style"><spring:message code="deck.form.title.edit"/></h2>
          </c:otherwise>
        </c:choose>
      </div>
      
      <!-- Delete -->
      <c:if test="${action == 'edit'}">
        <div class="col-2 col-sm-2 d-flex order-sm-last justify-content-end align-items-center">
          <form name="deckDeleteForm" action="${pageContext.request.contextPath}/deck/delete" method='POST'>
            <input class="form-control" id="deleteId" type="hidden" name='deleteId' value="${deck.deckId}">
            <button class="button-style btn btn-lg btn-danger ml-3" type="submit" name="submit">
              <i class="fas fa-trash"></i> <spring:message code="action.delete" />
            </button>
          </form>
        </div>
      </c:if>
      
      <!-- Info -->
      <div class="col-sm-6 mt-2 mt-sm-0 d-flex justify-content-center align-items-center">
        <p class="text-center m-0 p-1 modal-content"><span><i class="fas fa-info-circle"></i> <spring:message code="deck.form.instructions"/></span></p>
      </div>
      
    </div>
    <!-- End: Title & Info -->

    <!-- Start: Form -->
    <div class="card mx-3 mx-sm-5 mt-4 mb-5 sticky">
      <form name="deckCreateForm" action="${pageContext.request.contextPath}/deck/form/save" method='POST'>
        
        <!-- Form Header -->
        <div class="card-header p-3 bg-dark text-light">
          <div class="row ">
          
            <!-- Deck name -->
            <div class="col-sm-6 col-lg-4 p-0 d-flex align-items-center">
              <div class="input-group">
                <div class="input-group-prepend">
                  <span class="input-group-text"><i class="fas fa-pen"></i></span>
                </div>
                <c:if test="${not empty deck}">
                  <input class="form-control text-center" id="deckNumber" type="text" name='deckId' value="${deck.deckId}" required readonly>
                </c:if>
                <input type="text" class="form-control" name='deckName' placeholder="<spring:message code="deck.form.name.placeholder"/>" value="${deck.name}" required>
              </div>
            </div>
            
            <!-- Buttons -->
            <div class="col-sm-6 col-lg-8 p-0 mt-3 mt-sm-0 d-flex justify-content-between justify-content-sm-end">
              <a class="button-style btn btn-lg btn-warning" href="${pageContext.request.contextPath}/deck/list" role="button">
                <i class="fas fa-times-circle"></i> <spring:message code="action.cancel"/>
              </a>
              <button class="button-style btn btn-lg btn-warning ml-3" type="submit" name="submit">
                <i class="fas fa-check-circle"></i> <spring:message code="action.save" />
              </button>
            </div>
          </div>
        </div>
        
        <!-- Form Body -->
        <div class="card-body px-1 px-sm-0 pb-1">
          <c:choose>
          
            <c:when test="${not empty deck}">
              <div class="row" id="selected-card-names">
                <c:forEach items="${deck.deckCardMaps}" var="deckCardMap">
                  <input type="text" class="selected-card-name form-control col mx-2 mx-sm-3 text-center" id="selected-card-name-${deckCardMap.position}"
                    name='selected-card-id-${deckCardMap.position}'
                    placeholder="<spring:message code="deck.form.slot-${deckCardMap.position}.placeholder"/>"
                    value="#${deckCardMap.card.cardId}" required onkeypress="return false;">
                </c:forEach>
              </div>
              <div class="row" id="selected-card-slots">
                <c:forEach items="${deck.deckCardMaps}" var="deckCardMap">
                  <div class="selected-card-slot col p-0 bg-dark text-light rounded d-flex justify-content-center align-items-center"
                    id="selected-card-slot-${deckCardMap.position}" ondragover="allowDrop(event)" ondrop="drop(event)"></div>
                </c:forEach>
              </div>
            </c:when>
            
            <c:otherwise>
              <div class="row" id="selected-card-names">
                <c:forEach var="i" begin="1" end="5">
                  <input type="text" class="selected-card-name form-control col mx-2 mx-sm-3 text-center" id="selected-card-name-${i}"
                    name="selected-card-id-${i}"
                    placeholder="<spring:message code="deck.form.slot-${i}.placeholder"/>" required onkeypress="return false;">
                </c:forEach>
              </div>
              <div class="row" id="selected-card-slots">
                <c:forEach var="i" begin="1" end="5">
                  <div class="selected-card-slot col p-0 bg-dark text-light rounded d-flex justify-content-center align-items-center"
                    id="selected-card-slot-${i}" ondragover="allowDrop(event)" ondrop="drop(event)"></div>
                </c:forEach>
              </div>
            </c:otherwise>
          </c:choose>
        </div>
      </form>
    </div>
    <!-- End: Form -->

    <!-- Start: Card HTML -->
    <div class="row px-5">
      <c:forEach items="${cardList}" var="card">
        <div class="col my-4 d-flex justify-content-center" ondragover="allowDrop(event)" ondrop="drop(event)">
          <div class="heroCardFather" id="${card.cardId}" draggable="true" ondragstart="drag(event)">
            <div class="heroCard" draggable="false">
              <div class="cardImg" 
                style="background-image: url('${pageContext.request.contextPath}/${card.img}')">
              </div>
              <img class="templateImg" 
                src="${pageContext.request.contextPath}/static/img/card/templates/${fn:toLowerCase(card.type)}-template.png"
                alt="edit icon" draggable="false" onContextMenu="return false;">
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
                <div class="abilityName" style="color:var(--${fn:toLowerCase(card.type)}-color);">${card.ability.name}</div>
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
<!-- End: Deck Form -->

<!-- Reduce long card titles -->
<script>changeTitleFontSize();</script>