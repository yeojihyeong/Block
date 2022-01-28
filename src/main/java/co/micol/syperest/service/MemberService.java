package co.micol.syperest.service;

import java.util.List;

public interface MemberService {
	List<MemberVO> memberSelectList();
	
	MemberVO memberSelect(MemberVO vo); //한명조회, 로그인 처리
	
	int memberInsert(MemberVO vo);
	
	int memberDelete(MemberVO vo);
	
	int memberUpdate(MemberVO vo);
	
}
