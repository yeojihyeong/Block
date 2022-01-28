<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
<h3>박스오피스</h3>
<div id="result"></div>
<div id="info"></div>
<script type="text/javascript">

function movieList() {
var url = 'http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20120101'
$.ajax({
	url: url,
	
}).done(function(datas){

	var	list = datas.boxOfficeResult.dailyBoxOfficeList;
		for(i=0; i<list.length; i++){
		
		$("#result").append(`<a href='javascript:movieInfo(${list[i].movieCd});'> \${i+1} 등 :  \${list[i].movieNm} </a> <br>`);	
		}
			
		
	
} );
}

movieList();

function movieInfo(cd){
var url = 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=f5eef3421c602c6cb7ea224104795888&movieCd=' + cd
	$.ajax({
		url: url,
		
	}).done(function(datas){
	//배우리스트
		var list = datas.movieInfoResult.movieInfo.actors;
		for(i=0; i<list.length; i++){
			$("#info").append((i+1)+"번째 배우 : "+list[i].peopleNm+"<br>");
		}
	//첫번째 감독이름
		var list1 = datas.movieInfoResult.movieInfo.directors;
		$("#info").append("감독: "+list1[0].peopleNm);
				
			 
				
		
	} );
}
</script>
</body>
</html>