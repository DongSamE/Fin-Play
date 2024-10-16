package bank;

import java.sql.ResultSet;
import java.util.Scanner;

import Main_Project.MainUI;
import a_Controller.bankDAO;
import a_Controller.mainDAO;
import a_Model.bankDTO;
import a_Model.mainDTO;

public class bankUtil {
   public void accountMenu(bankDTO bdto) {

      Scanner scanner = new Scanner(System.in);
      System.out.println("───────────────────────────────────────────────────────────");
      System.out.println("                        계좌관리");
      System.out.println("ID \t\t은행명 \t\t계좌번호 \t\t예금액");
      bankUtil.display(bdto);
      System.out.println("───────────────────────────────────────────────────────────");
      System.out.println("[1] 계좌생성");
      System.out.println("[2] 계좌삭제");
      System.out.println("[3] 메인메뉴로 돌아가기");

      int choice = scanner.nextInt();
      switch (choice) {
      case 1:
         createAccount(bdto);
         break;
      case 2:
         deleteAccount(bdto);
         break;
      case 3:
         System.out.println("...메인베뉴로 돌아갑니다...");
         MainUI.main(null);
         ;
         break;
      default:
         System.out.println("올바른 메뉴를 선택해주세요.");
         accountMenu(bdto);
      }
   }

   private void createAccount(bankDTO bdto) {
      System.out.println("계좌생성에 오신걸 환영합니다!");
      Scanner sc = new Scanner(System.in);
      // 1. 사용자한테 userId, userPw , bName, bNum, bal

      System.out.print("계좌생성) 계좌 비밀번호 입력 >> ");
      String userPw = sc.next();
      System.out.print("계좌생성) 은행이름 입력 >> ");
      String bName = sc.next();
      System.out.print("계좌생성) 원하는 계좌번호 입력 >> ");
      String bNum = sc.next();
      System.out.print("계좌생성) 잔액 입력 >> ");
      int bal = sc.nextInt();

      bankDTO dto = new bankDTO(bdto.getUserId(), userPw, bName, bNum, bal);
      bankDAO dao = new bankDAO();

      // 성공 여부 확인 위해 join의 리턴값에 저장
      int result = dao.createAccount(dto);

      if (result > 0) {
         System.out.println("계좌생성 성공!");
      } else {
         System.out.println("계좌생성 실패~");
      }

   }

   private void deleteAccount(bankDTO bdto) {
      System.out.println("계좌삭제 프로세스를 시작합니다~");
      Scanner sc = new Scanner(System.in);
      System.out.print("계좌삭제) 삭제하고 싶은 계좌번호 입력 >> ");
      String bNum = sc.next();
      System.out.print("계좌생성) 비밀번호>> ");
      String userPw = sc.next();
      bankDTO dto = new bankDTO(bdto.getUserId(), bNum, userPw);
      bankDAO dao = new bankDAO();

      int result = dao.deleteAccount(dto);
      if (result > 0) {
         System.out.println("계좌삭제 완료!");
      } else {
         System.out.println("계좌삭제 실패~");
      }

   }

   public static void display(bankDTO bdto) {
      bankDAO dao = new bankDAO();
      dao.display(bdto);
   }

   public static void deposit(bankDTO bdto) {
      bankDAO dao = new bankDAO();
      Scanner sc = new Scanner(System.in);
      // 계좌선택, 계좌 선택후 금액 업데이트, 업데이트 후 잔액조회
      System.out.print("입금할 은행 입력 >> ");
      String bname = sc.next();
      System.out.print("입금할 계좌번호 입력 >> ");
      String bnum = sc.next();
      System.out.print("계좌 비밀번호 입력 >> ");
      String accpw = sc.next();
      bankDTO searchDTO = new bankDTO(bdto.getUserId(), bnum, accpw);

      int search = dao.search(searchDTO);
      if (search == 1) {
         System.out.print("얼마를 입금하시겠습니까? >>  ");
         int money = sc.nextInt();
         bankDTO depositDTO = new bankDTO(bdto.getUserId(), accpw, bname, bnum, money);
         int result = dao.deposit(depositDTO);
         if (result > 0) {
            System.out.println("입금 완료!");
         } else {
            System.out.println("입금 실패~");
         }
      } else {
         System.out.print("계좌를 찾을 수 없습니다.");
      }

   }

   public static void withdraw(bankDTO bdto) {
      bankDAO dao = new bankDAO();
      Scanner sc = new Scanner(System.in);
      // 계좌선택, 계좌 선택후 금액 업데이트, 업데이트 후 잔액조회
      System.out.print("출금할 은행 입력 >> ");
      String bname = sc.next();
      System.out.print("출금할 계좌번호 입력 >> ");
      String bnum = sc.next();
      System.out.print("계좌 비밀번호 입력 >> ");
      String accpw = sc.next();
      bankDTO searchDTO = new bankDTO(bdto.getUserId(), bnum, accpw);

      int search = dao.search(searchDTO);
      if (search == 1) {
         System.out.print("얼마를 출금하시겠습니까? >>  ");
         int money = sc.nextInt();
         bankDTO withdrawDTO = new bankDTO(bdto.getUserId(), accpw, bname, bnum, money);
         int result = dao.withdraw(withdrawDTO);
         if (result > 0) {
            System.out.println("출금 완료!");
         } else {
            System.out.println("출금 실패~");
         }
      } else {
         System.out.print("계좌를 찾을 수 없습니다.");
      }

   }
   public static void transfer(bankDTO bdto) {
      bankDAO dao = new bankDAO();
      Scanner sc = new Scanner(System.in);
      // 계좌선택, 계좌 선택후 금액 업데이트, 업데이트 후 잔액조회
      System.out.print("출금할 은행 입력 >> ");
      String bname = sc.next();
      System.out.print("출금할 계좌번호 입력 >> ");
      String bnum = sc.next();
      System.out.print("계좌 비밀번호 입력 >> ");
      String accpw = sc.next();
      bankDTO myDTO = new bankDTO(bdto.getUserId(), bnum, accpw);

      int search = dao.search(myDTO);
      if (search == 1) {
         bankDAO.viewAccUser(myDTO);
         System.out.print("누구에게 송금하시겠습니까? >>  ");
         String target = sc.next();
         bankDAO.viewUserACC(target);
         System.out.print("어느 은행으로 송금하시겠습니까? >>  ");
         String targetBank = sc.next();
         System.out.print("어느 계좌로 송금하시겠습니까? >>  ");
         String targetAcc = sc.next();
         System.out.print("얼마를 송금하시겠습니까? >>  ");
         int money = sc.nextInt();
         
         bankDTO fromDTO = new bankDTO(myDTO.getUserId(), null, bname, myDTO.getBNum(), money);
         bankDTO toDTO = new bankDTO(target, null, targetBank, targetAcc, money);
         int rsfrom = dao.withdraw(fromDTO);
         int rsto = dao.deposit(toDTO);
         if (rsfrom > 0 && rsto > 0) {
            System.out.println("송금 완료!");
         } else {
            System.out.println("송금 실패~");
         }
      } else {
         System.out.println("계좌를 찾을 수 없습니다.");
      }

   }
}
