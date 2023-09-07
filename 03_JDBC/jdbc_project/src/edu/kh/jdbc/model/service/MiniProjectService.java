package edu.kh.jdbc.model.service;

import java.sql.Connection;


import edu.kh.jdbc.model.dao.MiniProjectDAO;
import edu.kh.jdbc.model.dto.MiniProject;
import static edu.kh.jdbc.common.JDBCTemplate.*;
public class MiniProjectService {

	private MiniProjectDAO dao = new MiniProjectDAO();
	
	public int insertMember(MiniProject member) {
		Connection conn = getConnection();
		
		int result = dao.insertMember(conn, member);
		
		if(result > 0) commit(conn);
		else		rollback(conn);
		
		close(conn);
		return result;
	}

}
