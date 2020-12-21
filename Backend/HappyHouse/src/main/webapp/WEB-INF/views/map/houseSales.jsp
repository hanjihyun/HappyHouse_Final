<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
<c:if test="${cookie.ssafy_id.value ne null}">
	<c:set var="saveid" value="${cookie.ssafy_id.value}" />
	<c:set var="idck" value=" checked=\"checked\"" />
</c:if>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<div class="container-fluid">
	<form name="pageform" id="pageform" method="GET" action="">
		<input type="hidden" name="pg" id="pg" value=""> <input
			type="hidden" name="dongVal" id="dongVal" value="">
	</form>
	<section id="index_section">
	<h1>매매정보</h1>
		<div class="card col-sm-12 mt-1" style="min-height: 500px;">
			<input type="hidden" name="pg" id="pg" value="1">
			<div class="card-body">
				<script>
            let colorArr = ['table-primary','table-success','table-danger'];
            $(document).ready(function(){
               $.get("${root}/map/sido",
                     function(data, status){
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
                  $.get("${root}/map/gugun",
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
                  $.get("${root}/map/dong"
                        ,{gugun: $("#gugun").val()}
                        ,function(data, status){
                           $("#dong").empty();
                           $("#dong").append('<option value="0">선택</option>');
                           $.each(data, function(index, vo) {
                              $("#dong").append("<option value='"+vo.dong+"'>"+vo.dong+"</option>");
                           });//each
                        }//function
                        , "json"
                  );//get
               });//change
               $("#dong").change(function() {
                  $.get("${root}/map/apt"
                        ,{ dong: $("#dong").val(), pg: "1"}
                        ,function(data, status){
                           $("#searchResult").empty();
                           $('#navigator').empty();
                           $.each(data.list, function(index, vo) {
                              let str = "<tr>"
                              + "<td>" + vo.dong + "</td>"
                              + "<td><a href='${root}/map/detailHouse?no="+vo.no+"'>" + vo.aptName + "</a></td>"
                              + "<td>" + vo.dealAmount + "</td>"
                              + "<td>" + vo.buildYear + "</td>"
                              + "<td>" + vo.dealYear+"."+vo.dealMonth+"."+vo.dealDay + "</td>"
                              + "<td>" + vo.area + "</td>"
                              + "<td>" + vo.floor + "</td>"
                              + "</tr>";
                             //+ "</td><td id='lat_"+index+"'></td><td id='lng_"+index+"'></td></tr>";
                              $("#searchResult").append(str);
                           });//each
                           $('#navigator').append(data.navigation.navigator);
                           initMap();
                           geocode(data.list);
                        }//function
                        , "json"
                  );//get
               });//change
            });//ready
            function geocode(jsonData) {
               let idx = 0;
               $.each(jsonData, function(index, vo) {
                  let tmpLat;
                  let tmpLng;
                  $.get("https://maps.googleapis.com/maps/api/geocode/json"
                        ,{   key:'AIzaSyAlHVTvESmE7eyqhZB0Og89jjN-0iaNvQo'
                           , address:vo.dong+"+"+vo.aptName+"+"+vo.jibun
                        }
                        , function(data, status) {
                           //alert(data.results[0].geometry.location.lat);
                           tmpLat = data.results[0].geometry.location.lat;
                           tmpLng = data.results[0].geometry.location.lng;
                           $("#lat_"+index).text(tmpLat);
                           $("#lng_"+index).text(tmpLng);
                           addMarker(tmpLat, tmpLng, vo.aptName);
                        }
                        , "json"
                  );//get
               });//each
            }
     
            </script>

				<div>
					시도 : <select id="sido">
						<option value="0">선택</option>
					</select> 구군 : <select id="gugun">
						<option value="0">선택</option>
					</select> 읍면동 : <select id="dong">
						<option value="0">선택</option>
					</select>
				</div>

				<div class="row mt-5 ml-1 mr-1 p-1">
					<div id="map" style="width: 100%; height: 500px; margin: auto;"></div>
					<!--            <div id="map" style="height: 500px; width:100%;" class="col-md-7"></div>  -->
					<script
						src="https://unpkg.com/@google/markerclustererplus@4.0.1/dist/markerclustererplus.min.js"></script>
					<script defer
						src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAlHVTvESmE7eyqhZB0Og89jjN-0iaNvQo&callback=initMap"></script>
					<script>
               var multi = {lat: 37.5665734, lng: 126.978179};
               var map;
               function initMap() {
                  map = new google.maps.Map(document.getElementById('map'), {
                     center: multi, zoom: 12
                  });
//                   var marker = new google.maps.Marker({position: multi, map: map});
               }
            	   var image = "${root}/resources/assets/img/house2.png";
               function addMarker(tmpLat, tmpLng, aptName) {
                  var marker = new google.maps.Marker({
                     position: new google.maps.LatLng(parseFloat(tmpLat),parseFloat(tmpLng)),
                     label: aptName,
                     title: aptName,
                     icon:image
                  });
                  marker.addListener('click', function() {
                     map.setZoom(17);
                     map.setCenter(marker.getPosition());
                     callHouseDealInfo();
                  });
                  marker.setMap(map);
               }
               function callHouseDealInfo() {
                  alert("you can call HouseDealInfo");
               }
            </script>
				</div>

				<table
					class="table mt-2 table-striped table-bordered table-hover col">
					<thead class="thead-dark">

						<tr>
							<th>동</th>
							<th>아파트이름</th>
							<th>거래금액</th>
							<th>건축년도</th>
							<th>거래일자</th>
							<th>평수</th>
							<th>층</th>
						</tr>
					</thead>
					<tbody id="searchResult">
					</tbody>
				</table>
			</div>

			<table align="center">
				<tr>
					<td id="navigator"></td>
				</tr>
			</table>
		</div>
	</section>
</div>
<script type="text/javascript">
      $(function(){
//     	  $('#searchKey option[value=${searchKey}]').prop('selected', 'selected').change();
         $("#searchBtn").click(function(){
            if ($("#searchWord").val() == "" && $("#searchKey").val() != "all" ) {
               alert("검색어를 입력하세요");
               return false;
            }
           if ($("#searchWord").val() == "" && $("#searchKey").val() == "all" ) {
             location.href="${root}/map/houseSales";
          }
            $("#searchForm").submit();

         });
     
      });
      function pageMove(pg) { 
          document.getElementById("pg").value=pg;
		      $.get("${root}/map/apt"
		              ,{ dong: $("#dong").val(), pg: $("#pg").val()}
		              ,function(data, status){
		                 $("#searchResult").empty();
		                 $('#navigator').empty();
		                 $.each(data.list, function(index, vo) {
		                    let str = "<tr>"
		                    + "<td>" + vo.dong + "</td>"
		                    + "<td><a href='${root}/map/detailHouse?no="+vo.no+"'>" + vo.aptName + "</a></td>"
		                    + "<td>" + vo.dealAmount + "</td>"
		                    + "<td>" + vo.buildYear + "</td>"
		                    + "<td>" + vo.dealYear+"."+vo.dealMonth+"."+vo.dealDay + "</td>"
		                    + "<td>" + vo.area + "</td>"
		                    + "<td>" + vo.floor + "</td>"
		                    + "</tr>";
		                   //+ "</td><td id='lat_"+index+"'></td><td id='lng_"+index+"'></td></tr>";
		                    $("#searchResult").append(str);
		                 });//each
		                 $('#navigator').append(data.navigation.navigator);
		                 initMap();
		                 geocode(data.list);
		              }//function
		              , "json"
		        );//get
      }

    
   </script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />