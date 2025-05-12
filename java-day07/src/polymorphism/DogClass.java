package polymorphism;

public class DogClass extends AnimalClass {
    @Override
    void sound() {
        System.out.println("멍멍 소리를 낸다");
    }
}
