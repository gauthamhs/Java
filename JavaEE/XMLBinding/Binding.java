
public interface Binding
{

    public Object unmarshall(String inputXML) throws BindingException;

    public String marshall(Object beanObj) throws BindingException;

}
