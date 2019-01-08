<%@ taglib
  prefix="c"
  uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
  <c:when test="${not empty user}">
    <div class="container-fluid ">
      <div class="row">
        <div class="col align-self-start">
          <h2>Edit/Create card</h2>
        </div>
      </div>
      <div class="row align-items-center">
        <div class="col-3">
          <p>Card image</p>
        </div>

        <div class="col-3">
          <form>
            <div class="form-group">
              <label for="cardEditName">Card name:</label> <input
                type="text"
                class="form-control"
                id="inputCardName"
                placeholder="Enter card name">
            </div>
            <div class="form-group">
              <label for="cardEditType">Card type:</label> <input
                type="text"
                class="form-control"
                id="inputCardType"
                placeholder="Enter card type">
            </div>

            <div class="form-group">
              <label for="cardEditSaga">Card saga:</label> <input
                type="text"
                class="form-control"
                id="inputCardSaga"
                placeholder="Enter card saga">
            </div>
          </form>
        </div>
        <div class="col-3">
          <form>
            <div class="form-group">
              <label for="cardEditAttack">Attack value:</label> <input
                type="text"
                class="form-control"
                id="inputCardAttack"
                placeholder="Enter card atttack">
            </div>
            <div class="form-group">
              <label for="cardEditMagicAttack">Magic attack
                value:</label> <input
                type="text"
                class="form-control"
                id="inputCardMagicAttack"
                placeholder="Enter card magic attack">
            </div>
            <div class="form-group">
              <label for="cardEditdefense">Defense value:</label> <input
                type="text"
                class="form-control"
                id="inputCardDefense"
                placeholder="Enter card defense">
            </div>
          </form>
        </div>
        <div class="col-3">
          <form>
            <div class="form-group">
              <label for="cardEditMagicDefense">Magic defense
                value:</label> <input
                type="text"
                class="form-control"
                id="inputCardMagicDefense"
                placeholder="Enter card special attack">
            </div>
            <div class="form-group">
              <label for="cardEditSpeeed">Speed value:</label> <input
                type="text"
                class="form-control"
                id="inputCardSpeed"
                placeholder="Enter card speed">
            </div>
            <div class="form-group">
              <label for="cardHealth">Health value:</label> <input
                type="text"
                class="form-control"
                id="inputCardHealth"
                placeholder="Enter card health">
            </div>
          </form>
        </div>
      </div>
      <div class="row justify-content-center">
        <div class="col offset-3">
          <button
            type="submit"
            class="btn btn-primary">Submit</button>
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
