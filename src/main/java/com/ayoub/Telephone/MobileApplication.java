package com.ayoub.Telephone;

import com.ayoub.Telephone.entities.Role;
import com.ayoub.Telephone.entities.User;
import com.ayoub.Telephone.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MobileApplication implements CommandLineRunner {

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(MobileApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Password Encoded BCRYPT :");
        System.out.println(passwordEncoder.encode("123"));

        
    }
/*
    void init_users() {
        // أضف الرولات
        userService.addRole(new Role(null, "ADMIN"));
        userService.addRole(new Role(null, "AGENT"));
        userService.addRole(new Role(null, "USER"));

        // أضف المستخدمين
        userService.saveUser(new User(null, "admin", "123", true, null));
        userService.saveUser(new User(null, "ayoub", "123", true, null));
        userService.saveUser(new User(null, "user1", "123", true, null));

        // أضف الرولات للمستخدمين
        userService.addRoleToUser("admin", "ADMIN");
        userService.addRoleToUser("ayoub", "AGENT");
        userService.addRoleToUser("ayoub", "USER");
        userService.addRoleToUser("user1", "USER");
        }*/

@Bean
public ModelMapper modelMapper()
{
return new ModelMapper();
}

}
