<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<c:set var="root" value="${pageContext.request.contextPath }" />
  <jsp:include page="/WEB-INF/views/common/header.jsp" />

    <!-- ======= main ======= -->
    <main id="main">
        <!-- ======= Contact Section ======= -->
        <section id="contact" class="contact">
            <div class="container">
                <h1> 상세 페이지 </h1>
<%--                  <input type="hidden" value="${detailForm.no }" id = "detailNo" /> --%>
                <table class="table" border="1">
                    <tr>
                        <td rowspan="8" width="300px">
                            <img src="${root }/resources/img/건양하늘터.jpg" alt="">
                        </td>
                    </tr>
                     <tr>
                        <td class="atr"><strong>동</strong></td>
                        <td>${detailForm.dong }</td>
                        
                    </tr>
                    <tr>
                        <td class="atr"><strong>아파트명</strong></td>
                        <td>${detailForm.aptName }</td>
                    </tr>
                    <tr>
                        <td class="atr"><strong>거래금액</strong></td>
                        <td>${detailForm.dealAmount }</td>
                    </tr>
           
                    <tr> 
                        <td class="atr"><strong>건축연도</strong></td>
                        <td>${detailForm.buildYear }</td>
                    </tr>
                    <tr>
                        <td class="atr"><strong>전용면적</strong></td>
                        <td>${detailForm.area }</td>
                    </tr>
                    <tr>
                        <td class="atr"><strong>거래일</strong></td>
                        <td>${detailForm.dealYear }-${detailForm.dealMonth }-${detailForm.dealDay }</td>
                    </tr>
                    <tr>
                        <td class="atr"><strong>층</strong></td>
                        <td>${detailForm.floor }</td>
                    </tr>
            
                </table>
			<div class="row" >
				<div class="col"></div>
				<div class="col-xl-6">
					<button id="cancelbtn" class="cancelbtn btn-secondary">뒤로가기</button>
					<button id="signupbtn" class="signupbtn btn-secondary">관심매물 등록</button>
				</div>
			<div class="col"></div>
			</div>
            </div>
        </section><!-- End Contact Section -->

    </main><!-- End #main -->
 <script type="text/javascript">
			$(function(){
				$("#cancelbtn").click(function(){
					location.href="${root}/map/houseSales";
				});
				$("#signupbtn").click(function(){
					location.href="${root}/fav/searchDetail?no="+${detailForm.no };
				});
			});
</script>   
  <jsp:include page="/WEB-INF/views/common/footer.jsp" />

