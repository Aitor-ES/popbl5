<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="forgot" class="text-center">

  <img class="mt-5" src="${pageContext.request.contextPath}/static/img/login/logo.png" alt="<spring:message code="login.logo.alt"/>">
  <h1 class="h2 mt-3 mb-3 font-weight-normal"><spring:message code="forgot.label"/></h1>
  <form action="forgotForm" method='GET'>    
    <div class="row justify-content-center mb-5">
      <div class="modal-content col-10 col-md-6 col-lg-4 col-xl-4">
        <div class="input-group">
          <div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-at"></i></span></div>
          <input type="text" class="form-control" name='email' placeholder="<spring:message code="forgot.email"/>" required>
        </div>
        <button class="btn btn-lg btn-primary mt-3" type="submit" name="submit"><i class="fas fa-share-square"></i> <spring:message code="forgot.send"/></button>
      </div>
    </div>
  </form>
</div>