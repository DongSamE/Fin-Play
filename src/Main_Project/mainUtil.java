package Main_Project;

import java.util.Scanner;

import a_Controller.mainDAO;
import a_Model.mainDTO;
import bank.bankMain;
import game.gameMain;

public class mainUtil {

	public static void menu() {
		Scanner sc = new Scanner(System.in);
		boolean running = true;
		int input;
		while (running) {
			System.out.println("  [1] 계좌관리         [2] 모의투자게임           [3] 종료");
			input = sc.nextInt();
			sc.nextLine();
			if (input == 1) {
				bankMain bm = new bankMain();
				bm.main(null);
			} else if (input == 2) {
				gameMain gm = new gameMain();
				gm.main(null);
			} else if (input == 3) {
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
		System.out.println("[1] 로그인");
		// - 사용자에게 아이디, 패스워드만 받기
		System.out.print("로그인) ID를 입력하세요 >>");
		String id = sc.next();
		System.out.print("로그인) PW를 입력하세요 >>");
		String pw = sc.next();
		// dao, dto 객체 생성
		mainDTO dto = new mainDTO(id, pw);
		mainDAO dao = new mainDAO();

		int result = dao.login(dto);

		if (result > 0) {
			System.out.println("로그인 성공!");
			menu();
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

	public static void mypage() {
		System.out.println("======================================================");
		System.out.println("[1] 비밀번호변경 [2] 회원탈퇴");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		if (input == 1) {
			edit();
		} else if (input == 2) {
			delete();
		}
	}

	public static void edit() {
		// 1. 비밀번호 변경
		// - name, id, pw 를 입력받아서 변수 저장
		Scanner sc = new Scanner(System.in);
		System.out.println("[1] 비밀번호 변경");

		System.out.print("id 입력 >> ");
		String id = sc.next();
		System.out.print("pw 입력 >> ");
		String pw = sc.next();

		// 회원가입에 필요한 정보를 받았으니
		// DTO에 정보를 채우기
		mainDTO dto = new mainDTO(id, pw);

		// DAO 기능 사용하기 위해 객체 생성
		mainDAO dao = new mainDAO();

		// 성공 여부 확인 위해 join의 리턴값에 저장
		int result = dao.edit(dto);

		if (result > 0) {
			System.out.println("회워가입 성공!");
		} else {
			System.out.println("회원가입 실패~");
		}

	}

	public static void delete() {
		// 2. 회원탈퇴
		// - id, pw 를 입력받아서 변수 저장
		Scanner sc = new Scanner(System.in);
		System.out.println("[2] 회원탈퇴");

		System.out.print("id 입력 >> ");
		String id = sc.next();
		System.out.print("pw 입력 >> ");
		String pw = sc.next();

		// 회원가입에 필요한 정보를 받았으니
		// DTO에 정보를 채우기
		mainDTO dto = new mainDTO(id, pw);

		// DAO 기능 사용하기 위해 객체 생성
		mainDAO dao = new mainDAO();

		// 성공 여부 확인 위해 join의 리턴값에 저장
		int result = dao.delete(dto);

		if (result > 0) {
			System.out.println("회워가입 성공!");
		} else {
			System.out.println("회원가입 실패~");
		}

	}
}
