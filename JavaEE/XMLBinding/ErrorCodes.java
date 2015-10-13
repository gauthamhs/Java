public enum ErrorCodes {

    XML_BINDING_CONTEXT_FAIL("1111","Failed to create the xml binding context."),
    XML_BINDING_MARSHALL_FAIL("2222","Failed to marshall the xml."),
    XML_BINDING_UNMARSHALL_FAIL("3333","Failed to unmarshall the object.");
    
        public final String errorCode;
    public final String errorMessage;

    ErrorCodes(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
    
    }
