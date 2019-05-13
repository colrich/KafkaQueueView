package io.pivotal.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(exclude = {
	org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
	org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration.class})
@ComponentScan(basePackageClasses = StoreConfiguration.class)
public class KafkaQueueViewApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaQueueViewApplication.class, args);
	}

	


}
