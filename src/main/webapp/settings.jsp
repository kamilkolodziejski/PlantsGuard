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
<title>PlantsGuard - Ustawienia</title>
<!-- BOOTSTRAP STYLES-->
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="assets/css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />

<script type="text/javascript">
function deleteNumber(btn) {
	if(document.getElementById("phonesTable").getElementsByTagName("tr").length<=1) return;
	var row_id=btn.substring(4);
	var table = document.getElementById("phonesTable").deleteRow(row_id);
	var nodes = table.getChildNodes;
	var i=0;
	for(node in nodes) {
		node.firstChild.name='xxxauthorizedNumbers['+i+']';
	}
}

function addNumber(number) {
	var table = document.getElementById('phonesTable');
    var rowCount = table.getElementsByTagName("tr").length;
    var row = table.insertRow();
    row.id="row_"+rowCount
    var cell1 = row.insertCell(0);
    cell1.innerHTML = '<input type="text" name="authorizedNumbers['+rowCount+']" value="'+number+'"/>';
    var cell2 = row.insertCell(1);
	cell2.innerHTML = '<input type="button" id="btn_'+rowCount+'" onclick="deleteNumber(this.id)" value="Usun"/>';
	document.getElementById('input_phone').value='Dodaj numer';
}
</script>
</head>
<body>


	<div id="wrapper">
		<div class="navbar navbar-inverse navbar-fixed-top">
			<div class="adjust-nav">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".sidebar-collapse">
						<span class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#"> <img
						src="assets/img/logo.png" />
					</a>
				</div>
				<span class="logout-spn"> <a href="logout" style="color: #fff;">Wyloguj</a>
				</span>
			</div>
		</div>
		<!-- /. NAV TOP  -->
		<nav class="navbar-default navbar-side" role="navigation">
			<div class="sidebar-collapse">
				<ul class="nav" id="main-menu">
					<li><a href="dashboard"><i class="fa fa-desktop "></i>Dashboard</a></li>
					<li><a href="charts"><i class="fa fa-table "></i>Wykres	pomiarów</a></li>
					<li class="active-link"><a href="settings"><i class="fa fa-edit "></i>Ustawienia</a></li>
			</div>
		</nav>
		<!-- /. NAV SIDE  -->
		<div id="page-wrapper">
			<div id="page-inner">
				<div class="row">
					<div class="col-md-12">
						<h2>Ustawienia</h2>
						<form method="post" action="/settings"
							modelAttribute="configuration">
							<center>
								<div> Interwal pomiarow</br> <input type="text" name="measureInterval" pattern="[0-9]{1-5}"
									value="${configuration.measureInterval }" /> </div>
									
								<div> Interwal sprawdzania rozkazow</br> <input type="text" pattern="[0-9]{1-5}"
									name="ordersInterval" value="${configuration.ordersInterval }" />
								</div>
								<div></br></br>
								<table id="phonesTable">
									<c:forEach items="${configuration.authorizedNumbers}"
										var="phone" varStatus="status">
										<tr id="row_${status.index }">
											<td><input type="text" pattern="[0-9]{11}"
												name="authorizedNumbers[${status.index }]" value="${phone }" /></td>
											<td><input type="button" id="btn_${status.index }" onclick='deleteNumber(this.id)'
												value="Usun" /></td>
										</tr>
									</c:forEach>
								</table>
								--------------------------------------------------------</br>
								<div>
								<td><input type="text" id="input_phone" value="Dodaj numer" /></td>
								<td><input type="button" id="input_btn"	onclick="addNumber(document.getElementById('input_phone').value)"
										   value="Dodaj" /></td> </br> </br> 
								<input type="submit" name="submit" value="Zapisz" /> 
								<input type="button" name="cancel" onClick="window.location='/settings'" value="Anuluj" /> </br> </br> 
								<label style="color: green">${msg}</label> <label style="color: red">${error}</label>
								</div></div>
							</center>
						</form>
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
	<script src="assets/js/jquery-1.10.2.js"></script>
	<!-- BOOTSTRAP SCRIPTS -->
	<script src="assets/js/bootstrap.min.js"></script>
	<!-- CUSTOM SCRIPTS -->
	<script src="assets/js/custom.js"></script>


</body>
</html>
