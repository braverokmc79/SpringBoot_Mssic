<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<c:import url="include/head.jsp" />
<style type="text/css">
 .main-v2-section{
 	background-color: #fff;
 	height: 100px;
 }
 body{
 	overflow-y:
 }
 .jumbotron{
 	background-color: #fff;
 }
</style>
</head>
<body>
	<c:import url="include/header.jsp" />


	<section class="header-banner"></section>
	<section class="main-v2-boards main-v2-section">
		<div class="container">
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
		</div>
	</section>




   <div class="container">     
   	 
   	<div class="row text-center">
   	
	  <div class="col-md-12">
        <img src="/resources/images/rabbit.png"  class="img-responsive center-block"/>
     </div>
    
     </div>		
   </div>
    
 <div class="container">
    <div class="column add-bottom">
        <div id="mainwrap">
            <div id="nowPlay">
                <span id="npAction">Paused...</span><span id="npTitle"></span>
            </div>
            <div id="audiowrap">
                <div id="audio0">
                    <audio id="audio1" preload controls>Your browser does not support HTML5 Audio! 😢</audio>
                </div>
                <div id="tracks">
                    <a id="btnPrev">&larr;</a><a id="btnNext">&rarr;</a>
                </div>
                <div>
                	<button type="button" class="btn btn-info" onclick="plListModal()"><i class="fas fa-list-alt" style="font-size: 25px;"></i></button>
                </div>
            </div>
            <div id="plwrap" style="display: none;">
                <ul id="plList"></ul>
            </div>
        </div>
    </div>
    <div class="column add-bottom center">
        <p></p>        
    </div>
</div>


	<section class="header-banner"></section>
	<section class="main-v2-boards main-v2-section">
		<div class="container">
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
		</div>
	</section>





	<c:import url="./include/footer.jsp" />
	<script src="/resources/mss/js/music.js"></script>

	<script type="text/javascript">
		function plListModal(e) {
			$("#plwrap").toggle("slow");
		}

		dateFormat();
		function dateFormat() {
			var moments = document.getElementsByClassName('moment');
			for (var i = 0; i < moments.length; ++i) {
				var item = moments[i];
				item.innerHTML = moment(item.textContent, "YYYY-MM-DD hh:mm:ss")
						.fromNow();
			}
		}
	</script>


</body>
</html>