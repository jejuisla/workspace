package edu.kh.test.view;

import java.util.Scanner;

import edu.kh.test.model.dto.ShopMember;
import edu.kh.test.model.service.ShopService;

public class TestView {
	
	private Scanner sc = new Scanner(System.in);
	private ShopService service = new ShopService();
	
	// 아이디 입력받아 한명의 회원정보 조회 
	public void selectMember() {
		System.out.print("ID 입력 : ");
		String memberId = sc.next();
		
		ShopMember sm = service.selectMember(memberId);
		
		if(sm != null) {
			System.out.println(sm);
		}
		
		
	}
	
	
}


