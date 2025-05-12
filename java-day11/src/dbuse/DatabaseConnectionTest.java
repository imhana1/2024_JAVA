package dbuse;

import java.sql.*;

public class DatabaseConnectionTest {
    public static void main(String[] args) {
        Connection conn = null;//접속 처리 및 관리
        Statement stmt = null;//SQL 문장(쿼리문) 실행 객체
        ResultSet rs = null;//select 문 결과 저장 객체

        try {
            //1. 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 로드 성공");

            //2. 접속 수립
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/jdbc_db",
                    "dev01",
                    "1234"
            );
            System.out.println("접속 성공");

            //3. SQL 실행
            //실행할 SQL 문장 작성
            String query = "select * from testtbl";
            //실행 객체 생성 - connection이 만들어 줌.
            stmt = conn.createStatement();

            //쿼리문 실행 - statement
            rs = stmt.executeQuery(query);

            //3-1. 결과 처리
            while (rs.next()){//next() : 결과를 한 행씩 가져오고, 없으면 false
                System.out.println(rs.getInt(1));//rs.getInt("tcode")
                System.out.println(rs.getString("tname"));
                System.out.println(rs.getInt(3));
                System.out.println(rs.getString(4));
                System.out.println("------------------------------------");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("드라이버 로드 실패");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("접속 실패");
        } finally {
            //4. close 작업
            try {
                conn.close();
            } catch (SQLException e) {
                //여기에는 아무것도 작성하지 않는다.
            }
        }
    }
}
