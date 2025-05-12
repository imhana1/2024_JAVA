package datetimeEx;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date today = new Date();
        System.out.println(today);

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd (E)");
        String dayStr = sdf1.format(today);
        System.out.println(dayStr);

        SimpleDateFormat sdf2 =
                new SimpleDateFormat("[a] hh:mm:ss");
        String timeStr = sdf2.format(today);
        System.out.println(timeStr);

        SimpleDateFormat sdf3 = new SimpleDateFormat("F w W D");
        String str = sdf3.format(today);
        System.out.println(str);

    }
}
