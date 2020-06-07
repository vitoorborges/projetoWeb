<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="style.css">

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


<style>
body {
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

.hero-image {
	background-image:
		url("https://www.esporteinterativo.com.br/__export/1582836634857/sites/esporteinterativo/img/2020/02/27/taxa_brasileirao.jpg_786143474.jpg");
	background-color: #cccccc;
	height: 965px;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	position: relative;
}

.hero-text {
	text-align: justify;
	position: absolute;
	top: 50%;
	left: 20%;
	transform: translate(-50%, -50%);
	color: black;
}

body, h1,h2,h3,h4,h5,h6 {font-family: "Montserrat", sans-serif}
.w3-row-padding img {margin-bottom: 12px}

.w3-sidebar {width: 120px;background: #222;}

#main {margin-left: 120px}

@media only screen and (max-width: 600px) {#main {margin-left: 0}}

</style>
<title>Insert title here</title>
</head>
<body class=hero-image>
	
	
<nav class="w3-sidebar w3-bar-block w3-small w3-hide-small w3-center w3-black">
	</br>
    <i  class="fa fa-home w3-xxlarge"></i>
    <p>HOME</p>
  <a href="login.jsp" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
    <i class="fa fa-user w3-xxlarge"></i>
    <p>LOGIN</p>
  </a>
  <a href="#photos" class="w3-bar-item w3-button w3-padding-large w3-hover-black">
    <i class="fa fa-futbol-o w3-xxlarge"></i>
    <p>JOGOS</p>
  </a>
</nav>



<div class=hero-text>
		<h1 class="w3-xxxlarge"><b>APOSTAS.NET</b></h1>
    <h6>Bem-vindos ao <span class="w3-tag">Mundo das apostas</span></h6>
</div>

<c:if test="${result == 'true' }">
		<script type="text/javascript">
			alert("${mensagem}");
		</script>
</c:if>


</body>
</html>