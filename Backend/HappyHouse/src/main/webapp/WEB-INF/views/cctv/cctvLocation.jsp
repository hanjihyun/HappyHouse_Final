<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
<c:if test="${cookie.ssafy_id.value ne null}">
   <c:set var="saveid" value="${cookie.ssafy_id.value}" />
   <c:set var="idck" value=" checked=\"checked\"" />
</c:if>
<jsp:include page="/WEB-INF/views/common/header.jsp" />
<style>
video {
   position: relative;
   top: 100%;
   transform: translateY(0%);
}
</style>
<div class="container-fluid">
<form name="pageform" id="pageform" method="GET" action="">
		<input type="hidden" name="pg" id="pg" value=""> 
		<input type="hidden" name="dongVal" id="dongVal" value="">
	</form>
   <section id="index_section">
   <h1>CCTV 설치된 지역</h1>
      <div class="card col-sm-12 mt-1" style="min-height: 850px;">
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
                  $.get("${root}/cctv/location"
                        ,{ dong: $("#dong").val(),pg: "1"}
                        ,function(data, status){
                           $("#searchResult").empty();
                           $('#navigator').empty();
                           var multi;
                           $.each(data.list, function(index, vo) {
                              multi = {lat: parseFloat(vo.lat), lng: parseFloat(vo.lng)};
                              let str = "<tr>"
                              + "<td>" + vo.dong +" "+ vo.jibun+"</td>"
//                               + "<td><a href='${root}/map/detailHouse?no="+vo.no+"'>" + vo.jibun + "</a></td>"
                              + "<td>" + vo.installdate + "</td>"
                              + "<td>" + vo.storeday + "</td>"
                              + "<td>" + vo.lastdate + "</td>"
                              + "</tr>";
                             //+ "</td><td id='lat_"+index+"'></td><td id='lng_"+index+"'></td></tr>";
                              $("#searchResult").append(str);
                           });//each
                           $('#navigator').append(data.navigation.navigator);
                           //initMap();
                           mapChange(multi,16);
                           geocode(data.list);
                        }//function
                        , "json"
                  );//get
               });//change
            });//ready
            function geocode(jsonData) {
               let idx = 0;
               $.each(jsonData, function(index, vo) {
//                   console.log("index" +index )
                  let tmpLat;
                  let tmpLng;
                  $.get("https://maps.googleapis.com/maps/api/geocode/json"
                        ,{   key:'AIzaSyAlHVTvESmE7eyqhZB0Og89jjN-0iaNvQo'
                           , address:vo.dong+"+"+vo.jibun
                        }
                        , function(data, status) {
                           //alert(data.results[0].geometry.location.lat);
                           tmpLat = data.results[0].geometry.location.lat;
                           tmpLng = data.results[0].geometry.location.lng;
                           $("#lat_"+index).text(tmpLat);
                           $("#lng_"+index).text(tmpLng);
                           if(vo.jibun != null){
                              addMarker(tmpLat, tmpLng, vo.jibun);
                           }else{
                             addMarker(vo.lat, vo.lng, vo.jibun);
                           }
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

            <div id="cctvMV" class="modal" style="display: none; z-index: 2;">

               <form class="modal-content animate" id="cctvForm" name="cctvForm"
                  action="" method="post" style="width: 40%;">

                  <div class="imgcontainer">
                     <span
                        onclick="document.getElementById('cctvMV').style.display='none'"
                        class="close" title="Close Modal">&times;&nbsp;&nbsp;</span>
                     <br> <br>

<!--                      <video oncontextmenu="return false;" id="myVideo" width="640" -->
<!--                         align="center" controls autoplay> -->

<%--                         <source src="${root }/resource/img/mvi.mp4" type="video/mp4"> --%>

<!--                      </video> -->
                  </div>

               </form>
            </div>
            <!-- cctv모달  끝 -->
            <div class="row mt-5 ml-1 mr-1 p-1">
                <div id="map" style="width: 100%; height: 500px; margin: auto;"></div>
<!--                <div id="map" style="height: 500px;" class="col-md-7"></div> -->
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
               function mapChange(multi,zoom) {
                   map = new google.maps.Map(document.getElementById('map'), {
                      center: multi, zoom: zoom
                   });
                   //var marker = new google.maps.Marker({position: multi, map: map});
                }
                  var image = "${root}/resources/assets/img/cctvMark.png";
               function addMarker(tmpLat, tmpLng, jibun) {
                  var marker = new google.maps.Marker({
                     position: new google.maps.LatLng(parseFloat(tmpLat),parseFloat(tmpLng)),
                     label: jibun,
                     title: jibun,
                     icon:image
                  });
                  marker.addListener('click', function() {
                     map.setZoom(17);
                     map.setCenter(marker.getPosition());
//                      document.getElementById('cctvMV').style.display='block';
//                      callHouseDealInfo();
                  });
                  marker.setMap(map);
               }
               function callHouseDealInfo() {
                  alert("you can call CCTV Location");
               }
            </script>
     
               <table
                  class="table mt-2 table-striped table-bordered table-hover col">
                  <thead class="thead-dark">
                     <tr>
                        <th>소재지주소</th>
                        <th>설치날짜</th>
                        <th>보관일자</th>
                        <th>기준일자</th>
                     </tr>
                  </thead>
                  <tbody id="searchResult">
                  </tbody>
               </table>
            </div>
         </div>
	<table align="center">
		<tr>
			<td id="navigator"></td>
		</tr>
	</table>
      </div>
   </section>
</div>
<script>
function pageMove(pg) { 
    document.getElementById("pg").value=pg;
    $.get("${root}/cctv/location"
            ,{ dong: $("#dong").val(),pg: $("#pg").val()}
            ,function(data, status){
               $("#searchResult").empty();
               $('#navigator').empty();
               var multi;
               $.each(data.list, function(index, vo) {
                   multi = {lat: parseFloat(vo.lat), lng: parseFloat(vo.lng)};
                   let str = "<tr>"
                   + "<td>" + vo.dong +" "+ vo.jibun+"</td>"
//                    + "<td><a href='${root}/map/detailHouse?no="+vo.no+"'>" + vo.jibun + "</a></td>"
                   + "<td>" + vo.installdate + "</td>"
                   + "<td>" + vo.storeday + "</td>"
                   + "<td>" + vo.lastdate + "</td>"
                   + "</tr>";
                  //+ "</td><td id='lat_"+index+"'></td><td id='lng_"+index+"'></td></tr>";
                   $("#searchResult").append(str);
                });//each
               $('#navigator').append(data.navigation.navigator);
               //initMap();
               mapChange(multi,16);
               geocode(data.list);
            }//function
            , "json"
      );//get
}
</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />