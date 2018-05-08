package com.aman1.feelitsayit.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatter {

    public static String formateDate(Date date){
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String formattedDate  = simpleDateFormat.format(date);

        return formattedDate;
    }
}
