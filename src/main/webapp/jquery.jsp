<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.active {
	background-color: red
}
</style>

</head>
<body>

	<ul class="klist">
		<li data-price="500" data-pub="영진">java</li>
		<li data-price="400">jsp</li>
		<li data-price="300">spring</li>
	</ul>
	<button type="button" id=btnCount>선택확인</button>
	<script src="https://code.jquery.com/jquery-3.6.0.js"
		integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
		crossorigin="anonymous"></script>
	<script type="text/javascript">

	
		$("li").on("click", function() {
			// $(event.target).css("backgroundColor","green");//$(this) 같음

			/* if ($(this).hasClass("active")) {
				$(this).removeClass("active")
			} else {
				$(this).addClass("active")
			} */
			
			$(this).toggleClass("active")
			alert($(this).data("price"));
			console.log($(this).data("price"));
		})
		
		$("#btnCount").on("click",function(){
			//클래스가 active 태그 찾아서 개수 출력
			// alert($(".active").length +"개 선택됨");
			var list = $(".active");
			for(i=0;i<list.length; i++)
				{
					console.log($(list[i]).html());
				}
			
			
			for( temp of list) {
				console.log( $(temp).html() );
			}
			
			$.each(list, function(i, item){
				console.log( $(item).html() );
			});
			
		})
		
	</script>
</body>
</html>