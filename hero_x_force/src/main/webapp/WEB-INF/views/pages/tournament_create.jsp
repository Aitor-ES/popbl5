<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="tournament-create">
  <div class="container-fluid">
    <div class="row px-4 pt-4">
      <div class="col-10">
        <h2 class="title-style"><spring:message code="tournament.create.title" /></h2>
      </div>
      <div class="col-2 d-flex justify-content-end align-items-center">
        <a class="btn btn-lg btn-warning mt-3 mb-3" href="${pageContext.request.contextPath}/tournament/list" role="button">
          <i class="fas fa-times-circle"></i> <spring:message code="action.cancel"/>
        </a>
      </div>
    </div>

    <form name="tournamentForm" action="${pageContext.request.contextPath}/tournament/form" method='POST'> 
      <div class="row px-5">
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
      <div class="row px-5 mt-3">
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
          
      <div class="row px-5 mt-3">
        <div class="col">  
           <button class="btn btn-lg btn-warning" type="submit" name="submit">
             <i class="fas fa-check-circle"></i> <spring:message code="action.accept" />
          </button>
        </div> 
      </div> 
  	</form>
  </div>
  
  <!-- Start: Back to top button -->
  <button class="btn btn-lg btn-primary" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
  <!-- End: Back to top button -->
</section>