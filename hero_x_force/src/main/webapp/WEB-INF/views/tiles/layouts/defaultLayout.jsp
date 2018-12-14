<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html lang="en-US">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:getAsString name="title" /> - Hero X-Force</title>
    <!--link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/-->
  </head>
  <body>
    <div class="flex-container">
      <tiles:insertAttribute name="header" />
      <tiles:insertAttribute name="menu" />
      <article class="article">
        <tiles:insertAttribute name="body" />
      </article>
      <tiles:insertAttribute name="footer" />
    </div>
  </body>
</html>