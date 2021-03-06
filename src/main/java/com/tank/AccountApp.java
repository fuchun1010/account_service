package com.tank;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author tank198435163.com
 */
@MapperScan("com.tank.dao")
@SpringBootApplication
public class AccountApp {
  public static void main(String[] args) {
    SpringApplication.run(AccountApp.class);
  }
}
