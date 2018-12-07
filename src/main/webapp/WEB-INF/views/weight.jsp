<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<c:import url="include/header.jsp"/>
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
					  	<c:choose>
					  		<c:when test="${type  eq 'zabbix' }">
					  		 <c:set var="settingType"  value="Zabbix "/>
					  			Zabbix
					  		</c:when>
					  		<c:when test="${type  eq 'checkserver' }">
					  		<c:set var="settingType"  value="체크서버 "/>
					  		체크서버
					  		</c:when>
					  		<c:when test="${type  eq 'crash' }">
					  		<c:set var="settingType"  value="크래쉬 "/>
					  			크래쉬
					  		</c:when>					  	
					  	</c:choose>
					  	
					  	가중치 설정 </h2>					  	
					  	<input type="hidden"  name="type" value="${type}"  />
					  	<button class="btn btn-success" style="float:right;">설정</button>
					  </div>	
					</div>
			
			
			
					
				<div class="row">
					<div class="span12">					
						<!-- /widget -->
						<div class="widget widget-table action-table">
							<div class="widget-header">
								<i class="icon-th-list"></i>
								<h3>가중치 설정</h3>
							</div>
							<!-- /widget-header -->
							<div class="widget-content">
								<table class="table table-striped table-bordered">
									<thead>
										<tr>
											<th>번호</th>
											<th>키워드</th>
											<th>점수입력 (1~10)</th>											
										</tr>
									</thead>
									<tbody>
					<tr>
						<td>1</td>
						<td>keyword_01</td>
						<td><input type="number" class='socre-number' min="1" max="10" name="score1" value="${score.score1}"></td>
					</tr>									
					<tr>
						<td>2</td>
						<td>keyword_02</td>
						<td><input type="number" class='socre-number' min="1" max="10" name="score2" value="${score.score2}"></td>
					</tr>
					<tr>
						<td>3</td>
						<td>keyword_03</td>
						<td><input type="number" class='socre-number' min="1" max="10" name="score3" value="${score.score3}"></td>
					</tr>
					
					<tr>
						<td>4</td>
						<td>keyword_04</td>
						<td><input type="number" class='socre-number' min="1" max="10" name="score4" value="${score.score4}"></td>
					</tr>
					<tr>
						<td>5</td>
						<td>keyword_05</td>
						<td><input type="number" class='socre-number' min="1" max="10" name="score5" value="${score.score5}"></td>
					</tr>
					<tr>
						<td>6</td>
						<td>keyword_06</td>
						<td><input type="number" class='socre-number' min="1" max="10" name="score6" value="${score.score6}"></td>
					</tr>
					<tr>
						<td>7</td>
						<td>keyword_07</td>
						<td><input type="number" class='socre-number' min="1" max="10" name="score7" value="${score.score7}"></td>
					</tr>														
					<tr>
						<td>8</td>
						<td>keyword_08</td>
						<td><input type="number" class='socre-number' min="1" max="10" name="score8" value="${score.score8}"></td>
					</tr>					
					<tr>
						<td>9</td>
						<td>keyword_09</td>
						<td><input type="number" class='socre-number' min="1" max="10" name="score9" value="${score.score9}"></td>
					</tr>
					
					<tr>
						<td>10</td>
						<td>keyword_10</td>
						<td><input type="number" class='socre-number' min="1" max="10" name="score10" value="${score.score10}"></td>
					</tr>

					<tr>
						<td>11</td>
						<td>keyword_11</td>
						<td><input type="number" class='socre-number' min="1" max="10" name="score11" value="${score.score11}"></td>
					</tr>									
					<tr>
						<td>12</td>
						<td>keyword_12</td>
						<td><input type="number" class='socre-number' min="1" max="10" name="score12" value="${score.score12}"></td>
					</tr>
					<tr>
						<td>13</td>
						<td>keyword_13</td>
						<td><input type="number" class='socre-number' min="1" max="10" name="score13" value="${score.score13}"></td>
					</tr>
					
					<tr>
						<td>14</td>
						<td>keyword_14</td>
						<td><input type="number" class='socre-number' min="1" max="10" name="score14" value="${score.score14}"></td>
					</tr>
					<tr>
						<td>15</td>
						<td>keyword_15</td>
						<td><input type="number" class='socre-number' min="1" max="10" name="score15" value="${score.score15}"></td>
					</tr>
					<tr>
						<td>16</td>
						<td>keyword_16</td>
						<td><input type="number" class='socre-number' min="1" max="10" name="score16" value="${score.score16}"></td>
					</tr>
					<tr>
						<td>17</td>
						<td>keyword_17</td>
						<td><input type="number" class='socre-number' min="1" max="10" name="score17" value="${score.score17}"></td>
					</tr>														
					<tr>
						<td>18</td>
						<td>keyword_18</td>
						<td><input type="number" class='socre-number' min="1" max="10" name="score18" value="${score.score18}"></td>
					</tr>					
					<tr>
						<td>19</td>
						<td>keyword_19</td>
						<td><input type="number" class='socre-number' min="1" max="10" name="score19" value="${score.score19}"></td>
					</tr>
					
					<tr>
						<td>20</td>
						<td>keyword_20</td>
						<td><input type="number" class='socre-number' min="1" max="10" name="score20" value="${score.score20}"></td>
					</tr>
					<tr>
						<td>21</td>
						<td>keyword_21</td>
						<td><input type="number" class='socre-number' min="1" max="10" name="score21" value="${score.score21}"></td>
					</tr>									
					<tr>
						<td>22</td>
						<td>keyword_22</td>
						<td><input type="number" class='socre-number' min="1" max="10" name="score22" value="${score.score22}"></td>
					</tr>
					<tr>
						<td>23</td>
						<td>keyword_23</td>
						<td><input type="number" class='socre-number' min="1" max="10" name="score23" value="${score.score23}"></td>
					</tr>
					
					<tr>
						<td>24</td>
						<td>keyword_24</td>
						<td><input type="number" class='socre-number' min="1" max="10" name="score24" value="${score.score24}"></td>
					</tr>
					<tr>
						<td>25</td>
						<td>keyword_25</td>
						<td><input type="number" class='socre-number' min="1" max="10" name="score25" value="${score.score25}"></td>
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

<c:if test="${not empty message }">
<script>
alert('${settingType} 가중치가 설정 되었습니다.');
history.replaceState({}, null, location.pathname);
</script>
</c:if>
</body>
</html>