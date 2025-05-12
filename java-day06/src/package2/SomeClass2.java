package package2;

import package1.UseClass1;

public class SomeClass2 {
    public void someMethod(){
        UseClass1 uc2 = new UseClass1();
        uc2.a = 1000;//public 멤버
        //uc2.b = 2000;//default 멤버. 다른 패키지라서 사용 불가.
        //uc2.c = 3000;//private 멤버. 사용 불가.
        //uc2.e = 4000;//protected 멤버. 사용 불가.

        ChildClass2 cc2 = new ChildClass2();
        cc2.a = 11111;

    }
}
/