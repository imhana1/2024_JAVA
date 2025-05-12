package diary.dao;

import diary.dto.DiaryDto;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

public class DiaryDao {
    // 파일명에 날짜 정보 넣는 처리
    private Calendar cal = null;
    private String path = "data";

    public void saveDiary(DiaryDto diary) throws Exception{
        // 예외 사항 처리는 service 에서 처리하도록 넘김
        File folder = new File(path);
        if (folder.isDirectory()){ // 폴더가 없으면,
            folder.mkdir(); // 폴더 생성
        }

        // 파일명 생성 (날짜로)
        cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int date = cal.get(Calendar.DATE);
        int hour = cal.get(Calendar.HOUR_OF_DAY); // 24 시간
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);

        String fname = "%d%02d%02d-%02d%02d%02d.txt"
                .formatted(year, month, date,
                        hour, minute, second);

        File file = new File(path + "\\" + fname);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        String str = diary.getWeather() + "\n" + diary.getContent();
        bw.write(str);
        bw.flush();

        bw.close();
        fw.close();
    }// saveDiary end

    // 파일 목록을 가져오는 메소드
    public ArrayList<String> getList(){
        File folder = new File(path);
        ArrayList<String> dList = null;

        if (folder.exists()){
            dList = new ArrayList<>();
            File[] list = folder.listFiles();

            if (list.length == 0){
                // 폴더는 있으나 파일은 없을 때
                dList = null;
                return dList;
            }

            for(File f : list){
                String fname = f.getName();
                // 'xxx.txt' 에서 '.txt' 만 제거
                fname = fname.substring(0, fname.lastIndexOf(".txt"));
                dList.add(fname);
            } // for end
        } //if end

        return dList; // dList 는 null 이거나 파일명 목록이 된다
    } // getList end

    // 파일 내용 읽어오는 메소드
    public DiaryDto getDiary(String date)throws Exception{
        DiaryDto diary = new DiaryDto();

        String fname = path + "\\" + date + ".txt";
        File file = new File(fname);

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String str = null;
        String content = "";
        while((str = br.readLine()) != null){
            // 날씨 저장 먼저
            if (diary.getWeather() == null){
                diary.setWeather(str);
            } else {
                content += str + "\n";
            }
        } // while 문 end
        diary.setContent(content);

        return diary;
    }
} // class end
