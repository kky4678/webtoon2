<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>팀 개설하기</title> 
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet">
    <link href="/toon/resources/bootstrap-fileinput-master/css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" media="all" rel="stylesheet" type="text/css" />
    <link href="/toon/resources/bootstrap-fileinput-master/themes/explorer-fa/theme.css" media="all" rel="stylesheet" type="text/css" />
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="/toon/resources/bootstrap-fileinput-master/js/plugins/sortable.js" type="text/javascript"></script>
    <script src="/toon/resources/bootstrap-fileinput-master/js/fileinput.js" type="text/javascript"></script>
    <script src="/toon/resources/bootstrap-fileinput-master/js/locales/fr.js" type="text/javascript"></script>
    <script src="/toon/resources/bootstrap-fileinput-master/js/locales/es.js" type="text/javascript"></script>
    <script src="/toon/resources/bootstrap-fileinput-master/themes/explorer-fa/theme.js" type="text/javascript"></script>
    <script src="/toon/resources/bootstrap-fileinput-master/themes/fa/theme.js" type="text/javascript"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" type="text/javascript"></script>
    <script src="/toon/resources/js/workspace/create.js"></script>
    
    <style>
    	#box{
    		width: 1000px;
    	}
    	#box > button{
    		width: 100%;
    	}
    </style>
</head>

<body>
    <div id="box" class = "container">
    	<h3>팀 생성 페이지</h3>
        <div class="form-group">
            <label for="w_teamname">팀 이름</label>
            <input type="text" class="form-control" id="w_teamname" placeholder="서포툰">
        </div>

		<div class="form-group">
            <label for="w_title">웹툰 제목</label>
            <input type="text" class="form-control" id="w_title" placeholder="미녀와 야수">
        </div>
        
        <div class="form-group">
            <label for="w_information">웹툰 소개</label>
            <textarea class = "form-control" id = "w_information" placeholder="소개글"></textarea>
        </div>
        
		<%String Hobby[] = {"에피소드", "옵니버스", "스토리", "일상", "개그", "판타지", "액션", "드라마", "순정", "감성", "스릴러", "시대극", "스포츠"};%>
        <div class=".checkbox-inline">
           <label for="hobby">장르</label><br>
			<%for(int i = 0; i <Hobby.length; i ++){ %>
				<label>
	              <input type="checkbox" class = "hobby"> <%=Hobby[i] %>
	            </label>
            <%} %>
        </div>
        
        <div class="file-loading">
	        <input id="kv-explorer" type="file">
	    </div>
        
        <button class = "btn btn-info" id = "create">팀 개설</button>
        <button class = "btn btn-secondary" id = "cancel">뒤로가기</button>
 
    </div>
</body>

</html>
