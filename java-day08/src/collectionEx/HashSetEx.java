package collectionEx;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class HashSetEx {
    public static void main(String[] args) {
        //정수형 집합
        Set<Integer> iSet = new HashSet<>();
        //집합에 데이터 입력 : add(값)
        iSet.add(1);
        iSet.add(2);
        iSet.add(3);
        iSet.add(4);
        iSet.add(5);
        iSet.add(2);
        System.out.println(iSet);
        System.out.println("개수 : " + iSet.size());

        for(int a : iSet){//이런 사용법은 옳지 않다.(100% 보장안됨)
            System.out.println(a);
        }//set은 원래 순서가 없기 때문에 순차적으로 사용하지 말자.

        //집합 데이터의 유무 확인 : contains();
        System.out.println(iSet.contains(8));

        //집합 데이터의 삭제 : remove(값);
        iSet.remove(4);
        System.out.println(iSet);

        //Set 원소의 순차적인 사용 : iterator로 변환 후 사용.
        Iterator<Integer> iter = iSet.iterator();

        while (iter.hasNext()){
            int n = iter.next();//원소 꺼내기
            System.out.println(n);
            if(n == 3){
                iter.remove();//원소 제거(삭제) - 원본도 삭제(iSet)
            }
        }
        System.out.println(iSet);

        ///////////////////////////////////////////////
        //Dto를 담는 Set
        Set<TestDto> dtoSet = new HashSet<>();
        TestDto td1 = new TestDto();
        td1.setStr("abc");
        td1.setIv(10);
        td1.setB(true);

        TestDto td2 = new TestDto();
        td2.setStr("def");
        td2.setIv(20);
        td2.setB(false);

        dtoSet.add(td1);
        dtoSet.add(td2);

        TestDto td3 = new TestDto();
        td3.setStr("abc");
        td3.setIv(11);
        td3.setB(true);

        dtoSet.add(td3);
        dtoSet.add(td1);

        System.out.println(dtoSet);
    }
}//HashSetEx end

//set, list, map에 저장하는 대상은 객체(DTO)
class TestDto {
    private String str;
    private int iv;
    private boolean b;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getIv() {
        return iv;
    }

    public void setIv(int iv) {
        this.iv = iv;
    }

    public boolean isB() {
        return b;
    }

    public void setB(boolean b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "{str: %s, iv: %d, b: %b}"
                .formatted(str, iv, b);
    }

    @Override
    public boolean equals(Object obj) {
        //저장할 객체의 데이터가 중복인지 여부를 확인하기 위해
        //equals 메소드를 재정의
        TestDto t = (TestDto) obj;
        boolean bb = str.equals(t.getStr())
                && (iv == t.getIv())
                && (b == t.isB());
        return bb;
    }

    @Override
    public int hashCode() {
        return Objects.hash(str, iv, b);
    }
}//TestDto end

