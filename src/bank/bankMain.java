package bank;

import java.util.Scanner;

public class bankMain {

	public void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("===== Fin=====");
			// 계좌관리 - 계좌 추가 & 삭제
			System.out.println("[1] 입금 [2] 출금 [3] 송금 [4] 계좌관리 [5] 종료");
			System.out.print("Choose your option: >> ");
			int choice = sc.nextInt();

			if (choice == 1) {
				System.out.println("[1] 은행 서비스로 이동합니다...");
			} else if (choice == 2) {
				System.out.println("[2] 모의투자 게임으로 이동합니다...");
			} else if (choice == 3) {
				System.out.println("[3] 뒤로 이동합니다...");
			} else if (choice == 4) {
				System.out.println("[4] 계좌관리...");
			} else if (choice == 5) {
				System.out.println("[5] 앱을 종료합니다...");
				break;
			} else {
				System.out.println("잘못된 값을 입력하셨습니다.. 다시 입력하세요...");
			}
		}
	}
}
