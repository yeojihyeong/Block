<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bank.jsp</title>
</head>
<body>
계좌목록

<input name="fintechUseNum">
<button type="button" id="btnBalance">잔액조회</button>
<div id="divacc"></div>
	<div class="acc" data-usernum=""><span></span><span></span></div>
<div id="result"></div>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script type="text/javascript">
accountList();

function accountList(){
	$.ajax({
		url:"account",
	}).done(function(result){
		console.log(result);
	
	 	for(bank of result.res_list){
	 		$("<div>").addClass("acc")
	 				  .data("usernum", bank.fintech_use_num )
	 				  .append( $("<span>").html(bank.account_holder_name))
	 				  .append($("<span>").html(bank.account_num_masked))
	 				  .appendTo("#divacc")
	 		
	 		
	 		
	 		
		 /* $("#divacc").append(list[i].fintech_use_num);
		$("#divacc").append(list[i].account_holder_name);
		$("#divacc").append(list[i].account_num_masked); */  
		} 
	})
}


/* $("#btnBalance").on("click", */ 
		
	$(".divacc").on("click","span", function(){	
		var num = $(this).closest(".acc").data("usenum");
		console.log(num);
	$.ajax({
		url:"balance",
		data:{fintechUseNum:num},
	}).done(function(result){
		//잔액만 div에 출력
 		console.log(result);
 		$("#result").empty();
		$("#result").append("계좌:" + result.balance_amt);
	})
})
</script>

</body>
</html>