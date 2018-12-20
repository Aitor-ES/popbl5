<!-- Page directives -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div class="navbar navbar-expand-md navbar-dark bg-dark">
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
          href="${pageContext.request.contextPath}/profile">Profile</a>
      </li>
      <li class="nav-item">
        <a class="nav-link"
          href="${pageContext.request.contextPath}/decks">Decks</a>
      </li>
      <li class="nav-item">
        <a class="nav-link"
          href="${pageContext.request.contextPath}/heroes">Heroes</a>
      </li>
      <li class="nav-item">
        <a class="nav-link"
          href="${pageContext.request.contextPath}/duels">Duels</a>
      </li>
      <li class="nav-item">
        <a class="nav-link"
          href="${pageContext.request.contextPath}/tournaments">Tournaments</a>
      </li>
      <li class="nav-item">
        <a class="nav-link"
          href="${pageContext.request.contextPath}/ranking">Ranking</a>
      </li>
    </ul>
  </div>
</div>