<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="duel_list">
  <div class="container-fluid">
    <div class="row px-4 pt-4">
      <div class="col-10">
        <h2 class="title-style"><spring:message code="duel.list.title" /></h2>
      </div>
      <div class="col-2 d-flex justify-content-end align-items-center">
        <a class="btn btn-lg btn-warning mt-3 mb-3" href="${pageContext.request.contextPath}/duel/create" role="button">
          <i class="fas fa-plus"></i> <spring:message code="action.create"/>
        </a>
      </div>
    </div>
    
    <div class="row px-4 pt-4">
      <div class="col">
        <h2 class="title-style"><spring:message code="duel.list.join"/></h2>
      </div>
    </div>
    
    <div class="row px-4 pt-2">
      <div class="col">
        <ul class="list-group">
          <c:forEach items="${matchesAsUser_2}" var="matchAsUser_2">
            <li class="list-group-item d-flex align-items-center bd-highlight mb-3">
              <span class="mr-auto bd-highlight">${matchAsUser_2.user_1.username}</span>
            
              
              <div class="input-group col-sm-3">
                <div class="input-group-prepend">
                  <span class="input-group-text"><i class="fas fa-id-card-alt"></i></span>
                </div>
                <select class="selectpicker form-control" name="myDeck_id" data-size="5" data-live-search="true" title="Choose one of the following..." required>
                  <c:forEach items="${deckList}" var="deck">
                    <option value="${deck.deck_id}">${deck.name}</option>
                  </c:forEach>
                </select>
              </div>
            
              <a class="btn btn-success bd-highlight mr-1" href="${pageContext.request.contextPath}/duel/${matchAsUser_2.match_id}/loadBattle"
                role="button"><spring:message code="action.accept" /></a>
              <button type="submit" class="btn btn-danger bd-highlight ml-1"><spring:message code="action.refuse" /></button>
            </li>
          </c:forEach>
        </ul>
      </div>
    </div>
  </div>

  <!-- Start: Back to top button -->
  <button class="btn btn-lg btn-primary" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
  <!-- End: Back to top button -->
</section>