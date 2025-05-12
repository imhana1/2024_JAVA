package phonebook.dto;

//이름, 연락처, 주소, 생일정보
public class PhoneDto {
    //개별적인 정보 식별을 위해 일련번호 추가
    private int pno;
    private String pname;
    private String pnumber;
    private String paddr;
    private String pbirth;

    public int getPno() {
        return pno;
    }

    public void setPno(int pno) {
        this.pno = pno;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPnumber() {
        return pnumber;
    }

    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    public String getPaddr() {
        return paddr;
    }

    public void setPaddr(String paddr) {
        this.paddr = paddr;
    }

    public String getPbirth() {
        return pbirth;
    }

    public void setPbirth(String pbirth) {
        this.pbirth = pbirth;
    }

    @Override
    public String toString() {
        String str = "번호 : " + pno + "\n"
                + "이름 : " + pname + "\n"
                + "연락처 : " + pnumber + "\n"
                + "주소 : " + paddr + "\n"
                + "생일 : " + pbirth;
        return str;
    }
}
