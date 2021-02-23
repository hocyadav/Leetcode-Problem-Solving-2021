package io.hari.problemsolving2021;

import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProblemSolving2021Application {

    public static void main(String[] args) {
        SpringApplication.run(ProblemSolving2021Application.class, args);
    }

    @Test
    public void foo() {
        System.out.println("ProblemSolving2021Application.foo");
    }

}
