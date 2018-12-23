<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<header class="navbar navbar-expand navbar-dark bg-dark d-flex justify-content-between">
  <!-- Logo -->
  <a class="navbar-brand" href="${pageContext.request.contextPath}/">
    <img src="${pageContext.request.contextPath}/static/img/horizontal_logo.png" width="100" height="40" alt="Hero X-Force Logo">
    <spring:message code="header.appName"/>
  </a>
  
  <!-- Lang & Login/logout -->
  <ul class="nav navbar-nav ">
    <!-- Enable language changing -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navdrop" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <spring:message code="header.lang"/>
      </a>
      <div class="dropdown-menu" aria-labelledby="navdrop">
        <a class="dropdown-item" href="${pageContext.request.contextPath}/${springViewName}?lang=en" role="button"><spring:message code="language.en"/></a>
        <a class="dropdown-item" href="${pageContext.request.contextPath}/${springViewName}?lang=es" role="button"><spring:message code="language.es"/></a>
        <a class="dropdown-item" href="${pageContext.request.contextPath}/${springViewName}?lang=eu" role="button"><spring:message code="language.eu"/></a>
      </div>
    </li>

    <!-- Logout option if the user is logged -->
    <c:choose>
      <c:when test="${empty sessionScope.user}">
        <li class="nav-item">
            <button class="btn" onclick="window.location.href='${pageContext.request.contextPath}/login'"><i class="fas fa-sign-in-alt"></i> <spring:message code="action.login"/></button>
        </li>
      </c:when>
      <c:otherwise>
        <li class="nav-item">
          <form action="logout">
            <button class="btn" type="submit" name="action" value="logout"><i class="fas fa-sign-in-alt"></i><spring:message code="action.logout"/></button>
          </form>
        </li>
      </c:otherwise>
    </c:choose>
  </ul>
</header>
