package phonebook.controller;

import phonebook.common.ComValue;
import phonebook.dto.PhoneDto;
import phonebook.service.PhoneService;
import phonebook.view.PhoneView;

import java.util.ArrayList;

public class PhoneController {
    //화면 처리용 부품 객체 사용.
    private PhoneView pv = new PhoneView();
    //서비스용 객체
    private PhoneService ps = new PhoneService();

    //메뉴용 상수
    private final int MAIN_MENU = 1;
    private final int SEARCH_MENU = 2;

    //전체 프로그램 제어
    public void run(){
        int menu = -1;//메뉴번호 저장 변수(초기값은 사용되지 않을 값으로)

        //타이틀 출력 -> 화면
        pv.viewTitle("연락처 프로그램");

        while (true){
            //메뉴 출력 및 메뉴 번호 입력 -> 화면
            menu = pv.showMenu(ComValue.MAIN_MENU);
            
            //종료 처리
            if(menu == 0){
                //메시지 출력(종료) -> 화면
                pv.prMsg("프로그램 종료");
                break;
            }//if end

            //나머지 메뉴 처리
            switch (menu){
                case 1:
                    //pv.prMsg("입력");
                    inputPhoneInfo();
                    break;
                case 2:
                   // pv.prMsg("출력");
                    outputPhoneList();
                    break;
                case 3:
                    //pv.prMsg("검색");
                    searchPhoneInfo();
                    break;
                case 4:
                    //pv.prMsg("수정");
                    updatePhoneInfo();
                    break;
                case 5:
                    //pv.prMsg("삭제");
                    deletePhoneInfo();
                    break;
                default:
                    pv.prMsg("0~5번까지만 입력하세요.");
            }
        }//while end
    }//run end
    // 한 클래스 내부에서만 사용되는 메소드의 경우도 private 로 작성
    private void inputPhoneInfo(){
        // 서브 타이틀 출력
        pv.viewTitle("연락처 입력");
        PhoneDto pInfo = new PhoneDto(); // 한 연락처 저장 공간(그릇)
        // 값들의 입력 처리 -> view 에서 처리
        pv.inputPhone(pInfo);
        // 연락처 저장 -> service
        String msg = ps.insertPhoneInfo(pInfo);
        // 메시지 출력 -> view
        pv.prMsg(msg);
    }// 입력 메소드 끝나는 부분 end

    private void outputPhoneList(){
        // 서브 타이틀 출력
        pv.viewTitle("연락처 출력");
        // 목록 가져오기 -> service
        ArrayList<PhoneDto> plist = ps.selectPhoneList();
        // 출력 작업은 view 에서 처리함
        pv.outputList(plist);
    }

    // 연락처 삭제
    private void deletePhoneInfo(){
        // 서브 타이틀 출력
        pv.viewTitle("연락처 삭제");

        if (ps.selectPhoneList().size() == 0){
            pv.prMsg("데이터가 없습니다.");
            return;
        }

        // 사용자로 부터 삭제할 연락처의 식별 번호를 입력
        int pno = pv.inputNumber("삭제할 연락처 번호 : ");

        // 일련 번호 기반으로 실제 삭제 처리 -> service
        String msg = ps.deletePhone(pno);
        // 메시지 출력
        pv.prMsg(msg);
    }//delete end
    public void searchPhoneInfo(){
        // 서브 메뉴 처리 == run 메소드와 같은 동작을 수행
        int subMenu = -1; // 서브메뉴 입력 값 저장

        // 서브 타이틀 출력
        pv.viewTitle("연락처 검색");

        // 데이터 유무 확인
        if (ps.selectPhoneList().size() == 0){
            pv.prMsg("데이터가 없습니다.");
            return;
        }

        // 서브 메뉴 동작 무한 루프
        while (true){
            subMenu = pv.showMenu(ComValue.SEARCH_MENU);

            // 서브 메뉴 종료
            if (subMenu == 0){
                pv.prMsg("상위 메뉴로 돌아갑니다.");
                return;
            }

            switch (subMenu){
                case 1: // 이름 검색
                    nameSearch();
                    break;
                case 2: // 연락처 검색
                    numberSearch();
                    break;
                case 3: // 생일 검색
                    birthSearch();
                    break;
                default:
                    pv.prMsg("0~3번 까지만 입력 하세요.");
            }
        }
    }// searchInfo end

    private void nameSearch(){
        // 서브 타이틀 출력
        pv.viewTitle("이름 검색");
        // 화면에서 검색 할 이름 키워드를 받아옴
        String keyword = pv.searchInput("이름 : ");
        // keyword 로 검색을 수행 -> service
        // 서비스는 검색한 연락처 목록을 가져온다
        ArrayList<PhoneDto> rList = ps.getNames(keyword);

        //결과 목록 출력
        pv.outputList(rList);
    } // nameSearch end

    private void numberSearch(){
        // 서브 타이틀 출력
        pv.viewTitle("연락처 검색");
        String keyword = pv.searchInput("연락처 : ");
        ArrayList<PhoneDto> rlist = ps.getnumber(keyword);

        pv.outputList(rlist);
    }

    private void birthSearch(){
        pv.viewTitle("생일 검색");
        String keyword = pv.searchInput("생일 : ");
        ArrayList<PhoneDto> bList = ps.getBirth(keyword);

        pv.outputList(bList);
    }

    private void updatePhoneInfo(){
        // 번호로 찾아서 수정(이름, 연락처, 주소, 생일)
        // 찾은 내용을 사용자에게 확인하게 함
        // 수정(삭제) = 키워드 검색 + 수정(삭제)

        pv.viewTitle("연락처 수정");

        if (ps.selectPhoneList().size() == 0) {
            pv.prMsg("데이터가 없습니다.");
            return;
        }

        int pno = pv.inputNumber("수정 할 연락처 번호 : ");

        // 검색한 번호로 개별 연락처 정보를 가져오는 처리 -> service 에서 함
        PhoneDto phone = ps.getPhoneInfo(pno);

        // 연락처를 출력하거나 '해당 연락처가 없습니다.' 라는 메시지를 출력.
        if (phone != null){
            pv.outputPhone(phone); // 개별 출력용 메소드
        } else {
            pv.prMsg("해당 연락처가 없습니다.");
            return; // 해당 연락처가 없으면 수정 작업 중단
        }

        pv.updateInput(phone);
        // 저장 (변경) -> service
        String msg = ps.updatePhone(phone, pno);

        pv.prMsg(msg);
    } // updatePhone(연락처 수정) end
}//class end

































