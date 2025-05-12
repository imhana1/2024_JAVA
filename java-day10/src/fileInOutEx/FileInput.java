package fileInOutEx;

import java.io.*;

public class FileInput {
    public static void main(String[] args) {
        String path = "data"; // 폴더명

        // FileInputStream 사용 메소드
        //inputStreamUse(path);

        // FileReader 사용 메소드
        //readerUse(path);

        // BufferedReader 사용 메소드
        bufferUse(path);
    }

    private static void bufferUse(String path) {
        // BufferedReader 도 보조 스트림 객체
        // FileReader 도 함께 사용
        FileReader fr = null;
        BufferedReader br = null;

        String fname = path + "\\" + "test3.txt";
        File file = new File(fname);

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String str = null;
            while ((str = br.readLine()) != null){
                System.out.println(str);
            }
        } catch (Exception e) {
            System.out.println("읽기 실패");
        } finally {
            try{
                br.close();
                fr.close();
            } catch (Exception ee){

            }
        }
    }

    private static void readerUse(String path) {
        FileReader fr = null;
        String fname = path + "\\" + "test2.txt";
        File file = new File(fname);

        try {
            fr = new FileReader(file);
            int i =0;

            while ((i = fr.read()) != -1){
                System.out.print((char) i);
            }
        } catch (FileNotFoundException e) {
            System.out.println("파일 없음");
        } catch (IOException e) {
            System.out.println("읽기 실패");
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                //
            }
        }
    }

    private static void inputStreamUse(String path) {
        FileInputStream fis = null;

        String fname = path + "\\" + "test1.txt";
        File file = new File(fname);

        try {
            fis = new FileInputStream(file);
            int i = 0;

            while((i = fis.read()) != -1){
                // read() : byte 단위로 파일의 저장된 데이터를
                //          읽어오는 메소드
                //          읽어온 데이터의 크기를 i에 저장
                //          읽어올 데이터가 없으면 i에 -1을 저장
                System.out.write(i);
                // write : byte 를 문자로 변환하여 출력하는 메소드
            }

        } catch (FileNotFoundException e) {
            System.out.println("파일 없음");
        } catch (IOException e) {
            System.out.println("읽기 실패");
        }finally {

            try {
                fis.close();
            } catch (IOException e) {

            }
        }
    }

}

