package com.example.myreactivedemo;

import com.example.myreactivedemo.dto.Results;
import com.example.myreactivedemo.dto.Root;
import com.example.myreactivedemo.dto.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@SpringBootApplication
@EnableScheduling
public class MyReactiveDemoApplication {


	@Bean
	WebClient http (WebClient.Builder builder) {
		return builder.build();
	}
	public static void main(String[] args) {
		SpringApplication.run(MyReactiveDemoApplication.class, args);
	}

}


@RestController
@RequiredArgsConstructor
class GetQuote{
	private final Stock stock;
	private final ScheduledFixedRateExample scheduledFixedRateExample;

	@GetMapping("/get")
	Flux<Root> get() throws InterruptedException {
		scheduledFixedRateExample.scheduleTaskUsingCronExpression();
		return this.stock.getStocks();
	}
}

@Component
@RequiredArgsConstructor
@EnableAsync
class ScheduledFixedRateExample {
//	@Async
//	@Scheduled(fixedRate = 10)
//	public void scheduleFixedRateTaskAsync() throws InterruptedException {
//		System.out.println(
//				"Fixed rate task async - " + System.currentTimeMillis() / 10);
//		Thread.sleep(2);
//	}

//	@Scheduled(cron = "* * * * * *")
	public void scheduleTaskUsingCronExpression() {

		long now = System.currentTimeMillis() / 1000;
		System.out.println(
				"schedule tasks using cron jobs - " + now);
	}

}