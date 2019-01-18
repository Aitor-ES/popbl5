<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Start: Deck list -->
<section id="deck-list">
  <div class="container-fluid">
  
    <!-- Start: Title & Button -->
    <div class="row px-sm-4 pt-4">
      
      <!-- Title -->
      <div class="col-8 col-sm-10">
        <h2 class="title-style"><spring:message code="deck.list.title"/></h2>
      </div>
      
      <!-- Button -->
      <div class="col-4 col-sm-2 d-flex justify-content-end align-items-center">
        <a class="button-style btn btn-lg btn-warning" href="${pageContext.request.contextPath}/deck/form" role="button">
          <i class="fas fa-plus"></i> <spring:message code="action.new"/>
        </a>
      </div>
    </div>

    <!-- Start: Deck list -->
    <c:forEach items="${deckList}" var="deck">
      <div class="card mx-3 mx-sm-5 mt-4 mb-5">
      
        <!-- Deck header -->
        <div class="card-header p-3 bg-dark text-light">
          <div class="row ">
          
            <!-- Deck name -->
            <div class="col-8 p-0 d-flex align-items-center">
          	   <p class="mb-0">${deck.name}</p>
            </div>
            
            <!-- Button -->
            <div class="col-4 p-0 d-flex justify-content-end">
              <a class="button-style btn btn-lg btn-warning" href="${pageContext.request.contextPath}/deck/${deck.deckId}/form" role="button">
                <i class="fas fa-cog"></i> <spring:message code="action.edit"/>
              </a>
            </div>
          </div>
        </div>
        
        <!-- Deck body -->
        <div class="card-body">
          <div class="row mx-0">
            <c:forEach items="${deck.deckCardMaps}" var="deckCardMap">
            
              <!-- Card HTML -->
              <div class="col my-3 d-flex justify-content-center">
                <div class="heroCardDeckFather" draggable="false" ondragstart="drag(event)">
                  <div class="heroCardDeck" draggable="false">
                    <div class="cardImg" 
                style="background-image: url('${pageContext.request.contextPath}/${deckCardMap.card.img}')">
                    </div>
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
                      <div class="ATK_VAL statValue" style="color:var(--${fn:toLowerCase(deckCardMap.card.type)}-color);">${deckCardMap.card.atk}</div>
                      <div class="DEF_VAL statValue" style="color:var(--${fn:toLowerCase(deckCardMap.card.type)}-color);">${deckCardMap.card.def}</div>
                      <div class="SPD_VAL statValue" style="color:var(--${fn:toLowerCase(deckCardMap.card.type)}-color);">${deckCardMap.card.spd}</div>
                      <div class="HP_VAL statValue" style="color:var(--${fn:toLowerCase(deckCardMap.card.type)}-color);">${deckCardMap.card.hp}</div>
                      <div class="MATK_VAL statValue" style="color:var(--${fn:toLowerCase(deckCardMap.card.type)}-color);">${deckCardMap.card.magAtk}</div>
                      <div class="MDEF_VAL statValue" style="color:var(--${fn:toLowerCase(deckCardMap.card.type)}-color);">${deckCardMap.card.magDef}</div>
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
      </div>
    </c:forEach>
    <!-- End: Deck list -->
  
    <!-- Start: Top button -->
    <button class="button-style btn btn-lg btn-warning" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
    <!-- End: Top button -->
  
  </div>
</section>
<!-- End: Deck list -->

<!-- Reduce long card titles -->
<script>changeTitleFontSize();</script>