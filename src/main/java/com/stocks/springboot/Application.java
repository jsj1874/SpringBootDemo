package com.stocks.springboot;

import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.embedded.jetty.JettyServerCustomizer;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * 
 * @SpringBootApplication相对与@Configuration、@EnableAutoConfiguration和  @ComponentScan
 */
@SpringBootApplication
@ComponentScan(basePackages={"com.stocks.springboot.controller","com.stocks.springboot.service","com.stocks.springboot.aspect",
		"com.stocks.springboot"})
//@ComponentScan(value = "cn.stocks.springboot")
public class Application extends SpringBootServletInitializer{
	
	
	public static void main(String[] args) {
		 SpringApplication.run(Application.class, args);
		// SpringApplication.r
		
	}
	
	
	
	 /*@Profile("jetty")
     @Bean
     public JettyEmbeddedServletContainerFactory jettyEmbeddedServletContainerFactory(
             JettyServerCustomizer jettyServerCustomizer) {
         JettyEmbeddedServletContainerFactory factory = new JettyEmbeddedServletContainerFactory();
         factory.addServerCustomizers(jettyServerCustomizer);
         return factory;
     }
*/

     @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
    	 
		return builder.sources(this.getClass());
	}


     /*
	@Bean
     public JettyServerCustomizer jettyServerCustomizer() {
         return server -> {
             // Tweak the connection config used by Jetty to handle incoming HTTP
             // connections
             final QueuedThreadPool threadPool = server.getBean(QueuedThreadPool.class);
             threadPool.setMaxThreads(100);
             threadPool.setMinThreads(20);
         };
     } */
     

     
     private Connector initiateHttpConnector() {

       Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
       connector.setScheme("http");
       connector.setPort(8080);
       connector.setSecure(false);
       connector.setRedirectPort(8443);
       return connector;
     }

}
