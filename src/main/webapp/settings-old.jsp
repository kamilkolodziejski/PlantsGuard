
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"/>
<html xmlns:c="http://java.sun.com/jsp/jstl/core">
<%@page import="pl.put.poznan.plantsguard.model.Configuration"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" xmlns:c="http://java.sun.com/jsp/jstl/core">
<title>Settings</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
function deleteNumber(btn) {
	var row = btn.parentNode.parentNode;
	var phone=row.firstChild;
	var name=phone.getAttribute('name');
	document.write(name);
	phone.value="";
	phone.name="";
	phone.outerHTML = "";
	delete phone;
	row.outerHTML = "";
	delete row;
	var nodes = document.getElementById("phonesTable").getChildNodes;
	var i=0;
	for(node in nodes) {
		node.firstChild.name='authorizedNumbers['+i+']';
	}
}

function addNumber(number) {
	var table = document.getElementById('phonesTable');
    var rowCount = table.getElementsByTagName("tr").length;
    var row = table.insertRow();
    var cell1 = row.insertCell(0);
    cell1.innerHTML = '<input type="text" name="authorizedNumbers['+rowCount+']" value="'+number+'"/>';
    var cell2 = row.insertCell(1);
	cell2.innerHTML = '<input type="button" onclick="deleteNumber(this)" value="Usun"/>';
}
</script>

</head>
<body>
	<form method="post" action="/settings" modelAttribute="configuration">
		<center>
			<h1>Witaj ${user.username }</h1></br></br></br>
			<h2>Ustawienia</h2></br></br>
			Interwal pomiarow</br>
			<input type="text" name="measureInterval" value="${configuration.measureInterval }"/> </br></br>
			Interwal sprawdzania rozkazow</br>
			<input type="text" name="ordersInterval" value="${configuration.ordersInterval }"/> </br></br>
			
			<table id="phonesTable">
			<c:forEach items="${configuration.authorizedNumbers}" var="phone" varStatus="status">
				<tr>
					<td><input type="text" name="authorizedNumbers[${status.index }]" value="${phone }"/></td>
					<td><input type="button" onclick='deleteNumber(this)' value="Usun"/></td>
				</tr>
			</c:forEach>
			</table>
			--------------------------------------------------------</br>
			<td><input type="text" id="input_phone" value="Dodaj numer"/></td>
			<td><input type="button" id="input_btn" onclick="addNumber(document.getElementById('input_phone').value)" value="Dodaj"/></td>
			</br>
			</br>
			<input type="submit" name="submit" value="Zapisz" />
			<input type="button" name="cancel" onClick="window.location='/settings'" value="Zapisz" /> 
			</br>
			</br>
			<label style="color: green">${msg}</label>
			<label style="color: red">${error}</label>
			</br>
		</center>
	</form>
</body>
</html>