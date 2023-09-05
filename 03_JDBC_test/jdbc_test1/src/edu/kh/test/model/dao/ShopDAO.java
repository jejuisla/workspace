package edu.kh.test.model.dao;

import static edu.kh.test.common.JDBCTemplate.*;

import edu.kh.test.model.dto.ShopMember;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class ShopDAO {

	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	public ShopMember selectMember(Connection conn, String memberId) {
		ShopMember sm = null;
		
		
		
		try {
			String sql = "SELECT * FROM SHOP_MEMBER WHERE MEMBER_ID = ?";
			pstmt =conn.prepareStatement(sql);
			
			pstmt.setString(1, memberId); // pstmt를 사용시 ? 에 값을 세팅해줘야 하는데 세팅을 안해줬음
			// ? 는 MEMBER_ID에 해당하는 부분이라서 VARCHAR2타입을 사용하기 때문에 STRING 값으로 세팅해줘야함
			
			rs = pstmt.executeQuery(); // SQL을 수행하여 ResultSet으로 결과를 반환받아야 하는 구문이 없음
			// SELECT를 사용했기 때문에 executeUpdate가 아닌 executeQuery로 사용해야함
			if(rs.next()) {
				String id = rs.getString("MEMBER_ID");
				String pw = rs.getString("MEMBER_PW");
				String phone = rs.getString("PHONE");
				String gender = rs.getString("GENDER"); // 컬럼명 아니면 컬럼 순서를 적어야함
				// 설명으로 적어서 문제 발생
				
				sm = new ShopMember(id, pw, phone, gender);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(conn); // 데이터 유수를 막기위한 닫기구문을 작성해야하는데 작성안함
			// 커넥션만 생성했기 때문에 커넥션만 닫음
		}
		
		return sm;
	}
	

}



