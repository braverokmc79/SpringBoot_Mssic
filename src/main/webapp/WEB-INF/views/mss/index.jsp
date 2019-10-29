<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
 int isMobile = 0;
 String agent = request.getHeader("USER-AGENT");
 String[] mobileos = {"iPhone","iPod","Android","BlackBerry","Windows CE","Nokia","Webos","Opera Mini","SonyEricsson","Opera Mobi","IEMobile"};
 int j = -1;
 for(int i=0 ; i<mobileos.length ; i++) {
 	j=agent.indexOf(mobileos[i]);
 	if(j > -1 ){ 	
 	// 모바일로 접근했을 때
 	 isMobile = 1;
 	 request.setAttribute("isMobile", isMobile);
 	break;
   }
 }
 %>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="include/head.jsp" %>

<style type="text/css">
 .main-v2-section{
 	background-color: #fff;
 	height: 100px;
 }

 .jumbotron{
 	background-color: #fff;
 }
 
 #jp_container_2{
     background-image: url(${HOME}/resources/images/music-update.gif) ;
     background-repeat: no-repeat;
 }
.jp-interface{
	background-color: #fff;
}
</style>


<link href="${HOME}/resources/dist/skin/pink.flag/css/jplayer.pink.flag.css" rel="stylesheet" type="text/css" />
<!-- <script type="text/javascript" src="${HOME}/resources/lib/jquery.min.js"></script> -->
<script type="text/javascript" src="${HOME}/resources/dist/jplayer/jquery.jplayer.min.js"></script>
<script type="text/javascript" src="${HOME}/resources/dist/add-on/jplayer.playlist.min.js"></script>
<script type="text/javascript">
//<![CDATA[
$(document).ready(function(){


	new jPlayerPlaylist({
		jPlayer: "#jquery_jplayer_2",
		cssSelectorAncestor: "#jp_container_2"
	}, [
		
	<c:forEach items="${audioList }" var="row"  varStatus="status" >
		 {
			title:"${row.title }",
			mp3:"${HOME}/resources/mp3/${row.fullName }"
				
		}	
		<c:out  value="${   status.index < audioList.size()  ?  ',' : '' }"  />				
	 </c:forEach>
		
	], {
		swfPath: "../../dist/jplayer",
		supplied: "oga, mp3",
		wmode: "window",
		useStateClassSkin: true,
		autoBlur: false,
		smoothPlayBar: true,
		keyEnabled: true
	});
});
//]]>
</script>
</head>
<body>

	<%@ include file="include/header.jsp" %>
	<section class="header-banner"></section>
	<section class="main-v2-boards main-v2-section">
		<div class="container">
			<p>&nbsp;</p>
			<p>&nbsp;</p>
			<p>&nbsp;</p>
		</div>
	</section>




  
   	 
   	<div class="row text-center">
   	
	  <div class="col-md-12">
        <img src="${HOME}/resources/images/rabbit.png"  class="img-responsive center-block"/>
     </div>
    
     </div>		

 <div class="container">
<div id="jquery_jplayer_2" class="jp-jplayer"></div>
<div id="jp_container_2" class="jp-audio" role="application" aria-label="media player">
	<div class="jp-type-playlist" >
		<div class="jp-gui jp-interface" style="background-color:  rgba(255,255,255,0.01 );">
			<div class="jp-volume-controls">
				<button class="jp-mute" role="button" tabindex="0">mute</button>
				<button class="jp-volume-max" role="button" tabindex="0">max volume</button>
				<div class="jp-volume-bar">
					<div class="jp-volume-bar-value"></div>
				</div>
			</div>
			<div class="jp-controls-holder">
				<div class="jp-controls">
					<button class="jp-previous" role="button" tabindex="0">previous</button>
					<button class="jp-play" role="button" tabindex="0">play</button>
					<button class="jp-stop" role="button" tabindex="0">stop</button>
					<button class="jp-next" role="button" tabindex="0">next</button>
					<button class="jp-list" role="button" tabindex="0">list</button>
				</div>
				<div class="jp-progress">
					<div class="jp-seek-bar">
						<div class="jp-play-bar"></div>
					</div>
				</div>
				<div class="jp-current-time" role="timer" aria-label="time">&nbsp;</div>
				<div class="jp-duration" role="timer" aria-label="duration">&nbsp;</div>
				<div class="jp-toggles">
					<button class="jp-repeat" role="button" tabindex="0">repeat</button>
					<button class="jp-shuffle" role="button" tabindex="0">shuffle</button>
				</div>
			</div>
		</div>
		<div class="jp-playlist" style="display: none;">
			<ul>
				<li>&nbsp;</li>
			</ul>
		</div>
		<div class="jp-no-solution">
			<span>Update Required</span>
			To play the media you will need to either update your browser to a recent version or update your <a href="http://get.adobe.com/flashplayer/" target="_blank">Flash plugin</a>.
		</div>
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


</div>

	
	<%@ include file="./include/footer.jsp" %>
	
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script type="text/javascript">

		dateFormat();
		function dateFormat() {
			var moments = document.getElementsByClassName('moment');
			for (var i = 0; i < moments.length; ++i) {
				var item = moments[i];
				item.innerHTML = moment(item.textContent, "YYYY-MM-DD hh:mm:ss")
						.fromNow();
			}
		}
		
$(document).ready(function(){
	$(".jp-list").on("click", function(e){
		var display=$(".jp-playlist").css("display");
		if(display=="none"){			
			$(".jp-list").css("background", "url(${HOME}/resources/dist/skin/pink.flag/image/list-y.jpg)");
		}else{
			$(".jp-list").css("background", "url(${HOME}/resources/dist/skin/pink.flag/image/list-n.jpg)");
		}
		$(".jp-playlist").toggle("slow");

		
	});
	
	 <c:if test="${isMobile eq 1 }">
	 $(".jp-progress").css("margin-top" , "5px");
	$(".jp-progress").css("margin-left" , "80px");		
	 </c:if>
	
});	


</script>


</body>
</html>