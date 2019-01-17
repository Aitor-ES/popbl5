<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Start: Duel list -->
<section id="duel_list">
  <div class="container-fluid">
  
    <!-- Start: Title & Button -->
    <div class="row px-sm-4 pt-4">
    
      <!-- Title -->
      <div class="col col-sm-10">
        <h2 class="title-style"><spring:message code="duel.list.title" /></h2>
      </div>
      
      <!-- Button -->
      <div class="col col-sm-2 d-flex justify-content-end align-items-center">
        <a class="btn btn-lg btn-warning button-style" href="${pageContext.request.contextPath}/duel/create" role="button">
          <i class="fas fa-plus"></i> <spring:message code="action.create"/>
        </a>
      </div>
    </div>
    <!-- End: Title & Button -->
    
    <!-- Start: Play title -->
    <div class="row px-sm-4 pt-5">
      <div class="col">
        <h2 class="title-style"><spring:message code="duel.list.join"/></h2>
      </div>
    </div>
    <!-- End: Play title -->
    
    <!-- Start: List -->
    <div class="row px-sm-4 pt-3 mb-4">
      <div class="col">
        <c:forEach items="${matchesAsUser_2}" var="matchAsUser_2">
          <form name="duelListForm" action="${pageContext.request.contextPath}/duel/${matchAsUser_2.match_id}/battle" method='POST'>
            <div class="panel bg-white border border-danger p-3 mb-3">
              <div class="panel-body d-flex align-items-center bd-highlight">
                <span class="mr-auto bd-highlight">${matchAsUser_2.user_1.username}</span>
              
                <div class="input-group col-sm-5">
                  <div class="input-group-prepend">
                    <span class="input-group-text"><i class="fas fa-id-card-alt"></i></span>
                  </div>
                  <select class="selectpicker form-control" name="deck-picker-${matchAsUser_2.match_id}" data-size="5"
                    data-live-search="true" title="Choose one of the following..." required>
                    <c:forEach items="${deckList}" var="deck">
                      <option value="${deck.deck_id}">${deck.name}</option>
                    </c:forEach>
                  </select>
                </div>
                <button type="submit" name="action" value="accept"
                  class="btn btn-success bd-highlight ml-1"><spring:message code="action.accept" /></button>
                <button type="submit" name="action" value="refuse"
                  class="btn btn-danger bd-highlight ml-1"><spring:message code="action.refuse" /></button>
             </div>
            </div>
          </form>
        </c:forEach>
      </div>
    </div>
  </div>

  <!-- Start: Back to top button -->
  <button class="btn btn-lg btn-primary" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
  <!-- End: Back to top button -->
</section>