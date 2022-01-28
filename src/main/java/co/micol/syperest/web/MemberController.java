package co.micol.syperest.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.micol.syperest.service.MemberService;
import co.micol.syperest.service.MemberVO;
import co.micol.syperest.util.Aria;
import co.micol.syperest.util.ShaEncyption;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberDao;
	
	private final static String ENC_TO_DEC = "a123456789abcd";
	
	@RequestMapping("/login.do")
	public String login(MemberVO vo, Model model) {
		//단방향 암호화 객체 생성
		ShaEncyption sha = new ShaEncyption();

		//패스워드 암호화
		vo.setMember_password(sha.encryptSHA256(vo.getMember_password()));
		
		System.out.println(vo.getMember_password());
		
		model.addAttribute("member", memberDao.memberSelect(vo));
		return "member/loginResult";
	}
	
	@PostMapping("/encryption.do")
	public String encryption(@RequestParam("str") String str, Model model) {
		Aria aria = new Aria(ENC_TO_DEC); //양방향 암호화 객체 생성
		
		//암호화
		str= aria.Encrypt(str);
		model.addAttribute("encStr",str);		
		return "member/encryption";
	}
	
	@PostMapping("/decrytion.do")
	public String decrytion(@RequestParam("str") String str, Model model) {
		Aria aria = new Aria(ENC_TO_DEC); //복호화 , 암호화할때 키 그대로 사용할것
		str = aria.Decrypt(str);
		model.addAttribute("decrytStr",str);
		
		
		return "member/decrytion";
	}
	
}
