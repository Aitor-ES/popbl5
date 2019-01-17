<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Start: Tournament list -->
<section id="tournament_list">
  <div class="container-fluid">
    
    <!-- Start: Title & Button -->
    <div class="row px-sm-4 pt-4">
    
      <!-- Title -->
      <div class="col col-sm-10">
        <h2 class="title-style"><spring:message code="tournament.list.create.header" /></h2>
      </div>
      
      <!-- Button -->
      <div class="col col-sm-2 d-flex justify-content-end align-items-center">
        <a class="button-style btn btn-lg btn-warning" href="${pageContext.request.contextPath}/tournament/create" role="button">
          <i class="fas fa-plus"></i> <spring:message code="action.create"/>
        </a>
      </div>
    </div>
    <!-- End: Title & Button -->
    
    <!-- Start: Play title -->
    <div class="row px-sm-4 pt-5">
      <div class="col">
        <h2 class="title-style"><spring:message code="tournament.list.join.header" /></h2>
      </div>
    </div>
    <!-- End: Play title -->
    
    <!-- Start: List -->
    <div class="row px-sm-5 pt-3 mb-4">
      <div class="col">
        <c:choose>
          <c:when test="${tournamentList.size() == 0}">
            <div class="row">
              <div class="modal-content col">
                <h3 class="text-center"><spring:message code="tournament.list.empty" /></h3>
              </div>
            </div>
          
          </c:when>
          <c:otherwise>
            <c:forEach items="${tournamentList}" var="tournament">
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
                        <a class="btn btn-lg btn-warning" href="${pageContext.request.contextPath}/tournament/${tournament.tournament_id}/join" role="button">
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
    <!-- End: List -->
    
    <!-- Start: Top button -->
    <button class="button-style btn btn-lg btn-warning" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
    <!-- End: Top button -->
  
  </div>
</section>
<!-- End: Tournament list -->
