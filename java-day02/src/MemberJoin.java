import java.util.Scanner;

public class MemberJoin {
    public static void main(String[] args) { // psvm

        Scanner scan = new Scanner(System.in); //입력 객체 Scanner
        // ㄴ 타입 식별자 = 초기화;
        // 개발자 정의형 타입
        // scan 은 변수, 참조형 변수
        // 참조형 변수는 instance 인스턴스를 저장

        String id = ""; // 변수의 초기화는 가급적 하는 것이 좋음
        String pass = "";
        String name = "";
        int age = 0;
        String phone = "";
        String address = "";

        // 타이틀 출력
        System.out.println("== 주소록 프로그램 ==");
        System.out.println("-------------------");
        System.out.println("<회원 가입>");

        // 회원 정보 입력 부분
        System.out.print("아이디 : ");
        id = scan.nextLine(); // 문자열 입력
        System.out.print("비밀번호 : ");
        pass = scan.nextLine();
        System.out.print("이름 : ");
        name = scan.nextLine();
        System.out.print("나이 : ");
//        age = scan.nextInt();
//        scan.nextLine(); // 남아있는 엔터키 처리
        String s = scan.nextLine(); // 문자열로 입력
        age = Integer.parseInt(s); // 숫자로 변환
        System.out.print("연락처 : ");
        phone = scan.nextLine();
        System.out.print("주소 : ");
        address = scan.nextLine();

        // 정보 확인용 출력 부분
        System.out.println(); // 한줄 띄기
        System.out.println("<입력 정보 확인>");
        System.out.println("아이디 : " + id);
        System.out.println("비밀번호 : " + pass);
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
        System.out.println("연락처 : " + phone);
        System.out.println("주소 : " + address);




                //내가한거
//        System.out.println("회원가입");
//        System.out.print(" ID ");
//        String str = scan.nextLine();
//        System.out.print(" 비밀번호 ");
//        String str1 = scan.nextLine();
//        System.out.print(" 이름 ");
//        String str2 = scan.nextLine();
//        System.out.print(" 나이 ");
//        int a = scan.nextInt();
//        System.out.print(" 연락처 ");
//        int b = scan.nextInt();
//        scan.nextLine();
//        System.out.print(" 주소 ");
//        String str3 = scan.nextLine();
//
//        System.out.println(" ID : " + str);
//        System.out.println(" 비밀번호 : " + str1);
//        System.out.println(" 이름 :" + str2);
//        System.out.println(" 나이 : " + a);
//        System.out.println(" 연락처 : " + b);
//        System.out.println(" 주소 : " + str3);
//        System.out.print("회원가입 완료");

    }
}
