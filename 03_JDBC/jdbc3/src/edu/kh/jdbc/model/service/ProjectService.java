package edu.kh.jdbc.model.service;

import edu.kh.jdbc.model.dao.ProjectDao;
import edu.kh.jdbc.model.dto.Board;
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

	/** 게시글 상세 조회
	 * @param boardNo
	 * @return
	 */
	public Board selectBoard(int boardNo) {
		Connection conn = getConnection();
		
		// 1) DAO - 게시글 상세 조회 메서드 호출
		Board board = dao.selectBoard(conn, boardNo);
		
		// 2) 게시글 상세 조회 결과가 있을 경우 -> 조회수 증가(incrementReadCount(게시글 번호)) 수행
		if(board != null) {
			int result = dao.incrementReadCount(conn, boardNo);
			
			// 트랜젝션 제어
			if(result > 0) {
				commit(conn);
				// DB와 데이터 동기화
				// (DB에서만 조회수가 1증가하기 때문에
				// 조회해둔 board에도 조회수 1을 증가시킨다)
				board.setReadCount(board.getReadCount()+1);
			}
			else rollback(conn);
		}
		
		close(conn);
		
		return board;
	}

	public Board selectBoardList(String nick) {
		Connection conn = getConnection();
		Board board = dao.selectBoardList(conn, nick);
		
		close(conn);
		
		return board;
	}



	/** 일치하는지 확인 메서드
	 * @param boardNo
	 * @param memberNo
	 * @return
	 */
	public Board selectDeleteBoard(int boardNo, int memberNo) {
		Connection conn = getConnection();
		
		
		Board board = dao.selectDeleteBoard(conn, boardNo, memberNo);
		
		close(conn);
		return board;
	}

	public int deleteBoard(int boardNo) {
		Connection conn = getConnection();
		
		int result = dao.deleteBoard(conn, boardNo);
		
		if(result > 0) commit(conn);
		else			rollback(conn);
		
		close(conn);
		return result;
	}

	public int updateBoard(String boardTitle, String boardContent, int boardNo) {
		Connection conn = getConnection();
		
		int result = dao.updateBoard(conn , boardTitle, boardContent, boardNo);
		
		if(result >0) commit(conn);
		else		 rollback(conn);
		
		close(conn);
		return result;
	}

	

	



	
}
