<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<section id="profile-edit">

      <div class="container-fluid ">
        <div class="row align-items-center">
          <div class="col align-self-center">
            <form name="userForm" action="${pageContext.request.contextPath}/profile/form" method='POST'>
              <label class="mt-3"><spring:message code="profile.edit.username.title"/></label>
              <div class="input-group">
                <div class="input-group-prepend">
                  <span class="input-group-text"><i class="fas fa-user"></i></span>
                </div>
                <input type="text" class="form-control" name='username' placeholder="<spring:message code="profile.edit.username.placeholder"/>"
                  value="${user.username}" required>
              </div>
              
              <label class="mt-3"><spring:message code="profile.edit.email.title"/></label>
              <div class="input-group">
                <div class="input-group-prepend">
                  <span class="input-group-text"><i class="fas fa-at"></i></span>
                </div>
                <input type="text" class="form-control" name='email' placeholder="<spring:message code="profile.edit.email.placeholder"/>" 
                  value="${user.email}" required>
              </div>
              
              <label class="mt-3"><spring:message code="profile.edit.password.title"/></label>
              <div class="input-group">
                <div class="input-group-prepend">
                  <span class="input-group-text"><i class="fas fa-lock"></i></span>
                </div>
                <input type="password" class="form-control" name='password' placeholder="<spring:message code="profile.edit.password.placeholder"/>" 
                  value="${user.password}" required>
              </div>
              
              <label class="mt-3"><spring:message code="profile.edit.password.confirm.title"/></label>
              <div class="input-group">
                <div class="input-group-prepend">
                  <span class="input-group-text"><i class="fas fa-key"></i></span>
                </div>
                <input type="password" class="form-control" name='confirmPassword' placeholder="<spring:message code="profile.edit.password.confirm.placeholder"/>" 
                  value="${user.password}" required>
              </div>
              
              <div class="progress mt-3" id="myProgressBar" style="display: none">
                <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" 
                  aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%">
                </div>
              </div>
              
              <a class="btn btn-lg btn-warning mt-3 mb-3" href="${pageContext.request.contextPath}/profile/data" role="button">
                <i class="fas fa-times-circle"></i> <spring:message code="profile.edit.cancel"/>
              </a>
              
              <button class="btn btn-lg btn-warning ml-3 mt-3 mb-3" type="submit" name="submit" onclick="userProgress()">
                <i class="fas fa-check-circle"></i> <spring:message code="profile.edit.accept" />
              </button>
            </form>
          </div>
        </div>
      </div>

</section>