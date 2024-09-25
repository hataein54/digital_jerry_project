<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<title>Hello, world!</title>
<style>
		@font-face {
			font-family: 'omyu_pretty';
			src:
				url('https://fastly.jsdelivr.net/gh/projectnoonnu/noonfonts_2304-01@1.0/omyu_pretty.woff2')
				format('woff2');
			font-weight: normal;
			font-style: normal;
			}

		body {
				font-family: 'omyu_pretty';
			}

		.bodyback, #header {
			background-color: rgb(255, 253, 219);
			}

		li, footer {
			background-color: rgb(193, 215, 190);
			}

		#title:hover {
			color: rgb(12, 101, 12);
			transition: 0.2s;
			transform: scale(1.2);
			}
	
		li :hover {
			color: white;
			}

		.menu-text {
			text-decoration: none;
			color: black;
			}

		html, body {
			height: 100%;
			margin: 0;
			padding: 0;
		}

		body {
			display: flex;
			flex-direction: column;
		}

		main {
			flex: 1;
		}

		footer {
			background-color: rgb(193, 215, 190);
			position: fixed;
			bottom: 0;
			width: 100%;
		}
				 table {
            border-collapse: collapse; /* 테두리를 합쳐서 깔끔하게 보이도록 설정 */
        }

        table, th, td {
            border: 1px solid black; /* 테두리 추가 */
              background-color: #f2f8eb;
        }

        th, td {
            padding: 8px; /* 셀 내부의 패딩 */
            text-align: center; /* 텍스트를 가운데 정렬 */
          
        }
	</style>
</head>

<body class="bodyback">

	<header id="header" class="d-flex justify-content-center text-dark ">
		<h1 id="title" class="fw-bold display-5 p-5  ">
			<a href="#" class="menu-text  "
				onclick="location.href='voteMain.html'">지역 구의원 투표 프로그램 ver 2024</a>
		</h1>
	</header>

	<nav class="top-menu d-flex align-items-start text-right ">
		<ul class="nav d-flex nav-fill w-100 h-50 fs-4">
			<li class="nav-item p-3"><a href="candidate_view.doVote"
				class="menu-text fw-bold"> 후보조회 <svg
						xmlns="http://www.w3.org/2000/svg" width="16" height="16"
						fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                        <path
							d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0" />
                    </svg>
			</a></li>
			<li class="nav-item p-3"><a href="vote_view.doVote"
				class="menu-text fw-bold"> 투표하기 <svg
						xmlns="http://www.w3.org/2000/svg" width="16" height="16"
						fill="currentColor" class="bi bi-envelope-paper"
						viewBox="0 0 16 16">
                        <path
							d="M4 0a2 2 0 0 0-2 2v1.133l-.941.502A2 2 0 0 0 0 5.4V14a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V5.4a2 2 0 0 0-1.059-1.765L14 3.133V2a2 2 0 0 0-2-2zm10 4.267.47.25A1 1 0 0 1 15 5.4v.817l-1 .6zm-1 3.15-3.75 2.25L8 8.917l-1.25.75L3 7.417V2a1 1 0 0 1 1-1h8a1 1 0 0 1 1 1zm-11-.6-1-.6V5.4a1 1 0 0 1 .53-.882L2 4.267zm13 .566v5.734l-4.778-2.867zm-.035 6.88A1 1 0 0 1 14 15H2a1 1 0 0 1-.965-.738L8 10.083zM1 13.116V7.383l4.778 2.867L1 13.117Z" />
                    </svg>
			</a></li>
			<li class="nav-item p-3"><a href="check_view.doVote"
				class="menu-text fw-bold"> 투표검수조회 <svg
						xmlns="http://www.w3.org/2000/svg" width="16" height="16"
						fill="currentColor" class="bi bi-check-circle" viewBox="0 0 16 16">
                        <path
							d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14m0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16" />
                        <path
							d="m10.97 4.97-.02.022-3.473 4.425-2.093-2.094a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-1.071-1.05" />
                    </svg>
			</a></li>
			<li class="nav-item p-3"><a href="rank_view.doVote"
				class="menu-text fw-bold"> 후보자등수 <svg
						xmlns="http://www.w3.org/2000/svg" width="16" height="16"
						fill="currentColor" class="bi bi-trophy" viewBox="0 0 16 16">
                        <path
							d="M2.5.5A.5.5 0 0 1 3 0h10a.5.5 0 0 1 .5.5q0 .807-.034 1.536a3 3 0 1 1-1.133 5.89c-.79 1.865-1.878 2.777-2.833 3.011v2.173l1.425.356c.194.048.377.135.537.255L13.3 15.1a.5.5 0 0 1-.3.9H3a.5.5 0 0 1-.3-.9l1.838-1.379c.16-.12.343-.207.537-.255L6.5 13.11v-2.173c-.955-.234-2.043-1.146-2.833-3.012a3 3 0 1 1-1.132-5.89A33 33 0 0 1 2.5.5m.099 2.54a2 2 0 0 0 .72 3.935c-.333-1.05-.588-2.346-.72-3.935m10.083 3.935a2 2 0 0 0 .72-3.935c-.133 1.59-.388 2.885-.72 3.935M3.504 1q.01.775.056 1.469c.13 2.028.457 3.546.87 4.667C5.294 9.48 6.484 10 7 10a.5.5 0 0 1 .5.5v2.61a1 1 0 0 1-.757.97l-1.426.356a.5.5 0 0 0-.179.085L4.5 15h7l-.638-.479a.5.5 0 0 0-.18-.085l-1.425-.356a1 1 0 0 1-.757-.97V10.5A.5.5 0 0 1 9 10c.516 0 1.706-.52 2.57-2.864.413-1.12.74-2.64.87-4.667q.045-.694.056-1.469z" />
                    </svg>
			</a></li>
		</ul>
	</nav> 

	<main class="container">
		<h2 class="d-flex align-items-end justify-content-center mt-3 ">정당 이름</h2>
		<div class="members row justify-content-around">
			<!-- <div class="member-info col-6 row justify-content-center"></div> -->
			     
            
				<div class="row member-info col-6 justify-content-center">
					<h3 class="text-center">${party.p_name}</h3>
					<a class="text-center"><img src="img/profile.png" class="w-50 mb-3"></a>
					<h4 class="text-center">등록연월일: ${party.p_indate}</h4>
					<h4 class="text-center">대표자: ${party.p_reader}</h4>
					<h4 class="text-center">${party.p_tel1}-${party.p_tel2}-${party.p_tel3}</h4>
					
				</div>
		
		</div>


	</main>
	<footer>
		<div
			class="text-dark d-flex align-items-end justify-content-center p-3">copyright:
			Kim yoon-jeong, Ha tae-in</div>
	</footer>
</body>

</html>