package diary.service;

import diary.dao.DiaryDao;
import diary.dto.DiaryDto;

public class DiaryService {
    //Dao를 사용
    private DiaryDao dDao = new DiaryDao();

    //일기 저장 기능 제공 메소드
    public String saveDiary(DiaryDto diary){
        String msg = null;

        //파일에 diary 저장 : dao
        try {
            dDao.saveDiary(diary);
            msg = "저장 성공";
        } catch (Exception e) {
            msg = "저장 실패";
        }

        return msg;//저장 처리 성공/실패 메시지를 보낸다.
    }
}
