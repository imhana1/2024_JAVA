import java.util.Scanner;

public class InOutTest {
    public static void main(String[] args) {
        // Scanner 클래스(설계도) - 입력장치(객체)를 만드는 클래스
        Scanner scan = new Scanner(System.in);
        //System.in : 표준 입력 장치(키보드)

        // 2개의 값을 입력 받아서 덧셈 결과를 출력하는 프로그램
        int n1;
        int n2;


        // 타이틀 출력
        System.out.println("간단한 계산기");
        System.out.print("첫번째 숫자 입력 - ");
        n1 = scan.nextInt(); // n1의 변수에 첫번째 정수값을 입력받는다
        System.out.print("두번째 숫자 입력 - ");
        n2 = scan.nextInt(); // n2의 변수에 두번째 정수값을 입력받는다

        int res = n1 + n2;


        System.out.println("덧셈 결과 : " + res + " 입니다");
        // System.out : 표준 출력 장치(모니터-콘솔창)

        ///////////////////////////////////////////
        System.out.println("숫자 입력");
        int a = scan.nextInt();
        scan.nextLine(); // 입력한 엔터키 값을 처리
        System.out.println("문자열 입력");
        String str = scan.nextLine();

        System.out.println("숫자 :" + a);
        System.out.println("문자열 : " + str);

        /////////////////////////////////////////////////
        //printf 예
        int iv = 100;
        float fv = 3.14f;
        String s = "문자열";

        // 한꺼번에 출력 한다면, 위 세가지를 한줄로 표현 한다면
        System.out.println(iv + ",\n" + fv + ",\n" + s);
        System.out.printf("%d\n, %.2f\n, %s%n\n", iv, fv, s);




        System.out.print("프로그램\n 종료\n"); // \n은 줄바꿈 단축키


    }
}
// print 는 출력하고 줄을 안바꿈
// prinln 은 출력하고 줄을 바꿈
//