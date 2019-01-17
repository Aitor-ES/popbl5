<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Start: Register  -->
<section id="register">
  <div class="container-fluid">
    <!-- Start: Logo -->
    <div class="row mt-4">
      <div class="col text-center">
        <img src="${pageContext.request.contextPath}/static/img/login/logo.png" alt="<spring:message code="register.logo.alt"/>">
      </div>
    </div>
    <!-- End: Logo -->
    
    <!--  Start: Title -->
    <div id="register-title" class="row">
      <div class="col text-center">
        <h2 class="h2 mt-3 mb-3 font-weight-normal"><spring:message code="register.label"/></h2>
      </div>
    </div>
    <!-- End: Title -->
    
    <!-- Start: Register -->
    <form name="registerForm" action="${pageContext.request.contextPath}/register/form" method='POST'>
      <div class="row justify-content-center mb-5">
        <div class="modal-content col-10 col-md-8 col-lg-6 col-xl-4">
        
          <!-- Username -->
          <div class="input-group">
            <div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-user"></i></span></div>
            <input type="text" class="form-control" name='username' placeholder="<spring:message code="register.username"/>" required>
          </div>
          
          <!-- Email -->
          <div class="input-group mt-3">
            <div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-at"></i></span></div>
            <input type="text" class="form-control" name='email' placeholder="<spring:message code="register.email"/>" required>
          </div>
          
          <!-- Password -->
          <div class="input-group mt-3">
            <div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-lock"></i></span></div>
            <input type="password" class="form-control" name='password' placeholder="<spring:message code="register.password"/>" required>
          </div>
          
          <!-- Confirm password -->
          <div class="input-group mt-3">
            <div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-key"></i></span></div>
            <input type="password" class="form-control" name='confirmPassword' placeholder="<spring:message code="register.confirm.password"/>" required>
          </div>
          
          <!-- Progress bar -->
          <div class="progress mt-3" id="myProgressBar" style="display: none">
            <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%"></div>
          </div>
          
          <!-- Button -->
          <button class="button-style btn btn-lg btn-warning mt-3" type="submit" name="submit" onclick="userProgress()"><i class="fas fa-plus"></i> <spring:message code="action.create"/></button>
        
        </div>
      </div>
    </form>
    <!-- End: Register -->
  
    <!-- Start: Top button -->
    <button class="button-style btn btn-lg btn-warning" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
    <!-- End: Top button -->
  
  </div>
</section>
<!-- End: Register -->