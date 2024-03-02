package com.Spring.Security;	
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
		
		BCryptPasswordEncoder bcp = new BCryptPasswordEncoder();
		System.out.println(bcp.encode("try@123"));
		System.out.println(bcp.encode("try@321"));
		System.out.println(bcp.encode("try@412"));
	}
	
	//here we are not following that 1.2.3
	//this was only for understanding purpose.
	
	//1st iteration 
	//$2a$10$Yilxya7ruZl31Qh1CSvae.2URzEBuLtWIGAABS1LDM/4/WMaRH7Ym
	//$2a$10$nVydZr17We/KSrjGOesrSeuTdlHPEFFwy5KWlDYo9XHJrolugKC8.
	//$2a$10$vygfKV0GkMbpWIu./Yvc7.C8YiMp.hNf2q5ZWhbFJEHoJMLFAHlaG
	
	//here 2a represent bcrypt algo
	//10 strength 
	//then we have salt 
	// folowed by hash value 
	
	//total length after Encryption  - 60
	
	
	
	//2nd iteration 
	//$2a$10$cxzHRcgspgrzJ2Y/IjBQdeQ8QJo0pPTiMB6u3/ojP20eskszJBo4a
	//$2a$10$AwNwWqEiQD2DLlAZrPbBaerQyNOJyjDOZ2XuHlzIRKF/WK3zH7mXW
	//$2a$10$JWHSWHrKEG6DGUVALcFcHeofGP8XINRmcc8VO47IsgM/ygPTqPCPmv

}
