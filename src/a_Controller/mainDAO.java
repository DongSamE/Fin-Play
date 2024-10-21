package a_Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import a_Model.mainDTO;

public class mainDAO {

	public int join(mainDTO dto) {
		int result = 0;
		try {
			// 1. DB 드라이버 꺼내기 // 2. DB랑 자바연결 // 3. 쿼리문 작성
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1523:xe";
			String user = "seocho_dcx_bigdata14_p1_3";
			String password = "smhrd3";
			Connection conn = DriverManager.getConnection(url, user, password);

			String sql = "INSERT INTO BANKUSER VALUES(?,?,?)";

			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getName());
			psmt.setString(2, dto.getId());
			psmt.setString(3, dto.getPw());

			result = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	public int login(mainDTO dto) {
		int result = 0;
		try {
			// 1. DB 드라이버 꺼내기 // 2. DB랑 자바연결 // 3. 쿼리문 작성
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1523:xe";
			String user = "seocho_dcx_bigdata14_p1_3";
			String password = "smhrd3";
			Connection conn = DriverManager.getConnection(url, user, password);
			// 여기부터는 내가 짜야함
			String sql = "SELECT * FROM BANKUSER WHERE USER_ID=? AND USER_PW=? ";
			PreparedStatement psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());

			ResultSet rs = psmt.executeQuery();

			if (rs.next()) {
				result = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	public int edit(mainDTO dto) {
		int result = 0;
		try {
			// 1. DB 드라이버 꺼내기 // 2. DB랑 자바연결 // 3. 쿼리문 작성
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1523:xe";
			String user = "seocho_dcx_bigdata14_p1_3";
			String password = "smhrd3";
			Connection conn = DriverManager.getConnection(url, user, password);
			// 여기부터는 내가 짜야함
			String sql = "UPDATE BANKUSER SET USER_PW = ? WHERE USER_ID = ?";
			PreparedStatement psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getPw());
			psmt.setString(2, dto.getId());

			ResultSet rs = psmt.executeQuery();

			if (rs.next()) {
				result = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	public int delete(mainDTO dto) {
		int result = 0;
		try {
			// 1. DB 드라이버 꺼내기 // 2. DB랑 자바연결 // 3. 쿼리문 작성
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-campus.smhrd.com:1523:xe";
			String user = "seocho_dcx_bigdata14_p1_3";
			String password = "smhrd3";
			Connection conn = DriverManager.getConnection(url, user, password);
			// 여기부터는 내가 짜야함
			String sql = "DELETE FROM BANKUSER WHERE USER_ID = ? AND USER_PW = ? ";
			PreparedStatement psmt = conn.prepareStatement(sql);

			psmt.setString(1, dto.getId());
			psmt.setString(2, dto.getPw());

			ResultSet rs = psmt.executeQuery();

			if (rs.next()) {
				result = 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

}
