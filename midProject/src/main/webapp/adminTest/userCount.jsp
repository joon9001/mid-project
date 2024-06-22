<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 방문자 수 확인하기 -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <script language="JavaScript">  
        expireDate = new Date  // 현재의 날짜 객체를 생성 
        expireDate.setMonth(expireDate.getMonth()+3)  // 현재 월에 3개월을 더함. 쿠키의 유효기간 설정.(현재~3개월) 
        hitCt = eval(cookieVal("pageHit"))  // 방문 카운트 변수이며 cookieVal 함수를 실행. 
        hitCt++  // 방문 카운트 +1
        document.cookie = "pageHit="+hitCt+";expires=" + expireDate.toGMTString() // 이곳에서 쿠키를 갱신.   
        function cookieVal(cookieName) {  // cookieVal 함수를 선언함.   
           thisCookie = document.cookie.split("; ")  // 쿠키의 문자열 구조가 '쿠키명=쿠키값; expires=유효기간' 이기 때문에 먼저 세미콜론(;)으로 나눔.(split) 
           for (i=0; i<thisCookie.length; i++) { // ; 으로 나눈 만큼 반복문을 실행. 여기서는 2번을 반복함.   
                if (cookieName == thisCookie[i].split("=")[0]) {  // 먼저 thisCookie[i].split("=")[0]은 '쿠키명=쿠키값' 구조에서 =으로 나눈 배열의 첫번째 값을 지칭함(쿠키명). 
                     return thisCookie[i].split("=")[1]  // thisCookie[i].split("=")[1] 은 =으로 나눈 배열의 두번째 값.(쿠키값) 
               }   
         }   
         return 0   
        }   
        </script>     
<h3 align=center>  
<script language="javascript" type="text/javascript">  
    document.write("현재 홈페이지에 <font color=red>" + hitCt + "</font> 번째 방문자입니다!")  
</script>  
</h3> 
</body> 
</html>