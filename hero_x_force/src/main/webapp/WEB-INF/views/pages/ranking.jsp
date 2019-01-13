<!-- Page directives -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Spring library -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- JSTL library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<section id="ranking">
  <h2><spring:message code="ranking.title" /></h2>

  <table class="table table-hover">
    <thead class="thead-dark">
      <tr>
        <th scope="col"><spring:message code="ranking.table.number" /></th>
        <th scope="col"><spring:message code="ranking.table.username" /></th>
        <th scope="col"><spring:message code="ranking.table.battlesWon" /></th>
        <th scope="col"><spring:message code="ranking.table.battlesLost" /></th>
        <th scope="col"><spring:message code="ranking.table.points" /></th>
      </tr>
    </thead>
    <tbody>
      <c:forEach items="${ranking}" var="user">
        <tr>
          <th scope="row">${user.user_id}</th>
          <td>${user.username}</td>
          <td>${user.wins}</td>
          <td>${user.loses}</td>
          <td>${user.points}</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</section>