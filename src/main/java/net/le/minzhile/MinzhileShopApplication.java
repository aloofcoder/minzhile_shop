package net.le.minzhile;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("net.le.minzhile.**.dao")
public class MinzhileShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(MinzhileShopApplication.class, args);
    }
}
