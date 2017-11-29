package ua.chup;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ua.chup.model.CustomUser;
import ua.chup.model.UserRole;
import ua.chup.service.UserService;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
    @Bean
    public CommandLineRunner demo(final UserService userService) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                userService.deleteAll();
                userService.addUser(new CustomUser("admin", "5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8", UserRole.ADMIN));
                userService.addUser(new CustomUser("user", "5baa61e4c9b93f3f0682250b6cf8331b7ee68fd8", UserRole.USER));
            }
        };
    }

   /* @Bean
    public CommandLineRunner demo(final UtilService utilService) {
        return new CommandLineRunner(){

            @Override
            public void run(String... strings) throws Exception {
                Util util;
                utilService.deleteAll();
                for (int i = 0; i < 13; i++) {
                    util = new Util("Nmae"+i,"jhh"+i,"example"+i,"path"+i);
                    utilService.addUtil(util);
                }



            }
        };
    }
    */

 }