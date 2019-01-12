<!-- Page directives -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- Spring tags -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!-- JSTL tags -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="deck-list">
  <div class="d-flex justify-content-between align-items-center">
    <h2 class="deckListTitle"><spring:message code="deck.list.title"/></h2>
    <a class="btn btn-primary" href="${pageContext.request.contextPath}/deck/form" role="button"><spring:message code="action.new"/></a>
  </div>
  
  <div class="container-fluid">
    <c:forEach items="${deckList}" var="deck">
      <div class="deckListDataBox">
        <div class="row deckListTitleRow">
          <div class="col">
            <h3><a class="deckTitle"
              href="${pageContext.request.contextPath}/deck/${deck.deck_id}/data">${deck.name}</a></h3>
          </div> 
           <div class="editButtonDeckList">
            <img src="${pageContext.request.contextPath}/static/img/default/edit.jpg" alt="edit icon">
            <a class="btn btn-danger" href="${pageContext.request.contextPath}/deck/${deck.deck_id}/form" role="button">
              <spring:message code="action.edit"/></a>
          </div>
        </div>
        <div class="deck-cards row">
          <c:forEach items="${deck.deckCardMaps}" var="deckCardMap">
            <div class="col">
              <img src="${deckCardMap.card.img}" alt="${deckCardMap.card.alt}">
            </div>
          </c:forEach>
        </div>
      </div>
    </c:forEach>
  </div>
</section>