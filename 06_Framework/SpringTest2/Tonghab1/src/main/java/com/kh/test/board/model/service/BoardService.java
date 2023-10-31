package com.kh.test.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kh.test.board.model.dto.Board;

@Service
public interface BoardService {

	Board selectBoard(String boardTitle);


}
