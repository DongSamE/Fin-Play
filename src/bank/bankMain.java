package bank;

import java.util.Scanner;

import a_Model.bankDTO;
import a_Model.mainDTO;

public class bankMain {

   public void main(mainDTO dto) {
      bankDTO bdto = new bankDTO(dto);
      Scanner sc = new Scanner(System.in);

      while (true) {
         System.out.println("───────────────────────────────────────────────────────────");
         System.out.println("                        뱅킹서비스");
         System.out.println("───────────────────────────────────────────────────────────");
         //내계좌  display
         System.out.println("▼ 보유계좌");
         System.out.println("ID \t\t|은행명 \t\t|계좌번호 \t\t| 예금액");
         bankUtil.display(bdto);
         System.out.println("───────────────────────────────────────────────────────────");
         
         // 계좌관리 - 계좌 추가 & 삭제
         System.out.println("[1] 입금 [2] 출금 [3] 송금 [4] 계좌관리 [5] 종료");
         System.out.print(">> ");
         int choice = sc.nextInt();

         if (choice == 1) {
            System.out.println("[1] 입금");
            bankUtil.deposit(bdto);
         } else if (choice == 2) {
            System.out.println("[2] 출금");
            bankUtil.withdraw(bdto);
         } else if (choice == 3) {
            System.out.println("[3] 송금");
            bankUtil.transfer(bdto);
         } else if (choice == 4) {
            System.out.println("[4] 계좌관리로 이동합니다");
            bankUtil am = new bankUtil();
            am.accountMenu(bdto);
         } else if (choice == 5) {
            System.out.println("[5] 앱을 종료합니다");
            break;
         } else {
            System.out.println("잘못된 값을 입력하셨습니다.. 다시 입력하세요...");
         }
      }
   }
}
