package com.ssafy.test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBInsert {

   public static void main(String[] args) {
      Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try{
            // 1. 드라이버 로딩
            Class.forName("com.mysql.jdbc.Driver");

            // 2. 연결하기
            String url = "jdbc:mysql://localhost:3306/happyHouse?serverTimezone=UTC&useSSL=false&useUniCode=yes&characterEncoding=UTF-8";
            conn = DriverManager.getConnection(url, "root", "ssafy");


            // 3. 쿼리 수행을 위한 Statement 객체 생성
            stmt = conn.createStatement();

            // 4. SQL 쿼리 작성
            // 주의사항
            // 1) JDBC에서 쿼리를 작성할 때는 세미콜론(;)을 빼고 작성한다.
            // 2) SELECT 할 때 * 으로 모든 칼럼을 가져오는 것보다
            //   가져와야 할 칼럼을 직접 명시해주는 것이 좋다.
            // 3) 원하는 결과는 쿼리로써 마무리 짓고, java 코드로 후작업 하는 것은 권하지 않음
            // 4) 쿼리를 한 줄로 쓰기 어려운 경우 들여쓰기를 사용해도 되지만 띄어쓰기에 유의 !!
            String sql = "SELECT city, gugun, dong FROM dongcode";
            //String sql2 = "select count(*) from dongcode";


            // 5. 쿼리 수행
            // 레코드들은 ResultSet 객체에 추가된다.
            rs = stmt.executeQuery(sql);

            // 6. 실행결과 출력하기
            while(rs.next()){
                // 레코드의 칼럼은 배열과 달리 0부터 시작하지 않고 1부터 시작한다.
                // 데이터베이스에서 가져오는 데이터의 타입에 맞게 getString 또는 getInt 등을 호출한다.
               
               String city = rs.getString(1);
                String gugun = rs.getString(2);
                String dong = rs.getString(3);
                
                //System.out.println(city + " " + gugun + " " + dong);

                //sheltercnt
                PreparedStatement pstmt2 = null;
                ResultSet rs2 = null;
                
                String shelter = "SELECT count(dong) FROM shelter where dong=?";
                pstmt2 = conn.prepareStatement(shelter);
                pstmt2.setString(1, dong);
                rs2 = pstmt2.executeQuery();
                int sheltercnt = 0;
                while(rs2.next()) { 
                   sheltercnt = rs2.getInt(1);
             }
                
                //policeofficecnt
                PreparedStatement pstmt3 = null;
                ResultSet rs3 = null;
                
                String policeoffice = "SELECT count(dong) FROM policeoffice where dong=?";
                pstmt3 = conn.prepareStatement(policeoffice);
                pstmt3.setString(1, dong);
                rs3 = pstmt3.executeQuery();
                int policeofficecnt = 0;
                while(rs3.next()) { 
                   policeofficecnt = rs3.getInt(1);
             }
                
                //firestationcnt
                PreparedStatement pstmt4 = null;
                ResultSet rs4 = null;
                
                String firestation = "SELECT count(dong) FROM firestation where dong=?";
                pstmt4 = conn.prepareStatement(firestation);
                pstmt4.setString(1, dong);
                rs4 = pstmt4.executeQuery();
                int firestationcnt = 0;
                while(rs4.next()) { 
                   firestationcnt = rs4.getInt(1);
             }
                
                //safetycentercnt
                PreparedStatement pstmt5 = null;
                ResultSet rs5 = null;
                
                String safetycenter = "SELECT count(dong) FROM safetycenter where dong=?";
                pstmt5 = conn.prepareStatement(safetycenter);
                pstmt5.setString(1, dong);
                rs5 = pstmt5.executeQuery();
                int safetycentercnt = 0;
                while(rs5.next()) { 
                   safetycentercnt = rs5.getInt(1);
             }
                
                //safetybellcnt
                PreparedStatement pstmt6 = null;
                ResultSet rs6 = null;
                
                String safetybell = "SELECT count(dong) FROM safetybell where dong=?";
                pstmt5 = conn.prepareStatement(safetybell);
                pstmt5.setString(1, dong);
                rs6 = pstmt5.executeQuery();
                int safetybellcnt = 0;
                while(rs6.next()) { 
                   safetybellcnt = rs6.getInt(1);
             }
                
            /*
             * while(rs2.next()) { int sheltercnt = rs2.getInt(1);
             * System.out.println("dong: "+dong+" cnt:"+ sheltercnt); }
             */
                
                int totalcnt = sheltercnt + policeofficecnt + firestationcnt + safetycentercnt + safetybellcnt;
                //System.out.println(totalcnt);
                
                String type = null;
                if(totalcnt==0) type="red";
                else if(totalcnt==1) type="yellow";
                else if(totalcnt<=4) type="blue";
                else type="green";
                
                insert(city,gugun,dong,type,firestationcnt,policeofficecnt,sheltercnt,safetybellcnt, safetycentercnt, totalcnt);
                if( pstmt2 != null && !pstmt2.isClosed()){
                    pstmt2.close();
                }
                if( rs2 != null && !rs2.isClosed()){
                    rs2.close();
                }
                if( pstmt3 != null && !pstmt3.isClosed()){
                    pstmt3.close();
                }
                if( rs3 != null && !rs3.isClosed()){
                    rs3.close();
                }
                if( pstmt4 != null && !pstmt4.isClosed()){
                    pstmt4.close();
                }
                if( rs4 != null && !rs4.isClosed()){
                    rs4.close();
                }
                if( pstmt5 != null && !pstmt5.isClosed()){
                    pstmt5.close();
                }
                if( rs5 != null && !rs5.isClosed()){
                    rs5.close();
                }
                if( pstmt6 != null && !pstmt6.isClosed()){
                    pstmt6.close();
                }
                if( rs6 != null && !rs6.isClosed()){
                    rs6.close();
                }
            }
        }
        catch( ClassNotFoundException e){
            System.out.println("드라이버 로딩 실패");
        }
        catch( SQLException e){
            System.out.println("에러 " + e);
        }
        finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
                if( stmt != null && !stmt.isClosed()){
                    stmt.close();
                }
                if( rs != null && !rs.isClosed()){
                    rs.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }
      
      //insert("봄이", "victolee", "페르시안", 2, 3, 0,0,0,0);
   }

   public static void insert(String sido, String gugun, String dong, String type, int firestationcnt, int policeofficecnt, int sheltercnt, int safetybellcnt, int safetycentercnt, int totalcnt) {
      Connection conn = null;
      PreparedStatement pstmt = null;

      try {
// 1. 드라이버 로딩
         Class.forName("com.mysql.jdbc.Driver");

// 2. 연결하기
         String url = "jdbc:mysql://localhost:3306/happyHouse?serverTimezone=UTC&useSSL=false&useUniCode=yes&characterEncoding=UTF-8";
         conn = DriverManager.getConnection(url, "root", "ssafy");

// 3. SQL 쿼리 준비
// 추가하려는 데이터의 값은 전달된 인자를 통해 동적으로 할당되는 값이다.
// 즉 어떤 값이 전달될지 모르므로 Select 할 때와 달리
// stmt = conn.createStatement(); 를 작성하지 않고
// pstmt = conn.prepareStatement(sql); 로 작성하여 데이터를 추가할 것임을 알립니다.
// 물론 sql 쿼리 내에서 + 연산자로 한 줄로 작성할 수 있지만 가독성이 너무 떨어지게 되므로
// 이 방법을 권합니다.
         String sql = "INSERT INTO safelevel VALUES (?,?,?,?,?,?,?,?,?,?)";
         pstmt = conn.prepareStatement(sql);

// 4. 데이터 binding
         pstmt.setString(1, sido);
         pstmt.setString(2, gugun);
         pstmt.setString(3, dong);
         pstmt.setString(4,type);
         pstmt.setInt(5, firestationcnt);
         pstmt.setInt(6, policeofficecnt);
         pstmt.setInt(7, sheltercnt);
         pstmt.setInt(8, safetybellcnt);
         pstmt.setInt(9, safetycentercnt);
         pstmt.setInt(10, totalcnt);

// 5. 쿼리 실행 및 결과 처리
// SELECT와 달리 INSERT는 반환되는 데이터들이 없으므로
// ResultSet 객체가 필요 없고, 바로 pstmt.executeUpdate()메서드를 호출하면 됩니다.
// INSERT, UPDATE, DELETE 쿼리는 이와 같이 메서드를 호출하며
// SELECT에서는 stmt.executeQuery(sql); 메서드를 사용했었습니다.
// @return     int - 몇 개의 row가 영향을 미쳤는지를 반환
         int count = pstmt.executeUpdate();
         if (count == 0) {
            System.out.println("데이터 입력 실패");
         } else {
            //System.out.println("데이터 입력 성공");
         }
      } catch (ClassNotFoundException e) {
         System.out.println("드라이버 로딩 실패");
      } catch (SQLException e) {
         System.out.println("에러 " + e);
      } finally {
         try {
            if (conn != null && !conn.isClosed()) {
               conn.close();
            }
            if (pstmt != null && !pstmt.isClosed()) {
               pstmt.close();
            }
         } catch (SQLException e) {
            e.printStackTrace();
         }
      }
   }
}