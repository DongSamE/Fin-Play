package a_Model;

public class bankDTO {
   
         // Model : 데이터를 관리하는 코드 모음
         // DTO: Data Transfer Object
         // ->  데이터를 가져오거나(getter), 변경하기(setter)
      
         //뱅크DTO BANKACC 맞춰서 재작성      
   
         private String userId;
         private String bName;
         private String bNum;
         private int bal;
         private String userPw;
         // 로그인 하자마자 userId가 바로 바뀌게
         public bankDTO(mainDTO dto) {
            this.userId = dto.getId();
         }
         public bankDTO(String userId, String userPw, String bName, String bNum, int bal) {
            this.userId = userId;
            this.userPw = userPw;
            this.bName = bName;
            this.bNum = bNum;
            this.bal = bal;
         }
         // 계좌 관리용 메소드
         public bankDTO(String userPw, String bName, String bNum, int bal) {
            this.userPw = userPw;
            this.bName = bName;
            this.bNum = bNum;
            this.bal = bal;
         }
         
         // 계좌 삭제 메소드
         public bankDTO(String userId, String bNum, String userPw) {
            this.userId = userId;
            this.bNum = bNum;
            this.userPw = userPw;
         }
         

         public String getUserId() {
            return userId;
         }
         public String getBName() {
            return bName;
         }
         public String getBNum() {
            return bNum;
         }
         public int getBal() {
            return bal;
         }
         public String getUserPw() {
            return userPw;
         }

         

   
      

}
