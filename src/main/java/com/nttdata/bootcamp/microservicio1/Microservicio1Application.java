package com.nttdata.bootcamp.microservicio1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * [Description]. <br/>
 * <b>Class</b>: {@link Microservicio1Application}<br/>
 * <b>Copyright</b>: &Copy; 2022 NTT DATA SAC. <br/>
 * <b>Company</b>: NTT DATA SAC. <br/>
 *
 * @author Yennyffer Lizana <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>{USERNAME}. (acronym) From (EVE)</li>
 * </ul>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>ene. 06, 2022 (acronym) Creation class.</li>
 * </ul>
 * @version 1.0
 */
//@EnableEurekaClient
@SpringBootApplication
@EnableReactiveMongoRepositories
public class Microservicio1Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservicio1Application.class, args);
	}

}
