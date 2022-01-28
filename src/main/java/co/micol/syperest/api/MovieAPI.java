package co.micol.syperest.api;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MovieAPI {
	
	public static void main(String[] args) throws Exception {
		//movieList();
		movieInfo("20112207");
	}
	
	
	 static String boxofficerul = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20220127";
	
	 
	 public static JsonNode restMovieList() throws Exception{
		 RestTemplate rest = new RestTemplate();
		 JsonNode node = rest.getForObject(boxofficerul, JsonNode.class);
		 return  node.get("boxOfficeResult")
					.get("dailyBoxOfficeList");
	 }
	 
	public static JsonNode movieList() throws Exception{
		
		URL url = new URL(boxofficerul);
		//서버연결
		URLConnection urlcon = url.openConnection();
		
		//응답결과 받고
		InputStream in = urlcon.getInputStream();
		
		//제이슨 변환시켜주는 라이브러리
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode nodes = mapper.readTree(url);
		
		String nm = 
				nodes.get("boxOfficeResult")
				 .get("dailyBoxOfficeList")
				 .get(0)
				 .get("movieNm").asText();
		System.out.println(nm);
		
		JsonNode list = nodes.get("boxOfficeResult")
						.get("dailyBoxOfficeList");
		
		for(int i = 0 ; i<list.size() ; i++) {
			String mnm = 
						list.
							get(i)
							.get("movieNm").asText();
			
			System.out.println(mnm);					
		}
		return list;
		
	}
	
	
	
	
	
	
	public static void movieInfo(String cd) throws Exception{
		String urladdr = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=f5eef3421c602c6cb7ea224104795888&movieCd="+cd;
		
		URL url = new URL(urladdr);
		//서버연결
		URLConnection urlcon = url.openConnection();
		
		//응답결과 받고
		InputStream in = urlcon.getInputStream();
		
		//제이슨 변환시켜주는 라이브러리
		ObjectMapper mapper = new ObjectMapper();
		
		JsonNode nodes = mapper.readTree(url);
		
		/*
		 * String nm = nodes.get("boxOfficeResult") .get("dailyBoxOfficeList") .get(0)
		 * .get("movieNm").asText(); System.out.println(nm);
		 */
		
		JsonNode list = nodes.get("movieInfoResult")
						.get("movieInfo")
						.get("actors");
		
		for(int i = 0 ; i<list.size() ; i++) {
			String mnm = list.
							get(i)
							.get("peopleNm").asText();
			
			System.out.println(mnm);					
		}
		
	}
}
