package multiLineEx;

import java.util.Scanner;

public class MultiLineInputTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        while (scan.hasNextLine()){
            String s = scan.nextLine();
            if (s.equals("")){
                break; // 엔터키 두번 입력 시 종료
            }
            sb.append(s + "\n");
        }
        String finalStr = sb.toString();
        System.out.println(finalStr);
    }
}
