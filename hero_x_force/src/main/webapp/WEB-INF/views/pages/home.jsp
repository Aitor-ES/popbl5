<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2>Login</h2>

<c:if test="${not empty msg}">
  <p>${msg}</p>
</c:if>

<form name='login-form' action="login" method='POST'>
  <table>
    <tr>
      <td>User:</td>
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