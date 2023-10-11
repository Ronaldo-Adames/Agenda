package com.example.agenda.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

  public static String tryParseDate(String date) {
    SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");
    Date formattedDate = null;

    try {
      formattedDate = inputFormat.parse(date);
    } catch (ParseException e) {
      formattedDate = new Date();
    }

    return outputFormat.format(formattedDate);
  }


}
