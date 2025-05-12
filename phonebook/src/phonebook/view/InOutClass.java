package phonebook.view;

import java.util.Scanner;

public class InOutClass {
    //화면에 출력하거나 키보드로부터 값을 받는 기능을
    //제공하는 부품 클래스
    //다른 클래스에서는 print와 Scanner를 사용하지 않고
    //이 클래스에서만 하도록 제한.
    //제공 기능
    //1. 출력 - 한줄 출력과 두줄 출력
    // 한줄 출력용 메소드
    public void olPrint(String str){
        System.out.print(str);
    }

    // 두줄 출력용 메소드
    public void tlPrint(String str){
        System.out.println(str);
    }

    //2. 입력 - 안내문구 출력과 입력
    //          정수, 실수, 문자열
    private Scanner scan = new Scanner(System.in);

    //문자열 입력 메소드
    public String inStr(String s){
        //안내문구 s를 받아서 먼저 출력하고 입력받기.
        olPrint(s);//안내문구 출력.
        String str = scan.nextLine();//문자열입력.

        return str;//입력받은 문자열 넘겨주기.
    }

    //정수 입력 메소드
    //문자열 -> 정수로 변환.
    public int inNum(String s){
        int num = -999999;//생각할 수 있는 최소의 값.
        String nstr = inStr(s);//숫자만 입력한다.
        try {
            if (!nstr.equals("")) {
                num = Integer.parseInt(nstr);
            }
        } catch (NumberFormatException e){
            //콘솔에 출력하는 프로그램은 이 부분을 비운다.
        }
        return num;
    }//inNum end

    //실수 입력 메소드
    public float inFloat(String s){
        float fnum = -0.0000000000001f;
        String fstr = inStr(s);
        if(!fstr.equals("")){
            fnum = Float.parseFloat(fstr);
        }
        return fnum;
    }//inFloat end
}//class end
