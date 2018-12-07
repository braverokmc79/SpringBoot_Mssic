<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
			<div class="container">
				<div class="row">
					<div class="span12">
						<div class="widget widget-nopad">
							<div class="widget-header">
							</div>
							<!-- /widget-header -->
							<div class="widget-content">
								<div class="widget big-stats-container">
									<div class="widget-content">
										<h3 class="bigstats" style="text-align:center; margin-top: 30px;">
											
										</h3>
										<div id="big_stats" class="cf" style="height: 300px;">
											<div class="stat">
												<span class="value"></span>
											</div>
										
										</div>
									</div>
									<!-- /widget-content -->

								</div>
							</div>
						</div>
						<!-- /widget -->
		
					</div>
	
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /main-inner -->
	</div>
		

<c:import url="include/footer.jsp"/>

</body>
</html>