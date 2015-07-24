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
  
  public static String convertDateToString(java.util.Date thisDate, String pattern){
      if(thisDate == null){
          return "";
        }
        SimpleDateFormat simpleDate = new SimpleDateFormat(pattern);
        String dateString = simpleDate.format(thisDate);
        return dateString;
      }

public static Date getDate(Date originalDate, int offDays){
	    java.util.Calendar calendar = java.util.Calendar.getInstance();
	    calendar.setTime(originalDate);
	    calendar.add(java.util.Calendar.DATE, offDays);
	    java.util.Date date = calendar.getTime();
	    return date;
	  }
	 
	  public static Date getDate(int offSetFromToday){
	    java.util.Calendar calendar = java.util.Calendar.getInstance();
	    java.util.Date todayDate = new java.util.Date();
	    calendar.setTime(todayDate);
	    calendar.add(java.util.Calendar.DATE, offSetFromToday);
	    java.util.Date date = calendar.getTime();
	    return date;
	  }
	  
	  public static Date getDateAndTimeFromToday(int offSetFromToday){
        String todayString = FormatData.convertDateToString(new java.util.Date(), "MM/dd/yyyy");
        Date today = FormatData.convertStringToDate(todayString + " 00:00:00");
        return FormatData.getDate(today, offSetFromToday);       
      }
      
        public static Date getDateAndTimeFromToday(int offSetFromToday){
        String todayString = FormatData.convertDateToString(new java.util.Date(), "MM/dd/yyyy");
        Date today = FormatData.convertStringToDate(todayString + " 00:00:00");
        return FormatData.getDate(today, offSetFromToday);       
      }
	  
	  public static Date getDateAndTimeFromTodaywithTime(int offSetFromToday, String time){        
        String todayString = FormatData.convertDateToString(new java.util.Date(), "MM/dd/yyyy");
        Date today = FormatData.convertStringToDate(todayString + " "+time);
        return FormatData.getDate(today, offSetFromToday);       
      }
    
	/**
	   * Converts a String to Date.
	   * @param dateStr ("MM/dd/yyyy HH:mm:ss a" or "MM/dd/yyyy HH:mm:ss" or "MM/dd/yyyy" or "yyyyMMdd" )
	   * @return
	   * @throws IllegalArgumentException 
	   */
	  public static Date convertStringToDate(String dateStr) throws IllegalArgumentException
	  {
	    Date date=null;
	    SimpleDateFormat sdf=null;
	    
	        if (!FormatData.isEmpty(dateStr))
	        {
	            if (date == null)
	            {
	                try
	                {
	                    sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
	                    date = sdf.parse(dateStr);
	                }
	                catch (ParseException pe)
	                {
	                }
	            }
	            if (date == null)
	            {
	                try
	                {
	                    sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	                    date = sdf.parse(dateStr);
	                }
	                catch (ParseException pe)
	                {
	                }
	            }
	            if (date == null)
	            {
	                try
	                {
	                    sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");
	                    date = sdf.parse(dateStr);
	                }
	                catch (ParseException pe)
	                {
	                }
	            }

	            if (date == null)
	            {
	                try
	                {
	                    sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS z");
	                    date = sdf.parse(dateStr);
	                }
	                catch (ParseException pe)
	                {
	                }
	            }
	            
	            
	            if (date == null)
	            {
	                try
	                {
	                    sdf = new SimpleDateFormat("MM/dd/yyyy");
	                    date = sdf.parse(dateStr);
	                }
	                catch (ParseException pe)
	                {
	                }
	            }
	            
	            if (date == null)
	            {
	                try
	                {
	                    sdf = new SimpleDateFormat("M/dd/yyyy");
	                    date = sdf.parse(dateStr);
	                }
	                catch (ParseException pe)
	                {
	                }
	            }
	            if (date == null)
	            {
	                try
	                {
	                    sdf = new SimpleDateFormat("MM/d/yyyy");
	                    date = sdf.parse(dateStr);
	                }
	                catch (ParseException pe)
	                {
	                }
	            }
	            if (date == null)
	            {
	                try
	                {
	                    sdf = new SimpleDateFormat("M/d/yyyy");
	                    date = sdf.parse(dateStr);
	                }
	                catch (ParseException pe)
	                {
	                }
	            }


	            if (date == null)
	            {
	                try
	                {
	                    sdf = new SimpleDateFormat("yyyyMMdd");
	                    date = sdf.parse(dateStr);
	                }
	                catch (ParseException pe)
	                {
	                }
	            }
	            if (date == null)
	            {
	                try
	                {
	                    sdf = new SimpleDateFormat("yyyy-MM-dd");
	                    date = sdf.parse(dateStr);
	                }
	                catch (ParseException pe)
	                {
	                }
	            }
	            
	            if (date == null)
	                throw new IllegalArgumentException(
	                        "Unable to parse "
	                                + dateStr
	                                + "to Date format. The date String should be in \"MM/dd/yyyy HH:mm:ss a\" or \"MM/dd/yyyy HH:mm:ss\" or \"MM/dd/yyyy\" or \"yyyyMMdd\" format. ");
	        }
	    return date;
	  }
