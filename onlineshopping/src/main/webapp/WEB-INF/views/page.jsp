<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Online Shopping - ${title} </title>
	<script>
		window.menu = '${title}';
	</script>
    <!-- Bootstrap Core CSS -->
	<link href="${css}/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
	<link href="${css}/myapp.css" rel="stylesheet">

  </head>

  <body>
	<div class="wrapper">
	    <!-- Navigation -->
	    <%@include file="./shared/navbar.jsp" %>
	
	    <!-- Page Content -->
	    <div class="content">
		    <!-- Load only when user clicks home -->
		    <c:if test="${userClicksHome == true }">
		    	<%@include file="home.jsp" %>
		    </c:if>
		    
		    <!-- Load only when user clicks about -->
		    <c:if test="${userClicksAbout == true }">
		    	<%@include file="about.jsp" %>
		    </c:if>
		    
		    <!-- Load only when user clicks contact -->
		    <c:if test="${userClicksContact == true }">
		    	<%@include file="contact.jsp" %>
		    </c:if>
		    
		    <!-- Load only when user clicks all products -->
		    <c:if test="${userClicksAllProducts == true or userClicksCategoryProducts == true }">
		    	<%@include file="listProducts.jsp" %>
		    </c:if>

	    </div>
	    <!-- Footer -->
	    <%@include file="./shared/footer.jsp" %>
	
	    <!-- jQuery -->
		<script src="${js}/jquery.min.js"></script>
	    <!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.bundle.min.js"></script>
		
		 <!-- Self coded JavaScript -->
		<script src="${js}/myapp.js"></script>
	</div>
  </body>

</html>
