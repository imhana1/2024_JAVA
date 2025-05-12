package diary.view;

import diary.dto.DiaryDto;

import java.util.ArrayList;

public class DiaryView {
    // 타이틀 출력, 메뉴 출력, 각 입력 처리 메소드 작성
    private InOutClass ioc = new InOutClass();

    // 타이틀 출력 메소드
    public void showTitle(String title){
        ioc.tlPrint("======================");
        ioc.tlPrint("<< " + title + " >>");
        ioc.tlPrint("======================");
    }

    // 메뉴 출력 및 번호 받기 : view
    public int showMenu(){
        ioc.tlPrint("메뉴 > ");
        ioc.tlPrint("1. 일기 작성하기");
        ioc.tlPrint("2. 일기 불러오기");
        ioc.tlPrint("3. 일기 수정하기");
        ioc.tlPrint("4. 일기 삭제하기");
        ioc.tlPrint("0. 종료");

        int menu = ioc.inNum("입력 : ");
        return menu;
    }

    // 메시지 출력 메소드
    public void prMsg(String msg){
        ioc.tlPrint(msg);
    }

    // 일기 내용 입력 메소드
    public void inputDiary(DiaryDto diary){
        diary.setWeather(ioc.inStr("날씨 : "));
        diary.setContent(ioc.inMultiLine(" < 내용 > "));
    }// inputDiary end

    // 일기 목록 출력 메소드
    public void outputList(ArrayList<String> dList){
        for (String s : dList){
            ioc.tlPrint(s);
        }
        ioc.tlPrint("======================");
    }

    // 불러올 날짜 입력 메소드 (불러오기, 수정하기, 삭제하기에서 모두 사용)
    public String inputDate(String comment){
        String date = ioc.inStr(comment);
        ioc.tlPrint("======================");
        return date;
    }// inputDate end

    public void outputDiary(DiaryDto diary){
        ioc.tlPrint(diary.toString());
        ioc.tlPrint("======================");
    }
} // class end
