package com.youxu.business.utils.transicatetool;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTransform {

    public static Date stringFormatTransToDate(String simpleDateString){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition parsePosition = new ParsePosition(0);
        Date periodOfValidityNew = simpleDateFormat.parse(simpleDateString, parsePosition);
        return periodOfValidityNew;
    }
}
