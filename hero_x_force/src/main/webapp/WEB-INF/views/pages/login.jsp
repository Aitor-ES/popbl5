<!-- Page directives -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!-- JSTL library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- SPRING library -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h2>Login</h2>

<form name='login-form' action="login" method='GET'>
  <table>
    <tr>
      <td>Nickname:</td>
      <td><input type='text' name='username' value='' /></td>
    </tr>
    <tr>
      <td>Password:</td>
      <td><input type='password' name='password' /></td>
    </tr>
    <tr>
      <td><input name="submit" type="submit" value="submit" /></td>
    </tr>
  </table>
</form>