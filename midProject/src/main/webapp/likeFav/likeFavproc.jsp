<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="likeFavMgr" class="likefav.LikeFavMgr"/>
<%
int no = Integer.parseInt(request.getParameter("reply_book_no")); //책번호
boolean b = likeFavMgr.checkFav(no); //찜을 한 경우 true
out.print(b);
if(b){//찜 취소
	likeFavMgr.cancelLike(no);
	%>
	<script>
		location.href="history.back(-2)";
	</script><%
	//out.print("찜이 취소되었습니다.");
}else{//찜하기.. 자체가 안되겠다..! 화면에서 사라짐..ㅎ
	/*auto-increment*/
	/* int newNum = likeFavMgr.currentMaxNum() +1;
	likeFavbean.setLike_no(newNum);
	likeFavMgr.FavBook(no);*/
	//out.println("찜하기 완료");
}

%>