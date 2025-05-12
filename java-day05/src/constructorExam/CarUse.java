package constructorExam;

public class CarUse {
    public static void main(String[] args) {
        //Car mc = new Car(); <- error. 기본 생성자가 없음.

        //개발자가 작성한 생성자를 반드시 사용해야 한다.
        Car mycar = new Car("람보르기니", "레드", true, 2);

        //기본 생성자 작성후
        Car mySecondCar = new Car();

        Car myThCar = new Car("쏘나타");
        Car car4 = new Car("그랜저", "회색");
        Car car5 = new Car("올란도", "흰색", false);

        System.out.println(mySecondCar);
        System.out.println(car4);
    }
}
