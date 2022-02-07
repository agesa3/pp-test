package com.agesadev.employee.app;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import javax.servlet.ServletRegistration;

@EnableWs
@Configuration
public class WebServiceConfiguration extends WsConfigurerAdapter {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/agesadev/*");
    }

    @Bean(name = "employees")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema employeeSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("agesaServiceSoapHttp");
        wsdl11Definition.setLocationUri("/agesadev");
        wsdl11Definition.setTargetNamespace("agesadev.com");
        wsdl11Definition.setSchema(employeeSchema);
        return wsdl11Definition;
    }



    @Bean
    public XsdSchema employeeSchema() {
        return new SimpleXsdSchema(new ClassPathResource("employee.xsd"));
    }

}