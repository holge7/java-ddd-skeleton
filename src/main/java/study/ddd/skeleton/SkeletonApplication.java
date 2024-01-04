package study.ddd.skeleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import study.ddd.skeleton.shared.infrastructure.bus.event.rabbitmq.RabbitMqDomainEventsConsumer;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SkeletonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkeletonApplication.class, args);
	}

}
