package methodExam;

public class InitTest {
    static int cv = 1;
    int iv = 1;

    static  {
        cv = 2;
    }
    {
        iv = 2;
    }

    InitTest (){ //생성자. 클래스 이름과 같은 이름을 쓰는 메소드.
        iv = 3; //인스턴스 변수의 초기화.
    }

    public static void main(String[] args) {
        InitTest i = new InitTest();//클래스 스스로 인스턴스 생성.
        System.out.println(cv);
        System.out.println(i.iv);
    }
}
