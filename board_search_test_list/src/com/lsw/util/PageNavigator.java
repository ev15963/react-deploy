package com.lsw.util;

/**
 * 페이징 네비게이터 함수
 * @author stoneis.pe.kr
 * @since 2013.07.10
 */
public class PageNavigator {
	
	/**
	 * 페이징 네비게이터를 만들어주는 함수
	 * @param totalCount	- 총수 총레코드값
	 * @param listCount		- 노출될 목록 게시물 수 한번에 보여줄 리스트수 
	 * @param pagePerBlock	- 노출될 블록 수  << 1234 >>
	 * @param pageNum		- 페이지 번호 int로 형변환
	 * @param searchType	- 검색 항목
	 * @param searchText	- 검색어 검색어에 따라 레코드 값이 달라짐
	 * @return
	 */
	public String getPageNavigator(int totalCount, int listCount, int pagePerBlock,
			int pageNum, String searchType, String searchText) { //문자열로 들어오기 때문에 숫자열로 전환 태그까지 만들어서 String으로 반환
		StringBuffer sb = new StringBuffer(); // 값이 더 빨리 처리됨 .append 사용 (buffer에게 넣어줌)
		if(totalCount > 0) {	//??
			int totalNumOfPage = (totalCount % listCount == 0) ?	//삼항연산 
					totalCount / listCount :						//한페이지에 그룹에 몇개 필요한지
					totalCount / listCount + 1;
			
			int totalNumOfBlock = (totalNumOfPage % pagePerBlock == 0) ?	//페이지 그룹에 몇개 필요한지
					totalNumOfPage / pagePerBlock :							// 1 2 3 4 5 
					totalNumOfPage / pagePerBlock + 1;						// 6 7 8 9 10
																			//111213
			int currentBlock = (pageNum % pagePerBlock == 0) ? 				//몇번째 그룹에 있는지 확인하기 위해서 클린한 페이지로 다시돌아감
					pageNum / pagePerBlock :
					pageNum / pagePerBlock + 1;
			
			int startPage = (currentBlock - 1) * pagePerBlock + 1;			//시작과 끝번호 (리스트 꺼내기 위해서)
			int endPage = startPage + pagePerBlock - 1;
			
			if(endPage > totalNumOfPage)
				endPage = totalNumOfPage;
			
			boolean isNext = false;
			boolean isPrev = false;
			if(currentBlock < totalNumOfBlock)	
				isNext = true;
			
			if(currentBlock > 1)
				isPrev = true;
			
			if(totalNumOfBlock == 1){		//첫번째 그룹과 같으면 false		// 1 2 3 4 5 
				isNext = false;													// 6 7 8 9 10
				isPrev = false;													//111213
			}
			//////////////////////////////////////////////////////////////////
			
//			"<a href="boardList?pageNum=1&searchType="+전체검색/제목/작성자/내용+"&searchText="+searchText" title="<<"><<</a> ");
			if(pageNum > 1){
				sb.append("<a href=\"").append("boardList?pageNum=1&amp;searchType="+searchType+"&amp;searchText="+searchText); //검색까지 해줘야한다 &-> &amp;
				sb.append("\" title=\"<<\"><<</a>&nbsp;");	//&nbsp; 띄어쓰기  "title="<<"><<
			}
			if (isPrev) {
				int goPrevPage = startPage - pagePerBlock;			
				sb.append("&nbsp;&nbsp;<a href=\"").append("boardList?pageNum="+goPrevPage+"&amp;searchType="+searchType+"&amp;searchText="+searchText);
				sb.append("\" title=\"<\"><</a>"); //  
			} else {
				
			}
			for (int i = startPage; i <= endPage; i++) {
				if (i == pageNum) {
					sb.append("<a href=\"#\"><strong>").append(i).append("</strong></a>&nbsp;&nbsp;");
				} else {
					sb.append("<a href=\"").append("boardList?pageNum="+i+"&amp;searchType="+searchType+"&amp;searchText="+searchText);
					sb.append("\" title=\""+i+"\">").append(i).append("</a>&nbsp;&nbsp;");
				}
			}
			if (isNext) {
				int goNextPage = startPage + pagePerBlock;
	
				sb.append("<a href=\"").append("boardList?pageNum="+goNextPage+"&amp;searchType="+searchType+"&amp;searchText="+searchText);
				sb.append("\" title=\">\">></a>");
			} else {
				
			}
			if(totalNumOfPage > pageNum){
				sb.append("&nbsp;&nbsp;<a href=\"").append("boardList?pageNum="+totalNumOfPage+"&amp;searchType="+searchType+"&amp;searchText="+searchText);
				sb.append("\" title=\">>\">>></a>");
			}
			
		}
		return sb.toString(); //Stringbuffer에서 toString으로 타입 변환하여 리턴
	}
}
