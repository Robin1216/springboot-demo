package com.robin.springboot.demo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        closeBanner();
        SpringApplication.run(Application.class, args);
    }

    // 关闭 banner
    private static void closeBanner(){
        SpringApplication app = new SpringApplication(Application.class);
         /* Banner.Mode.OFF:关闭;
         * Banner.Mode.CONSOLE:控制台输出，默认方式;
         * Banner.Mode.LOG:日志输出方式;
         */
        app.setBannerMode(Banner.Mode.CONSOLE);

    }
}
