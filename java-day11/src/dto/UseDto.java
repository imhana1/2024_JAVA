package dto;

public class UseDto {
    public static void main(String[] args) {
        DataDto dd = new DataDto();
        dd.setCode(1);
        dd.setStr("abc");
        dd.setIntVal(100);

        System.out.println(dd.getCode());
        System.out.println(dd.getStr());
        System.out.println(dd.getIntVal());
    }
}
