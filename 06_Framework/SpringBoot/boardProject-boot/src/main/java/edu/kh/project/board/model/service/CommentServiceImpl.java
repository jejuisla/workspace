package edu.kh.project.board.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.kh.project.board.model.dto.Comment;
import edu.kh.project.board.model.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{
	private final CommentMapper mapper;
	
	@Override
	public List<Comment> select(int boardNo) {
		return mapper.select(boardNo);
	}
	
	@Override
	public int insert(Comment comment) {
		return mapper.insert(comment);
	}
	
	// 댓글 수정
	@Override
	public int update(Comment comment) {
		// TODO Auto-generated method stub
		return mapper.update(comment);
	}
	
	// 댓글 삭제
	@Override
	public int delete(int commentNo) {
		// TODO Auto-generated method stub
		return mapper.delete(commentNo);
	}
}
