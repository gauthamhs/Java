

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class StringUtil
{
    
    private static final String DATE_FORMAT = "MM/dd/yyyy";
    private static final String DATETIME_FORMAT = "MM/dd/yyyy hh:mm:ss a";
    /**
     * Returns true if String is null, empty or contains one or more white
     * spaces.
     * 
     * @param str
     *            to be tested
     * @return true if String is empty
     */
    public static boolean isEmpty(String str)
    {
        if (str == null || str.trim().length() <= 0)
            return true;
        else
            return false;
    }

    /**
     * Returns true if String is not null or empty.
     * 
     * @param str
     *            to be tested
     * @return true if String is empty
     */
    public static boolean isNotNullOrEmpty(String str)
    {
        if (str != null && str.trim().length() > 0)
            return true;
        else
            return false;
    }

    /**
     * Trims leading and trailing spaces.
     * 
     * @param value
     * @return
     */
    public static String trim(String value)
    {
        if (value == null)
            return "";
        else if (value.trim().equalsIgnoreCase("null"))
            return "";
        else
            return value.trim();
    }

    /**
     * Splits the string based on the regex
     * 
     * @param str
     * @param regex
     * @return
     */
    public static String[] split(String str, String regex)
    {
        String[] tokens = {};

        if (!isEmpty(str) && !isEmpty(regex))
        {
            tokens = str.split(regex);
        }

        return tokens;
    }

    /**
     * Returns a substring containing a specified number of characters from a
     * string. This method is meant to be similar to the VB6 Mid$ function.
     * 
     * @param param
     *            String expression from which characters are returned.
     * @param index
     *            Character position in string at which the part to be taken
     *            begins. If start is greater than or equal to the number of
     *            characters in string, midStr returns a zero-length string
     * @param length
     *            Number of characters to return. If there are fewer than length
     *            characters in the text (including the character at start), all
     *            characters from the start position to the end of the string
     *            are returned.
     * @return
     */
    public static String midStr(String param, int startIndex, int length)
    {
        String result = "";

        if (startIndex >= param.length())
            result = "";
        else if (param.length() < startIndex + length)
            result = param.substring(startIndex);
        else
            result = param.substring(startIndex, startIndex + length);

        return result;
    }

    /**
     * Returns a substring containing a specified number of characters from the
     * beginning (left side) of a string. This method is meant to be similar to
     * the VB6 Left$ function.
     * 
     * @param param
     *            String expression from which the leftmost characters are
     *            returned.
     * @param length
     *            Integer indicating how many characters to return. If 0, a
     *            zero-length string ("") is returned. If greater than or equal
     *            to the number of characters in string, the entire string is
     *            returned.
     * @return
     */
    public static String leftStr(String param, int length)
    {
        String result = "";

        if (length == 0)
            result = "";
        else if (length >= param.length())
            result = param;
        else
            result = param.substring(0, length);

        return result;
    }

    /**
     * Returns a substring containing a specified number of characters from the
     * end (right side) of a string. This method is meant to be similar to the
     * VB6 Right$ function.
     * 
     * @param param
     *            String expression from which the rightmost characters are
     *            returned.
     * @param length
     *            Integer indicating how many characters to return. If 0, a
     *            zero-length string ("") is returned. If greater than or equal
     *            to the number of characters in string, the entire string is
     *            returned.
     * @return
     */
    public static String rightStr(String param, int length)
    {
        String result = "";

        if (length == 0)
            result = "";
        else if (length >= param.length())
            result = param;
        else
            result = param.substring(param.length() - length, param.length());

        return result;
    }

    /**
     * Converts java.lang.String to java.util.Date
     * 
     * @param stringDate
     *            (MM/DD/YYYY)
     * @return Date
     * @throws ParseException
     */
    public static Date getDate(String dateStr) throws ParseException
    {// MM/DD/YYYY

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        Date date = null;

        if (!isEmpty(dateStr) && !dateStr.equals("N/A"))
        {
            date = sdf.parse(dateStr);
        }
        return date;
    }
    
    /**
     * Converts java.lang.String to java.util.Date
     * 
     * @param stringDate
     *          
     * @return Date and Time
     *              MM/dd/yyyy hh:mm:ss a
     * @throws ParseException
     */
    public static Date getDateAndTime(String dateStr) throws ParseException
    {
      SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT);
      Date date = null;

      if (!isEmpty(dateStr) && !dateStr.equals("N/A"))
      {
          date = sdf.parse(dateStr);
      }
      return date;
      
    }

    /**
     * It returns today's date
     * 
     * @param dateStr
     * @return today's Date
     * @throws ParseException
     */
    public static String getCurrentDate() throws ParseException
    {// MM/DD/YYYY

      DateFormat df = new SimpleDateFormat(DATETIME_FORMAT);
      String currentDate = df.format(new Date());
        return currentDate;
    }
    
    public static String getDateAsString(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(date);
    }

    public static String getDateAndTimeAsString(Date date)
    {
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT);
        return sdf.format(date);
    }

    /**
     * Converts empty if null
     * @param iterable
     * @return
     */
    public static <T> Iterable<T> emptyIfNull(Iterable<T> iterable)
    {
        return iterable == null ? Collections.<T> emptyList() : iterable;
    }

    /**
     * Converts Date object to XMLGregorialCalendar object
     * 
     * @param date
     * @return
     */
    public static XMLGregorianCalendar toXMLGregorianCalendar(Date date)
    {
        XMLGregorianCalendar xmlCalendar = null;
        if (date != null)
        {
            GregorianCalendar gCalendar = new GregorianCalendar();
            gCalendar.setTime(date);

            try
            {
                xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
            }
            catch (DatatypeConfigurationException ex)
            {

            }
        }
        return xmlCalendar;
    }

    /**
     * Converts the XMLGregorialCalendar to Date object
     * 
     * @param calendar
     * @return
     */
    public static Date toDate(XMLGregorianCalendar calendar)
    {
        Date date = null;
        if (calendar != null)
        {
            date = calendar.toGregorianCalendar().getTime();
        }
        return date;
    }

    /**
     * Converts BigDecimal to Double
     * 
     * @param dec
     * @return
     */
    public static Double toDouble(BigDecimal dec)
    {
        Double val = null;
        if (dec != null)
        {
            val = Double.parseDouble(dec.toString());
           
        }
        return val;
    }

    /**
     * Converts double value to BigDecimal
     * 
     * @param val
     * @return
     */
    public static BigDecimal toBigDecimal(Double val)
    {
        BigDecimal bigDec = null;
        if (val != null)
        {
            bigDec = BigDecimal.valueOf(val);
        }
        return bigDec;
    }
  
    /**
     * Converts BigInteger to Integer, if null returns null
     * @param bigInt
     * @return
     */
    public static Integer toInteger(BigInteger bigInt){
        Integer val = null;
        
        if(bigInt !=null){
            val = bigInt.intValue();
        }
        return val;
    }
    
    /**
     * Converts Integer to BigInteger, if null returns null
     * @param val
     * @return
     */
    public static BigInteger toBigInteger(Integer val){
        BigInteger bigInt = null;
        if(val!=null){
            bigInt =  new BigInteger(Integer.toString(val)); 
        }
        
        return bigInt;
    }
    
    /**
     * Converts Integer to BigInteger, if null returns null
     * @param val
     * @return
     */
    public static BigInteger toBigInteger(String val){
        BigInteger bigInt = null;
        if(val!=null){
            bigInt =  new BigInteger(val); 
        }
        
        return bigInt;
    }
    
    /**
     * 
     * @param str
     * @return true if str is numeric
     */
    public static boolean isNumeric(String str){
    	try{  
    	    double d = Double.parseDouble(str);  
    	  }catch(NumberFormatException nfe){  
    	    return false;  
    	  }  
    	return true;
    }
}
