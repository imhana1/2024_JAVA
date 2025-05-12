package mart;

import java.util.ArrayList;

public class MartManager {
    public static void main(String[] args) {
        ArrayList<Productinfo> prodList = new ArrayList<>();

        FoodInfo food1 = new FoodInfo();
        food1.setPno(1);
        food1.setPname("참치 통조림");
        food1.setPrice(1000);
        food1.setAmount(50);
        food1.setCompny("동원");
        food1.setGdate("2025-07-11");
        food1.setIngredient("참치");
        food1.setIngredient("식용유");
        food1.setIngredient("소금");

        prodList.add(food1);

        ElectroInfo elec1 = new ElectroInfo();
        elec1.setPno(2);
        elec1.setPname("TV");
        elec1.setPrice(500000);
        elec1.setAmount(10);
        elec1.setCompny("LG");
        elec1.setGdate("2025-07-10");
        elec1.setSerialNumber("LG1201MS7");

        prodList.add(elec1);

        Productinfo prod = prodList.get(0);
        System.out.println(prod.getPname());
        System.out.println(prod.getCompny());
        System.out.println(prod.getPrice());
        //System.out.println(prod.getIngredient);// error

        FoodInfo food = (FoodInfo) prod; // 강제 형변환 (down casting)
        System.out.println(food.getIngredient(1));

        //Productinfo prod2 = prodList.get(1);
        //System.out.println(prod2.getserialNumber);// error
        ElectroInfo elec = (ElectroInfo) prodList.get(1);
        System.out.println(elec.getSerialNumber());

        for (Productinfo p : prodList) {
            if (p instanceof FoodInfo) {
                FoodInfo f = (FoodInfo) p;
                //성분 정보 출력문
                System.out.println(f.getIngredient(0));
            }
            else if (p instanceof ElectroInfo){
                ElectroInfo e = (ElectroInfo) p;
                //시리얼 번호 출력문
                System.out.println(e.getSerialNumber());
            }
        }
    }
}
