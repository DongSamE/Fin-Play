package bank;

import java.util.Scanner;

import Main_Project.MainUI;

public class FinService {
	public void showFinMenu() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("==========핀테크 서비스=========");
		System.out.println("[1] 송금");
		System.out.println("[2] 계좌 정보 확인");
		System.out.println("[3] 메인메뉴로 돌아가기");

		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			transferMoney();
			break;
		case 2:
			accountInquiry();
			break;
		case 3:
			System.out.println("...메인베뉴로 돌아갑니다...");
			MainUI.main(null);
			;
			break;
		default:
			System.out.println("올바른 메뉴를 선택해주세요.");
			showFinMenu();
		}
	}

	private void transferMoney() {
		System.out.println("송금");
		// Transfer logic here
	}

	private void accountInquiry() {
		System.out.println("계좌정보 확인");
		// Account inquiry logic here
	}
}