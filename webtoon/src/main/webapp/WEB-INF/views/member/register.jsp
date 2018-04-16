<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>회원가입 페이지</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

    <!-- 제이쿼리 -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- index.js -->
    <script src="/toon/resources/js/member/register.js"></script>
    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

    <style>
        #loginform {
            width: 500px;
        }

        #loginform>button {
            width: 100%;
        }

        #loginform>h3 {
            text-align: center;
        }
        label > span{
        	color : red;
        }
    </style>
</head>

<body>
    <div id="loginform" class="container">
        <h3>회원가입 페이지</h3>
        <div class="form-group">
            <label for="m_id">이메일 <span>*</span></label>
            <input type="email" class="form-control" id="m_id" placeholder="example@supportoon.com">
        </div>

        <div class="form-group">
            <label for="m_pw">비밀번호 <span>*</span></label>
            <input type="password" class="form-control" id="m_pw" placeholder="비밀번호">
        </div>

        <div class="form-group">
            <label for="m_pw2">비밀번호 확인 <span>*</span></label>
            <input type="password" class="form-control" id="m_pw2" placeholder="비밀번호">
        </div>

        <div class="form-group">
            <label for="m_nick">닉네임 <span>*</span></label><br>
            <input type="text" class="form-control" id="m_nick" placeholder="닉네임">
        </div>

        <div class="form-group">
            <label for="m_birthday">생년월일 <span>*</span></label>
            <label for="m_gender" style = "display: none;">뒷자리</label><br>
            <input type="date" class="form-control" id="m_birthday" style="width: 300px; display: inline;" placeholder="970831" maxlength="6"> -
            <input type="text" class="form-control" id="m_gender" style="width: 35px; display: inline;" placeholder="1" maxlength="1">******
        </div>
        
        <div class="form-group">
            <label for="m_class">유형 <span>*</span></label>
            <select class="form-control" id="m_class">
              <option>없음</option>
              <option>글</option>
              <option>그림</option>
              <option>글/그림</option>
              <option>어시스턴트</option>
              <option>방문자</option>
            </select>
        </div>
        
       <div class="form-group">
            <label for="m_location">지역 <span>*</span></label>
            <%String[] location = {"서울","경기","인천","대전","대구","부산","울산","광주","강원","세종","충북","충남","경북","경남","전북","전남","제주","해외"}; %>
            <select class="form-control" id="m_location">
              <option>없음</option>
              <%for(int i = 0; i < location.length; i ++){ %>
              	<option><%=location[i] %></option>
              <%} %>
            </select>
        </div>
		<%String Hobby[] = {"에피소드", "옵니버스", "스토리", "일상", "개그", "판타지", "액션", "드라마", "순정", "감성", "스릴러", "시대극", "스포츠"};%>
        <div class=".checkbox-inline">
           <label for="hobby">관심분야</label><br>
			<%for(int i = 0; i <Hobby.length; i ++){ %>
				<label>
	              <input type="checkbox" class = "hobby"> <%=Hobby[i] %>
	            </label>
            <%} %>
        </div>

        <button id="register" class="btn btn-info">로그인</button>
        <button id="cancel" class="btn btn-danger">뒤로가기</button>
    </div>
</body>

</html>