package com.kh.test.board.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.kh.test.board.model.dto.Board;

@Mapper
public interface BoardMapper {

	/** 게시글 목록 조회
	 * @return boardList
	 */
	List<Board> selectBoardList();

	
	/* 게시글 작성
	 * 
	 *  */
	int insert(Map<String, Object> map);

	/** 게시글 상세 조회 
	 * 
	 * */
	Board selectOne(int boardNo);

	
	
}
