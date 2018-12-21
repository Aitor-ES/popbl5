<!-- Page directives -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<!-- FMT library -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<fmt:bundle basename="edu.mondragon.lang.View">

  <h2>
    <fmt:message key="header.ranking" />
  </h2>

  <table class="table table-hover">
    <thead class="thead-dark">
      <tr>
        <th scope="col">Nº</th>
        <th scope="col">Player</th>
        <th scope="col">Battles won</th>
        <th scope="col">Battles lost</th>
        <th scope="col">Win percentage</th>
        <th scope="col">Achievements</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <th scope="row">1</th>
        <td>imendi</td>
        <td>10</td>
        <td>0</td>
        <td>10.0</td>
        <td>15</td>
      </tr>
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



</fmt:bundle>