package com.project.movementbody;

import com.project.movementbody.util.FoodCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class MovementbodyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovementbodyApplication.class, args);
    }

}
