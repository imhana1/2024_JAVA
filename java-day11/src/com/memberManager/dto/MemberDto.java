package com.memberManager.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MemberDto {
    //멤버 변수는 DB 테이블의 컬럼명과 동일하게 작성.
    private String uid;
    private String upass;
    private String uname;
    private int uage;
    private String uaddr;

    @Override
    public String toString() {
        return """
                ID : %s
                NAME : %s
                AGE : %d
                ADDRESS : %s""".formatted(uid, uname, uage, uaddr);
    }
}

