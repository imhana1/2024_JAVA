package package3;

public class ChildClass extends ParentClass{
    int c;

    public ChildClass(){
        //a = 1;
        //b = 1;
        //super();//여기서 변수 초기화를 하지 않고 부모클래스의 생성자를 호출
        super(2, 2);//하나의 생성자만 호출하여 사용할 수 있다.
        c = 2;//부모클래스의 생성자를 먼저 호출해야 한다.
    }
}

