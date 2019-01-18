<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Start: Duel create -->
<section id="duel-create">
  <div class="container-fluid">
  
    <!-- Start: Title & Button -->
    <div class="row px-sm-4 pt-4">
    
      <!-- Title -->
      <div class="col-9 col-sm-10">
        <h2 class="title-style"><spring:message code="duel.create.title" /></h2>
      </div>
      
      <!-- Button -->
      <div class="col-3 col-sm-2 d-flex justify-content-end align-items-center">
        <a class="button-style btn btn-lg btn-warning" href="${pageContext.request.contextPath}/duel/list" role="button">
          <i class="fas fa-times-circle"></i> <spring:message code="action.cancel"/>
        </a>
      </div>
    </div>
    <!-- End: Title & Button -->
    
    <!-- Start: Data -->
    <form name="duelCreateForm" action="${pageContext.request.contextPath}/duel/create/save" method='POST'>
    
      <!-- Player -->
      <div class="row px-sm-5 mt-4 mt-sm-2">
        <div class="col col-lg-6">
          <label><spring:message code="duel.create.search"/>:</label>
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text"><i class="fas fa-user-secret"></i></span>
            </div>
            <select class="selectpicker form-control" name="opponentId" data-size="5" data-live-search="true" title="<spring:message code="duel.list.choose"/>" required>
              <c:forEach items="${userList}" var="user">
                <option value="${user.userId}">${user.username}</option>
              </c:forEach>
            </select>
          </div>
        </div>
      </div>
      
      <!-- Deck -->
      <div class="row px-sm-5 mt-3">
        <div class="col col-lg-6">
          <label><spring:message code="duel.create.choose"/></label>
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text"><i class="fas fa-id-card-alt"></i></span>
            </div>
            <select class="selectpicker form-control" name="myDeckId" data-size="5" data-live-search="true" title="<spring:message code="duel.list.choose"/>" required>
              <c:forEach items="${deckList}" var="deck">
                <option value="${deck.deckId}">${deck.name}</option>
              </c:forEach>
            </select>
          </div>
        </div>
      </div>

      <!-- Button -->   
      <div class="row px-sm-5 mt-3">
        <div class="col">  
           <button class="button-style btn btn-lg btn-warning" type="submit" name="submit">
             <i class="fas fa-check-circle"></i> <spring:message code="action.accept" />
          </button>
        </div> 
      </div> 
  	</form>
    <!-- End: Data -->
  
    <!-- Start: Top button -->
    <button class="button-style btn btn-lg btn-warning" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
    <!-- End: Top button -->
  
  </div>
</section>
<!-- End: Duel create -->