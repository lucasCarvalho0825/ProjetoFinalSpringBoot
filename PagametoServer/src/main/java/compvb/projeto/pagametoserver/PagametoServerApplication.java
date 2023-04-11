package compvb.projeto.pagametoserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class PagametoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PagametoServerApplication.class, args);
    }

}
