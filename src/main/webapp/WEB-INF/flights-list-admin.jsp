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
  <body style="background-color: #202020">
  	<div class="page-header">
  	       <th>
  	  		<a href="/logout" class="btn btn-primary" style="color: darkred; font-size: large; font-weight:bold">Logout</a>
  	  		</th>
  		<div class="pull-left">
  		  	  	<div style="color: white; font-size: large">Welcome ${logged_user}</div>
  		</div>
  		<div class="clearfix"></div>
  	</div>
        <table class="table table-striped">

         <ul>
            <form action="/flightslist" method="POST">
               <p style="font-size:35px; font-weight:bold; color:white">Search Flight</p>
               <th><input type="text" class="form-control" id="origin" name="origin" value="" placeholder="origin"></th>
               <th><input type="text" class="form-control" id="destination" name="destination" value="" placeholder="destination"></th>
               <th><button type="submit" style="margin-left:10px; background-color:blue; width: 80px; height: 35px; align-self: center; color: #d3be6c">Search</button></th>
            </form>
         </ul>
            <tr>
                <th style="color:white; font-size:20px">Flight Id</th>
                <th style="color:white; font-size:20px">Origin</th>
                <th style="color:white; font-size:20px">Destination</th>
                <th style="color:white; font-size:20px">Time of Departure</th>
                <th style="color:white; font-size:20px">Time of Arrival</th>
                <th style="color:white; font-size:20px">Time Until Arrival</th>
                <th style="color:white; font-size:20px">Actions</th>
            </tr>
            <c:forEach items="${flights}" var="flights">
                <tr>
                    <td style="color:white; font-size:15px"><c:out value="${flights.id}"/></td>
                    <td style="color:white; font-size:15px"><c:out value="${flights.origin}"/></td>
                    <td style="color:white; font-size:15px"><c:out value="${flights.destination}"/></td>
                    <td style="color:white; font-size:15px"><c:out value="${flights.timeOfDeparture}"/></td>
                    <td style="color:white; font-size:15px"><c:out value="${flights.timeOfArrival}"/></td>
                    <td style="color:white; font-size:15px"><c:out value="${flights.timeUntilArrival}"/></td>

                    <td>
                        <a href="<c:url value="/flightslist/${flights.id}/information"/> " class="btn btn-info" style="color: orange; margin-bottom: 5px">View Flight Information</a>
                        <a href="<c:url value="/flightslist/${flights.id}/tickets"/>" class="btn btn-info" style="color: orange; margin-bottom: 5px">Buy Tickets!</a>
                        <a href="<c:url value="/${flights.id}/passengers"/>" class="btn btn-info" style="color: orange; margin-bottom: 5px">See Passengers</a>
                    </td>
                </tr>
            </c:forEach>
    </table>
  </body>
</html>
