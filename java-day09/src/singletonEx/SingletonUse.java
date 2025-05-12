package singletonEx;

public class SingletonUse {
    public static void main(String[] args) {
        //SingletonClass sc = new SingletonClass(); // 생성 불가
        SingletonClass sc1 = SingletonClass.getInstance();
        sc1.setNum1(10);
        System.out.println(sc1.getNum1());

        /////////////////////////////////////

        SingletonClass sc2 = SingletonClass.getInstance();
        System.out.println(sc2.getNum1());
        sc2.setNum1(100);

        System.out.println(sc1.getNum1());
    }
}
