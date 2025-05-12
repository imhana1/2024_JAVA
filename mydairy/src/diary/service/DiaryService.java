package diary.service;

import diary.dao.DiaryDao;
import diary.dto.DiaryDto;

import java.util.ArrayList;

public class DiaryService {
    //Dao 를 사용
    private DiaryDao dDao = new DiaryDao();

    // 일기 저장 기능 제공 메소드
    public String saveDiary(DiaryDto diary){
        String msg = null;

        // 파일에 diary 저장 : dao
        try {
            dDao.saveDiary(diary);
            msg = "저장 성공";
        } catch (Exception e) {
            msg = "저장 실패";
            // e.printStackTrace(); // 어디서 문제가 되는지 확인하는 메소드
        }

        return msg; // 저장 처리 성공 / 실패 메시지를 보낸다
    } // saveDiary end

    // 일기 목록을 가져오는 메소드
    public ArrayList<String> loadList(){
        ArrayList<String> dList = null;

        // 목록을 가져오는 작업 : dao
        dList = dDao.getList();

        return dList;
    }// load List end

    // 지정한 날짜의 일기 불러오는 메소드
    public DiaryDto loadDiary(String date){
        DiaryDto diary = null;

        // 해당 날짜(date)의 파일 내용을 불러오기 : dao
        try {
            diary = dDao.getDiary(date);
        } catch (Exception e) {
            //
        }

        return diary;
    }
}// class end
