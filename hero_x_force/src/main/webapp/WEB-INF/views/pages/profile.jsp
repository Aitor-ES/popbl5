<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h2>Profile</h2>
<c:choose>
  <c:when test="${not empty user}">
    <p>${user.id}</p>
    <p>${user.firstName}</p>
    <p>${user.lastName}</p>
    <p>${user.email}</p>
    <p>${user.password}</p>
  </c:when>
  <c:otherwise>
    <p>WIP</p>
  </c:otherwise>
</c:choose>

