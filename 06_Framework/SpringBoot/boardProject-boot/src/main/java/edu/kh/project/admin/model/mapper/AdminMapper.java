package edu.kh.project.admin.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import edu.kh.project.member.model.dto.Member;

@Mapper
public interface AdminMapper {

	Member select(String inputEmail);

	/** 전체 회원 조회
	 * @return memberList
	 */
	// Mapper 메서드의 반환형이 List로 작성되어 있으면
	// Mybatis 수행 시 조회하는 모든 행을 자동으로 
	// List에 추가
	// 조회 결과가 없을 경우 비어 있는 List(0칸)가 반환
	List<Member> selectAll();

	/** 전체 회원 조회(정렬 포함)
	 * @param query
	 * @return memberList
	 */
	List<Member> selectSort(String query);

	/** 회원 복구
	 * @param memberNo
	 * @return
	 */
	int restoration(int memberNo);

	/** 권한 변경
	 * @param memberNo
	 * @return
	 */
	int changeAuthority(int memberNo);

	int initPw(Map<String, Object> map);

	

	

}
