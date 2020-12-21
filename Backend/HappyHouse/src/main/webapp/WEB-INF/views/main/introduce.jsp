<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    

  <jsp:include page="/WEB-INF/views/common/header.jsp" />

    <!-- ======= main ======= -->
    <main id="main">
     <section id="about" class="about">
      <div class="container">

        <div class="row">
          <div class="col-xl-6 col-lg-6 video-box d-flex justify-content-center align-items-stretch" data-aos="zoom-in">
            <a href="https://www.youtube.com/watch?v=jDDaplaOz7Q" class="venobox play-btn mb-4" data-vbtype="video" data-autoplay="true"></a>
          </div>

          <div class="col-xl-6 col-lg-6 d-flex flex-column align-items-stretch justify-content-center py-5 px-lg-5">
            <div class="box-heading" data-aos="fade-up">
              <h4>About us</h4>
              <h3>HappyHouse를 소개합니다.</h3>
              <p><strong>안전한</strong> 아파트 매매정보를 제공하는 HappyHouse</p>
            </div>

            <div class="icon-box" data-aos="fade-up" data-aos-delay="100">
              <div class="icon"><i class="bx bx-gift"></i></div>
              <h4 class="title"><a href="">매매정보</a></h4>
              <p class="description">아파트 매매정보를 지도로 시,구군,동으로 선택하여 확인할 수 있습니다</p>
            </div>
            
            <div class="icon-box" data-aos="fade-up">
              <div class="icon"><i class="bx bx-fingerprint"></i></div>
              <h4 class="title"><a href="">CCTV 위치, 영상 제공</a></h4>
              <p class="description">CCTV위치를 지도상에서 확인할 수 있습니다.</p>
              <p class="description"> 도로 CCTV영상을 확인할 수 있습니다.</p>
            </div>

            <div class="icon-box" data-aos="fade-up" data-aos-delay="200">
              <div class="icon"><i class="bx bx-atom"></i></div>
              <h4 class="title"><a href="">게시판</a></h4>
              <p class="description">공지사항을 확인할 수 있습니다.</p>
              <p class="description">Q&A를 통해 질문을 할 수 있습니다.</p>
            </div>

          </div>
        </div>

      </div>
    </section><!-- End About Section -->
    </main><!-- End #main -->

  <jsp:include page="/WEB-INF/views/common/footer.jsp" />
  

