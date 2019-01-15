<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

    <!--c:forEach items="${deckList}" var="deck"-->
    <div class="deck-list-data-box">
      <div class="row deck-list-title-row mr-3">
          <h3><a class="deck-title" href="${pageContext.request.contextPath}/deck/data">Deck name</a></h3>
          <div class="d-flex justify-content-end">
            <a class="btn btn-lg btn-warning" href="${pageContext.request.contextPath}/deck/${deck.deck_id}/form" role="button">
              <i class="fas fa-cog"></i> <spring:message code="action.edit"/>
            </a>
          </div>
        </div> 
      <div class="deck-cards row">
        <!--c:forEach items="${deck.cardList}" var="card"-->
          <!--div class="col">
            <img src="${card.img}" alt="${card.alt}">
        </div-->
          <div class="col">
			<a class ="deck-list-card" href="${pageContext.request.contextPath}/card/data">
              <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
                alt="Hero X-Force Logo">
            </a>        
           <h3><a class="deckTitle" href="${pageContext.request.contextPath}/deck/${deck.deck_id}/data">${deck.name}</a></h3>
          </div> 
        <div class="deck-cards row">
          <c:forEach items="${deck.deckCardMaps}" var="deckCardMap">
            <div class="col">
              <img src="${deckCardMap.card.img}" alt="${deckCardMap.card.alt}">
            </div>
          </c:forEach>
        </div>
      </div>
    </div>
  </div>
  
  <!-- Start: Back to top button -->
  <button class="btn btn-lg btn-primary" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
  <!-- End: Back to top button -->
</section>