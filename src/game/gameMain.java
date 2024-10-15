package game;

import java.util.Scanner;

public class gameMain {

	public void main(String[] args) {
		// 게임시작 인트로
		System.out.println("=====================모의투자게임======================");
		System.out.println("             [1] 게임 시작");
		System.out.println("             [2] 스코어보드 확인");
		System.out.println("             [3] 메인메뉴로 돌아가기");
		System.out.println("===================================================");
		InvestmentGame ig = new InvestmentGame();
		
		Scanner sc = new Scanner(System.in);
		int choice  = 0;
		boolean con = true ;
		//유저 선택
		
		while(con) {
			choice = sc.nextInt();
			if(choice == 1) {
				ig.newGame();
			}else if(choice == 2) {
				
			}else if(choice == 3) {
				System.out.println("...메인베뉴로 돌아갑니다...");
				con=false;
			}else {
				System.out.println("올바른 메뉴를 선택해주세요");
			}
			
			
		}
		
	}

}
