<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"> -->
<html>
<head>



<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<link href="assets/css/custom.css" rel="stylesheet" />
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />

<link rel="stylesheet" href="assets/datepicker/datepicker.css">
<!-- <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.min.css" /> -->
<!-- <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker3.min.css" /> -->


<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript"
	src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script type="text/javascript">

$(document).ready( function () {
	loadChart('20160101','20160131');
	});
	
  	 function loadChart(start='20170101', end='20170115'){
  		
	 google.charts.load('current', {'packages':['corechart']});
	 google.charts.setOnLoadCallback(drawChartRest);
	 function drawChartRest() {
	     var jsonData = $.ajax({
	         url: 'http://localhost:8080/api/measures/get?dateFrom='+start+'&dateTo='+end,
	         dataType: "json",
	         async: false
	         }).responseText;
	         
	     var data = new google.visualization.arrayToDataTable(jsonData);
	
	     var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
	     chart.draw(data, {width: 600, height: 400});
	   }
  }
</script>

<title>PlantsGuard - Wykresy pomiarów</title>
</head>
<body>
	<div id="wrapper">
	
		<!--  NAV TOP  -->
		<div class="navbar navbar-inverse navbar-fixed-top">
			<div class="adjust-nav">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".sidebar-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#"> <img
						src="/assets/img/logo.png" />
					</a>
				</div>
				<span class="logout-spn"> <a href="logout" style="color: #fff;">Wyloguj</a>
				</span>
			</div>
		</div>
		<!-- /. NAV TOP  -->
		
		<!--  NAV SIDE  -->
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">
					<li><a href="/dashboard"><i class="fa fa-desktop "></i>Dashboard</a></li>
					<li class="active-link"><a href="/charts"><i class="fa fa-table "></i>Wykres pomiarów</a></li>
					<li><a href="/devices"><i class="fa fa-edit "></i>Urządzenia</a></li>
			</div>
		</nav>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h2>Wykres pomiarów</h2>

						<b style="text-align: right; padding: 15px;">Data od <input
							id="date_from" type="text"></b><b
							style="text-align: center; padding: 15px;">Data do <input
							id="date_to" type="text"></b> <b
							style="text-align: center; padding: 15px;">Rodzaj wykresu </b>
<select id="chart_type">
<option value="linechart">Wykres liniowy</option>
<option value="barchart">Wykres słupkowy</option>
</select>

						<div id="chart_div" style="width: 600; height: 400"></div>

					</div>
				</div>
				<!-- /. ROW  -->
				<hr />
				<!-- /. ROW  -->
			</div>
			<!-- /. PAGE INNER  -->
		</div>
		<!-- /. PAGE WRAPPER  -->
	</div>
	<div class="footer">
		<div class="row">
			<div class="col-lg-12">
				&copy; 2014 yourdomain.com | Design by: <a
					href="http://binarytheme.com" style="color: #fff;" target="_blank">www.binarytheme.com</a>
			</div>
		</div>
	</div>


	<!-- /. WRAPPER  -->
	<!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
	<!-- JQUERY SCRIPTS -->
	<script src="assets/js/jquery-1.10.2.js" type="text/javascript"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="assets/js/custom.js" type="text/javascript"></script>

	<script type="text/javascript" src="assets/datepicker/datepicker.js"></script>
	<script>
  	const pickerFrom = datepicker('#date_from');
    const pickerTo = datepicker('#date_to');
  </script>

</body>
</html>
