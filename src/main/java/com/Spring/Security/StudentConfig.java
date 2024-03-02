package com.Spring.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class StudentConfig extends WebSecurityConfigurerAdapter{

//	@Autowired
//	PasswordEncoder passordEncoder;
	
	//In above we tried to autowire passowrdEncoder instead creating bean of it using @Bean and 
	//encoded the password in inMemoryAuthentication but that did'nt work.
	//that's bcoz PasswordEncoder is a Interface and autowiring it won't create bean of it.
	
	//Instead bean will be created of the class which is implementing it's method.
	//Here NoOpPasswordEncoder, BCryptPasswordEncoder and other classes implementing the methods
	//of PasswordEncoder Interface, so that's why we need to create bean of PasswordEncoder
	//using @Bean and specify that which class we want to inject. 
	
	//responsibilty for StudentConfig class is to provide authentication.
	String DEVELOPER_AUTHORITY = "developer";
    String DEVOPS_AUTHORITY = "devops";
    
    //AuthenticationManagerBuilder - provides different methods that we can apply for 
    //								 authentication.
    
    //various types of authentication - 
    //1. In memory auth - No db is involved. We don't save anything in db like user and pwd.
    //All the details persist till the application is running.
    
    //2. db way of auth - we are saving details of the user in db.
    
    //3. ldap auth - it stores or validates user based on hierarchy. 
	
    //we are trying to design the ant matcher or adding filter for api 
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    // here we are going to have user and password details of the user 
    //Giving Authentication to user.
    	
    	auth.inMemoryAuthentication()
    		.withUser("Arun")
    		.password("123")
    		//.password(passordEncoder.encode("123"))
    		.authorities(DEVELOPER_AUTHORITY)
    		.and()
    		.withUser("khusboo")
    		.password("try@321")
    		//.password(passordEncoder.encode("try@321"))
  //.password("$2a$10$nVydZr17We/KSrjGOesrSeuTdlHPEFFwy5KWlDYo9XHJrolugKC8.") Not sure if we can use like this also. 
    		.authorities(DEVOPS_AUTHORITY)
    		.and()
    		.withUser("farooq")
    		.password("try@412")
    		//.password(passordEncoder.encode("try@412"))
    		.authorities(DEVELOPER_AUTHORITY,DEVOPS_AUTHORITY);		
    }

  //when ever u write an ant matcher it should be from most restrictive to least restrictive 
    protected void configure(HttpSecurity http) throws Exception {
    	// Giving Authorization to user.
    	http.httpBasic()
    	.and()
    	.authorizeHttpRequests()	
    	.antMatchers("/devops/**").hasAnyAuthority(DEVOPS_AUTHORITY)
    	//If instead of above, we use below than also it will work fine.
    	//.antMatchers(HttpMethod.GET,"/devops/**").hasAnyAuthority(DEVOPS_AUTHORITY)
    	//In the above antMatcher if we are not specifying it as GET or POST, then it will
    	//work for both of them.
    	
    	//.antMatchers(HttpMethod.POST, "/developer/**").hasAnyAuthority(DEVOPS_AUTHORITY)
    	.antMatchers(HttpMethod.POST, "/sre/**").hasAnyAuthority(DEVELOPER_AUTHORITY)
    	.antMatchers("/developer/**").hasAnyAuthority(DEVELOPER_AUTHORITY)// developer will have access to both get and post
    	
    	.antMatchers("/**").permitAll() //This permits all the api's other than assigned
    	//authorization to be accessed without authorization.
    	//If we don't provide authorization for accessing some API's and don't use 
    	//above method permitAll(), then we will get error in accessing those API's.			
    	.and().formLogin();
    }
    
    //In above POST methods a'int working.
    
    //In Spring Security, passwords should be encoded before storing them in the database,
    //and when users attempt to log in, the entered password is encoded and compared with 
    //the encoded password stored in the database.
    //Below method does the same.	

//If we don't use below NoOpPasswordEncoder PasswordEncoder, then it will give error.    
    	 @Bean
    	 public PasswordEncoder getPE() {
    		return NoOpPasswordEncoder.getInstance();
    	 } 
//	 
    
//If we use below and don't use this in configure method above, then it will give error.    
//	 @Bean
//	 public PasswordEncoder getPE() {
//		return new BCryptPasswordEncoder();
//	 } 
//We don't have any decode method.	 
}