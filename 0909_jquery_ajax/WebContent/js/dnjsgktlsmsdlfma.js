$(document).ready(function() {
			//아래 버튼을 클릭했을 때 ajaxResult.jsp를 호출..
			//이 때 ajax() 함수를 사용하여 전송방식을 설정..
			
			$('#ajaxCall').click(function() {
				var request = $.ajax({
					url: "ajaxResult.jsp",	// 호출된 url
					method : "POST",		//메서드 type : post/get
					data : { paraNum : 1 }, //파라미터 생략가능
					dataType: "json"		// 응답타임 응답받을 전달받을 데이터가 없으면 생략가능
				
			});
				
				//응답완료 후 실행 - 정상 처리 성공시
				request.done(function(data) {
					console.log(data)
				
					/*data는 ajaxResult.jsp에서 응답하는
						json 포맷방식의 데이터를 가지고 와서
						javascript Object(객체)방식으로 변환
						객체, 속성 형태로 값을 꺼내올 수 있다.
					*/
					
					console.log(data.param1)
					console.log(data.param2)
				});
				
				////////////////////////////////////////////
				//에러발생시 실행 실패시
				request.fail(function(jqXHR, textStatus) {
					alert("Request failed "+ textStatus);
				});
				
			}); //click() END
				
			


		});	//ready() END