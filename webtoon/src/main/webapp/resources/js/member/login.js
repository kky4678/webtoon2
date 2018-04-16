$(document).ready(function() {
	$("#login").click(function() {
		var json = {
			m_id : $.trim($("#m_id").val()),
			m_pw : $.trim($("#m_pw").val())
		};

		$.ajax({
			type : "post",
			url : "login",
			data : json,
			success : function(data) {
				// 0 정상, 1 아이디 비번 검색이 안됨, 2 아이디 검색중 DB 신텍스 오류, 3 아이디 검색 결과가 없음, 4 아이디 검색중 신텍스 오류
				switch (Number(data)) {
				case 0:
					window.location.href = "/toon";
					break;
					
				case 1:
					alert('아이디 또는 비밀번호를 확인 할 수 없습니다.');
					break;

				default:
					alert('로그인 중 오류가 발생 했습니다. [error code :' + Number(data) + "]");
					break;
				}
			},
			error : function(error) {
				alert('오류가 발생 이유' + error);
			}
		});
	});

	$("#register").click(function() {
		window.location.href = "/toon/member/register";
	});
});