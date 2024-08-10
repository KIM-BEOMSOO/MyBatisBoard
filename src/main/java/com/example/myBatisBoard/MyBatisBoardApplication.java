package com.example.myBatisBoard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.myBatisBoard.repository")
public class MyBatisBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyBatisBoardApplication.class, args);
	}

}
