package collectionEx;

import java.util.*;

public class HashMapEx {
    public static void main(String[] args) {
        //초간단 사전 : 단어 - 뜻
        Map<String, String> dic = new HashMap<>();
        //데이터 입력
        dic.put("one", "하나|일");
        dic.put("apple", "사과");
        dic.put("grape", "포도");
        dic.put("pear", "배");
        dic.put("ship", "배");
        dic.put("ship", "돛단배");
        System.out.println(dic);

        //map의 데이터 읽어오기 : get(key)
        System.out.println(dic.get("two"));
        //key에 해당하는 value가 없을 경우 : null

        //key나 value의 존재 여부 확인 : ture/false
        //containsKey(key) : 키 존재 여부 확인
        System.out.println(dic.containsKey("two"));
        //containsValue(value) : 값 존재 여부 확인
        System.out.println(dic.containsValue("배"));

        //key에는 어떤 것들이 있는가 - 키집합(keySet())
        Set<String> keySet = dic.keySet();
        System.out.println(keySet);
        System.out.println(dic.get("one"));

        //값의 집합(Collection) : values()
        Collection<String> vSet = dic.values();
        System.out.println(vSet);

        //값을 가지고 키를 구하자. 뜻으로 단어 찾기
        //1. 찾고자 하는 값이 맵에 존재하는가?(true)
        //2. 키 집합을 생성한다.
        //3. 키 집합을 순차구조(iterator)로 변환
        //4. 키 집합에서 키를 하나씩 가져와서 해당 값을 읽어온다.
        //5. 읽어온 값과 찾는 값을 비교 : 같으면 해당 키를 출력.
        // 사과의 키는 무엇인가?
        // 키를 출력하거나 '해당 값은 사전에 없습니다.'라는 문구를 출력.
        String s = "사과";

        if(dic.containsValue(s)){
            Set<String> keys = dic.keySet();
            Iterator<String> kIter = keys.iterator();
            while (kIter.hasNext()){
                String k = kIter.next();
                String v = dic.get(k);
                if(v.equals(s)){
                    System.out.println(s + "의 단어는 " + k);
                    break;
                }
            }
        } else {
            System.out.println("해당 값은 사전에 없습니다.");
        }
    }
}
