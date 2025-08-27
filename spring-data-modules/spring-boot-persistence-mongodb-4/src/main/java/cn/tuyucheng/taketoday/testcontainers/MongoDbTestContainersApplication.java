package cn.tuyucheng.taketoday.testcontainers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = { "cn.tuyucheng.taketoday" })
public class MongoDbTestContainersApplication {

    public static void main(String... args) {
        SpringApplication.run(MongoDbTestContainersApplication.class, args);
    }

}
