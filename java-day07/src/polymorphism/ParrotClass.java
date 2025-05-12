package polymorphism;

public class ParrotClass extends AnimalClass{

    @Override
    void move() {
        System.out.println("날아서 이동한다.");
    }

    @Override
    void sound() {
        System.out.println("사람 소리를 낸다.");
    }
}
