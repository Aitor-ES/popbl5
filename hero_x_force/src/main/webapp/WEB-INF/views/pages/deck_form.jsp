<!-- Page directives -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- Spring tags -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!-- JSTL tags -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
          <div class="card-container" id="hero-${card.card_id}-container" draggable="true" ondragstart="drag(event)">
            <img src="${card.img}" draggable="false">
            <span>${card.name}</span>
          </div>
        </div>
      </c:forEach>
    </div>
  </div>
  
  <!-- Start: Back to top button -->
  <button class="btn btn-lg btn-primary" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
  <!-- End: Back to top button -->
</section>