package edu.kh.test.model.service;

import static edu.kh.test.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.test.model.dto.ShopMember;
import edu.kh.test.model.dao.ShopDAO;
import oracle.net.nt.ConnectDescription;

public class ShopService {

	private ShopDAO dao = new ShopDAO();

	public ShopMember selectMember(String memberId) {
		Connection conn = getConnection();
		
		ShopMember sm = dao.selectMember(conn, memberId);
		
		close(conn);
		return sm;
	}

	
	
	
	
}
