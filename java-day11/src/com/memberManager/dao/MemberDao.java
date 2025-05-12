package com.memberManager.dao;

import com.memberManager.dto.MemberDto;
import com.memberManager.view.MemberView;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MemberDao {
    //DB 연동에 필요한 정보
    private String drv = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/jdbc_db";
    private String user = "dev01";
    private String pass = "1234";

    //DB 연동에 필요한 객체(메모리를 사용하는 객체들)
    private Connection conn;
    private PreparedStatement pstmt;//SQL 실행 객체
    private ResultSet rs;

    //드라이버 로드 -> 최초에 한번만 수행 -> 생성자에서 처리
    public MemberDao(){
        try {
            Class.forName(drv);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }//생성자 end

    //close 접속(메모리 사용) 해제
    public void close(){
        try {
            if(rs != null) rs.close();
            if(pstmt != null) pstmt.close();
            if(conn != null) conn.close();
        } catch (SQLException e) {
            //비워둔다.
        }
    }

    public void insertMember(MemberDto member)
            throws SQLException{
        //SQL 쿼리문 작성
        String query = "insert into usertbl " +
                "values (?,?,?,?,?)";

        //접속 Connection
        conn = DriverManager.getConnection(url, user, pass);

        //실행 객체 PreparedStatement
        pstmt = conn.prepareStatement(query);

        //? 부분 채우기
        pstmt.setString(1, member.getUid());
        pstmt.setString(2, member.getUpass());
        pstmt.setString(3, member.getUname());
        pstmt.setInt(4, member.getUage());
        pstmt.setString(5, member.getUaddr());

        //쿼리문 실행
        pstmt.executeUpdate();//insert, update, delete
        //정상적으로 처리되지 않으면 SQLException이 발생 -> service로 넘어감
    }//insertMember end


    public List<MemberDto> getList() throws SQLException{
        List<MemberDto> mList = null;

        //쿼리문
        String query = "select * from usertbl";

        conn = DriverManager.getConnection(url, user, pass);
        pstmt = conn.prepareStatement(query);
        rs = pstmt.executeQuery();

        //ResultSet에 담긴 결과를 Dto 목록 담기(결과 처리)
        while (rs.next()){
            if(mList == null){//처음 데이터를 가져올 때만 실행
                mList = new ArrayList<>();
            }
            //한 회원을 담기위한 Dto 생성
            MemberDto member = new MemberDto();
            member.setUid(rs.getString(1));
            member.setUpass(rs.getString(2));
            member.setUname(rs.getString(3));
            member.setUage(rs.getInt(4));
            member.setUaddr(rs.getString(5));
            //dto -> list add
            mList.add(member);
        }//while end
        return mList;//null 이거나 목록이 저장되어 있거나.
    }//getList end

    public MemberDto selectMember(String searchId) throws SQLException {
        MemberDto member = null;

        String query = "select * from usertbl where uid = ?";

        conn = DriverManager.getConnection(url, user, pass);
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, searchId);
        rs = pstmt.executeQuery();

        //정보가 없거나, 하나거나.
        if(rs.next()){
            member = new MemberDto();
            member.setUid(rs.getString(1));
            member.setUpass(rs.getString(2));
            member.setUname(rs.getString(3));
            member.setUage(rs.getInt(4));
            member.setUaddr(rs.getString(5));
        }//if end

        return member;//null이거나 한명의 정보이거나.
    }//selectMember end

    public void updateMember(MemberDto member) throws SQLException{
        String query = "update usertbl set uname=?, uage=?, uaddr=? where uid=?";

        conn = DriverManager.getConnection(url, user, pass);
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, member.getUname());
        pstmt.setInt(2, member.getUage());
        pstmt.setString(3, member.getUaddr());
        pstmt.setString(4, member.getUid());

        pstmt.executeUpdate                                (); // insert, update, delete 공동 메소드
    }

    public void deleteMember(String uid) throws SQLException{
        String query = "delete from usertbl where uid=?";

        conn = DriverManager.getConnection(url, user, pass);
        pstmt = conn.prepareStatement(query);
        pstmt.setString(1, uid);

        pstmt.executeUpdate();
    }
}//class end
