<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- HTML code -->
<!DOCTYPE html>
<html>
  <head>
    <!-- Required meta tags -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    
    <!-- Remove NetBeans bug -->
    <link rel="shortcut icon" href="#"/>
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
      integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" 
      crossorigin="anonymous"/>
    
    <!-- jQuery JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"
      integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
      crossorigin="anonymous"></script>
    
    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" 
      integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" 
      crossorigin="anonymous"></script>
    
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" 
      integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" 
      crossorigin="anonymous"></script>
      
    <!-- D3 JS -->
    <script src="https://d3js.org/d3.v4.min.js"></script>
      
    
    <!-- Icon library -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" 
      integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" 
      crossorigin="anonymous"/>
    
    <!-- Custom css -->
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/default.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/deck_list.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/deck_form.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/deck_data.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/card_data.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/menu.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/home.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/login.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/register.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/forgot.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/profile.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/decks.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/duels.css"/>"/>
    
    <!-- Custom js -->
    <script src="<c:url value='/static/js/default.js'/>"></script>
    <script src="<c:url value='/static/js/message.js'/>"></script>
    <script src="<c:url value='/static/js/deck_form.js'/>"></script>
    <script src="<c:url value='/static/js/radar_chart.js'/>"></script>

    <!-- Title -->
    <title><tiles:getAsString name="title"/> - <spring:message code="header.appName"/></title> 
  </head>
  <body>
    <!-- Current application context -->
    <script>
    	var MAIN_CONTEXT = '${pageContext.request.contextPath}';
    </script>
    
    <!-- Tiles templates -->
    <tiles:insertAttribute name="header"/>
    <c:if test="${not empty sessionScope.user}">
      <tiles:insertAttribute name="menu"/>
    </c:if>
    <tiles:insertAttribute name="message"/>
    <tiles:insertAttribute name="main"/>
    <tiles:insertAttribute name="footer"/>
  </body>
</html>