package com.Spring.Security;		
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
//By default	
//Username - user
//pwd - displayed in console	

//we need to tell spring to unsecure api.	
//when we add Security as dependency, all the API's are Secured.	
	
//		@GetMapping("/developer")
//		public String getDeveloper() {
		//when user hits this api, the username and pwd that he has entered will get displayed.
//			Authentication auth= SecurityContextHolder.getContext().getAuthentication();
//			System.out.println(auth);
//			User user=(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//			System.out.println(user.getUsername()+"username     password"+user.getPassword());
//			return "My name is developer";
//		}	

		@GetMapping("/tester")
		public String getTester() {
			return "My name is tester";
		}	

		@GetMapping("/devops")
		public String getDevops() {
			return "My name is devops";
		}
		
		@PostMapping("/sre")
		public String sre() {
			return "Hi sre !!!";
		}
		
		@GetMapping("/developer")
		public String developer() {
			return "Hi Developer !!";
		}
		
		@PostMapping("/developer")
		public String developerDetails() {
			return "Hi Developer !!";
		}

//cookie - small info from backend stored in the browser to support consecutive Request.
//It is somewhat a unique Id that gets assigned when a user makes log-in and it gets changed
//when a user logs out.
	
//The default timeout session in spring security is 15 Minutes.	
}