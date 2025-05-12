package package1;

public class ChildClass1 extends UseClass1 {
    public int d;

    public void method3(){
        a = 10000;
        b = 20000;
        //c = 30000;//부모 클래스의 private 멤버 사용 불가.
        d = 60000;//부모 클래스는 없는 새 멤버 사용.
        e = 80000;//부모 클래스의 protected 멤버 사용 가능.
    }

    @Override
    public void method1(){
        a = 1000;
        b = 2000;
        //c = 3000;
        e = 4000;
        d = 5000;
    }

    @Override
    public void printMethod(){
        System.out.println(a + b + e + d);
    }
}
