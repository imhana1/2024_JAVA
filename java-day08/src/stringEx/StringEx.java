package stringEx;

public class StringEx {
    public static void main(String[] args) {
        //문자열 생성 방법
        String str1 = "hello";//약식
        String str2 = new String("hello");//정식
        //문자배열로 문자열 생성
        char[] chs = {'h', 'e', 'l', 'l', 'o'};
        String str3 = new String(chs);
        //StringBuffer를 사용하여 문자열 생성.
        StringBuffer sb = new StringBuffer();//문자 시퀀스
        sb.append("hel");
        sb.append("lo");
        String str4 = new String(sb);
        String str5 = sb.toString();

        ////////////////////////////////////////
        System.out.println(str1.concat(" world"));
        System.out.println("world ".concat(str1));

        ////////////////////////////////////////
        char c = "안녕".charAt(0);//0번부터
        System.out.println(c);//

        ///////////////////////////////////////
        String str6 = "dog,cat:chicken-pig;rabbit parrot";
        String[] strs = str6.split("[ ,:;-]");
        //System.out.println(strs);
        for(String s : strs){
            System.out.println(s);
        }

        /////////////////////////////////////////////
        String str7 = "aa0bbcc1aaee3ggaa5gg";
        String str8 = str7.replace("aae", "E");
        System.out.println(str8);

        /////////////////////////////////////////////
        System.out.println(str7.indexOf("aa"));
        System.out.println(str7.indexOf("aa", 5));
        System.out.println(str7.lastIndexOf("aa"));
        System.out.println(str7);

        ////////////////////////////////////////////
        String str9 = str7.substring(str7.indexOf("cc"), 11);
        System.out.println(str9);
        System.out.println(str7);

    }//main end
}//class end
