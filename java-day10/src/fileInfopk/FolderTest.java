package fileInfopk;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;

public class FolderTest {
    public static void main(String[] args) {
        //폴더 생성
        //makeFolder();

        //폴더 내용 보기(파일, 하위 폴더)
        folderInfo();
        //폴더 삭제
        folderDelete();
        // 폴더 내부에 파일이나 하위 폴더가 있으면 삭제가 안됨
    }

    private static void folderDelete() {
        String path = "testFolder";
        File folder = new File(path);

        if (folder.exists()){
            //내부 파일들과 하위 폴더 삭제
            File[] list = folder.listFiles();
            for (File f : list){
                f.delete();
            }
            boolean b = folder.delete();
            if (b){
                System.out.println("폴더 삭제 성공");
            } else {
                System.out.println("폴더 삭제 실패");
            }
        } else {
            System.out.println("해당 폴더 없음");
        }

    }

    private static void folderInfo() {
        String path = "testFolder";
        File folder = new File(path);

        if(folder.exists()){//폴더 존재유무 확인
            //폴더 내부의 파일(하위폴더) 목록 가져오기 : ListFiles()
            File[] List = folder.listFiles();

            for(File f : List){
                //파일(폴더)명 읽어오는 메소드 : getName()
                //System.out.println(f.getName());
                if(f.isFile()){
                    System.out.println(f.getName() + "<- 파일");
                }else {
                    System.out.println(f.getName() + "<- 폴더");
                }
            }
        }
    }

    private static void makeFolder() {
        String folderName = "testFolder";
        File folder = new File(folderName);
        //폴더 유무 확인 후 생성
        if(!folder.isDirectory()){
            if(folder.mkdir()){ //Make DIRectory 폴더 생성 메소드
                System.out.println("생성 성공!");
            }else {
                System.out.println("생성 실패!");
            }
        }else {
            System.out.println("폴더가 이미 존재합니다.");
        }

        //이 후 파일을 해당 폴더 생성
        File file = new File(folderName + "\\hello.txt");
        try {
            file.createNewFile();
        }catch (IOException e){
            System.out.println("파일 생성 불가.");
        }

    }// makeFolder end
}//class end