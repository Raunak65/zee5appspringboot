package com.zee.zee5app;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.exception.IdInvalidLengthException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.service.UserService;

public class UserRepoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext applicationContext = 
				SpringApplication.run(MoviesRepoTest.class, args);
		
		UserService userservice = applicationContext.getBean(UserService.class);
		Register reg = new Register(new BigDecimal("7894561230"),"register@10","Raunak","Chandak","register10@mail.com","pass@afes");
		userservice.addUser(reg);
		try {
			Register[] registers = userservice.getAllUsers();
			for(int i = 0 ; i < registers.length;i++) {
				System.out.println(registers[i]);
			}
			Optional<List<Register>> optional = userservice.getAllUsersDetails();
			if (optional.isPresent()){
				optional.get().forEach(e->System.out.println(e));
			}
			else {
				System.out.println("No users found.");
			}
			String res = userservice.deleteUserById("register@10");
			System.out.println(res);
		} catch (InvalidNameException | IdInvalidLengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidEmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		applicationContext.close();

	}

}
