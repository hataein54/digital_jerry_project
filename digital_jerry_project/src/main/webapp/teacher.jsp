<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<title>DAZERO'S GOLF</title>
<meta charset="utf-8">

<link rel="stylesheet" type="text/css" href="./golf.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

<style>
body {
	background-color: rgb(146, 164, 223);
	font-family: 'SBAggroB';
}

@font-face {
	font-family: 'SBAggroB';
	src:
		url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2108@1.1/SBAggroB.woff')
		format('woff');
	font-weight: normal;
	font-style: normal;
}

#title:hover {
	transition: 0.2s;
	transform: scale(1.2);
}
</style>
</head>

<body>
	<div id="wrap" class="container w-75 h-100">

		<!-- 헤더 -->
		<header
			class="d-flex justify-content-center w-100 h-100 logo text-center mt-4"
			id="title">

			<!-- 로고영역 -->
			<h1 class="home-tag fw-bold text-center my-3">
				<a class="text-decoration-none link-light"
					onclick="href = 'index.html'">골프 연습장 <i
					class="fa-solid fa-golf-ball-tee"></i></a>
			</h1>
		</header>

		<!-- 중간메뉴 -->
		<nav
			class="menu d-flex align-items-center mt-3 p-3 bg-dark opacity-75">
			<ul class="nav nav-fill w-100 d-flex">
				<li class="nav-item" id="title"><a href="teacher_view.doGolf"
					class="menu-font fs-5 text-light fw-bold text-decoration-none">강사
						조회 <i class="fa-solid fa-magnifying-glass"></i>
				</a></li>
				<li class="nav-item" id="title"><a href="insert_view.doGolf"
					class="menu-font fs-5 text-light fw-bold text-decoration-none">수강
						신청 <i class="fa-regular fa-square-check"></i>
				</a></li>
				<li class="nav-item" id="title"><a href="member_view.doGolf"
					class="menu-font fs-5 text-light fw-bold text-decoration-none">회원
						정보 조회 <i class="fa-solid fa-user"></i>
				</a></li>
				<li class="nav-item" id="title"><a href="result_view.doGolf"
					class="menu-font fs-5 text-light fw-bold text-decoration-none">강사
						매출 현황 <i class="fa-solid fa-arrow-trend-up"></i>
				</a></li>
			</ul>
		</nav>

		<div class="container">
			<p class="text-center fw-bold fs-3 my-5">
				강사 조회 <i class="fa-solid fa-magnifying-glass"></i>
			</p>

			<div class="row">
				<c:forEach var="teacher" items="${teacherList}">
					<div class="col-3 card-box mx-0 mb-5">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title fw-bold text-center">${teacher.class_name}</h5>
								<img class="w-100 h-100" src="./img/${teacher.teacher_code}.jpg">

								<p class="mt-2 fw-bold text-center">${teacher.teacher_name}</p>

								<ul class="mt-2">
									<li class="card-text text-start">CODE :
										${teacher.teacher_code}</li>
									<li class="card-text text-start">PRICE :
										₩${teacher.class_price}</li>
									<li class="card-text text-start">REGIST DATE :
										${teacher.teacher_resist_date}</li>
								</ul>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>

		<!-- 푸터 -->
		<footer class="text-center">
			<div class="text-secondary bg-body-secondary opacity-75">
				<p class="d-inline-block fw-bold text-dark py-1 pt-4 fs-5 col-3">회사
					: ICT 컴퍼니</p>
				<p class="d-inline-block fw-bold text-dark py-1 pt-4 fs-5 col-3">대표
					: 윤다영 & 박현춘</p>
				<p class="d-inline-block fw-bold text-dark py-1 pt-4 fs-5 col-5">주소
					: 서울특별시 성동구 성수동</p>
			</div>
		</footer>

	</div>
</body>

</html>