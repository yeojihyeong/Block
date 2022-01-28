package co.micol.syperest.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.micol.syperest.service.MemberMapper;
import co.micol.syperest.service.MemberService;
import co.micol.syperest.service.MemberVO;
@Repository("memberDao")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper map;
	
	@Override
	public List<MemberVO> memberSelectList() {

		return map.memberSelectList();
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {

		return map.memberSelect(vo);
	}

	@Override
	public int memberInsert(MemberVO vo) {
		return map.memberInsert(vo);
	}

	@Override
	public int memberDelete(MemberVO vo) {
		return map.memberDelete(vo);
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		return map.memberUpdate(vo);
	}

}
