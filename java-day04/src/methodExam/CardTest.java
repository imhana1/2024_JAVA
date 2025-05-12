package methodExam;

public class CardTest {
    public static void main(String[] args) {
        //인스턴스 생성 전부터 사용 가능.
        Card.width = 1000;
        Card.height = 2500;

        Card c1 = new Card();//카드 인스턴스
        c1.kind = "heart";
        c1.number = 7;
        Card c2 = new Card();//카드 인스턴스
        c2.kind = "spade";
        c2.number = 4;
        System.out.printf("c1은 %s, %d이며, 크기는 (%d, %d)%n",
                c1.kind, c1.number, c1.width, c1.height);
        System.out.printf("c2은 %s, %d이며, 크기는 (%d, %d)%n",
                c2.kind, c2.number, c2.width, c2.height);
        Card.width = 50;
        Card.height = 80;
        System.out.printf("c1은 %s, %d이며, 크기는 (%d, %d)%n",
                c1.kind, c1.number, c1.width, c1.height);
        System.out.printf("c2은 %s, %d이며, 크기는 (%d, %d)%n",
                c2.kind, c2.number, c2.width, c2.height);

    }
}

//같은 파일에 여러 클래스를 작성할 수 있다.
//단, public 키워드는 파일이름과 같은 클래스에만 붙인다.
//(같은 파일에 여러 클래스를 작성하지 말것.)
class Card {
    String kind;//카드의 모양 저장 변수
    int number;//카드의 숫자 저장 변수
    static int width = 100;
    static int height = 250;
}