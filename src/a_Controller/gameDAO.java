package a_Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import a_Model.gameDTO;

public class gameDAO {
	
	public int enroll(gameDTO gdto, int tmoney) {
		int result = 0;
		try {
			// 1. DB 드라이버 꺼내기 // 2. DB랑 자바연결 // 3. 쿼리문 작성
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "";
			String user = "";
			String password = "";
			Connection conn = DriverManager.getConnection(url, user, password);

			String sql = "INSERT INTO TOP3 (USER_ID, SCORE) VALUES (?,?)";

			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, gdto.getId());
			psmt.setInt(2, tmoney);
			result = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;

	}

	public void checktop3() {
		try {
			// 1. DB 드라이버 꺼내기 // 2. DB랑 자바연결 // 3. 쿼리문 작성
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "";
			String user = "";
			String password = "";
			Connection conn = DriverManager.getConnection(url, user, password);

			String sql = "SELECT ROWNUM, USER_ID, SCORE, DT FROM (" + "SELECT USER_ID, SCORE, DT " + "FROM TOP3 "
					+ "ORDER BY SCORE DESC" + ") WHERE ROWNUM <= 3";

			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					int rn = rs.getInt("ROWNUM");
					String id = rs.getString("USER_ID");
					int score = rs.getInt("SCORE");
					String dt = rs.getString("DT");
					System.out.println(rn + "\t" + id + "\t" + score + "\t" + dt);
				}
			} else {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
