package methodExam;

public class StaticInstanceTest {
    int iv;
    static int cv;

    void iMethod() { }
    static void cMethod() { }

    void iMethod2() {
        iv = 10;
        cv = 10;
        iMethod();
        cMethod();
    }
    
    static void cMethod2(){
        iv = 20;//사용 불가
        cv = 20;
        iMethod();//사용 불가
        cMethod();
    }
}
