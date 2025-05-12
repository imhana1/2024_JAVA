package phonebook.service;

import phonebook.dao.PhoneDao;
import phonebook.dto.PhoneDto;

import java.util.ArrayList;

public class PhoneService {
    // 연락처 프로그램의 기능을 제공하는 클래스(실무자)


    private PhoneDao pDao = new PhoneDao();

    // 입력 처리 메소드
    public String insertPhoneInfo(PhoneDto phone) {
        // 컨트롤러가 phone 을 주면, Dao 에 전달
        // 일련 번호 구하기
        int lastNo = pDao.getLastNo(); // 마지막 번호
        phone.setPno(lastNo + 1);

        pDao.setPhoneInfoList(phone);

        return "입력 성공";
    }// insert end

    // 목록 출력 기능을 처리하는 메소드
    public ArrayList<PhoneDto> selectPhoneList(){
        // Dao 에게 목록을 요청
        ArrayList<PhoneDto> pList = pDao.getPhoneInfoList();

        return pList;
    }

    public String deletePhone(int pno) {
        String msg = pDao.deletePhone(pno);
        return msg;
    }

    public ArrayList<PhoneDto> getNames(String keyword) {
        ArrayList<PhoneDto> rList = pDao.getNameInfo(keyword);
        return rList;
    }

    public ArrayList<PhoneDto> getnumber(String keyword) {
        ArrayList<PhoneDto> rList = pDao.getNumberInfo(keyword);
        return rList;
    }
    public ArrayList<PhoneDto> getBirth(String keyword) {
        ArrayList<PhoneDto> rList = pDao.getBirthInfo(keyword);
        return rList;
    }
    public PhoneDto getPhoneInfo(int pno) {
        PhoneDto phone = pDao.selectPhoneInfo(pno);
        return phone;
    }

    public String updatePhone(PhoneDto phone, int pno) {
        String msg = null;

        msg = pDao.updatePhone(phone, pno);

        return msg;
    }

}// class end
