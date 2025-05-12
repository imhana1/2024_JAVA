package randomEx;

import java.util.Random;

public class LottoNumber {
    public static void main(String[] args) {
        Random rand = new Random();

        // 45개 짜리 배열
        int[] lotto = new int[45];

        for(int i = 0; i <45 ; i++){
            lotto[i] = i + 1;
        }
//        for(int n : lotto){ // 확인용 코드
//            System.out.println(n);
//        }

        int temp = 0; // swap 용 임시 변수
        int s = 0; // 난수 저장 변수

        for(int j = 0; j < 10000; j++) {
            s = rand.nextInt(45); // 0 ~ 44까지 생성. 배열의 순번
            temp = lotto[0];
            lotto[0] = lotto[s];
            lotto[s] = temp;
        } // 중복 상황을 배제하기 위한 알고리즘

        for(int k = 0; k < 6; k++) {
            System.out.println(lotto[k]);
        }
//        // swap 예
//        int a = 10;
//        int b = 20;
//        int c = 0;
//        c = a;
//        a = b;
//        b = c;
    }
}
