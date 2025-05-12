package myframe;

import java.util.Scanner;
 // 프로그램 골격 만들어보기
public class ControllerClass {
    // 이 프로그램은 프로그램의 모든 부분을 처리하는 인스턴스의 설계도 틀래스
    // 타이틀 : ㅇㅇ관리 프로그램
    // 메뉴 : 1. 입력, 2. 출력, 0. 종료

    public void run(){ // run : 프로그램 실행
        Scanner scanner = new Scanner(System.in);
        String menu; // 숫자도 문자열로 입력 받자

        // 프로그램의 타이틀 출력
        System.out.println("관리 프로그램");
        System.out.println("===========");

        // 메튜 출력부터 종료까지 무한루프
        while (true) { //조건식이 항상 true 이기 때문에 종료하지 않음
            // 메뉴 출력
            System.out.println("1. 입력 ");
            System.out.println("2. 출력 ");
            // 여러 추가 메뉴가 들어갈 수 있음
            System.out.println("0. 종료 ");
            // 메뉴 입력
            System.out.println("메뉴 선택> "); // "메뉴 선택>" - 프롬프트라고 함
            menu = scanner.nextLine(); // 문자열로 입력을 받음

            // 입력한 메뉴 번호에 따라서 기능으로 분기를 시킴, if, switch 로 처리
            // 종료 처리
            if(menu.equals("0")){
                System.out.println("프로그램 종료");
                break; // while 문 종료, 프로그램을 종료한다는 뜻
            }

            // 나머지 메뉴
            switch (menu){
                case "1": // 입력 기능 처리 부분
                    System.out.println("입력 기능을 수행합니다.");
                    break;
                case "2": // 출력 기능 처리 부분
                    System.out.println("출력 기능을 수행합니다.");
                    break;
                default:
                    System.out.println("잘못 입력하였습니다.");
            }
        }
    }
}
