package Main_Project;

import java.util.Scanner;

import a_Controller.mainDAO;
import a_Model.mainDTO;
import bank.bankMain;
import game.gameMain;

public class mainUtil {

	public static void menu(mainDTO login_info) {
		Scanner sc = new Scanner(System.in);
		boolean running = true;
		int input;
		while (running) {
			System.out.println("───────────────────────────────────────────────────────────");
			System.out.println("  [1] 뱅킹서비스     [2] 모의투자게임    [3]마이페이지    [4] 종료");
			input = sc.nextInt();
			sc.nextLine();
			if (input == 1) {
				bankMain bm = new bankMain();
				bm.main(login_info);
			} else if (input == 2) {
				gameMain gm = new gameMain();
				gm.main(login_info);
			} else if (input == 3) {
				mypage(login_info);
			} else if (input == 4) {
				running = false; // Ends the loop
				System.out.println("             프로그램을 종료합니다.");
			} else {
				System.out.println("             올바른 옵션을 선택해주세요.");
			}
		}
	}

	public static void login() {
		// 1. 로그인
		Scanner sc = new Scanner(System.in);
		System.out.println("───────────────────────────────────────────────────────────");
		System.out.println("[1] 로그인");
		// - 사용자에게 아이디, 패스워드만 받기
		System.out.print("ID를 입력하세요 >>");
		String id = sc.next();
		System.out.print("PW를 입력하세요 >>");
		String pw = sc.next();
		// dao, dto 객체 생성
		mainDTO dto = new mainDTO(id, pw);
		mainDAO dao = new mainDAO();

		int result = dao.login(dto);

		if (result > 0) {
			menu(dto);
		} else {
			System.out.println("로그인 실패~");
		}

	}

	public static void join() {
		// 2. 회원가입
		// - name, id, pw 를 입력받아서 변수 저장
		Scanner sc = new Scanner(System.in);
		System.out.println("[2] 회원가입");

		System.out.print("이름 입력 >> ");
		String name = sc.next();
		System.out.print("id 입력 >> ");
		String id = sc.next();
		System.out.print("pw 입력 >> ");
		String pw = sc.next();

		// 회원가입에 필요한 정보를 받았으니
		// DTO에 정보를 채우기
		mainDTO dto = new mainDTO(name, id, pw);

		// DAO 기능 사용하기 위해 객체 생성
		mainDAO dao = new mainDAO();

		// 성공 여부 확인 위해 join의 리턴값에 저장
		int result = dao.join(dto);

		if (result > 0) {
			System.out.println("회워가입 성공!");
		} else {
			System.out.println("회원가입 실패~");
		}

	}

	public static void mypage(mainDTO login_info) {
		System.out.println("───────────────────────────────────────────────────────────");
		System.out.println("[1] 비밀번호변경 [2] 회원탈퇴");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		if (input == 1) {
			edit(login_info);
		} else if (input == 2) {
			delete(login_info);
		}
	}

	public static void edit(mainDTO login_info) {
		// 1. 비밀번호 변경
		// - name, id, pw 를 입력받아서 변수 저장
		Scanner sc = new Scanner(System.in);
		System.out.println("[1] 비밀번호 변경");

		System.out.print("새 비밀번호 입력 >> ");
		String pw = sc.next();
		System.out.print("비밀번호 확인 >> ");
		String pw_check = sc.next();

		// DAO 기능 사용하기 위해 객체 생성
		mainDAO dao = new mainDAO();
		String id = login_info.getId();
		// 성공 여부 확인 위해 join의 리턴값에 저장

		if (pw.equals(pw_check)) {
			mainDTO dto = new mainDTO(id, pw);
			int result = dao.edit(dto);
			if (result > 0) {
				System.out.println("비밀번호가 변경되었습니다");
			} else {
				System.out.println("비밀번호 변경에 실패했습니다");
			}
		} else {
			System.out.println("비밀번호가 다릅니다.");
		}

	}

	public static void delete(mainDTO login_info) {
		// 2. 회원탈퇴
		int result;
		// - id, pw 를 입력받아서 변수 저장
		Scanner sc = new Scanner(System.in);
		System.out.println("[2] 회원탈퇴");

		System.out.print("탈퇴하시겠습니까? [ Y / N ] ");
		String choice = sc.next();

		// 회원가입에 필요한 정보를 받았으니
		// DTO에 정보를 채우기

		// DAO 기능 사용하기 위해 객체 생성
		mainDAO dao = new mainDAO();
		if (choice.equals(choice)) {
			result = dao.delete(login_info);
		} else {
			result = 0;
		}

		if (result > 0) {
			System.out.println("탈퇴성공 다음에 또 만나요");
			MainUI.main(null);
		} else {
			System.out.println("탈퇴처리에 실패했습니다");
		}

	}
}
