package springboot.test_springboot;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App {
	private static final Logger log=Logger.getLogger(App.class);
    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
        log.info("ceshi");
    }

}
