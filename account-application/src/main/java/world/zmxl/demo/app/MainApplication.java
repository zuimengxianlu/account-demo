package world.zmxl.demo.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 类的介绍
 *
 * @author 醉梦仙露
 * @date 2023/10/24
 */
@SpringBootApplication(
        scanBasePackages = {
                "world.zmxl.demo.app",
                "world.zmxl.demo.domain",
                "world.zmxl.demo.infrastructure",
                "world.zmxl.demo.trigger"
        }
)
@MapperScan(basePackages = "world.zmxl.demo.infrastructure.dao")
@EnableDiscoveryClient
public class MainApplication {

    public static void main(String[] args){
        SpringApplication.run(MainApplication.class, args);
    }

}
