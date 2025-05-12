package overloadExam;

public class MethodOverloadText {
    public static void main(String[] args) {
        //대표적인 오버로딩 메소드
        //System.out.println(10);
        //System.out.println("abc");

        OverloadClass ol = new OverloadClass();
        int r1 = ol.add(5, 6);
        System.out.println(r1);

        int r2 = ol.add(6, 8, 10);
        System.out.println(r2);

        int r3 = ol.add(3.14f, 5.36f);
        System.out.println(r3);
    }
}
