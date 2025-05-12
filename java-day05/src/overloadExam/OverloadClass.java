package overloadExam;

public class OverloadClass {
    public int add(int a, int b){
        return a + b;
    }

    //파라미터(매개변수) 개수로 구분
    public int add(int a, int b, int c){
        return a + b + c;
    }

    //매개변수의 자료형으로 구분
    public int add(float a, float b){
        return (int) (a + b);
    }
}
