public static Date addDays(Date date, int days)
  {
      Calendar cal = Calendar.getInstance();
      cal.setTime(date);
      cal.add(Calendar.DATE, days); 
      return cal.getTime();
  }
  
  public static boolean isSaturday(Date date)
  {
      Calendar cal = Calendar.getInstance();
      cal.setTime(date);
      if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY){
        return true;
      }
      return false;
  }
  
  public static boolean isSunday(Date date)
  {
      Calendar cal = Calendar.getInstance();
      cal.setTime(date);
      if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
        return true;
      }
      return false;
  }
  
  public static Integer getYear(Date date)
  {
    if(date == null){
      return null;
    }
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    return calendar.get(Calendar.YEAR);
  }
