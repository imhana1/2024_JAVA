package phonebook.dao;

import phonebook.dto.PhoneDto;

import java.util.ArrayList;

public class PhoneDao {
    //데이터 저장소(Repository) -> DB
    //ArrayList로 생성
    private ArrayList<PhoneDto> phoneInfoList = new ArrayList<>();
    //데이터 저장 단위는 하나의 dto(정보 묶음)

    //위의 arraylist를 활용할 수 있는 메소드 작성.
    //마지막으로 입력된 연락처의 일련번호를 구하는 메소드
    public int getLastNo(){
        int lastNo = 0;
        int pListSize = phoneInfoList.size();
        //현재 저장된 연락처의 개수
        
        //중간에 삭제가 진행될 수 있음.
        if(pListSize != 0){
            //마지막 위치의 연락처 정보를 꺼내온다.
            PhoneDto p = phoneInfoList.get(pListSize - 1);
            lastNo = p.getPno();//마지막 연락처의 일련번호
        }

        return lastNo;
    }

    //저장소(arraylist)에 저장하는 메소드 : create(insert)
    public void setPhoneInfoList(PhoneDto pinfo){
        phoneInfoList.add(pinfo);
    }

    //저장소의 정보를 읽어오는 메소드들 : read(select)
    //1. 전체 출력용 메소드
    public ArrayList<PhoneDto> getPhoneInfoList(){
        return phoneInfoList;
    }
    //2. 검색 출력(개별 출력) - 이름(동명이인이 존재하기 때문에)
    public ArrayList<PhoneDto> getNameInfo(String name){
        //검색 결과를 담기위한 list
        ArrayList<PhoneDto> nList = new ArrayList<>();
        //전체 연락처 목록에서 한명씩의 정보를 꺼내 이름을 비교
        for(PhoneDto p : phoneInfoList){
            if(name.equals(p.getPname())){//이름 비교
                nList.add(p);//이름이 같으면 결과 목록에 저장
            }
        }
        return nList;//검색 결과 넘기기
    }

    //연락처 검색
    public ArrayList<PhoneDto> getNumberInfo(String number){
        ArrayList<PhoneDto> nList = new ArrayList<>();
        for(PhoneDto p : phoneInfoList){
            if(number.equals(p.getPnumber())){
                nList.add(p);
            }
        }
        return nList;
    }

    //생일 검색
    public ArrayList<PhoneDto> getBirthInfo(String birth){
        ArrayList<PhoneDto> bList = new ArrayList<>();
        for(PhoneDto p : phoneInfoList){
            if(birth.equals(p.getPbirth())){
                bList.add(p);
            }
        }
        return bList;
    }

    //연락처 수정 : update
    public String updatePhone(PhoneDto phone, int number){
        String result = null;
        // 1, 2, 3, 5, 6, 7, 10, 12, <- number(pno)
        // 0  1  2  3  4  5   6   7  <- i(데이터의 위치값)
        for(int i = 0; i < phoneInfoList.size(); i++){
            PhoneDto p = phoneInfoList.get(i);
            if(number == p.getPno()){
                phoneInfoList.set(i, phone);
                result = "수정 성공";
                break;
            }
        }
        if(result == null){
            result = "해당 데이터 없음";
        }
        return result;
    }//method end

    //연락처 삭제 : delete
    public String deletePhone(int number){
        String result = null;
        for(PhoneDto p : phoneInfoList){
            if(number == p.getPno()){
                phoneInfoList.remove(p);
                result = "삭제 성공";
                break;
            }
        }
        if(result == null){
            result = "해당 데이터 없음";
        }
        return result;
    }

    public PhoneDto selectPhoneInfo(int pno) {
        for (PhoneDto p : phoneInfoList){
            if (pno == p.getPno()){
                return p;
            }
        }
        return null; // 없다, 검색한 번호에 해당하는 연락처가 없다
    }
}//class end


