package com.costin.erm;

import com.costin.erm.entity.Car;
import com.costin.erm.entity.CarProfile;
import com.costin.erm.entity.Role;
import com.costin.erm.entity.User;
import com.costin.erm.repository.RoleRepository;
import com.costin.erm.service.CarService;
import com.costin.erm.service.UserService;
import com.costin.erm.usermodel.RegisterUserModel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ErmApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErmApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(RoleRepository roleRepository, UserService userService) {
//		return args -> {
//			roleRepository.save(new Role("ROLE_EMPLOYEE"));
//			roleRepository.save(new Role("ROLE_BOSS"));
//
//			RegisterUserModel registerUserModel = new RegisterUserModel(
//					"costin",
//					"05z08l2001anu",
//					"Costin",
//					"Cinjau",
//					"cinjau.costin@yahoo.com"
//			);
//
//			userService.save(registerUserModel);
//
//			userService.addRoleForUser(registerUserModel.getUsername(), "ROLE_BOSS");
//
//		};
//	}

}
