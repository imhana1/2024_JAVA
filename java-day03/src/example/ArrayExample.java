package example;

import java.util.Scanner;

public class ArrayExample {
    public static void main(String[] args) {
        // Array 다차원 배열
        // 여러명의 성적을 관리하는 프로그램
        Scanner scanner = new Scanner(System.in);
        System.out.print("인원 : ");
        int num = scanner.nextInt();
        System.out.print("과목수 : ");
        int part = scanner.nextInt();
        // 다차원 배열 만들기

        int[][] scores = new int[num][part]; // 크기를 지정 안하면 실행이 안됨, 크기지정을 반드시 해줘야함

        for (int i = 0; i < scores.length; i++){ // scores.length; - 여기선 행의 갯수
            for (int k = 0; k < scores[i].length; k++){ // scores[i].length; - 여기선 행의 길이, 칸 수
                System.out.print((i + 1) + "번 : " + (k + 1) + "과목의 점수 : ");
                scores[i][k] = scanner.nextInt();
            }
        }
        for (int[] ss : scores){
            for (int s : ss) {
                System.out.println(s);

            }
        }
    }
}
