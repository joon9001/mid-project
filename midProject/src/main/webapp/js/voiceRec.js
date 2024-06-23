  let recognition;

        function availabilityFunc() {
            if ('webkitSpeechRecognition' in window) {
                recognition = new webkitSpeechRecognition();
            } else if ('SpeechRecognition' in window) {
                recognition = new SpeechRecognition();
            } else {
                alert("현재 브라우저는 음성 인식을 지원하지 않습니다.");
                return;
            }

            recognition.lang = "ko";
            recognition.maxAlternatives = 5;

            recognition.addEventListener("speechstart", () => {
                console.log("음성 인식 시작");
            });

            recognition.addEventListener("speechend", () => {
                console.log("음성 인식 종료");
                recognition.stop();
            });

            recognition.addEventListener("result", (e) => {
                const searchConsole = document.getElementById("search_console");
                searchConsole.value = e.results[0][0].transcript;
                console.log("인식된 텍스트: ", searchConsole.value);
            });
        }

        function startRecord() {
            if (recognition) {
                recognition.start();
                console.log("음성 인식 중...");
            }
        }

        function endRecord() {
            if (recognition) {
                recognition.stop();
                console.log("음성 인식 중단");
            }
        }

        window.addEventListener("load", availabilityFunc);