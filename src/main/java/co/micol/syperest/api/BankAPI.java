package co.micol.syperest.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BankAPI {

	public static void main(String[] args) {
// Map<String,Object> map = BankAPI.getBalanceInfo();
//		Map<String,Object> map = BankAPI.getTransactionInfo();
//		Map<String,Object> map = BankAPI.getInquiryInfo();
		BankVO vo = new BankVO();
		vo.setAccessToken(
				"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAxMDAzMDY4Iiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2NTExMDg2NDgsImp0aSI6Ijk0NGY1MzY3LTM0NDItNGUzNC1iMTE4LWZkZGIyNjIwYTA3OSJ9.jbq0fcVxQHo3Vcmx0OJLu8s8i4cV_NixQFFOsBpNpjU");
		vo.setFintechUseNum("120220017788941080951008");
		Map<String, Object> map = new BankAPI().getBalanceInfo(vo);
		System.out.println(map);
	}

	static String use_org_code = "M202200177";
	static String org_access_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiJNMjAyMjAwMTc3Iiwic2NvcGUiOlsib29iIl0sImlzcyI6Imh0dHBzOi8vd3d3Lm9wZW5iYW5raW5nLm9yLmtyIiwiZXhwIjoxNjUxNjMxODk4LCJqdGkiOiI3NzNmOWQ0OS1hMGVkLTQzNzMtODg4Mi03ZjY2YmE0NGE4ZDQifQ.DIexEfGVP6GutBhbj6iGXtb7ZziVLXue1G4DBrcYu6Q";

	public String getSequence() {
		long t = System.nanoTime();
		String result = String.valueOf(t).substring(7);
		return result;
	}// 9자리로 1씩증가된 값

	public String getDate() {
		String result = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		Date date = new Date();
		result = sdf.format(date);
		return result;
	}

	public Map<String, Object> getBalanceInfo(BankVO vo) {
		String reqURL = "https://testapi.openbanking.or.kr/v2.0/account/balance/fin_num";

		String param = "bank_tran_id=" + use_org_code + "U" + getSequence();
		param += "&tran_dtime=" + getDate();
		param += "&fintech_use_num=" + vo.getFintechUseNum();

		HttpHeaders headers = new HttpHeaders();
		String org_access_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAxMDAzMDY4Iiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2NTExMDg2NDgsImp0aSI6Ijk0NGY1MzY3LTM0NDItNGUzNC1iMTE4LWZkZGIyNjIwYTA3OSJ9.jbq0fcVxQHo3Vcmx0OJLu8s8i4cV_NixQFFOsBpNpjU";
		headers.set("Authorization", "Bearer " + org_access_token);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(null,
				headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Map> response = restTemplate.exchange(reqURL + "?" + param, HttpMethod.GET, request, Map.class);

		return response.getBody();

	}

	public Map<String, Object> getAccountInfo() {

		String reqURL = "https://testapi.openbanking.or.kr/v2.0/account/balance/fin_num";

		MultiValueMap<String, String> param = new LinkedMultiValueMap<String, String>();
		param.add("bank_tran_id", use_org_code + "U" + "000000023");
		param.add("tran_dtime", getDate());
		param.add("fintech_use_num", "120220017788941080951008");

		HttpHeaders headers = new HttpHeaders();
		String org_access_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAxMDAzMDY4Iiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2NTExMDg2NDgsImp0aSI6Ijk0NGY1MzY3LTM0NDItNGUzNC1iMTE4LWZkZGIyNjIwYTA3OSJ9.jbq0fcVxQHo3Vcmx0OJLu8s8i4cV_NixQFFOsBpNpjU";
		headers.set("Authorization", "Bearer " + org_access_token);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(param,
				headers);

		RestTemplate restTemplate = new RestTemplate();
		Map response = restTemplate.postForObject(reqURL, request, Map.class);

		return response;
	}

	public Map<String, Object> getTransactionInfo() {
		String reqURL = "https://testapi.openbanking.or.kr/v2.0/account/transaction_list/fin_num";

		String param = "bank_tran_id=" + use_org_code + "U" + "000000028";
		param += "&fintech_use_num=" + "120220017788941080951008";
		param += "&inquiry_type=" + 'A';
		param += "&inquiry_base=" + 'D';
		param += "&from_date=" + "20220201";
		param += "&to_date=" + "20220203";
		param += "&sort_order=" + 'D';
		param += "&tran_dtime=" + getDate();

		HttpHeaders headers = new HttpHeaders();
		String org_access_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAxMDAzMDY4Iiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2NTExMDg2NDgsImp0aSI6Ijk0NGY1MzY3LTM0NDItNGUzNC1iMTE4LWZkZGIyNjIwYTA3OSJ9.jbq0fcVxQHo3Vcmx0OJLu8s8i4cV_NixQFFOsBpNpjU";
		headers.set("Authorization", "Bearer " + org_access_token);

		HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(null,
				headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Map> response = restTemplate.exchange(reqURL + "?" + param, HttpMethod.GET, request, Map.class);

		return response.getBody();

	}

	public Map<String, Object> getInquiryInfo() {
		String reqURL = "https://testapi.openbanking.or.kr/v2.0/inquiry/real_name";
		Map<String, String> param = new HashMap<>();
		// MultiValueMap<String, String> param = new LinkedMultiValueMap<String,
		// String>();
		param.put("bank_tran_id", use_org_code + "U" + "000000041");
		param.put("bank_code_std", "031");
		param.put("account_num", "1234567890123456");
		param.put("account_holder_info_type", " ");
		param.put("account_holder_info", "951010");
		param.put("tran_dtime", getDate());

		ObjectMapper mapper = new ObjectMapper();
		String jsonparam = "";
		try {
			jsonparam = mapper.writeValueAsString(param);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		// System.out.println(jsonparam);

		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", "application/json; charset=UTF-8");
		// 기관토큰

		headers.set("Authorization", "Bearer " + org_access_token);
		// System.out.println(headers);

		HttpEntity<String> request = new HttpEntity<String>(jsonparam, headers);

		RestTemplate restTemplate = new RestTemplate();
		Map response = restTemplate.postForObject(reqURL, request, Map.class);

		return response;

	}
	
	
	public Map<String, Object> getAccountInfo(BankVO vo){
		String reqURL = "https://testapi.openbanking.or.kr/v2.0/account/list";
		
		String param ="user_seq_no=" + vo.getUserSeqNo();
		param +="&include_cancel_yn="+"Y";
		param +="&sort_order="+ "D";
		
		HttpHeaders headers = new HttpHeaders();
		String org_access_token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxMTAxMDAzMDY4Iiwic2NvcGUiOlsiaW5xdWlyeSIsImxvZ2luIiwidHJhbnNmZXIiXSwiaXNzIjoiaHR0cHM6Ly93d3cub3BlbmJhbmtpbmcub3Iua3IiLCJleHAiOjE2NTExMDg2NDgsImp0aSI6Ijk0NGY1MzY3LTM0NDItNGUzNC1iMTE4LWZkZGIyNjIwYTA3OSJ9.jbq0fcVxQHo3Vcmx0OJLu8s8i4cV_NixQFFOsBpNpjU";
		headers.set("Authorization", "Bearer " +org_access_token);
		
		HttpEntity<MultiValueMap<String, String>> request = 
				new HttpEntity<MultiValueMap<String, String>>(null,headers);
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Map> response = restTemplate.exchange(reqURL + "?" + param,
															HttpMethod.GET,
															request,
															Map.class);
		
		return response.getBody();
		
	}
	

}