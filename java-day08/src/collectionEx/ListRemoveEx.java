package collectionEx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListRemoveEx {
    public static void main(String[] args) {
        List<Integer> iList = new ArrayList<>();
        //데이터 추가
        iList.add(1);
        iList.add(2);
        iList.add(2);
        iList.add(2);
        iList.add(3);
        iList.add(3);
        iList.add(3);
        iList.add(4);
        iList.add(4);
        iList.add(5);
        iList.add(6);
        System.out.println(iList);

        //문제. 모든 2를 지워라.
        //시도 1. remove() //모든 2를 지울 수 없다.
        //iList.remove(2);
        //System.out.println(iList);

        //시도 2. forEach() - 삭제 시 사용 불가
//        for(int n : iList){
//            if(n == 2){
//                iList.remove(Integer.valueOf(2));
//            }
//        }//for end

        //시도 3. 일반 for 사용 : 성공이긴 하지만....
        //int iSize = iList.size();
//        for(int i = 0; i < iList.size(); i++){
//            if(iList.get(i) == 2){
//                iList.remove(i);
//                i--;
//            }
//        }

        //시도 4. iterator 사용(안전한 삭제) - 권장
        Iterator<Integer> iter = iList.iterator();
        while (iter.hasNext()){
            if(iter.next() == 2){
                iter.remove();
            }
        }

        System.out.println(iList);
    }//main end
}//class end
