package a_Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

import a_Model.bankDTO;
import a_Model.mainDTO;

public class bankDAO {
	public void display(bankDTO dto) {
		try {
			// 1. DB 드라이버 꺼내기 // 2. DB랑 자바연결 // 3. 쿼리문 작성
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1523:xe";
			String user = "seocho_dcx_bigdata14_p1_3";
			String password = "smhrd3";
			Connection conn = DriverManager.getConnection(url, user, password);

			// 여기부터는 내가 짜야함
			String sql = "SELECT * FROM BANKACC WHERE USER_ID = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUserId());

			ResultSet result = psmt.executeQuery();

			while (result.next()) {

				String user_id = result.getString("USER_ID");
				String bname = result.getString("BNAME");
				String bnum = result.getString("BNUM");
				int bal = result.getInt("BAL");
				System.out.println(user_id + "\t\t|" + bname + "\t\t|" + bnum + "\t\t|" + bal);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int createAccount(bankDTO dto) {
		int result = 0;
		try {
			// 1. DB 드라이버 꺼내기 // 2. DB랑 자바연결 // 3. 쿼리문 작성
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1523:xe";
			String user = "seocho_dcx_bigdata14_p1_3";
			String password = "smhrd3";
			Connection conn = DriverManager.getConnection(url, user, password);

			// 여기부터는 내가 짜야함
			String sql = "INSERT INTO BANKACC (USER_ID, USER_PW, BNAME, BNUM, BAL) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUserId());
			psmt.setString(2, dto.getUserPw());
			psmt.setString(3, dto.getBName());
			psmt.setString(4, dto.getBNum());
			psmt.setInt(5, dto.getBal());

			result = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	public int deleteAccount(bankDTO dto) {
		int result = 0;
		try {
			// 1. DB 드라이버 꺼내기 // 2. DB랑 자바연결 // 3. 쿼리문 작성
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1523:xe";
			String user = "seocho_dcx_bigdata14_p1_3";
			String password = "smhrd3";
			Connection conn = DriverManager.getConnection(url, user, password);

			// 여기부터는 내가 짜야함
			String sql = "DELETE FROM BANKACC WHERE USER_ID = ? AND BNUM = ? AND USER_PW = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getUserId());
			psmt.setString(2, dto.getBNum());
			psmt.setString(3, dto.getUserPw());

			result = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	public int deposit(bankDTO dto) {
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1523:xe";
			String user = "seocho_dcx_bigdata14_p1_3";
			String password = "smhrd3";

			Connection conn = DriverManager.getConnection(url, user, password);

			String sql = "UPDATE BANKACC SET BAL = BAL + ? WHERE BNAME = ? AND BNUM = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);

			psmt.setInt(1, dto.getBal());
			psmt.setString(2, dto.getBName());
			psmt.setString(3, dto.getBNum());

			result = psmt.executeUpdate();

		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int withdraw(bankDTO dto) {
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1523:xe";
			String user = "seocho_dcx_bigdata14_p1_3";
			String password = "smhrd3";

			Connection conn = DriverManager.getConnection(url, user, password);

			String sql = "UPDATE BANKACC SET BAL = BAL - ? WHERE BNAME = ? AND BNUM = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);

			psmt.setInt(1, dto.getBal());
			psmt.setString(2, dto.getBName());
			psmt.setString(3, dto.getBNum());

			result = psmt.executeUpdate();

		} catch (

		Exception e) {
			result = -1;
		}
		return result;
	}

	public int search(bankDTO myDTO) {

		ResultSet result = null;
		int returnValue = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1523:xe";
			String user = "seocho_dcx_bigdata14_p1_3";
			String password = "smhrd3";

			Connection conn = DriverManager.getConnection(url, user, password);

			String sql = "SELECT * FROM BANKACC WHERE USER_ID = ? AND BNUM = ? AND USER_PW = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);

			psmt.setString(1, myDTO.getUserId());
			psmt.setString(2, myDTO.getBNum());
			psmt.setString(3, myDTO.getUserPw());

			result = psmt.executeQuery();

			if (result != null && result.next()) {
				returnValue = 1; // Data found
			} else {
				returnValue = 0; // No data found
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}

		return returnValue;
	}

	public static void viewAccUser(bankDTO dto) {
		try {
			// 1. DB 드라이버 꺼내기 // 2. DB랑 자바연결 // 3. 쿼리문 작성
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1523:xe";
			String user = "seocho_dcx_bigdata14_p1_3";
			String password = "smhrd3";
			Connection conn = DriverManager.getConnection(url, user, password);

			// 여기부터는 내가 짜야함
			String sql = "SELECT DISTINCT USER_ID FROM BANKACC";
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet result = psmt.executeQuery();
			System.out.println("───────────────────────────────────────────────────────────");
			System.out.println("가입자 명단");
			int count = 1;
			while (result.next()) {

				String user_id = result.getString("USER_ID");
				System.out.println(count + ". " + user_id);
				count++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void viewUserACC(String target) {
		try {
			// 1. DB 드라이버 꺼내기 // 2. DB랑 자바연결 // 3. 쿼리문 작성
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1523:xe";
			String user = "seocho_dcx_bigdata14_p1_3";
			String password = "smhrd3";
			Connection conn = DriverManager.getConnection(url, user, password);

			String sql = "SELECT BNAME, BNUM FROM BANKACC WHERE USER_ID = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, target);

			ResultSet result = psmt.executeQuery();
			System.out.println("    은행명" + "\t" + "계좌번호");
			int count = 1;
			while (result.next()) {

				String bname = result.getString("BNAME");
				String bnum = result.getString("BNUM");
				System.out.println(count + ". " + bname + "\t" + bnum);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
