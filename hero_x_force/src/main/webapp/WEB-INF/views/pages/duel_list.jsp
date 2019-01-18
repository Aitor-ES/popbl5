<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Start: Duel list -->
<section id="duel-list">
  <div class="container-fluid">
  
    <!-- Start: Duels title & button -->
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
    <!-- End: Duels title & button -->
    
    <!-- Start: Play title -->
    <div class="row px-sm-4 pt-3">
      <div class="col">
        <h2 class="title-style"><spring:message code="duel.list.join"/></h2>
      </div>
    </div>
    <!-- End: Play title -->
    
    <!-- Start: Info & Card -->
    <div class="row mb-4 mt-2">
      <div class="col px-0">
        <c:choose>
          <c:when test="${matchesAsUser2.size() == 0}">
            
            <!-- Info -->
            <div class="row mt-3">
              <div class="col-md-8 offset-md-2 d-flex justify-content-center align-items-center">
                <p class="text-center m-0 p-1 modal-content"><span><i class="fas fa-info-circle"></i> <spring:message code="duel.list.empty"/></span></p>
              </div>
            </div>
          </c:when>
          
          <c:otherwise>
            
            <!-- Card -->
            <c:forEach items="${matchesAsUser2}" var="matchAsUser2">
              <form name="duelListForm" action="${pageContext.request.contextPath}/duel/${matchAsUser2.matchId}/battle" method='POST'>
                <div class="card mx-3 mx-sm-5 mt-4 mb-5">
          
                  <!-- Duel header -->
                  <div class="card-header p-3 bg-dark text-light">
                    <div class="row ">
                    
                      <!-- Opponent name -->
                      <div class="p-0 d-flex align-items-center">
                    	   <p class="mb-0"><spring:message code="duel.list.opponent"/> <i class="fas fa-angle-right"></i> ${matchAsUser2.user1.username}</p>
                      </div>
                    </div>
                  </div>
          
                  <!-- Duel body -->
                  <div class="card-body">
                    <div class="row ">
          
                      <!-- Selector -->
                      <div class="col-sm-6 col-lg-5 p-0 d-flex align-items-center">
                        <div class="input-group">
                          <div class="input-group-prepend">
                            <span class="input-group-text"><i class="fas fa-id-card-alt"></i></span>
                          </div>
                          <select class="selectpicker form-control" name="deck-picker-${matchAsUser2.matchId}" data-size="5"
                            data-live-search="true" title="<spring:message code="duel.list.choose"/>" required>
                            <c:forEach items="${deckList}" var="deck">
                              <option value="${deck.deckId}">${deck.name}</option>
                            </c:forEach>
                          </select>
                        </div>
                      </div>
                      
                      <!-- Buttons -->
                      <div class="col-sm-6 col-lg-7 p-0 mt-3 mt-sm-0 d-flex justify-content-between justify-content-sm-end">
                        <button type="submit" name="action" value="accept" class="button-style btn btn-lg btn-warning">
                          <i class="fas fa-check-circle"></i> <spring:message code="action.accept" />
                        </button>
                        <a class="button-style btn btn-lg btn-danger ml-3"
                          href="${pageContext.request.contextPath}/duel/${matchAsUser2.matchId}/delete" role="button">
                          <i class="fas fa-times-circle"></i> <spring:message code="action.refuse" />
                        </a>
                      </div>
                    </div>
                  </div>
                  
                  <!-- Duel footer -->
                  <div class="card-footer text-muted px-0">
                    <div class="row ">
                    
                      <!-- Date -->
                      <div class="col d-flex justify-content-start">
                        <p class="mb-0">${matchAsUser2.date}</p>
                      </div>
                      
                      <!-- Hour -->
                      <div class="col d-flex justify-content-end">
                        <p class="mb-0">${matchAsUser2.hour}</p>
                      </div>
                    </div>
                  </div>
                </div>
              </form>
            </c:forEach>
          </c:otherwise>
        </c:choose>
      </div>
    </div>
    <!-- End: Info & Card -->
    
    <!-- Start: Top button -->
    <button class="button-style btn btn-lg btn-warning" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
    <!-- End: Top button -->
  
  </div>
</section>
<!-- End: Ranking --> 