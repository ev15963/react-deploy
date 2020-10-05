<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>checkSuccess.jsp 게시글을 비밀번호가 일치할 경우 처리를 위한 jsp 페이지</title>
</head>
<body>
<script type="text/javascript">
	if (window.name == "update") {	//만일 새창 이름이 update인경우
		//window opener(open을 해준다)의 parent(부모)는 window의 location.href 주소
		//(parent)를 생하고 사용해도 괜찮다. opener 자체에 window가 있고 open을 해야하기 때문에
		//openr를 사용
		window.opener.parent.location.href = 
			"BoardServlet?command=board_update_form&num=${param.num}";
	} else if (window.name== 'delete') {	//만일 새창 이름이 delete인 경우
		alert('삭제되었습니다.')
		window.opener.parent.location.href = 
			"BoardServlet?command=board_delete&num=${param.num}";
	}
	window.close();	//완료후 닫기

</script>
</body>
</html>