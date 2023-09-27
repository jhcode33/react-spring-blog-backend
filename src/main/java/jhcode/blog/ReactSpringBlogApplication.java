package jhcode.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //BaseTimeEntity
@SpringBootApplication
public class ReactSpringBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactSpringBlogApplication.class, args);
    }

}
