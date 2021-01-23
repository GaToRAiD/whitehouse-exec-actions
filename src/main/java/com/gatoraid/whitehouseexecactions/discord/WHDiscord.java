package com.gatoraid.whitehouseexecactions.discord;

import com.gatoraid.whitehouseexecactions.WebScrappers.WebScraper;
import com.gatoraid.whitehouseexecactions.dao.BidenDAO;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.List;

public class WHDiscord {

//    WebScraper checkUpdates = new WebScraper();

    private static BidenDAO bidenDAO;

    @Autowired
    public WHDiscord(BidenDAO thewhiteHouseDAO){
        bidenDAO = thewhiteHouseDAO;
    }

//    public List<String> checkLatest() throws IOException {
//        checkUpdates.setWebURL("https://www.whitehouse.gov/presidential-actions/");
//        checkUpdates.getWebReturn();
//
//        return null;
//    }


}
