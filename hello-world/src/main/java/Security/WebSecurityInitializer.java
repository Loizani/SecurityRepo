package Security;


import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class WebSecurityInitializer extends AbstractSecurityWebApplicationInitializer {
	public WebSecurityInitializer() {
		super();
		System.out.println("WebSecurityInitializer") ;  
	}
}
