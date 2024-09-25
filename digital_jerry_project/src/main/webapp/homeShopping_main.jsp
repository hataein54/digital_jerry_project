<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="homeshopping.css">
<link rel="stylesheet"
   href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" />
<title>Document</title>

<style>
@font-face {
    font-family: 'YoonChildfundkoreaManSeh';
    src: url('https://fastly.jsdelivr.net/gh/projectnoonnu/2408@1.0/YoonChildfundkoreaManSeh.woff2') format('woff2');
    font-weight: normal;
    font-style: normal;
}

body{
    font-family: 'YoonChildfundkoreaManSeh';
    font-weight: bold;
}

.menu-text{
	font-weight: bold;
	color: black;
}
</style>
</head>
<body>
	<div>
		<a href="jerryMain.html" class="menu-text">
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house" viewBox="0 0 16 16">
  				<path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L2 8.207V13.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V8.207l.646.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293zM13 7.207V13.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V7.207l5-5z"/>
			</svg>
			돌아가기
		</a>
	</div>
	<div id="wrap">
		<header id="title" class="display-5 pb-4">
			<h1>
				<a href="homeShopping_main.jsp" class="menu-text">Home Shopping <i class="fa-solid fa-cart-shopping"></i></a>
			</h1>
		</header>

		<nav>
			<ul id="navUl" class="nav d-flex justify-content-around py-3">
				<li><a href="signUp_view.doHomeShopping" class="menu-text">회원가입 <i class="fa-solid fa-pen"></i></a></li>
				<li><a href="memberList_view.doHomeShopping" class="menu-text">회원목록 <i class="fa-solid fa-users"></i></a></li>
				<li><a href="sales_view.doHomeShopping" class="menu-text">매출확인 <i class="fa-solid fa-sack-dollar"></i></a></li>
			</ul>
		</nav>

		<main class="container">
			<div id="demo" class="carousel slide" data-bs-ride="carousel">
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="img/hs1.png" alt="Los Angeles" class="d-block"
							style="width: 100%; height: 100%">
					</div>
					<div class="carousel-item">
						<img src="img/hs2.png" alt="Chicago" class="d-block"
							style="width: 100%; height: 100%;">
					</div>
					<div class="carousel-item">
						<img src="img/hs3.png" alt="New York" class="d-block"
							style="width: 100%; height: 100%;">
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#demo" data-bs-slide="prev">
					<span class="carousel-control-prev-icon"></span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#demo" data-bs-slide="next">
					<span class="carousel-control-next-icon"></span>
				</button>
			</div>
		</main>

		<footer>
			<div id="footerDiv" class="py-3">copyright : Kim seon-woo</div>
		</footer>
	</div>
</body>
</html>