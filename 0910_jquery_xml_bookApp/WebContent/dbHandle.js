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
	db
			.transaction(function(tr) {
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

}

// 전체 데이터 검색 트랜잭션 실행
function listBook() {

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
