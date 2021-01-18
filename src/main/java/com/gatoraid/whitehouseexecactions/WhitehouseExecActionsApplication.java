package com.gatoraid.whitehouseexecactions;

import com.gatoraid.whitehouseexecactions.WebScrappers.WhiteHouseScraper;
import com.gatoraid.whitehouseexecactions.dao.WhiteHouseDAO;
import com.gatoraid.whitehouseexecactions.dao.WhiteHouseDAOImpl;
import com.gatoraid.whitehouseexecactions.entity.WhiteHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;

@SpringBootApplication
public class WhitehouseExecActionsApplication {

    private static WhiteHouseDAO whiteHouseDAO;

    @Autowired
    public WhitehouseExecActionsApplication(WhiteHouseDAO thewhiteHouseDAO){
        whiteHouseDAO = thewhiteHouseDAO;
    }

    public static void main(String[] args) throws IOException {
          SpringApplication.run(WhitehouseExecActionsApplication.class, args);
        System.out.println("Calling WhiteHouseScraper");
        WhiteHouseScraper whs = new WhiteHouseScraper(whiteHouseDAO);
        whs.getAllPages();
    }

}
