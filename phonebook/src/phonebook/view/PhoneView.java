package phonebook.view;

import phonebook.dto.PhoneDto;

import java.util.ArrayList;

public class PhoneView {
    //입력과 출력 관련 작업용 클래스
    //InOutClass를 활용하여 프로그램에 맞는 입력과 출력을 처리
    //InOutClass로부터 받은 입력값은 controller에 전달
    //controller로부터 받은 출력값을 InOutClass로 전달

    private InOutClass ioc = new InOutClass();

    //타이틀 출력용 메소드(메인 타이틀, 서브 타이틀)
    public void viewTitle(String title){
        ioc.tlPrint("---------------------------");
        ioc.tlPrint("<< " + title + " >>");
        ioc.tlPrint("---------------------------");
    }

    //메뉴 출력 및 메뉴 번호 입력
    public int showMenu(int cNum){
        int m = -1;

        ioc.tlPrint("");//메뉴 출력전에 한줄 띄기
        ioc.tlPrint("메뉴>");

        //메인 메뉴와 서브 메뉴를 switch로 분류 사용
        switch (cNum){
            case 1: //메인 메뉴 출력
                ioc.tlPrint("1. 연락처 입력");
                ioc.tlPrint("2. 연락처 출력");
                ioc.tlPrint("3. 연락처 검색");
                ioc.tlPrint("4. 연락처 수정");
                ioc.tlPrint("5. 연락처 삭제");
                ioc.tlPrint("0. 프로그램 종료");
                break;
            case 2: //검색 메뉴 출력
                ioc.tlPrint("1. 이름 검색");
                ioc.tlPrint("2. 연락처 검색");
                ioc.tlPrint("3. 생일 검색");
                ioc.tlPrint("0. 돌아가기");
                break;
        }//switch end

        m = ioc.inNum("선택> ");

        return m;
    }//method end

    //메시지 출력용 메소드
    public void prMsg(String message){
        ioc.tlPrint(message);
    }

    // 연락처 입력용 메소드
    public void inputPhone(PhoneDto phone){
        phone.setPname(ioc.inStr("이름 : "));
        phone.setPnumber(ioc.inStr("연락처 : "));
        phone.setPaddr(ioc.inStr("주소 : "));
        phone.setPbirth(ioc.inStr("생일 : "));
        // 인스턴스를 받은 경우 return할 필요 없음
        // 파라미터가 객체(인스턴스)인 경우
        // 인스턴스의 주소가 넘어온다
    }// inputPhone end

    public void outputList(ArrayList<PhoneDto> pList){
        // 저장된 데이터의 유무 확인
        if(pList.size() == 0) {
            prMsg("출력할 연락처가 없습니다.");
            return;
        }

        for (PhoneDto p : pList){
            ioc.tlPrint(p.toString());
            ioc.tlPrint("-------------------------");
        }
    }// outputList end


    // 수정, 삭제 시 연락처 일련번호를 입력 받는 메소드
    public int inputNumber(String str) {
        int num = ioc.inNum(str);
        return num;
    }

    public String searchInput(String comment) {
        String keyword = ioc.inStr(comment);
        ioc.tlPrint("---------------------");
        return keyword;
    }

    public void outputPhone(PhoneDto phone) {
        ioc.tlPrint(phone.toString());
        ioc.tlPrint("---------------------");
    }

    public void updateInput(PhoneDto phone) {
        // 변경 할 데이터는 입력, 변경 할 데이터가 없을 경우 엔터기로 넘김
        viewTitle("수정 데이터 입력");
        prMsg("변경하지 않을 데이터는 엔터키를 입력하세요");
        String str = null;

        // 변경 할 이름 입력
        str = ioc.inStr("이름 : ");
        if (str != ""){ // 새 데이터를 입력한 경우
            phone.setPname(str);
        } // 엔터키로 넘어가면 기존 데이터를 남김
        // 연락처 입력
        str = ioc.inStr("연락처 : ");
        if (str != ""){
            phone.setPnumber(str);
        }
        // 주소 입력
        str = ioc.inStr("주소 : ");
        if (str != ""){
            phone.setPaddr(str);
        }
        // 생일 입력
        str = ioc.inStr("생일 : ");
        if (str != ""){
            phone.setPbirth(str);
        }
    }
}//class end
































