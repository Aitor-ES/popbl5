<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="duels">
  <div class="container-fluid">
    <div class="row px-4 pt-4">
      <div class="col">
        <h2 class="title-style"><spring:message code="duels.title"/></h2>
      </div>
    </div>
    
    <div class="duels-data-box">
      <form class="form-inline">
        <div class="form-group">
          <label for="inputPlayer"><spring:message code="duels.searchPlayer" /></label>
          <input type="text" id="inputPlayer" class="form-control mx-sm-3" aria-describedby="playerHelpInline">
        </div>
      </form>
      <button type="submit" class="btn btn-danger challenge-button"> <spring:message code="duels.challenge" /></button>
    </div>
    
    <div class="row px-4 pt-4">
      <div class="col">
        <h2 class="title-style"><spring:message code="duels.acceptDuel"/></h2>
      </div>
    </div>
    
    <ul class="list-group">
      <c:forEach items="${matchesAsUser_2}" var="matchAsUser_2">
        <li class="list-group-item d-flex align-items-center bd-highlight mb-3">
          <span class="mr-auto bd-highlight">${matchAsUser_2.user_1.username}</span>
          <a class="btn btn-success bd-highlight mr-1" href="${pageContext.request.contextPath}/duel/${matchAsUser_2.match_id}/loadBattle"
            role="button"><spring:message code="action.accept" /></a>
          <button type="submit" class="btn btn-danger bd-highlight ml-1"><spring:message code="action.refuse" /></button>
        </li>
      </c:forEach>
    </ul>

  </div>
    
  <!-- Start: Back to top button -->
  <button class="btn btn-lg btn-primary" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
  <!-- End: Back to top button -->
</section>