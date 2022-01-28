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
<div id="movieList"></div>

<script type="text/javascript">
$.ajax({
	url: 'movieList'
}).done(function(datas){
	var	list = datas;
	for(i=0; i<list.length; i++){
	
	$("#movieList").append(`<a href='javascript:movieInfo(${list[i].movieCd});'> \${i+1} 등 :  \${list[i].movieNm} </a> <br>`);	
	}
});

</script>
</body>
</html>