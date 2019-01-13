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
      <c:forEach items="${cardList}" var="card">
        <div class="col" ondragover="allowDrop(event)" ondrop="drop(event)">
          <div class="card-container" id="hero-${card.card_id}-container" draggable="true" ondragstart="drag(event)">
            <img src="${card.img}" draggable="false">
            <span>${card.name}</span>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
</section>