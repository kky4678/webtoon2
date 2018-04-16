<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>로그인 페이지</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

    <!-- 제이쿼리 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- index.js -->
    <script src="/toon/resources/js/member/login.js"></script>
    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
    
    <style>
    	#loginform{
    		width: 800px;
    	}
    	#loginform > button{
    		width: 100%;
    	}
    </style>
</head>

<body>
    <div id="loginform" class = "container">
    <h3>로그인 페이지</h3>
        <div class="form-group">
            <label for="id">아이디</label>
            <input type="email" class="form-control" id="m_id" placeholder="example@supportoon.com">
        </div>

        <div class="form-group">
            <label for="pw">비밀번호</label>
            <input type="text" class="form-control" id="m_pw" placeholder="비밀번호">
        </div>
        <button id = "login" class = "btn btn-info">로그인</button>
        <button id = "register" class = "btn btn-danger">회원가입</button>
    </div>
</body>

</html>
