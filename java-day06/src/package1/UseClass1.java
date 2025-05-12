package package1;

public class UseClass1 {
    public int a;
    int b;//default 접근제어
    private int c;
    protected int e;

    public void method1(){
        //클래스 내에서 접근제어는 의미 없음.
        a = 10;
        b = 20;
        c = 30;
        e = 40;
    }

    public void printMethod(){
        System.out.println(a + b + c + e);
    }
}
