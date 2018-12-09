<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    
<c:choose>
 <c:when test="${ empty sessionScope.USER }">
 
  
<div id="boardComment" class="panel-footer board board-view-comment" >
          <h5 style="margin-bottom:0">댓글</h5>
       
       <form action="/recommendation/replies/create" method="post" id="boardCommentForm" >


              <p>
      <input id="submitbtn" class="form-control tooltipstered" minlength="1" maxlength="500" required aria-required="true" 
               name="content" type="text"  placeholder="댓글을 입력해주세요 (최대 500자)" />
             </p>
           
  
<p><input id="clicktoshow1" class="hidden form-control tooltipstered" minlength="1" maxlength="10" required="" 
aria-required="true" style="float:left; margin-bottom:25px; 
width:48%; height:40px; border: 1px solid #d9d9de" name="rNickname"  type="text" placeholder="닉네임 (최대 10자)"></p>
<p><input id="clicktoshow2" class="hidden form-control tooltipstered" 
minlength="4" maxlength="4" required="" aria-required="true" 
style="ime-mode:inactive; float:right; margin-bottom:25px; width:48%; height:40px; border: 1px solid #d9d9de" 
name="rPw" type="password"  placeholder="비밀번호 (4자)"  ></p>                  
     
              
              <input id="clicktoshow3" class="button form-control tooltipstered hidden"  type="button" value="댓글 쓰기">
              <input type="hidden" name="bno">               	                       
          </form>
      </div> 
                
 </c:when>
 <c:otherwise>
 
 <div id="boardComment" class="panel-footer board board-view-comment">
       <h5 style="margin-bottom:0">댓글</h5>  
                     
       <form action="/recommendation/replies/create" method="post" id="boardCommentForm">
  
       <p><input id="submitbtn" class="form-control tooltipstered" minlength="1" maxlength="500" required
       aria-required="true"
       name="content" type="text"  placeholder="댓글을 입력해주세요 (최대 500자)"   ></input>
       </p>                    
     
       <p>
       <input disabled id="clicktoshow1" value="${sessionScope.USER.nickname }"  class="hidden form-control tooltipstered" 
       minlength="1" maxlength="10" required aria-required="true"  name="rnickname" type="text"   placeholder="닉네임 (최대 10자)"/>               
       </p>                        
                                        
<input id="clicktoshow3" class="button form-control tooltipstered hidden" type="button" value="댓글 쓰기">
<p><input type="hidden" name="bno"> 

</p>

                    	 
   </form>
       
</div>
          
 
 
 
 </c:otherwise>
</c:choose>    
