package example;

import java.util.Scanner;

public class GradeProc {
    public static void main(String[] args) {
        // switch
        Scanner scanner = new Scanner(System.in);

        int score = 0;
        String grade = null; // 참조형 변수는 2가지를 저장 1번째 실제 데이터 2데이터의 위치정보 , null 과 ""; 빈 문자열은 다름 초기화는 null 입력을 권장

        System.out.println("학점 계산기");
        System.out.print("점수 : ");
        score = scanner.nextInt();

        switch (score/10) {
            case 10:
            case 9:
                grade = "A";
                break; // switch 를 종료
            case 8:
                grade = "B";
                break;
            case 7:
                grade = "C";
                break;
            case 6:
                grade = "D";
                break;
            default:
                grade = "F";
        }
        System.out.println("학점 : " + grade);
    }
}
