package Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.csrf.CsrfTokenRepository;
//import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) {
		try {
			auth.inMemoryAuthentication().withUser("user").password("{noop}user").roles("USER");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/*").permitAll().and().formLogin().usernameParameter("username")
//				.passwordParameter("password").loginProcessingUrl("/login").loginPage("/singers")
//				.failureUrl("/security/loginfail").defaultSuccessUrl("/singers").permitAll().and().logout()
//				.logoutUrl("/logout").logoutSuccessUrl("/singers").and().csrf().disable();
		
		http   //droit à sous adresse de /newuser/ et url qui commence par /delete-user-*
		.authorizeRequests()
		.antMatchers("/*").access("hasRole('USER')") 
		.and().formLogin()
		.usernameParameter("username").passwordParameter("password")
		.loginProcessingUrl("/login");
	}
	
	
	public String enCode(String myStr)  {
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
	String result = encoder.encode("myPassword");
	return result ;
	}
	
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//	return new BCryptPasswordEncoder();
//	}
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//	    return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}
//	
}
