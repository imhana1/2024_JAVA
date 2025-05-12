package stringbufferEx;

public class StringBufferTest {
    public static void main(String[] args) {
        // 기본 생성법 : 기본적으로 16칸의 공백 공간을 생성
        StringBuffer sb1 = new StringBuffer();
        sb1.append("abcdefghijklmnopq");
        System.out.println(sb1.capacity());
        System.out.println(sb1.length());
        // 원하는 크기로 공간 생성
        StringBuffer sb2 = new StringBuffer(100); // 공간 설정
        System.out.println(sb2.capacity());
        // 초기 글자를 넣은 상태로 공간 생성
        StringBuffer sb3 = new StringBuffer("abcd");
        System.out.println(sb3.capacity());
        System.out.println(sb3.length());

        StringBuffer sb4 = sb1.delete(2,6);
        System.out.println(sb1);
        System.out.println(sb4);

        sb4.insert(5, "ABCDEFG");
        System.out.println(sb1);
        System.out.println(sb4);

        sb4.replace(6, 10, "오~");
        System.out.println(sb4);

        sb4.reverse();
        System.out.println(sb4);

        //특정 문자열을 역순으로 만드는 단계
        // 1. 문자열을 기본값(초기값)으로 하는 StringBuffer 생성
        // 2. reverse() 메소드 사용
        // 3. StringBuffer 의 toString() 메소드로 문자열 변환

        String result = sb4.toString(); // 최종적으로 문자열 변환
        System.out.println(result);

    }
}
