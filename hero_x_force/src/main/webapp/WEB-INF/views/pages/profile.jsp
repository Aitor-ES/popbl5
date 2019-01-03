<%@ taglib
  prefix="c"
  uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
  <c:when test="${not empty user}">
    <div class="container-fluid ">
      <div class="row">
        <div class="col align-self-start">
          <h2>${user.firstName}'s profile</h2>
        </div>
        <div class="col-1 align-self-end">
          <button
            type="button"
            class="btn btn-primary">Edit profile</button>
        </div>
      </div>
      <div class="row align-items-center">
        <div class="col">
          <p>First name:</p>
          <p>Last name:</p>
          <p>email:</p>
          <p>Points:</p>
          <p>Battles won:</p>
          <p>Battles lost:</p>
        </div>
        <div class="col">
          <p>win percentage pie chart</p>
        </div>
      </div>
    </div>

    <div class="container-fluid ">
      <div class="row align-items-center">
       <div
          class="col-8"
          id="achievementTable">
          <h2>Achievements:</h2>
          <table class="table">
            <thead>
              <tr>
                <th>Name</th>
                <th>Unlocked date</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>Achievement 1</td>
                <td>12/21/2018</td>
              </tr>
              <tr>
                <td>Achievement 1</td>
                <td>12/21/2018</td>
              </tr>
              <tr>
                <td>Achievement 1</td>
                <td>12/21/2018</td>
              </tr>
            </tbody>
          </table>
        </div>
        <div
          class="col-4"
          id="winChart">
          <p>Achievement percentage pie chart</p>
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
