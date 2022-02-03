<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input name="kor"><input name="eng">
<button id="btnAdd" type="button">추가</button>
<button id="btnScore" type="button">국어성적합계</button>

<table>
	<thead>
		<tr>
			<td>국어</td>
			<td>영어</td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>40</td>
			<td>60</td>
		</tr>
		<tr>
			<td>80</td>
			<td>100</td>
		</tr>
		<tr>
			<td>60</td>
			<td>60</td>
		</tr>
	</tbody>
</table>

<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script type="text/javascript">
	//국어성적합계 버턴을 클릭하면 국어성적합계를 계산하여 alert로 출력
		//숫자로 형변환 후 덧셈
	$("#btnScore").on("click",function(){
		list = $("tbody").find("tr");
		//tr을 반복문 돌면서 td값 읽기.
		for(i = 0 ; i < list.length; i++){
			console.log($(list[i].html()));
			
		}
	})
	
	//추가 버튼을 클릭하면 input 태그의 값으로 <tr> 생성해서 테이블 추가
</script>
</body>
</html>