package abstractPakage;

public interface TestInterface {
    // 모든 변수는 상수
    public static final int a = 10; // 정식 표현
    final int b = 20; // 약식 표현
    static int c = 30;
    int d = 40;

    // 모든 메소드는 추상 메소드
    public abstract void method1(); // 정식표현
    public void method2(); // 약식 표현
    void method3();
}
