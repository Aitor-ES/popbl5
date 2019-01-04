<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="home">
  <!-- Start: Carousel -->
  <div id="myCarousel" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <img class="first-slide" src="${pageContext.request.contextPath}/static/img/home/first_slide.jpg" alt="<spring:message code="home.carousel.first.alt"/>">
        <div class="container">
          <div class="carousel-caption text-left">
            <h1><spring:message code="home.carousel.first.label"/></h1>
            <p><spring:message code="home.carousel.first.text"/></p>
            <p><a class="btn btn-lg btn-primary" href="${pageContext.request.contextPath}/login" role="button">Sign up today</a></p>
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <img class="second-slide" src="${pageContext.request.contextPath}/static/img/home/second_slide.jpg" alt="<spring:message code="home.carousel.second.alt"/>">
        <div class="container">
          <div class="carousel-caption">
            <h1><spring:message code="home.carousel.second.label"/></h1>
            <p><spring:message code="home.carousel.second.text"/></p>
            <p><a class="btn btn-lg btn-primary" href="#" role="button">Learn more</a></p>
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <img class="third-slide" src="${pageContext.request.contextPath}/static/img/home/third_slide.jpg" alt="<spring:message code="home.carousel.third.alt"/>">
        <div class="container">
          <div class="carousel-caption text-right">
            <h1><spring:message code="home.carousel.third.label"/></h1>
            <p><spring:message code="home.carousel.third.text"/></p>
            <p><a class="btn btn-lg btn-primary" href="#" role="button">Browse gallery</a></p>
          </div>
        </div>
      </div>
    </div>
    <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
  <!-- End: Carousel -->
  
  <!-- Start: Features -->
  <div class="container features">
    <div class="row">
      <div class="col-lg-3">
        <img class="rounded-circle" src="${pageContext.request.contextPath}/static/img/home/f1.png" alt="<spring:message code="home.features.first.alt"/>" width="140" height="140">
        <h2><spring:message code="home.features.first.label"/></h2>
        <p><spring:message code="home.features.first.text"/></p>
      </div>
      <div class="col-lg-3">
        <img class="rounded-circle" src="${pageContext.request.contextPath}/static/img/home/f2.png" alt="<spring:message code="home.features.second.alt"/>" width="140" height="140">
        <h2><spring:message code="home.features.second.label"/></h2>
        <p><spring:message code="home.features.second.label"/></p>
      </div>
      <div class="col-lg-3">
        <img class="rounded-circle" src="${pageContext.request.contextPath}/static/img/home/f3.png" alt="<spring:message code="home.features.third.alt"/>" width="140" height="140">
        <h2><spring:message code="home.features.third.label"/></h2>
        <p><spring:message code="home.features.third.label"/></p>
      </div>
      <div class="col-lg-3">
        <img class="rounded-circle" src="${pageContext.request.contextPath}/static/img/home/f4.png" alt="<spring:message code="home.features.fourth.alt"/>" width="140" height="140">
        <h2><spring:message code="home.features.fourth.label"/></h2>
        <p><spring:message code="home.features.fourth.label"/></p>
      </div>
    </div>
  </div> 
  <!-- End: Features -->
  
  <!-- Start: News info -->
  <div class="container news">
    <hr class="news-divider">
  
    <div class="row news">
      <div class="col-md-7">
        <h2 class="news-heading">First featurette heading. <span class="text-muted">It'll blow your mind.</span></h2>
        <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
      </div>
      <div class="col-md-5">
        <img class="news-image img-fluid mx-auto" src="${pageContext.request.contextPath}/static/img/home/n1.jpg" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
      </div>
    </div>

    <hr class="news-divider">
  
    <div class="row news">
      <div class="col-md-7 order-md-2">
        <h2 class="news-heading">Oh yeah, it's that good. <span class="text-muted">See for yourself.</span></h2>
        <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
      </div>
      <div class="col-md-5 order-md-1">
        <img class="news-image img-fluid mx-auto" src="${pageContext.request.contextPath}/static/img/home/n2.jpg" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
      </div>
    </div>
  
    <hr class="news-divider">
  
    <div class="row news">
      <div class="col-md-7">
        <h2 class="news-heading">And lastly, this one. <span class="text-muted">Checkmate.</span></h2>
        <p class="lead">Donec ullamcorper nulla non metus auctor fringilla. Vestibulum id ligula porta felis euismod semper. Praesent commodo cursus magna, vel scelerisque nisl consectetur. Fusce dapibus, tellus ac cursus commodo.</p>
      </div>
      <div class="col-md-5">
        <img class="news-image img-fluid mx-auto" src="${pageContext.request.contextPath}/static/img/home/n3.jpg" data-src="holder.js/500x500/auto" alt="Generic placeholder image">
      </div>
    </div>
  
    <hr class="news-divider">
  </div> 
  <!-- End: News info -->
  
  <!-- Start: Jumbotron! -->
  <div class="jumbotron p-5 p-md-5 m-md-5 text-center">
    <h1 class="display-4"><spring:message code="home.contact.label"/></h1>
    <p class="lead"><spring:message code="home.contact.text"/></p>
    <hr class="my-4">
    <p><spring:message code="home.contact.info"/></p>
    <a class="btn btn-lg btn-primary text-white" data-toggle="modal" data-target="#exampleModal"><spring:message code="home.contact.button"/></a>
  </div>
  <!-- End: Jumbotron! -->
  
  <!-- Start: Modal! -->
  <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">New message</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <form>
          <div class="col-auto">
              <label class="sr-only" for="inlineFormInputGroup">Username</label>
              <div class="input-group mb-2">
                <div class="input-group-prepend">
                  <div class="input-group-text"><i class="fas fa-user"></i></div>
                </div>
                <input type="text" class="form-control" id="inlineFormInputGroup" placeholder="Username">
              </div>
            </div>
            <div class="form-group">
              <label for="recipient-name" class="col-form-label">Recipient:</label>
              <input type="text" class="form-control" id="recipient-name">
            </div>
            <div class="form-group">
              <label for="message-text" class="col-form-label">Message:</label>
              <textarea class="form-control" id="message-text"></textarea>
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
          <button type="button" class="btn btn-primary">Send message</button>
        </div>
      </div>
    </div>
  </div>
  <!-- End: Modal! -->
  
  <!-- Start: Back to top button -->
  <button class="btn btn-lg btn-primary" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
  <!-- End: Back to top button -->
</div>