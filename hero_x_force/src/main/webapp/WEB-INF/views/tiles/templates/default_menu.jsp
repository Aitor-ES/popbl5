<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div id="menu">
  <div class="navbar navbar-expand-md navbar-dark">
    <!-- Navbar toggler -->
    <button class="navbar-toggler" type="button" data-toggle="collapse"
      data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
      aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <!-- Navbar items -->
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav nav-fill w-100">
        <li class="nav-item">
          <a class="nav-link"
            href="${pageContext.request.contextPath}/profile/data"><spring:message code="header.profile"/></a>
        </li>
        <li class="nav-item">
          <a class="nav-link"
            href="${pageContext.request.contextPath}/deck/list"><spring:message code="header.decks"/></a>
        </li>
        <li class="nav-item">
          <a class="nav-link"
            href="${pageContext.request.contextPath}/card/list"><spring:message code="header.heroes"/></a>
        </li>
        <li class="nav-item">
          <a class="nav-link"
            href="${pageContext.request.contextPath}/duel/list"><spring:message code="header.duels"/></a>
        </li>
        <li class="nav-item">
          <a class="nav-link"
            href="${pageContext.request.contextPath}/tournaments"><spring:message code="header.tournaments"/></a>
        </li>
        <li class="nav-item">
          <a class="nav-link"
            href="${pageContext.request.contextPath}/ranking"><spring:message code="header.ranking"/></a>
        </li>
      </ul>
    </div>
  </div>
</div>