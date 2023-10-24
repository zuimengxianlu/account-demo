package world.zmxl.demo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
public class MainApplication {

    public static void main(String[] args){
        SpringApplication.run(MainApplication.class);
    }

}
