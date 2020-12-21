<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
<c:if test="${cookie.ssafy_id.value ne null}">
   <c:set var="saveid" value="${cookie.ssafy_id.value}"/>
   <c:set var="idck" value=" checked=\"checked\""/>
</c:if>
  <jsp:include page="/WEB-INF/views/common/header.jsp" />
   <div class="container-fluid">
      
      <section id="index_section">
      <h1>안전지역 통계</h1>
         <div class="card col-sm-12 mt-1" style="min-height: 850px;">
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
                  $.get("${root}/safety/type"
                        ,{ dong: $("#dong").val()}
                        ,function(data, status){
                          
                        }//function
                        , "json"
                  );//get
               });//change
               
              $("#type").change(function() {
                  var type = $("#type").val();
                  if(type=="shelter")
                  {
                     $.get("${root}/safety/shelter"
                               ,{ type: $("#type").val(),
                                  dong: $("#dong").val()}
                               ,function(data, status){
                                  $("#searchResult").empty();
                                  var multi;
                                  $.each(data, function(index, vo) {
                                     multi = {lat: parseFloat(vo.lat), lng: parseFloat(vo.lng)};
                                  });//each
                                  console.log("multi: "+multi.lat+" "+multi.lng);
                                  if(data.length!=0){
                                     mapChange(multi,15);
                                      geocode(data);
                                  }else{
                                     alert("검색 결과 0건입니다.");
                                     initMap();
                                  }
                               }//function
                               , "json"
                         );//get
                  }else if(type=="policeOffice"){
                     $.get("${root}/safety/policeOffice"
                               ,{ type: $("#type").val(),
                                  dong: $("#dong").val()}
                               ,function(data, status){
                                  $("#searchResult").empty();
                                  var multi;
                                  $.each(data, function(index, vo) {
                                     multi = {lat: parseFloat(vo.lat), lng: parseFloat(vo.lng)};
                                  });//each
                                  if(data.length!=0){
                                     mapChange(multi,15);
                                      geocode(data);
                                  }else{
                                     alert("검색 결과 0건입니다.");
                                     initMap();
                                  }
                               }//function
                               , "json"
                         );//get
                  }else if(type=="safetyBell"){
                     $.get("${root}/safety/safetyBell"
                               ,{ type: $("#type").val(),
                                  dong: $("#dong").val()}
                               ,function(data, status){
                                  $("#searchResult").empty();
                                  var multi;
                                  $.each(data, function(index, vo) {
                                     multi = {lat: parseFloat(vo.lat), lng: parseFloat(vo.lng)};
                                  });//each
                                  if(data.length!=0){
                                     mapChange(multi,15);
                                      geocode(data);
                                  }else{
                                     alert("검색 결과 0건입니다.");
                                     initMap();
                                  }
                               }//function
                               , "json"
                         );//get
                  }else if(type=="fireStation"){
                     $.get("${root}/safety/fireStation"
                               ,{ type: $("#type").val(),
                                  dong: $("#dong").val()}
                               ,function(data, status){
                                  $("#searchResult").empty();
                                  var multi;
                                  $.each(data, function(index, vo) {
                                     multi = {lat: parseFloat(vo.lat), lng: parseFloat(vo.lng)};
                                  });//each
                                  if(data.length!=0){
                                     console.log("multi: "+multi.lat+" "+multi.lng);
                                     mapChange(multi,15);
                                      geocode(data);
                                  }else{
                                     alert("검색 결과 0건입니다.");
                                     initMap();
                                  }
                                  
                               }//function
                               , "json"
                         );//get
                  }else if(type=="safetyCenter"){
                     $.get("${root}/safety/safetyCenter"
                               ,{ type: $("#type").val(),
                                  dong: $("#dong").val()}
                               ,function(data, status){
                                  $("#searchResult").empty();
                                  var multi;
                                  $.each(data, function(index, vo) {
                                     multi = {lat: parseFloat(vo.lat), lng: parseFloat(vo.lng)};
                                  });//each
                                  if(data.length!=0){
                                     mapChange(multi,15);
                                      geocode(data);
                                  }else{
                                     alert("검색 결과 0건입니다.");
                                     initMap();
                                  }
                               }//function
                               , "json"
                         );//get
                  }else if(type=="level"){
                     $.get("${root}/safety/level"
                              ,{ type: $("#type").val(),
                                 dong: $("#dong").val()}
                              ,function(data, status){
                                 $("#searchResult").empty();
                                 $.each(data, function(index, vo) {
                                    $("#level").val(vo.type);
                                 });//each
                                 geocodeLevel(data);
                                 console.log(data);
                              }//function
                              , "json"
                        );//get
                  }
                   
                });//change
            });//ready
            function geocode(jsonData) {
               let idx = 0;
               $.each(jsonData, function(index, vo) {
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
                           //$("#lat_"+index).text(tmpLat);
                           //$("#lng_"+index).text(tmpLng);
                           addMarker(tmpLat, tmpLng);
                        }
                        , "json"
                  );//get
               });//each
            }
            function geocodeNum(jsonData) {
                let idx = 0;
                $.each(jsonData, function(index, vo) {
                   let tmpLat;
                   let tmpLng;
                   $.get("https://maps.googleapis.com/maps/api/geocode/json"
                         ,{   key:'AIzaSyAlHVTvESmE7eyqhZB0Og89jjN-0iaNvQo'
                            , address:vo.dong+"+"+vo.lat+"+"+vo.lng
                         }
                         , function(data, status) {
                            //alert(data.results[0].geometry.location.lat);
                            tmpLat = vo.lat;
                            tmpLng = vo.lng;
                            //$("#lat_"+index).text(tmpLat);
                            //$("#lng_"+index).text(tmpLng);
                            //console.log(vo.type);
                            addMarker(tmpLat, tmpLng);
                         }
                         , "json"
                   );//get
                });//each
             }
            function geocodeLevel(jsonData) {
                let idx = 0;
                $.each(jsonData, function(index, vo) {
                   let tmpLat;
                   let tmpLng;
                   $.get("https://maps.googleapis.com/maps/api/geocode/json"
                         ,{   key:'AIzaSyAlHVTvESmE7eyqhZB0Og89jjN-0iaNvQo'
                            , address:vo.dong,
                            type: vo.type,
                         }
                         , function(data, status) {
                            //alert(data.results[0].geometry.location.lat);
                            tmpLat = data.results[0].geometry.location.lat;
                            tmpLng = data.results[0].geometry.location.lng;
                            //$("#lat_"+index).text(tmpLat);
                            //$("#lng_"+index).text(tmpLng);
                            var multi = {lat: parseFloat(tmpLat), lng: parseFloat(tmpLng)};
                      mapChange(multi,15);
                            addMarkerLevel(tmpLat, tmpLng);
                         }
                         , "json"
                   );//get
                });//each
             }
            function pageMove(pg) { 
             document.getElementById("pg").value=pg;
             document.getElementById("pageform").action = "${root}/map?act=apt";
             document.getElementById("pageform").submit();
          }
            </script>

            <div>
               시도 : <select id="sido">
                  <option value="0">선택</option>
               </select> 
               구군 : <select id="gugun">
                  <option value="0">선택</option>
               </select> 
               읍면동 : <select id="dong">
                  <option value="0">선택</option>
               </select> 
               안전정보 : <select id="type">
                  <option value="0">선택</option>
                  <option value="level">등급</option>
                  <option value="shelter">대피소</option>
                  <option value="fireStation">소방서</option>
                  <option value="safetyBell">안전비상벨</option>
                  <option value="policeOffice">경찰서</option>
                  <option value="safetyCenter">안전센터</option>
               </select>
               <input type="hidden" id="level"></input>
              <!-- <button class="btn btn-secondary" id="selectBtn" style="margin-top: -10px;">확인</button> --> 
            </div>

            <div class="row mt-5 ml-1 mr-1 p-1">
            <div id="map" style="width: 100%; height: 700px; margin: auto;"></div>
<!--            <div id="map" style="height: 500px;" class="col-md-7"></div>  -->
           <script src="https://unpkg.com/@google/markerclustererplus@4.0.1/dist/markerclustererplus.min.js"></script>
           <script defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAlHVTvESmE7eyqhZB0Og89jjN-0iaNvQo&callback=initMap"></script>
           <script>
               
               var map;
               function initMap() {
                 var multi = {lat: 37.5665734, lng: 126.978179};
                  map = new google.maps.Map(document.getElementById('map'), {
                     center: multi, zoom: 12
                  });
                  //var marker = new google.maps.Marker({position: multi, map: map});
               }
               function mapChange(multi,zoom) {
                   map = new google.maps.Map(document.getElementById('map'), {
                      center: multi, zoom: zoom
                   });
                   //var marker = new google.maps.Marker({position: multi, map: map});
                }
                  //var image = "${root}/resources/img/safety.png";
               function addMarker(tmpLat, tmpLng) {
                  var image = "${root}/resources/assets/img/"+$("#type").val()+".png";

                  var marker = new google.maps.Marker({
                     position: new google.maps.LatLng(parseFloat(tmpLat),parseFloat(tmpLng)),
//                     label: aptName,
//                     title: aptName,
                     icon: image
                     
                  });
                  console.log(tmpLat+" "+tmpLng);
                  marker.addListener('click', function() {
                     map.setZoom(17);
                     map.setCenter(marker.getPosition());
                     //callHouseDealInfo();
                  });
                  marker.setMap(map);
               }
               function addMarkerLevel(tmpLat, tmpLng) {
                   var image = "${root}/resources/assets/img/"+$("#level").val()+".png";

                   var marker = new google.maps.Marker({
                      position: new google.maps.LatLng(parseFloat(tmpLat),parseFloat(tmpLng)),
//                      label: aptName,
//                      title: aptName,
                      icon: image
                      
                   });
                   //console.log(tmpLat+" "+tmpLng);
                   marker.addListener('click', function() {
                      map.setZoom(17);
                      map.setCenter(marker.getPosition());
                      //callHouseDealInfo();
                   });
                   marker.setMap(map);
                }
               function callHouseDealInfo() {
                  alert("you can call HouseDealInfo");
               }
/*               $(document).ready(function(){
                  $("#selectBtn").click(function(){
                     if($("#sido").val()==0||$("#gugun").val()==0||$("#dong").val()==0||$("#type").val()==0){
                        alert("모든 항목을 선택해 주세요");
                        return;
                     }else{
                        
                     }
                  });
               })
               */
            </script>
            <!-- ============== 페이저 ===========
            <form name="pageform" id="pageform" method="GET" action="">
            <input type="hidden" name="act" id="act" value="list">
            <input type="hidden" name="pg" id="pg" value="">
            <input type="hidden" name="dong" id="dong" value="">
         </form> 
         -->
           <%-- <table class="table mt-2 table-striped table-bordered table-hover col-md-5">
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
            </table>   --%>
            </div>
            </div>
         </div>
         
      <%--   ============ 페이저 =============
          <table>
            <tr>
               <td>${alpa.navigator}</td>
            </tr>
         </table> 
         --%>
         
      </section>
   </div>

  <jsp:include page="/WEB-INF/views/common/footer.jsp" />