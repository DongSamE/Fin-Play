package game;

import java.util.Scanner;

import Main_Project.mainUtil;
import a_Model.mainDTO;

public class gameMain {

	public void main(mainDTO login_info) {
		// 게임시작 인트로
		System.out.println("=====================모의투자게임======================");
		System.out.println("             [1] 게임 시작");
		System.out.println("             [2] 스코어보드 확인");
		System.out.println("             [3] 메인메뉴로 돌아가기");
		System.out.println("===================================================");
		InvestmentGame ig = new InvestmentGame();
		
		Scanner sc = new Scanner(System.in);
		int choice  = 0;
		//유저 선택
		
		while(true) {
			choice = sc.nextInt();
			if(choice == 1) {
				ig.newGame(login_info);
			}else if(choice == 2) {
				//스코어보드 짜기
				ig.checktop3(login_info);
			}else if(choice == 3) {
				System.out.println("...메인베뉴로 돌아갑니다...");
				mainUtil.menu(login_info);
			}else {
				System.out.println("올바른 메뉴를 선택해주세요");
			}
			
			
		}
		
	}

}
