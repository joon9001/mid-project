# SceneStealer
1. DB 파일 받은 후 폴더 내 파일 번호 순서대로 복붙해서 넣기!

2. RegisterIdCheck.jsp 파일에서 아래 url의 ip주소 및 데이터베이스명과 DB 사용자이름, 비밀번호를 자기껄로 수정하기
// 데이터베이스 연결 설정
        String url = "jdbc:mariadb://192.168.0.19:3306/ss";
        conn = DriverManager.getConnection(url, "root", "123");
        
       
3. deleteProc.jsp 파일에서 아래 url의 ip주소 및 데이터베이스명과 DB 사용자이름, 비밀번호를 자기껄로 수정하기
    // 데이터베이스 연결 설정
        String url = "jdbc:mariadb://192.168.0.19:3306/ss";
        conn = DriverManager.getConnection(url, "root", "123");

   
