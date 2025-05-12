package datetimeEx;

import java.util.Calendar;

public class MyCalender {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
//        System.out.println(cal);

        // 연도, 월, 일 구하기
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int date = cal.get(Calendar.DATE);
        System.out.printf("%d-%02d-%02d\n", year, month, date);

        // 시간 출력
//        int hour = cal.get(Calendar.HOUR); // 12시간 주기
        int hour = cal.get(Calendar.HOUR_OF_DAY); // 24시간 주기
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        System.out.printf("%02d:%02d:%02d\n", hour, minute, second);

        // 요일 출력
        int dow = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println(dow); // 1 : 일요일, 7 : 토요일

        // 현재 '일'을 포함한 달의 마지막 날
        int lastDay = cal.getActualMaximum(Calendar.DATE);
        System.out.println(lastDay);
        int startDay = cal.getActualMinimum(Calendar.DATE);
        System.out.println(startDay);

        // Calender 날짜 지정
        // set(상수, 값)
        cal.set(Calendar.YEAR, 2023);
        cal.set(Calendar.MONTH, 1); // 실제 월은 2월
        cal.set(Calendar.DATE, 1);

        year = cal.get(Calendar.YEAR);
        month = cal.get(Calendar.MONTH) + 1;
        date = cal.get(Calendar.DATE);
        System.out.printf("%d-%02d-%02d\n", year, month, date);

        lastDay = cal.getActualMaximum(Calendar.DATE);
        System.out.println(lastDay);
    }
}
