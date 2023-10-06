package edu.kh.member.model.dao;
import static edu.kh.member.common.JDBCTemplate.*;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.member.model.dto.Member;

// DAO (Database Access Object)
public class MemberDao {

	// JDBC 객체를 저장할 변수 선언
	private Statement stmt = null; // SQL 수행 후 결과 반환 받는 역할
	private PreparedStatement pstmt = null; // "?"로 SQL 쉽게 작성
	private ResultSet rs = null; // 조회 결과 집합(Result set) 저장 역할
	
	// Properties : key,value 모두 String으로 제한된 Map + 파일 입출력 쉬움
	private Properties prop = null;
	
	// 기본 생성자
	public MemberDao() {
		
		// DAO 객체 생성 시 xml(SQL) 파일의 내용을 읽어오기
		try {
		String path = MemberDao.class.getResource("/edu/kh/member/sql/member-sql.xml").getPath();
		
		prop = new Properties();
		prop.loadFromXML(new FileInputStream(path));
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/** 로그인
	 * @param conn
	 * @param id
	 * @param pw
	 * @return 회원정보 또는 null
	 */
	public Member login(Connection conn, String id, String pw) {
		
		// 1) 결과 저장용 변수 선언
		Member loginMember = null;
		
		try {
			// 2) SQL 얻어오기
			String sql = prop.getProperty("login");
			
			// 3) PreparedStatement 객체 생성
			pstmt = conn.prepareStatement(sql);
			
			// 4) ?에 알맞은 값을 세팅
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			// 5) spl 수행 후 결과 반환 받기
			rs = pstmt.executeQuery();
			
			// 6) 조회 결과를 Member 객체에 옮겨 담기
			if(rs.next()) { // 조회 결과가 1행인 경우 if, N행 while
				int memberNo = rs.getInt("MEMBER_NO");
				String memberId = rs.getString("MEMBER_ID");
				String memberName = rs.getString("MEMBER_NAME");
				String gender = rs.getString("GENDER");
				String enrollDate = rs.getString("ENROLL_DATE");
				
				loginMember = new Member(); // Member 객체 생성
				
				loginMember.setMemberNo(memberNo);
				loginMember.setMemberId(memberId);
				loginMember.setMemberName(memberName);
				loginMember.setGender(gender);
				loginMember.setEnrollDate(enrollDate);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			// 7) 사용한 JDBC 객체 자원 반환
			close(rs);
			close(pstmt);
		}
		
		
		return loginMember;
	}

	public List<Member> selectMemberList(Connection conn) {
		List<Member> memberList = new ArrayList<Member>();
		
		try {
			// sql 얻어오기
			String sql = prop.getProperty("selectMemberList");
			
			pstmt = conn.prepareStatement(sql);
			
			// SQL(SELECT) 수행(executeQuery()) 후 결과 반환 받기
			rs = pstmt.executeQuery();
			// 조회 결과를 List에 옮겨 담기
			while(rs.next()) {
				int memberNo = rs.getInt("MEMBER_NO");
				String memberId = rs.getString("MEMBER_ID");
				String memberPw = rs.getString("MEMBER_PW");
				String memberName = rs.getString("MEMBER_NAME");
				String gender = rs.getString("GENDER");
				String enrollDate = rs.getString("ENROLL_DATE");
				
				Member mem = new Member(); // Member 객체 생성
				
				mem.setMemberNo(memberNo);
				mem.setMemberId(memberId);
				mem.setMemberPw(memberPw);
				mem.setMemberName(memberName);
				mem.setGender(gender);
				mem.setEnrollDate(enrollDate);
				
				memberList.add(mem);
			} // while 종료
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return memberList;
	}

	/** 회원 가입
	 * @param conn
	 * @param member
	 * @return result
	 */
	public int signup(Connection conn, Member member) {
		int result = 0;
		
		try {
			String sql = prop.getProperty("signup");
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPw());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getGender());
			
			// SQL(INSERT) 수행(executeUpdate())후 결과 반환
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
