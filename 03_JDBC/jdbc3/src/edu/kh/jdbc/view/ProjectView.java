package edu.kh.jdbc.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import edu.kh.jdbc.model.dto.Board;
import edu.kh.jdbc.model.dto.Member;
import edu.kh.jdbc.model.service.ProjectService;

public class ProjectView {
	private Scanner sc = new Scanner(System.in);
	private ProjectService service = new ProjectService();
	
	// 로그인한 회원의 정보가 담긴 Member객체를 참조할 변수 선언
	private Member loginMember = null;
	
	
	public void displayMenu() {
	int input = -1;
	
		do {
			try {
				if(loginMember != null) { // 로그인 상태인 경우
					System.out.println("----------------------------------");
					System.out.printf("(%s) \n", loginMember.getMemberEmail());
					System.out.println("----------------------------------");
				}
				System.out.println("\\n**** MEMBER/BOARD 테이블 사용 JDBC ****\\n");
				System.out.println("1. 회원 가입");
				System.out.println("2. 로그인");
				System.out.println("3. 회원 정보 수정"); // 닉네임, 전화번호
				System.out.println("4. 회원 탈퇴"); // MEMBER_DEL_FL = 'Y'
				System.out.println("5. MEMBER 테이블 전체 조회");
				System.out.println("6. 게시글 작성하기"); //BOARD 테이블에 INSERT하기
				
	            // ------------------ 게시글 목록 조회(selectBoardList) ------------------
	            // 게시글 번호, 제목, 작성일, 조회수, 작성자번호, 작성자 닉네임
	            // 게시글 번호 내림차순으로 조회
	            // 단, 삭제되지 않은 글만 조회(BOARD_DEL_FL = 'N')
	            System.out.println("7. 게시글 목록 조회"); // selectBoardList()
				
			    // ------------------ 게시글 상세 조회(selectBoard) ------------------
			    // 게시글 번호를 입력 받아 일치하는 게시글의
			    // 제목, 내용, 작성일, 조회수, 작성자번호, 작성자 닉네임 조회
			    // 단, 삭제되지 않은 게시글만 조회 가능(BOARD_DEL_FL = 'N')
			    
			    // view 메서드 1개 - service 메서드 1개 -  dao 메서드 2개
			    // service에서 dao의 메서드를 연달아 호출
			    // 1) 게시글 상세조회(selectBoard(게시글번호)) 를 먼저 수행
			    // 2) 게시글 상세 조회 결과가 있을 경우 -> 조회수 증가(incrementReadCount(게시글 번호)) 수행
				System.out.println("8. 게시글 상세조회");
				
	            // ------------------ 게시글 삭제(deleteBoard) ------------------
	            // 1) 로그인 여부 확인
	            
	            // 2) 로그인 상태인 경우 게시글 번호를 입력 받아
	            // 해당 게시글 작성 회원 번호(BOARD.MEMBER_NO)와 
	            // 로그인한 회원의 회원 번호(MEMBER.MEMBER_NO)가 일치하는지 확인하는 service 메서드 호출
	            
	            // 3) 일치할 경우
	            // 정말 삭제하시겠습니까?(Y/N)을 출력 
	            // -> Y 입력 시 BOARD_DEL_FL 컬럼 값을 'Y'로 수정하는 service 메서드 호출
	            System.out.println("9. 게시글 삭제");
	            
	            // ------------------ 게시글 수정(updateBoard)  ------------------
	            // 1) 로그인 여부 확인
	            
	            // 2) 로그인 상태인 경우 게시글 번호를 입력 받아
	            // 해당 게시글 작성 회원 번호(BOARD.MEMBER_NO)와 
	            // 로그인한 회원의 회원 번호(MEMBER.MEMBER_NO)가 일치하는지 확인하는 service 메서드 호출
	            
	            // 3) 일치할 경우
	            // 수정할 제목, 내용을 입력 받아 해당 게시글의 제목, 내용을 수정
	            System.out.println("10. 게시글 수정");
				System.out.println("0. 종료");
	
				System.out.print("메뉴 선택 : ");
				input = sc.nextInt();
				sc.nextLine();
				
				switch(input) {
				case 1: insertMember(); break;
				case 2: login(); break;
				case 3: updateMember(); break;
				case 4: updateDelfl(); break;
				case 5: selectAllMember(); break;
				case 6: insertBoard(); break;
				case 7: selectBoardList(); break;
				case 8: selectBoard(); break;
				case 9: deleteBoard(); break;
				case 10: updateBoard(); break;
				case 0: System.out.println("\n 프로그램 종료 \n");
				default: System.out.println("\n 메뉴 번호만 입력해주세요 \n");
				}
			} catch(InputMismatchException e) {
				System.out.println("\n잘못된 입력");
				sc.nextLine();
			}
			
		}while(input != 0);	
	}

	   /**
	    * 회원 가입 화면
	    */
	   private void insertMember() {
	      System.out.println("\n***** 회원 가입 *****\n");
	      
	      System.out.print("이메일 : ");
	      String email = sc.next();
	      
	      System.out.print("비밀번호 : ");
	      String pw = sc.next();
	      
	      System.out.print("닉네임 : ");
	      String nickname = sc.next();
	      
	      System.out.print("휴대폰 번호(- 제외) : ");
	      String tel = sc.next();
	      sc.nextLine(); // 입력 버퍼 개행문자 제거
	      
	      System.out.print("주소 : ");
	      String address = sc.nextLine();
	   
	      // 입력 받은 값을 Member 객체에 저장하기
	      Member member = new Member(email, pw, nickname, tel, address);
	      
	      // 서비스로 member를 전달한 후 수행 결과 반환 받기
	      // -> DML(INSERT,UPDATE,DELETE) 결과는 성공한 행의 수(int)로 반환
	      
	      int result = service.insertMember(member); // 1 또는 0
	      
	      if(result > 0) {
	         System.out.println("회원 가입 성공!!!");
	      }else {
	         System.out.println("회원 가입 실패......");
	      }
	   }
	
	
	   private void login() {
		   System.out.println("\n ---- 로그인 ---- \n");
		   
		   System.out.print("이메일 : ");
		   String email = sc.next();
		   
		   System.out.print("비밀번호 : ");
		   String pw = sc.next();
		   
		   // 로그인 서비스 호출 후 결과(Member 타입) 반환 받기
		   Member member = service.login(email, pw);
		   
		   // 로그인 결과에 따라 출력하기
		   if(member != null) {
			   System.out.println("로그인 성공");
			   System.out.println(member);
			   
			   loginMember = member;
		   }
		   else	{
			   System.out.println("로그인 실패");
		   }
	   }
	   
	   

	   
	   /**
	 * MEMBER 테이블 전체 조회
	 */
	private void selectAllMember() {
		   System.out.println("\n 멤버 테이블 전체 조회 \n");
		   
		   System.out.print("내림 차순(1), 오름 차순(아무숫자): ");
		   int sort = sc.nextInt();
		   
		   
		   List<Member> memberList = service.selectAllMember(sort);
		   
		   // 조회 결과가 없을 때( 리스트가 비어있을 경우, null 아님)
//		   if(memberList.isEmpty() ) {
		   if(memberList.size() == 0 ) {
			   System.out.println("\n 조회 결과가 없습니다 \n");
		   } else {
			   // 향상된 for문 리스트에 모든 값 출력
			   for( Member mem : memberList ) {
				   System.out.println(mem);
			   }
		   }	   
	   }
	
	
	/**
	 * 로그인된 회원의 닉네임, 전화번호 수정
	 */
	private void updateMember() {
		// 로그인 여부 확인
		if(loginMember == null) {
			System.out.println("\n **** 로그인 후 이용해주세요 **** \n");
			return;
		}
		// 로그인된 경우
		System.out.print("수정할 닉네임: ");
		String nickname = sc.next();
		
		System.out.print("수정할 전화번호(-제외): ");
		String tel = sc.next();
		
		// 회원 정보 수정 서비스 호출 후 결과 반환 받기
		// 수정할 닉네임, 전화번호, 회원번호(PK, 조건절에 사용, 식)
		int result = service.updateMember(nickname, tel, loginMember.getMemberNo());
		
		if(result > 0) System.out.println("수정 성공");
		else System.out.println("수정 실패");
	}
	
	
	
	
	/**
	 * 회원 탈퇴
	 */
	private void updateDelfl() {
		System.out.println("\n 회원 탈퇴 \n");
		
		// 로그인 여부 확인
		if(loginMember == null) {
			System.out.println("로그인 후 이용해주세요");
			return;
		}
			// 로그인 상태인 경우
			// 1) 비밀번호 입력 받기
			System.out.println("비밀번호 입력: ");
			String pw = sc.next();
			// 2) 서비스 메서드 호출 후 결과 반환받기
			// - 매개변수 : 회원번호, 입력 받은 비밀번호
			// - 반환값 : SQL 수행 후 결과 행의 개수	
			int result = service.updateDelFl(loginMember.getMemberNo(), pw);
		
			// 3) 성공일 경우 : "탈퇴 되었습니다", loginMember = null;
			//	  실패일 경우 : "비밀번호가 일치하지 않습니다"
			if(result > 0) {
				System.out.println("탈퇴 되었습니다.");
				loginMember = null; // 로그아웃
			}else {
				System.out.println("비밀번호가 일치하지 않습니다.");
			}
	}
	
	
	/**
	 * 게시글 작성하기
	 */
	private void insertBoard() {
		System.out.println("\n 게시글 작성 \n");
		
		// 로그인 여부 확인
		if(loginMember == null) {
			System.out.println("로그인 후 이용해주세요");
			return;
		}
		
		System.out.print("제목 입력: ");
		String title = sc.nextLine();
		
		System.out.println("내용 입력(입력 종료 : !wq) : ");
		String content = ""; // 빈문자열
		while(true) { // 결과가 무조건 한 줄이면 if 사용 권장
			String temp = sc.nextLine(); 
			
			if(temp.equals("!wq")) {// 입력 종료 커맨드인 경우
				break;
			}
			content += temp + "\n";
		}
		// BOARD 테이블에 삽입하는 서비스 호출 후 결과 반환받기
		int result = service.insertBoard(title, content, loginMember.getMemberNo());
							// 제목,  내용,		작성자 회원 번호
		
		
		if(result > 0) System.out.println("\n 게시글이 등록 되었습니다. \n");
		else 		System.out.println("\n 게시글 등록 실패 \n");
	}
	
	
	/**
	 * 게시글 목록 조회
	 */
	private void selectBoardList() {
		System.out.println(" 게시글 목록 조회 ");
		
		System.out.print("작성자 닉네임 : ");
		String nick = sc.next();
		
		Board board = service.selectBoardList(nick);
		
		if (board == null) {
			System.out.println("게시글이 존재하지 않습니다");
			return;
		}
		System.out.println(board);
	}
	

	/**
	 *  게시글 상세 조회
	 */
	private void selectBoard() {
		System.out.println("\n****게시글 상세 조회****\n");
	
		System.out.print("게시글 번호 입력: ");
		int boardNo = sc.nextInt();
		
		// 서비스 메서드 호출 후 결과 반환 받기
		Board board = service.selectBoard(boardNo);
		
		// 조회 결과가 존재하지 않을 경우
		if(board == null) {
			System.out.println("\n 게시글이 존재하지 않습니다. \n");
			return;
		}
		// 조회결과가 있을 경우
		System.out.printf("[%d] %s\n",board.getBoardNo(),board.getBoardTitle());
		System.out.println("작성일 : "+ board.getBoardCreateDate());
		System.out.println("조회수 :"+board.getReadCount());
		System.out.printf("작성자 : %s (%d) \n",board.getMemberNickname(),board.getMemberNo());
		System.out.println("---------------------------------------");
		System.out.println(board.getBoardContent());
		System.out.println("------------------------------------------");
	
	}
    
	private void deleteBoard() {
		System.out.println("\n****게시글 삭제****\n");
		
		if(loginMember == null) {
			System.out.println("로그인 후 이용해주세요");
			return;
		}
		System.out.print("게시글 번호 : ");
		int boardNo = sc.nextInt();
		
		Board board = service.selectDeleteBoard(boardNo,loginMember.getMemberNo());
		if(loginMember.getMemberNo() != board.getMemberNo()) {
//			System.out.println("정말 삭제하시겠습니까?(Y/N)");
//			String answer = sc.next();
//			if(answer.equals('Y')) {
//				int result = service.deleteBoard(boardNo);
//				if(result > 0) {
//					System.out.println("게시글 삭제 성공");
//				}else {
//					System.out.println("게시글 삭제 실패");
//				}
//			}else {
//				System.out.println("동일 x");
//			}
			
			System.out.println("동일 x");
			return;
		}
		System.out.println("동일o");
		System.out.println("정말 삭제하시겠습니까?(Y/N)");
		String answer = sc.next();
		
		if(answer.equals("Y")) {
			int result = service.deleteBoard(boardNo);
			if(result > 0) {
				System.out.println("게시글 삭제 성공");
			}else {
				System.out.println("게시글 삭제 실패");
			}
			
		}else {
			System.out.println("게시글 삭제 실패");
			System.out.println("Y입력해야 삭제가 됩니다");
		}
	}

	
	private void updateBoard() {
		System.out.println("\n**** 게시글 수정 ****\n");
		
		if(loginMember == null) {
			System.out.println("로그인 후 이용해주세요");
			return;
		}
		System.out.print("게시글 번호 : ");
		int boardNo = sc.nextInt();
		sc.nextLine();
		Board board = service.selectDeleteBoard(boardNo,loginMember.getMemberNo());
		if(loginMember.getMemberNo() != board.getMemberNo()) {
			System.out.println("동일 x");
			return;
		}
		System.out.println("동일o");
		
		System.out.print("수정할 제목 : ");
		String boardTitle = sc.nextLine();
		System.out.print("수정할 내용 : ");
		String boardContent = sc.nextLine();
		
		int result = service.updateBoard(boardTitle, boardContent, boardNo);
		
		if(result > 0) System.out.println("게시글 수정 성공");
		else	System.out.println("게시글 수정 실패");
		
		
		
	}
	
	
}
