<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<fmt:bundle basename="edu.mondragon.lang.View">

<header class="navbar navbar-expand navbar-dark bg-dark d-flex justify-content-between">
  <!-- Logo -->
  <a class="navbar-brand" href="${pageContext.request.contextPath}/">
    <!--img src="${pageContext.request.contextPath}/static/img/horizontal_logo.png" width="100" height="40" alt="Hero X-Force Logo"-->
    <fmt:message key="header.appName"/>
  </a>

  
  <!-- Lang & Login/logout -->
  <ul class="nav navbar-nav ">
    <!-- Enable language changing -->
    <li class="nav-item dropdown">
      <a class="nav-link dropdown-toggle" href="#" id="navdrop" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <fmt:message key="header.lang"></fmt:message>
      </a>
      <div class="dropdown-menu" aria-labelledby="navdrop">
        <!--form name='locale-form' action="locale" method="GET"-->
          <button class="dropdown-item" type="submit" name="langTag" value="en"><fmt:message key="language.en"/></button>
          <button class="dropdown-item" type="submit" name="langTag" value="es-ES"><fmt:message key="language.es"/></button>
          <button class="dropdown-item" type="submit" name="langTag" value="eu"><fmt:message key="language.eu"/></button>
        <!--/form-->
      </div>
    </li>

    <!-- Logout option if the user is logged -->
    <c:choose>
      <c:when test="${empty sessionScope.user}">
        <li class="nav-item">
            <button class="btn" onclick="window.location.href='${pageContext.request.contextPath}/login'"><i class="fas fa-sign-in-alt"></i> <fmt:message key="action.login"/></button>
        </li>
      </c:when>
      <c:otherwise>
        <li class="nav-item">
          <form action="logout">
            <button class="btn" type="submit" name="action" value="logout"><i class="fas fa-sign-in-alt"></i> <fmt:message key="action.logout"/></button>
          </form>
        </li>
      </c:otherwise>
    </c:choose>
  </ul>
</header>

</fmt:bundle>