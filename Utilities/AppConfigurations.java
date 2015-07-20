import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.naming.NamingException;

import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.spi.ExchangeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.connection.JmsTransactionManager;
import org.springframework.jms.connection.UserCredentialsConnectionFactoryAdapter;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.jndi.JndiTemplate;
import org.springframework.transaction.PlatformTransactionManager;

import com.ipacc.policy.platform.cancelpending.config.properties.MessagingConfig;
import com.ipacc.policy.platform.composite.logging.ExchangeLogFormatter;

@Configuration
@PropertySource({"file:/${POLICYPLATFORM_CONFIG_DIR}/messaging.properties","file:/${POLICYPLATFORM_CONFIG_DIR}/database.properties","file:/${POLICYPLATFORM_CONFIG_DIR}/ile.properties"})
@ComponentScan(basePackages = { "com.ipacc.policy.platform.cancelpending", "com.ipacc.policy.entity.common.dao" })
@ImportResource({"classpath:/camel-config.xml"})
public class AppConfig  {
  
  @Autowired
MessagingConfig msgConfig;

    private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

    public AppConfig() {
        logger.info("Constructing AppConfig for policy-cancelpending-svc.");
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
        pspc.setIgnoreUnresolvablePlaceholders(true);
        return pspc;
    }

    @Bean
    public ConnectionFactory jmsConnectionFactory() throws NamingException {
        try {
          System.out.println("get jmsConnectionFactory");
          Properties props = new Properties();
          JndiObjectFactoryBean jndiFactory = new JndiObjectFactoryBean();
       
            props.put("java.naming.factory.initial", msgConfig.getInitialFactory());
            props.put("java.naming.provider.url", msgConfig.getUrl());
            props.put("java.naming.security.principal", msgConfig.getSecurityPrincipal());
            props.put("java.naming.security.credentials", msgConfig.getSecurityCredentials());

            jndiFactory.setJndiTemplate(new JndiTemplate(props));
            jndiFactory.setJndiName(msgConfig.getQueueFactory());

            jndiFactory.afterPropertiesSet();

            UserCredentialsConnectionFactoryAdapter connectionFactory = new UserCredentialsConnectionFactoryAdapter();

            connectionFactory.setUsername(msgConfig.getUsername());
            connectionFactory.setPassword(msgConfig.getPassword());
            connectionFactory.setTargetConnectionFactory((ConnectionFactory) jndiFactory.getObject());

            CachingConnectionFactory factory = new CachingConnectionFactory(connectionFactory);
            factory.setSessionCacheSize(10);
            factory.setCacheConsumers(false);

            return factory;
        } catch (Exception e) {
            throw new BeanCreationException("Cannot load ems jndi properties", e);
        }
    }
    
    @Bean
    public ConnectionFactory jmsConnectionFactoryILE() throws NamingException {
        try {
          System.out.println("get jmsConnectionFactoryILE");
          Properties props = new Properties();
          JndiObjectFactoryBean jndiFactory = new JndiObjectFactoryBean();

            props.put("java.naming.factory.initial", msgConfig.getInitialFactory());
            props.put("java.naming.provider.url", msgConfig.getUrlILE());
            props.put("java.naming.security.principal", msgConfig.getSecurityPrincipalILE());
            props.put("java.naming.security.credentials", msgConfig.getSecurityCredentialsILE());
   
            jndiFactory.setJndiTemplate(new JndiTemplate(props));
            jndiFactory.setJndiName(msgConfig.getQueueFactoryILE());

            jndiFactory.afterPropertiesSet();

            UserCredentialsConnectionFactoryAdapter connectionFactory = new UserCredentialsConnectionFactoryAdapter();

            connectionFactory.setUsername(msgConfig.getUsernameILE());
            connectionFactory.setPassword(msgConfig.getPasswordILE());
          
            connectionFactory.setTargetConnectionFactory((ConnectionFactory) jndiFactory.getObject());

            CachingConnectionFactory factory = new CachingConnectionFactory(connectionFactory);
            factory.setSessionCacheSize(10);
            factory.setCacheConsumers(false);

            return factory;
        } catch (Exception e) {
            throw new BeanCreationException("Cannot load ems jndi properties", e);
            
        }
    }

    @Bean(name = "jmsTransactionManager")
    public PlatformTransactionManager jmsTransactionManager() throws NamingException {
        return new JmsTransactionManager(jmsConnectionFactory());
    }

    @Bean
    public JmsComponent jmsComponent() throws NamingException {
        JmsComponent component = new JmsComponent();
        component.setConnectionFactory(jmsConnectionFactory());
        component.setTransactionManager(jmsTransactionManager());
        component.setPreserveMessageQos(true);
        
        return component;
    }
    
    @Bean(name = "logFormatter")
    public ExchangeFormatter logFormatter() {
        return new ExchangeLogFormatter();
    }

}
