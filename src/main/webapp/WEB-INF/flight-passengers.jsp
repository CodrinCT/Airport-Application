<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Flights List</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
          crossorigin="anonymous">
  </head>

  <body>
  	<div class="page-header">
  	       <th>
  	  		<a href="/logout" class="btn btn-primary">Logout</a>
  	  		<a href="/flightslist" class="btn btn-primary">Back to Flight List</a>
  	  		</th>
  		<div class="pull-left">
  		  	  	<div>Welcome ${logged_user}</div>
  		</div>
  		<div class="clearfix"></div>
  	</div>
        <table class="table table-striped">
            <tr>
                <th>Passenger Id</th>
                <th>Ticket Id</th>
                <th>Passenger Name</th>
                <th>Passenger Flight Id</th>
                <th>Actions</th>
            </tr>
            <c:forEach items="${passenger}" var="passenger">
                <tr>
                    <td><c:out value="${passenger.passengerId}"/></td>
                    <td><c:out value="${passenger.ticketId}"/></td>
                    <td><c:out value="${passenger.passengerName}"/></td>
                    <td><c:out value="${passenger.passengerFlightId}"/></td>
                    <td><a href="/cancel/${passenger.ticketId}" class="btn btn-info">Cancel</a></td>
                </tr>
                <tr>

                </tr>
            </c:forEach>
    </table>
  </body>
</html>