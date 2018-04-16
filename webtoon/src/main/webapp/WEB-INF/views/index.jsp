<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="true" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>로그인 페이지</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

    <!-- 제이쿼리 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- index.js -->
    <script src="/toon/resources/js/member/index.js"></script>
    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    
    <style>
    	#box{
    		width: 800px;
    	}
    	#loginform > button{
    		width: 100%;
    	}
    	#box > h3{
    		text-align: center;
    	}
    	#box > button{
    		width: 100%;
    	}
    </style>
</head>

<body>
    <div id="box" class = "container">	
		<h3> ${sessionScope.m.m_nick}님 환영 합니다. </h3>
		<button id = "Mypage" class = "btn btn-secondary">마이페이지</button>
		<button id = "CreateWorkSpace" class = "btn btn-info">공간 개설</button>
		<button id = "logout" class = "btn btn-danger">로그아웃</button>
    </div>
</body>

</html>
