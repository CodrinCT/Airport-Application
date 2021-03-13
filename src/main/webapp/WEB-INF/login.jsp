<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Login</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous">
</head>
<body>

	<div class="container">
		<form class="form-horizontal" role="form" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="user">User:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="user" name="user" value="">
				</div>
				<label class="control-label col-sm-2" for="password">Password:</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="password" name="password" value="">
				</div>
			</div>
			
			<c:if test="${not empty error}">
				<div class="alert alert-danger">Error: ${error}</div>
			</c:if>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button class="btn btn-primary">Login</button> 
				</div>

			</div>
			<div class="col-sm-offset-2 col-sm-10">
                    <a href="<c:url value="/registration"/> " class="btn btn-info">Sign Up</a>
            </div>
		</form>
	</div>

	<div id = "hi">
	<p style = color:red , margin to left = 100px>hello</p>
	</div>

</body>
</html>
