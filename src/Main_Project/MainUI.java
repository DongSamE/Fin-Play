package Main_Project;

import java.util.Scanner;

import a_Controller.bankDAO;
import a_Model.bankDTO;
import a_Model.mainDTO;
import bank.bankMain;
import game.InvestmentGame;
import game.gameMain;

public class MainUI {

	private String user_id;
	private String user_pw;
	static mainDTO login_info;
	//메인 UI
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			// Intro UI
			System.out.println("╔═════════════════════════════════════════════════╗");
			System.out.println("             핀테크와 게임을 한번에  FinPlay");
			System.out.println("╚═════════════════════════════════════════════════╝");
			System.out.println("  [1] 로그인          [2] 회원가입        [3] 종료");
			System.out.print(">>");
			int choice = sc.nextInt();

			if (choice == 1) {
				// 로그인
				mainUtil.login();
			} else if (choice == 2) {
				// 회원가입
				mainUtil.join();
			} else if (choice == 3) {
				System.out.println("앱을 종료합니다  ~");
				break;
			} else {
				System.out.println("[잘못된 입력 값입니다 다시 입력 해주세요 ~] ");
			}
		}

	}

}
