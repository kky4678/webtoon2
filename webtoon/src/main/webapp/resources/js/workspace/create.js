$(document).ready(function() {
	$("#kv-explorer").fileinput({
		'theme' : 'explorer-fa',
		overwriteInitial : false,
		initialPreviewAsData : false,
		showUpload : false,
		showClose : false,
		maxFileSize : 3000,
		allowedFileExtensions : [ 'jpg', 'png', 'gif' ]
	});
	
	$("#cancel").click(function(){
		window.location.href = "/toon";
	});

	$("#create").click(function() {
		var json = {
			w_teamname : $("#w_teamname").val(),
			w_title : $("#w_title").val(),
			w_information : $("#w_information").val(),
			w_file : $("#kv-explorer")[0].files[0]
		};

		if(!syntax(json)) return;
		
		if (HobbyCheck()) json['w_hobby'] = JSON.stringify(HobbyCheck());
		else return;

        $.ajax({
			type : "post",
			url : "create",
			data : change(json),
			processData : false,
			contentType : false,
			success : function(data) {
				//0 정상 가입, 1 팀이름 중복, 2 설렉트 신텍스 오류, 3 인설트 신텍스 오류
				switch (Number(data)) {
				case 0:
					alert('정상적으로 생성이 되었습니다.');
					window.location.href = "/toon";
					break;
					
				case 1:
					alert('팀 이름이 중복이 되었습니다.');
					break;

				default:
					alert('공간개설 중 오류가 발생 했습니다. [error code :' + Number(data) + "]");
					break;
				}
			},
			error : function(error) {
				alert("오류 발생"+error);
			}
		});
		
	});
	
	function change(json){
        var formData = new FormData();
        for(var i in json){
        	 formData.append(i, json[i]);
        }
        return formData;
	}

	function syntax(json) {
		var result = {
			w_teamname : "팀 이름",
			w_title : "웹툰 제목"
		};

		for ( var str in json) {
			if (str !== "w_information" && str !== "w_file" && json[str].length == 0) {
				alert(result[str] + ' 정보를 입력 하세요.');
				$("#" + str).focus();
				return false;
			}
		}
		return true;
	}

	function HobbyCheck() {
		var Hobby = new Array();
		var i = 0;
		$('.hobby').each(function(index) {
			if ($(this).prop("checked")) {
				Hobby[i] = index + 1;
				i++;
			}
		});
		if (i > 2) {
			alert("장르는 2개까지만 가능 합니다.");
			return false;
		} else if (i == 0) {
			alert("장르를 한개 이상 선택 해주세요.");
			return false;
		}
		return Hobby;
	}
});
