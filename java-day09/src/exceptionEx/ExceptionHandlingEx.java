package exceptionEx;

import java.util.Scanner;

public class ExceptionHandlingEx {
    // 예외 처리 예제
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str = null;
        int num = 0;

        for (int i = 0; i < 5; i++){
            try {
                System.out.println("-- 입력 전 --");
                System.out.print("숫자 입력 : ");
                str = scan.nextLine();
                System.out.println("-- 변환 전 --");
                num = Integer.parseInt(str);
                System.out.println("-- 변환 후 --");

                System.out.println("입력한 숫자 : " + num);
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력하세요");
            } finally {
                System.out.println("현재 반복 횟수 : " + i);
            }
        }// for end
    } // main end
}//class end
