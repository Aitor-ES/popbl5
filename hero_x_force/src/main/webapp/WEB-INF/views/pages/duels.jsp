<!-- Page directives -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<!-- Spring library -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- JSTL library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

  <h2 class="duels-title">
    <spring:message code="duels.title" />
  </h2>
 <div class="duelsDataBox">
    <form class="form-inline">
      <div class="form-group">
        <label for="inputPlayer"><spring:message code="duels.searchPlayer" /></label>
        <input type="text" id="inputPlayer" class="form-control mx-sm-3" aria-describedby="playerHelpInline">
      </div>
    </form>
    <button type="submit" class="btn btn-danger challengeButton"> <spring:message code="duels.challenge" /></button>
  </div>

  <h2>
    <spring:message code="duels.acceptDuel" />
  </h2>
<ul class="list-group">
  <c:forEach items="${user_2_matchMapList}" var="user_2_matchMap">
    <li class="list-group-item d-flex align-items-center bd-highlight mb-3">
      <span class="mr-auto bd-highlight">${user_2_matchMap.user_1.username}</span>
    <li
      class="list-group-item d-flex align-items-center bd-highlight mb-3">
      <span class="mr-auto  bd-highlight">Izq</span>
      <button type="submit" class="btn btn-success bd-highlight mr-1">
        <spring:message code="duels.buttonAccept" />
      </button>
      <button type="submit" class="btn btn-danger bd-highlight ml-1">
        <spring:message code="duels.buttonRefuse" />
      </button>
    </li>
  </c:forEach>
</ul>