package com.memberManager.view;

import com.memberManager.dto.MemberDto;
import java.util.List;

public class MemberView {
    //모니터 출력 및 키보드 입력 처리 객체
    private InOutClass ioc = new InOutClass();

    //타이틀 출력 메소드
    public void viewTitle(String title) {
        ioc.tlPrint("----------------------");
        ioc.tlPrint("<< " + title + " >>");
        ioc.tlPrint("----------------------");
    }

    //메뉴 출력 메소드(메인메뉴, 서브메뉴 모두 처리)
    public int showMenu(int cNum) {
        //cNum에 들어오는 값에 따라 메인과 서브 선택 출력.
        int menu = -1;//입력한 메뉴번호 저장 변수

        ioc.tlPrint("");//메뉴 출력전 한줄 띄어쓰기
        ioc.tlPrint("메뉴>");

        switch (cNum){
            case 1://메인 메뉴 출력
                ioc.tlPrint("1. 회원 정보 입력");
                ioc.tlPrint("2. 회원 정보 출력");
                ioc.tlPrint("3. 회원 정보 검색");
                ioc.tlPrint("0. 프로그램 종료");
                break;
            case 2://검색 후 서브 메뉴 출력
                ioc.tlPrint("1. 회원 정보 수정");
                ioc.tlPrint("2. 회원 정보 삭제");
                ioc.tlPrint("0. 이전 메뉴");
                break;
        }
        //메뉴번호 입력받기
        menu = ioc.inNum("선택> ");

        return menu;//입력받은 메뉴 번호를 컨트롤러로 전달.
    }

    //메시지 출력용 메소드
    public void prMsg(String msg) {
        ioc.tlPrint(msg);
    }

    public void inputMember(MemberDto member) {
        member.setUid(ioc.inStr("ID : "));
        member.setUpass(ioc.inStr("PASS : "));
        member.setUname(ioc.inStr("NAME : "));
        member.setUage(ioc.inNum("AGE : "));
        member.setUaddr(ioc.inStr("ADDRESS : "));
    }

    public void outputList(List<MemberDto> mList) {
        for(MemberDto m : mList){
            ioc.tlPrint(m.toString());
            ioc.tlPrint("----------------------");
        }
    }

    public String getSearch(String s) {
        String keyword = ioc.inStr(s);
        ioc.tlPrint("---------------------");
        return keyword;
    }

    public void outputMember(MemberDto member) {
        ioc.tlPrint(member.toString());
        ioc.tlPrint("---------------------");
    }

    public void updateMember(MemberDto member) {
        String str = null;//각 수정 항목의 값을 받는 임시 변수
        int inValue = -1;//나이 입력값 저장 변수

        str = ioc.inStr("NAME : ");
        if(!str.equals("")){//입력한 내용이 있으면.
            member.setUname(str);
        }
        inValue = ioc.inNum("AGE : ");
        if(inValue > -1){
            member.setUage(inValue);
        }
        str = ioc.inStr("ADDRESS : ");
        if(!str.equals("")){
            member.setUaddr(str);
        }
    }
}//class end
