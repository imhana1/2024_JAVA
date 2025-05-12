package package2;

import package1.UseClass1;

public class ChilidClass2 extends UseClass1 {
    public void someMetod7() {
        a = 9999; // public 멤버 상속됨
        // b = 8888; // default 멤버여서 사용 불가
        // c = 7777; // private 멤버 상속 안됨
        e = 1000; // protected 멤버 상속됨
    }
}
