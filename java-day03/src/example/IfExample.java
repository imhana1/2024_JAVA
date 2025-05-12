package example;

import java.util.Scanner;

public class IfExample {
    public static void main(String[] args) {
        // if 문
        Scanner scanner = new Scanner(System.in);

        int score = 0;


        System.out.println("판별 프로그램");
        System.out.print("점수 : ");
        score = scanner.nextInt();

        if(score >= 60) {
            System.out.println("합격");
        } else if(score >= 50) {
            System.out.println("보류");
        } else {
            System.out.println("불합격");
        }
    }
}
