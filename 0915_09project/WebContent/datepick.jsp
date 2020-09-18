<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Date-Time picker Test</title>
<!-- 제이쿼리 라이브러리 -->
<script src="http://code.jquery.com/jquery-1.7.min.js"></script>

<!-- 제이쿼리 ui css -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/smoothness/jquery-ui.css">

<!-- Time picker -->
<script type="text/javascript" src="jquery.timepicker.min.js"></script>
<link rel="stylesheet" href="jquery.timepicker.min.css">

<!-- Date picker(제이쿼리 ui) -->
<script src="//code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<script type="text/javascript">
	$(document).ready(
			function() {
				var date = new Date();
				var year = date.getFullYear();
				var month = date.getMonth() + 1; // 1~12가 아니라 0~11로 반환되므로 +1
				var day = date.getDate();
				var hours = date.getHours();
				var minutes = date.getMinutes();
				var today = year + "-" + month + "-" + day;
				console.log(today);
				/*-------------------date picker---------------------------------*/

				$.datepicker.setDefaults({
					dateFormat : 'yy-mm-dd',
					monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월',
							'8월', '9월', '10월', '11월', '12월' ],
					monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월',
							'7월', '8월', '9월', '10월', '11월', '12월' ],
					dayNames : [ '일', '월', '화', '수', '목', '금', '토' ], //한글 캘린더 요일 표시 부분
					dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ], //한글 요일 표시 부분
					dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ], // 한글 요일 표시 부분
					showMonthAfterYear : true, // true : 년 월  false : 월 년 순으로 보여줌
					yearSuffix : '년',
				//            showButtonPanel: true,   // 오늘로 가는 버튼과 달력 닫기 버튼 보기 옵션
				//            closeText: '닫기', // 닫기 버튼 텍스트 변경
				//            currentText: '오늘', // 오늘 텍스트 변경
				});

				$('#rev_date').datepicker({
					maxDate : '+1m',
					minDate : '0' // 예약가능 날짜는 당일부터 한달뒤까지만
				});

				$('#rev_date').datepicker("setDate", "today"); // 기본값 세팅

				/*-------------------time picker---------------------------------*/

				console.log("현재 시간 => " + hours + ":" + minutes);

				// hours
				if (hours > 19 || hours < 10) {
					hours = 10;
					minutes = '00';
				} else {
					// minutes 30분 단위 반올림
					if (minutes == 0) {
						minutes = '00';
					} else if (minutes < 30) {
						minutes = 30;
					} else if (minutes > 30) {
						minutes = '00';
						if (hours != 10 || hours != 20) {
							hours += 1;
						}
					}
				} // hours, minutes 설정 완료

				console.log("시작 예약가능 시간 => " + hours + ":" + minutes);

				// timepicker 설정
				$('#rev_time').timepicker({
					minTime : hours + ":" + minutes,
					maxTime : '20:00', // 마지막 예약가능 시간
					timeFormat : 'h:i a',
					step : 30, // 30분 단위로 지정.
					dropdown : true, // 드롭다운 표시 여부
					useSelect : true, // select 형태로 사용 -> 사용자가 임의로 입력시간 조절불가
					//          disableTimeRanges : [ [ '1pm', '2pm' ], [ '3pm', '4:01 pm' ] ] // 막아놓을 시간 설정

				});

			});
</script>

</head>

<body>
<form>
	<table>
		<tr>
			<th>예약년,월,일</th>
			<td><input type="text" name="rev_date" id="rev_date" size="8" required="required" /></td>
		</tr>
		<tr>
			<th>예약시간</th>
			<td><input type="text" name="rev_time" id="rev_time" required="required"/></td>
		</tr>
		<tr>
			<td><input type="submit" name="submit" value="제출" /></td>
		</tr>
	</table>
	</form>
</body>
</html>