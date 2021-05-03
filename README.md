# 🏘️HappyHouse

### 여성, 노인, 어린이가 있는 가정을 대상으로 한 안전하고 합리적인 내 집 구하기

## HappyHouse 소개

- 범죄가 늘어나는 요즘 안전한 지역에 집을 구하고 싶은 사람들을 위한 사이트
- 자기 기준에서 안전하고 합리적인 내집 마련
- 여성, 노인, 어린이가 있는 가정을 잠재적 대상으로 한 사이트
- 다양한 안전지역을 확인할 수 있는 카테고리 제공

## 🗓️개발 기간

### 2020.11.19 ~ 2020.11.26 (8 days)

![%F0%9F%8F%98%EF%B8%8FHappyHouse%20419df846d41848e6978e43395aa4386f/Untitled.png](%F0%9F%8F%98%EF%B8%8FHappyHouse%20419df846d41848e6978e43395aa4386f/Untitled.png)

## 🔧**Tech Stack**

![%F0%9F%8F%98%EF%B8%8FHappyHouse%20419df846d41848e6978e43395aa4386f/Untitled%201.png](%F0%9F%8F%98%EF%B8%8FHappyHouse%20419df846d41848e6978e43395aa4386f/Untitled%201.png)

- Spring Boot(Backend / Frontend) - 2.1.4 version
- Vue.js(Frontend 일부 -  Q&A 게시판) - 2.6.12 version
- Mysql
- Google developers(Google map)
- 공공데이터 포털(아파트 주택 매매정보)
- 국토교통부(CCTV영상 데이터 & 위치)
- 생활안전지도(대피소, 소방서, 경찰서, 안전비상벨, 안전센터 데이터)

## 📊ERD Diagram

---

![%F0%9F%8F%98%EF%B8%8FHappyHouse%20419df846d41848e6978e43395aa4386f.png](%F0%9F%8F%98%EF%B8%8FHappyHouse%20419df846d41848e6978e43395aa4386f.png)

## 📊Usecase Diagram

---

![%F0%9F%8F%98%EF%B8%8FHappyHouse%20419df846d41848e6978e43395aa4386f/Untitled%202.png](%F0%9F%8F%98%EF%B8%8FHappyHouse%20419df846d41848e6978e43395aa4386f/Untitled%202.png)

## 🏷️HappyHouse 기본기능

- 날씨 제공 - 네이버 날씨 데이터
- 부동산 실시간 뉴스 제공 - 네이버 부동산 뉴스 데이터
- 회원 관리
- 로그인 / 로그아웃
- 회원가입, 비밀번호 찾기시 이메일 인증 서비스 제공
- 회원 정보 수정 서비스 제공
- 회원 탈퇴 서비스 제공
- 게시판
- 매매정보 : 공공데이터의 아파트 매매정보, 위치 정보 제공
- Q&A : 사이트에 관한 Q&A 서비스 제공

    - 공지사항 : 사이트 공지 제공

## 🏷️HappyHouse 주요기능

### 회원가입/ 로그인

- 소셜 로그인 (구글)
- 회원가입/ 비밀번호 변경 시 이메일을 통한 인증

![%F0%9F%8F%98%EF%B8%8FHappyHouse%20419df846d41848e6978e43395aa4386f/Untitled%203.png](%F0%9F%8F%98%EF%B8%8FHappyHouse%20419df846d41848e6978e43395aa4386f/Untitled%203.png)

![%F0%9F%8F%98%EF%B8%8FHappyHouse%20419df846d41848e6978e43395aa4386f/Untitled%204.png](%F0%9F%8F%98%EF%B8%8FHappyHouse%20419df846d41848e6978e43395aa4386f/Untitled%204.png)

![%F0%9F%8F%98%EF%B8%8FHappyHouse%20419df846d41848e6978e43395aa4386f/Untitled%205.png](%F0%9F%8F%98%EF%B8%8FHappyHouse%20419df846d41848e6978e43395aa4386f/Untitled%205.png)

### 부동산 매매 정보

- 지역별 부동산 매매 정보 제공

![%F0%9F%8F%98%EF%B8%8FHappyHouse%20419df846d41848e6978e43395aa4386f/_(1).png](%F0%9F%8F%98%EF%B8%8FHappyHouse%20419df846d41848e6978e43395aa4386f/_(1).png)

### CCTV 설치 지역

- CCTV 설치 위치 제공 (google map)

![%F0%9F%8F%98%EF%B8%8FHappyHouse%20419df846d41848e6978e43395aa4386f/Untitled%206.png](%F0%9F%8F%98%EF%B8%8FHappyHouse%20419df846d41848e6978e43395aa4386f/Untitled%206.png)

- CCTV 영상 제공 (국토교통부 API)
    - 해당 위치의 씨씨티비 영상 정보 제공

![%F0%9F%8F%98%EF%B8%8FHappyHouse%20419df846d41848e6978e43395aa4386f/Untitled%207.png](%F0%9F%8F%98%EF%B8%8FHappyHouse%20419df846d41848e6978e43395aa4386f/Untitled%207.png)

### 안전 지역

- 안전 관련 데이터 통계를 통한 등급 표시
    - 동단위로 선택할 수 있으며 색으로 알아보기 쉽게 등급 표시
    - 지도 위 표시 되는 아이콘의 빨간색은 위험, 노란색은 경고, 파란색은 주의 , 초록색은 안전 단계

![%F0%9F%8F%98%EF%B8%8FHappyHouse%20419df846d41848e6978e43395aa4386f/Untitled%208.png](%F0%9F%8F%98%EF%B8%8FHappyHouse%20419df846d41848e6978e43395aa4386f/Untitled%208.png)

## 🙂팀원 소개

![%F0%9F%8F%98%EF%B8%8FHappyHouse%20419df846d41848e6978e43395aa4386f/Untitled%209.png](%F0%9F%8F%98%EF%B8%8FHappyHouse%20419df846d41848e6978e43395aa4386f/Untitled%209.png)
