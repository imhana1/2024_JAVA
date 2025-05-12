import java.util.Scanner;

public class OperatorEx {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//        int a = 0;
//        int b = 0;
//
//
////        a = scan.nextInt();
////        b = scan.nextInt();
//
//        System.out.println("a == b :" + (a == b));
//
//        String s1 = "abc";
//        String s2 = new String("abc");
//
////        System.out.println("s1 == s2 : " + (s1 == s2));
////
////        System.out.println("s1과 s2가 같은가 :" + s1.equals(s2));

        //////////////////////////////////////////////
        // 조건 연산자
        System.out.println("연도 : ");
        int year = scan.nextInt();

        String leap = ((year % 4 == 0)
                && (year % 100 != 0)
                || (year % 400 == 0) ) ? "윤년" : "평년";
        System.out.println(year + "년은 " + leap + "입니다.");
        ///////////////////////////////////////////
        int k1 = 1;
        int k2 = 2;
        int k3 = 1;
        boolean b = (k1 == k2) && (++k1 == k3); // ++를 넣었기 때문에 값이 2가 나와야함
        // 첫번째 식이 거짓이여서 && 다음 식이 실행이 안됨
        // 이런 경우는 거의 없으니 주의해야함
        //    논리 연산의 경우 특수한 상황에 따라 문제가 발생할 수 있음.
        //    &&의 경우 첫번째 조건식이 false 인 경우, 두번째 조건식을 수행하지 않는다.
        //    반대로 ||(or)의 경우 첫번째 조건식이 true 일때 두번째 조건식에 추가적인 연산식이 있을 경우 수행되지 않기 때문에 결과에 영향을 줄 수 있다.
        System.out.println("k1 = " + k1);

    }
}
