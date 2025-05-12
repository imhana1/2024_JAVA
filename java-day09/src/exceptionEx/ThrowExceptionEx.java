package exceptionEx;

public class ThrowExceptionEx {
    public static void main(String[] args) {
        try {
            etMethod();
        } catch (MyMessage e) {
            System.out.println(e.getMessage());
        }
        try{ // 정상적인 실행일 경우 나눗셈 결과를 받고,
            int r = method1(5,0);
            System.out.println(r);
        } catch (MyMessage e) { // 비정상적인 경우 메시지를 받는다
            System.out.println(e.getMessage());
        }
    }

    static int method1(int a, int b) throws MyMessage{
        int r = 0;
        try{
            r = a / b;
        }catch (Exception e){
            throw new MyMessage("0으로 나눌 수 없다");
        }
        return r;
    }

    static void etMethod() throws MyMessage{
        //예외사항 인스턴스 생성
        MyMessage mm = new MyMessage("보내는 메시지");
        throw mm;
    }
} // class end

// 메시지 전달용 예외객체(실제 예외는 아니지만 예외처럼 동작)
class MyMessage extends Exception {
    // 생성자로 전달 할 메시지를 저장받도록 한다
    public MyMessage(String msg){
        super(msg);
    }
}