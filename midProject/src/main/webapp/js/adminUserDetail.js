
function memUpdate(id) {
    $("#userDetailModal").show();
}



$(document).ready(function() {
	
	
      // 수정 버튼 클릭 이벤트 핸들러
		$(".btnUpdate").click(function() {
			var no = $(this).data('no');
			$.ajax({
				url: 'getUserDetail.jsp',
				type: 'GET',
				data: { no: no },
				success: function(response) {
					var user = JSON.parse(response);
					$("#updateForm input[name='no']").val(user.no);
					$("#updateForm input[name='id']").val(user.id);
					$("#updateForm input[name='pw']").val(user.pw);
					$("#updateForm input[name='uname']").val(user.uname);
					$("#updateForm input[name='email']").val(user.email);
					$("#updateForm input[name='gender']").val(user.gender);
					$("#updateForm input[name='signout_is']").val(user.signout_is);
					$("#userDetailModal").show();
				},
				error: function(xhr, status, error) {
					alert("사용자 정보를 불러오는 중 오류가 발생했습니다.");
				}
			});
		});

		// 삭제 버튼 클릭 이벤트 핸들러
		$(".btnDelete").click(function() {
			if (confirm("정말 삭제하시겠습니까?")) {
				var no = $(this).data('no');
				$.ajax({
					url: 'adminUserDelete.jsp',
					type: 'POST',
					data: { no: no },
					success: function(response) {
						alert("사용자가 삭제되었습니다.");
						location.reload();
					},
					error: function(xhr, status, error) {
						alert("삭제 중 오류가 발생했습니다.");
					}
				});
			}
		});     
           
    	// 회원 정보 수정 폼 제출 이벤트 핸들러
		$("#updateForm").submit(function(event) {
			event.preventDefault();
			$.ajax({
				url: 'adminUserUpdate.jsp',
				type: 'POST',
				data: $(this).serialize(),
				success: function(response) {
					alert("회원 정보가 수정되었습니다.");
					location.reload();
				},
				error: function(xhr, status, error) {
					alert("수정 중 오류가 발생했습니다.");
				}
			});
		});
	
	
    // 모달 닫기 버튼 클릭 시
    $(".close").click(function() {
        $("#userDetailModal").hide();
    });
});
    // 모달을 여는 함수 정의
    function openModal() {
        var modal = document.getElementById("userDetailModal");
        if (modal) {
            modal.style.display = "block";

            // 모달을 닫는 <span> 요소 가져오기
            var span = document.getElementsByClassName("close")[0];

            // 사용자가 <span> (x)를 클릭하면 모달 닫기
            span.onclick = function() {
                modal.style.display = "none";
            }

            // 사용자가 모달 밖의 아무 곳이나 클릭하면 모달 닫기
            window.onclick = function(event) {
                if (event.target == modal) {
                    modal.style.display = "none";
                }
            }
        } else {
            console.error('Modal element not found');
        }
    }

    // adUserDetail 함수 정의
    window.adUserDetail = function(no) {
        // AJAX를 사용하여 데이터 전송
        $.ajax({
            url: 'adminUserDetail.jsp', // 데이터를 전송할 서버 URL
            type: 'GET', // GET 방식으로 요청
            data: { no: no }, // 전송할 데이터
            success: function(response) {
                // 페이지 이동이 아닌, 받은 응답을 모달에 출력
                $('#userDetailModal .modal-content').html(response);
                openModal(); // 모달 열기
            },
            error: function(status, error) {
                console.error('ajax err : ', status, error);
            }
        });
    };


  $(".close").click(function() {
        $("#userDetailModal").hide();
    });

    $("#updateForm").submit(function(event) {
        event.preventDefault();
        $.ajax({
            type: "POST",
            url: "userUpdateProc.jsp",
            data: $(this).serialize(),
            success: function(response) {
                alert("수정되었습니다.");
                $("#userDetailModal").hide();
                location.reload();
            },
            error: function(error) {
                alert("수정 중 오류가 발생했습니다.");
            }
        });
    });


function memberUpdateOk(){ 
	//입력자료 오류검사 생략
	document.updateForm.submit();
}
function memberUpdateCancel(){
	location.href="../admin_user/adminUser.jsp";
}



