package ulas.hrmsDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import ulas.hrmsDemo.business.concretes.JobTitleManager;
import ulas.hrmsDemo.dataAccess.abstracts.JobTitleDao;
import ulas.hrmsDemo.entities.concretes.JobTitle;

@SpringBootApplication
@EnableSwagger2
public class HrmsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrmsDemoApplication.class, args);





	}
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("ulas.hrmsDemo"))
				.build();
	}

}
