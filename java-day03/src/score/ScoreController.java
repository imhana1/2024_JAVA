package score;

import java.util.ArrayList;
import java.util.Scanner;

public class ScoreController {
    public void run(){
        Scanner scanner = new Scanner(System.in);
        String menu = null;

        // 타이틀 출력
        System.out.println("성적 관리 프로그램");
        System.out.println("===============");

        //성적 정보를 저장하는 공간 - ArrayList
        ArrayList<Integer> scoreList = new ArrayList<>();

        while (true) { // 무한 루프 생성
            // 메뉴 출력
            System.out.println(); // 한 줄 띄기
            System.out.println("1. 점수 입력");
            System.out.println("2. 전체 점수 출력");
            System.out.println("3. 총점");
            System.out.println("4. 평균");
            System.out.println("0. 종료");
            System.out.println("==============");
            // 메뉴 입력
            System.out.print("선택> ");
            menu = scanner.nextLine();

            //종료 처리
            if (menu.equals("0")) {
                System.out.println("프로그램 종료");
                break;
            }

            int total = 0; // 총점 저장 변수
            float avg = 0.0f; // 평균 저장 변수

            String s = null; // 입력 값을 저장하는 변수

            // 기능 분류 (메뉴 처리)
            switch (menu){
                case"1": // 점수 입력 처리
                    System.out.println("<점수 입력>");
                    int i = scoreList.size() + 1;
                    System.out.print(i + "번 학생 점수 : ");
                    s = scanner.nextLine();
                    scoreList.add(Integer.parseInt(s));
                    break;
                case "2": // 전체 점수 출력
                    for (int idx = 0; idx < scoreList.size(); idx++) {
                        System.out.printf("%d번 점수 : %d%n",idx+1, scoreList.get(idx));
                    }
                    break;
                case "3": // 총점 계산 및 출력
                    System.out.println("<총점 출력>");
                    if(scoreList.size() == 0){
                        System.out.println("입력한 점수가 없습니다.");
                    } else {
                        for(int sc : scoreList){
                            total += sc;
                        }
                        System.out.println("총점 : " + total);
                    break;
                case "4": // 평균 계산 및 출력
                    System.out.println("<평균 출력>");
                    if(total != 0){
                        avg = (float) total / scoreList.size();
                        System.out.println("평균 : " + avg);
                    } else {
                        System.out.println("총점을 먼저 구하세요.");
                    }
                    break;
                default:
                    System.out.println("0 ~ 4 사이의 값을 입력하세요.");
            }
        }
    }
}
