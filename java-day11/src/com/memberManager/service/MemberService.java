package com.memberManager.service;

import com.memberManager.dao.MemberDao;
import com.memberManager.dto.MemberDto;
import java.sql.SQLException;
import java.util.List;

public class MemberService {
    //Dao 객체
    private MemberDao mDao = new MemberDao();

    //회원 정보 저장 메소드
    public String inputMember(MemberDto member) {
        //DB 처리 결과 메시지 저장 변수
        String msg = null;

        //Dao의 insert 메소드를 사용해서 정보를 저장.
        try {
            mDao.insertMember(member);
            msg = "저장 성공";
        } catch (SQLException e) {
            msg = "저장 실패";
            //e.printStackTrace();
        } finally {
            mDao.close();
        }

        return msg;
    }

    public List<MemberDto> getList() {
        //Dao의 테이블 내용을 받아오는 메소드 실행.
        List<MemberDto> mList = null;

        try {
            mList = mDao.getList();
        } catch (SQLException e) {
            //비워둠.
        } finally {
            mDao.close();
        }

        return mList;
    }

    public MemberDto getMember(String searchId) {
        MemberDto member = null;

        try {
            member = mDao.selectMember(searchId);
        } catch (SQLException e) {

        } finally {
            mDao.close();
        }

        return member;
    }

    public String updateMember(MemberDto member) {
        String msg = null;

        try {
            mDao.updateMember(member);
            msg = "수정 성공";
        } catch (SQLException e) {
            msg = "수정 실패";
            e.printStackTrace();
        } finally {
            mDao.close();
        }
        return msg;
    }

    public String deleteMember(String uid) {
        String msg = null;

        try {
            mDao.deleteMember(uid);
            msg = "삭제 성공";
        } catch (SQLException e) {
            msg = "삭제 실패";
        } finally {
            mDao.close();
        }
        return msg;
    }
}//class end
