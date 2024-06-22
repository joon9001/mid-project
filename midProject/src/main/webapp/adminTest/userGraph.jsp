<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Visitor Counter</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    
    <script src="https://unpkg.com/react/umd/react.production.min.js"></script>
<script src="https://unpkg.com/react-dom/umd/react-dom.production.min.js"></script>
<script src="https://unpkg.com/prop-types/prop-types.min.js"></script>
<script src="https://unpkg.com/recharts/umd/Recharts.js"></script>
</head>
<body>
    <h3 align="center">
        <script language="javascript" type="text/javascript">
            document.write("현재 홈페이지에 <font color=red>" + updateVisitorCount() + "</font> 번째 방문자입니다!")
        </script>
        
    </h3>

    <!-- 그래프를 표시할 캔버스 요소 -->
    <canvas id="visitorChart" width="400" height="200"></canvas>

    <script>
        function updateVisitorCount() {
            const today = new Date().toISOString().split('T')[0]; // 현재 날짜를 "YYYY-MM-DD" 형식으로 가져옴
            let visitors = JSON.parse(localStorage.getItem('visitors') || '{}'); // 로컬 스토리지에서 방문자 데이터를 가져옴
            
            if (!visitors[today]) { // 오늘 날짜의 방문자 데이터가 없는 경우
                visitors[today] = 0; // 초기화
            }
            visitors[today]++; // 오늘 날짜의 방문자 수 증가
            
            localStorage.setItem('visitors', JSON.stringify(visitors)); // 방문자 데이터를 로컬 스토리지에 저장

            return visitors[today];
        }

        function getWeeklyVisitorData() {
            const today = new Date();
            let visitors = JSON.parse(localStorage.getItem('visitors') || '{}');
            let labels = [];
            let data = [];

            for (let i = 6; i >= 0; i--) {
                let date = new Date();
                date.setDate(today.getDate() - i);
                const dateString = date.toISOString().split('T')[0];
                labels.push(dateString);
                data.push(visitors[dateString] || 0);
            }

            return { labels, data };
        }

        const ctx = document.getElementById('visitorChart').getContext('2d');
        const visitorData = getWeeklyVisitorData();
        const visitorChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: visitorData.labels,
                datasets: [{
                    label: '방문자 수',
                    data: visitorData.data,
                    backgroundColor: 'rgba(75, 192, 192, 0.2)',
                    borderColor: 'rgba(75, 192, 192, 1)',
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
    </script>
</body>
</html>
