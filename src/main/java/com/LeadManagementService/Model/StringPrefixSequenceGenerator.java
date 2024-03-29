package com.LeadManagementService.Model;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;
import org.hibernate.type.spi.TypeConfiguration;

public class StringPrefixSequenceGenerator extends SequenceStyleGenerator{
	
	public static final String value_prefix_parameter="valuePrefix";
	public static final String value_prefix_default="";
	
	private String valuePrefix;
	
	public static final String number_format_parameter="numberFormat";
	public static final String number_format_default="%d";
	
	private String numberFormat;

	
	@Override
	public void configure(Type type, Properties parameters, ServiceRegistry serviceRegistry) throws MappingException {
		
		super.configure(new TypeConfiguration().getBasicTypeRegistry().getRegisteredType(Long.class), parameters, serviceRegistry);
		valuePrefix=ConfigurationHelper.getString(value_prefix_parameter, parameters,value_prefix_default);
		numberFormat=ConfigurationHelper.getString(number_format_parameter,parameters,number_format_default);
	}

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
	
		return valuePrefix + String.format(numberFormat, super.generate(session,object));
	}

	
	

}
