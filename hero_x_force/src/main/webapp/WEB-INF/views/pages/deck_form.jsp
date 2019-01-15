<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<section id="deck-form">
  <div class="container-fluid">
    <div class="row px-4 pt-4">
      <div class="col">
        <h2 class="title-style"><spring:message code="deck.form.title.create"/></h2>       
      </div>
    </div>
    
    <form name="userForm" action="${pageContext.request.contextPath}/profile/form" method='POST'>
      <div class="row px-5">
        <div class="col-4 d-flex justify-content-end align-items-center">
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text"><i class="fas fa-pen"></i></span>
            </div>
            <input type="text" class="form-control" name='deckName' placeholder="<spring:message code="deck.form.name"/>" required>
          </div>
        </div>
        <div class="col-8 d-flex justify-content-end align-items-center">
          <a class="btn btn-lg btn-warning mr-3" href="${pageContext.request.contextPath}/deck/list" role="button">
            <i class="fas fa-times-circle"></i> <spring:message code="action.cancel"/>
          </a>
          <button class="btn btn-lg btn-warning ml-3 mt-3 mb-3" type="submit" name="submit">
            <i class="fas fa-check-circle"></i> <spring:message code="action.save" />
          </button>
        </div>  
      </div>
      
      <div class="row mx-5 mt-2" id="selected-cards">
        <div class="selected-card-slot col bg-dark text-light rounded d-flex justify-content-center align-items-center"
          ondragover="allowDrop(event)" ondrop="drop(event)"></div>
        <div class="selected-card-slot col bg-dark text-light rounded d-flex justify-content-center align-items-center"
          ondragover="allowDrop(event)" ondrop="drop(event)"></div>
        <div class="selected-card-slot col bg-dark text-light rounded d-flex justify-content-center align-items-center"
          ondragover="allowDrop(event)" ondrop="drop(event)"></div>
        <div class="selected-card-slot col bg-dark text-light rounded d-flex justify-content-center align-items-center"
          ondragover="allowDrop(event)" ondrop="drop(event)"></div>
        <div class="selected-card-slot col bg-dark text-light rounded d-flex justify-content-center align-items-center"
          ondragover="allowDrop(event)" ondrop="drop(event)"></div>
      </div>
    </form>
    
    <div class="row p-5" id="available-cards">
      <c:forEach items="${cardList}" var="card">
        
        <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
          <div class="heroCardFather" id="card${card.card_id }" draggable="true" ondragstart="drag(event)">
            <div class="heroCard" draggable="false">
              <div class="cardImg"
                style="background-image: url('${pageContext.request.contextPath}/static/img/card/heroes/${card.name}.png')"></div>
              <a href="${pageContext.request.contextPath}/card/${card.card_id}/data">
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
                <c:forEach var="i" begin="1" end="${card.stars}">
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
      </c:forEach>
    </div>
  </div>
  
  <!-- Start: Back to top button -->
  <button class="btn btn-lg btn-primary" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
  <!-- End: Back to top button -->
</section>