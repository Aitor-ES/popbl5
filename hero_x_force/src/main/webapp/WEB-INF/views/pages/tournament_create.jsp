<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Start: Tournament create -->
<section id="tournament-create">
  <div class="container-fluid">
  
    <!-- Start: Title & Button -->
    <div class="row px-sm-4 pt-4">
    
      <!-- Title -->
      <div class="col col-sm-10">
        <h2 class="title-style"><spring:message code="tournament.create.title" /></h2>
      </div>
      
      <!-- Button -->
      <div class="col col-sm-2 d-flex justify-content-end align-items-center">
        <a class="button-style btn btn-lg btn-warning" href="${pageContext.request.contextPath}/tournament/list" role="button">
          <i class="fas fa-times-circle"></i> <spring:message code="action.cancel"/>
        </a>
      </div>
    </div>
    <!-- End: Title & Button -->
    
    <!-- Start: Data -->
    <form name="tournamentForm" action="${pageContext.request.contextPath}/tournament/form" method='POST'>
    
      <!-- Name-->
      <div class="row px-sm-5 mt-4 mt-sm-2">
        <div class="col col-lg-6">
          <label><spring:message code="tournament.create.tournament.title"/></label>
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text"><i class="fas fa-gamepad"></i></span>
            </div>
            <input type="text" class="form-control" name='name' placeholder="<spring:message code="tournament.create.tournament.placeholder"/>" required>
          </div>
        </div>
      </div>
      
      <!-- Participants -->
      <div class="row px-sm-5 mt-3">
        <div class="col col-lg-6">
          <label><spring:message code="tournament.create.participants.title"/></label>
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text"><i class="fas fa-users"></i></span>
            </div>
            <input type="number" class="form-control" min="0" step="1" name='participants' placeholder="<spring:message code="tournament.create.participants.placeholder"/>" required>
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
  
    <!-- Start: Top button -->
    <button class="button-style btn btn-lg btn-warning" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
    <!-- End: Top button -->
  
  </div>
</section>
<!-- End: Tournament create -->