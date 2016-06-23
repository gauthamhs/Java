<bean id="billingServiceCXFEndpoint" class="org.apache.camel.component.cxf.CxfEndpoint" />

  private String CXF_BILLINGSERVICE_ENDPOINT =
      "cxf:bean:billingServiceCXFEndpoint?address={{service.billingservice.endpoint.address}}&serviceClass=com.ipacc.policy.platform.cancelpending.services.billingservice.BillingService&loggingFeatureEnabled=true";
      
          from(
        "spring-ws:soapaction:/CalculateCancelDate?endpointMapping=#policyCancelPendingServiceEndpointMapping")       
        .id("PolicyCancelPendingSoapService_CalculateCancelDate")
        .to("direct:calculateCancelPendingDate")
        .end();
        
            from("direct:billingSchedule").routeId("BillingSchedule")
    .bean(billingServiceWSProcessor, "processBillingScheduleRequest")
    .to(CXF_BILLINGSERVICE_ENDPOINT)
    .bean(billingServiceWSProcessor, "processBillingScheduleResponse")
    .end();
