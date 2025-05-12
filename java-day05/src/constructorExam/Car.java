package constructorExam;

public class Car {
    //모델명, 컬러, 기어, 문개수
    private String model;
    private String color;
    private boolean gearType;//true : 자동, false : 수동
    private int doorCnt = 4;//1) 필드에 직접 초기화

    // 2) 인스턴스 생성 후에 초기화 - setter 메소드 사용
    public void setModel(String model){
        this.model = model;
    }
    //메소드에서 지역변수의 이름과 멤버변수의 이름이 같을 경우
    //구분을 하기위해 this 키워드를 사용.
    //this를 사용하지 않으려면 변수의 이름를 다르게 사용하면 된다.

    // 3) 생성자를 사용하여 초기화
    public Car() {
//        this.model = "아반떼";
//        this.color = "검정";
//        this.gearType = true;
//        this.doorCnt = 4;
        this("아반떼");
    } //기본 생성자.

    public Car(String model){
//        this.model = model;
//        this.color = "검정";
//        this.gearType = true;
//        this.doorCnt = 4;
        this(model, "검정");
    }

    public Car(String model, String color){
//        this.model = model;
//        this.color = color;
//        this.gearType = true;
//        this.doorCnt = 4;
        this(model, color, true);
    }

    public Car(String model,
               String color,
               boolean gearType){
//        this.model = model;
//        this.color = color;
//        this.gearType = gearType;
//        this.doorCnt = 4;
        this(model, color, gearType, 4);
    }// this() : 다른 생성자를 호출하는 방식.

    public Car(String model,
               String color,
               boolean gearType,
               int doorCnt){
        this.model = model;
        this.color = color;
        this.gearType = gearType;
        this.doorCnt = doorCnt;
    }

    @Override
    public String toString() {
        String str = null;
        str = "모델명 : " + model + "\n"
                + "색상 : " + color + "\n"
                + "문개수 : " + doorCnt;
        return str;
    }
}
