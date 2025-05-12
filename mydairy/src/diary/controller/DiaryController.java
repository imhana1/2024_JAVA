package diary.controller;

import diary.dto.DiaryDto;
import diary.service.DiaryService;
import diary.view.DiaryView;

import java.util.ArrayList;

public class DiaryController {
    // view 와 service 를 사용하는 클래스
    private DiaryView dView = new DiaryView();
    private DiaryService dServ = new DiaryService();

     public void run(){
         // 전체 프로그램 제어 메소드
         int menu = -1;

         // 타이틀 출력 : View
        dView.showTitle("일기장");

        // 프로그램 무한 루프 처리
         while (true){
             // 메뉴 출력 및 번호 받기 : view
             menu = dView.showMenu();

             // 종료 처리
             if (menu == 0){
                 // 메시지 출력 : view
                 dView.prMsg("프로그램 종료");
                 break; // while 종료 (프로그램 종료)
             }

             // 나머지 메뉴 및 잘못된 입력 처리
             switch (menu){
                 case 1: // 일기 작성
                     saveDiary();
                     break;
                 case 2: // 일기 불러오기
                     loadDiary();
                     break;
                 case 3: // 일기 수정
                     break;
                 case 4: // 일기 삭제
                     break;
                 default:
                     dView.prMsg("0 ~ 4 번 까지만 입력하세요.");
             }
         } // while end
     } // run end

    private void loadDiary() {
         // 서브 타이틀 출력
        dView.showTitle(" < 일기 불러오기 > ");

        // 일기 목록 가져오기 : service
        ArrayList<String> dList = dServ.loadList();
        if (dList == null){
            dView.prMsg("저장된 일기 없음");
        } else {
            // 목록 출력하기 : view
            dView.outputList(dList);
        }
        // 읽어올 날짜를 입력 받아서(view) 파일 내용을 불러오기 (service)
        String date = dView.inputDate(" 불러올 날짜 :  ");

        // 입력한 날짜의 파일 내용 불러오기(service)
        DiaryDto diary = dServ.loadDiary(date);

        if (diary == null){
            dView.prMsg("해당 날짜의 일기가 없습니다.");
        } else {
            // 일기 내용 출력 : view
            dView.outputDiary(diary);
        }
    } // loadDiary end

    private void saveDiary() {
         // 서브 타이틀 출력
        dView.showTitle(" < 일기 작성하기 > ");

        // 일기 내용 작성 : view
        DiaryDto diary = new DiaryDto();
        dView.inputDiary(diary);

        // 입력 받은 일기를 파일로 저장 : service -> dao
        String msg = dServ.saveDiary(diary);

        // 넘어온 메시지를 출력 : view
        dView.prMsg(msg);
    }
} // class end
