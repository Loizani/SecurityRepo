package mvc;


import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class HelloWorldDispatcherServletInitializer implements WebApplicationInitializer {

		
	@Override
	public void onStartup(javax.servlet.ServletContext objJavaServletContext) throws ServletException {

		
		// Load Spring web application configuration
		AnnotationConfigWebApplicationContext	objSprWebAnnotConfWebAppContext = new AnnotationConfigWebApplicationContext();
		objSprWebAnnotConfWebAppContext.scan("mvc");
		objJavaServletContext.addListener(new ContextLoaderListener(objSprWebAnnotConfWebAppContext));
		
		objSprWebAnnotConfWebAppContext.register(mvcConfig.class);
		objSprWebAnnotConfWebAppContext.setServletContext(objJavaServletContext);
		
		org.springframework.web.servlet.DispatcherServlet objDispatcherServlet = new DispatcherServlet(objSprWebAnnotConfWebAppContext) ;		
		javax.servlet.ServletRegistration.Dynamic objDynamicServlet = objJavaServletContext.addServlet("DispatcherServletWithSecurityNoXML", objDispatcherServlet );

		objDynamicServlet.setLoadOnStartup(1);
		objDynamicServlet.addMapping("/");
	}

}
