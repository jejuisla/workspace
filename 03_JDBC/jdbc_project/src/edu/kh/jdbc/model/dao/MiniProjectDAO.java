package edu.kh.jdbc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import edu.kh.jdbc.model.dto.MiniProject;

public class MiniProjectDAO {

	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	public int insertMember(Connection conn, MiniProject member) {
		int result = 0;
		
		String sql = "INSERT INTO MAINMEMBER\n"
				+ "VALUES(SEQ_MAIN_MEMBER_NO,?,?,?,?,?,?,DEFAULT)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(1, member.getPhoneNumber());
			pstmt.setString(1, member.getMemberAddress());
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(1, member.getMemberId());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
