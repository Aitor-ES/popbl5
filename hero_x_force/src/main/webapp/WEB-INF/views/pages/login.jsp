<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Start: Login  -->
<section id="login">

  <!-- Start: Logo -->
  <div class="row mt-4">
    <div class="col text-center">
      <img src="${pageContext.request.contextPath}/static/img/login/logo.png" alt="<spring:message code="login.logo.alt"/>">
    </div>
  </div>
  <!-- End: Logo -->
  
  <!--  Start: Title -->
  <div id="login-title" class="row">
    <div class="col text-center">
      <h2 class="h2 mt-3 mb-3 font-weight-normal"><spring:message code="login.label"/></h2>
    </div>
  </div>
  <!-- End: Title -->
  
  <!-- Start: Sign in -->
  <form name="loginForm" action="${pageContext.request.contextPath}/login/form" method='POST'>    
    <div class="row justify-content-center mb-5">
      <div class="modal-content col-10 col-md-8 col-lg-6 col-xl-4">
      
        <!-- Input: Username -->
        <div class="input-group">
          <div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-user"></i></span></div>
          <input type="text" class="form-control" name='username' placeholder="<spring:message code="login.username"/>" required>
        </div>
        
        <!-- Input: Password -->
        <div class="input-group mt-3">
          <div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-lock"></i></span></div>
          <input type="password" class="form-control" name='password' placeholder="<spring:message code="login.password"/>" required>
        </div>
        
        <!-- Button: Sign in -->
        <button class="btn btn-lg btn-warning mt-3" type="submit" name="submit"><i class="fas fa-sign-in-alt"></i> <spring:message code="login.singIn"/></button>
        
        <div class="row">
        
          <!-- Link: Register -->
          <div id="register-link" class="col-sm mt-2 text-center">
            <a class="text-white" href="${pageContext.request.contextPath}/register"><spring:message code="login.register"/></a>
          </div>
          
          <!-- Link: Forgot -->
          <div id="recover-link" class="col-sm mt-2 text-center">
            <a class="text-white" href="${pageContext.request.contextPath}/forgot"><spring:message code="login.forgot"/></a>
          </div>
          
        </div>
      </div>
    </div>
  </form>
  <!-- End: Sign in -->
  
  <!-- Start: Top button -->
  <button class="btn btn-lg btn-warning" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
  <!-- End: Top button -->
</section>
<!-- End: Login -->