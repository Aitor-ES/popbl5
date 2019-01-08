<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="register" class="text-center">

  <img class="mt-5" src="${pageContext.request.contextPath}/static/img/login/logo.png" alt="<spring:message code="login.logo.alt"/>">
  <h1 class="h2 mt-3 mb-3 font-weight-normal"><spring:message code="register.label"/></h1>
  <form action="${pageContext.request.contextPath}/register/form" method='POST'>    
    <div class="row justify-content-center mb-5">
      <div class="modal-content col-10 col-md-6 col-lg-4 col-xl-4">
        <div class="input-group">
          <div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-user"></i></span></div>
          <input type="text" class="form-control" name='username' placeholder="<spring:message code="register.username"/>" required>
          <div class="invalid-feedback">Your username is required.</div>
        </div>
        <div class="input-group mt-3">
          <div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-at"></i></span></div>
          <input type="text" class="form-control" name='email' placeholder="<spring:message code="register.email"/>" required>
          <div class="invalid-feedback">Your username is required.</div>
        </div>
        <div class="input-group mt-3">
          <div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-lock"></i></span></div>
          <input type="password" class="form-control" name='password' placeholder="<spring:message code="register.password"/>" required>
          <div class="invalid-feedback">Your password is required.</div>
        </div>
        <div class="input-group mt-3">
          <div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-key"></i></span></div>
          <input type="password" class="form-control" name='confirmPassword' placeholder="<spring:message code="register.confirm.password"/>" required>
          <div class="invalid-feedback">Your password is required.</div>
        </div>
        <button class="btn btn-lg btn-primary mt-3" type="submit" name="submit"><i class="fas fa-plus"></i> <spring:message code="register.create.account"/></button>
      </div>
    </div>
  </form>
</div>