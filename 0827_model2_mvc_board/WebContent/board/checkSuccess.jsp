<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>수정, 삭제가 성공했을 경우 checkSuccess.jsp</title>
</head>
<body>
<script type="text/javascript">
if (window.name== "update") {
	window.opener.paerent.location.href = 
		"BoardServlet?command=board_update_form&num=${param.num}";
} else if (window.name == "delete") {
	alert("삭제되었습니다.");
	window.opener.parent.locaton.href = 
		"BoardServlet?command=board_delete&num=${param.num}";
}
window.close();
</script>
</body>
</html>