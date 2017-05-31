package com.sapient.configuration;

import java.util.Properties;

import javax.jms.ConnectionFactory;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.destination.JndiDestinationResolver;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.jndi.JndiTemplate;

import com.sapient.jms.CometSolaceProperties;
import com.solacesystems.jms.SupportedProperty;




@Configuration
public class SolaceContextLoader {
	
	
	@Autowired
	private CometSolaceProperties prop;
	
	
	@Bean
	@Lazy
	public JmsTemplate jmsTemplate()
	
	{
		
		JmsTemplate  jmsTemplate = new JmsTemplate();
		jmsTemplate.setConnectionFactory(getConnectionfactory());
		jmsTemplate.setDefaultDestinationName(prop.getDefaultDestination());
		jmsTemplate.setPubSubDomain(true);
		jmsTemplate.setDeliveryPersistent(true);
		jmsTemplate.setExplicitQosEnabled(true);
		return jmsTemplate;
		
	}
	
	

	public CachingConnectionFactory getConnectionfactory ()
	{
		
		CachingConnectionFactory cachedFactory= new CachingConnectionFactory();
		cachedFactory.setTargetConnectionFactory((ConnectionFactory) getSolaceConnectionFactory());
		cachedFactory.setSessionCacheSize(prop.getSessionSize());
				
		return cachedFactory;
		
	}
	
	@Bean
	@Lazy
	public JndiObjectFactoryBean getSolaceConnectionFactory()
	{
		JndiObjectFactoryBean jndiObjectFactoryBean =new JndiObjectFactoryBean();
		jndiObjectFactoryBean.setJndiTemplate(getsolaceJndiTemplate());
		jndiObjectFactoryBean.setJndiName(prop.getJndiName());
		
		
		return jndiObjectFactoryBean;
	}
	

	public JndiDestinationResolver  jndiDestinationResolver()
	
	{
		JndiDestinationResolver resolver = new JndiDestinationResolver();
		resolver.setCache(true);
		resolver.setJndiTemplate(getsolaceJndiTemplate());
		return resolver;
	}
	

	
	public JndiTemplate getsolaceJndiTemplate()
	{
		JndiTemplate jndiTemplate= new JndiTemplate();
	    Properties jndiprops = new Properties();
	    jndiprops.setProperty(InitialContext.INITIAL_CONTEXT_FACTORY, prop.getContextFactory());
	    jndiprops.setProperty(SupportedProperty.SOLACE_JMS_VPN, prop.getVpn());
	    jndiprops.setProperty(InitialContext.PROVIDER_URL, prop.getProviderURL());
	    jndiprops.setProperty(Context.SECURITY_PRINCIPAL, prop.getSecurityPrincipal());
	    jndiprops.setProperty(Context.SECURITY_CREDENTIALS,prop.getCredential());
	    jndiprops.setProperty(SupportedProperty.SOLACE_JMS_SSL_TRUST_STORE_FORMAT, prop.getTrustStoreFormat());
	    jndiprops.setProperty(SupportedProperty.SOLACE_JMS_SSL_TRUST_STORE, prop.getTrustStore());
	    jndiprops.setProperty(SupportedProperty.SOLACE_JMS_SSL_TRUST_STORE_PASSWORD, prop.getStorePasssword());
	    jndiTemplate.setEnvironment(jndiprops);
	    return jndiTemplate;
		
	}

}
