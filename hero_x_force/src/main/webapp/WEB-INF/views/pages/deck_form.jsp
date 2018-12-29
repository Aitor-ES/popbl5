<!-- Page directives -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- Sping tags -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- JSTL tags -->
<!--%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%-->

<h2><spring:message code="deck.form.title.create"/></h2>

<div class="container-fluid">
  <div class="row">
    <div class="col">
      <label for="deck-name"><spring:message code="deck.form.name"/>:</label>
      <br/>
      <input type='text' name='deck-name' value='' />
    </div>
    <div class="col-1">
      <a class="btn btn-primary" href="${pageContext.request.contextPath}/deck/form" role="button"><spring:message code="action.save"/></a>
    </div>
  </div>
  
  <div class="selected-cards">
    <div class="row">
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <label>Hero 1</label>
      </div>
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <label>Hero 2</label>
      </div>
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <label>Hero 3</label>
      </div>
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <label>Hero 4</label>
      </div>
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <label>Hero 5</label>
      </div>
    </div>
  </div>
  
  <div class="available-cards">
    <div class="row">
      <!--c:forEach items="${cardList}" var="card">
        <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
          <img src="${card.img}" alt="${card.alt}"
            id="${card.id}" draggable="true" ondragstart="drag(event)">
        </div>
      </c:forEach-->
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
          alt="Hero X-Force Logo"
          id="hero-1" draggable="true" ondragstart="drag(event)">
      </div>
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
          alt="Hero X-Force Logo"
          id="hero-2" draggable="true" ondragstart="drag(event)">
      </div>
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
          alt="Hero X-Force Logo"
          id="hero-3" draggable="true" ondragstart="drag(event)">
      </div>
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
          alt="Hero X-Force Logo"
          id="hero-4" draggable="true" ondragstart="drag(event)">
      </div>
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
          alt="Hero X-Force Logo"
          id="hero-5" draggable="true" ondragstart="drag(event)">
      </div>
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
          alt="Hero X-Force Logo"
          id="hero-6" draggable="true" ondragstart="drag(event)">
      </div>
    </div>
  </div>
</div>