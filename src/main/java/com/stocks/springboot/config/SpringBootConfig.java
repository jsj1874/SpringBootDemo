package com.stocks.springboot.config;

import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;  

@SpringBootConfiguration
public class SpringBootConfig {
	@Value("${server.port}")
	private int port;

	/*@Bean
	  public EmbeddedServletContainerFactory servletContainer() {
	    TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory();
	    tomcat.addAdditionalTomcatConnectors(createHttpConnector());
	    return tomcat;
	  }

	  private Connector createHttpConnector() {
	    Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
	    connector.setScheme("http");
	    connector.setPort(port);
	    connector.setSecure(false);
	    return connector;
	  }*/
}
