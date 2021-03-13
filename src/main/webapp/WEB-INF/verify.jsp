<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Verification</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous">
</head>
<body>

	<div class="container">
	    <c:if test="${not empty error}">
      	    <div class="alert alert-danger">Error: ${failure}</div>
        </c:if>
        <c:if test="${not empty success}">
        	<div class="alert alert-success">Success: ${success}</div>
        </c:if>
	</div>
	<div class="col-sm-offset-2 col-sm-10">
         <a href="<c:url value="/home.html"/> " class="btn btn-info">To home page</a>
    </div>
</body>
</html>
