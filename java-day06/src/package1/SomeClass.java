package package1;

public class SomeClass {
    public void someMethod(){
        UseClass1 uc = new UseClass1();
        uc.a = 100;//public 멤버변수 사용 가능.
        uc.b = 200;//default 멤버변수 사용 가능.
        //uc.c = 300;//private 멤버변수 사용 불가.
        uc.e = 300;//protected 멤버변수 사용 가능.

        ChildClass1 cc = new ChildClass1();
        cc.a = 500;
        cc.b = 700;
        cc.d = 900;


    }
}
