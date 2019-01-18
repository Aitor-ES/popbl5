<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Start: Deck List -->
<section id="heroes">
  <div class="container-fluid">
  
    <!-- Start: Title -->
    <div class="row px-sm-4 pt-4">
      <div class="col">
        <h2 class="title-style"> <spring:message code="heroes.title" /> </h2>
      </div>
    </div>
    <!-- End: Title -->
    
    <!-- Start: Hero list -->
    <div class="row px-5 my-3">
      <c:forEach items="${heroesList}" var="card">
        <div class="col my-4 d-flex justify-content-center">
          <div class="heroCardFather" id="${card.cardId}">
            <div class="heroCard">
              <div class="cardImg"
                style="background-image: url('${pageContext.request.contextPath}/${card.img}')">
              </div>
              <a href="${pageContext.request.contextPath}/card/${card.cardId}/data">
                <img class="templateImg"
                  src="${pageContext.request.contextPath}/static/img/card/templates/${fn:toLowerCase(card.type)}-template.png"
                  alt="edit icon">
              </a>
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
    <!-- End: Hero list -->
    
    <!-- Start: Top button -->
    <button class="button-style btn btn-lg btn-warning" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
    <!-- End: Top button -->
  
  </div>
</section>
<!-- End: Heroes -->

<!-- Reduce long card titles -->
<script>changeTitleFontSize();</script>