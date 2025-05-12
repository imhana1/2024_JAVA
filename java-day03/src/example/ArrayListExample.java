package example;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
                // ArrayList
        ArrayList<String> menus = new ArrayList<>();

        // 원소 추가 (add)
        menus.add("자장면");
        menus.add("짬뽕");
        menus.add("탕수육");

        System.out.println(menus);
        System.out.println(menus.size());

        for (int i = 0; i < menus.size(); i++) {
            System.out.println(menus.get(i));
        }
        for (String m : menus) {
            System.out.println(m);
        }

        menus.set(1, "울면"); // 특정 위치 값(데이터) 변경
        System.out.println(menus);

        // 원소(데이터,값) 찾기
        System.out.println(menus.indexOf("자장면"));

        if (menus.indexOf("짬뽕") == -1){ // 원소(데이터,값)가 없으면
            menus.add("짬뽕"); // 원소(데이터,값)를 추가한다
        }

        if (!menus.contains("유산슬")){ // 유산슬이 없으면
            menus.add("유산슬"); // 유산슬을 추가
        }
        System.out.println(menus);

        int idx = menus.indexOf("울면"); // 특정한 데이터의 위치를 찾아서 삭제
        menus.remove(idx);
        menus.remove("유산슬"); // 데이터를 특정해서 삭제

        System.out.println(menus);

        menus.clear();
        System.out.println(menus); // 데이터 전부 삭제


        ArrayList<Integer> intList = new ArrayList<>();
        ArrayList<Float> FloatList = new ArrayList<>();
        // Generics(제네릭스) : 선언할 때 타입을 결정하는 방식.
        // Collection Framework : List, Set, Map 형태의 데이터 저장 프레임워크 (저장 틀을 저장하는 메소드)

        //Wrapper Class 를 활용한 변수 선언
        int a = 10; // 객체 지향의 개념에 반하는 방식
        Integer aa = Integer.valueOf(10);
        Integer bb = 20; // new 사용이 불편하여 변경한 듯,,,
    }
}
