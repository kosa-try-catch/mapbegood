package com.kosa.mapbegood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication(
//		exclude = {
//				org.springframework.cloud.aws.autoconfigure.context.ContextInstanceDataAutoConfiguration.class,
//				org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration.class,
//				org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration.class
//		}
)
public class MapbegoodApplication {
 
	public static void main(String[] args) {
		SpringApplication.run(MapbegoodApplication.class, args);
	}

}