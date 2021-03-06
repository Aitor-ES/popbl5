<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- Start: Home  -->
<section id="home">
  <div class="container-fluid">
  
    <!-- Start: Carousel -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner">
      
        <!-- 1st carousel -->
        <div class="carousel-item active">
          <img src="${pageContext.request.contextPath}/static/img/home/first_slide.jpg" alt="<spring:message code="home.carousel.first.alt"/>">
          <div class="carousel-text container">
            <div class="carousel-caption text-left">
              <h1><span><spring:message code="home.carousel.first.label"/></span></h1>
              <p><span><spring:message code="home.carousel.first.text"/></span></p>
              <a class="button-style btn btn-lg btn-warning" href="${pageContext.request.contextPath}/register" role="button"><spring:message code="home.carousel.first.button"/></a>
            </div>
          </div>
        </div>
        
        <!-- 2nd carousel -->
        <div class="carousel-item">
          <img src="${pageContext.request.contextPath}/static/img/home/second_slide.jpg" alt="<spring:message code="home.carousel.second.alt"/>">
          <div class="carousel-text container">
            <div class="carousel-caption">
              <h1><span><spring:message code="home.carousel.second.label"/></span></h1>
              <p><span><spring:message code="home.carousel.second.text"/></span></p>
              <a class="button-style btn btn-lg btn-warning" href="#checkpoint1" role="button"><spring:message code="home.carousel.second.button"/></a>
            </div>
          </div>
        </div>
        
        <!-- 3rd carousel -->
        <div class="carousel-item">
          <img src="${pageContext.request.contextPath}/static/img/home/third_slide.jpg" alt="<spring:message code="home.carousel.third.alt"/>">
          <div class="carousel-text container">
            <div class="carousel-caption text-right">
              <h1><span><spring:message code="home.carousel.third.label"/></span></h1>
              <p><span><spring:message code="home.carousel.third.text"/></span></p>
              <a class="button-style btn btn-lg btn-warning" href="#checkpoint2" role="button"><spring:message code="home.carousel.third.button"/></a>
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
    <div id="checkpoint1" class="features container">
      <div class="row text-center">
      
        <!-- 1st feature -->
        <div class="col-lg-3 px-4">
          <img class="rounded-circle mb-3" src="${pageContext.request.contextPath}/static/img/home/f1.jpg" alt="<spring:message code="home.features.first.alt"/>" width="140" height="140">
          <h2><spring:message code="home.features.first.label"/></h2>
          <p><spring:message code="home.features.first.text"/></p>
        </div>
        
        <!-- 2nd feature -->
        <div class="col-lg-3 px-4">
          <img class="rounded-circle mb-3" src="${pageContext.request.contextPath}/static/img/home/f2.jpg" alt="<spring:message code="home.features.second.alt"/>" width="140" height="140">
          <h2><spring:message code="home.features.second.label"/></h2>
          <p><spring:message code="home.features.second.text"/></p>
        </div>
        
        <!-- 3rd feature -->
        <div class="col-lg-3 px-4">
          <img class="rounded-circle mb-3" src="${pageContext.request.contextPath}/static/img/home/f3.jpg" alt="<spring:message code="home.features.third.alt"/>" width="140" height="140">
          <h2><spring:message code="home.features.third.label"/></h2>
          <p><spring:message code="home.features.third.text"/></p>
        </div>
        
        <!-- 4th feature -->
        <div class="col-lg-3 px-4">
          <img class="rounded-circle mb-3" src="${pageContext.request.contextPath}/static/img/home/f4.jpg" alt="<spring:message code="home.features.fourth.alt"/>" width="140" height="140">
          <h2><spring:message code="home.features.fourth.label"/></h2>
          <p><spring:message code="home.features.fourth.text"/></p>
        </div>
      </div>
    </div> 
    <!-- End: Features -->
    
    <!-- Start: News -->
    <div id="checkpoint2" class="container news">
      <hr class="news-divider">
    
      <!-- 1st new -->
      <div class="row news">
        <div class="col-md-7">
          <h2 class="news-heading"><spring:message code="home.news.first.heading"/> <span class="text-muted"><spring:message code="home.news.first.title"/></span></h2>
          <p class="subtitle text-justify"><spring:message code="home.news.first.text"/></p>
        </div>
        <div class="col-md-5">
          <img class="news-image img-fluid mx-auto" src="${pageContext.request.contextPath}/static/img/home/n1.jpg" data-src="holder.js/500x500/auto" alt="<spring:message code="home.news.first.alt"/>">
        </div>
      </div>
  
      <hr class="news-divider">
    
      <!-- 2nd new -->
      <div class="row news">
        <div class="col-md-7 order-md-2">
          <h2 class="news-heading"><spring:message code="home.news.second.heading"/> <span class="text-muted"><spring:message code="home.news.second.title"/></span></h2>
          <p class="subtitles text-justify"><spring:message code="home.news.second.text"/></p>
        </div>
        <div class="col-md-5 order-md-1">
          <img class="news-image img-fluid mx-auto" src="${pageContext.request.contextPath}/static/img/home/n2.jpg" data-src="holder.js/500x500/auto" alt="<spring:message code="home.news.second.alt"/>">
        </div>
      </div>
    
      <hr class="news-divider">
      <!-- 3rd new -->
      <div class="row news">
        <div class="col-md-7">
          <h2 class="news-heading"><spring:message code="home.news.third.heading"/> <span class="text-muted"><spring:message code="home.news.third.title"/></span></h2>
          <p class="subtitle text-justify"><spring:message code="home.news.third.text"/></p>
        </div>
        <div class="col-md-5">
          <img class="news-image img-fluid mx-auto" src="${pageContext.request.contextPath}/static/img/home/n3.jpg" data-src="holder.js/500x500/auto" alt="<spring:message code="home.news.third.alt"/>">
        </div>
      </div>
    
      <hr class="news-divider">
    </div> 
    <!-- End: News -->
    
    <!-- Start: Jumbotron -->
    <div class="jumbotron p-5 p-md-5 m-md-5 text-center">
      <h1 class="display-4"><spring:message code="home.contact.label"/></h1>
      <p class="subtitle"><spring:message code="home.contact.text"/></p>
      <hr class="my-4">
      <p><spring:message code="home.contact.info"/></p>
      <a class="button-style btn btn-lg btn-warning mt-3" data-toggle="modal" data-target="#contactUsModal" role="button"><spring:message code="home.contact.button"/></a>
    </div>
    <!-- End: Jumbotron -->
    
    <!-- Start: Modal -->
    <div class="modal fade" id="contactUsModal" tabindex="-1" role="dialog" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
        
          <!-- Header -->
          <div class="modal-header">
            <h5 class="modal-title"><spring:message code="home.contact.label"/></h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          
          <!-- Body -->
          <div class="modal-body">
            <form name="homeForm" action="${pageContext.request.contextPath}/home/form" method='POST'>
              
              <div class="col-auto">
              
                <!-- Username -->
                <div class="input-group">
                  <div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-user"></i></span></div>
                  <input type="text" class="form-control" name='username' placeholder="<spring:message code="home.contact.modal.username"/>" required>
                </div>
                
                <!-- Subject -->
                <div class="input-group mt-3">
                  <div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-align-justify"></i></span></div>
                  <input type="text" class="form-control" name='subject' placeholder="<spring:message code="home.contact.modal.subject"/>" required>
                </div>
                
                <!-- Message -->
                <div class="input-group mt-3">
                  <div class="input-group-prepend"><span class="input-group-text"><i class="fas fa-pen"></i></span></div>
                  <textarea class="form-control" name='message' rows="6" placeholder="<spring:message code="home.contact.modal.message"/>" required></textarea>
                </div>
              </div>
              
              <!-- Progress bar -->
              <div class="progress m-3 mb-0" id="myProgressBar" style="display: none">
                <div class="progress-bar progress-bar-striped progress-bar-animated" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%"></div>
              </div>
              
              <!-- Footer -->
              <div class="modal-footer mt-3">
                <button class="button-style btn btn-lg btn-warning mt-3" data-dismiss="modal"><i class="fas fa-times-circle"></i> <spring:message code="action.cancel"/></button>
                <button class="button-style btn btn-lg btn-warning mt-3" type="submit" name="submit" onclick="homeProgress()"><i class="fas fa-paper-plane"></i> <spring:message code="action.send"/></button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
    <!-- End: Modal -->
  
    <!-- Start: Top button -->
    <button class="button-style btn btn-lg btn-warning" onclick="topFunction()" id="topButton"><spring:message code="action.top"/></button>
    <!-- End: Top button -->
  
  </div>
</section>
<!-- End: Home -->