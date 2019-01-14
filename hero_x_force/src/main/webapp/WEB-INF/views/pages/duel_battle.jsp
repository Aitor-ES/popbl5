<!-- Page directives -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- Spring tags -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!-- JSTL tags -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="duel-result">
  <div class="container-fluid">
    <h2>Battle!</h2>
    <a class="btn bd-highlight mr-1" href="${pageContext.request.contextPath}/duel/battle"
          role="button">Start</a>
    <div id="battle-log"></div>
  </div>
</section>