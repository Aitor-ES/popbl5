<!-- Page directives -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- Sping tags -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- JSTL tags -->
<!--%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%-->

<div class="d-flex justify-content-between align-items-center">
  <h2><spring:message code="deck.list.title"/></h2>
  <a class="btn btn-primary" href="${pageContext.request.contextPath}/deck/form" role="button"><spring:message code="action.new"/></a>
</div>

<div class="container-fluid">
  <!--c:forEach items="${deckList}" var="deck"-->
    <div class="row">
      <div class="col">
        <h3><a href="${pageContext.request.contextPath}/deck/data">Deck name</a></h3>
        <!--h3><a class="link"
          href="${pageContext.request.contextPath}/deck/${deck.id}/data">${deck.name}</a></h3-->
      </div>
      <div class="col-1">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/deck/form" role="button"><spring:message code="action.edit"/></a>
      </div>
    </div>
    <div class="deck-cards row">
      <!--c:forEach items="${deck.cardList}" var="card"-->
        <!--div class="col">
          <img src="${card.img}" alt="${card.alt}">
        </div-->
        <div class="col">
          <a href="${pageContext.request.contextPath}/card/data">
            <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
              alt="Hero X-Force Logo">
          </a>
        </div>
        <div class="col">
          <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
            alt="Hero X-Force Logo">
        </div>
        <div class="col">
          <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
            alt="Hero X-Force Logo">
        </div>
        <div class="col">
          <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
            alt="Hero X-Force Logo">
        </div>
        <div class="col">
          <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
            alt="Hero X-Force Logo">
        </div>
      <!--/c:forEach-->
    </div>
  <!--/c:forEach-->
</div>