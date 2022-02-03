package co.micol.syperest.api;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //@Controller + ResponseBody 합친것 모든 호출이 애이작스일때사용하면 좋음
public class BankController {

	@RequestMapping("/balance")
	public Map balance(BankVO vo) {
		
		//로그인한 유저의 토큰은 DB에서 조회
		vo.setAccessToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAxMDAzMDY4Iiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2NTExMDg2NDgsImp0aSI6Ijk0NGY1MzY3LTM0NDItNGUzNC1iMTE4LWZkZGIyNjIwYTA3OSJ9.jbq0fcVxQHo3Vcmx0OJLu8s8i4cV_NixQFFOsBpNpjU");
		return new BankAPI().getBalanceInfo(vo);
	}
	
	@RequestMapping("/account")
	public Map account(BankVO vo) {
		vo.setAccessToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAxMDAzMDY4Iiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2NTExMDg2NDgsImp0aSI6Ijk0NGY1MzY3LTM0NDItNGUzNC1iMTE4LWZkZGIyNjIwYTA3OSJ9.jbq0fcVxQHo3Vcmx0OJLu8s8i4cV_NixQFFOsBpNpjU");
		vo.setUserSeqNo("1101003068");
		return new BankAPI().getAccountInfo(vo);
	}
	
}
