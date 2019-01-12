<!-- Page directives -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Spring library -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- JSTL library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section id="tournaments">
  <h2><spring:message code="tournaments.header" /></h2>
  <button type="submit" class="btn btn-primary"><spring:message code="tournaments.create" /></button>
  
  <h2><spring:message code="tournaments.join" /></h2>
  <c:forEach items="${availableTournamentList}" var="tournament">
    <div id="accordion">
      <div class="card">
        <div class="card-header" id="heading-${tournament.tournament_id}">
          <div class="mb-0">
            <button class="btn btn-link" data-toggle="collapse" data-target="#collapse-${tournament.tournament_id}"
              aria-expanded="true" aria-controls="collapse-${tournament.tournament_id}">${tournament.name}</button>
          </div>
        </div>
        <div id="collapse-${tournament.tournament_id}" class="collapse" aria-labelledby="heading-${tournament.tournament_id}"
          data-parent="#accordion">
          <div class="card-body">
            <ul id="tournament-${tournament.tournament_id}-participants" class="list-group">
              <!-- <li class="list-group-item">${user.username}</li> -->
            </ul>
            <button type="submit" class="btn btn-success"><spring:message code="tournaments.join" /></button>
          </div>
        </div>
      </div>
    </div>
  </c:forEach>
</section>
