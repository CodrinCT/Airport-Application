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
  		<div class="pull-left">
  			<a href="/logout" class="btn btn-primary">Logout</a>
  			<th></th>
  			<th>
  			<a href="/flightslist" class = "btn btn-primary">Back to Flight List</a>
            </th>
  		</div>
  		<div class="clearfix"></div>
  	</div>

        <table class="table table-striped">
            <tr>
                <th>Flight id</th>
                <th>Class</th>
                <th>Number Of Sits</th>
                <th>Available Sits</th>
            </tr>
                <tr>
                      <td><c:out value="${info.id}"/></td>
                      <td><c:out value="${info.planeClass}"/></td>
                      <td><c:out value="${info.nrOfSits}"/></td>
                      <td><c:out value="${info.availableSits}"/></td>
                      <td>
                </tr>
    </table>
  </body>
</html>