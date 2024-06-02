<<<<<<< HEAD
let xhr
let checkFirst = loopSend = false;
//부울 값으로, 초기 값은 모두 false입니다. 특정 상태를 추적하기 위해 사용됩니다.
let kbs;

function sijak(){
	if(checkFirst === false){
	//kbs: setTimeout의 식별자를 저장하기 위한 변수.
		kbs = setTimeout("sendkeyword()", 800);
		loopSend = true;
	}
}

function sendkeyword(){
	//let keyWord = document.querySelector("#kbs").values;
	let keyWord = document.frm.keyword.value;
	//console.log(keyWord);
	
	if(keyWord === ""){
		hide();
	}else{
		xhr = new XMLHttpRequest();
		let para = "keyword=" + keyWord;
		xhr.open("get", "jq8.jsp?" + para, true);
		xhr.onreadystatechange = function(){
			if(xhr.readyState === 4 && xhr.status === 200){
				process();
			}
		}
		xhr.send(null);
	}
	clearTimeout(kbs);  // setTimeout 설정 해제
}

function process(){
	let resultData = xhr.responseText;
	//console.log(resultData);
	let result = resultData.split("|");
	// 2|홍길동,홍두깨 형태로 저장되있는 자료를 |를 기준으로 자른다.
	//console.log(`건수:${result[0]} 자료:${result[1]}`);
	let tot = result[0];
	if(tot > 0){
		let datas = result[1].split(",");
//홍길동,홍두깨 형태의 배열을 ,를 기준으로 split한다.		
		let imsi = "";
		for(let i=0; i < datas.length; i++){
			imsi += "<a href=\"javascript:func('" + datas[i] + "')\">" + 
								datas[i] + "</a><br>";
		}
		console.log(imsi);
		document.querySelector("#suggestList").innerHTML = imsi;
		show();
	}
}

function func(reData){
	//alert(reData);
	frm.sel.value = reData;
	loopSend = checkFirst = false;
	hide();
	
	frm.keyword.value = "";
}

function hide(){
	document.querySelector("#suggest").style.display="none";
}

function show(){
	document.querySelector("#suggest").style.display="";
}
=======
let xhr
let checkFirst = loopSend = false;
//부울 값으로, 초기 값은 모두 false입니다. 특정 상태를 추적하기 위해 사용됩니다.
let kbs;

function sijak(){
	if(checkFirst === false){
	//kbs: setTimeout의 식별자를 저장하기 위한 변수.
		kbs = setTimeout("sendkeyword()", 800);
		loopSend = true;
	}
}

function sendkeyword(){
	//let keyWord = document.querySelector("#kbs").values;
	let keyWord = document.frm.keyword.value;
	//console.log(keyWord);
	
	if(keyWord === ""){
		hide();
	}else{
		xhr = new XMLHttpRequest();
		let para = "keyword=" + keyWord;
		xhr.open("get", "jq8.jsp?" + para, true);
		xhr.onreadystatechange = function(){
			if(xhr.readyState === 4 && xhr.status === 200){
				process();
			}
		}
		xhr.send(null);
	}
	clearTimeout(kbs);  // setTimeout 설정 해제
}

function process(){
	let resultData = xhr.responseText;
	//console.log(resultData);
	let result = resultData.split("|");
	// 2|홍길동,홍두깨 형태로 저장되있는 자료를 |를 기준으로 자른다.
	//console.log(`건수:${result[0]} 자료:${result[1]}`);
	let tot = result[0];
	if(tot > 0){
		let datas = result[1].split(",");
//홍길동,홍두깨 형태의 배열을 ,를 기준으로 split한다.		
		let imsi = "";
		for(let i=0; i < datas.length; i++){
			imsi += "<a href=\"javascript:func('" + datas[i] + "')\">" + 
								datas[i] + "</a><br>";
		}
		console.log(imsi);
		document.querySelector("#suggestList").innerHTML = imsi;
		show();
	}
}

function func(reData){
	//alert(reData);
	frm.sel.value = reData;
	loopSend = checkFirst = false;
	hide();
	
	frm.keyword.value = "";
}

function hide(){
	document.querySelector("#suggest").style.display="none";
}

function show(){
	document.querySelector("#suggest").style.display="";
}
>>>>>>> branch 'main' of https://github.com/joon9001/java_source.git
