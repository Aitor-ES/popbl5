<!-- Page directives -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- Spring tags -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!-- JSTL tags -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="deck-form">
  <h2><spring:message code="deck.form.title.create"/></h2>
  <div class="container-fluid">
    <label for="deck-name"><spring:message code="deck.form.name"/>:</label>
    <input type='text' name='deck-name' value='' />
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/deck/form" role="button"><spring:message code="action.save"/></a>
    <div class="row" id="selected-cards">
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
    <div class="row" id="available-cards">
      <!-- <c:forEach items="${cardList}" var="card">
        <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
          <img src="${card.img}" alt="${card.alt}"
            id="${card.id}" draggable="true" ondragstart="drag(event)">
        </div>
      </c:forEach> -->
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <div class="card-container" id="hero-1-container" draggable="true" ondragstart="drag(event)">
          <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
            alt="Hero X-Force Logo" draggable="false">
          <span>1</span>
        </div>
      </div>
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <div class="card-container" id="hero-2-container" draggable="true" ondragstart="drag(event)">
          <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
            alt="Hero X-Force Logo" draggable="false">
          <span>2</span>
        </div>
      </div>
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <div class="card-container" id="hero-3-container" draggable="true" ondragstart="drag(event)">
          <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
            alt="Hero X-Force Logo" draggable="false">
          <span>3</span>
        </div>
      </div>
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <div class="card-container" id="hero-4-container" draggable="true" ondragstart="drag(event)">
          <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
            alt="Hero X-Force Logo" draggable="false">
          <span>4</span>
        </div>
      </div>
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <div class="card-container" id="hero-5-container" draggable="true" ondragstart="drag(event)">
          <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
            alt="Hero X-Force Logo" draggable="false">
          <span>5</span>
        </div>
      </div>
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <div class="card-container" id="hero-6-container" draggable="true" ondragstart="drag(event)">
          <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
            alt="Hero X-Force Logo" draggable="false">
          <span>6</span>
        </div>
      </div>
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <div class="card-container" id="hero-1-container" draggable="true" ondragstart="drag(event)">
          <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
            alt="Hero X-Force Logo" draggable="false">
          <span>1</span>
        </div>
      </div>
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <div class="card-container" id="hero-2-container" draggable="true" ondragstart="drag(event)">
          <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
            alt="Hero X-Force Logo" draggable="false">
          <span>2</span>
        </div>
      </div>
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <div class="card-container" id="hero-3-container" draggable="true" ondragstart="drag(event)">
          <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
            alt="Hero X-Force Logo" draggable="false">
          <span>3</span>
        </div>
      </div>
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <div class="card-container" id="hero-4-container" draggable="true" ondragstart="drag(event)">
          <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
            alt="Hero X-Force Logo" draggable="false">
          <span>4</span>
        </div>
      </div>
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <div class="card-container" id="hero-5-container" draggable="true" ondragstart="drag(event)">
          <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
            alt="Hero X-Force Logo" draggable="false">
          <span>5</span>
        </div>
      </div>
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <div class="card-container" id="hero-6-container" draggable="true" ondragstart="drag(event)">
          <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
            alt="Hero X-Force Logo" draggable="false">
          <span>6</span>
        </div>
      </div>
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <div class="card-container" id="hero-1-container" draggable="true" ondragstart="drag(event)">
          <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
            alt="Hero X-Force Logo" draggable="false">
          <span>1</span>
        </div>
      </div>
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <div class="card-container" id="hero-2-container" draggable="true" ondragstart="drag(event)">
          <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
            alt="Hero X-Force Logo" draggable="false">
          <span>2</span>
        </div>
      </div>
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <div class="card-container" id="hero-3-container" draggable="true" ondragstart="drag(event)">
          <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
            alt="Hero X-Force Logo" draggable="false">
          <span>3</span>
        </div>
      </div>
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <div class="card-container" id="hero-4-container" draggable="true" ondragstart="drag(event)">
          <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
            alt="Hero X-Force Logo" draggable="false">
          <span>4</span>
        </div>
      </div>
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <div class="card-container" id="hero-5-container" draggable="true" ondragstart="drag(event)">
          <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
            alt="Hero X-Force Logo" draggable="false">
          <span>5</span>
        </div>
      </div>
      <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
        <div class="card-container" id="hero-6-container" draggable="true" ondragstart="drag(event)">
          <img src="https://render.fineartamerica.com/images/rendered/default/greeting-card/images/artworkimages/medium/1/poker-playing-card-ace-heart-miroslav-nemecek-transparent.png?&targetx=43&targety=39&imagewidth=413&imageheight=622&modelwidth=500&modelheight=700&backgroundcolor=ffffff&orientation=1"
            alt="Hero X-Force Logo" draggable="false">
          <span>6</span>
        </div>
      </div>
    </div>
  </div>
</section>