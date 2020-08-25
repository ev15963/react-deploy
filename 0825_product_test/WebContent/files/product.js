function productCheck() {
	//name 속성인 frm NaN (= not a number) : 숫자가 아니니?
	if (isNaN(document.frm.price.value)) { //name 속성인 frm NaN (= not a number) : 숫자가 아니니?
		alert("숫자를 입력해야 합니다"); //frm태그안에서 price 안에서 찾아야한다.
		frm.price.focus(); //price에 촛점을 맞춘다
		return false;
	}
	return true;
}