package collectionEx;

public class GenericEx {
    public static void main(String[] args) {
        Book b1 = new Book();
        b1.name = "Java";
        b1.price = 10000;

        Cloth c1 = new Cloth();
        c1.brand = "나이키";
        c1.size = "XXL";
        c1.kind = "점퍼";

        //box에 book을 저장
        Box box1 = new Box();
        box1.setItem(b1);

        //box에 cloth를 저장
        Box box2 = new Box();
        box2.setItem(c1);

        //... 여기는 다른 메소드라고 가정.(이사 후)
        Object obj = box2.getItem();
        if(obj instanceof Book){
            Book b2 = (Book) obj;
            //이 후에 책으로 사용.
            System.out.println(b2.name + ", " + b2.price);
        } else if(obj instanceof Cloth){
            Cloth c2 = (Cloth) obj;
            //이 후에 옷으로 사용.
            System.out.println(c2.brand + ", " + c2.size);
        }

        ////////////////////////////////////////////////////
        //제네릭스 박스 이용
        Gbox<Book> box3 = new Gbox<>();
        Gbox<Cloth> box4 = new Gbox<>();

        box3.setItem(b1);
        box4.setItem(c1);

        //...여기서부터 다른 메소드라고 가정
        Book b3 = box3.getItem();
        Cloth c3= box4.getItem();
    }
}

class Book {
    String name;
    int price;
}

class Cloth {
    String brand;
    String size;
    String kind;
}

//어떤 인스턴스라도 담을 수 있는 박스 객체
//다형성을 활용. Object 클래스는 모든 객체의 조상.
class Box {
    private Object item;//어떤 인스턴스던 저장 가능
    public Object getItem(){
        return item;
    }
    public void setItem(Object item){
        this.item = item;
    }
}

//제네릭스를 활용한 Box class
class Gbox<T> {
    private T item;
    public T getItem(){
        return item;
    }
    public void setItem(T item){
        this.item = item;
    }
}