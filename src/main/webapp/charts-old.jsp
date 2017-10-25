<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<title>Dashboard</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">


  // Load the Visualization API and the piechart package.
  
  google.charts.load('current', {'packages':['corechart']});

  google.charts.setOnLoadCallback(drawChartRest);

  function drawChartRest() {
      var jsonData = $.ajax({
          url: "http://localhost:8080/api/measures/get?dateFrom=20170101&dateTo=20170201",
          dataType: "json",
          async: false
          }).responseText;
          
      // Create our data table out of JSON data loaded from server.
      var data = new google.visualization.DataTable(jsonData);

      // Instantiate and draw our chart, passing in some options.
      var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
      chart.draw(data, {width: 800, height: 600});
    }

  
</script>

</head>
<body>

<center>
    <div id="chart_div" style="width:800; height:600"></div>
</center>

	
	

</body>
</html>