package abstractPakage;

public class AbstractTestClass {
    public static void main(String[] args) {
        //AnimalClass animal = new AnimalClass(); // 인스턴스 생성 불가
        MonkeyClass monkey1 = new MonkeyClass();

        AnimalClass ani = new MonkeyClass(); // 다형성
    }
}
