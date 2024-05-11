package com.oussema.accessoires;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.oussema.accessoires.entities.Accessoire;
import com.oussema.accessoires.entities.Role;
import com.oussema.accessoires.entities.User;
import com.oussema.accessoires.service.AccessoireService;
import com.oussema.accessoires.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class AccessoiresInformatiqueApplication implements CommandLineRunner {

	@Autowired
	AccessoireService accessoireService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserService userService;

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(AccessoiresInformatiqueApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Accessoire.class);

		System.out.println("Password Encoded BCRYPT :******************** ");
		System.out.println(passwordEncoder.encode("123"));

		/*
		 * accessoireService.saveAccessoire(new Accessoire("Souris Redragon M2", 160.0,
		 * new Date())); accessoireService.saveAccessoire(new
		 * Accessoire("Clavier Ryzer Viper", 200.0, new Date()));
		 * accessoireService.saveAccessoire(new Accessoire("Ecran Benq Zowie", 500.0,
		 * new Date())); accessoireService.saveAccessoire(new
		 * Accessoire("Casque HyperX Cloud II", 350.0, new Date()));
		 */

	}

	/*/@PostConstruct
	void init_users() {

		// ajouter les rôles
		userService.addRole(new Role(null, "ADMIN"));
		userService.addRole(new Role(null, "AGENT"));
		userService.addRole(new Role(null, "USER"));

		// ajouter les users
		userService.saveUser(new User(null, "admin", "123", true, null));
		userService.saveUser(new User(null, "oussema", "123", true, null));
		userService.saveUser(new User(null, "user", "123", true, null));

		// ajouter les rôles aux users
		userService.addRoleToUser("admin", "ADMIN");
		userService.addRoleToUser("oussema", "USER");
		userService.addRoleToUser("oussema", "AGENT");
		userService.addRoleToUser("user", "USER");
	}*/

}
