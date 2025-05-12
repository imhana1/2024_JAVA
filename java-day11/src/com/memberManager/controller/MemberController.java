package com.memberManager.controller;

import com.memberManager.dto.MemberDto;
import com.memberManager.service.MemberService;
import com.memberManager.view.MemberView;

import java.util.List;

public class MemberController {
    //화면 처리용 객체
    private MemberView mView = new MemberView();
    //서비스 객체
    private MemberService mServ = new MemberService();

    //프로그램 전체 제어용 메소드
    public void run(){
        //메뉴 번호 저장 변수
        int m = -1;

        //타이틀 출력(view 클래스 메소드 사용)
        mView.viewTitle("회원 관리 프로그램");

        while (true){//종료 명령 전까지 무한 반복
            //메뉴 출력과 메뉴 번호 입력 -> view 메소드
            m = mView.showMenu(1);

            //종료 처리(사용자가 0을 입력)
            if(m == 0){
                //종료 메시지 출력(view의 메소드 사용)
                mView.prMsg("프로그램 종료");
                //메소드 종료
                return;
            }

            //나머지 메뉴 처리
            switch (m){
                case 1://회원 정보 입력
                    inputMember();
                    break;
                case 2://회원 정보 출력
                    outputMember();
                    break;
                case 3://회원 정보 검색
                    searchMember();
                    break;
                default:
                    mView.prMsg("0~3번까지만 입력하세요.");
            }
        }
    }

    private void searchMember() {
        //서브 타이틀 출력
        mView.viewTitle("회원 정보 검색");

        //검색 키워드 입력받아서
        String searchId = mView.getSearch("ID : ");

        //서비스에 검색 키워드 넘기고 결과 받기
        MemberDto member = mServ.getMember(searchId);

        //view로 검색 결과 출력
        if(member != null){
            mView.outputMember(member);
        }
        else {
            mView.prMsg("검색한 회원이 없습니다.");
            return;//여기서 메소드 종료.
        }

        updateDelete(member);
    }

    private void updateDelete(MemberDto member) {
        int sm = -1;

        while (true) {
            //하위 메뉴 출력
            sm = mView.showMenu(2);

            if(sm == 0){
                mView.prMsg("이전 메뉴로 돌아갑니다.");
                return;
            }
            //수정 또는 삭제 분기.
            switch (sm){
                case 1://수정
                    updateMember(member);
                    break;
                case 2://삭제
                    deleteMember(member.getUid());
                    break;
                default:
                    mView.prMsg("0~2번까지만 입력하세요.");
            }
        }
    }

    private void deleteMember(String uid) {
        //삭제 여부 확인(view)
        String yn = mView.getSearch("삭제할까요?(y/n) ");

        //서비스에 아이디 넘겨서 삭제 처리 후 결과 보고
        yn = yn.toLowerCase();//소문자로 변환. toUpperCase() - 대문자로 변환

        String msg = null;
        if(yn.equals("y")){
            //삭제 진행
            msg = mServ.deleteMember(uid);
        }
        else {
            msg = "삭제를 취소합니다.";
        }
        mView.prMsg(msg);
    }

    private void updateMember(MemberDto member) {
        //수정할 정보를 입력받아서 서비스로 넘기고
        mView.updateMember(member);
        //서비스로부터 처리 결과를 받아 뷰로 출력.
        String msg = mServ.updateMember(member);
        mView.prMsg(msg);
    }

    private void outputMember() {
        //서브 타이틀 출력
        mView.viewTitle("회원 정보 출력");

        //서비스로부터 회원 목록(List) 받기
        List<MemberDto> mList = mServ.getList();

        //회원 목록을 view로 출력
        if(mList != null){
            mView.outputList(mList);
        }
        else {
            mView.prMsg("저장된 회원이 없습니다.");
        }
    }

    private void inputMember() {
        //서브 타이틀 출력
        mView.viewTitle("회원 정보 입력");
        //회원 정보 저장 객체 생성
        MemberDto member = new MemberDto();
        //회원 정보 입력(view 메소드)
        mView.inputMember(member);
        //서비스에 회원정보 전달 및 결과 받기
        String msg = mServ.inputMember(member);
        //결과 출력(view 메소드)
        mView.prMsg(msg);
    }
}//class end
