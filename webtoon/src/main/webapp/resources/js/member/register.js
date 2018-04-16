$(document).ready(function () {
	var checklist = 0;
    $("#register").click(function () {
        var json = {
            m_id: $.trim($("#m_id").val()),
            m_pw: $.trim($("#m_pw").val()),
            m_pw2: $.trim($("#m_pw2").val()),
            m_nick: $.trim($("#m_nick").val()),
            m_birthday: $.trim($("#m_birthday").val()),
            m_gender: $.trim($("#m_gender").val()),
            m_class: $("#m_class option:selected").val(),
            m_location: $("#m_location option:selected").val()
        };
        
        var sampleevents = {};
        

        if (!syntax(json)) return;
        
        if(HobbyCheck().length != 0) json['m_hobby'] = JSON.stringify(HobbyCheck());
        json['m_gender'] = genderChange(json['m_gender']);
        
        console.log(json);
        
        $.ajax({
            type: "post",
            url: "register",
            data: json,
            success: function (data) {
                switch (Number(data)) {
				case 0:
					alert('정상적으로 회원가입 되었습니다.\n로그인 페이지로 이동 됩니다.');
					window.location.href = "/toon/member/login";
					break;
				
				case 1:
					alert('아이디가 중복 되었습니다.');
					$("#m_id").focus();
					break;
					
				case 2:
					alert('닉네임이 중복 되었습니다.');
					$("#m_nick").focus();
					break;

				default:
					alert('회원가입 중 오류가 발생 했습니다. [error code :' + Number(data) + "]");
					break;
				}
            },
            error: function (error) {
                alert('오류가 발생 이유' + error);
            }
        });
    });

    $("#cancel").click(function () {
        window.location.href = "/toon/member/login";
    });

    $('#m_gender').keyup(function () {
        if ($("#m_gender").val().length > 1) {
            alert('주민등록번호 뒷자리는 2글자 이상은 입력이 불가능 합니다.');
            $("#m_gender").val("");
            $("#m_gender").focus();
        }
    });

    function syntax(json) {
        var result = {
            m_id: "아이디",
            m_pw: "비밀번호",
            m_pw2: "비밀번호 확인",
            m_nick: "닉네임",
            m_gender : "생년월일 뒷자리"
        };

        for (var str in json) {
            if (json[str].length == 0) {
                alert(result[str] + " 정보를 입력하세요.");
                $("#" + a).focus();
                return false;
            }
        }

        if (json['m_id']) {
            var regEmail = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
            if (!regEmail.test(json['m_id'])) {
                alert('이메일 형식에 맞춰서 적어주세요.');
                return false;
            }
        }

        if (json['m_location'] == "없음") {
            alert('지역을 선택 해주세요.');
            return false;
        }

        if (json['m_class'] == "없음") {
            alert("유형을 선택 해주세요.");
            return false;
        }

        if (json['m_birthday'].length != 10) {
            alert("생년월일 앞자리의 형식을 알맞게 작성해주세요. ex) 1997-08-31");
            return false;
        }

        if (json['m_gender'].length != 1) {
            alert("생년월일 뒷 자리는 1자리를 입력해주세요. ex)970831");
            return false;
        }

        if (json['m_pw'].length < 8 || json['m_pw'].length > 25) {
            alert('비밀번호는 8자리 ~ 24자리까지 제한을 둡니다.');
            $("#m_pw").focus();
            return false;
        }

        if (json['m_pw'] !== json['m_pw2']) {
            alert('비밀번호가 일치하지 않습니다.');
            $("#m_pw").focus();
            return false;
        }
        
        if (json['m_nick'].length < 2 || json['m_nick'].length > 9) {
            alert('닉네임은 2자리에서 8자리로 제한을 둡니다.');
            $("#m_nick").focus();
            return false;
        }
        
        return true;
    }

    function HobbyCheck() {
        var Hobby = new Array();
        var i = 0;
        $('.hobby').each(function (index) {
            if ($(this).prop("checked")) {
                Hobby[i] = index + 1;
                i++;
            }
        });
        if(i > 3){
        	alert("관심분야는 3개까지만 가능 합니다.");
        	return;
        }
        return Hobby;
    }

    function genderChange(gender) {
        if (gender % 2 == 0) return 'w';
        else return 'm';
    }
});
