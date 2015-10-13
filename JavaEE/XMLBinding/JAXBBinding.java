import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import ErrorCodes
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JaxbBinding implements Binding
{
    private static final Logger LOGGER = LoggerFactory.getLogger(JaxbBinding.class);

    private String bindingPackage;
    @SuppressWarnings("rawtypes")
    private Class[] bindClasses;
    private JAXBContext context;

    /**
     * 
     */
    private JaxbBinding()
    {
        
    }

    /**
     * Unmarshalls the input xmla and returns the Jaxb object
     * @param inputXML
     * @param objectType
     * @return
     * @throws BindingException
     */
    @Override
    public Object unmarshall(String inputXML) throws BindingException
    {
        Unmarshaller unMarshaller = getUnMarshaller();
        Object result = null;

        try
        {
            /*
             * Unmarshalls the input xml 
             */
            result = unMarshaller.unmarshal(new StringReader(inputXML));
        }
        catch (JAXBException jaxbe)
        {
            if (LOGGER.isDebugEnabled())
            {
                String errMsg = new StringBuilder()
                        .append("from XML Data: ").append(inputXML).toString();
                LOGGER.error(errMsg, jaxbe);
            }
            throw new BindingException(ErrorCodes.XML_BINDING_UNMARSHALL_FAIL.errorCode, jaxbe);
        }
//        return objectType.cast(result);
        return result;
    }

    /**
     * Marshalls the jaxb object and returns the xml
     * @param beanObj
     * @return
     * @throws BindingException
     */
    @Override
    public String marshall(Object beanObj) throws BindingException
    {
        Marshaller marshaller = getMarshaller();
        StringWriter resultXML = new StringWriter();
        try
        {
            /*
             * Marshalls the input object
             */
            
            marshaller.marshal(beanObj, resultXML);
        }
        catch (JAXBException jaxbe)
        {
            if (LOGGER.isDebugEnabled())
            {
                String errMsg = new StringBuilder().append("Exception while marshalling the object ").append(beanObj).toString();
                LOGGER.error(errMsg, jaxbe);
            }
            throw new BindingException(ErrorCodes.XML_BINDING_MARSHALL_FAIL.errorCode, jaxbe);
        }
        return resultXML.toString();
    }

    /**
     * Creates the Jaxb Context
     * @throws BindingException
     */
    private synchronized void createJAXBContext() throws BindingException
    {
        try
        {
            if (context == null)
            {
                /*
                 * Context based on the binding package or binding classes
                 */
                if (bindClasses != null && bindClasses.length > 0)
                {
                  context = JAXBContext.newInstance(bindClasses);
                }
                else if (bindingPackage != null && bindingPackage.length() > 0)
                {
                    context = JAXBContext.newInstance(bindingPackage);
                }
                else
                {
                    throw new BindingException("No JAXB Binding specified");
                }
            }
        }
        catch (JAXBException jaxbe)
        {
            if (LOGGER.isDebugEnabled())
            {
                String errMsg = new StringBuilder().append("Exception while creating JAXBContext for packages ").append(bindingPackage)
                        .toString();
                LOGGER.error(errMsg, jaxbe);
            }
            throw new BindingException(ErrorCodes.XML_BINDING_CONTEXT_FAIL.errorCode, jaxbe);
        }
    }

    /**
     * Gets the Jaxb Context
     * @return
     * @throws BindingException
     */
    protected JAXBContext getJAXBContext() throws BindingException
    {
        if (context == null)
        {
            createJAXBContext();
        }
        return context;
    }
    
    /**
     * Gets the XML binding object for the package
     * @param bindingPackage
     * @return
     * @throws BindingException
     */
    public synchronized static Binding getBinding(String bindingPackage) throws BindingException
    {
        try
        {
            JaxbBinding binding = new JaxbBinding();
            binding.setBindingPackage(bindingPackage);
            return binding;
        }
        catch (Exception jaxbe)
        {
            throw new BindingException(ErrorCodes.XML_BINDING_CONTEXT_FAIL.errorCode, jaxbe);
        }
    }

    /**
     * Gets the XML binding object for list of classes
     * @param bindClasses
     * @return
     * @throws BindingException
     */
    public synchronized static Binding getBinding(@SuppressWarnings("rawtypes") Class... bindClasses) throws BindingException
    {
        try
        {
            JaxbBinding binding = new IPACCJaxbBinding();
            binding.setBindClasses(bindClasses);
            return binding;
        }
        catch (Exception jaxbe)
        {
            throw new BindingException(ErrorCodes.XML_BINDING_CONTEXT_FAIL.errorCode, jaxbe);
        }
    }
    

    /**
     * Gets the JaxB unmarshaller
     * @return
     * @throws BindingException
     */
    protected Unmarshaller getUnMarshaller() throws BindingException
    {
        Unmarshaller unMarshaller = null;

        try
        {
            unMarshaller = getJAXBContext().createUnmarshaller();
        }
        catch (JAXBException jaxbe)
        {
            if (LOGGER.isDebugEnabled())
            {
                String errMsg = new StringBuilder().append("Exception while creating Unmarshaller for packages ").append(bindingPackage)
                        .toString();
                LOGGER.error(errMsg, jaxbe);
            }
            throw new BindingException(ErrorCodes.XML_BINDING_UNMARSHALL_FAIL.errorCode, jaxbe);
        }
        return unMarshaller;
    }

    /**
     * Gets the JaxB marshaller
     * @return
     * @throws BindingException
     */
    protected Marshaller getMarshaller() throws BindingException
    {
        Marshaller marshaller = null;

        try
        {
            marshaller = getJAXBContext().createMarshaller();
        }
        catch (JAXBException jaxbe)
        {
            if (LOGGER.isDebugEnabled())
            {
                String errMsg = new StringBuilder().append("Exception while creating marshaller for packages ").append(bindingPackage)
                        .toString();
                LOGGER.error(errMsg, jaxbe);
            }
            throw new BindingException(ErrorCodes.XML_BINDING_MARSHALL_FAIL.errorCode, jaxbe);
        }

        return marshaller;
    }

    

    /**
     * Sets the binding package
     * @param bindingPackage
     */
    protected void setBindingPackage(String bindingPackage)
    {
        this.bindingPackage = bindingPackage;
    }

    /**
     * sets the binding classes
     * @param bindClasses
     */
    protected void setBindClasses(@SuppressWarnings("rawtypes") Class[] bindClasses)
    {
        this.bindClasses = bindClasses;
    }
    
}
