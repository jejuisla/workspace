package edu.kh.project.myPage.model.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.mapper.MyPageMapper;

@Service
public class MyPageServiceImpl implements MyPageService{

	@Autowired
	private MyPageMapper mapper;
	
	@Autowired
	private BCryptPasswordEncoder bcrypt;
	
	@Override
	public int info(Member updateMember, String[] memberAddress) {
		
		// 주소 가공
		// 주소가 입력되지 않은 경우
		if(updateMember.getMemberAddress().equals(",,")) {
			updateMember.setMemberAddress(null); // null로 변환
		} else {
		// 배열 -> 문자열로 합쳐서 inputMember에 추가
			String address = String.join("^^^", memberAddress);
			updateMember.setMemberAddress(address);
		}		
		return mapper.info(updateMember);
	}
	
	@Override
	public int changePw(String currentPw, String newPw, int memberNo) {
		// 로그인한 회원 비밀번호 조회
		String encPw = mapper.selectMemberPw(memberNo); 
		
		if(!bcrypt.matches(currentPw, encPw)) {  
			return 0;
		}
		// 같으면 새 비밀번호 변경
		// 마이바티스 코드의 파라미터는 1개만 가능
		// 지금 newPw, currentPw 두개 필요 -> Map(Collection 사용)
		
		Map<String, Object> map = new HashMap<>(); // Map 생성 후 파라미터 집어넣기
		map.put("newPw", bcrypt.encode(newPw)); // 회원가입 창에서 새 비밀번호 칸에 적은 비밀번호를 암호화
		map.put("memberNo", memberNo);
		
		return mapper.changePw(map);
	}

	@Override
	public int secession(String memberPw, int memberNo) {
		String encPw = mapper.selectMemberPw(memberNo);
		
		if(!bcrypt.matches(memberPw, encPw)) {
			return 0;
		}
		return mapper.secession(memberNo);
	}

}