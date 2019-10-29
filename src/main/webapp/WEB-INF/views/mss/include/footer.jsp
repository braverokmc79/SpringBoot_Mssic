<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<footer class="navbar" 	style="margin-bottom: 0; border-radius: 0px; border: 0px;">
		<div class="footer-v2">
			<div class="container">
				<p class="footer-v2-title">MSSIC </p>
				<p class="footer-v2-tips">Copyright ⓒ 2018 MSSIC </p>
				<p class="footer-v2-tips">
					All Rights Reserved.
				</p>
				<p class="footer-v2-tips">무료음악 스트리밍 사이트
			</div>
		</div>
	</footer>



		<script src="${HOME}/resources/mss/js/bootstrap.js"></script>
		<script src="${HOME}/resources/mss/js/bootstrap.min.js"></script>
		<script src="${HOME}/resources/mss/js/menu.js"></script>
		<script src="${HOME}/resources/mss/js/hr.js"></script>
		<script src="${HOME}/resources/mss/js/waves.js"></script>
		<script src="${HOME}/resources/mss/js/summernote.min.js"></script>
		<script src="${HOME}/resources/mss/js/summernote.js"></script>
		<script src="${HOME}/resources/mss/js/summernote-lite.js"></script>
		<script src="${HOME}/resources/mss/js/summernote-bs4.min.js"></script>
		<script src="${HOME}/resources/mss/js/summernote-bs4.js"></script>
		<script src="${HOME}/resources/mss/js/d3.v3.min.js"></script>
		<script src="${HOME}/resources/mss/js/jquery.cookie.min.js"></script>			
		<script src="${HOME}/resources/mss/js/spectrum.js"></script>



  <script>
    $( document ).ready( function() {
      $( window ).scroll( function() {
        if ( $( this ).scrollTop() > 200 ) {
          $( '.top' ).fadeIn();
        } else {
         // $( '.top' ).fadeOut();
        }
      } );
      $( '.top' ).click( function() {
        $( 'html, body' ).animate( { scrollTop : 0 }, 400 );
        return false;
      } );
    } );
  </script>
	
	