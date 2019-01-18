<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Start: Tournament list -->
<section id="tournament-list">
  <div class="container-fluid">
    
    <!-- Start: Title & Button -->
    <div class="row px-sm-4 pt-4">
    
      <!-- Title -->
      <div class="col-8 col-sm-10">
        <h2 class="title-style"><spring:message code="tournament.list.create.header" /></h2>
      </div>
      
      <!-- Button -->
      <div class="col-4 col-sm-2 d-flex justify-content-end align-items-center">
        <a class="button-style btn btn-lg btn-warning" href="${pageContext.request.contextPath}/tournament/create" role="button">
          <i class="fas fa-plus"></i> <spring:message code="action.create"/>
        </a>
      </div>
    </div>
    <!-- End: Title & Button -->
    
    <!-- Start: Join title -->
    <div class="row px-sm-4 py-3">
      <div class="col">
        <h2 class="title-style"><spring:message code="tournament.list.join.header" /></h2>
      </div>
    </div>
    <!-- End: Join title -->
    
    <!-- Start: Not joined list -->
    <div class="row px-sm-5 pt-1 mb-4">
      <div class="col">
        <c:choose>
        
          <c:when test="${availableTournamentList.size() == 0}">
            <div class="row mt-1">
              <div class="col-md-8 offset-md-2 d-flex justify-content-center align-items-center">
                <p class="text-center m-0 p-1 modal-content"><span><i class="fas fa-info-circle"></i> <spring:message code="tournament.list.empty"/></span></p>
              </div>
            </div>
          </c:when>
          
          <c:otherwise>
            <c:forEach items="${availableTournamentList}" var="tournament">
              <div id="accordion">
                <div class="card">
                  <div class="card-header" id="heading-${tournament.tournamentId}">
                      <i class="fas fa-sort-down"></i>
                      <button class="btn btn-link" data-toggle="collapse" data-target="#collapse-${tournament.tournamentId}"
                        aria-expanded="true" aria-controls="collapse-${tournament.tournamentId}">#${tournament.tournamentId} - ${tournament.name} - (${tournament.date})
                      </button>
                  </div>
                  <div id="collapse-${tournament.tournamentId}" class="collapse" aria-labelledby="heading-${tournament.tournamentId}" data-parent="#accordion">
                    <div class="card-body">
                      <ul id="tournament-${tournament.tournamentId}-participants" class="list-group">
                        <c:forEach items="${tournament.userTournamentMaps}" var="userTournamentMap">
                          <li class="list-group-item">${userTournamentMap.user.username}</li>
                        </c:forEach>
                      </ul>
                      <div class="col-2 d-flex justify-content-start align-items-center">
                        <a class="btn btn-lg btn-warning" href="${pageContext.request.contextPath}/tournament/${tournament.tournamentId}/join" role="button">
                          <i class="fas fa-hand-point-up"></i> <spring:message code="tournament.list.join.button"/>
                        </a>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </c:forEach>
          </c:otherwise>
          
        </c:choose>
      </div>
    </div>
    <!-- End: Not joined list -->
    
    <!-- Start: Joined title -->
    <div class="row px-sm-4">
      <div class="col">
        <h2 class="title-style"><spring:message code="tournament.list.joined.header" /></h2>
      </div>
    </div>
    <!-- End: Joined title -->
    
    <!-- Start: Joined list -->
    <div class="row px-sm-5 pt-3 mb-4">
      <div class="col">
        <c:choose>
          <c:when test="${joinedTournamentList.size() == 0}">
            <div class="row mt-1">
              <div class="col-md-8 offset-md-2 d-flex justify-content-center align-items-center">
                <p class="text-center m-0 p-1 modal-content"><span><i class="fas fa-info-circle"></i> <spring:message code="tournament.list.empty"/></span></p>
              </div>
            </div>
          </c:when>
          <c:otherwise>
            <c:forEach items="${joinedTournamentList}" var="tournament">
              <div id="accordion">
                <div class="card">
                  <div class="card-header" id="heading-${tournament.tournamentId}">
                      <i class="fas fa-sort-down"></i>
                      <button class="btn btn-link" data-toggle="collapse" data-target="#collapse-${tournament.tournamentId}"
                        aria-expanded="true" aria-controls="collapse-${tournament.tournamentId}">#${tournament.tournamentId} - ${tournament.name} - (${tournament.date})
                      </button>
                  </div>
                  <div id="collapse-${tournament.tournamentId}" class="collapse" aria-labelledby="heading-${tournament.tournamentId}" data-parent="#accordion">
                    <div class="card-body">
                      <ul id="tournament-${tournament.tournamentId}-participants" class="list-group">
                        <c:forEach items="${tournament.userTournamentMaps}" var="userTournamentMap">
                          <li class="list-group-item">${userTournamentMap.user.username}</li>
                        </c:forEach>
                      </ul>
                    </div>
                  </div>
                </div>
              </div>
            </c:forEach>
          </c:otherwise>
        </c:choose>
      </div>
    </div>
    <!-- End: Joined list -->
    
    <!-- Start: Top button -->
    <button class="button-style btn btn-lg btn-warning" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
    <!-- End: Top button -->
  
  </div>
</section>
<!-- End: Tournament list -->
