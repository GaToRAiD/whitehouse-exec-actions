package com.gatoraid.whitehouseexecactions.WebScrappers;

import com.gatoraid.whitehouseexecactions.dao.WhiteHouseDAO;
import com.gatoraid.whitehouseexecactions.entity.WhiteHouse;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.*;

public class WhiteHouseScraper {
    private String baseURL = "https://www.whitehouse.gov/presidential-actions/page/";
    private int page = 1;


    private WhiteHouseDAO whiteHouseDAO;

    @Autowired
    public WhiteHouseScraper(WhiteHouseDAO whDAO){
        whiteHouseDAO = whDAO;
    }


    public void saveArticle(WhiteHouse theArticle){
        if(whiteHouseDAO.GetItem(theArticle).size() == 0){
            whiteHouseDAO.saveItem(theArticle);
            System.out.println("Item Saved");
        }
    }

    public void getAllPages() throws IOException {
        while(true){
            String webpage = baseURL + page;
            WebScraper whiteHouseScraper = new WebScraper();
            whiteHouseScraper.setWebURL(webpage);
            whiteHouseScraper.getWebReturn();
            Element pageStatus = whiteHouseScraper.getWebReturn();
            if (pageStatus == null){
                System.out.println("No More Pages To Index");
                break;
            } else {
                HashMap pageArticles = whiteHouseScraper.getElements();
                Iterator iterator = pageArticles.entrySet().iterator();
                while(iterator.hasNext()){
                    Map.Entry currentArticle = (Map.Entry)iterator.next();
                    try {
                        //System.out.println(currentArticle.getValue());
                        //System.out.println(currentArticle.getKey());
                        WhiteHouse whiteHouse = new WhiteHouse();
                        whiteHouse.setLink((String) currentArticle.getValue());
                        whiteHouse.setText((String) currentArticle.getKey());
                        saveArticle(whiteHouse);
                    } catch(Exception exc) {
                        System.out.println(exc);
                    }
                }
            }
            pageStatus.empty();
            page++;
        }
    }

}
