package package3;

public class ParentClass{
    int a;
    int b;

    //생성자 : 멤버변수의 값을 초기화.
    public ParentClass(){//기본생성자. 매개변수가 없는 생성자.
        //a = 1;
        //b = 1;
        this(1, 1);
    }

    public ParentClass(int a, int b){
        this.a = a;
        this.b = b;
    }
}
