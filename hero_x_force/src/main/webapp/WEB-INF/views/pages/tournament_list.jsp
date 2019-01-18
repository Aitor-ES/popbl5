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
    
    <!-- Start: Join Info & Card -->
    <div class="row mb-4 mt-2">
      <div class="col px-0">
        <c:choose>
          <c:when test="${availableTournamentList.size() == 0}">
          
            <!-- Info -->
            <div class="row mt-3">
              <div class="col-md-8 offset-md-2 d-flex justify-content-center align-items-center">
                <p class="text-center m-0 p-1 modal-content"><span><i class="fas fa-info-circle"></i> <spring:message code="tournament.list.empty"/></span></p>
              </div>
            </div>
          </c:when>
          
          <c:otherwise>
          
            <!-- Card -->
            <c:forEach items="${availableTournamentList}" var="tournament">
              <div id="join-card" class="card mx-3 mx-sm-5 mt-4 mb-5">
              
                <!-- Tournament header -->
                <div class="card-header p-3 bg-dark text-light">
                  <div class="row ">
                  
                    <!-- Name -->
                    <div class="p-0 d-flex align-items-center">
                       <p class="mb-0"><spring:message code="tournament.list.header"/> <i class="fas fa-angle-right"></i> ${tournament.name}</p>
                    </div>
                  </div>
                </div>

                <!-- Tournament body -->
                <div class="card-body">
                  <div class="row ">

                    <!-- Accordion -->
                    <div class="accordion col-sm-6 p-0" id="accordion-${tournament.tournamentId}">
                      <div class="card">
                        <div class="card-header px-0 py-1" id="heading-${tournament.tournamentId}">
                          <button class="btn btn-link" data-toggle="collapse" data-target="#collapse-${tournament.tournamentId}"
                            aria-expanded="true" aria-controls="collapse-${tournament.tournamentId}">
                            <p class="my-0"><i class="fas fa-eye"></i> <spring:message code="tournament.list.info"/></p>
                          </button>
                        </div>
                        <div id="collapse-${tournament.tournamentId}" class="collapse"
                          aria-labelledby="heading-${tournament.tournamentId}" data-parent="#accordion-${tournament.tournamentId}">
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
                    
                    <!-- Button -->
                    <div class="col-sm-6 p-0 mt-3 mt-sm-0 d-flex justify-content-center justify-content-sm-end align-items-center">
                      <a class="btn btn-lg btn-warning" href="${pageContext.request.contextPath}/tournament/${tournament.tournamentId}/join" role="button">
                        <i class="fas fa-sign-in-alt"></i> <spring:message code="action.join"/>
                      </a>
                    </div>
                  </div>
                </div>
                
                <!-- Tournament footer -->
                <div class="card-footer text-muted px-0">
                  <div class="row ">
                  
                    <!-- Date -->
                    <div class="col d-flex justify-content-start">
                      <p class="mb-0">${tournament.date}</p>
                    </div>
                    
                    <!-- Hour -->
                    <div class="col d-flex justify-content-end">
                      <p class="mb-0">${tournament.hour}</p>
                    </div>
                  </div>
                </div>
              </div>
            </c:forEach>
          </c:otherwise>
        </c:choose>
      </div>
    </div>            
    <!-- End: Join Info & Card -->        
    
    <!-- Start: Joined title -->
    <div class="row px-sm-4 py-3">
      <div class="col">
        <h2 class="title-style"><spring:message code="tournament.list.joined.header" /></h2>
      </div>
    </div>
    <!-- End: Joined title -->
    
    <!-- Start: Joined Info & Card -->
    <div class="row mb-4 mt-2">
      <div class="col px-0">
        <c:choose>
          <c:when test="${joinedTournamentList.size() == 0}">
          
            <!-- Info -->
            <div class="row mt-3">
              <div class="col-md-8 offset-md-2 d-flex justify-content-center align-items-center">
                <p class="text-center m-0 p-1 modal-content"><span><i class="fas fa-info-circle"></i> <spring:message code="tournament.list.empty"/></span></p>
              </div>
            </div>
          </c:when>
          
          <c:otherwise>
          
            <!-- Card -->
            <c:forEach items="${joinedTournamentList}" var="tournament">
              <div id="join-card" class="card mx-3 mx-sm-5 mt-4 mb-5">
              
                <!-- Tournament header -->
                <div class="card-header p-3 bg-dark text-light">
                  <div class="row ">
                  
                    <!-- Name -->
                    <div class="p-0 d-flex align-items-center">
                       <p class="mb-0"><spring:message code="tournament.list.header"/> <i class="fas fa-angle-right"></i> ${tournament.name}</p>
                    </div>
                  </div>
                </div>
          
                <!-- Tournament body -->
                <div class="card-body">
                  <!-- Accordion -->
                  <div class="accordion p-0" id="accordion-${tournament.tournamentId}">
                    <div class="card">
                      <div class="card-header px-0 py-1" id="heading-${tournament.tournamentId}">
                        <button class="btn btn-link" data-toggle="collapse" data-target="#collapse-${tournament.tournamentId}"
                          aria-expanded="true" aria-controls="collapse-${tournament.tournamentId}">
                          <p class="my-0"><i class="fas fa-eye"></i> <spring:message code="tournament.list.info"/></p>
                        </button>
                      </div>
                      <div id="collapse-${tournament.tournamentId}" class="collapse"
                        aria-labelledby="heading-${tournament.tournamentId}" data-parent="#accordion-${tournament.tournamentId}">
                        <div class="card-body">
                          <ul class="list-group" id="tournament-${tournament.tournamentId}-participants">
                            <c:forEach items="${tournament.userTournamentMaps}" var="userTournamentMap">
                              <li class="list-group-item">${userTournamentMap.user.username}</li>
                            </c:forEach>
                          </ul>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
                
                <!-- Tournament footer -->
                <div class="card-footer text-muted px-0">
                  <div class="row ">
                  
                    <!-- Date -->
                    <div class="col d-flex justify-content-start">
                      <p class="mb-0">${tournament.date}</p>
                    </div>
                    
                    <!-- Hour -->
                    <div class="col d-flex justify-content-end">
                      <p class="mb-0">${tournament.hour}</p>
                    </div>
                  </div>
                </div>
              </div>
            </c:forEach>
          </c:otherwise>
        </c:choose>
      </div>
    </div>            
    <!-- End: Joined Info & Card -->
    
    <!-- Start: Top button -->
    <button class="button-style btn btn-lg btn-warning" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
    <!-- End: Top button -->
  
  </div>
</section>
<!-- End: Tournament list -->
