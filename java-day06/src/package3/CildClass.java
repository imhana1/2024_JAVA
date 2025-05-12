package package3;

public class CildClass extends ParentClass{
    int c;

    public CildClass() {
//        a = 1;
//        b = 2;
//        super(); // 여기서 변수 초기화를 하지 않고 부모 클래스의 생성자를 호출 자식클래스의 생성자 안에서만 사용 가능
        super(2, 2); // 한 생성자에서는 생성자만 호출하여 사용할 수 있다.
        c = 2; // 부모 클래스의 생성자를 먼저 호출해야 한다. super 는  반드시 첫 줄에 있어야함
    }
}
