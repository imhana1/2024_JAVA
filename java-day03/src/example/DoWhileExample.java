package example;

import java.util.Scanner;

public class DoWhileExample {
    public static void main(String[] args) {
        // while 문, do while 문
        Scanner scanner = new Scanner(System.in);
        int score;
        int total = 0;
        float avg = 0.0f;
        int count = 0; // 입력 횟수를 세는 변수

        System.out.println("점수 관리 프로그램");

        do {
            System.out.println("점수 (종료 : 0) - ");
            score = scanner.nextInt();
            total += score;
            count++;
        } while (score != 0); // score 가 0이 아니면

        avg = (float) total / count;
        System.out.printf("총점 : %d, 평균 : %.2f", total, avg);
    }
}
