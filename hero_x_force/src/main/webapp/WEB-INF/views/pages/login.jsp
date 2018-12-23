<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<main id="login">
  <div class="modal-dialog text-center">
    <div class="col-sm-8 main-section">
      <div class="modal-content">
        <div class="col-12 user-img">
          <img src="${pageContext.request.contextPath}/static/img/login.jpg"/>
        </div>
        
        <form class="col-12" action="login" method='GET'>
          <div class="form-group" id="username">
            <input type="text" class="form-control" name='username' placeholder="Enter Username">
          </div>
          <div class="form-group" id="password">
            <input type="password" class="form-control" name='password' placeholder="Enter Password">
          </div>
          <button type="submit" class="btn" name="submit"><i class="fas fa-sign-in-alt"></i> Login</button>
        </form>
        
        <div class="col-12 forgot">
          <a href="#">Register</a>
        </div>
      </div> <!-- End of Modal Content -->
    </div>
  </div>
</main>