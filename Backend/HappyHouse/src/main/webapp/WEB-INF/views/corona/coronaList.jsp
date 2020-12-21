<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<c:set var="root" value="${pageContext.request.contextPath }" />
  <jsp:include page="/WEB-INF/views/common/header.jsp" />
  
   <div class="container-fluid">
      <section id="index_section">
      <h1>코로나 선별 진료소 및 국가 안심병원</h1>
	  <div class="row"></div>
			<div class="card col-sm-12 mt-1" style="min-height: 850px;">
				<div class="card-body">
			<script>
            let colorArr = ['table-primary','table-success','table-danger'];
            $(document).ready(function(){
               $.get("${root}/corona/sido"
                  ,function(data, status){
                     $.each(data, function(index, vo) {
                        $("#sido").append("<option value='"+vo.sido_code+"'>"+vo.sido_name+"</option>");
                     });//each
                  }//function
                  , "json"
               );//get
            });//ready
            $(document).ready(function(){
               $("#sido").change(function() {
            	   let sido  = $("#sido").val();
                  $.get("${root}/corona/gugun",
                		  { sido: $("#sido").val()}
                        ,function(data, status){
                           $("#gugun").empty();
                           $("#gugun").append('<option value="0">선택</option>');
                           $.each(data, function(index, vo) {
                              $("#gugun").append("<option value='"+vo.gugun_code+"'>"+vo.gugun_name+"</option>");
                           });//each
                        }//function
                        , "json"
                  );//get
               });//change
               $("#gugun").change(function() {
            	   let gugun  = $("#gugun").val();
            	   $.get("${root}/corona/hospital"
            			   ,{gugun: $("#gugun").val()}
                           ,function(data, status){
                              $("#hospital").empty();
                              $.each(data, function(index, vo) {
                                 let str = "<tr>"
                                 + "<td>" + vo.basicDate + "</td>"
                                 + "<td>" + vo.sido + "</td>"
                                 + "<td>" + vo.gugun + "</td>"
                                 + "<td>" + vo.hospitalName + "</td>"
                                 + "<td>" + vo.address + "</td>"
                                 + "<td>" + vo.type + "</td>"
                                 + "<td>" + vo.phone + "</td>"
                                 + "</tr>";
                                 $("#hospital").append(str);
                              });//each
                              //$("tbody").append("<tr><td colspan='7'>${navigation.navigator}</td></tr>");
                           }//function
                           , "json"
                     );//get
                     
                     $.get("${root}/corona/medicalCenter"
                    		 ,{gugun: $("#gugun").val()}
                             ,function(data, status){
                                $("#medicalCenter").empty();
                                $.each(data, function(index, vo) {
                                   let str = "<tr>"
                                  	 + "<td>" + vo.basicDate + "</td>"
                                  	 + "<td>" + vo.availability + "</td>"
                                    + "<td>" + vo.sido + "</td>"
                                    + "<td>" + vo.gugun + "</td>"
                                    + "<td>" + vo.hospitalName + "</td>"
                                    + "<td>" + vo.address + "</td>"
                                    + "<td>" + vo.operationTime + "</td>"
                                    + "<td>" + vo.phone + "</td>"
                                    + "</tr>";
                                   $("#medicalCenter").append(str);
                                });//each
                                //$("tbody").append("<tr><td colspan='7'>${navigation.navigator}</td></tr>");
                             }//function
                             , "json"
                       );//get
               });//change
               $("#dong").change(function() {
                 
               });//change
            });//ready
          
			</script>
					<div>
						시도 : <select id="sido">
							<option value="0">선택</option>
						</select>
						 구군 : <select id="gugun">
							<option value="0">선택</option>
						</select>
					</div>
					<div>
					<div class="row">
					<h1 class="col">국민 안심 병원</h1>
					<h1 class="col">선별 진료소</h1>
					</div>
					<div class="row mt-5 ml-1 mr-1 p-1">
						
						<table class="table mt-2 table-striped table-bordered table-hover col-md-6">
							
							<thead class="thead-dark">
								<tr>
									<th>기준일</th>
									<th>시도</th>
									<th>구군</th>
									<th>기관명</th>
									<th>주소</th>
									<th>신청유형</th>
									<th>전화번호</th>
								</tr>
							</thead>
							<tbody id="hospital">
							</tbody>
						</table>
						
						
						<table class="table mt-2 table-striped table-bordered table-hover col-md-6">
							
							<thead class="thead-dark">
								<tr>
									<th>기준일</th>
									<th>검체채취가능여부</th>
									<th>시도</th>
									<th>구군</th>
									<th>기관명</th>
									<th>주소</th>
									<th>운영시간</th>
									<th>전화번호</th>
								</tr>
							</thead>
							<tbody id="medicalCenter">
							</tbody>
						</table>
						
					</div>
					</div>
				</div>
			</div>

			<%--	============ 페이저 =============
		 	<table>
				<tr>
					<td>${alpa.navigator}</td>
				</tr>
			</table> 
			--%>
			
		</section>
   </div>
  <jsp:include page="/WEB-INF/views/common/footer.jsp" />