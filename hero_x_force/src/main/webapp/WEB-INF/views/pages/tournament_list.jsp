<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="tournament_list">
  <div class="container-fluid">
    <div class="row px-4 pt-4">
      <div class="col-10">
        <h2 class="title-style"><spring:message code="tournament.list.create.header" /></h2>
      </div>
      <div class="col-2 d-flex justify-content-end align-items-center">
        <a class="btn btn-lg btn-warning mt-3 mb-3" href="${pageContext.request.contextPath}/tournament/create" role="button">
          <i class="fas fa-plus"></i> <spring:message code="tournament.list.create.button"/>
        </a>
      </div>
    </div>

    <div class="row px-4 pt-4">
      <div class="col">
        <h2 class="title-style"><spring:message code="tournament.list.join.header" /></h2>
      </div>
    </div>
    
    <div class="row px-4 pt-4">
      <div class="col">
        <c:forEach items="${availableTournamentList}" var="tournament">
          <div id="accordion">
            <div class="card">
              <div class="card-header" id="heading-${tournament.tournament_id}">
                  <i class="fas fa-sort-down"></i>
                  <button class="btn btn-link" data-toggle="collapse" data-target="#collapse-${tournament.tournament_id}"
                    aria-expanded="true" aria-controls="collapse-${tournament.tournament_id}">#${tournament.tournament_id} - ${tournament.name} - (${tournament.date})
                  </button>
              </div>
              <div id="collapse-${tournament.tournament_id}" class="collapse" aria-labelledby="heading-${tournament.tournament_id}" data-parent="#accordion">
                <div class="card-body">
                  <ul id="tournament-${tournament.tournament_id}-participants" class="list-group">
                    <!-- <li class="list-group-item">${user.username}</li> -->
                  </ul>
                  <div class="col-2 d-flex justify-content-start align-items-center">
                    <a class="btn btn-lg btn-warning" href="${pageContext.request.contextPath}/tournament/create" role="button">
                      <i class="fas fa-hand-point-up"></i> <spring:message code="tournament.list.join.button"/>
                    </a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </c:forEach>
      </div>
    </div>
  </div>
  
  <!-- Start: Back to top button -->
  <button class="btn btn-lg btn-primary" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
  <!-- End: Back to top button -->
</section>
