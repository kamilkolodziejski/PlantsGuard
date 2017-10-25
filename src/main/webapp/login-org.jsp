<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login page</title>
</head>
<body>
	<form method="post" action="processLogin" modelAttribute="user">
		<center>
			Login</br>
			<input type="text" name="username" /> </br></br>
			Password</br>
			<input type="password" name="password"/> </br></br>
			<input type="submit" name="submit"/> 
			</br></br>
			<label style="color:red">${error}</label>
			<label>${message}</label>
			</br></br>
			
		</center>
	</form>
</body>
</html>