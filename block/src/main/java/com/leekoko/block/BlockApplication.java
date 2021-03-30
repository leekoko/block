package com.leekoko.block;

import com.leekoko.block.service.IEdaBusnessTalentsCoverInfoDataService;
import feign.Feign;
import feign.Request;
import feign.Retryer;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@EnableScheduling
@SpringBootApplication
public class BlockApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlockApplication.class, args);
	}

	@Bean
	IEdaBusnessTalentsCoverInfoDataService feignTest(){
		return Feign.builder()
				.encoder(new JacksonEncoder())
				.decoder(new JacksonDecoder())
				.options(new Request.Options(2000, 3500))
				.retryer(new Retryer.Default(5000, 5000, 3))
				.target(IEdaBusnessTalentsCoverInfoDataService.class, "http://127.0.0.1:41156");
	}
}
