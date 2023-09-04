package edu.kh.jdbc.model.service;

import edu.kh.jdbc.model.dao.ProjectDao;
import edu.kh.jdbc.model.dto.Member;

// static 필드/메서드 호출 시 클래스명(JDBCTemplate) 생략
import static edu.kh.jdbc.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

public class ProjectService {

	private ProjectDao dao = new ProjectDao();
	
	/** 회원 가입
	 * @param member
	 * @return
	 */
	public int insertMember(Member member) {
		
		// 커넥션 생성
		Connection conn = getConnection();
		
		// DAO 메서드 호출(커넥션 전달,매개변수 전달)
		int result = dao.insertMember(conn, member);
		
		// 트랜젝션 제어
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		// 커넥션 반환
		close(conn);
		
		return result;
	}

	/** 로그인
	 * @param email
	 * @param pw
	 * @return
	 */
	public Member login(String email, String pw) {
		
		// 커넥션 생성
		Connection conn = getConnection();
		
		// DAO 메서드 호출
//		Member member = dao.login(conn, email, pw); // PreparedStatement

		Member member = dao.login2(conn, email, pw); // Statement
		
		// SELECT는 트랜잭션 제어 처리가 필요 없다 -> 건너 뜀
		
		// 커넥션 반환
		close(conn);
		
		// view로 결과 반환
		return member;
	}

	
	/** MEMBER 테이블 전체 조회
	 * @param sort
	 * @return
	 */
	public List<Member> selectAllMember(int sort){
		Connection conn = getConnection();
		
		List<Member> memberList = dao.selectAllMember(conn, sort);
		
		close(conn);
		
		return memberList;
	}

	/** 회원 정보 수정
	 * @param nickname
	 * @param tel
	 * @param memberNo
	 * @return
	 */
	public int updateMember(String nickname, String tel, int memberNo) {
		Connection conn = getConnection();
		
		int result = dao.updateMember(conn, nickname, tel, memberNo);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		return result;
	}

	
	/** 회원 탈퇴
	 * @param memberNo
	 * @param pw
	 * @return
	 */
	public int updateDelFl(int memberNo, String pw) {
		Connection conn = getConnection();
		
		int result = dao.updateDelFl(conn, memberNo, pw);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		return result;
	}

	
	
	public int insertBoard(String title, String content, int memberNo) {
		Connection conn = getConnection();
		
		int result = dao.insertBoard(conn, title, content, memberNo);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		
		return result;
	}



	
}
