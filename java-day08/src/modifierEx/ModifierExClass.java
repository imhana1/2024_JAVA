package modifierEx;

public class ModifierExClass {
}

final class finalClass {
    final int MAX_SIZE = 100;

    final void getMethod(){
        final int LV = 10;
        //MAX_SIZE = 200;//상수라서 값 변경 불가
        //LV = 90;//상수라서 값 변경 불가
    }
}

//class ChildFinalClass extends finalClass {
//    @Override
//    void getMethod() {
//        super.getMethod();
//    } //부모클래스의 getMethod가 final이 붙어서 재정의 불가
//}//부모클래스가 final 클래스이기 때문에 상속 불가

//대표적인 final 클래스 : String (상속 불가)