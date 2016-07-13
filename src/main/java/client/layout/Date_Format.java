package client.layout;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/**
 *
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2005 MTC touch</p>
 * <p>Company: MTC touch</p>
 * @author Ghadi Rayess
 * @version 1.0
 */
public class Date_Format {


  private static SimpleDateFormat oDateFormat_DAY_TIME = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" ,Locale.US);
  private static SimpleDateFormat oDateFormat_DAY_TIME2 = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss" ,Locale.US);
  private static SimpleDateFormat oDateFormat_DAY = new SimpleDateFormat("yyyy-MM-dd" ,Locale.US);
  private static SimpleDateFormat oDateFormat_DAYDMY = new SimpleDateFormat("dd-M-yyyy hh:mm:ss aaa" ,Locale.US);
  private static SimpleDateFormat oDateFormat_Month = new SimpleDateFormat("yyyy-MM" ,Locale.US);

 // private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//  private static DateFormat df_dmy = new SimpleDateFormat("dd-MM-yyyy");
 // private static DateFormat dft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  private Date_Format() {

  }
  static public Date getDate(String sdate) throws ParseException{

       return oDateFormat_DAY.parse(sdate);
  }
   static public Date getDateDMY(String sdate) throws ParseException{
       return oDateFormat_DAYDMY.parse(sdate);
  }
  static public Date getDateTime(String sdate) throws ParseException{
       return oDateFormat_DAY_TIME.parse(sdate);
  }
  static public String Format_Day_Time(Date date){
      if(date==null){
        return "N/A";
    }
    return oDateFormat_DAY_TIME.format(date);
  }
static public String Format_Day_Time2(Date date){
     if(date==null){
        return "N/A";
    }
    return oDateFormat_DAY_TIME2.format(date);
  }

static public String Format_Day(Date date){
     if(date==null){
        return "N/A";
    }
    return oDateFormat_DAY.format(date);
  }

static public String Format_DayDMY(Date date){
     if(date==null){
        return "N/A";
    }
    return oDateFormat_DAYDMY.format(date);
  }
  static public String Format_Month(Date date){
       if(date==null){
        return "N/A";
    }
    return oDateFormat_Month.format(date);
  }

  static public String LOG_FORMAT(String Parameters[], String Delimiter){
    String ReturnString = "";
    for (int index = 0; index < Parameters.length-1; index ++){
      ReturnString = Parameters[index] + Delimiter;
    }
    return ReturnString + Parameters[Parameters.length-2];
  }

}
