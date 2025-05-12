package abstractPakage;

public abstract class AnimalClass { // 추상 키워드
    String name; // 변수에는 abstract 를 붙ㄴ일 수 없다 (추상 변수는 없음)
    int age;
    String gender;

    public abstract void howl();// 추상 메소드

    public void sleep(){ // 일반 메소드
        System.out.println("코코낸내");
    }
}
