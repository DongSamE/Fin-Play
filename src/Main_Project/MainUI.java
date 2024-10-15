package Main_Project;

import java.util.Scanner;

import bank.FinService;
import game.InvestmentGame;
import game.gameMain;

public class MainUI {

	String user_id;
	String user_pw;
	String name;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean running = true;

		while (running) {
			// Intro UI
			System.out.println("======================================================");
			System.out.println("             핀테크와 게임을 한번에  FinPlay");
			System.out.println("======================================================");
			
			
			
			
			//로그인 회원가입 종료
			
			
			
			
			
			System.out.println("  [1] 계좌관리         [2] 모의투자게임           [3] 종료");

			int input = sc.nextInt();
			switch (input) {
			case 1:
				FinService fm = new FinService();
				
				break;
			case 2:
				gameMain gm = new gameMain();
				gm.main(null);
				break;
			case 3:
				running = false; // Ends the loop
				System.out.println("             프로그램을 종료합니다.");
				break;
			default:
				System.out.println("             올바른 옵션을 선택해주세요.");
			}
		}
		sc.close();
	}

}
