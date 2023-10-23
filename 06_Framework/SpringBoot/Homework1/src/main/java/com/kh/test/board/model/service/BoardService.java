package com.kh.test.board.model.service;

import java.util.List;

import com.kh.test.board.model.dto.Board;

public interface BoardService {

	
	/** 게시글 목록 조회
	 * @return boardList
	 */
	List<Board> selectBoardList();

	/** 게시글 수정
	 * 
	 * */
	int insert(String boardTitle, String boardPw, String boardWriter, String boardContent);

	/** 게시글 상세 조회
	 * 
	 *  */
	Board selectOne(int boardNo);

}
