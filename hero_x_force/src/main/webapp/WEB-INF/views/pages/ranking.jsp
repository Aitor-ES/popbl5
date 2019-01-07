<!-- Page directives -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!-- Spring library -->
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!-- JSTL library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

  <h2>
   <spring:message code="ranking.title" />
  </h2>

  <table class="table table-hover">
    <thead class="thead-dark">
      <tr>
        <th scope="col"><spring:message code="ranking.table.number" /></th>
        <th scope="col"><spring:message code="ranking.table.username" /></th>
        <th scope="col"><spring:message code="ranking.table.battlesWon" /></th>
        <th scope="col"><spring:message code="ranking.table.battlesLost" /></th>
        <th scope="col"><spring:message code="ranking.table.winPercentage" /></th>
        <th scope="col"><spring:message code="ranking.table.achievements" /></th>
      </tr>
    </thead>
    <tbody>
    <!--  <c:forEach items="${UserList}" var="user">
      <tr>
        <th scope="row">${user.id}</th>
        <td>${user.name}</td>
        <td>${user.wins}</td>
        <td>${user.loses}</td>
        <td>${user.win-percentage}</td>
        <td>${user.achievements}</td>
      </tr>
       </c:forEach>--> 
      <tr>
        <th scope="row">2</th>
        <td>aEstarrona</td>
        <td>9</td>
        <td>1</td>
        <td>9.0</td>
        <td>10</td>
      </tr>
      <tr>
        <th scope="row">3</th>
        <td>aAlonso</td>
        <td>1</td>
        <td>10</td>
        <td>0.1</td>
        <td>0</td>
      </tr>
    </tbody>
  </table>
