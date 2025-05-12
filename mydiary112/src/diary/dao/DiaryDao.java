package diary.dao;

import diary.dto.DiaryDto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DiaryDao {
    //파일명을 날짜정보로 처리.
    private Calendar cal = null;
    private String path = "data";

    public void saveDiary(DiaryDto diary) throws Exception{
        //예외사항는 service에서 처리(넘김)
        File folder = new File(path);
        if(!folder.isDirectory()){//폴더가 없으면,
            folder.mkdir();//폴더 생성
        }

        //파일명 생성(날짜로)
        cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int date = cal.get(Calendar.DATE);
        String fname = "%d%02d%02d.txt".formatted(year, month, date);

        File file = new File(path + "\\" + fname);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        String str = diary.getWeather() + "\n" + diary.getContent();
        bw.write(str);
        bw.flush();

        bw.close();
        fw.close();
    }
}
