package singletonEx;

public class SingletonClass {
    // 자신의 인스턴스를 저장하는 클래스 변수
    private static SingletonClass instance;
    // 생성자는 private 로 선언
    private SingletonClass(){
        //다른 클래스에서 인스턴스 생성 불가
    }
    // 인스턴스 제공 메소드
    public static SingletonClass getInstance(){
        if(instance == null){
            instance = new SingletonClass();
        }
        return instance;
    }
    // 나머지 부분 : 필드, 메소드 등은 일반 클래스와 동일하게 작성
    private int num1;
    public int getNum1() {
        return num1;
    }
    public void setNum1(int num1){
        this.num1 = num1;
    }
} // class end
