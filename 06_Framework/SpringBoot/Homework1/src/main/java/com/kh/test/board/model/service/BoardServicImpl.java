package com.kh.test.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.mapper.BoardMapper;

@Transactional
@Service
public class BoardServicImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;

	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	
	@Override
	public List<Board> selectBoardList() {
		return mapper.selectBoardList();
	}
	
	@Override
	public int insert(String boardTitle, String boardPw, String boardWriter, String boardContent) {

		String encPw = bcrypt.encode(boardPw);
		
		Map<String, Object> map = new HashMap<>();
		map.put("encPw", map);
		map.put("boardTitle", boardTitle);
		map.put("boardWriter", boardWriter);
		map.put("boardContent", boardContent);
		
		return mapper.insert(map);
	}
	
	@Override
	public Board selectOne(int boardNo) {
		
		return mapper.selectOne(boardNo);
	}
}
