<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Buy Ticket</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
          <link rel="stylesheet" type="text/css" href="css/jquery.autocomplete.css" />
          	<script type="text/javascript"
          			src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
          	<script src="js/jquery.autocomplete.js"></script>
  </head>

  <body>
  	<div class="page-header">
  		<div class="pull-left">
  			<a href="/logout" class="btn btn-primary">Logout</a>
  			<th></th>
  			<th>
  			<a href="/flightslist" class = "btn btn-primary">Back to Flight List</a>
            </th>
  		</div>
  		<div>Welcome ${logged_user}</div>
  		<div class="clearfix"></div>
  	</div>

        <table class="table table-striped">
            <tr>
                <th>Class Name</th>
                <th>Ticket Base Price</th>
                <th>Total Price</th>
            </tr>
            <tr id="productAddFormRow">
             <c:forEach items="${planeClass}" var="planeClass">
             <tr>
                    <td><c:out value="${planeClass.className}"/></td>
                    <td><c:out value="${planeClass.classTicketPrice}"/>$</td>
                  </td>
             </tr>
             </c:forEach>


             <tr>
             <form class="form-horizontal" role="form" method="post">
             <td><input type="text" id="className" class="form-control" name="className" value="" placeholder="Class Name"></td>
             <td> <button class="btn btn-primary">Buy</button>
             </form>
             </tr>
            </tr>
    </table>

  </body>
</html>