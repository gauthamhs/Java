/**
 * Project Name : policy-cancellation-svc
 * Java Class   : IPACCBaseCancelProcesor.java
 * Date			: Jun 18, 2015
 * Author		: ChilukA
 */
package com.ipacc.policy.platform.policycancellation.processor;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Source;

import org.springframework.ws.soap.SoapHeaderElement;

import com.ipacc.policy.platform.policycancellation.jaxb.cncl.ObjectFactory;
import com.ipacc.policy.platform.policycancellation.jaxb.cncl.ServiceInfoType;

public class IPACCBaseCancellationProcessor
{

    protected static final String POLICY_CANCELLATION = "PolicyCancellation";

    protected static final String SERVICE_INFO = "ServiceInfo";

    @SuppressWarnings("unchecked")
    protected ServiceInfoType getServiceInfoType(SoapHeaderElement soapHeaderElement)
    {

        ServiceInfoType serviceInfoType = null;

        if (soapHeaderElement == null)
        {
            return null;
        }

        try
        {

            Source source = soapHeaderElement.getSource();

            JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Object serviceInfoObject = unmarshaller.unmarshal(source);

            serviceInfoType = ((JAXBElement<ServiceInfoType>) serviceInfoObject).getValue();

        }
        catch (JAXBException exp)
        {

            exp.printStackTrace();
        }
        return serviceInfoType;

    }
}
