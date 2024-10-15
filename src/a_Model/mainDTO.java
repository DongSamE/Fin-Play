package a_Model;

public class mainDTO {
		// Model : 데이터를 관리하는 코드 모음
			// DTO: Data Transfer Object
			// ->  데이터를 가져오거나(getter), 변경하기(setter)
			
			// 1.필드 -> 아이디, 비번, 이름, 나이(private)
			private String name;
			private String id;
			private String pw;
			
			// 2. 메소드
			
			// 생성자 메소드
			public mainDTO(String name, String id, String pw) {
				this.name = name;
				this.id = id;
				this.pw = pw;
			}
			// 로그인 메소드
			public mainDTO(String id, String pw) {
				this.id = id;
				this.pw = pw;
			
			}

			public String getName() {
				return name;
			}
			public String getId() {
				return id;
			}
			public String getPw() {
				return pw;
			}

			
		


}
