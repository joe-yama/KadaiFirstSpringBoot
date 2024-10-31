package com.techacademy;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class KadaiFirstController {

  @GetMapping("/dayofweek/{dateAsStr}")
  public String dispDayOfWeek(@PathVariable String dateAsStr) {
    LocalDate dateAsLocalDate = LocalDate.parse(dateAsStr, DateTimeFormatter.ofPattern("yyyyMMdd"));
    DayOfWeek dayOfweek = dateAsLocalDate.getDayOfWeek();
    return dayOfweek.getDisplayName(TextStyle.FULL, Locale.ENGLISH);
  }

  @GetMapping("/plus/{val1}/{val2}")
  public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
    int res;
    res = val1 + val2;
    return Integer.toString(res);
  }

  @GetMapping("/minus/{val1}/{val2}")
  public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
    int res;
    res = val1 - val2;
    return Integer.toString(res);
  }

  @GetMapping("/times/{val1}/{val2}")
  public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
    int res;
    res = val1 * val2;
    return Integer.toString(res);
  }

  @GetMapping("/divide/{val1}/{val2}")
  public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
    int res;
    try {
      res = val1 / val2;
    } catch (ArithmeticException e) {
      return "エラー: 0で除算しています。";
    }
    return Integer.toString(res);
  }

}
