import Book from './Book.js'
//위에 book을 import해야지만 아래 클래스에서 book을 extends 할 수 있다.
class Magazine extends Book{
	constructor(title, author, isbn, issueNumber){
		super(title, author, isbn);
		this.issueNumber = issueNumber; // 잡지 호수
	}
	
	toString(){ // 책 정보를 문자열로 반환
		return `책 제목:${this.title}, 저자:${this.author}, ISBN:${this.isbn}, 호수:${this.issueNumber}`;
	}
}

export default Magazine;
