package fileInfopk;

import java.io.File;
import java.io.IOException;

public class FileInfoTest {
    public static void main(String[] args) {
        //파일 객체 생성(메모리)
        File file = new File("test\\test.txt");

        //하드디스크에 파일 생성 - createNewFile()
        //파일 생성 성공 시 - true, 같은 이름의 파일이 존재하면 false.
        try {
            boolean b = file.createNewFile();
            if(b){
                System.out.println("파일 생성 성공.");
            }else {
                System.out.println("이미 파일이 존재합니다.");
            }
        } catch (IOException e){
            //e.printStackTrace();//예외사항 출력
            //콘솔 프로그램에서는 사용하지 말자.
            System.out.println("파일 생성 실패.");
        }//try catch end

        //파일 존재 여부 및 파일/폴더 구분
        File file2 = new File("test");
        System.out.println("파일인가?" + file2.isFile());
        System.out.println("폴더인가?" + file2.isDirectory());

        //파일이 존재하지 않으면 생성.
        File file3 = new File("test2.txt");
        if(!file3.isFile()){
            try {
                file3.createNewFile();
            } catch (IOException e) {
                System.out.println("파일 생성 실패.");
            }
        }//if end

        //이런 저런 파일 정보
        System.out.println("수정시간 : " + file3.lastModified());
        System.out.println("읽기 가능 : " + file3.canRead());
        System.out.println("쓰기 가능 : " + file3.canExecute());
        System.out.println("숨김파일 : " + file3.isHidden());
        System.out.println("존재여부 : " + file3.exists());
        System.out.println("파일크기 : " + file3.length());

        //파일 경로 : 상대 경로, 절대 경로
        System.out.println("상대경로 : " + file3.getPath());
        System.out.println("절대경로 : " + file3.getAbsoluteFile());


        //파일 이름 변경 : renameTo()
        //바꿀 이름을 가진 file 객체가 필요
        File file4 = new File("data.txt");
        boolean rb = file3.renameTo(file4);
        if(rb){
            System.out.println("변경 성공!");
        }else {
            System.out.println("변경 실패!");
        }
        System.out.println(file3.getPath());

        //파일 삭제 : delete() - test2.txt -> data.txt
        //파일 존재 유무 확인 후 삭제
        if(file4.exists()){
            if(file4.delete()){
                System.out.println("삭제 성공!");
            }else {
                System.out.println("삭제 실패!");
            }
        }else {
            System.out.println("파일이 없습니다.");
        }

        System.out.println(file4.isFile()); //test2/txt 존재 확인

        //renameTo의 다른 사용법 : 이동(move)
        File file5 = new File("test.txt"); //이동 대상 파일
        File file6 = new File("dest_folder\\test.txt"); //이동될 경로

        if(file5.renameTo(file6)){
            System.out.println("이동 성공!");
        }else {
            System.out.println("이동 실패!");
        }

    }//main end
}//class end
