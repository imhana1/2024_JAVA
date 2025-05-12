package fileInOutEx;

import java.io.*; // 패키지의 모든 클래스 사용 : *
import java.util.Scanner;

public class FileOutput {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // 예제용 폴더 생성
        String path = "data";
        File folder = new File(path);
        if (!folder.isDirectory()) {
            folder.mkdir(); // 최초 한번만 폴더를 생성
        }//if end

        //FileOutputStream 사용 메소드
       // opStream(path);

        // FileWriter 사용 메소드
       // writeUse(path);

        // BufferedWriter 사용 메소드
        bufferWriter(path);
    }//main end

    private static void bufferWriter(String path) {
        // BufferedWriter 는 보조 스트임 객체이기 때문에
        // FileWriter 가 필요
        FileWriter fw = null;
        BufferedWriter bw = null;

        System.out.print("파일명 : ");
        String fname = scan.nextLine();
        fname += ".txt"; // 텍스트 파일 확장자 붙임

        File file = new File(path + "\\" + fname);

        try {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

            System.out.println("<작성 내용>");
            String str = scan.nextLine();
            str += "\n";

            bw.write(str);

            // 스트림(통로)에 미처 전송되지 못한 데이터를 처리
            bw.flush();

            System.out.println("저장 완료");
        } catch (IOException e) {
            System.out.println("저장 실패");
        }finally {
            try {
                bw.close(); // 버퍼먼저 제거
                fw.close(); // 통로(writer) 제거
            } catch (IOException e) {

            }
        }
    }

    private static void writeUse(String path) {
        FileWriter fw = null;
        System.out.print("파일명 : ");
        String fname = scan.nextLine();
        fname += ".txt"; // 텍스트 파일 확장자 붙임

        File file = new File(path + "\\" + fname);

        try {
            fw = new FileWriter(file);
            // file 뒤에 true를 넣으면, append 모드로 동작
            System.out.println("<작성 내용>");
            String str = scan.nextLine();
            str += "\n";
            fw.write(str); // 글자 단위로 저장
            System.out.println("저장 완료");
        } catch (IOException e) {
            System.out.println("저장 실패");
        } finally {
            try {
                fw.close();
            } catch (IOException e) {

            }
        }
    } // writerUse end

    private static void opStream(String path) {
        FileOutputStream fos = null;
        System.out.print("파일명 : ");
        String fname = scan.nextLine();
        fname += ".txt"; // 텍스트 파일 확장자 붙임

        File file = new File(path + "\\" + fname);

        try {
            fos = new FileOutputStream(file, true);
            // FileOutputStream 은 하드디스크에 파일이 없으면
            // 새로 생성하고 메모의 파일 객체와 연결하고,
            // 이미 파일이 존재하면 파일 객체와 파일을 연결만 한다
            // 이 때 파일을 어떤 방식으로 다룰지를 선택할 수 있다 (mode)
            // 붙여쓰기 모드(append mode) : 기존 내용 + 새 내용 (true)
            // 덮어쓰기 모드(overwrite mode) : 새 내용만 저장
            // true 없이 작성하면 덮어쓰기 모드로 동작

            System.out.println("< 작성 내용"); // 간이 타이틀
            String str = scan.nextLine();
            str += "\n";

            // 저장 작업
            // 문자열을 byte 배열로 변환
            byte[] b = str.getBytes();
            fos.write(b);
            System.out.println("저장 완료");

        } catch (FileNotFoundException e) {
            System.out.println("파일 없음");
        } catch (IOException ie){
            System.out.println("파일 생성 실패");
        } finally {
            // FileOutputStream 은 가비지 컬렉션이 안되는 객체
            try {
                fos.close();
            } catch (IOException e) {
                // 예외 처리
            }
        }
    } // fos end
}//class end
