let recognition; // 음성 인식 객체를 저장할 변수 선언
let isRecognizing = false; // 음성 인식 상태를 추적하기 위한 변수 선언 및 초기화

function availabilityFunc() {
    if ('webkitSpeechRecognition' in window) { // Webkit 기반 브라우저에서 음성 인식 기능 사용 가능 여부 확인
        recognition = new webkitSpeechRecognition(); // webkitSpeechRecognition 객체 생성
    } else if ('SpeechRecognition' in window) { // 표준 SpeechRecognition 기능 사용 가능 여부 확인
        recognition = new SpeechRecognition(); // SpeechRecognition 객체 생성
    } else { // 음성 인식 기능이 지원되지 않는 브라우저 처리
        alert("현재 브라우저는 음성 인식을 지원하지 않습니다."); // 지원되지 않는 경우 경고 메시지 표시
        return;  
    }

    recognition.lang = "ko"; // 음성 인식 언어를 한국어로 설정
    recognition.maxAlternatives = 5; 

    recognition.addEventListener("speechstart", () => {
        console.log("음성 인식 시작");
        isRecognizing = true;
    });

    recognition.addEventListener("speechend", () => {
        console.log("음성 인식 종료");
        recognition.stop();
        isRecognizing = false;
    });

    recognition.addEventListener("result", (e) => {
        const searchConsole = document.querySelector(".search_txt");
        if (searchConsole) {
            searchConsole.value = e.results[0][0].transcript;
            console.log("인식된 텍스트: ", searchConsole.value);
        }
    });

    recognition.addEventListener("error", (e) => {
        console.error("음성 인식 오류: ", e);
        isRecognizing = false;
    });
}

function startRecord() {
    if (recognition && !isRecognizing) {
        recognition.start();
        console.log("음성 인식 중...");
    }
}

function endRecord() {
    if (recognition && isRecognizing) {
        recognition.stop();
        console.log("음성 인식 중단");
    }
}

window.addEventListener("load", availabilityFunc);
