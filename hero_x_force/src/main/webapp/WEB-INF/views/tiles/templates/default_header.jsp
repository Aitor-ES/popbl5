<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Start: Header  -->
<header id="header" class="navbar navbar-expand navbar-dark d-flex justify-content-between">

  <!-- Start: Logo -->
  <a class="navbar-brand" href="${pageContext.request.contextPath}/">
    <img src="${pageContext.request.contextPath}/static/img/default/horizontal_logo.png" width="100" height="40" alt="Hero X-Force">
  </a>
  <!-- End: Logo -->
  
  <!-- Start: Navbar -->
  <ul class="navbar-nav">
  
    <!-- List: Links & Button -->
    <c:choose>
      <c:when test="${not empty sessionScope.user}">
        <li class="nav-item">
          <form action="${pageContext.request.contextPath}/logout">
            <button class="btn btn-lg btn-danger" id="header_button" type="submit" name="action" value="logout"><i class="fas fa-sign-in-alt"></i> <spring:message code="action.logout"/></button>
          </form>
        </li>
      </c:when>
      <c:otherwise>
        <c:choose>
          <c:when test="${springViewName == 'home'}">
            <li class="nav-item">
              <a class="nav-link text-light" id="header_link" href="${pageContext.request.contextPath}/login"><i class="fas fa-chevron-right"></i> <spring:message code="action.login"/></a> 
             </li>
          </c:when>
          <c:when test="${springViewName == 'register'}">
            <li class="nav-item">
              <a class="nav-link text-light" id="header_link" href="${pageContext.request.contextPath}/login"><i class="fas fa-chevron-left"></i> <spring:message code="header.backToLogin"/></a> 
             </li>
          </c:when>
          <c:when test="${springViewName == 'forgot'}">
            <li class="nav-item">
              <a class="nav-link text-light" id="header_link" href="${pageContext.request.contextPath}/login"><i class="fas fa-chevron-left"></i> <spring:message code="header.backToLogin"/></a> 
             </li>
          </c:when>
          <c:otherwise>
            <li class="nav-item">
              <a class="nav-link text-light" id="header_link" href="${pageContext.request.contextPath}/"><i class="fas fa-chevron-left"></i> <spring:message code="header.backToHome"/></a> 
            </li>
          </c:otherwise>
        </c:choose>
      </c:otherwise>
    </c:choose>

    <!-- Dropdown: Language -->
    <li class="nav-item dropdown" id="language-select">
      <a class="nav-link dropdown-toggle" href="#" id="navdrop" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        <c:choose>
          <c:when test="${pageContext.response.locale.language == 'en'}">
            <img src="${pageContext.request.contextPath}/static/img/default/united_kingdom.png" width="40" height="40" alt="<spring:message code="language.en"/>">
          </c:when>
          <c:when test="${pageContext.response.locale.language == 'es'}">
            <img src="${pageContext.request.contextPath}/static/img/default/spain.png" width="40" height="40" alt="<spring:message code="language.es"/>">
          </c:when>
          <c:when test="${pageContext.response.locale.language == 'eu'}">
            <img src="${pageContext.request.contextPath}/static/img/default/basque_country.png" width="40" height="40" alt="<spring:message code="language.eu"/>">
          </c:when>
          <c:otherwise>
            <img src="${pageContext.request.contextPath}/static/img/default/united_kingdom.png" width="40" height="40" alt="<spring:message code="language.en"/>">
          </c:otherwise>
        </c:choose>
      </a>
      <div class="dropdown-menu">
        <a class="dropdown-item" href="${pageContext.request.contextPath}/${springViewName}?lang=en" role="button">
          <img src="${pageContext.request.contextPath}/static/img/default/united_kingdom.png" width="40" height="40" alt="<spring:message code="language.en"/>">
        </a>
        <a class="dropdown-item" href="${pageContext.request.contextPath}/${springViewName}?lang=es" role="button">
          <img src="${pageContext.request.contextPath}/static/img/default/spain.png" width="40" height="40" alt="<spring:message code="language.es"/>">
        </a>
        <a class="dropdown-item" href="${pageContext.request.contextPath}/${springViewName}?lang=eu" role="button">
          <img src="${pageContext.request.contextPath}/static/img/default/basque_country.png" width="40" height="40" alt="<spring:message code="language.eu"/>">
        </a>
      </div>
    </li>

  </ul>
  <!-- End: Navbar -->
  
</header>
<!-- End: Header -->