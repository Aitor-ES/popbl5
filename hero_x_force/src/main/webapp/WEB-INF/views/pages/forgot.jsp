<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Start: Forgot  -->
<section id="forgot">

  <!-- Start: Logo -->
  <div class="row mt-4">
    <div class="col text-center">
      <img src="${pageContext.request.contextPath}/static/img/login/logo.png" alt="<spring:message code="forgot.logo.alt"/>">
    </div>
  </div>
  <!-- End: Logo -->
  
  <!--  Start: Title -->
  <div id="forgot-title" class="row">
    <div class="col text-center">
      <h1 class="h2 mt-3 mb-3 font-weight-normal"><spring:message code="forgot.label"/></h1>
    </div>
  </div>
  <!-- End: Title -->
  
  <!-- Start: Register -->
  <form name="forgotForm" action="${pageContext.request.contextPath}/forgot/form" method='GET'>    
    <div class="row justify-content-center mb-5">
      <div class="modal-content col-10 col-md-6 col-lg-4 col-xl-4">
      
        <!-- Input: Email -->
        <div class="input-group">
          <div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-at"></i></span></div>
          <input type="text" class="form-control" name='email' placeholder="<spring:message code="forgot.email"/>" required>
        </div>
        
        <!-- Progress bar -->
        <div class="progress mt-3" id="myProgressBar" style="display: none">
          <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%"></div>
        </div>
        <button class="btn btn-lg btn-warning mt-3" type="submit" name="submit" onclick="forgotProgress()"><i class="fas fa-share-square"></i> <spring:message code="action.recover"/></button>
      </div>
    </div>
  </form>
  <!-- End: Forgot -->
  
  <!-- Start: Back to top button -->
  <button class="btn btn-lg btn-warning" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
  <!-- End: Back to top button -->
</section>
<!-- End: Section -->