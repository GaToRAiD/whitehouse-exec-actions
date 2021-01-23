package com.gatoraid.whitehouseexecactions;

import com.gatoraid.whitehouseexecactions.WebScrappers.BidenScraper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import static java.lang.System.exit;

import java.io.IOException;

@SpringBootApplication
@EnableScheduling
public class WhitehouseExecActionsApplication implements CommandLineRunner {

    @Autowired
    private BidenScraper bidenScraper;

    public static void main(String[] args) throws IOException {
        SpringApplication app = new SpringApplication(WhitehouseExecActionsApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        bidenScraper.setUrl();
        bidenScraper.setClassname();
        bidenScraper.getAllPages();

//        while (true){
//            bidenScraper.checkForUpdate();
//            Thread.sleep(4 * 60 * 60 * 1000);
//        }

    }
}
