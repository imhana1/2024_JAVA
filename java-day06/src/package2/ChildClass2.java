package package2;

import package1.UseClass1;

public class ChildClass2 extends UseClass1 {
    public void someMethod7(){
        a = 9999;//public 멤버 상속됨
        //b = 8888;//defautl 멤버 상속 안됨
        //c = 7777;//private 멤버 상속 안됨
        e = 1000;//protected 멤버 상속됨
    }
}
