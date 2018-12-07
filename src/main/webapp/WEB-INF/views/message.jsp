<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>


<!DOCTYPE html>
<html lang="ko">
<head>
<c:import url="include/header.jsp"/>

 <!-- Font Awesome -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"> 
   <!-- MDBootstrap Datatables  -->
<link href="/resources/css/datatables.min.css" rel="stylesheet"> 
</head>
<body>
<c:import url="include/top.jsp"/>
<c:import url="include/topMenu.jsp"/>	
	<!-- /subnavbar -->
	<div class="main">
		<div class="main-inner">

		
			<div class="container">
		
							<div class="row">
					  <div class="span12" style="margin-bottom: 30px;">
					  	<h2 class="text-center" style="text-align: center;">
					 			대시보드 - 
					  	<c:choose>
					  		<c:when test="${grade  eq 'fatal' }">
					  			FATAL
					  		</c:when>
					  		<c:when test="${grade  eq 'error' }">					 
					  		ERROR
					  		</c:when>
					  		<c:when test="${grade  eq 'warn' }">
					  			WARN
					  		</c:when>
					  	   <c:when test="${grade  eq 'info' }">
					  			INFO
					  		</c:when>	
					  		<c:when test="${grade  eq 'all' }">
					  			전체
					  		</c:when>
					  	</c:choose>					 			
						 </h2>					  						  						  	
					  </div>	
					</div>
		
		
		
			<div class="row">
				<div class="span12">
			<table id="dtBasicExample" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
									<thead>
										<tr>
											<th class="th-sm">번호</th>
											<th class="th-sm">sender</th>
											<th class="th-sm">taker</th>
											<th class="th-sm">sub</th>
											<th class="th-sm">body</th>
											<th class="th-sm">received_date</th>	
											<th class="th-sm">grade</th>										
										</tr>
									</thead>
									<tbody>		

									<c:forEach items="${messageList }" var="row" varStatus="status">																		
										<tr>
											<td>${status.count}</td>
											<%-- <td><pre>${row.eno}</pre></td> --%>
											<td><pre class="pre-body">${row.sender}</pre></td>
											<td><pre class="pre-body">${row.taker}</pre></td>
											<td><pre class="pre-body">${row.sub}</pre></td>
											<td><pre class="pre-body">${row.body}</pre></td>
											<td>${row.formattedDate}</td>
											<td>
								  	<c:choose>
											  		<c:when test="${row.grade  eq 'fatal' }">
											  			<span class="btn btn-danger">${row.grade}</span>
											  		</c:when>
											  		<c:when test="${row.grade  eq 'error' }">					 
											  		<span class="btn btn-warning">${row.grade}</span>
											  		</c:when>
											  		<c:when test="${row.grade  eq 'warn' }">
											  			<span class="btn btn-info">${row.grade}</span>
											  		</c:when>
											  		<c:when test="${row.grade  eq 'info' }">
											  			<span class="btn btn-success">${row.grade}</span>
											  		</c:when>												  							  	
								    </c:choose>																									
											</td>
									
										</tr>										
   									</c:forEach>

			
							     	</tbody>
								</table>
				
				</div>
			
			</div>
		
		

				</div>
			<!-- /container -->
	
		</div>
		<!-- /main-inner -->
	</div>
	
	

<c:import url="include/footer.jsp"/>

 
   <!-- MDB core JavaScript -->
<script type="text/javascript" src="/resources/js/mdb.min.js"></script>
   <!-- MDBootstrap Datatables  -->
<script type="text/javascript" src="/resources/js/datatables.js"></script>
<script>
$(document).ready(function () {
  $('#dtBasicExample').DataTable();
  $('.dataTables_length').addClass('bs-select');

  dataTableCss();
   
   
});

function dataTableCss(){
	$("#dtBasicExample_filter").css("float","right");
	$("#dtBasicExample_paginate").css("float","right");
}
</script>



</body>
</html>