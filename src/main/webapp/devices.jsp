<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- <html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"> -->
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>PlantsGuard - Urządzenia</title>
<!-- BOOTSTRAP STYLES-->
<link href="/assets/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="/assets/css/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="/assets/css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
	
<script type="text/javascript">
function goToSettings(dev_id) {
	window.location='/device/'+dev_id;
}
</script>
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
					<li><a href="/charts"><i class="fa fa-table "></i>Wykres pomiarów</a></li>
					<li class="active-link"><a href="/devices"><i class="fa fa-edit "></i>Urządzenia</a></li>
			</div>
		</nav>
		<!-- /. NAV SIDE  -->
		
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h2>Urządzenia</h2>
							<center>
								<table id="device_table">
									<tr>
										<td>ID</td>
										<td>Numer</td>
										<td>Nazwa</td>
										<td>Ostatni odczyt</td>
										<td>Ostateni podlewanie</td>
										<td>Poziom baterii</td>
									</tr>									
									<c:forEach items="${devices}"
										var="device" varStatus="status">
										<tr>
											<td id="dev_id_${status.index }">${device.deviceId}</td>
											<td id="dev_number_${status.index }">${device.deviceNumber}</td>
											<td id="dev_name">${device.deviceName}</td>
											<td>${device.lastMeasure}</td>
											<td>${device.lastIrrigate}</td>
											<td>${device.lastBatteryLevel}</td>
											<td><input type="button" onclick="goToSettings(document.getElementById('dev_id_${status.index}').textContent)">Edytuj</button></td>
										</tr>
									</c:forEach>
								</table>
							</center>
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
	<script src="/assets/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="/assets/js/bootstrap.min.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="/assets/js/custom.js"></script>


</body>
</html>
