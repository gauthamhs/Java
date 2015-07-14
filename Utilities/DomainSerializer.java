import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.thoughtworks.xstream.XStream;

/**
 * Utility class for serializing a Java object to XML or JSON.
 *
 */
public class DomainSerializer {
    private volatile static DomainSerializer INSTANCE = null;

    private DomainSerializer() {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, true);
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    }

    private XStream      xstream      = new XStream();
    private ObjectMapper objectMapper = new ObjectMapper();

    public static DomainSerializer getInstance() {
        if (INSTANCE == null) {
            synchronized (DomainSerializer.class) {
                INSTANCE = new DomainSerializer();
            }
        }

        return INSTANCE;
    }

    public String toXml(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("object must not be null.");
        }

        return xstream.toXML(object);
    }

    @SuppressWarnings("unchecked")
    public <T> T fromXml(String xml, Class<T> requiredType) {
        if (StringUtils.isBlank(xml)) {
            throw new IllegalArgumentException("xml must not be null or empty.");
        }

        if (requiredType == null) {
            throw new IllegalArgumentException("requiredType must not be null.");
        }

        return (T) xstream.fromXML(xml);
    }

    public String toJson(Object object) throws IOException {
        if (object == null) {
            throw new IllegalArgumentException("object must not be null.");
        }

        return objectMapper.writeValueAsString(object);
    }

    public <T> T fromJson(String json, Class<T> requiredType) throws IOException {
        if (StringUtils.isBlank(json)) {
            throw new IllegalArgumentException("json must not be null or empty.");
        }

        return objectMapper.readValue(json, requiredType);
    }
}
