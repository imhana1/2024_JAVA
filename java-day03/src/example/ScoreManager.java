package example;

import java.util.Scanner;

public class ScoreManager {
    public static void main(String[] args) {
        // for
        Scanner scanner = new Scanner(System.in);
        int score = 0; // 점수
        int total = 0; // 총점
        float avg = 0.0f; // 평균

        System.out.println("점수 관리 프로그램");
        System.out.println("5명의 점수를 입력하세요");

        for(int i = 1; i <= 5; i++){
            System.out.print(i + "번 점수 : ");
            score = scanner.nextInt();
            total += score;
        }
        avg = (float) total; // 실수로 형변환을 하여 연산
        // 수식에서 사용하는 변수의 타입이 다른 경우
        // 가장 큰 자료형으로 모든 변수의 값의 형이 변환된다

        System.out.println("총점 : " + total + ", 평균 : " + avg);
        // 숫자를 문자열로 변환할 때 원래는 String.valueOf(숫자)
        // 방식 2 : "" + 숫자

    }
}
