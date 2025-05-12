package package1;

public class MainClass {
    public static void main(String[] args) {
        UseClass1 uc0 = new UseClass1();
        uc0.method1();
        uc0.printMethod();// 100

        ChildClass1 cc0 = new ChildClass1();
        cc0.method1();
        cc0.printMethod();
    }
}
