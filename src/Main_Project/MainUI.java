package Main_Project;

import java.util.Scanner;

import a_Controller.bankDAO;
import a_Model.bankDTO;
import bank.bankMain;
import game.InvestmentGame;
import game.gameMain;

public class MainUI {

	String user_id;
	String user_pw;
	String name;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
				// Intro UI
				System.out.println("======================================================");
				System.out.println("             핀테크와 게임을 한번에  FinPlay");
				System.out.println("======================================================");
				System.out.println("[1] 로그인 [2] 회원가입 [3] 마이페이지 [4] 종료");
				System.out.print("Choose your option: >>");
				int choice = sc.nextInt();

				if (choice == 1) {
					//로그인
					mainUtil.login();
				} else if (choice == 2) {
					//회원가입
					mainUtil.join();
				} else if (choice == 3) {
					//정보수정
					mainUtil.mypage();
				} else if (choice == 4) {
					System.out.println("앱을 종료합니다  ~");
					break;
				} else {
					System.out.println("[잘못된 입력 값입니다 다시 입력 해주세요 ~] ");
				}
		}
		

	}

}
