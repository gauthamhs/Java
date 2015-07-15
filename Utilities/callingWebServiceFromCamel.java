public class Processor {
	
	private static final Logger logger = LoggerFactory.getLogger(Processor.class);
	
	public void processRequest(Exchange exchange) throws Exception{
		
		try{
			
		String payload = exchange.getIn().getBody(String.class);
		
	      Request Request =
	              DomainSerializer.getInstance().fromXml(payload, Request.class);
	      
	      Integer year = Request.getYear();
	      
	      RequestHeaderType requestHeader = new RequestHeaderType();
	      ServiceInfoType value = new ServiceInfoType();
	      requestHeader.setServiceInfo(value);
	      
	      RequestCriteriaType Request = new RequestCriteriaType();
	      Request.setYear(year);
	      
	      List<Object> list = new ArrayList<Object>();
	      list.add(requestHeader);
	      list.add(Request);
	      
	      exchange.getIn().setHeader(CxfConstants.OPERATION_NAME, "getHolidays");
	      exchange.getIn().setBody(list);
		} catch (Exception e) {
        e.printStackTrace();
      }
	      
	}
	
	  public void processCESHolidaysResponse(Exchange exchange) throws Exception {
		    try {
		    	
		    	ResponseType response = null;
		      
		      Holidays Holidays = null;
		      
		      try {
		        MessageContentsList result = (MessageContentsList) exchange.getIn().getBody();
		        if (result != null) {
		          response = (HolidaysResponseType) result.get(0);
		          cesHolidays = (Holidays)(response.getHolidays().get(0));
		          
		          exchange.getIn().setHeader(Constants.HEADER_SERVICE_RESPONSE_SUCCESS, Constants.SERVICE_RESPONSE_SUCCESS_Y);
		        } else {
		          exchange.getIn().setHeader(Constants.HEADER_SERVICE_RESPONSE_SUCCESS, Constants.SERVICE_RESPONSE_SUCCESS_N);
		        }
		      } catch (Exception e) {
		        e.printStackTrace();
		        exchange.getIn().setHeader(Constants.HEADER_SERVICE_RESPONSE_SUCCESS, Constants.SERVICE_RESPONSE_SUCCESS_N);
		      }
		      String paymentString = DomainSerializer.getInstance().toXml(Holidays);
		      
		      exchange.getIn().setBody(paymentString);

		    } catch (Exception e) {

		      exchange.getIn().setBody(e.getMessage());
		    }
		  }
	
	  public void processUnsupportOperation(Exchange exchange) throws Exception {
		    String Action = (String) exchange.getIn().getHeader("Action");

		    logger.info("Begin XYZ - processUnsupportOperation");

		    exchange.getIn().setBody("error");
		  }

}
