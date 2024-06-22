<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<link rel="stylesheet" href="../css/adminMain.css">
<script type="text/javascript" src="../js/adminMain.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script>
window.onload = function() {
    // 첫 번째 차트
    const ctx1 = document.getElementById('myChart1').getContext('2d');
    new Chart(ctx1, {
      type: 'bar',
      data: {
        labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
        datasets: [{
          label: '# of Votes',
          data: [12, 19, 3, 5, 2, 3],
          borderWidth: 1
        }]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
    });

    // 두 번째 차트
    const ctx2 = document.getElementById('myChart2').getContext('2d');
    new Chart(ctx2, {
      type: 'line',
      data: {
        labels: ['January', 'February', 'March', 'April', 'May', 'June'],
        datasets: [{
          label: '# of Votes',
          data: [10, 15, 13, 20, 18, 10],
          borderWidth: 1
        }]
      },
      options: {
        scales: {
          y: {
            beginAtZero: true
          }
        }
      }
    });
};

// 페이지 전환 함수
function showPage(pageId) {
    const pages = document.querySelectorAll('.page');
    pages.forEach(page => {
        if (page.id === pageId) {
            page.style.display = 'block';
        } else {
            page.style.display = 'none';
        }
    });
}
</script>
<style>
/* 페이지 숨기기 기본 스타일 */
.page {
    display: none;
}

/* 기본으로 첫 번째 페이지를 표시 */
#page-dashboard {
    display: block;
}
</style>
</head>
<body>
    <div class="container">
        <header class="header">
        </header>
        <nav class="sidebar">
            <ul>
                <li><a href="#" onclick="showPage('page-dashboard')">대시보드</a></li>
                <li><a href="#" onclick="showPage('page-users')">유저</a></li>
                <li><a href="#" onclick="showPage('page-reviews')">리뷰/댓글</a></li>
                <li><a href="#" onclick="showPage('page-reports')">신고/문의</a></li>
            </ul>
        </nav>
        <main class="main-content">
            <!-- 대시보드 페이지 -->
            <div id="page-dashboard" class="page">
                <h2>대시보드</h2>
                <div style="width: 50%;">
                    <canvas id="myChart1"></canvas>
                </div>
                <div style="width: 50%;">
                    <canvas id="myChart2"></canvas>
                </div>
            </div>
            <!-- 유저 페이지 -->
            <div id="page-users" class="page">
                <h2>유저</h2>
                <!-- 유저 관련 내용 -->
            </div>
            <!-- 리뷰/댓글 페이지 -->
            <div id="page-reviews" class="page">
                <h2>리뷰/댓글</h2>
                <!-- 리뷰/댓글 관련 내용 -->
            </div>
            <!-- 신고/문의 페이지 -->
            <div id="page-reports" class="page">
                <h2>신고/문의</h2>
                <!-- 신고/문의 관련 내용 -->
            </div>
        </main>
        <footer class="footer"></footer>
    </div>
</body>
</html>
