<%@ taglib
  prefix="c"
  uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib
  uri="http://www.springframework.org/tags"
  prefix="spring"%>

<c:choose>
  <c:when test="${not empty user}">
    <div class="container-fluid ">
      <div class="row align-items-center">
        <div class="col align-self-start">
          <h2>Edit User data</h2>
        </div>
      </div>
      <div class="row align-items-center">
        <div col="align-self-center">
          <form>
            <div class="form-group">
              <label for="userEditData"><spring:message code="userData.email"/></label><input
                type="email"
                class="form-control"
                id="inputFirstName"
                placeholder="Enter your new email">
            </div>
            <div class="form-group">
              <label for="userEdtiData"><spring:message code="userData.password"/></label>
              <input
                type="password"
                class="form-control"
                id="inputSecondName"
                placeholder="Enter your new password">
            </div>
            <button
              type="submit"
              class="btn btn-primary">Update</button>
          </form>
        </div>
      </div>
    </div>
  </c:when>
  <c:otherwise>
    <div
      class="alert alert-danger alert-dismissible"
      role="alert">
      <p>An error has been occurred</p>
      <button
        type="button"
        class="close"
        data-dismiss="alert"
        aria-label="Close">
        <span aria-hidden="true">&times;</span>
      </button>
    </div>
  </c:otherwise>
</c:choose>
