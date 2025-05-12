public class Main {
    public static void main(String[] args) {
        // 변수  선언
        long a = 10000L; // 8byte
        int b = (int)a; // long 보다 int 가 데이터가 작아서 강제적으로 변수를 변환 - 강제 형변환 Casting

         int c = 256;
         long d = c; // 위와 반대로 작은데이터가 큰데이터 공간으로 이동하는 것은 상관없음  - 자동 형변환 Casting

         int e = 5;
         float f = e;

         float g = 3.14f;
         int h = (int)g;

        System.out.println(f);
        System.out.println(h);

        //////////////////////////////////
        String str1 = null;
        String str2 = "";
        System.out.println(str2);
        System.out.println(str1);



    }
}
// 클래스(객체)안에 작성한 함수 = 메소드(method)
// System.out.println(); - sout