   $(document).ready(function() {
        fetch('../admin/adminUser.jsp')
            .then(response => response.json())  // 응답을 JSON으로 변환
            .then(data => {
                const userListElement = document.getElementById('userTableBody');
                userListElement.innerHTML = ''; // 기존 내용을 지움

                data.forEach(member => {
                    const row = document.createElement('tr');
                    row.innerHTML = `
                        <td>${member.id}</td>
                        <td>${member.uname}</td>
                        <td>${member.email}</td>
                    `;
                    userListElement.appendChild(row);
                });
            })
            .catch(error => console.error('Error fetching data:', error)); // 데이터 요청 중 오류 발생 시 콘솔에 에러 출력
    });