var db = null;
var var_no = null; // 페이지 받을 변수
var position = null;
var index;

// 데이터베이스 생성 및 오픈
function openDB() {
	db = window.openDatabase('bookDB', '1.0', '북DB', 1024 * 1024);
	console.log('1_DB 생성...');
}

// 테이블 생성 트랜잭션 실행
function createTable() {
	db.transaction(function(tr) {
				var createSQL = 'create table if not exists book(type text, name text)';

				tr.executeSql(createSQL, [], function() {
					console.log('2_1_테이블 생성_sql 실행성공...');
				}, function() {
					console.log('2_1_테이블 생성_sql 실행 실패...');
				});
			},
			
			function() {
				console.log('테이블 생성 트랜잭션 실패... 롤백은 자동');
			},
			
			function() {
				console.log('테이블 생성 트랜잭션 성공...');
			}
			
		);
}

// 데이터 입력 트랜잭션 실행
function insertBook() {
	db.transaction(function(tr){
		var type =$('#bookType1').val();
		var name =$('#bookName1').val();
		var insertSQL ='insert into book(type, name) values(?, ?)';
	
		tr.executeSql(insertSQL,
				[type, name],
				function(tr, rs) {
						console.log('3_책등록...no: ' + rs.insertId);
						alert('도서명' + $('#bookName1').val() + '이 입력되었습니다.');
						$('#bookName1').val('');
						$('#bookType1').val('미정').attr('selected', 'selected');
						$('#bookType1').selectmenu('refresh');
		},
		
		function(tr, err) {
			alert('DB오류 ' + err.message + err.code);
		}

		); //tr.executeSql() END
	});	//db.transaction() END
}

// 전체 데이터 검색 트랜잭션 실행
function listBook() {
	db.transcation(function(tr) {
		var selectSQL= 'select * from book';
		
		tr.executeSql(selectSQL,
				[],
				function(tr, rs) {
					console.log('책 조회...' + rs.rows.length + '건.');
					
					if (position == 'first') {
						if(index == 0) { alert('더 이상의 도서가 없습니다.'); } else { index = 0; }
					} else if(position == 'prev') {
						if(index == 0) { alert('더 이상의 도서가 없습니다.'); } else { index = --index; }
					} else if(position == 'next') {
						if(index == rs.rows.length-1) { alert('더 이상의 도서가 없습니다'); } else { index = ++index; }
					} else {
						if(index == rs.rows.length-1) { alert('더 이상의 도서가 없습니다'); } else { index = rs.rows.length-1; }
					}

					$('#bookType4').val(rs.rows.item(index).type);
					$('#bookName4').val(rs.rows.item(index).name);
			}
		);		// tr.executeSql() END
	});		// db.transaction() END
	
}

// 데이터 수정 트랜잭션 실행
function updateBook() {

}

// 데이터 삭제 트랜잭션 실행
function deleteBook() {

}

// 데이터 수정 위한 데이터 검색 트랜잭션 실행
function selectBook2(name) {

}

// 데이터 삭제 위한 데이터 검색 트랜잭션 실행
function selectBook3(name) {

}

// 데이터 조건 검색 트랜잭션 실행
function selectBook4(name) {

};
