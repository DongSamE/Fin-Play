package Main_Project;

import java.util.Scanner;

import fin.FinService;
import game.InvestmentGame;

public class MainUI {
	
	String 계좌번호 ;
	int 잔액 ;
	String 예금주;
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            // Intro UI
        	System.out.println("======================================================");
            System.out.println("             핀테크와 게임을 한번에  FinPlay");
            System.out.println("======================================================");
            System.out.println("  [1] 계좌관리         [2] 모의투자게임           [3] 종료");

            int input = sc.nextInt();
            switch (input) {
                case 1:
                    FinService finService = new FinService();
                    finService.showFinMenu(); // Starts FinService features
                    break;
                case 2:
                    InvestmentGame gameService = new InvestmentGame();
                    gameService.startGame(); // Starts InvestmentGame features
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
