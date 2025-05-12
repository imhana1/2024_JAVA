package exceptionEx;

import java.util.Scanner;

public class EhCalculator {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        String menu = null;
        System.out.println("<<예외 처리 되는 계산기");

        while (true) {
            System.out.println("1. 덧셈");
            System.out.println("2. 뺄셈");
            System.out.println("3. 곱셈");
            System.out.println("4. 나눗셈");
            System.out.println("0. 종료");
            System.out.print("선택> ");
            menu = scan.nextLine();
            
            if (menu.equals("0")){
                System.out.println("계산기 종료");
                return;
            }
            
            switch (menu){
                case "1":
                    add();
                    break;
                case"2":
                    try{
                        sub();
                    }catch (NumberFormatException e){
                        System.out.println("숫자를 입력하세요.");
                    }finally {
                        System.out.println("뺄셈 종료. 이전 메뉴로 돌아갑니다.");
                    }
                    break;
                case"3":
                    try {
                        mul();
                    } catch (NumberFormatException e){
                        System.out.println("숫자를 입력하세요");
                    } finally {
                        System.out.println("곱셈 종료. 이전 메뉴로 돌아갑니다.");
                    }
                    break;
                case"4":
                    div();
                    break;
                default:
                    System.out.println("0~4까지만 입력");

            }
        }
    }

    private static void div() {
        //다중 예외 처리(2개 이상의 예외 처리)
        int n1, n2, r = 0;
        String str = null;

        System.out.println("<나눗셈 연산>");

        try{
            System.out.print("N1 : ");
            str = scan.nextLine();
            n1 = Integer.parseInt(str); // 예외 발생 가능 문장
            System.out.print("N2 : ");
            str = scan.nextLine();
            n2 = Integer.parseInt(str); // 예외 발생 가능 문장
            r = n1 / n2;
            System.out.println("결과 : " + r);
        } catch (NumberFormatException e){
            System.out.println("숫자를 입력하세요.");
        } catch (ArithmeticException e){
            System.out.println("두 번째 숫자에 0을 입력할 수 없습니다.");
        } catch (Exception e){
            //그 밖의 모든 예외사항의 처리

        }
        finally {
            System.out.println("나눗셈 종료. 이전 메뉴로 돌아갑니다.");
        }
    }

    private static void mul() throws NumberFormatException {
        // 다른 이런저런 작업을 하는 메소드
        mulrun(); // 곱셈 연산도 하는 경우
    }

    private static void mulrun() throws NumberFormatException {
        int n1, n2, r = 0;
        String str = null;

        System.out.println("<곱셈 연산>");

        System.out.print("N1 : ");
        str = scan.nextLine();
        n1 = Integer.parseInt(str); // 예외 발생 가능 문장
        System.out.print("N2 : ");
        str = scan.nextLine();
        n2 = Integer.parseInt(str); // 예외 발생 가능 문장
        r = n1 * n2;
        System.out.println("결과 : " + r);
    }

    private static void sub() throws NumberFormatException{
        // 이 메소드에서 예외처리하지 않고 위임
        int n1, n2, r = 0;
        String str = null;

        System.out.println("<뻴셈 연산>");

        System.out.print("N1 : ");
        str = scan.nextLine();
        n1 = Integer.parseInt(str); // 예외 발생 가능 문장
        System.out.print("N2 : ");
        str = scan.nextLine();
        n2 = Integer.parseInt(str); // 예외 발생 가능 문장
        r = n1 - n2;
        System.out.println("결과 : " + r);
    }

    private static void add() {
        // try, catch 자체 처리
        int n1, n2, r = 0;
        String str = null;

        System.out.println("<덧셈 연산>");

        try {
            System.out.print("N1 : ");
            str = scan.nextLine();
            n1 = Integer.parseInt(str); // 예외 발생 가능 문장
            System.out.print("N2 : ");
            str = scan.nextLine();
            n2 = Integer.parseInt(str); // 예외 발생 가능 문장
            r = n1 + n2;
            System.out.println("결과 : " + r);
        } catch (NumberFormatException e){
            System.out.println("숫자를 입력하세요.");
        }finally {
            System.out.println("덧셈 종료. 이전 메뉴로 돌아갑니다.");
        }
    }
}
