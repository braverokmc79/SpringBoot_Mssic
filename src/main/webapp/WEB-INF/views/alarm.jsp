<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<c:import url="include/header.jsp"/>
<style type="text/css">
.text-center{
 text-align: center !important;
}

</style>
</head>
<body>
<c:import url="include/top.jsp"/>
<c:import url="include/topMenu.jsp"/>	
	<!-- /subnavbar -->
	<div class="main">
		<div class="main-inner">
		
		<form method="post"  action="/users/weight" >
			<div class="container">
			
					<div class="row">
					  <div class="span12" style="margin-bottom: 30px;">
					  	<h2 class="text-center" style="text-align: center;">					  	
					  	Alarm 설정 </h2>					  	
					  	<input type="hidden"  name="type" value="${type}"  />
					  	<!-- <button class="btn btn-success" style="float:right;">설정</button> -->
					  </div>	
					</div>
			
			
			
					
				<div class="row">
					<div class="span12">					
						<!-- /widget -->
						<div class="widget widget-table action-table">
							<div class="widget-header">
								<i class="icon-th-list"></i>
								<h3>Alarm 설정</h3>
							</div>
							<!-- /widget-header -->
							<div class="widget-content">
				<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>번호</th>
									<th width="45%">호스트</th>
									<th width="45%"></th>											
								</tr>
							</thead>
							<tbody>

					<tr>
						<td>1</td>
						<td>checkserver</td>
						<td class="text-center">
<input type="checkbox"  data-toggle="toggle"  name="checkserver" id="checkserver" 
<c:out   value="${alarm.checkserver eq '1' ? 'checked' : '' }"     />	 onchange="alarmAction('checkserver')"	>					
																																							
						</td>
					</tr>									


					<tr>
						 <td>2</td>
						 <td>crash</td>
						 <td class="text-center" >
<input type="checkbox"  data-toggle="toggle"  name="crash" id="crash" 
			<c:out   value="${alarm.crash eq '1' ? 'checked' : '' }"      />	onchange="alarmAction('crash')"	>							 
						 </td>						
					</tr>

					<tr>
						 <td>3</td>
						 <td>DLPsvr</td>
						 <td class="text-center">
<input type="checkbox"  data-toggle="toggle"  name="dlpsvr" id="dlpsvr" 
			<c:out   value="${alarm.dlpsvr eq '1' ? 'checked' : '' }"      />	onchange="alarmAction('dlpsvr')"	>						 
						 </td>						
					</tr>
						
						
					<tr>
						 <td>4</td>
						 <td>drmsvr</td>
						 <td class="text-center">
<input type="checkbox"  data-toggle="toggle"  name="drmsvr" id="drmsvr" 
			<c:out   value="${alarm.drmsvr eq '1' ? 'checked' : '' }"      />	onchange="alarmAction('drmsvr')"	>							 
						 </td>						
					</tr>
						
					<tr>
						 <td>5</td>
						 <td>efilcare01</td>
						 <td class="text-center">
<input type="checkbox"  data-toggle="toggle"  name="efilcare01" id="efilcare01" 
			<c:out   value="${alarm.efilcare01 eq '1' ? 'checked' : '' }"      />	onchange="alarmAction('efilcare01')">						 
						 </td>						
					</tr>

					<tr>
						 <td>6</td>
						 <td>efilcare02</td>
						 <td class="text-center">
<input type="checkbox"  data-toggle="toggle"  name="efilcare02" id="efilcare02" 
			<c:out   value="${alarm.efilcare02 eq '1' ? 'checked' : '' }"      />	onchange="alarmAction('efilcare02')">							 
						 
						 </td>						
					</tr>
						
					<tr>
						 <td>7</td>
						 <td>LifeRecordDatabase01</td>
						 <td class="text-center">
<input type="checkbox"  data-toggle="toggle"  name="lifeRecordDatabase01" id="lifeRecordDatabase01" 
			<c:out   value="${alarm.lifeRecordDatabase01 eq '1' ? 'checked' : '' }"      />	onchange="alarmAction('lifeRecordDatabase01')">							 
						 </td>						
					</tr>												
	
				<tr>
						 <td>8</td>
						 <td>LifeRecordDatabase02</td>
						 <td  class="text-center">
<input type="checkbox"  data-toggle="toggle"  name="lifeRecordDatabase02" id="lifeRecordDatabase02" 
			<c:out   value="${alarm.lifeRecordDatabase02 eq '1' ? 'checked' : '' }"      />	onchange="alarmAction('lifeRecordDatabase02')">						 
						 </td>						
					</tr>	
						
				
				<tr>
				 	 <td>9</td>
					 <td>LifeRecordDatabase03</td>
					 <td class="text-center">
<input type="checkbox"  data-toggle="toggle"  name="lifeRecordDatabase03" id="lifeRecordDatabase03" 
			<c:out   value="${alarm.lifeRecordDatabase03 eq '1' ? 'checked' : '' }"      />	onchange="alarmAction('lifeRecordDatabase03')">						 					 
					 </td>						
				</tr>					
																		
		
				<tr>
				 	 <td>10</td>
					 <td>LifeRecordServer01</td>
					 <td class="text-center">
<input type="checkbox"  data-toggle="toggle"  name="lifeRecordServer01" id="lifeRecordServer01" 
			<c:out   value="${alarm.lifeRecordServer01 eq '1' ? 'checked' : '' }"      />	onchange="alarmAction('lifeRecordServer01')">						 					 					 
					 </td>						
				</tr>					
								
		
				<tr>
				 	 <td>11</td>
					 <td>LifeRecordServer02</td>
					 <td class="text-center">
<input type="checkbox"  data-toggle="toggle"  name="lifeRecordServer02" id="lifeRecordServer02" 
			<c:out   value="${alarm.lifeRecordServer02 eq '1' ? 'checked' : '' }"      />	onchange="alarmAction('lifeRecordServer02')">						 					 					 
					 
					 </td>						
				</tr>			
		
				<tr>
				 	 <td>12</td>
					 <td>LifeSemanticsService01</td>
					 <td class="text-center">
<input type="checkbox"  data-toggle="toggle"  name="lifeSemanticsService01" id="lifeSemanticsService01" 
			<c:out   value="${alarm.lifeSemanticsService01 eq '1' ? 'checked' : '' }"      />	onchange="alarmAction('lifeSemanticsService01')">						 					 					 
					 
					 </td>						
				</tr>									
	
				<tr>
				 	 <td>13</td>
					 <td>LifeSemnaticsService02</td>
					 <td class="text-center">
<input type="checkbox"  data-toggle="toggle"  name="lifeSemnaticsService02" id="lifeSemnaticsService02" 
			<c:out   value="${alarm.lifeSemnaticsService02 eq '1' ? 'checked' : '' }"      />	onchange="alarmAction('lifeSemnaticsService02')">						 					 					 
					 
					 </td>						
				</tr>									
		
				<tr>
				 	 <td>14</td>
					 <td>postman</td>
					 <td class="text-center" style="text-align: center;">
<input type="checkbox"  data-toggle="toggle"  name="postman" id="postman" 
			<c:out   value="${alarm.postman eq '1' ? 'checked' : '' }"      />	onchange="alarmAction('postman')">						 					 					 
					 
					 </td>						
				</tr>	
		
		
									</tbody>
								</table>
							</div>
							<!-- /widget-content -->
						</div>
					
					
					</div>		
	
	
				</div>
				<!-- /row -->

			</div>
			<!-- /container -->
			</form>
			
			
		</div>
		<!-- /main-inner -->
	</div>
	
	

<c:import url="include/footer.jsp"/>


<script>

$(document).ready(function(){
	
	
/* 	$("#checkserver").on("change", function(e){				
		var column="checkserver";
		var value =$("#checkserver").is(":checked");
		commonAlarm(column, value);
	}); */
	
});

function alarmAction(id){
	var column=id;
	var value =$("#"+id).is(":checked");
	commonAlarm(column, value);	
}


function commonAlarm(column, value  ){
	var checkValue=0;		
	if(value){
		checkValue=1;
	}else{
		checkValue=0;
	}
		$.ajax({
		url:"/users/alarm/ajax",
		type:"post",			
		data:{
			column:column,
			checkValue:checkValue
		},							
		dataType:"text",
		success:function(result){
			console.log(result);				
			if($.trim(result)=="success"){
				if(value){													
					setTimeout(function() { 							
						alert(column + "  값을 on 으로 변경 했습니다.");							
					}												
					, 500);
				}else{	
					setTimeout(function() { 							
						alert(column + "  값을  off 으로 변경 했습니다.");							
					}												
					, 500);
					
				}	
			}				
		},
		error:function(result){
			
		}					
	}); 				
	
	
}


</script>




</body>
</html>