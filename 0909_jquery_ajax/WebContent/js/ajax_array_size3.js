$(document).ready(function() {
			//아래 버튼을 클릭했을 때 ajaxResult.jsp를 호출..
			//이 때 ajax() 함수를 사용하여 전송방식을 설정..
			
			$('#call').click(function() {
				var input1 = $("num").val();
				console.log(input)
				var request = $.ajax({
					url: "ajaxResult3.jsp",	// 호출된 url
					method : "POST",		//메서드 type : post/get
					data : { paramNum : 1 }, //파라미터 (생략가능)
					dataType: "json"		// 응답타임 응답받을 전달받을 데이터가 없으면 생략가능
				
			});
				
				//응답완료 후 실행 - 정상 처리 성공시
				request.done(function(data) {
					console.log(data)
				
					$("#myName").empty();	//초기화처리
					
					for (var i=0; i <data.result.length; i++) {
						$("#myName").append('<div>'+data.result[i]+'</div>');
					}
					
				});	//request.done() END
				
				////////////////////////////////////////////
				//에러발생시 실행 실패시
				request.fail(function(jqXHR, textStatus) {
					alert("Request failed: "+ textStatus);
				}); //request.fail() END
				
			}); //$('#call').click() END
				
			


		});	//ready() END