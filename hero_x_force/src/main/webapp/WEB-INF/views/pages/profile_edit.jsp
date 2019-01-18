<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Start: Profile edit -->
<section id="profile-edit">
  <div class="container-fluid">
  
    <!-- Start: Title & Button -->
    <div class="row px-sm-4 pt-4">
    
      <!-- Title -->
      <div class="col-8 col-sm-10">
        <h2 class="title-style"><spring:message code="profile.edit.title" /></h2>
      </div>
      
      <!-- Button -->
      <div class="col-4 col-sm-2 d-flex justify-content-end align-items-center">
        <a class="button-style btn btn-lg btn-warning" href="${pageContext.request.contextPath}/profile/data" role="button">
          <i class="fas fa-times-circle"></i> <spring:message code="action.cancel"/>
        </a>
      </div>
    </div>
    <!-- End: Title & Button -->
    
    <!-- Start: Data -->
    <form name="userForm" action="${pageContext.request.contextPath}/profile/form" method='POST'> 
    
      <!-- User name -->
      <div class="row px-sm-5 mt-4 mt-sm-2">
        <div class="col col-lg-6">
          <label><spring:message code="profile.edit.username.title"/></label>
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text"><i class="fas fa-user"></i></span>
            </div>
            <input type="text" class="form-control" name='username' placeholder="<spring:message code="profile.edit.username.placeholder"/>"
              value="${user.username}" required>
          </div>
        </div>
      </div>
      
      <!-- Email -->
      <div class="row px-sm-5 mt-2">
        <div class="col col-lg-6">
          <label><spring:message code="profile.edit.email.title"/></label>
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text"><i class="fas fa-at"></i></span>
            </div>
            <input type="text" class="form-control" name='email' placeholder="<spring:message code="profile.edit.email.placeholder"/>" 
              value="${user.email}" required>
          </div>
        </div>
      </div>
      
      <!-- Password -->
      <div class="row px-sm-5 mt-2">
        <div class="col col-lg-6">
          <label><spring:message code="profile.edit.password.title"/></label>
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text"><i class="fas fa-lock"></i></span>
            </div>
            <input type="password" class="form-control" name='password' placeholder="<spring:message code="profile.edit.password.placeholder"/>" 
              value="${user.password}" required>
          </div>
        </div>
      </div>
      
      <!-- Confirm password -->
      <div class="row px-sm-5 mt-2 mb-3">
        <div class="col col-lg-6">
          <label><spring:message code="profile.edit.password.confirm.title"/></label>
          <div class="input-group">
            <div class="input-group-prepend">
              <span class="input-group-text"><i class="fas fa-key"></i></span>
            </div>
            <input type="password" class="form-control" name='confirmPassword' placeholder="<spring:message code="profile.edit.password.confirm.placeholder"/>" 
              value="${user.password}" required>
          </div>
        </div> 
      </div>
      
      <!-- Progress bar -->
      <div class="row px-sm-5">
         <div class="col col-lg-6">
          <div class="progress" id="myProgressBar" style="display: none">
            <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" 
              aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
            </div>
          </div>
        </div> 
      </div>  
      
      <!-- Button -->   
      <div class="row px-sm-5 mt-3">
        <div class="col">  
           <button class="button-style btn btn-lg btn-warning" type="submit" name="submit" onclick="userProgress()">
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
<!-- End: Profile edit -->